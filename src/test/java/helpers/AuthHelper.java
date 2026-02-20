package helpers;

import org.openqa.selenium.WebDriver;
import page.LoginPage;

public class AuthHelper {
    public static void login(WebDriver driver, String login, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(login,  password);
    }
}
