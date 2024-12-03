package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Класс WayPageFuter расширяет функциональность класса WayPage,
 * предоставляя методы для взаимодействия с элементами футера страницы.
 * Этот класс включает методы для получения контактной информации,
 * такой как адрес, номера телефонов и электронные почты.
 */
public class WayPageFuter extends WayPage {
    @FindBy(css = ".elementor-icon-list-item > .elementor-icon-list-text")
    private WebElement futerAdress;
    @FindBy(xpath = "//span[text()='+91 97111-11-558']")
    private WebElement futerPhoneNumber1;
    @FindBy(xpath = "//span[text()='+91 97111-91-558']")
    private WebElement futerPhoneNumber2;
    @FindBy(xpath = "//span[text()='trainer@way2automation.com']")
    private WebElement futerMail1;
    @FindBy(xpath = "//span[text()='seleniumcoaching@gmail.com']")
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
        waiter.waitForVisibility(futerAdress);
        return futerAdress.getText();
    }

    /**
     * Получает первый номер телефона из футера.
     * Включает ожидание видимости элемента номера телефона перед его извлечением.
     *
     * @return текст первого номера телефона из футера.
     */
    public String getFuterPhoneNumber1() {
        waiter.waitForVisibility(futerPhoneNumber1);
        return futerPhoneNumber1.getText();
    }

    /**
     * Получает второй номер телефона из футера.
     * Включает ожидание видимости элемента номера телефона перед его извлечением.
     *
     * @return текст второго номера телефона из футера.
     */
    public String getFuterPhoneNumber2() {
        waiter.waitForVisibility(futerPhoneNumber2);
        return futerPhoneNumber2.getText();
    }

    /**
     * Получает первый адрес электронной почты из футера.
     * Включает ожидание видимости элемента адреса электронной почты перед его извлечением.
     *
     * @return текст первого адреса электронной почты из футера.
     */
    public String getFuterMail1() {
        waiter.waitForVisibility(futerMail1);
        return futerMail1.getText();
    }

    /**
     * Получает второй адрес электронной почты из футера.
     * Включает ожидание видимости элемента адреса электронной почты перед его извлечением.
     *
     * @return текст второго адреса электронной почты из футера.
     */
    public String getFuterMail2() {
        waiter.waitForVisibility(futerMail2);
        return futerMail2.getText();
    }
}