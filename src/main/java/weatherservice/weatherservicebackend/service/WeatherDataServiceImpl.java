package weatherservice.weatherservicebackend.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Service;
import weatherservice.weatherservicebackend.entity.WeatherData;
import weatherservice.weatherservicebackend.interfaces.WeatherDataService;
import weatherservice.weatherservicebackend.weather_service_exceptions.WeatherServiceException;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {    

    /**
     * Gets the current weather from the apiweather location.
     * Takes the city and makes an api request for the current weather for that
     * city, adds to the db
     * and then returns the data back to the front end to display the data.
     */
    @Override
    public WeatherData getCurrentWeatherFromOpenWeatherApi(String city) {        
        WeatherData weatherData = null;

        try{
            // Need to make a request for current weather data from the openweather api...
            var openweatherapiUrl = new URL("${OPEN_WEATHER_API}" + city + "appid=" + "${OPEN_WEATHER_API_KEY}");

            var connection = (HttpURLConnection) openweatherapiUrl.openConnection();

            connection.setRequestMethod("GET");

            StringBuilder content;

            try (
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(connection.getInputStream()))) {
                String line;

                content = new StringBuilder();

                while((line = in.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }

            System.out.println("DEBUG: content: " + content);

            return weatherData;
        }
        catch(IOException ex){
            throw new WeatherServiceException("Error collecting the data", ex);
        }        
    }
}
