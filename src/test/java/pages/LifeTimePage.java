package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Класс LifeTimePage представляет веб-страницу, связанную с отдельным разделом приложения.
 * Он используется для взаимодействия с элементами на странице жизни и управления проверкой их состояния.
 */
public class LifeTimePage {
    protected WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//*[@id=\"post-25580\"]/div/div/section[1]/div[2]/div/div/div/div/h1")
    private WebElement header;
    /**
     * Конструктор класса LifeTimePage.
     * Инициализирует WebDriver, WebDriverWait и элементы страницы.
     *
     * @param driver объект WebDriver для управления браузером.
     */
    public LifeTimePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    /**
     * Получает текст заголовка страницы.
     * Перед получением текста заголовка метод ожидает, пока элемент не станет видимым.
     *
     * @return текст заголовка страницы.
     */
    @Step("Get the text from header")
    public String getTextHeader() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.getText();
    }
}
