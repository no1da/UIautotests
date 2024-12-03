package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

/**
 * Класс WayPageCourses расширяет функциональность класса WayPage,
 * предоставляя методы для взаимодействия с элементами меню курсов.
 * Этот класс включает методы для получения информации о курсах и прокрутки карусели курсов.
 */
public class WayPageCourses extends WayPage {
    @FindBy(xpath = "//div[contains(@class, 'swiper-container-wrap') and contains(@class, 'pp-info-box-carousel" +
            "-wrap')]//div[contains(@class, 'swiper-slide') and contains(@class, 'swiper-slide-active')]\n")
    private WebElement titleActiveCurse;
    @FindBy(xpath = "//div[contains(@class, 'pp-slider-arrow') and contains(@class, 'swiper-button-next')]")
    private WebElement leftScrollButton;
    @FindBy(css = ".elementor-slides-wrapper > div:nth-child(4)")
    private WebElement rightScrollButton;
    @FindBy(xpath = "//div[contains(@class, 'swiper-container-wrap') and contains(@class, 'pp-info-box-carousel-wrap')]")
    private WebElement menuCourses;
    @FindBy(css = ".eicon-close")
    private WebElement closeButton;

    /**
     * Конструктор класса WayPageCourses.
     * Инициализирует веб-драйвер, унаследованный от класса WayPage.
     *
     * @param driver объект WebDriver для управления браузером.
     */
    public WayPageCourses(WebDriver driver) {
        super(driver);
    }

    /**
     * Получает заголовок активного курса на странице,
     * сначала ожидая видимости меню курсов.
     * Включает прокрутку до элемента, перемещение к элементу меню,
     * клик по кнопке закрытия и ожидает видимости заголовка активного курса.
     *
     * @return атрибут "data-swiper-slide-index" активного курса.
     */
    public String getTitleActiveCourse() {
        waiter.waitForVisibility(menuCourses);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//div[contains(@class, 'swiper-container-wrap') and contains(@class, 'pp-info-box-carousel-wrap')]")));
        Actions action = new Actions(driver);
        action.moveToElement(menuCourses).perform();
        waiter.waitForClickability(closeButton);
        closeButton.click();
        waiter.waitForVisibility(titleActiveCurse);
        return titleActiveCurse.getAttribute("data-swiper-slide-index");
    }

    /**
     * Прокручивает карусель курсов влево.
     * Ожидает, что кнопка прокрутки влево станет кликабельной и затем кликает по ней.
     */
    public WayPageCourses scrollCoursesLeft() {
        waiter.waitForVisibility(leftScrollButton);
        leftScrollButton.click();
        return this;
    }

    /**
     * Прокручивает карусель курсов вправо.
     * Ожидает, что кнопка прокрутки вправо станет видимой и затем кликает по ней.
     */
    public WayPageCourses scrollCoursesRight() {
        waiter.waitForVisibility(rightScrollButton);
        rightScrollButton.click();
        return this;
    }
}
