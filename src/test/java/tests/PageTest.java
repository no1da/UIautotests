package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
/**
 * Класс тестирования страницы (https://www.way2automation.com/) содержит тесты для проверки различных элементов
 * и функциональности веб-страницы, используя фреймворк JUnit.
 */
public class PageTest extends MainPageTest {
    private WayPageHeader wayPageHeader;
    private WayPageFuter wayPageFuter;
    private LifeTimePage lifeTimePage;
    private WayPageNavigationBlock wayPageNavigationBlock;
    private WayPageCourses wayPageCourses;
    /**
     * Тестирует наличие заголовка, футера, кнопки регистрации,
     * списка курсов и навигационного блока на веб-странице.
     */
    @Test
    public void wayPageTest() {
        Assertions.assertTrue(wayPage.findHeader());
        Assertions.assertTrue(wayPage.findFooter());
        Assertions.assertTrue(wayPage.findButtonRegistration());
        Assertions.assertTrue(wayPage.findListCourses());
        Assertions.assertTrue(wayPage.findNavigationBlock());
    }
    /**
     * Проверяет элементы заголовка на странице, убедившись, что
     * значения телефонных номеров и других данных совпадают с
     * ожидаемыми значениями из конфигурации.
     */
    @Test
    public void wayPageHeaderTest() {
        wayPageHeader = new WayPageHeader(driver);
        Assertions.assertEquals(config.getProperty("phone.number1"), wayPageHeader.getPhoneNumber1());
        Assertions.assertEquals(config.getProperty("phone.number2"), wayPageHeader.getPhoneNumber2());
        Assertions.assertEquals(config.getProperty("phone.number3"), wayPageHeader.getPhoneNumber3());
        Assertions.assertEquals(config.getProperty("skype"), wayPageHeader.getSkype());
        Assertions.assertEquals(config.getProperty("mail"), wayPageHeader.getMail());
        Assertions.assertEquals(config.getProperty("facebook"), wayPageHeader.getFaceBook());
        Assertions.assertEquals(config.getProperty("linkedin"), wayPageHeader.getLinkedIn());
        Assertions.assertEquals(config.getProperty("google"), wayPageHeader.getGoogle());
        Assertions.assertEquals(config.getProperty("youtube"), wayPageHeader.getYouTube());
    }
    /**
     * Проверяет значения футера на странице и сравнивает их с
     * ожидаемыми значениями из конфигурационного файла.
     */
    @Test
    public void wayPageFutterTest() {
        wayPageFuter = new WayPageFuter(driver);
        assertEquals(config.getProperty("adress"), wayPageFuter.getFuterAdress());
        assertEquals(config.getProperty("phoneNumber1"), wayPageFuter.getFuterPhoneNumber1());
        assertEquals(config.getProperty("phoneNumber2"), wayPageFuter.getFuterPhoneNumber2());
        assertEquals(config.getProperty("mail1"), wayPageFuter.getFuterMail1());
        assertEquals(config.getProperty("mail2"), wayPageFuter.getFuterMail2());
    }
    /**
     * Тестирует функциональность меню курсов. Сравнивает заголовок
     * активного курса до и после прокрутки.
     */
    @Test
    public void coursesTest() {
        wayPageCourses = new WayPageCourses(driver);
        String titleCurse = wayPageCourses.getTitleActiveCourse();
        System.out.println(titleCurse);
        wayPageCourses.scrollCoursesLeft();
        String titleCurse2 = wayPageCourses.getTitleActiveCourse();
        assertEquals(titleCurse, titleCurse2);
    }
    /**
     * Тестирует переход на страницу 'LIFETIME MEMBERSHIP CLUB' и сверяет
     * заголовок страницы с ожидаемым заголовком из конфигурации.
     */
    @Test
    public void goToLifeTimeTest() {
        lifeTimePage = new LifeTimePage(driver);
        wayPageNavigationBlock = new WayPageNavigationBlock(driver);
        wayPageNavigationBlock.goToLifeTime();
        Assertions.assertEquals(lifeTimePage.getTextHeader(), config.getProperty("header"));
    }
}
