package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Базовый класс для настройки и управления тестовым окружением WebDriver.
 */
public class TestBase {
    protected WebDriver driver;
    protected static final Logger log = LoggerFactory.getLogger(TestBase.class);

    public void setUp() {
        WebDriverManager.chromedriver().setup(); //Настраивает и инициализирует тестовое окружение.
        driver = new ChromeDriver(); //Устанавливает драйвер Chrome
        driver.manage().window().maximize(); //Максимизирует окно браузера
        log.info("✅ Браузер запущен и развернут на весь экран");
    }

    public void tearDown(){
        if (driver != null) {
            driver.quit();
            log.info("✅ Браузер закрыт");
        } //Закрывает браузер и освобождает ресурсы WebDriver, если он был инициализирован.
    }
}
