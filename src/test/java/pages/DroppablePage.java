package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Класс pages.DroppablePage представляет страницу, где выполняются действия с элементами
 * drag-and-drop в рамках iframe. Реализован с использованием Page Object Model (POM).
 */
public class DroppablePage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"draggable\"]")
    private WebElement draggableElement;
    @FindBy(xpath = "//*[@id=\"droppable\"]")
    private WebElement droppableElement;
    @FindBy(xpath = "//*[@id=\"example-1-tab-1\"]//iframe[@class='demo-frame']")
    private WebElement frameElement;
    /**
     * Конструктор класса.
     * Инициализирует элементы на странице с помощью PageFactory.
     *
     * @param driver WebDriver для управления браузером.
     */
    public DroppablePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }
    /**
     * Переключает контекст WebDriver на iframe, внутри которого находятся элементы.
     */
    public void switchToFrame() {
        driver.switchTo().frame(frameElement);
    }
    /**
     * Выполняет действие drag-and-drop.
     * Захватывает элемент draggable, перетаскивает его к элементу droppable и отпускает.
     */
    public void dragAndDrop() {
        switchToFrame();
        Actions actions = new Actions(driver);
        actions.clickAndHold(draggableElement)
                .moveToElement(droppableElement)
                .release()
                .build()
                .perform();
    }
    /**
     * Получает текст из элемента droppable.
     *
     * @return Текст, отображаемый в droppable элементе (например, "Dropped!").
     */
    public String getDroppableText() {
        return droppableElement.getText();
    }
}
