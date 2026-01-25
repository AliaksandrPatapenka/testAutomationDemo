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
     * ТЕСТЫ
     */
    @Test
    @DisplayName("Выбор локализации ENG ")
    public void selectLanguageEng(){
        selectLanguage(TestData.LANGUAGE_ENG, TestData.EXPECTED_TEXT_LANGUAGE_ENG);
    }

    @Test
    @DisplayName("Выбор локализации РУС")
    public void selectLanguageRus(){
        selectLanguage(TestData.LANGUAGE_RUS, TestData.EXPECTED_TEXT_LANGUAGE_RUS);
    }
}
