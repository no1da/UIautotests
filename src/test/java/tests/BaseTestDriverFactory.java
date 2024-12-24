package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Epic;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import pages.WayPage;
import utils.Config;
import utils.DriverFactory;
import utils.ResultWatcher;

import java.net.MalformedURLException;

/**
 * Основной класс для тестирования главной страницы (https://www.way2automation.com/).
 * Этот класс предоставляет общие методики и настройки для тестов,
 * использующих Selenium WebDriver и страницу WayPage.
 */
@Epic("Testing Way2Automation Page")
public class BaseTestDriverFactory {
    static Config config;
    static WebDriver driver;
    static ResultWatcher resultWatcher;
    WayPage wayPage;

    public static WebDriver getDriver() {
        return driver;
    }

    /**
     * Инициализирует конфигурационные данные.
     * Выполняется один раз перед всеми тестами.
     */
    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        resultWatcher = new ResultWatcher();
        config = new Config();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
        );
    }

    /**
     * Метод инициализации, выполняемый перед каждым тестом.
     * Создает новый экземпляр WebDriver, открывает браузер,
     * настраивает его и переходит на целевой URL, определенный в конфигурации.
     */
    @BeforeEach
    public void setUp() throws MalformedURLException {
        String browser = config.getProperty("browser");
        String gridUrl = config.getProperty("grid.url");

        driver = DriverFactory.getDriver(browser, gridUrl);
        wayPage = new WayPage(driver);
        driver.manage().window().maximize();
        driver.get(config.getProperty("app.url"));
    }

    /**
     * Метод, выполняемый после каждого теста.
     * Закрывает браузер и освобождает используемые ресурсы.
     */
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

