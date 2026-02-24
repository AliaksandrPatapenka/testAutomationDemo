package page;

import base.BasePage;
import base.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Элементы и действия страницы авторизации
 */
public class LoginPage extends BasePage {
    protected static final Logger log = LoggerFactory.getLogger(LoginPage.class);
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * ЛОКАТОРЫ
     */
    private final By usernameField = By.name("login");
    private final By passwordField = By.name("password");
    private final By loginButton = By.cssSelector(".sign-in__button.j-button-submit");
    private final By authError = By.className("auth__error");
    private final By logoutButton = By.id("logout");

    /**
     * МЕТОДЫ ДЕЙСТВИЙ
     */
    public void openPageLogin() {
        log.info("Открываем страницу логина");
        openPage(TestData.LOGIN_URL);
        waitPage();
        log.info("Страница логина загружена");
    }

    private void enterUsername(String username) {
        log.debug("Вводим логин: {}", username);
        enterText(usernameField, username);
    }

    private void enterPassword(String password) {
        log.debug("Вводим пароль: {}", password);
        enterText(passwordField, password);
    }

    private void clickLoginButton() {
        log.info("Нажимаем на кнопку авторизации");
        clickButton(loginButton);
    }

    /**
     * КОМПОЗИТНЫЕ МЕТОДЫ
     */
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        log.info("Отправляем запрос авторизации");
    }

    /**
     * МЕТОДЫ ПРОВЕРОК
     */
    public void waitPage() {
        log.info("Ожидание загрузки страницы авторизации");
        wait.until(ExpectedConditions.and(
                ExpectedConditions.elementToBeClickable(usernameField),
                ExpectedConditions.elementToBeClickable(passwordField),
                ExpectedConditions.elementToBeClickable(loginButton)));
        log.debug("Страница авторизации загружена");
    }

    public String getAuthInvalid(){
        log.info("Проверяем появление ошибки авторизации");
        try {
            log.debug("Получен текст ошибки: {}", getText(authError));
            return getText(authError);
        } catch (TimeoutException error){
            log.debug("Элемент с ошибкой не появился");
            return null;
        }
    }

    public String getAuthSuccess(){
        log.debug("Проверяем успешную авторизацию (появление кнопки выхода)");
        try {
            log.debug("Кнопка выхода появилась, текст: '{}'", getText(logoutButton));
            return  getText(logoutButton);
        } catch (TimeoutException error){
            log.debug("Кнопка выхода не появилась. Текущий URL: {}", driver.getCurrentUrl());
            return null;
        }
    }
}
