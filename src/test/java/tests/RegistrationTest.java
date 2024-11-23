package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.PPWRegistrationPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;


public class RegistrationTest {
    protected PPWRegistrationPage ppwRegistrationPage;
    protected WebDriver driver;
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
        driver.get("https://www.way2automation.com/angularjs-protractor/registeration/#/login");
    }
    /**
     * DataProvider для возвращения различных наборов данных для теста авторизации.
     *
     * @return массив объектов с данными для входа.
     */
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"angular", "password", "123"},
                {"angular1", "password", "123"},
                {"angular", "password1", "123"},
        };
    }
    /**
     * Тест авторизации с использованием различных данных, предоставленных DataProvider.
     *
     * @param username  Имя пользователя для входа.
     * @param password  Пароль для входа.
     * @param username1 Пароль для входа.
     */
    @Test(dataProvider = "loginData")
    public void testRegistration(String username, String password, String username1) {
        ppwRegistrationPage.fillFieldsLogin(username, password, username1);
        ppwRegistrationPage.clickLogin();
        boolean log = ppwRegistrationPage.findLogged();
        if (log) {
            assertTrue(log, ppwRegistrationPage.getTextAuthAllert());
        } else {
            assertTrue(log);
        }
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
