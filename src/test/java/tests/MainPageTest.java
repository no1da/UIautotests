package tests;

import io.qameta.allure.Epic;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.WayPage;
import utils.Config;
/**
 * Основной класс для тестирования главной страницы (https://www.way2automation.com/).
 * Этот класс предоставляет общие методики и настройки для тестов,
 * использующих Selenium WebDriver и страницу WayPage.
 */
@Epic("Testing Way2Automation Page")
public class MainPageTest {
    protected WayPage wayPage;
    protected WebDriver driver;
    protected Config config;
    /**
     * Метод инициализации, выполняемый перед каждым тестом.
     * Создает новый экземпляр WebDriver, открывает браузер,
     * настраивает его и переходит на целевой URL, определенный в конфигурации.
     */
    @BeforeEach
    public void setUp() {
        config = new Config();
        driver = new ChromeDriver();
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
        driver.quit();
    }
}
