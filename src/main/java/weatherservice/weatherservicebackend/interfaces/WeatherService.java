package weatherservice.weatherservicebackend.interfaces;

import weatherservice.weatherservicebackend.entity.WeatherData;

public interface WeatherService {
    public String getCurrentWeatherFromOpenWeatherApi(String city);

    public void saveWeatherData(WeatherData weatherData);
}
