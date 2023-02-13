package weatherservice.weatherservicebackend.interfaces;

import weatherservice.weatherservicebackend.entity.WeatherData;

public interface WeatherDataService {
    public WeatherData getCurrentWeatherFromOpenWeatherApi(String city);
}
