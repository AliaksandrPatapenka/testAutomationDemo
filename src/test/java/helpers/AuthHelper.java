package helpers;

import base.TestBase;
import base.TestData;
import org.openqa.selenium.WebDriver;
import page.LoginPage;
import org.openqa.selenium.Cookie;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthHelper {
    private AuthHelper(){} //Приватный конструктор - чтобы нельзя было создать объект этого класса. Все методы будут статическими, вызываем как AuthHelper.methodName()
    private static final Logger log = LoggerFactory.getLogger(AuthHelper.class);

    public static void getAuthCookie () {
        TestBase testBase = new TestBase();

        testBase.setUp();
        WebDriver driver = testBase.getDriver(); // Создаем экземпляр драйвера для TestBase
        driver.manage().deleteAllCookies();//Удаляем старые куки
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPageLogin();
        loginPage.login(TestData.USER_LOGIN, TestData.USER_PASSWORD);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread was interrupted", e);
        }

        String token = (String) ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("return JSON.parse(localStorage.getItem('prop.sessionEntity')).token");//Получение токена из LocalStorage
        Cookie sessionCookie = new Cookie.Builder("session", token)
                .domain(TestData.BASE_DOMAIN).path("/")
               .isHttpOnly(true).build();//Создание из токена куки
        driver.manage().addCookie(sessionCookie);//Добавление куки в браузер
        Set<Cookie> allCookie = driver.manage().getCookies();//Получение всех кук
        log.info("Session cookie = {}",sessionCookie);
        log.info("Все cookie = {}",allCookie);
    }

    public static void main(String[] args) {
        getAuthCookie();
    }
}
