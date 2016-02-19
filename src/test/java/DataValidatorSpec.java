import org.junit.Test;
import static org.junit.Assert.*;

public class DataValidatorSpec {

    @Test
    public void isValidUsernameTest(){
        DataValidator testValidator = new DataValidator();
        String validUsername = "username";
        assertTrue("testing that the valid username is valid",
                testValidator.isValidUsername(validUsername));

        String invalidUsername = "Username";
        assertFalse("testing that the checker detects uppercase as invalid",
                testValidator.isValidUsername(invalidUsername));

        String invalidUsername2 = "username123";
        assertFalse("testing that the checker detects numbers as invalid",
                testValidator.isValidUsername(invalidUsername2));

        String invalidUsername3 = "ab";
        assertFalse("testing that the checker detects less than 3 characters is invalid",
                testValidator.isValidUsername(invalidUsername3));
    }

    @Test
    public void isValidEnhancedUsernameTest(){
        DataValidator testValidator = new DataValidator();
        String validUsername = "username_123";
        assertTrue("testing that the valid username is valid",
                testValidator.isValidEnhancedUsername(validUsername));

        String invalidUsername = "1234username";
        assertFalse("testing that the checker detects numbers first as invalid",
                testValidator.isValidEnhancedUsername(invalidUsername));
    }

    @Test
    public void isValidIPAddressTest(){
        DataValidator testValidator = new DataValidator();
        String validIP = "012.345.012.351";
        assertTrue("testing that the valid IP address is valid",
                testValidator.isValidIPAddress(validIP));

        String invalidIP = "111.111.111.111.111";
        assertFalse("testing that the checker detects additional segments",
                testValidator.isValidIPAddress(invalidIP));

        String invalidIP2 = "1.1.1.1";
        assertFalse("testing that the checker detects segments less than 3 digits",
                testValidator.isValidIPAddress(invalidIP2));
    }

}