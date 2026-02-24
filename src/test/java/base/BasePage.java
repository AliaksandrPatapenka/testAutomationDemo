package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

    /**
      * Абстрактный базовый класс для всех страниц.
      * Содержит общие методы и константы для работы с WebDriver.
      */
public abstract class BasePage  {
    protected WebDriver driver;
    protected WebDriverWait wait;
        protected static final Logger log = LoggerFactory.getLogger(BasePage.class);

    /**
     * КОНСТРУКТОР
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(TestData.DEFAULT_TIMEOUT));
        log.debug("Открыта страница: {}", this.getClass().getSimpleName());
    }

    /**
     * ОЖИДАНИЯ И ЗАДЕРЖКИ
     */
    protected WebElement elementToBeClickable(By locator) {
        log.debug("Ожидание кликабельности элемента: {}", locator);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected WebElement visibilityOfElementLocated(By locator){
        log.debug("Ожидание видимости элемента: {}", locator);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void invisibilityOfElementLocated(By locator){
        log.debug("Ожидание невидимости элемента: {}", locator);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

        /**
     * МЕТОДЫ ДЕЙСТВИЙ
     */

    public void openPage(String path) {
        String url = TestData.BASE_URL + path;
        driver.get(url);
    }

    protected void enterText(By locator, String text) {
        log.debug("Вводим текст '{}' в элемент: {}", text, locator);
        WebElement element = elementToBeClickable(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void clickButton(By locator) {
        log.info("Кликаем по элементу: {}", locator);
        WebElement element = elementToBeClickable(locator);
        element.click();

    }

    /**
     * МЕТОДЫ ПОЛУЧЕНИЯ ДАННЫХ.
     */
    public String getText(By locator) {
        log.debug("Получаем текст из элемента: {}", locator);
        WebElement element = visibilityOfElementLocated(locator);
        log.debug("Получен текстЖ {}", element.getText());
        return element.getText();
    }
}
