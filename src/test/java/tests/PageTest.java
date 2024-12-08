package tests;

import io.qameta.allure.*;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Класс тестирования страницы (https://www.way2automation.com/) содержит тесты для проверки различных элементов
 * и функциональности веб-страницы, используя фреймворк JUnit.
 */
@Epic("Testing Way2Automation Page")
public class PageTest extends MainPageTest {
    private WayPageHeader wayPageHeader;
    private WayPageFooter wayPageFuter;
    private LifeTimePage lifeTimePage;
    private WayPageNavigationBlock wayPageNavigationBlock;
    private WayPageCourses wayPageCourses;

    /**
     * Тестирует наличие заголовка, футера, кнопки регистрации,
     * списка курсов и навигационного блока на веб-странице.
     */
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Feature("Header, Footer, Registration Button, Courses List")
    @Story("Verify essential elements presence on the page")
    public void wayPageTest() {
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(wayPage.findHeader())
                .as("Header should be present")
                .isTrue();
        softAssertions.assertThat(wayPage.findFooter())
                .as("Footer should be present")
                .isTrue();
        softAssertions.assertThat(wayPage.findButtonRegistration())
                .as("Registration button should be present")
                .isTrue();
        softAssertions.assertThat(wayPage.findListCourses())
                .as("Courses list should be present")
                .isTrue();
        softAssertions.assertThat(wayPage.findNavigationBlock())
                .as("Navigation block should be present")
                .isTrue();

        softAssertions.assertAll();
    }

    /**
     * Проверяет элементы заголовка на странице, убедившись, что
     * значения телефонных номеров и других данных совпадают с
     * ожидаемыми значениями из конфигурации.
     */
    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Feature("Header Information")
    @Story("Validate header information against expected values")
    public void wayPageHeaderTest() {
        wayPageHeader = new WayPageHeader(driver);
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(wayPageHeader.getPhoneNumber1())
                .as("First phone number should match")
                .isEqualTo(config.getProperty("phone.number1"));
        softAssertions.assertThat(wayPageHeader.getPhoneNumber2())
                .as("Second phone number should match")
                .isEqualTo(config.getProperty("phone.number2"));
        softAssertions.assertThat(wayPageHeader.getPhoneNumber3())
                .as("Third phone number should match")
                .isEqualTo(config.getProperty("phone.number3"));
        softAssertions.assertThat(wayPageHeader.getSkype())
                .as("Skype should match")
                .isEqualTo(config.getProperty("skype"));
        softAssertions.assertThat(wayPageHeader.getMail())
                .as("Mail should match")
                .isEqualTo(config.getProperty("mail"));
        softAssertions.assertThat(wayPageHeader.getFaceBook())
                .as("Facebook should match")
                .isEqualTo(config.getProperty("facebook"));
        softAssertions.assertThat(wayPageHeader.getLinkedIn())
                .as("LinkedIn should match")
                .isEqualTo(config.getProperty("linkedin"));
        softAssertions.assertThat(wayPageHeader.getGoogle())
                .as("Google should match")
                .isEqualTo(config.getProperty("google"));
        softAssertions.assertThat(wayPageHeader.getYouTube())
                .as("YouTube should match")
                .isEqualTo(config.getProperty("youtube"));

        softAssertions.assertAll();
    }

    /**
     * Проверяет значения футера на странице и сравнивает их с
     * ожидаемыми значениями из конфигурационного файла.
     */
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Feature("Footer Information")
    @Story("Validate footer information against expected values")
    public void wayPageFuterTest() {
        wayPageFuter = new WayPageFooter(driver);
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(wayPageFuter.getFooterAdress())
                .as("Footer address should match")
                .isEqualTo(config.getProperty("adress"));
        softAssertions.assertThat(wayPageFuter.getFooterPhoneNumber1())
                .as("Footer phone number 1 should match")
                .isEqualTo(config.getProperty("phoneNumber1"));
        softAssertions.assertThat(wayPageFuter.getFooterPhoneNumber2())
                .as("Footer phone number 2 should match")
                .isEqualTo(config.getProperty("phoneNumber2"));
        softAssertions.assertThat(wayPageFuter.getFooterMail1())
                .as("Footer email 1 should match")
                .isEqualTo(config.getProperty("mail1"));
        softAssertions.assertThat(wayPageFuter.getFooterMail2())
                .as("Footer email 2 should match")
                .isEqualTo(config.getProperty("mail2"));

        softAssertions.assertAll();
    }

    /**
     * Тестирует функциональность меню курсов. Сравнивает заголовок
     * активного курса до и после прокрутки налево.
     */
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Feature("Course Navigation")
    @Story("Test course navigation functionality")
    public void coursesScrollLeftTest() {
        wayPageCourses = new WayPageCourses(driver);
        String titleCurse = wayPageCourses.getTitleActiveCourse();
        wayPageCourses.scrollCoursesLeft();
        wayPageCourses.scrollCoursesLeft();
        String titleCurse2 = wayPageCourses.getTitleActiveCourse();
        assertFalse(titleCurse.equals(titleCurse2));
    }

    /**
     * Тестирует функциональность меню курсов. Сравнивает заголовок
     * активного курса до и после прокрутки направо.
     */
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Feature("Course Navigation")
    @Story("Test course navigation functionality")
    public void coursesRightLeftTest() {
        wayPageCourses = new WayPageCourses(driver);
        String titleCurse = wayPageCourses.getTitleActiveCourse();
        wayPageCourses.scrollCoursesRight();
        String titleCurse2 = wayPageCourses.getTitleActiveCourse();
        assertFalse(titleCurse.equals(titleCurse2));
    }

    /**
     * Тестирует переход на страницу 'LIFETIME MEMBERSHIP CLUB' и сверяет
     * заголовок страницы с ожидаемым заголовком из конфигурации.
     */
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Feature("Lifetime Membership Navigation")
    @Story("Test navigation to lifetime membership page")
    public void goToLifeTimeTest() {
        lifeTimePage = new LifeTimePage(driver);
        wayPageNavigationBlock = new WayPageNavigationBlock(driver);
        wayPageNavigationBlock.goToLifeTime();
        assertEquals(lifeTimePage.getTextHeader(), config.getProperty("header"));
    }
}
