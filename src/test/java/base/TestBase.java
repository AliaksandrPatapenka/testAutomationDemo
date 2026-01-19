package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

/**
 * Базовый класс для настройки и управления тестовым окружением WebDriver.
 */
public class TestBase {
    /**
     * Экземпляр WebDriver для управления браузером.
     */
    protected WebDriver driver;

    /**
     * Настраивает и инициализирует тестовое окружение.
     * Устанавливает драйвер Chrome
     * Максимизирует окно браузера
     * Устанавливает неявное ожидание.
     */
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    /**
     * Завершает работу тестового окружения.
     * Закрывает браузер и освобождает ресурсы WebDriver, если он был инициализирован.
     */
    public void tearDown (){
        if (driver != null) {
            driver.quit();
        }
    }
}
