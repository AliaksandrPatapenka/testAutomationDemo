package helpers;

import base.TestBase;
import base.TestData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import page.LoginPage;
import org.openqa.selenium.Cookie;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;

public class AuthHelper {
    private AuthHelper(){} //Приватный конструктор - чтобы нельзя было создать объект этого класса. Все методы будут статическими, вызываем как AuthHelper.methodName()

    public static Set<Cookie> getAuthCookie (String expectedText) {
        TestBase testBase = new TestBase();
        testBase.setUp();
        WebDriver driver = testBase.getDriver(); // Создаем экземпляр драйвера для TestBase
        driver.manage().deleteAllCookies();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPageLogin();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        loginPage.login(TestData.USER_LOGIN, TestData.USER_PASSWORD);
        String token = (String) ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("return JSON.parse(localStorage.getItem('prop.sessionEntity')).token");
        Cookie sessionCookie = new Cookie.Builder("session", token).domain("localhost").path("/").isHttpOnly(true).build();
        driver.manage().addCookie(sessionCookie);
        Set<Cookie> allCookie = driver.manage().getCookies();
            for (Cookie cookie : allCookie) {
                System.out.println("Имя: " + cookie.getName());
                System.out.println("Значение: " + cookie.getValue());
            }// Выводим все сформированные Cookie
        return allCookie;


    }

    public static void main(String[] args) {
        getAuthCookie(TestData.EXPECTED_TEXT_AUTH);
    }
}
