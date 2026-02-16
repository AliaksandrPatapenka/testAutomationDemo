package test;

import base.TestBase;
import base.TestData;
import org.junit.jupiter.api.*;
import page.LoginPage;
import static io.qameta.allure.Allure.step;

/**
 * Авторизация. Тесты
 */
public class LoginTest extends TestBase {
    private LoginPage loginPage;

    private void auth(String userLogin, String userPassword, String expectedText, boolean isSuccess) {
            loginPage.login(userLogin, userPassword);
            String actualText;
            if (isSuccess){
                actualText = loginPage.getAuthSuccess();
            } else {
                actualText = loginPage.getAuthInvalid();
            }// если true, то успешная авторизация.
            Assertions.assertEquals(expectedText, actualText, "Нет нужного текста");
    }

    @BeforeEach
    public void  setUpTest(){
        step("Запустили браузер", this::setUp);
        step("Создали драйвер",() -> loginPage = new LoginPage(driver));
        step("Открыли страницу авторизации",() -> loginPage.openPageLogin());
    }

    @AfterEach
    public void tearDownTest(){
        step("Закрыли браузер", this::tearDown);

    }

    /**
     * Case2.1<br>
     * 1. Вводим логин пользователя, которого нет в базе данных<br>
     * 2. Вводим пароль любого существующего пользователя<br>
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Case 2.1: Проверка авторизации с невалидным логином")
    public void authInvalidLogin() {
        step("Авторизация по логину: " + TestData.INVALID_LOGIN + " и паролю: " + TestData.USER_PASSWORD,() ->{
            auth(TestData.INVALID_LOGIN, TestData.USER_PASSWORD, TestData.EXPECTED_TEXT_AUTH_INVALID, false);
        });
    }

    /**
     * Case2.2<br>
     * 1. Вводим логин пользователя(Пользователь: активен, не удален. Логин валидный)<br>
     * 2. Вводим неверный пароль пользователя<br>
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Case 2.2: Проверка авторизации с невалидным паролем")
    public void authInvalidPassword() {
        step("Авторизация по логину: " + TestData.USER_LOGIN + " и паролю: " + TestData.INVALID_PASSWORD,() ->{
            auth(TestData.USER_LOGIN, TestData.INVALID_PASSWORD, TestData.EXPECTED_TEXT_AUTH_INVALID, false);
        });
    }

    /**
     * Case2.3<br>
     * 1. Вводим логин пользователя, которого нет в базе данных<br>
     * 2. Вводим неверный пароль пользователя<br>
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Case 2.3: Проверка авторизации с некорректными логином и паролем")
    public void authInvalidLoginPassword(){
        step("Авторизация по логину: " + TestData.INVALID_LOGIN + " и паролю: " + TestData.INVALID_PASSWORD,() ->{
            auth(TestData.INVALID_LOGIN, TestData.INVALID_PASSWORD, TestData.EXPECTED_TEXT_AUTH_INVALID, false);
        });
    }

    /**
     * Case2.4<br>
     * 1. Вводим логин пользователя(Пользователь: активен, не удален. Логин валидный)<br>
     * 2. Вводим пароль пользователя(Пользователь: активен, не удален. Пароль: валидный)<br>
     * 3. Нажимаем на кнопку "Войти"
     */
    @Test
    @DisplayName("Case 2.4: Проверка успешной авторизации")
    public void authSuccess(){
        step("Авторизация по логину: " + TestData.USER_LOGIN + " и паролю: " + TestData.USER_PASSWORD,() ->{
            auth(TestData.USER_LOGIN, TestData.USER_PASSWORD, TestData.EXPECTED_TEXT_AUTH, true);
        });
    }
}
