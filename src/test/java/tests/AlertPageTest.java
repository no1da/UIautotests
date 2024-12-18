package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AlertPage;

import java.util.concurrent.TimeUnit;
/**
 * Класс для тестирования взаимодействия с alert (prompt) окнами на веб-странице.
 */
public class AlertPageTest {
    private WebDriver driver;
    private AlertPage alertPage;

    private static final String BASE_URL = "https://way2automation.com/way2auto_jquery/alert.php#load_box";
    private static final String EXPECTED_MESSAGE = "Hello Snape! How are you today?";
    /**
     * Инициализация браузера перед каждым тестом.
     * Этот метод:
     * - Создаёт экземпляр ChromeDriver,
     * - Инициализирует экземпляр pages.AlertPage,
     * - Настраивает ожидания и максимизирует окно браузера,
     * - Загружает тестируемую веб-страницу.
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        alertPage = new AlertPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }
    /**
     * Основной тест для проверки функциональности alert (prompt).
     * Действия, выполняемые в этом тесте:
     * - Переход к нужному разделу страницы с prompt (Input Alert),
     * - Переключение контекста в iframe,
     * - Отправка текста в prompt и подтверждение,
     * - Сравнение результата с ожидаемым сообщением.
     *
     * Ожидаемое поведение: отображение текста "Hello Snape! How are you today?" в элементе messageBox.
     */
    @Test
    public void testAlert() {
        alertPage.clickButtonInputAlert()
                .switchToFrame()
                .clickButtonClick()
                .alertAccept();

        Assertions.assertEquals(EXPECTED_MESSAGE, alertPage.getMessageBoxText(), "Сообщение не совпадает с ожидаемым.");
    }
    /**
     * Завершение работы в браузере после каждого теста.
     * Этот метод закрывает браузер и освобождает ресурсы.
     */
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
