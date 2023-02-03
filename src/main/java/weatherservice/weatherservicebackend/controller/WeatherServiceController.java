package weatherservice.weatherservicebackend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherServiceController {
    String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=${form.city}&appid=${apiKey}";

    /**
     * Gets the current weather and adds to db
     */
    @GetMapping()
    public void getCurrentWeather() {
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
