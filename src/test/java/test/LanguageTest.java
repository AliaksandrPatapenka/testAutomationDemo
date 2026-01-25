package test;

import base.TestBase;
import base.TestData;
import org.junit.jupiter.api.*;
import page.LanguageSelectComponent;

public class LanguageTest extends TestBase {
    private LanguageSelectComponent languageSelectComponent;

    private void selectLanguage(String language, String expectedTextLanguage){
        languageSelectComponent.selectLanguage(language);
        String actualText = languageSelectComponent.getLanguageButtonText();
        Assertions.assertEquals(expectedTextLanguage, actualText, "Язык не совпадает с выбранным");
    }

    @BeforeEach
    public void setupTest() {
        setUp();
        languageSelectComponent = new LanguageSelectComponent(driver);
        languageSelectComponent.openTestPage(TestData.LOGIN);
    }

    @AfterEach
    public void tearDownTest(){
        tearDown();
    }

    /**
     * Case1.1
     * 1. Нажимаем на кнопку, открывающую форму со списком доступных локализаций
     * 2. Нажимаем кнопку выбора английской локализации
     */
    @Test
    @DisplayName("Выбор локализации ENG ")
    public void selectLanguageEng(){
        selectLanguage(TestData.LANGUAGE_ENG, TestData.EXPECTED_TEXT_LANGUAGE_ENG);
    }

    /**
     * Case 1.2
     * 1. Нажимаем на кнопку, открывающую форму со списком доступных локализаций
     * 2. Нажимаем кнопку выбора русской локализации
     */
    @Test
    @DisplayName("Выбор локализации РУС")
    public void selectLanguageRus(){
        selectLanguage(TestData.LANGUAGE_RUS, TestData.EXPECTED_TEXT_LANGUAGE_RUS);
    }
}
