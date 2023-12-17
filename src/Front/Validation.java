package Front;

import java.util.regex.Pattern;

/**
 * This Class contains everything belongs to the Validation
 */
public class Validation {

    /**
     * This Method checks if the Input is matches the Pattern
     *
     * @param input the name of the user or the product
     * @param pattern the pattern that we will use to check the validation of the input
     * @return This returns ture or false according to the input
     */
    public static boolean validate(String input, String pattern) {
        Pattern p = Pattern.compile(pattern);
        return p.matcher(input).matches();
    }

    /**
     * This Method checks if the input is only Numbers and between 5 and 8 digits
     *
     * @param unit the input that we will check its validation
     * @return This returns ture or false according to the input
     */
    public static boolean isValid(String unit) {
        if (unit == null || unit.length() < 5 || unit.length() > 8) {
            return false;
        }

        for (char c : unit.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }
    /**
     * This Method checks if the input is only Numbers
     *
     * @param unit the input that we will check its validation
     * @return This returns ture or false according to the input
     */
    public static boolean isValidQuantity(String unit) {
        for (char c : unit.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }


}
