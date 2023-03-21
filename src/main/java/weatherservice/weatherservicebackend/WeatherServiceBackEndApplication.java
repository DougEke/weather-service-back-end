package weatherservice.weatherservicebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WeatherServiceBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceBackEndApplication.class, args);

		System.out.println("Starting the WeatherServiceBackEndApplication....");
	}

}
