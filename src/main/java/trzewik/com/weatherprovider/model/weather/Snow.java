package trzewik.com.weatherprovider.model.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Snow {

    @JsonProperty("3h")
    private BigDecimal threeHours;

    public BigDecimal getThreeHours() {
        return threeHours;
    }

    public void setThreeHours(BigDecimal threeHours) {
        this.threeHours = threeHours;
    }
}
