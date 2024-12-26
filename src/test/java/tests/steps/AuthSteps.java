package tests.steps;

import io.cucumber.java.ru.*;
import org.assertj.core.api.Assertions;
import pages.AuthSQLPage;
import tests.hooks.TestHooks;
import utils.Config;

public class AuthSteps extends AuthSQLPage {

    private Config config;

    public AuthSteps() {
        super(TestHooks.getDriver());
        this.config = new Config();
    }

    @Дано("я открываю страницу SQL-EX")
    public void openTheLoginPage() {
        driver.get(config.getProperty("auth.url"));
    }

    @Когда("я ввожу имя пользователя")
    public void enterTheUsername() {
        enterLogin(config.getProperty("login"));
    }

    @Когда("я ввожу пароль")
    public void enterThePassword() {
        enterPassword(config.getProperty("password"));
    }

    @И("я отправляю форму входа")
    public void submitTheLoginForm() {
        submit();
    }

    @Тогда("я должен увидеть свое имя пользователя на экране")
    public void shouldSeeMyUsernameDisplayedOnTheScreen() {
        boolean isUsernameVisible = findUsername();
        Assertions.assertThat(isUsernameVisible)
                .as("Имя пользователя должно быть видимым при успешном входе")
                .isTrue();
    }
}
