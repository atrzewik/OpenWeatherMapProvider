package trzewik.com.inputProvider;

import trzewik.com.weather.enums.Weather;

import java.util.Scanner;

public class InputMatcher {

    public static Weather collectWeatherPlanFromUser(String message, String ... formats){
        while (true){
            try{
                return matchWeatherChoice(collectString(message, formats));
            }
            catch (IllegalArgumentException e){
                MessagePrinter.printErrorMessage(MessageProvider.wrongWeather);
            }
        }
    }

    private static Weather matchWeatherChoice(String userChoice){
        if (userChoice.toUpperCase().equals(Weather.CURRENT.name())){
            return Weather.CURRENT;
        }
        else if (userChoice.toUpperCase().equals(Weather.FIVE_DAYS.name())){
            return Weather.FIVE_DAYS;
        }
        else {
            throw new IllegalArgumentException();
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
