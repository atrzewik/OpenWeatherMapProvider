package trzewik.com.weatherprovider.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import trzewik.com.weatherprovider.model.forecast.City;
import trzewik.com.weatherprovider.model.forecast.ForecastItem;

import java.math.BigDecimal;
import java.util.List;

public class ResponseWeatherForecast {

    private String cod;
    @JsonProperty("list")
    private List<ForecastItem> forecastItems;
    private City city;
    private BigDecimal message;
    private Integer cnt;

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public List<ForecastItem> getForecastItems() {
        return forecastItems;
    }

    public void setForecastItems(List<ForecastItem> forecastItems) {
        this.forecastItems = forecastItems;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public BigDecimal getMessage() {
        return message;
    }

    public void setMessage(BigDecimal message) {
        this.message = message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }
}
