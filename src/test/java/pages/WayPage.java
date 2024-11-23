package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
/**
 * Класс WayPage представляет веб-страницу с элементами, которые можно найти и с которыми можно взаимодействовать.
 * Он использует Selenium WebDriver для управления браузером и выполнения операций с элементами на странице.
 */
public class WayPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    @FindBy(xpath = "//*[@id=\"ast-desktop-header\"]/div[1]/div/div")
    private WebElement header;
    @FindBy(xpath = "//*[@id=\"ast-desktop-header\"]/div[2]/div/div")
    private WebElement navigationBlock;
    @FindBy(xpath = "//*[@id=\"ast-desktop-header\"]/div[2]/div/div/div")
    private WebElement buttonRegistration;
    @FindBy(xpath = "//*[@id=\"post-17\"]/div/div/section[4]")
    private WebElement listCourses;
    @FindBy(xpath = "//*[@id=\"page\"]/div[2]/div/section/div[1]")
    private WebElement footer;

    /**
     * Конструктор класса WayPage.
     * Инициализирует WebDriver, WebDriverWait и элементы страницы.
     *
     * @param driver объект WebDriver для управления браузером.
     */
    public WayPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    /**
     * Находит заголовок страницы и проверяет его видимость.
     *
     * @return true, если заголовок видимый; иначе false.
     */
    public boolean findHeader() {
        wait.until(ExpectedConditions.visibilityOf(header));
        return header.isDisplayed();
    }
    /**
     * Находит навигационный блок и проверяет его видимость.
     *
     * @return true, если навигационный блок видимый; иначе false.
     */
    public boolean findNavigationBlock() {
        wait.until(ExpectedConditions.visibilityOf(navigationBlock));
        return navigationBlock.isDisplayed();
    }
    /**
     * Находит кнопку регистрации и проверяет ее видимость.
     *
     * @return true, если кнопка регистрации видимая; иначе false.
     */
    public boolean findButtonRegistration() {
        wait.until(ExpectedConditions.visibilityOf(buttonRegistration));
        return buttonRegistration.isDisplayed();
    }
    /**
     * Находит список курсов и проверяет его видимость.
     *
     * @return true, если список курсов видимый; иначе false.
     */
    public boolean findListCourses() {
        wait.until(ExpectedConditions.visibilityOf(listCourses));
        return listCourses.isDisplayed();
    }
    /**
     * Находит футер страницы и проверяет его видимость.
     *
     * @return true, если футер видимый; иначе false.
     */
    public boolean findFooter() {
        wait.until(ExpectedConditions.visibilityOf(footer));
        return footer.isDisplayed();
    }
}