package trzewik.com.weather;

import java.math.BigDecimal;

public class Converter {

    public static int tempToCelsius(BigDecimal kelvin){
        return kelvin.subtract(new BigDecimal("273.15")).intValue();
    }
}
