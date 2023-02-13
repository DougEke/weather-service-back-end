package weatherservice.weatherservicebackend.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import weatherservice.weatherservicebackend.mapper.WeatherDataMapper;

@Configuration
public class WeatherServiceConfig {

    @Bean
    public WeatherDataMapper getWeatherDataMapper() {
        return new WeatherDataMapper();
    }    
}
