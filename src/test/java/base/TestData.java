package base;

/**
 * Содержит константы и тестовые данные для тестов.
 */
public final class TestData {

    public static final String BASE_URL = System.getProperty("base.url", "http://localhost:5001");
    //public static final String BASE_PROTOCOL = System.getProperty("base.protocol", "http://");
    //public static final String BASE_PORT = System.getProperty("base.port", ":5001");
    public static final String LOGIN_URL = System.getProperty("login.url", "/login");

    public static final String USER_LOGIN = System.getProperty("user.login", "user");
    public static final String USER_PASSWORD = System.getProperty("user.password", "1234");
    public static final String INVALID_LOGIN = System.getProperty("invalid.login", "userInvalid");
    public static final String INVALID_PASSWORD = System.getProperty("invalid.password", "4321");

    public static final String LANGUAGE_CODE_RUS = System.getProperty("language.rus", "rus");
    public static final String LANGUAGE_CODE_ENG = System.getProperty("language.eng", "eng");
    public static final String EXPECTED_TEXT_LANGUAGE_ENG = "ENGLISH";
    public static final String EXPECTED_TEXT_LANGUAGE_RUS = "РУССКИЙ";

    public  static final String EXPECTED_TEXT_AUTH_INVALID = System.getProperty("auth.invalid", "Invalid login or password");
    public  static final String EXPECTED_TEXT_AUTH = System.getProperty("auth.success", "Exit");

    public static final int DEFAULT_TIMEOUT = 10;

}
