package base;

public final class TestData {

    public static final String USER_LOGIN = System.getProperty("user.login", "user");
    public static final String USER_PASSWORD = System.getProperty("user.password", "1234");
    public static final String INVALID_LOGIN = System.getProperty("invalid.login", "userInvalid");
    public static final String INVALID_PASSWORD = System.getProperty("invalid.password", "4321");
    public static final String LANGUAGE_CODE = System.getProperty("language.code", "rus");

    public static final int DEFAULT_TIMEOUT_SECONDS = 10;

}
