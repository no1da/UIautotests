package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthSQLPage;
import utils.CookieManager;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuthTestTestNG extends BaseTestTestNG {
    private final String cookiesFilePath = "cookies.txt";
    /**
     * Метод инициализации, выполняемый перед каждым тестом.
     * Создает новый экземпляр WebDriver, открывает браузер,
     * настраивает его и переходит на целевой URL, определенный в конфигурации.
     */
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        authSQLPage = new AuthSQLPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(config.getProperty("auth.url"));
    }
    /**
     * Тест для проверки процесса авторизации с использованием учетных данных.
     * Заполняет поля авторизации и сохраняет куки, затем проверяет,
     * что авторизация прошла успешно, проверяя наличие имени пользователя.
     */
    @Test
    public void testLogin() {
        authSQLPage
                .enterLogin(config.getProperty("login"))
                .enterPassword(config.getProperty("password"))
                .submit();

        CookieManager.saveCookies(driver, cookiesFilePath);
        assertTrue(authSQLPage.findUsername());
    }
    /**
     * Тест для проверки процесса авторизации с использованием сохраненных куков.
     * Загружает куки, обновляет страницу и проверяет,
     * что авторизация прошла успешно, проверяя наличие имени пользователя.
     */
    @Test
    public void testLoginWithCookies() {
        CookieManager.loadCookies(driver, cookiesFilePath);
        driver.navigate().refresh();
        assertTrue(authSQLPage.findUsername());
    }
}
