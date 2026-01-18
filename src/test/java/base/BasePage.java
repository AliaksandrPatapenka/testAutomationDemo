package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    public static final String BASE_URL = System.getProperty("base.url", "http://localhost:5001"); //по дефолту http://localhost:5001. base.url - константа для изменения площадки
    protected WebDriver driver;
    protected WebDriverWait wait;

    //ОЖИДАНИЯ И ЗАДЕРЖКИ
    static final int DEFAULT_TIMEOUT_SECONDS = 10;

    protected WebElement elementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    } //Явное ожидание, элемент кликабелен

    //КОНСТРУКТОР
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
    }

    //ДЕЙСТВИЯ
    protected void enterText(By locator, String text) {
        WebElement element = elementToBeClickable(locator);
        element.clear();
        element.sendKeys(text);
    } //Вод текста

    protected void clickButton(By locator) {
        WebElement element = elementToBeClickable(locator);
        element.click();
    } //Нажатие на кнопку
}
