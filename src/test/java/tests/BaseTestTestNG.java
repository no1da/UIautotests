package tests;

import io.qameta.allure.Epic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.PPWRegistrationPage;
import utils.Config;

import java.util.concurrent.TimeUnit;

/**
 * Основной класс для тестирования главной страницы (https://www.way2automation.com/).
 * Этот класс предоставляет общие методики и настройки для тестов,
 * использующих Selenium WebDriver и страницу WayPage.
 */
@Epic("Testing Way2Automation Page")
public class BaseTestTestNG {
    static Config config;
    static WebDriver driver;
    static PPWRegistrationPage ppwRegistrationPage;
    /**
     * Инициализирует конфигурационные данные.
     * Выполняется один раз перед всеми тестами.
     */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        config = new Config();
    }
    /**
     * Метод инициализации, выполняемый перед каждым тестом.
     * Создает новый экземпляр WebDriver, открывает браузер,
     * настраивает его и переходит на целевой URL, определенный в конфигурации.
     */
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        ppwRegistrationPage = new PPWRegistrationPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(config.getProperty("registration_url"));
    }
    /**
     * Метод, выполняемый после каждого теста.
     * Закрывает браузер и освобождает используемые ресурсы.
     */
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
