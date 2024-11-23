package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
/**
 * Класс WayPageHeader расширяет функциональность класса WayPage,
 * предоставляя методы для взаимодействия с элементами заголовка страницы.
 * Этот класс включает методы для получения контактной информации,
 * такой как номера телефонов и ссылки на социальные сети.
 */
public class WayPageHeader extends WayPage {

    @FindBy(xpath = "//*[@id=\"ast-desktop-header\"]/div[1]/div/div/div/div[1]/div/div/div/div/div/section[1]" +
            "/div/div/div/div[2]/div/ul/li[1]/a/span[2]")
    private WebElement headerPhoneNumber1;
    @FindBy(xpath = "//*[@id=\"ast-desktop-header\"]/div[1]/div/div/div/div[1]/div/div/div/div/div/section[1]" +
            "/div/div/div/div[2]/div/ul/li[2]/a/span[2]")
    private WebElement headerPhoneNumber2;
    @FindBy(xpath = "//*[@id=\"ast-desktop-header\"]/div[1]/div/div/div/div[1]/div/div/div/div/div/section[1]" +
            "/div/div/div/div[2]/div/ul/li[3]/a/span[2]")
    private WebElement headerPhoneNumber3;
    @FindBy(xpath = "//*[@id=\"ast-desktop-header\"]/div[1]/div/div/div/div[1]/div/div/div/div/div/section[1]" +
            "/div/div/div/div[2]/div/ul/li[4]/a/span[2]")
    private WebElement headerSkype;
    @FindBy(xpath = "//*[@id=\"ast-desktop-header\"]/div[1]/div/div/div/div[1]/div/div/div/div/div/section[1]" +
            "/div/div/div/div[2]/div/ul/li[5]/a/span[2]")
    private WebElement headerMail;
    @FindBy(xpath = "//*[@id=\"ast-desktop-header\"]/div[1]/div/div/div/div[2]/div/div/div/a[1]")
    private WebElement faceBook;
    @FindBy(xpath = "//*[@id=\"ast-desktop-header\"]/div[1]/div/div/div/div[2]/div/div/div/a[2]")
    private WebElement linkedIn;
    @FindBy(xpath = "//*[@id=\"ast-desktop-header\"]/div[1]/div/div/div/div[2]/div/div/div/a[3]")
    private WebElement google;
    @FindBy(xpath = "//*[@id=\"ast-desktop-header\"]/div[1]/div/div/div/div[2]/div/div/div/a[4]")
    private WebElement youTube;
    /**
     * Конструктор класса WayPageHeader.
     * Инициализирует веб-драйвер, унаследованный от класса WayPage.
     *
     * @param driver объект WebDriver для управления браузером.
     */
    public WayPageHeader(WebDriver driver) {
        super(driver);
    }

    /**
     * Получает текст первого номера телефона из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return текст первого номера телефона.
     */
    @Step("Get the first phone number from header")
    public String getPhoneNumber1() {
        wait.until(ExpectedConditions.visibilityOf(headerPhoneNumber1));
        return headerPhoneNumber1.getText();
    }
    /**
     * Получает текст второго номера телефона из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return текст второго номера телефона.
     */
    @Step("Get the second phone number from header")
    public String getPhoneNumber2() {
        wait.until(ExpectedConditions.visibilityOf(headerPhoneNumber2));
        return headerPhoneNumber2.getText();
    }
    /**
     * Получает текст третьего номера телефона из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return текст третьего номера телефона.
     */
    @Step("Get the third phone number from header")
    public String getPhoneNumber3() {
        wait.until(ExpectedConditions.visibilityOf(headerPhoneNumber3));
        return headerPhoneNumber3.getText();
    }
    /**
     * Получает текст ссылки на Skype из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return текст ссылки на Skype.
     */
    @Step("Get the Skype link text from header")
    public String getSkype() {
        wait.until(ExpectedConditions.visibilityOf(headerSkype));
        return headerSkype.getText();
    }
    /**
     * Получает текст адреса электронной почты из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return текст адреса электронной почты.
     */
    @Step("Get the email address text from header")
    public String getMail() {
        wait.until(ExpectedConditions.visibilityOf(headerMail));
        return headerMail.getText();
    }
    /**
     * Получает URL Facebook из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return URL ссылки на Facebook.
     */
    @Step("Get the Facebook URL from header")
    public String getFaceBook() {
        wait.until(ExpectedConditions.visibilityOf(faceBook));
        return faceBook.getAttribute("href");
    }
    /**
     * Получает URL LinkedIn из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return URL ссылки на LinkedIn.
     */
    @Step("Get the LinkedIn URL from header")
    public String getLinkedIn() {
        wait.until(ExpectedConditions.visibilityOf(linkedIn));
        return linkedIn.getAttribute("href");
    }
    /**
     * Получает URL Google из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return URL ссылки на Google.
     */
    @Step("Get the Google URL from header")
    public String getGoogle() {
        wait.until(ExpectedConditions.visibilityOf(google));
        return google.getAttribute("href");
    }
    /**
     * Получает URL YouTube из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return URL ссылки на YouTube.
     */
    @Step("Get the YouTube URL from header")
    public String getYouTube() {
        wait.until(ExpectedConditions.visibilityOf(youTube));
        return youTube.getAttribute("href");
    }
}
