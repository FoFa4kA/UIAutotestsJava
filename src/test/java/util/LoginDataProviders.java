package util;

import org.testng.annotations.DataProvider;

public class LoginDataProviders {

    @DataProvider(name = "Invalid data for login")
    public Object[][] invalidLoginData() {
        return new Object[][] {
                {"invalid_data", "password", "user_desc"},
                {"username", "invalid_data", "user_desc"},
                {"invalid_data", "invalid_data", "user_desc"},
        };
    }

    @DataProvider(name = "Valid data for login")
    public Object[][] validLoginData() {
        return new Object[][] {
                {"username", "password", "user_desc"}
        };
    }
}
