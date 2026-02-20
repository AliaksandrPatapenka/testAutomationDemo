package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

    /**
      * Абстрактный базовый класс для всех страниц.
      * Содержит общие методы и константы для работы с WebDriver.
      */
public abstract class BasePage  {

    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * КОНСТРУКТОР
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TestData.DEFAULT_TIMEOUT));
    }

    /**
     * ОЖИДАНИЯ И ЗАДЕРЖКИ
     */
    protected WebElement elementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement visibilityOfElementLocated(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void invisibilityOfElementLocated(By locator){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
        /**
     * МЕТОДЫ ДЕЙСТВИЙ
     */

    public void openPage(String path) {
        String url = TestData.BASE_PROTOCOL + TestData.BASE_DOMAIN + TestData.BASE_PORT + path;
        driver.get(url);
    }

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
     * МЕТОДЫ ПОЛУЧЕНИЯ ДАННЫХ.
     */
    public String getText(By locator) {
        WebElement element = visibilityOfElementLocated(locator);
        return element.getText();
    }
}
