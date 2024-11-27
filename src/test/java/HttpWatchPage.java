import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
/**
 * Класс HttpWatchPage реализует Page Object Model (POM) для взаимодействия с веб-страницей HttpWatch.
 *
 * Этот класс инкапсулирует логику работы с элементами страницы:
 * кнопкой отображения изображения и самим изображением.
 *
 * Основной функционал включает:
 * - Клик по кнопке, чтобы запустить процесс отображения изображения.
 * - Ожидание и проверка на доступность объекта изображения на странице.
 */
public class HttpWatchPage {
    private WebDriverWait wait;
    private WebDriver driver;
    @FindBy(xpath = "//*[@id=\"displayImage\"]")
    private WebElement buttonImage;
    @FindBy(xpath = "//*[@id=\"downloadImg\"]")
    private WebElement image;
    /**
     * Конструктор класса HttpWatchPage.
     *
     * Выполняет инициализацию элементов страницы с использованием PageFactory
     * и задаёт настройки для явного ожидания.
     *
     * @param driver WebDriver, используемый для управления браузером.
     */
    public HttpWatchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Клик по кнопке "Display Image" с помощью метода WebElement.
     *
     * Метод используется для инициирования действия нажатия на кнопку, отображающую изображение.
     */
    public void clickButtonImage() {
        buttonImage.click();
    }
    /**
     * Проверка доступности изображения на странице.
     *
     * Метод ожидает, пока изображение станет видимым,
     * а затем возвращает результат проверки видимости элемента.
     *
     * @return true, если изображение отображается на странице, иначе false.
     */
    public boolean findImage() {
        wait.until(ExpectedConditions.visibilityOf(image));
        return image.isDisplayed();
    }
}
