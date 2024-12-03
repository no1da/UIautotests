package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Класс WayPageHeader расширяет функциональность класса WayPage,
 * предоставляя методы для взаимодействия с элементами заголовка страницы.
 * Этот класс включает методы для получения контактной информации,
 * такой как номера телефонов и ссылки на социальные сети.
 */
public class WayPageHeader extends WayPage {
    @FindBy(css = "span.lazyloaded")
    private WebElement headerPhoneNumber1;
    @FindBy(css = "li.elementor-inline-item:nth-child(2) > a:nth-child(1) > span:nth-child(2)")
    private WebElement headerPhoneNumber2;
    @FindBy(css = "li.elementor-inline-item:nth-child(3) > a:nth-child(1) > span:nth-child(2)")
    private WebElement headerPhoneNumber3;
    @FindBy(css = "li.elementor-inline-item:nth-child(4) > a:nth-child(1) > span:nth-child(2)")
    private WebElement headerSkype;
    @FindBy(css = "li.elementor-inline-item:nth-child(5) > a:nth-child(1) > span:nth-child(2)")
    private WebElement headerMail;
    @FindBy(css = "a.ast-builder-social-element:nth-child(1)")
    private WebElement faceBook;
    @FindBy(css = "a.ast-builder-social-element:nth-child(2)")
    private WebElement linkedIn;
    @FindBy(css = "a.ast-builder-social-element:nth-child(3)")
    private WebElement google;
    @FindBy(css = "a.ast-builder-social-element:nth-child(4)")
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
    public String getPhoneNumber1() {
        waiter.waitForVisibility(headerPhoneNumber1);
        return headerPhoneNumber1.getText();
    }

    /**
     * Получает текст второго номера телефона из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return текст второго номера телефона.
     */
    public String getPhoneNumber2() {
        waiter.waitForVisibility(headerPhoneNumber2);
        return headerPhoneNumber2.getText();
    }

    /**
     * Получает текст третьего номера телефона из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return текст третьего номера телефона.
     */
    public String getPhoneNumber3() {
        waiter.waitForVisibility(headerPhoneNumber3);
        return headerPhoneNumber3.getText();
    }

    /**
     * Получает текст ссылки на Skype из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return текст ссылки на Skype.
     */
    public String getSkype() {
        waiter.waitForVisibility(headerSkype);
        return headerSkype.getText();
    }

    /**
     * Получает текст адреса электронной почты из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return текст адреса электронной почты.
     */
    public String getMail() {
        waiter.waitForVisibility(headerMail);
        return headerMail.getText();
    }

    /**
     * Получает URL Facebook из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return URL ссылки на Facebook.
     */
    public String getFaceBook() {
        waiter.waitForVisibility(faceBook);
        return faceBook.getAttribute("href");
    }

    /**
     * Получает URL LinkedIn из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return URL ссылки на LinkedIn.
     */
    public String getLinkedIn() {
        waiter.waitForVisibility(linkedIn);
        return linkedIn.getAttribute("href");
    }

    /**
     * Получает URL Google из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return URL ссылки на Google.
     */
    public String getGoogle() {
        waiter.waitForVisibility(google);
        return google.getAttribute("href");
    }

    /**
     * Получает URL YouTube из заголовка.
     * Включает ожидание видимости элемента перед его извлечением.
     *
     * @return URL ссылки на YouTube.
     */
    public String getYouTube() {
        waiter.waitForVisibility(youTube);
        return youTube.getAttribute("href");
    }
}
