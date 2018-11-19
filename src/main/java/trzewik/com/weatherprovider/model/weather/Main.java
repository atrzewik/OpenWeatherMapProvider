package trzewik.com.weatherprovider.model.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Main {
    private BigDecimal temp;
    private BigDecimal pressure;
    private Integer humidity;
    @JsonProperty("temp_min")
    private BigDecimal tempMin;
    @JsonProperty("temp_max")
    private BigDecimal tempMax;
    @JsonProperty("sea_level")
    private BigDecimal seaLevel;
    @JsonProperty("grnd_level")
    private BigDecimal groundLevel;
    @JsonProperty("temp_kf")
    private BigDecimal tempKf;

    public BigDecimal getSeaLevel() {
        return seaLevel;
    }

    public void setSeaLevel(BigDecimal seaLevel) {
        this.seaLevel = seaLevel;
    }

    public BigDecimal getGroundLevel() {
        return groundLevel;
    }

    public void setGroundLevel(BigDecimal groundLevel) {
        this.groundLevel = groundLevel;
    }

    public BigDecimal getTempKf() {
        return tempKf;
    }

    public void setTempKf(BigDecimal tempKf) {
        this.tempKf = tempKf;
    }

    public BigDecimal getTemp() {
        return temp;
    }

    public void setTemp(BigDecimal temp) {
        this.temp = temp;
    }

    public BigDecimal getPressure() {
        return pressure;
    }

    public void setPressure(BigDecimal pressure) {
        this.pressure = pressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public BigDecimal getTempMin() {
        return tempMin;
    }

    public void setTempMin(BigDecimal tempMin) {
        this.tempMin = tempMin;
    }

    public BigDecimal getTempMax() {
        return tempMax;
    }

    public void setTempMax(BigDecimal tempMax) {
        this.tempMax = tempMax;
    }
}
