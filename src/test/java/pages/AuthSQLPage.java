package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Класс страницы авторизации для https://www.sql-ex.ru/.
 * Обеспечивает взаимодействие с элементами страницы авторизации.
 */
public class AuthSQLPage extends BasePage {
    @FindBy(xpath = "//form[@name='frmlogin']//input[@type='text' and @name='login']")
    private WebElement inputLogin;
    @FindBy(xpath = "//form[@name='frmlogin']//input[@type='password' and @name='psw']")
    private WebElement inputPassword;
    @FindBy(xpath = "//form[@name=\"frmlogin\"]//input[@type=\"submit\" and @name=\"subm1\"]")
    private WebElement inputSubmit;
    @FindBy(css = "a.none[href=\"/personal.php\"]")
    private WebElement username;

    /**
     * Конструктор класса AuthSQLPage.
     *
     * @param driver WebDriver для управления браузером.
     */
    public AuthSQLPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Заполняет поле логина.
     *
     * @param login логин пользователя.
     * @return текущий экземпляр AuthSQLPage для цепочки методов.
     */
    @Step("Fill in the login field with login: {login}")
    public AuthSQLPage enterLogin(String login) {
        waitAndInput(inputLogin, login);
        return this;
    }

    /**
     * Заполняет поле пароля.
     *
     * @param password пароль пользователя.
     * @return текущий экземпляр AuthSQLPage для цепочки методов.
     */
    @Step("Fill in the password field")
    public AuthSQLPage enterPassword(String password) {
        waitAndInput(inputPassword, password);
        return this;
    }

    /**
     * Отправляет форму авторизации.
     *
     * @return текущий экземпляр AuthSQLPage для цепочки методов.
     */
    @Step("Submit the login form")
    public AuthSQLPage submit() {
        waitAndClick(inputSubmit);
        return this;
    }

    /**
     * Находит имя Usera и проверяет его видимость.
     *
     * @return true, если заголовок видимый; иначе false.
     */
    @Step("Check visibility of the username")
    public boolean findUsername() {
        return waitAndIsDisplayed(username);
    }

    public WebElement getInputLogin() {
        return inputLogin;
    }
}
