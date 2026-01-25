package base;

public final class TestData {

    public static final String BASE_URL = System.getProperty("base.url", "http://localhost:5001");

    public static final String USER_LOGIN = System.getProperty("user.login", "user");
    public static final String USER_PASSWORD = System.getProperty("user.password", "1234");
    public static final String INVALID_LOGIN = System.getProperty("invalid.login", "userInvalid");
    public static final String INVALID_PASSWORD = System.getProperty("invalid.password", "4321");

    public static final String LANGUAGE_RUS = System.getProperty("language.rus", "rus");
    public static final String LANGUAGE_ENG = System.getProperty("language.eng", "eng");
    public static final String EXPECTED_TEXT_LANGUAGE_ENG = "English";
    public static final String EXPECTED_TEXT_LANGUAGE_RUS = "Русский";

    public  static final String EXPECTED_TEXT_AUTH_INVALID = System.getProperty("auth.invalid", "sldfakldlklk");
    public  static final String EXPECTED_TEXT_AUTH = System.getProperty("auth", "ewrlkwjherlk");

    public static final int DEFAULT_TIMEOUT = 10;

    public static final String LOGIN = "/LOGIN";
}
