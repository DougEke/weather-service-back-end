package weatherservice.weatherservicebackend.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WeatherData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long weatherDataId;

    private String placeName;
    private Double windSpeed;
    private Double windDirection;
    private Double currentTemp;
    private Double feelsLikeTemp;
    private Double maxTemp;
    private Double minTemp;
    private Integer pressure;
    private Integer humidity;
    private Integer visibility;
    private LocalDateTime weatherRecordedAtDateTime;
}
