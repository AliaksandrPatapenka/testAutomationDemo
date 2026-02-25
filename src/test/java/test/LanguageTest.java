package test;

import base.TestBase;
import base.TestData;
import org.junit.jupiter.api.*;
import page.LanguageSelectComponent;
import static io.qameta.allure.Allure.step;


/**
 * Язык интерфейса. Тесты
 */
public class LanguageTest extends TestBase {
    private LanguageSelectComponent languageSelectComponent;

    private void selectLanguage(String language, String expectedTextLanguage){
        step("Нажимаем кнопку, открывающую форму с доступными языками", () ->
            languageSelectComponent.selectLanguage(language));
        String actualText = step("Получаем текст кнопки после выбора", () ->
                 languageSelectComponent.getLanguageButtonText()
        );
        step("Проверяем, что язык изменился на " + expectedTextLanguage, () ->
            Assertions.assertEquals(expectedTextLanguage, actualText, "❌ Язык не совпадает с выбранным"));

    }

    @BeforeEach
    public void setupTest() {
        setUp();
        languageSelectComponent = new LanguageSelectComponent(driver);
        languageSelectComponent.openTestPage(TestData.LOGIN_URL);
    }

    @AfterEach
    public void tearDownTest(){
        tearDown();
    }

    /**
     * Case1.1 <br>
     * 1. Нажимаем на кнопку, открывающую форму со списком доступных локализаций<br>
     * 2. Нажимаем кнопку выбора английской локализации<br>
     */
    @Test
    @DisplayName("Case1.1: Выбор локализации ENG ")
    //@Step("Выбор языка {language}")
    public void selectLanguageEng(){
        step("Выбрали " + TestData.EXPECTED_TEXT_LANGUAGE_ENG + " язык", () ->
                selectLanguage(TestData.LANGUAGE_CODE_ENG, TestData.EXPECTED_TEXT_LANGUAGE_ENG));
    }

    /**
     * Case 1.2<br>
     * 1. Нажимаем на кнопку, открывающую форму со списком доступных локализаций<br>
     * 2. Нажимаем кнопку выбора русской локализации<br>
     */
    @Test
    @DisplayName("Case 1.2: Выбор локализации RUS")
    //@Step("Выбор языка {language}")
    public void selectLanguageRus(){
        step ("Выбрали " + TestData.EXPECTED_TEXT_LANGUAGE_RUS + " язык", () ->
                selectLanguage(TestData.LANGUAGE_CODE_RUS, TestData.EXPECTED_TEXT_LANGUAGE_RUS));
    }
}
