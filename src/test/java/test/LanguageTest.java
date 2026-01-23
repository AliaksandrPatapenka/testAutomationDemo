package test;

import base.TestBase;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import page.LanguageSelectComponent;

public class LanguageTest extends TestBase {
    private LanguageSelectComponent languageSelectComponent;

    /**
     * ДЕЙСТВИЯ ПЕРЕД НАЧАЛОМ И ПОСЛЕ ОКОНЧАНИЯ ТЕСТОВ
     */
    @BeforeEach
    public void setupTest() {
        setUp();
        languageSelectComponent = new LanguageSelectComponent(driver);
    }

    @AfterEach
    public void tearDownTest(){
        tearDown();
    }
}
