package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    /**
     * КОНСТРУКТОР
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * ЛОКАТОРЫ
     */
    private final By usernameField = By.name("login");
    private final By passwordField = By.name("password");
    private final By loginButton = By.cssSelector(".sign-in__button.j-button-submit");
    private final By footerLink = By.className("footer__link");

    /**
     * МЕТОДЫ ДЕЙСТВИЙ
     */
    public void open() {
        try {
            driver.get(BASE_URL + "/login");
            waitPage();
        } catch (Exception e) {
            System.out.println("❌ Сервер не отвечает");
        }
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

    public  void  clickFooterLink() {
        clickButton(footerLink);
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
}
