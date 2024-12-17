package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import pages.AuthSQLPage;
import pages.PPWRegistrationPage;
import utils.Config;

/**
 * Основной класс для тестирования
 * Этот класс предоставляет общие методики и настройки для тестов,
 * использующих Selenium WebDriver и страницу WayPage.
 */
public class BaseTestTestNG {
    static Config config;
    WebDriver driver;
    PPWRegistrationPage ppwRegistrationPage;
    AuthSQLPage authSQLPage;
    /**
     * Инициализирует конфигурационные данные.
     * Выполняется один раз перед всеми тестами.
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        config = new Config();
    }
    /**
     * Метод, выполняемый после каждого теста.
     * Закрывает браузер и освобождает используемые ресурсы.
     */
    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
