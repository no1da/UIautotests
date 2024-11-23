package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
/**
 * Класс WayPageNavigationBlock расширяет функциональность класса WayPage,
 * предоставляя методы для взаимодействия с навигационным блоком страницы.
 * Этот класс включает методы, которые позволяют пользователю перемещаться
 * по меню и выбирать различные курсы.
 */
public class WayPageNavigationBlock extends WayPage {
    @FindBy(xpath = "//*[@id=\"menu-item-27580\"]/a/span[2]")
    private WebElement allCourses;
    @FindBy(xpath = "//*[@id=\"menu-item-27581\"]/a")
    private WebElement linkLifeTime;
    @FindBy(xpath = "//*[@id=\"menu-item-27581\"]/a/span[2]")
    private WebElement textLifeTime;
    /**
     * Конструктор класса WayPageNavigationBlock.
     * Инициализирует веб-драйвер, унаследованный от класса WayPage.
     *
     * @param driver объект WebDriver для управления браузером.
     */
    public WayPageNavigationBlock(WebDriver driver) {
        super(driver);
    }
    /**
     * Метод для навигации к разделу "Пожизненный доступ".
     * Данный метод перемещается к элементу "Все курсы",
     * задерживает выполнение до его видимости,
     * затем перемещается к элементу "Пожизненный доступ" и кликает на него.
     */
    public void goToLifeTime() {
        wait.until(ExpectedConditions.visibilityOf(allCourses));
        Actions action = new Actions(driver);
        action.moveToElement(allCourses).perform();
        wait.until(ExpectedConditions.visibilityOf(linkLifeTime));
        action.moveToElement(linkLifeTime).click().perform();
    }
}
