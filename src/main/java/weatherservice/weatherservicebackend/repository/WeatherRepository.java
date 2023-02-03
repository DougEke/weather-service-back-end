package weatherservice.weatherservicebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import weatherservice.weatherservicebackend.entity.WeatherData;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherData, Integer> {
    
}
