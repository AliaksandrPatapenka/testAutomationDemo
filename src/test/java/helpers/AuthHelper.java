package helpers;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v120.network.model.Cookie;

import java.util.Set;

public class AuthHelper {
    private AuthHelper(){} //Приватный конструктор - чтобы нельзя было создать объект этого класса. Все методы будут статическими, вызываем как AuthHelper.methodName()

    public static Set<Cookie> getAuthCookie () {
        TestBase testBase = new TestBase();
        testBase.setUp();
        return Cookies;
    }


}
