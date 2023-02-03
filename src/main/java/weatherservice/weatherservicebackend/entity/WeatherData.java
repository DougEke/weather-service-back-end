package weatherservice.weatherservicebackend.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class WeatherData {
    private String city;
    private Integer windSpeed;
    private Integer maxTemp;
    private Integer minTemp;
    private Integer feelsLikeTemp;
    private Integer windDirection;
    private LocalDateTime sunriseTime;
    private LocalDateTime sunsetTime;
    private LocalDateTime currentTime;
    
}
