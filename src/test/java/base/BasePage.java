package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

/**
 * Абстрактный базовый класс для всех страниц.
 * Содержит общие методы и константы для работы с WebDriver.
 */
public abstract class BasePage  {
    /**
     * Базовый URL приложения.
     * Значение по умолчанию: "http://localhost:5001".
     * Может быть переопределено системным свойством "base.url".
     */
    public static final String BASE_URL = System.getProperty("base.url", "http://localhost:5001");
    /**
     * Экземпляр WebDriver для управления браузером.
     * Экземпляр WebDriverWait для явных ожиданий.
     */
    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * ОЖИДАНИЯ И ЗАДЕРЖКИ
     */
    protected WebElement elementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement visibilityOfElementLocated(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * КОНСТРУКТОР
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TestData.DEFAULT_TIMEOUT_SECONDS));
    }

    /**
     * МЕТОДЫ ДЕЙСТВИЙ
     */
    protected void enterText(By locator, String text) {
        WebElement element = elementToBeClickable(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void clickButton(By locator) {
        WebElement element = elementToBeClickable(locator);
        element.click();
    }

    /**
     * МЕТОДЫ ПОЛУЧЕНИЯ ДАННЫХ
     */
    public boolean isElementEnabled(By locator) {
        WebElement element = elementToBeClickable(locator);
        return element.isEnabled();
    }

    public String getText(By locator) {
        WebElement element = visibilityOfElementLocated(locator);
        return element.getText();
    }


}
