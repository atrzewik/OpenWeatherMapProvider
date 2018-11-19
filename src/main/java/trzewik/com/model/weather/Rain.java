package trzewik.com.model.weather;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Rain {

    @JsonProperty("3h")
    private BigDecimal threeHours;

    public BigDecimal getThreeHours() {
        return threeHours;
    }

    public void setThreeHours(BigDecimal threeHours) {
        this.threeHours = threeHours;
    }
}
