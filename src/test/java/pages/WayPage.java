package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Waiter;

import java.time.Duration;

/**
 * Класс WayPage представляет веб-страницу с элементами, которые можно найти и с которыми можно взаимодействовать.
 * Он использует Selenium WebDriver для управления браузером и выполнения операций с элементами на странице.
 */
public class WayPage {
    protected WebDriver driver;
    protected Waiter waiter;
    @FindBy(xpath = "//div[@class='site-above-header-wrap ast-builder-grid-row-container site-header-focus-item " +
            "ast-container' and @data-section='section-above-header-builder']")
    private WebElement header;
    @FindBy(css = "div.ast-main-header-wrap:nth-child(2) > div:nth-child(1) > div:nth-child(1)")
    private WebElement navigationBlock;
    @FindBy(css = "div.ast-main-header-wrap:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")
    private WebElement buttonRegistration;
    @FindBy(css = "section.elementor-section:nth-child(4)")
    private WebElement listCourses;
    @FindBy(css = ".elementor-element-60087569 > div:nth-child(1)")
    private WebElement footer;

    /**
     * Конструктор класса WayPage.
     * Инициализирует WebDriver, WebDriverWait и элементы страницы.
     *
     * @param driver объект WebDriver для управления браузером.
     */
    public WayPage(WebDriver driver) {
        this.driver = driver;
        this.waiter = new Waiter(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    /**
     * Находит заголовок страницы и проверяет его видимость.
     *
     * @return true, если заголовок видимый; иначе false.
     */
    public boolean findHeader() {
        waiter.waitForVisibility(header);
        return header.isDisplayed();
    }

    /**
     * Находит навигационный блок и проверяет его видимость.
     *
     * @return true, если навигационный блок видимый; иначе false.
     */
    public boolean findNavigationBlock() {
        waiter.waitForVisibility(navigationBlock);
        return navigationBlock.isDisplayed();
    }

    /**
     * Находит кнопку регистрации и проверяет ее видимость.
     *
     * @return true, если кнопка регистрации видимая; иначе false.
     */
    public boolean findButtonRegistration() {
        waiter.waitForVisibility(buttonRegistration);
        return buttonRegistration.isDisplayed();
    }

    /**
     * Находит список курсов и проверяет его видимость.
     *
     * @return true, если список курсов видимый; иначе false.
     */
    public boolean findListCourses() {
        waiter.waitForVisibility(listCourses);
        return listCourses.isDisplayed();
    }

    /**
     * Находит футер страницы и проверяет его видимость.
     *
     * @return true, если футер видимый; иначе false.
     */
    public boolean findFooter() {
        waiter.waitForVisibility(footer);
        return footer.isDisplayed();
    }
}