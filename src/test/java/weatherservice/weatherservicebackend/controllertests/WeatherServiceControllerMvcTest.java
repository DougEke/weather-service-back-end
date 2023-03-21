package weatherservice.weatherservicebackend.controllertests;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import weatherservice.weatherservicebackend.controller.WeatherServiceController;
import weatherservice.weatherservicebackend.entity.WeatherData;
import weatherservice.weatherservicebackend.interfaces.WeatherDataService;

// @ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebMvcTest(WeatherServiceController.class)
public class WeatherServiceControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WeatherDataService mockWeatherDataService;

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldGetWeatherDataList() throws Exception {

        var placeName = "London";

        var expectedResponse = getWeatherData(placeName, LocalDateTime.now());

        when(mockWeatherDataService.getCurrentWeatherFromOpenWeatherApi(placeName)).thenReturn(expectedResponse);

        var response = mockMvc.perform(MockMvcRequestBuilders.get("weather/" + placeName)
                .header("consumer_id","test")
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andDo(print())
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();

        var actualResponse = mapper.readValue(response, WeatherData.class);

        assertNotNull(actualResponse);

    }

    

    private WeatherData getWeatherData(String placeName, LocalDateTime localDateTime) {
        
        return  WeatherData.builder()
                    .placeName(placeName)
                    .currentTemp(100.0)
                    .visibility(5000)
                    .humidity(50)
                    .pressure(75)
                    .feelsLikeTemp(2599.0)
                    .minTemp(25.0)
                    .maxTemp(50.5)
                    .windDirection(275.75)
                    .weatherRecordedAtDateTime(localDateTime)
                    .build();
    }
}
