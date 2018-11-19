package trzewik.com.weather;

import com.mashape.unirest.http.exceptions.UnirestException;
import trzewik.com.model.ResponseWeather;
import trzewik.com.model.ResponseWeatherForecast;

import java.io.IOException;


public class WeatherProvider {

    private ResponseParser responseParser;

    public WeatherProvider(){
        this.responseParser = new ResponseParser();
    }

    public ResponseWeather getResponseWeather(String city) throws IllegalArgumentException{
        try {
            ApiClient apiClient = new ApiClient(DataProvider.dailyUrl, DataProvider.apiKey);
            ResponseWeather responseWeather = this.responseParser.parseResponseWeather(apiClient.getResponseBody(city));
            responseWeather.getMain().getTemp();
            return responseWeather;
        }
        catch (UnirestException | IOException | NullPointerException e){
            throw new IllegalArgumentException();
        }
    }

    public ResponseWeatherForecast getResponseWeatherForecast(String city) throws IllegalArgumentException{
        try {
            ApiClient apiClient = new ApiClient(DataProvider.forecastUrl, DataProvider.apiKey);
            return this.responseParser.parseResponseWeatherForecast(apiClient.getResponseBody(city));
        }
        catch (UnirestException | IOException e){
            throw new IllegalArgumentException();
        }
    }
}