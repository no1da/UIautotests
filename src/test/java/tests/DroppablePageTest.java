package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.DroppablePage;

/**
 * Тестовый класс для проверки функциональности Drag&Drop на странице, реализованной через Page Object Model (POM).
 * Использует JUnit 5 для написания тестов.
 */
public class DroppablePageTest {
    protected DroppablePage droppablePage;
    protected WebDriver driver;

    /**
     * Метод, выполняющий предварительные настройки перед каждым тестом.
     * Включает:
     * - Инициализацию WebDriver (в данном случае используем ChromeDriver).
     * - Создание экземпляра pages.DroppablePage.
     * - Открытие веб-страницы.
     * - Увеличение окна браузера на весь экран.
     */
    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();
        droppablePage = new DroppablePage(driver);
        driver.manage().window().maximize();
        driver.get("https://way2automation.com/way2auto_jquery/droppable.php#load_box");
    }
    /**
     * Тест для проверки функциональности Drag&Drop.
     * Включает:
     * - Перетаскивание элемента draggable в область droppable.
     * - Проверку текста в droppable элементе на соответствие "Dropped!".
     */
    @Test
    public void testDragAndDrop() {
        droppablePage.dragAndDrop();
        Assertions.assertEquals("Dropped!", droppablePage.getDroppableText());
    }

    /**
     * Метод, выполняющий очистку после выполнения каждого теста.
     * Закрытие браузера для освобождения ресурсов.
     */
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}

