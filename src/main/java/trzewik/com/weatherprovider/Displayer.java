package trzewik.com.weatherprovider;

import trzewik.com.weatherprovider.inputProvider.InputMatcher;
import trzewik.com.weatherprovider.inputProvider.MessagePrinter;
import trzewik.com.weatherprovider.inputProvider.MessageProvider;
import trzewik.com.weatherprovider.model.ResponseWeather;
import trzewik.com.weatherprovider.model.forecast.ForecastItem;
import trzewik.com.weatherprovider.weather.Converter;
import trzewik.com.weatherprovider.weather.WeatherProvider;
import trzewik.com.weatherprovider.weather.enums.Weather;


import java.util.List;


public class Displayer {

    public static void main(String[] args) {
        WeatherProvider weatherProvider = new WeatherProvider();
        Weather daysOfWeather = chooseWeatherInfo();
        if (daysOfWeather.equals(Weather.CURRENT)) {
            printCurrentWeather(getResponseWeather(weatherProvider));
        } else if (daysOfWeather.equals(Weather.FIVE_DAYS)) {
            printFiveDaysWeather(getForecastItems(weatherProvider));

        }

    }

    private static Weather chooseWeatherInfo() {
        return InputMatcher.collectWeatherPlanFromUser(MessageProvider.askAboutWeatherPlan);
    }

    private static void printFiveDaysWeather(List<ForecastItem> forecastItems) {
        for (ForecastItem forecastItem : forecastItems) {
            MessagePrinter.printMessage(MessageProvider.tellDayAndHour + forecastItem.getDtTxt());
            MessagePrinter.printMessage(MessageProvider.tellAverageTemp + Converter.tempToCelsius(forecastItem.getMain().getTemp()));
            MessagePrinter.printMessage(MessageProvider.tellMaxTemp + Converter.tempToCelsius(forecastItem.getMain().getTempMax()));
            MessagePrinter.printMessage(MessageProvider.tellMinTemp + Converter.tempToCelsius(forecastItem.getMain().getTempMin()));
        }
    }

    private static List<ForecastItem> getForecastItems(WeatherProvider weatherProvider) {
        while (true) {
            try {
                String cityChoice = InputMatcher.collectString(MessageProvider.askAboutCity);
                return weatherProvider.getResponseWeatherForecast(cityChoice).getForecastItems();
            } catch (IllegalArgumentException e) {
                MessagePrinter.printErrorMessage(MessageProvider.wrongCity);
            }
        }
    }

    private static void printCurrentWeather(ResponseWeather responseWeather) {
        MessagePrinter.printMessage(MessageProvider.informAboutCurrentTime);
        MessagePrinter.printMessage(MessageProvider.tellAverageTemp + Converter.tempToCelsius(responseWeather.getMain().getTemp()));
        MessagePrinter.printMessage(MessageProvider.tellMaxTemp + Converter.tempToCelsius(responseWeather.getMain().getTempMax()));
        MessagePrinter.printMessage(MessageProvider.tellMinTemp + Converter.tempToCelsius(responseWeather.getMain().getTempMin()));
    }

    private static ResponseWeather getResponseWeather(WeatherProvider weatherProvider) {
        while (true) {
            try {
                String cityChoice = InputMatcher.collectString(MessageProvider.askAboutCity);
                return weatherProvider.getResponseWeather(cityChoice);
            } catch (IllegalArgumentException e) {
                MessagePrinter.printErrorMessage(MessageProvider.wrongCity);
            }
        }
    }
}
