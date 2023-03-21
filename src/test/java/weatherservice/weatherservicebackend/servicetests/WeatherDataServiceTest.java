package weatherservice.weatherservicebackend.servicetests;

import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Description;

import weatherservice.weatherservicebackend.entity.WeatherData;
import weatherservice.weatherservicebackend.interfaces.WeatherDataService;
import weatherservice.weatherservicebackend.repository.WeatherDataRepository;

@SpringBootTest
public class WeatherDataServiceTest {
    
    @Autowired
    private WeatherDataService underTest;

    @MockBean
    private WeatherDataRepository repository;  
    
    private List<WeatherData> weatherDataList;

    @BeforeEach
    public void setUp() {
        var placeName = "London";
        weatherDataList = new ArrayList<WeatherData>();
        weatherDataList.add(getWeatherData(placeName, LocalDateTime.now()));

        when(repository.findByPlaceName(placeName)).thenReturn(weatherDataList);

    }

    @AfterEach
    public void tearDown() {
        weatherDataList.clear();
    }

    @Test
    @Description("Should return a single weather data record when only 1 exists") 
    public void shouldFindWeatherDataForGivenPlaceName() {

        var placeName = "London";

        var data = underTest.findWeatherDataByPlaceName(placeName);

        assertEquals(1, data.size());
        assertEquals(placeName, data.get(0).getPlaceName());

    }
    
    @Test
    @Description("Should return a list containing 2 weather data records for London")
    public void shouldReturnAListContaining2WeatherDataRecordsForGivenPlaceName() { 

        var placeName = "London";

        weatherDataList.add(getWeatherData(placeName,LocalDateTime.now()));

        var data = underTest.findWeatherDataByPlaceName(placeName);

        assertEquals(2, data.size());
        assertEquals("London", data.get(0).getPlaceName());
        assertEquals("London", data.get(1).getPlaceName());

    }

    private WeatherData getWeatherData(String placeName, LocalDateTime localDateTime) {

        return WeatherData.builder()
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
