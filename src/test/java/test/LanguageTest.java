package test;

import base.TestBase;
import base.TestData;
import org.junit.jupiter.api.*;
import page.LanguageSelectComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




/**
 * Язык интерфейса. Тесты
 */
public class LanguageTest extends TestBase {
    private LanguageSelectComponent languageSelectComponent;
    private static final Logger log = LoggerFactory.getLogger(LanguageTest.class);

    private void selectLanguage(String language, String expectedTextLanguage){
        log.info("Нажимаем кнопку, открывающую форму с доступными языками: {}", language);
        languageSelectComponent.selectLanguage(language);
        log.info("✅ Язык выбран, получаем текст кнопки");
        String actualText = languageSelectComponent.getLanguageButtonText();
        log.info(" Ожидаемый текст: {}, Фактический текст: {}", actualText, expectedTextLanguage);
        Assertions.assertEquals(expectedTextLanguage, actualText, " ❌ Язык не совпадает с выбранным");
        log.info("✅ Проверка выбора языка прошла успешно");
    }

    @BeforeEach
    public void setupTest() {
        log.info("Начало настройки тестов");
        setUp();
        languageSelectComponent = new LanguageSelectComponent(driver);
        languageSelectComponent.openTestPage(TestData.LOGIN_URL);
        log.info("✅ Страница открыта, тесты готовы к выполнению");
    }

    @AfterEach
    public void tearDownTest(){
        log.info("Завершение тестов. Очистка ресурсов");
        tearDown();
    }

    /**
     * Case1.1 <br>
     * 1. Нажимаем на кнопку, открывающую форму со списком доступных локализаций<br>
     * 2. Нажимаем кнопку выбора английской локализации<br>
     */
    @Test
    @DisplayName("Case1.1: Выбор локализации ENG ")
    public void selectLanguageEng(){
        log.info("=== Case1.1: Выбор английской локализации ===");
        selectLanguage(TestData.LANGUAGE_ENG, TestData.EXPECTED_TEXT_LANGUAGE_ENG);
        log.info("✅ Тест завершен успешно");
    }

    /**
     * Case 1.2<br>
     * 1. Нажимаем на кнопку, открывающую форму со списком доступных локализаций<br>
     * 2. Нажимаем кнопку выбора русской локализации<br>
     */
    @Test
    @DisplayName("Case 1.2: Выбор локализации RUS")
    public void selectLanguageRus(){
        log.info("=== Case 1.2: Выбор русской локализации ===");
        selectLanguage(TestData.LANGUAGE_RUS, TestData.EXPECTED_TEXT_LANGUAGE_RUS);
        log.info("✅ Тест завершен успешно");
    }
}
