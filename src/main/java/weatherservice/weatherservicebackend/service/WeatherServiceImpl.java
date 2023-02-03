package weatherservice.weatherservicebackend.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import weatherservice.weatherservicebackend.entity.WeatherData;
import weatherservice.weatherservicebackend.interfaces.WeatherService;
import weatherservice.weatherservicebackend.repository.WeatherRepository;
import weatherservice.weatherservicebackend.weather_service_exceptions.WeatherServiceException;

public class WeatherServiceImpl implements WeatherService {

    final private WeatherRepository weatherRepository;

    public WeatherServiceImpl(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
    }

    /**
     * Gets the current weather from the apiweather location.
     * Takes the city and makes an api request for the current weather for that
     * city, adds to the db
     * and then returns the data back to the front end to display the data.
     */
    @Override
    public String getCurrentWeatherFromOpenWeatherApi(String city) {        
        WeatherData weatherData = null;

        try{
            // Need to make a request for current weather data from the openweather api...
            var openweatherapiUrl = new URL("${OPEN_WEATHER_API}" + city + "appid=" + "${OPEN_WEATHER_API_KEY}");

            HttpURLConnection connection = (HttpURLConnection) openweatherapiUrl.openConnection();

            connection.setRequestProperty("accept", "application/json");

            InputStream response = connection.getInputStream();

            System.out.println("DEBUG - Received data: " + response.toString());

            // Need to map the received data into the WeatherData object for storing in the db...
            weatherData = (WeatherData) mapWeatherData(response);

            // Save the data to the database....
            saveWeatherData(weatherData);
        }
        catch(IOException ex){
            throw new WeatherServiceException("Error collecting the data", ex);
        }

        try{
            var jsonString = convertDataToJsonString(weatherData);
            return jsonString;
        }
        catch(JsonProcessingException ex){
            return null;
        }
        
    }

    private WeatherData mapWeatherData(InputStream response) {
        var weatherData = new WeatherData();

        return weatherData;

        
    }

    private String convertDataToJsonString(WeatherData weatherData) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        var jsonString = mapper.writeValueAsString(weatherData);

        return jsonString;
    }

    /**
     * Saves the weather data to the h2 db..
     */
    @Override
    public void saveWeatherData(WeatherData weatherData) {
        weatherRepository.save(weatherData);

    }

}
