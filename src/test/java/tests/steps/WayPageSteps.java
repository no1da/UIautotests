package tests.steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Тогда;
import org.assertj.core.api.Assertions;
import pages.WayPage;
import tests.hooks.TestHooks;
import utils.Config;

public class WayPageSteps extends WayPage {

    private Config config;

    public WayPageSteps() {
        super(TestHooks.getDriver());
        this.config = new Config();
    }

    @Дано("я открываю страницу Way2Automation")
    public void openThePage() {
            driver.get(config.getProperty("app.url"));
    }

    @Тогда("я должен увидеть заголовок")
    public void shouldSeeTheHeader() {
        Assertions.assertThat(findHeader())
                .as("Header should be displayed")
                .isTrue();
    }

    @Тогда("я должен увидеть футер")
    public void shouldSeeTheFooter() {
        Assertions.assertThat(findFooter())
                .as("Footer should be displayed")
                .isTrue();
    }

    @Тогда("я должен увидеть кнопку регистрации")
    public void shouldSeeTheRegistrationButton() {
        Assertions.assertThat(findButtonRegistration())
                .as("Registration button should be displayed")
                .isTrue();
    }

    @Тогда("я должен увидеть список курсов")
    public void shouldSeeTheCoursesList() {
        Assertions.assertThat(findListCourses())
                .as("Courses list should be displayed")
                .isTrue();
    }

    @Тогда("я должен увидеть блок навигации")
    public void shouldSeeTheNavigationBlock() {
        Assertions.assertThat(findNavigationBlock())
                .as("Navigation block should be displayed")
                .isTrue();
    }
}
