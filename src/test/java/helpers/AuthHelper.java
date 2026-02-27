package helpers;

import org.openqa.selenium.WebDriver;
import page.LoginPage;

public class AuthHelper {
    public static void login(WebDriver driver, String login, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPageLogin();
        loginPage.login(login, password);
    }// для авторизации в других тестовых классах в @BeforeEach использовать AuthHelper.login(driver, TestData.USER_LOGIN, TestData.USER_PASSWORD);
}
