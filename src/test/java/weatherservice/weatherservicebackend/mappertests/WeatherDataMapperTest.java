package weatherservice.weatherservicebackend.mappertests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.json.JSONException;
import org.json.JSONObject;
import weatherservice.weatherservicebackend.entity.WeatherData;
import weatherservice.weatherservicebackend.mapper.WeatherDataMapper;

public class WeatherDataMapperTest {

    private WeatherDataMapper underTest;

    @Test
    public void shouldConvertWeatherDataToJsonString() throws IOException {
        underTest = new WeatherDataMapper();
        var response = underTest.weatherDataToJsonMapper(getWeatherData());

        assertNotNull(response);
    }

    @Test
    void jsonToWeatherDataMapper() throws JSONException {
        underTest = new WeatherDataMapper();

        var weatherData = underTest.jsonToWeatherDataMapper( new JSONObject(getJsonFile()));
        
        assertEquals("Harlow", weatherData.getPlaceName());
        assertEquals("3.09", weatherData.getWindSpeed().toString());
        assertEquals("150.0", weatherData.getWindDirection().toString());
        assertEquals("6.0", weatherData.getCurrentTemp().toString());
        assertEquals("3.0", weatherData.getFeelsLikeTemp().toString());
        assertEquals("7.0", weatherData.getMaxTemp().toString());
        assertEquals("4.0", weatherData.getMinTemp().toString());
        assertEquals("1034", weatherData.getPressure().toString());
        assertEquals("81", weatherData.getHumidity().toString());
        assertEquals("8000", weatherData.getVisibility().toString());
    }

    private WeatherData getWeatherData() {
        return WeatherData.builder()
                .currentTemp(100.0)
                .visibility(5000)
                .humidity(50)
                .pressure(75)
                .feelsLikeTemp(2599.0)
                .minTemp(25.0)
                .maxTemp(50.5)
                .windDirection(275.75)
                .build();
    }

    private String getJsonFile() {
        return "{" +
                    "\"coord\": " +
                    "{" +
                        "\"lon\": 0.1116," +
                        "\"lat\": 51.7766" +
                    "}," +
                    "\"weather\": " +
                    "[" +
                        "{\"id\": 801," +
                        "\"main\": \"Clouds\"" +
                        ",\"description\": \"few clouds\"" +
                        ",\"icon\": \"02d\"}" +
                    "]," +
                    "\"base\": \"stations\"," +
                    "\"main\": " +
                    "{" +
                        "\"temp\": 279.44," +
                        "\"feels_like\": 277.14," +
                        "\"temp_min\": 277.71," +
                        "\"temp_max\": 280.93," +
                        "\"pressure\": 1034," +
                        "\"humidity\": 81" +
                    "}," +
                    "\"visibility\": 8000," +
                    "\"wind\": " +
                    "{" +
                        "\"speed\": 3.09," +
                        "\"deg\": 150" +
                    "}," +
                    "\"clouds\": " +
                    "{" +
                        "\"all\": 20" +
                    "}," +
                    "\"dt\": 1676280373," +
                    "\"sys\": " +
                    "{" +
                        "\"type\": 2," +
                        "\"id\": 2079289," +
                        "\"country\": \"GB\"," +
                        "\"sunrise\": 1676272732," +
                        "\"sunset\": 1676308133" +
                    "}," +
                    "\"timezone\": 0," +
                    "\"id\": 2647461," +
                    "\"name\": \"Harlow\"," +
                    "\"cod\": 200" +
                "}";
    }
    
}
