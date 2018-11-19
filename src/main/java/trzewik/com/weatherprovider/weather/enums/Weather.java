package trzewik.com.weatherprovider.weather.enums;

public enum Weather {
    CURRENT,
    FIVE_DAYS;

    public static Weather matchWeatherChoice(String userChoice){
        for (Weather weather: values()){
            if (userChoice.toUpperCase().equals(weather.name())){
                return weather;
            }
        }
        throw new IllegalArgumentException();
    }
}
