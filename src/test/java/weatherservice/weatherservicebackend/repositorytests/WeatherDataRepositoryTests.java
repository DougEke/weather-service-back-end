package weatherservice.weatherservicebackend.repositorytests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;

import weatherservice.weatherservicebackend.entity.WeatherData;
import weatherservice.weatherservicebackend.repository.WeatherDataRepository;

@DataJpaTest
public class WeatherDataRepositoryTests {

    @Autowired
    private WeatherDataRepository underTest;

    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    public void setUp() {
        WeatherData weatherData = WeatherData.builder()
            .name("Test")
            .currentTemp(100.0)
            .visibility(5000)
            .humidity(50)
            .pressure(75)
            .feelsLikeTemp(2599.0)
            .minTemp(25.0)
            .maxTemp(50.5)
            .windDirection(275.75)
            .build();

            entityManager.persist(weatherData);
    }

    @AfterAll
    public void tearDown() {
        entityManager.clear();;
    }

    @Test
    public void shouldGetWeatherData() {
        WeatherData data = (WeatherData) underTest.findById(1).get();

        assertEquals("Test", data.getName());
    }
    
}
