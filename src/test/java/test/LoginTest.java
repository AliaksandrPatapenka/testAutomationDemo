package test;

import base.TestBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.LoginPage;

/**
 * Тестовый класс для проверки функциональности страницы авторизации.
 */
public class LoginTest extends TestBase {
    /**
     * Экземпляр страницы авторизации.
     */
    private LoginPage loginPage;

    //ОБЩИЕ ДЕЙСТВИЯ
    /**
     * Подготавливает тестовое окружение перед каждым тестом.
     * Инициализирует драйвер, создает экземпляр LoginPage и открывает страницу входа.
     */
    @BeforeEach
    public void  setUpTest(){
        setUp();
        loginPage = new LoginPage(driver);
        loginPage.open();
    }

    /**
     * Завершает тестовое окружение после каждого теста.
     * Закрывает браузер и освобождает ресурсы.
     */
    @AfterEach
    public void tearDownTest(){
        tearDown();
    }

    //ТЕСТЫ
    /**
     * Case1:
     * 1. Нажимаем на кнопку раскрытия формы выбора локализации
     * 2. Нажимаем на кнопку нужной локализации
     */
    @Test
    @DisplayName("Выбор локализации")
    public void selectLanguage(){
        loginPage.selectLanguage("LANGUAGE");
    }

    /**
     * Case2:
     * 1. Нажимаем на кнопку открытия формы с пользовательским соглашением
     */
    @Test
    @DisplayName("Нажатие на ссылку в подвале страницы")
    public void clickFooterLink() {
        loginPage.clickFooterLink();
    }

    /**
     * Case3:
     * 1. Вводим логин пользователя(Пользователь: активен, не удален. Логин валидный)
     * 2. Вводим пароль пользователя(Пользователь: активен, не удален. Пароль: валидный)
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Проверка авторизации с валидными данными")
    public void successfulLogin(){
        loginPage.login("USER-LOGIN", "USER-PASSWORD");
    }

    /**
     * Case4:
     * 1. Вводим логин пользователя, которого нет в базе данных
     * 2. Вводим пароль пользователя(Пользователь: активен, не удален. Пароль: валидный)
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Проверка авторизации с невалидным логином")
    public void authInvalidLogin() {
        loginPage.login("INVALID-LOGIN", "USER-PASSWORD");
    }

    /**
     * Case5:
     * 1. Вводим логин пользователя(Пользователь: активен, не удален. Логин валидный)
     * 2. Вводим неверный пароль пользователя
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Проверка авторизации с невалидным паролем")
    public void authInvalidPassword() {
        loginPage.login("USER-LOGIN", "INVALID-PASSWORD");
    }

    /**
     * Case6:
     * 1. Вводим логин пользователя, которого нет в базе данных
     * 2. Вводим неверный пароль пользователя
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Проверка авторизации с некорректными логином и паролем")
    public void authInvalidLoginPassword(){
        loginPage.login("INVALID-LOGIN", "INVALID-PASSWORD");
    }
}
