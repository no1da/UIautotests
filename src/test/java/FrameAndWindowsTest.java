import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Тестовый класс FrameAndWindowsTest выполняет автоматизированное тестирование функциональности
 * открытия ссылок в новых вкладках (tabs) на веб-странице в соответствии с механизмом Selenium WebDriver.
 */
public class FrameAndWindowsTest {
    private static final String BASE_URL = "https://way2automation.com/way2auto_jquery/frames-and-windows.php#load_box";
    private static final String EXPECTED_PAGE_TITLE = "jQuery UI Datepicker - Default functionality";
    private static final int EXPECTED_TAB_COUNT = 3;
    private static final int SECOND_TAB_INDEX = 1;
    private static final int THIRD_TAB_INDEX = 2;
    private WebDriver driver;
    private FramesAndWindowsPages framesAndWindowsPages;
    private TabsHelper tabsHelper;

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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        framesAndWindowsPages = new FramesAndWindowsPages(driver);
        tabsHelper = new TabsHelper(driver);
        driver.get(BASE_URL);
    }

    /**
     * Тест проверяет открытие нескольких вкладок (tabs) и корректность переключения между ними.
     *
     * Шаги:
     * 1. Нажать на ссылку для открытия новой вкладки.
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
        framesAndWindowsPages.blankClick()
                .blankClickWithoutFrame();

        tabsHelper.updateTabs();
        tabsHelper.switchToTab(SECOND_TAB_INDEX);

        tabsHelper.updateTabs();
        assertEquals(EXPECTED_TAB_COUNT, tabsHelper.getTabCount(), "Количество вкладок не равно трём");

        tabsHelper.switchToTab(THIRD_TAB_INDEX);
        assertEquals(EXPECTED_PAGE_TITLE, driver.getTitle(), "Заголовок третьей вкладки не совпадает.");
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
