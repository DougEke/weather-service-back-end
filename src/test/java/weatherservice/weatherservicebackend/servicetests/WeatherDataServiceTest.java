package weatherservice.weatherservicebackend.servicetests;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;

import weatherservice.weatherservicebackend.entity.WeatherData;
import weatherservice.weatherservicebackend.interfaces.WeatherDataService;
import weatherservice.weatherservicebackend.repository.WeatherDataRepository;

@SpringBootTest
public class WeatherDataServiceTest {
    
    @Autowired
    private WeatherDataService underTest;

    @MockBean
    private WeatherDataRepository repository;

    @BeforeEach
    public void setUp() {
        WeatherData weatherData = WeatherData.builder()
            .name("Harlow")
            .currentTemp(100.0)
            .visibility(5000)
            .humidity(50)
            .pressure(75)
            .feelsLikeTemp(2599.0)
            .minTemp(25.0)
            .maxTemp(50.5)
            .windDirection(275.75)
            .build();   

    }

    
}
