package weatherservice.weatherservicebackend.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import weatherservice.weatherservicebackend.entity.WeatherData;
import weatherservice.weatherservicebackend.mapper.WeatherDataMapper;
import weatherservice.weatherservicebackend.repository.WeatherDataRepository;
import weatherservice.weatherservicebackend.service.WeatherDataServiceImpl;

@RestController
public class WeatherServiceController {

    @Autowired
    private WeatherDataServiceImpl weatherDataService;

    @Autowired
    private WeatherDataRepository weatherDataRepository;

    @Autowired
    private WeatherDataMapper weatherDataMapper;

    String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=${form.city}&appid=${apiKey}";

    /**
     * Gets the current weather and adds to db
     */
    @GetMapping("/weather/{city}")
    public WeatherData getCurrentWeatherData(@PathVariable("city") String city) {     
        
        var data = weatherDataMapper.jsonToWeatherDataMapper(
            new JSONObject(weatherDataService.getCurrentWeatherFromOpenWeatherApi(city))
            );

        weatherDataRepository.save(data);

        return data;

    }

    /**
     * Gets the 5 day forecast
     */
    @GetMapping("/forecast/{city}")
    public void getForecast() {
        
    // const apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=${city}&appid=${apiKey}";
    // }

    // Takes the city from the fe, calls the api then returns the data back an save to db.
    }
}
