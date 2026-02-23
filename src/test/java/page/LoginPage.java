package page;

import base.BasePage;
import base.TestData;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Элементы и действия страницы авторизации
 */
public class LoginPage extends BasePage {
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
        openPage(TestData.LOGIN_URL);
        waitPage();
    }

    private void enterUsername(String username) {
        enterText(usernameField, username);
    }

    private void enterPassword(String password) {
        enterText(passwordField, password);
    }

    private void clickLoginButton() {
        clickButton(loginButton);
    }

    /**
     * КОМПОЗИТНЫЕ МЕТОДЫ
     */
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    /**
     * МЕТОДЫ ПРОВЕРОК
     */
    public void waitPage() {
        wait.until(ExpectedConditions.and(
                ExpectedConditions.elementToBeClickable(usernameField),
                ExpectedConditions.elementToBeClickable(passwordField),
                ExpectedConditions.elementToBeClickable(loginButton)));
    }

    public String getAuthInvalid(){
        try {
            return getText(authError);
        } catch (TimeoutException error){
            return null;
        }

    }

    public String getAuthSuccess(){
        try {
            return  getText(logoutButton);
        } catch (TimeoutException error){
            return null;
        }
    }
}
