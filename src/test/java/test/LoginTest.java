package test;

import base.TestBase;
import base.TestData;
import org.junit.jupiter.api.*;
import page.LoginPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Авторизация. Тесты
 */
public class LoginTest extends TestBase {
    private LoginPage loginPage;
    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    private void auth(String userLogin, String userPassword, String expectedText, boolean isSuccess) {
        log.info("=== Начало авторизации ===");
        log.info("Логин: {}", userLogin);
        log.info("Пароль: {}", userPassword);
        log.info("Выполняем вход...");
        loginPage.login(userLogin, userPassword);
        String actualText;
        if (isSuccess){
            actualText = loginPage.getAutSuccess();
            log.info("Получен текст: {}", actualText);
        } else {
            actualText = loginPage.getAuthInvalid();
            log.info("Получен текст ошибки: {}", actualText);
        }// если true, то успешная авторизация.
        log.info("Ожидаемый текст: {}",expectedText);
        Assertions.assertEquals(expectedText, actualText, "Нет нужного текста");
        log.info("✅ Проверка на выбор успешной/неуспешной авторизации прошла успешно");
    }

    @BeforeEach
    public void  setUpTest(){
        setUp();
        log.info("✅Браузер запущен");
        loginPage = new LoginPage(driver);
        loginPage.openPageLogin();
        log.info("✅ Страница авторизации открыта");
    }

    @AfterEach
    public void tearDownTest(){
        tearDown();
        log.info("✅ Браузер закрыт");
    }

    /**
     * Case2.2<br>
     * 1. Вводим логин пользователя, которого нет в базе данных<br>
     * 2. Вводим пароль пользователя(Пользователь: активен, не удален. Пароль: валидный)<br>
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Case2.2: Проверка авторизации с невалидным логином")
    public void authInvalidLogin() {
        log.info("=== Case2.2: Проверка авторизации с невалидным логином ===");
        auth(TestData.INVALID_LOGIN, TestData.USER_PASSWORD, TestData.EXPECTED_TEXT_AUTH_INVALID, false);
        log.info("✅ Case2.2 завершен успешно");
    }

    /**
     * Case2.3<br>
     * 1. Вводим логин пользователя(Пользователь: активен, не удален. Логин валидный)<br>
     * 2. Вводим неверный пароль пользователя<br>
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Case2.3: Проверка авторизации с невалидным паролем")
    public void authInvalidPassword() {
        log.info("=== Case2.3: Проверка авторизации с невалидным паролем ===");
        auth(TestData.USER_LOGIN, TestData.INVALID_PASSWORD, TestData.EXPECTED_TEXT_AUTH_INVALID, false);
        log.info("✅ Case2.3 завершен успешно");
    }

    /**
     * Case2.4<br>
     * 1. Вводим логин пользователя, которого нет в базе данных<br>
     * 2. Вводим неверный пароль пользователя<br>
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Case2.4: Проверка авторизации с некорректными логином и паролем")
    public void authInvalidLoginPassword(){
        log.info("=== Case2.4: Проверка авторизации с некорректными логином и паролем ===");
        auth(TestData.INVALID_LOGIN, TestData.INVALID_PASSWORD, TestData.EXPECTED_TEXT_AUTH_INVALID, false);
        log.info("✅ Case2.4 завершен успешно");
    }

    /**
     * Case2.5<br>
     * 1. Вводим логин пользователя(Пользователь: активен, не удален. Логин валидный)<br>
     * 2. Вводим пароль пользователя(Пользователь: активен, не удален. Пароль: валидный)<br>
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Case2.5: Проверка успешной авторизации")
    public void authSuccess(){
        log.info("=== Case2.5: Проверка успешной авторизации ===");
        auth(TestData.USER_LOGIN, TestData.USER_PASSWORD, TestData.EXPECTED_TEXT_AUTH, true);
        log.info("✅ Case2.5 завершен успешно");

    }
}
