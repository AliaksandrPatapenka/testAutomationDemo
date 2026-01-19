package test;

import base.TestBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.LoginPage;

public class LoginTest extends TestBase {
    private LoginPage loginPage;

    //ОБЩИЕ ДЕЙСТВИЯ
    @BeforeEach
    public void  setUpTest(){
        setUp(); //Настройка драйвера (создание браузера)
        loginPage = new LoginPage(driver); //Создание PageObject
        loginPage.open(); //Открытие страницы
    }

    @AfterEach
    public void tearDownTest(){
        tearDown(); //Закрытие браузера
    }

    //ТЕСТЫ
    @Test
    public void testSuccessfulLogin(){}
}
