package tests.steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.WayPage;
import tests.hooks.TestHooks;
import utils.Config;

public class WayPageSteps {
    private WebDriver driver;
    private WayPage wayPage;
    private Config config;

    public WayPageSteps() {
        this.driver = TestHooks.getDriver();
        this.config = new Config();
        this.wayPage = new WayPage(driver);
    }

    @Дано("я открываю страницу Way2Automation")
    public void iOenThePage() {
            driver.get(config.getProperty("app.url"));
    }

    @Тогда("я должен увидеть заголовок")
    public void iShouldSeeTheHeader() {
        Assertions.assertThat(wayPage.findHeader())
                .as("Header should be displayed")
                .isTrue();
    }

    @Тогда("я должен увидеть футер")
    public void iShouldSeeTheFooter() {
        Assertions.assertThat(wayPage.findFooter())
                .as("Footer should be displayed")
                .isTrue();
    }

    @Тогда("я должен увидеть кнопку регистрации")
    public void iShouldSeeTheRegistrationButton() {
        Assertions.assertThat(wayPage.findButtonRegistration())
                .as("Registration button should be displayed")
                .isTrue();
    }

    @Тогда("я должен увидеть список курсов")
    public void iShouldSeeTheCoursesList() {
        Assertions.assertThat(wayPage.findListCourses())
                .as("Courses list should be displayed")
                .isTrue();
    }

    @Тогда("я должен увидеть блок навигации")
    public void iShouldSeeTheNavigationBlock() {
        Assertions.assertThat(wayPage.findNavigationBlock())
                .as("Navigation block should be displayed")
                .isTrue();
    }
}
