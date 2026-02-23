package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Базовый класс для настройки и управления тестовым окружением WebDriver.
 */
public class TestBase {
    protected WebDriver driver;

    public void setUp() {
        WebDriverManager.chromedriver().setup(); //Настраивает и инициализирует тестовое окружение.
        driver = new ChromeDriver(); //Устанавливает драйвер Chrome
        driver.manage().window().maximize(); //Максимизирует окно браузера
    }

    public void tearDown (){
        if (driver != null) {
            driver.quit();
        } //Закрывает браузер и освобождает ресурсы WebDriver, если он был инициализирован.
    }
}
