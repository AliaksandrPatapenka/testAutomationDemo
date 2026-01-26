package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Компонент для выбора языка интерфейса. Элементы и действия
 */
public class LanguageSelectComponent extends BasePage {
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
    private  final By spinner = By.cssSelector("[id='spinner_overlay_page']");

    /**
     * МЕТОДЫ ДЕЙСТВИЙ
     */

    public void openTestPage(String path) {
        openPage(path);
    }

    private void clickLanguageButton() {
        invisibilityOfElementLocated(spinner);
        try {
            Thread.sleep(1000); // 800 мс
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
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
