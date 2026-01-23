package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LanguageSelectComponent extends BasePage {
    /**
     * Конструктор.
     */
    public LanguageSelectComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * ЛОКАТОРЫ
     */
    private final By langButton = By.cssSelector("[data-id='dropLang']");
    private final By languageButtonText = By.cssSelector("[data-id='dropLang'] .footer-settings__text");
    private By langButtonByCode(String langCode) {
        return By.cssSelector("a[data-id='" + langCode + "']");
    }

    /**
     * МЕТОДЫ ДЕЙСТВИЙ
     */
    private void clickLanguageButton() {
        elementToBeClickable(langButton);
        clickButton(langButton);
    }

    private void clickLanguage(String langCode) {
        elementToBeClickable(langButtonByCode(langCode));
        clickButton(langButtonByCode(langCode));
    }

    /**
     *КОМПОЗИТНЫЕ МЕТОДЫ
     */
    public void selectLanguage(String langCode) {
        clickLanguageButton();
        clickLanguage(langCode);
    }

    /**
     *МЕТОДЫ ПРОВЕРОК
     */
    public String getLanguageButtonText() {
        visibilityOfElementLocated(languageButtonText);
        return getText(languageButtonText);
    }
}
