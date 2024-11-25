import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Тестовый класс FrameAndWindowsTest выполняет автоматизированное тестирование функциональности
 * открытия ссылок в новых вкладках (tabs) на веб-странице в соответствии с механизмом Selenium WebDriver.
 */
public class FrameAndWindowsTest {
    private WebDriver driver;
    private FramesAndWindowsPages framesAndWindowsPages;
    /**
     * Настройка браузера перед выполнением каждого теста (@BeforeEach).
     * Инициализирует драйвер ChromeDriver, подключает объект FramesAndWindowsPages
     * и переходит на начальную веб-страницу.
     *
     * @see FramesAndWindowsPages
     */
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        framesAndWindowsPages = new FramesAndWindowsPages(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://way2automation.com/way2auto_jquery/frames-and-windows.php#load_box");
    }
    /**
     * Тест проверяет открытие нескольких вкладок (tabs) и корректность переключения между ними.
     *
     * Шаги:
     * 1. Переключиться на iframe, содержащий ссылку.
     * 2. Нажать на ссылку для открытия новой вкладки.
     * 3. Переключиться на вторую вкладку и нажать на ещё одну ссылку.
     * 4. Проверить, что открылось три вкладки.
     * 5. Убедиться, что заголовок третьей вкладки соответствует ожидаемому значению.
     *
     * Ассерты:
     * - Проверить, что количество вкладок равно 3.
     * - Проверить, что заголовок третьей вкладки совпадает с "jQuery UI Datepicker - Default functionality".
     *
     * @throws AssertionError если условие ассертов не выполняется.
     */
    @Test
    public void testMultipleTabs() {
        framesAndWindowsPages.switchToFrame();
        framesAndWindowsPages.blankClick();

        Set<String> windowHandles = driver.getWindowHandles();
        ArrayList<String> tabs = new ArrayList<>(windowHandles);

        driver.switchTo().window(tabs.get(1));
        framesAndWindowsPages.blankClick();

        windowHandles = driver.getWindowHandles();
        tabs = new ArrayList<>(windowHandles);

        assertEquals(3, tabs.size(), "Количество вкладок не равно трем");

        driver.switchTo().window(tabs.get(2));
        String expectedPageTitle = "jQuery UI Datepicker - Default functionality";
        assertEquals(expectedPageTitle, driver.getTitle(), "Заголовок третьей вкладки не совпадает.");
    }
    /**
     * Закрытие браузера после выполнения каждого теста (@AfterEach).
     *
     * WebDriver (браузер) завершает свою работу и освобождает ресурсы.
     */
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
