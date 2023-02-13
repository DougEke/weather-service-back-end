package weatherservice.weatherservicebackend.entity;

import javax.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeatherData {

    private String name;
    private Double windSpeed;
    private Double windDirection;
    private Double currentTemp;
    private Double feelsLikeTemp;
    private Double maxTemp;
    private Double minTemp;
    private Integer pressure;
    private Integer humidity;
    private Integer visibility;
    
}
