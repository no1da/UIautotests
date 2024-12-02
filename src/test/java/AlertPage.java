import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * Класс-страница для работы с функциональностью модальных окон на веб-странице.
 * Реализует доступ к элементам страницы с использованием PageFactory и взаимодействия
 * с alert (JavaScript-всплывающими окнами) через WebDriver.
 */
public class AlertPage {
    private WebDriver driver;

    @FindBy(xpath = "//a[text()='Input Alert']")
    private WebElement buttonInputAlert;
    @FindBy(xpath = "//*[@id=\"example-1-tab-2\"]//iframe[@class='demo-frame']")
    private WebElement iframe;
    @FindBy(xpath = "//button[@onclick='myFunction()']")
    private WebElement buttonClick;
    @FindBy(xpath = "//*[@id='demo']")
    private WebElement messageBox;

    /**
     * Конструктор страницы AlertPage.
     * Инициализирует элементы страницы с использованием PageFactory.
     *
     * @param driver веб-драйвер, используемый для взаимодействия с браузером.
     */
    public AlertPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    /**
     * Переключает контекст WebDriver'а на iframe, чтобы получить доступ
     * к вложенному содержимому, включая элементы iframe.
     */
    public AlertPage switchToFrame() {
        driver.switchTo().frame(iframe);
        return this;
    }
    /**
     * Нажимает на кнопку "Input Alert", чтобы перейти к функциональности,
     * связанной с alert (всплывающими окнами).
     */
    public AlertPage clickButtonInputAlert() {
        buttonInputAlert.click();
        return this;
    }
    /**
     * Нажимает кнопку, которая вызывает JavaScript prompt-окно.
     */
    public AlertPage clickButtonClick() {
        buttonClick.click();
        return this;
    }
    /**
     * Взаимодействует с JavaScript-alert (prompt) окном.
     * Вводит текст в поле ввода окна и нажимает кнопку "OK" для подтверждения действия.
     */
    public AlertPage alertAccept() {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Snape");
        alert.accept();
        return this;
    }
    /**
     * Возвращает текст из элемента, который отображает результат взаимодействия
     * с модальным окном (prompt).
     *
     * @return текст, отображаемый в элементе messageBox.
     */
    public String getMessageBoxText() {
        return messageBox.getText();
    }
}
