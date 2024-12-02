import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
/**
 * Класс FramesAndWindowsPages реализует логику взаимодействия с веб-страницей "Frames and Windows".
 */
public class FramesAndWindowsPages {
    private WebDriver driver;
    @FindBy(xpath = "//*[@id=\"example-1-tab-1\"]//iframe[@class='demo-frame']")
    private WebElement frameElement;
    @FindBy(xpath = "//a[@target=\"_blank\"]")
    private WebElement blank;
    private WebDriverWait wait;
    /**
     * Конструктор класса FramesAndWindowsPages.
     * Инициализирует элементы страницы с помощью PageFactory и задаёт объект WebDriverWait.
     *
     * @param driver У экземпляра WebDriver должно быть активное окно браузера.
     */
    public FramesAndWindowsPages(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    /**
     * Метод, переключающий фокус WebDriver на iframe.
     *
     * @return текущий экземпляр FramesAndWindowsPages для поддержки Fluent Interface.
     */
    public FramesAndWindowsPages switchToFrame() {
        driver.switchTo().frame(frameElement);
        return this;
    }

    /**
     * Метод для нажатия на ссылку, которая открывает новую вкладку/окно браузера.
     *
     * @return текущий экземпляр FramesAndWindowsPages для поддержки Fluent Interface.
     */
    public FramesAndWindowsPages blankClickWithoutFrame() {
        blank.click();
        return this;
    }

    /**
     * Метод для нажатия на ссылку в iframe.
     *
     * @return текущий экземпляр FramesAndWindowsPages для поддержки Fluent Interface.
     */
    public FramesAndWindowsPages blankClick() {
        switchToFrame();
        blank.click();
        return this;
    }

}
