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
public abstract class BasePage {
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

    //ОЖИДАНИЯ И ЗАДЕРЖКИ
    /**
     * Таймаут по умолчанию для явных ожиданий в секундах.
     */
    static final int DEFAULT_TIMEOUT_SECONDS = 10;

    /**
     * Ожидает, пока элемент станет кликабельным.
     *
     * @param locator локатор элемента
     * @return кликабельный WebElement
     */
    protected WebElement elementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    //КОНСТРУКТОР
    /**
     * Конструктор базовой страницы.
     *
     * @param driver экземпляр WebDriver
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT_SECONDS));
    }

    //ДЕЙСТВИЯ
    /**
     * Вводит текст в поле, найденное по локатору.
     * Перед вводом очищает поле.
     *
     * @param locator локатор текстового поля
     * @param text текст для ввода
     */
    protected void enterText(By locator, String text) {
        WebElement element = elementToBeClickable(locator);
        element.clear();
        element.sendKeys(text);
    }

    /**
     * Кликает по элементу, найденному по локатору.
     *
     * @param locator локатор элемента для клика
     */
    protected void clickButton(By locator) {
        WebElement element = elementToBeClickable(locator);
        element.click();
    }
}
