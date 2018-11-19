package trzewik.com.weatherprovider.inputProvider;

import trzewik.com.weatherprovider.weather.enums.Weather;

import java.util.Scanner;

public class InputMatcher {

    public static Weather collectWeatherPlanFromUser(String message, String ... formats){
        while (true){
            try{
                return Weather.matchWeatherChoice(collectString(message, formats));
            }
            catch (IllegalArgumentException e){
                MessagePrinter.printErrorMessage(MessageProvider.wrongWeather);
            }
        }
    }

    public static String collectString(String message, String ... formats){
        while (true) {
            try {
                Scanner userInput = getMessage(message, formats);
                return userInput.nextLine();
            } catch (Exception e) {
                MessagePrinter.printErrorMessage("Input must be a string! Try again: ");
            }
        }
    }

    private static Scanner getMessage(String message, String ... formats){
        Scanner userInput = new Scanner(System.in);
        MessagePrinter.printMessage(message, formats);
        return userInput;
    }
}
