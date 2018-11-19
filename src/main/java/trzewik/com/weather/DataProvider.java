package trzewik.com.weather;

public class DataProvider {


    public static String basicUrl = "https://api.openweathermap.org/data/2.5/";
    public static String dailyUrl = basicUrl + "weather";
    public static String forecastUrl = basicUrl + "forecast";
    public static String apiKey = ApiKeyProperty.getApiKey();
}
