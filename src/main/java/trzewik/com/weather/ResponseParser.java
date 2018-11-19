package trzewik.com.weather;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import trzewik.com.model.ResponseWeather;
import trzewik.com.model.ResponseWeatherForecast;

import java.io.IOException;

public class ResponseParser {

    private ObjectMapper mapper;

    public ResponseParser() {
        this.mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public ResponseWeather parseResponseWeather(String body) throws IOException {
        return mapper.readValue(body, ResponseWeather.class);
    }

    public ResponseWeatherForecast parseResponseWeatherForecast(String body) throws IOException {
        return mapper.readValue(body, ResponseWeatherForecast.class);
    }
}
