package weatherservice.weatherservicebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeatherServiceBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceBackEndApplication.class, args);

		System.out.println("Starting the WeatherServiceBackEndApplication....");
	}

}
