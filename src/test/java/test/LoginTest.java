package test;

import base.TestBase;
import base.TestData;
import helpers.AuthHelper;
import org.junit.jupiter.api.*;
import page.LoginPage;
import static io.qameta.allure.Allure.step;

/**
 * Авторизация. Тесты
 */
public class LoginTest extends TestBase {
    private LoginPage loginPage;

    private void authSuccess(String login, String password, String expectedText){
        AuthHelper.login(driver, login, password);
        String actualText = loginPage.getAuthSuccess();
        Assertions.assertNotNull(actualText, "Элемент с ошибкой авторизации не появился. Текущий URL: " + driver.getCurrentUrl());
        Assertions.assertEquals(expectedText, actualText, "⚠️ Кнопка выхода появилась. Но текст в кнопке не Exit");
    }

    private void authInvalid(String login, String password, String expectedText){
        AuthHelper.login(driver,login, password);
        String actualText = loginPage.getAuthInvalid();
        Assertions.assertNotNull(actualText, "Элемент с ошибкой авторизации не появился");
        Assertions.assertEquals(expectedText, actualText, "⚠️ Полученный текст не Invalid login or password");
    }

    @BeforeEach
    public void setUpTest(){
        step("Запустили браузер", this::setUp);
        step("Создали драйвер",() -> loginPage = new LoginPage(driver));
        step("Открыли страницу авторизации",() -> loginPage.openPageLogin());
    }

    @AfterEach
    public void tearDownTest(){
        step("Закрыли браузер", this::tearDown);
    }

    /**
     * Case2.1<br>
     * 1. Вводим логин пользователя, которого нет в базе данных<br>
     * 2. Вводим пароль любого существующего пользователя<br>
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Case 2.1: Проверка авторизации с невалидным логином")
    public void authInvalidLogin() {
        step("Авторизация по логину: " + TestData.INVALID_LOGIN + " и паролю: " + TestData.USER_PASSWORD,() ->
                authInvalid(TestData.INVALID_LOGIN, TestData.USER_PASSWORD, TestData.EXPECTED_TEXT_AUTH_INVALID));
    }

    /**
     * Case2.2<br>
     * 1. Вводим логин пользователя(Пользователь: активен, не удален. Логин валидный)<br>
     * 2. Вводим неверный пароль пользователя<br>
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Case 2.2: Проверка авторизации с невалидным паролем")
    public void authInvalidPassword() {
        step("Авторизация по логину: " + TestData.USER_LOGIN + " и паролю: " + TestData.INVALID_PASSWORD,() ->
                authInvalid(TestData.USER_LOGIN, TestData.INVALID_PASSWORD, TestData.EXPECTED_TEXT_AUTH_INVALID));
    }

    /**
     * Case2.3<br>
     * 1. Вводим логин пользователя, которого нет в базе данных<br>
     * 2. Вводим неверный пароль пользователя<br>
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Case 2.3: Проверка авторизации с некорректными логином и паролем")
    public void authInvalidLoginPassword(){
        step("Авторизация по логину: " + TestData.INVALID_LOGIN + " и паролю: " + TestData.INVALID_PASSWORD,() ->
                authInvalid(TestData.INVALID_LOGIN, TestData.INVALID_PASSWORD, TestData.EXPECTED_TEXT_AUTH_INVALID));
    }

    /**
     * Case2.4<br>
     * 1. Вводим логин пользователя(Пользователь: активен, не удален. Логин валидный)<br>
     * 2. Вводим пароль пользователя(Пользователь: активен, не удален. Пароль: валидный)<br>
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Case 2.4: Проверка успешной авторизации")
    public void authSuccess(){
        step(" Авторизация по логину: " + TestData.USER_LOGIN + " и паролю: " + TestData.USER_PASSWORD,() ->
                authSuccess(TestData.USER_LOGIN, TestData.USER_PASSWORD, TestData.EXPECTED_TEXT_AUTH));
    }
}
