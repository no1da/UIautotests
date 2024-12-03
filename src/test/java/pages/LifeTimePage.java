package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Waiter;

import java.time.Duration;

/**
 * Класс LifeTimePage представляет веб-страницу, связанную с отдельным разделом приложения.
 * Он используется для взаимодействия с элементами на странице жизни и управления проверкой их состояния.
 */
public class LifeTimePage {
    private WebDriver driver;
    private Waiter waiter;
    @FindBy(css = "article#post-25580 h1.elementor-heading-title.elementor-size-default")
    private WebElement header;

    /**
     * Конструктор класса LifeTimePage.
     * Инициализирует WebDriver, WebDriverWait и элементы страницы.
     *
     * @param driver объект WebDriver для управления браузером.
     */
    public LifeTimePage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new Waiter(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Получает текст заголовка страницы.
     * Перед получением текста заголовка метод ожидает, пока элемент не станет видимым.
     *
     * @return текст заголовка страницы.
     */
    public String getTextHeader() {
        waiter.waitForVisibility(header);
        return header.getText();
    }
}
