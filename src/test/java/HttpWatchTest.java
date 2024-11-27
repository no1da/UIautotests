import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * Класс HttpWatchTest тестирует взаимодействие с Basic Authentication на сайте HttpWatch
 * с использованием Selenium WebDriver и выполняет проверки элементов на странице.
 *
 * Основной сценарий:
 * 1. Открытие страницы без авторизации.
 * 2. Ввод логина и пароля через формат URL (Basic Authentication).
 * 3. Проверка, что защищённое содержимое доступно после авторизации.
 */
public class HttpWatchTest {
    protected HttpWatchPage httpWatchPage;
    protected WebDriver driver;
    protected String baseUrl;
    protected String url;
    protected String authUrl;
    protected String username;
    protected String password;
    /**
     * Метод setUp() выполняется перед каждым тестом.
     * На его этапе выполняется:
     * 1. Инициализация тестовых данных (URL, логина, пароля, страницы).
     * 2. Запуск ChromeDriver.
     * 3. Открытие страницы до выполнения теста.
     */
    @BeforeEach
    public void setUp() {
        baseUrl = "www.httpwatch.com/httpgallery/authentication/#showExample10";
        url = "http://www.httpwatch.com/httpgallery/authentication/#showExample10";
        username = "httpwatch";
        password = "httpwatch";
        authUrl = "http://" + username + ":" + password + "@" + baseUrl;
        driver = new ChromeDriver();
        httpWatchPage = new HttpWatchPage(driver);
        driver.manage().window().maximize();
        driver.get(url);
    }
    /**
     * Основной тест, проверяющий работу Basic Authentication и доступ к защищённым элементам страницы.
     *
     * Как выполняется тест:
     * 1. Клик по кнопке для загрузки изображения до авторизации.
     * 2. Выполнение авторизации через Basic Authentication (URL с логином и паролем).
     * 3. Повторный клик по кнопке для загрузки изображения.
     * 4. Проверка, доступно ли изображение после авторизации.
     */
    @Test
    public void testDragAndDrop() {
        httpWatchPage.clickButtonImage();
        driver.get(authUrl);
        httpWatchPage.clickButtonImage();
        Assertions.assertTrue(httpWatchPage.findImage());
    }

    /**
     * Метод tearDown() выполняется после каждого теста.
     * Выполняет завершающие действия:
     * - Закрытие браузера.
     */
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
