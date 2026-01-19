package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    //ЛОКАТОРЫ
    /**
     * Локатор поля для ввода логина.
     */
    private final By usernameField = By.name("login");
    /**
     * Локатор поля для ввода пароля.
     */
    private final By passwordField = By.name("password");
    /**
     * Локатор кнопки авторизации.
     */
    private final By loginButton = By.cssSelector(".sign-in__button.j-button-submit");
    /**
     * Локатор кнопки раскрытия списка доступных языков.
     */
    private final By langButton = By.id("language-flag");
    /**
     * Возвращает локатор кнопки выбора языка по его коду.
     *
     * @param langCode код языка (например, "en", "ru")
     * @return локатор By для выбранного языка
     */
    private By langButtonByCode(String langCode) {
        return By.cssSelector("a[data-id='" + langCode + "']");
    }
    /**
     * Локатор ссылки в подвале страницы (пользовательское соглашение).
     */
    private final By footerLink = By.className("footer__link");

    //КОНСТРУКТОР
    /**
     * Конструктор страницы авторизации.
     *
     * @param driver экземпляр WebDriver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //МЕТОДЫ ДЕЙСТВИЙ
    /**
     * Открывает страницу входа в приложение.
     * В случае ошибки соединения выводит сообщение в консоль.
     */
    public void open() {
        try {
            driver.get(BASE_URL + "/login");
            waitPage();
        } catch (Exception e) {
            System.out.println("❌ Сервер не отвечает");
        }
    }

    /**
     * Вводит логин в соответствующее поле.
     *
     * @param username логин пользователя
     */
    private void enterUsername(String username) {
        enterText(usernameField, username);
    }

    /**
     * Вводит пароль в соответствующее поле.
     *
     * @param password пароль пользователя
     */
    private void enterPassword(String password) {
        enterText(passwordField, password);
    }

    /**
     * Нажимает кнопку авторизации.
     */
    private void clickLoginButton() {
        clickButton(loginButton);
    }

    /**
     * Нажимает кнопку раскрытия списка языков.
     */
    private void clickLanguageButton() {
        clickButton(langButton);
    }

    /**
     * Выбирает язык интерфейса по коду.
     *
     * @param langCode код языка для выбора
     */
    private void clickLanguage(String langCode) {
        clickButton(langButtonByCode(langCode));
    }

    /**
     * Нажимает ссылку в подвале страницы (пользовательское соглашение).
     */
    public  void  clickFooterLink() {
        clickButton(footerLink);
    }

    //КОМПОЗИТНЫЕ МЕТОДЫ
    /**
     * Выполняет авторизацию пользователя.
     *
     * @param username логин пользователя
     * @param password пароль пользователя
     */
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    /**
     * Выбирает язык интерфейса.
     *
     * @param langCode код языка для выбора
     */
    public void selectLanguage(String langCode) {
        clickLanguageButton();
        clickLanguage(langCode);
    }

    //МЕТОДЫ ПРОВЕРОК
    /**
     * Ожидает готовности страницы к взаимодействию.
     * Ожидает, пока поля логина, пароля и кнопка авторизации станут кликабельными.
     */
    public void waitPage() {
        wait.until(ExpectedConditions.and(
                ExpectedConditions.elementToBeClickable(usernameField),
                ExpectedConditions.elementToBeClickable(passwordField),
                ExpectedConditions.elementToBeClickable(loginButton)));
    }

    public String getText() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(langButton));
        return element.getAttribute("class");
    }

}
