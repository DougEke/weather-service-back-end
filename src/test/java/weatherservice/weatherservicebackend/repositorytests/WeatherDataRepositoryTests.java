package weatherservice.weatherservicebackend.repositorytests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.context.annotation.Description;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.jupiter.api.AfterEach;
import weatherservice.weatherservicebackend.entity.WeatherData;
import weatherservice.weatherservicebackend.repository.WeatherDataRepository;

@DataJpaTest
@TestInstance(Lifecycle.PER_CLASS)
@Transactional
public class WeatherDataRepositoryTests {

    @Autowired
    private WeatherDataRepository underTest;

    @Autowired
    private TestEntityManager entityManager;

    @AfterEach
    public void tearDown() {
        entityManager.flush();
    }

    @Test
    @Description("Should retrieve the weather data for a given name when only 1 exists")
    public void shouldFindWeatherDataForGivenPlaceName() {
        var placeName = "London";
        var weatherRecordedAtDateTime = LocalDateTime.now();
        
        entityManager.persist(getWeatherData(placeName, weatherRecordedAtDateTime)); 

        var data = (List<WeatherData>) underTest.findByPlaceName(placeName);

        assertEquals(1, data.size());
        assertEquals(placeName, data.get(0).getPlaceName());
        assertEquals(weatherRecordedAtDateTime, data.get(0).getWeatherRecordedAtDateTime());

    }

    @Test
    @Description("Should return 2 weather data records for the stated place name when only 2 exists")
    public void shouldReturnAllWeatherDataForAGivenPlaceName() {
        
        var placeName = "London";
        var weatherRecordedAtDateTime = LocalDateTime.now();
        
        entityManager.persist(getWeatherData(placeName, weatherRecordedAtDateTime));         
        entityManager.persist(getWeatherData(placeName, weatherRecordedAtDateTime)); 

        var data = (List<WeatherData>) underTest.findByPlaceName(placeName);

        assertEquals(2, data.size());
    }

    @Test
    @Description("Should return 2 weather data records for the stated place name when only 2 exists, but with 3 records stored, one not being the given name")
    public void shouldReturnAllWeatherDataForAGivenPlaceNameWhenOtherPlaceNamesAreStored() {
        
        var placeName = "London";
        var weatherRecordedAtDateTime = LocalDateTime.now();
        
        entityManager.persist(getWeatherData(placeName, weatherRecordedAtDateTime));         
        entityManager.persist(getWeatherData(placeName, weatherRecordedAtDateTime));        
        entityManager.persist(getWeatherData("Lincoln", weatherRecordedAtDateTime)); 

        var data = (List<WeatherData>) underTest.findByPlaceName(placeName);

        assertEquals(2, data.size());
    }

    @Test
    @Description("Should retrieve all the weather data stored")
    public void shouldGetAllTheStoredWeatherData() {
        
        var placeName1 = "London";
        var placeName2 = "Lincoln";
        var placeName3 = "Harlow";
        var weatherRecordedAtDateTime = LocalDateTime.now();
        
        entityManager.persist(getWeatherData(placeName1, weatherRecordedAtDateTime));         
        entityManager.persist(getWeatherData(placeName2, weatherRecordedAtDateTime));        
        entityManager.persist(getWeatherData(placeName3, weatherRecordedAtDateTime)); 

        var data = (List<WeatherData>) underTest.findAll();

        assertEquals(3, data.size());
        assertEquals(placeName1, data.get(0).getPlaceName());
        assertEquals(placeName2, data.get(1).getPlaceName());
        assertEquals(placeName3, data.get(2).getPlaceName());

    }

    private WeatherData getWeatherData(String placeName, LocalDateTime localDateTime) {

        return  WeatherData.builder()
            .placeName(placeName)
            .currentTemp(100.0)
            .visibility(5000)
            .humidity(50)
            .pressure(75)
            .feelsLikeTemp(2599.0)
            .minTemp(25.0)
            .maxTemp(50.5)
            .windDirection(275.75)
            .weatherRecordedAtDateTime(localDateTime)
            .build();

    }
    
}
