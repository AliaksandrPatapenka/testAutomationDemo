package test;

import base.TestBase;
import base.TestData;
import org.junit.jupiter.api.*;
import page.LoginPage;

/**
 * Тестовый класс для проверки функциональности страницы авторизации.
 */
public class LoginTest extends TestBase {
    private LoginPage loginPage;

    private void auth(String userLogin, String userPassword, String expectedText, boolean isSuccess) {
        loginPage.login(userLogin, userPassword);
        String actualText;
        if (isSuccess){
            actualText = loginPage.getAutSuccess();
        } else {
            actualText = loginPage.getAuthInvalid();
        }// если true, то успешная авторизация.
        Assertions.assertEquals(expectedText, actualText, "Нет нужного текста");
    }

    @BeforeEach
    public void  setUpTest(){
        setUp();
        loginPage = new LoginPage(driver);
        loginPage.openPageLogin();
    }

    @AfterEach
    public void tearDownTest(){
        tearDown();
    }

    /**
     * ТЕСТЫ
     * Case1:
     * 1. Нажимаем на кнопку открытия формы с пользовательским соглашением
     */
    @Test
    @DisplayName("Нажатие на ссылку в подвале страницы")
    public void clickFooterLink() {
        loginPage.clickFooterLink();
        Assertions.assertTrue(loginPage.isFooterLinkClickable(), "Ссылка в футере должна быть кликабельной");
    }

    /**
     * Case2:
     * 1. Вводим логин пользователя, которого нет в базе данных
     * 2. Вводим пароль пользователя(Пользователь: активен, не удален. Пароль: валидный)
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Проверка авторизации с невалидным логином")
    public void authInvalidLogin() {
        auth(TestData.INVALID_LOGIN, TestData.USER_PASSWORD, TestData.EXPECTED_TEXT_AUTH_INVALID, false);
    }

    /**
     * Case3:
     * 1. Вводим логин пользователя(Пользователь: активен, не удален. Логин валидный)
     * 2. Вводим неверный пароль пользователя
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Проверка авторизации с невалидным паролем")
    public void authInvalidPassword() {
        auth(TestData.USER_LOGIN, TestData.INVALID_PASSWORD, TestData.EXPECTED_TEXT_AUTH_INVALID, false);
    }

    /**
     * Case4:
     * 1. Вводим логин пользователя, которого нет в базе данных
     * 2. Вводим неверный пароль пользователя
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Проверка авторизации с некорректными логином и паролем")
    public void authInvalidLoginPassword(){
        auth(TestData.INVALID_LOGIN, TestData.INVALID_PASSWORD, TestData.EXPECTED_TEXT_AUTH_INVALID, false);
    }

    /**
     * Case5:
     * 1. Вводим логин пользователя(Пользователь: активен, не удален. Логин валидный)
     * 2. Вводим пароль пользователя(Пользователь: активен, не удален. Пароль: валидный)
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Проверка успешной авторизации")
    public void authSusses(){
        auth(TestData.USER_LOGIN, TestData.USER_PASSWORD, TestData.EXPECTED_TEXT_AUTH, true);

    }
}
