public class DataValidator {

    public boolean isValidUsername(String userInput) {
        //valid username must have at least 3 characters
        //must be lowercase letters only
        //cannot have more than 25 characters
        if (!isProperLength(userInput)) {
            return false;
        } else if (!containsLowercaseOnly(userInput)) {
            return false;
        }
        return true;
    }

    public boolean isValidEnhancedUsername(String userInput) {
        //username may contain numbers and an _
        //username must start with a letter
        if (!isProperLength(userInput)) {
            return false;
        } else if (!containsWordCharactersOnly(userInput)) {
            return false;
        } else if (!isFirstCharLetter(userInput)) {
            return false;
        } else return true;
    }

    //returns false if the length of the string is greater than 25 or less than 3
    private boolean isProperLength(String userInput) {
        int length = userInput.length();
        if (length > 25 || length <= 3) {
            return false;
        }
        return true;
    }

    //returns false if the string contains anything other than lowercase letters
    private boolean containsLowercaseOnly(String userInput) {
        if (userInput.matches("[a-z]+")) {
            return true;
        }
        return false;
    }

    //returns false if the string contains anything other than word characters
    private boolean containsWordCharactersOnly(String userInput) {
        if (userInput.matches("[\\w]+")) {
            return true;
        }
        return false;
    }

    //returns false if the first character is not a letter
    private boolean isFirstCharLetter(String userInput) {
        if (userInput.matches("^[^a-zA-Z](.*)")) {
            return false;
        }
        return true;
    }

    //IP addresses consist of four numbers (0-255) separated by dots.
    //Leading zeros are allowed but each number cannot be more than 3 digits
    public boolean isValidIPAddress(String userInput) {
        //first, check that the string contains only digits and dots
        if (!containsOnlyNumbers(userInput)) {
            return false;
        }
        //splits the string by dots
        String[] segments = userInput.split("\\.");
        //if the array length is not equal to 4, returns false
        if (!checkArrayLength(segments)) {
            return false;
        }
        //checks each segment and returns false if any of them are not 3 digits long
        for (int i = 0; i < 4; i++) {
            if (!checkSegmentLength(segments[i])) {
                return false;
            }
        }
        //if all tests pass, returns true
        return true;
    }

    //method to check array length
    public boolean checkArrayLength(String[] segments) {
        if (segments.length == 4) {
            return true;
        }
        return false;
    }

    //checks if the string contains only numbers and dots
    public boolean containsOnlyNumbers(String userInput) {
        if (userInput.matches("[\\d\\.]+")) {
            return true;
        }
        return false;
    }

    //returns false if the string length is greater than 3
    public boolean checkSegmentLength(String segment) {
        if (segment.length() == 3) {
            return true;
        }
        return false;
    }
}