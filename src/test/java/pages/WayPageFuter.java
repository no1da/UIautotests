package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
/**
 * Класс WayPageFuter расширяет функциональность класса WayPage,
 * предоставляя методы для взаимодействия с элементами футера страницы.
 * Этот класс включает методы для получения контактной информации,
 * такой как адрес, номера телефонов и электронные почты.
 */
public class WayPageFuter extends WayPage {

    @FindBy(xpath = "//*[@id=\"page\"]/div[2]/div/section/div[2]/div/div/section[1]/div/div[4]/div/div[2]/div/ul/li[1]/span[2]")
    private WebElement futerAdress;
    @FindBy(xpath = "//*[@id=\"page\"]/div[2]/div/section/div[2]/div/div/section[1]/div/div[4]/div/div[2]/div/ul/li[2]/a/span[2]")
    private WebElement futerPhoneNumber1;
    @FindBy(xpath = "//*[@id=\"page\"]/div[2]/div/section/div[2]/div/div/section[1]/div/div[4]/div/div[2]/div/ul/li[3]/a/span[2]")
    private WebElement futerPhoneNumber2;
    @FindBy(xpath = "//*[@id=\"page\"]/div[2]/div/section/div[2]/div/div/section[1]/div/div[4]/div/div[2]/div/ul/li[4]/a/span[2]")
    private WebElement futerMail1;
    @FindBy(xpath = "//*[@id=\"page\"]/div[2]/div/section/div[2]/div/div/section[1]/div/div[4]/div/div[2]/div/ul/li[5]/a/span[2]")
    private WebElement futerMail2;
    /**
     * Конструктор класса WayPageFuter.
     * Инициализирует веб-драйвер, унаследованный от класса WayPage.
     *
     * @param driver объект WebDriver для управления браузером.
     */
    public WayPageFuter(WebDriver driver) {
        super(driver);
    }
    /**
     * Получает адрес из футера.
     * Включает ожидание видимости элемента адреса перед его извлечением.
     *
     * @return текст адреса из футера.
     */
    public String getFuterAdress() {
        wait.until(ExpectedConditions.visibilityOf(futerAdress));
        return futerAdress.getText();
    }
    /**
     * Получает первый номер телефона из футера.
     * Включает ожидание видимости элемента номера телефона перед его извлечением.
     *
     * @return текст первого номера телефона из футера.
     */
    public String getFuterPhoneNumber1() {
        wait.until(ExpectedConditions.visibilityOf(futerPhoneNumber1));
        return futerPhoneNumber1.getText();
    }
    /**
     * Получает второй номер телефона из футера.
     * Включает ожидание видимости элемента номера телефона перед его извлечением.
     *
     * @return текст второго номера телефона из футера.
     */
    public String getFuterPhoneNumber2() {
        wait.until(ExpectedConditions.visibilityOf(futerPhoneNumber2));
        return futerPhoneNumber2.getText();
    }
    /**
     * Получает первый адрес электронной почты из футера.
     * Включает ожидание видимости элемента адреса электронной почты перед его извлечением.
     *
     * @return текст первого адреса электронной почты из футера.
     */
    public String getFuterMail1() {
        wait.until(ExpectedConditions.visibilityOf(futerMail1));
        return futerMail1.getText();
    }
    /**
     * Получает второй адрес электронной почты из футера.
     * Включает ожидание видимости элемента адреса электронной почты перед его извлечением.
     *
     * @return текст второго адреса электронной почты из футера.
     */
    public String getFuterMail2() {
        wait.until(ExpectedConditions.visibilityOf(futerMail2));
        return futerMail2.getText();
    }
}