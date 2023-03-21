package weatherservice.weatherservicebackend.interfaces;

import java.util.List;

import weatherservice.weatherservicebackend.entity.WeatherData;

public interface WeatherDataService {
    public WeatherData getCurrentWeatherFromOpenWeatherApi(String city);

    public List<WeatherData> findWeatherDataByPlaceName(String placeName);
}
