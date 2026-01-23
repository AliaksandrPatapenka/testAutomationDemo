package test;

import base.TestBase;
import base.TestData;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.LoginPage;

/**
 * Тестовый класс для проверки функциональности страницы авторизации.
 */
public class LoginTest extends TestBase {
    private LoginPage loginPage;

    /**
     * ДЕЙСТВИЯ ПЕРЕД НАЧАЛОМ И ПОСЛЕ ОКОНЧАНИЯ ТЕСТОВ
     */
    @BeforeEach
    public void  setUpTest(){
        setUp();
        loginPage = new LoginPage(driver);
        loginPage.open();
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
    }

    /**
     * Case2:
     * 1. Вводим логин пользователя(Пользователь: активен, не удален. Логин валидный)
     * 2. Вводим пароль пользователя(Пользователь: активен, не удален. Пароль: валидный)
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Проверка авторизации с валидными данными")
    public void successfulLogin(){
        loginPage.login(TestData.USER_LOGIN, TestData.USER_PASSWORD);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Test wait interrupted", e);
        }
    }

    /**
     * Case3:
     * 1. Вводим логин пользователя, которого нет в базе данных
     * 2. Вводим пароль пользователя(Пользователь: активен, не удален. Пароль: валидный)
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Проверка авторизации с невалидным логином")
    public void authInvalidLogin() {
        loginPage.login(TestData.INVALID_LOGIN, TestData.USER_PASSWORD);
    }

    /**
     * Case4:
     * 1. Вводим логин пользователя(Пользователь: активен, не удален. Логин валидный)
     * 2. Вводим неверный пароль пользователя
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Проверка авторизации с невалидным паролем")
    public void authInvalidPassword() {
        loginPage.login(TestData.USER_LOGIN, TestData.INVALID_PASSWORD);
    }

    /**
     * Case5:
     * 1. Вводим логин пользователя, которого нет в базе данных
     * 2. Вводим неверный пароль пользователя
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Проверка авторизации с некорректными логином и паролем")
    public void authInvalidLoginPassword(){
        loginPage.login(TestData.INVALID_LOGIN, TestData.INVALID_PASSWORD);
    }
}
