package weatherservice.weatherservicebackend.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class WeatherDataServiceScheduler {

    @Scheduled(initialDelay = 5000L, fixedDelayString = "${schedulerRateInMilliSeconds}")
    private void handleEvent() {

        System.out.println("[" + java.time.LocalTime.now() + "] - Getting weather data from openweatherApi...");
    }
    
}
