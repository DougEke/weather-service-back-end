package weatherservice.weatherservicebackend.mapper;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import weatherservice.weatherservicebackend.entity.WeatherData;

@Component
public class WeatherDataMapper {    
    public WeatherData jsonToWeatherDataMapper(JSONObject obj) {
        var data = new WeatherData();

        // Gets the name
        data.setName(obj.get("name").toString());
        System.out.println("Name: " + data.getName());

        // Get the wind data
        data.setWindSpeed(Double.parseDouble(((JSONObject)obj.get("wind")).get("speed").toString()));
        data.setWindDirection(Double.parseDouble(((JSONObject)obj.get("wind")).get("deg").toString()));

        // Get the temperature
        data.setCurrentTemp(Math.floor(Double.parseDouble(((JSONObject) obj.get("main")).get("temp").toString()) - 273.15));
        data.setFeelsLikeTemp(Math.floor(Double.parseDouble(((JSONObject) obj.get("main")).get("feels_like").toString()) - 273.15));
        data.setMaxTemp(Math.floor(Double.parseDouble(((JSONObject) obj.get("main")).get("temp_max").toString()) - 273.15));
        data.setMinTemp(Math.floor(Double.parseDouble(((JSONObject) obj.get("main")).get("temp_min").toString()) - 273.15));

        // Get visibility, pressure and humidity..
        data.setVisibility(Integer.parseInt((obj.get("visibility")).toString()));
        data.setPressure(Integer.parseInt(((JSONObject) obj.get("main")).get("pressure").toString()));
        data.setHumidity(Integer.parseInt(((JSONObject) obj.get("main")).get("humidity").toString()));

        return data;
    }

    public String  weatherDataToJsonMapper(WeatherData data) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        String jsonString = mapper.writeValueAsString(data);

        return jsonString;
    }
    
}
