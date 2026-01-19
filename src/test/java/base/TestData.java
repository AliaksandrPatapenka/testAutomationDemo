package base;

public class TestData {

    public static final String USER_LOGIN = System.getProperty("user.login", "user");
    public static final String USER_PASSWORD = System.getProperty("user.password", "1234");
    public static final String INVALID_LOGIN = System.getProperty("user.login", "userInvalid");
    public static final String INVALID_PASSWORD = System.getProperty("user.password", "4321");
    public static final String LANGUAGE = System.getProperty("language.rus", "rus");

}
