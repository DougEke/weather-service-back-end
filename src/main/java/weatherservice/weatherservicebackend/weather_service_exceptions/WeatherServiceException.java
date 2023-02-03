package weatherservice.weatherservicebackend.weather_service_exceptions;

import java.time.LocalDateTime;

public class WeatherServiceException extends RuntimeException {

    public WeatherServiceException(String message) {
        super(message);

        System.out.println("[" + LocalDateTime.now() + "] - Weather service excpetion: " + message);
    }

    public WeatherServiceException(String message, Throwable cause) {
        super(message, cause);

        System.out.println("[" + LocalDateTime.now() + "] - Weather service excpetion: " + message + " - Reason: " + cause.toString());
    }
    
}
