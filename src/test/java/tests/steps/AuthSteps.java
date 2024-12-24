package tests.steps;

import io.cucumber.java.ru.*;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import pages.AuthSQLPage;
import tests.hooks.TestHooks;
import utils.Config;

public class AuthSteps {
    private WebDriver driver;
    private AuthSQLPage authSQLPage;
    private Config config;

    public AuthSteps() {
        this.driver = TestHooks.getDriver();
        this.config = new Config();
        this.authSQLPage = new AuthSQLPage(driver);
    }

    @Дано("я открываю страницу входа")
    public void iOpenTheLoginPage() {
        driver.get(config.getProperty("auth.url"));
    }

    @Когда("я ввожу имя пользователя")
    public void iEnterTheUsername() {
        authSQLPage.enterLogin(config.getProperty("login"));
    }

    @Когда("я ввожу пароль")
    public void iEnterThePassword() {
        authSQLPage.enterPassword(config.getProperty("password"));
    }

    @И("я отправляю форму входа")
    public void iSubmitTheLoginForm() {
        authSQLPage.submit();
    }

    @Тогда("я должен увидеть свое имя пользователя на экране")
    public void iShouldSeeMyUsernameDisplayedOnTheScreen() {
        boolean isUsernameVisible = authSQLPage.findUsername();
        Assertions.assertThat(isUsernameVisible)
                .as("Имя пользователя должно быть видимым при успешном входе")
                .isTrue();
    }
}
