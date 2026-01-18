package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    //Локаторы
    private final By usernameField = By.name("login"); //Поле Логин
    private final By passwordField = By.name("password"); //Поле Пароль
    private final By loginButton = By.cssSelector(".sign-in__button.j-button-submit"); //Кнопка авторизации
    private final By langButton = By.id("language-flag"); //Кнопка раскрытия формы с доступными языками
    private By langButtonByCode(String langCode) {
        return By.cssSelector("a[data-id='" + langCode + "']");
    } //Метод извлечения доступных локализаций
    private final By footerLink = By.className("footer__link"); //Кнопка открытия пользовательского соглашения

    //КОНСТРУКТОР
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //МЕТОДЫ ДЕЙСТВИЙ
    public void open() {
        driver.get(BASE_URL + "/login");
        waitPage();
    }//Открываем  тестируемую страницу

    private void enterUsername(String username) {
        enterText(usernameField, username);
    }//Вводим логин

    private void enterPassword(String password) {
        enterText(passwordField, password);
    }//Вводим пароль

    private void clickLoginButton() {
        clickButton(loginButton);
    }//Нажимаем на кнопку Авторизации

    private void clickLanguageButton() {
        clickButton(langButton);
    }//Нажатие на элемент раскрытия формы с доступными локализациями

    private void clickLanguage(String langCode) {
        clickButton(langButtonByCode(langCode));
    }//Нажатие на кнопку нужной локализации

    public  void  clickFooterLink() {
        clickButton(footerLink);
    }//Нажимаем на кнопку открытия формы пользовательского соглашения

    //КОМПОЗИТНЫЕ МЕТОДЫ
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }//Авторизация

    public void selectLanguage(String langCode) {
        clickLanguageButton();
        clickLanguage(langCode);
    } //Выбор локализации

    //МЕТОДЫ ПРОВЕРОК
    public void waitPage() {
        wait.until(ExpectedConditions.and(
                ExpectedConditions.elementToBeClickable(usernameField),
                ExpectedConditions.elementToBeClickable(passwordField),
                ExpectedConditions.elementToBeClickable(loginButton)));
    }//Поля Логин и Пароль, кнопка авторизации становятся кликабельны
}
