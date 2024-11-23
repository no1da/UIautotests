package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AuthSQLPage;
import utils.Config;
import utils.CookieManager;

import static org.junit.jupiter.api.Assertions.assertTrue;
@Epic("Authentication Module")
public class AuthTest {
    private final String cookiesFilePath = "cookies.txt";
    protected AuthSQLPage authSQLPage;
    protected WebDriver driver;
    protected Config config;

    /**
     * Метод инициализации, выполняемый перед каждым тестом.
     * Создает новый экземпляр WebDriver, открывает браузер,
     * настраивает его и переходит на целевой URL, определенный в конфигурации.
     */
    @BeforeEach
    @Step("Setting up the web driver and navigating to the authentication URL")
    public void setUp() {
        config = new Config();
        driver = new ChromeDriver();
        authSQLPage = new AuthSQLPage(driver);
        driver.manage().window().maximize();
        driver.get(config.getProperty("auth.url"));
    }
    /**
     * Тест для проверки процесса авторизации с использованием учетных данных.
     * Заполняет поля авторизации и сохраняет куки, затем проверяет,
     * что авторизация прошла успешно, проверяя наличие имени пользователя.
     */
    @Test
    @Feature("User Login")
    @Story("Login with credentials")
    @Severity(SeverityLevel.CRITICAL)
    public void testLogin() {
        authSQLPage.fillFieldsAuth(config.getProperty("login"), config.getProperty("password"));
        CookieManager.saveCookies(driver, cookiesFilePath);
        assertTrue(authSQLPage.findUsername());
    }
    /**
     * Тест для проверки процесса авторизации с использованием сохраненных куков.
     * Загружает куки, обновляет страницу и проверяет,
     * что авторизация прошла успешно, проверяя наличие имени пользователя.
     */
    @Test
    @Feature("User Login")
    @Story("Login using cookies")
    @Severity(SeverityLevel.NORMAL)
    public void testLoginWithCookies() {
        CookieManager.loadCookies(driver, cookiesFilePath);
        driver.navigate().refresh();
        assertTrue(authSQLPage.findUsername());
    }


    /**
     * Метод, выполняемый после каждого теста.
     * Закрывает браузер и освобождает используемые ресурсы.
     */
    @AfterEach
    @Step("Closing the web driver")
    public void tearDown() {
        driver.quit();
    }
}
