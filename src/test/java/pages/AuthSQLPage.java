package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Класс страницы авторизации для https://www.sql-ex.ru/.
 * Обеспечивает взаимодействие с элементами страницы авторизации.
 */
public class AuthSQLPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "/html/body/table[2]/tbody/tr/td[1]/form/table/tbody/tr[1]/td/input[1]")
    private WebElement inputLogin;
    @FindBy(xpath = "/html/body/table[2]/tbody/tr/td[1]/form/table/tbody/tr[1]/td/input[2]")
    private WebElement inputPassword;
    @FindBy(xpath = "/html/body/table[2]/tbody/tr/td[1]/form/table/tbody/tr[2]/td[1]/input")
    private WebElement inputSubmit;
    @FindBy(xpath = "/html/body/table[1]/tbody/tr/td[3]/b/a")
    private WebElement username;
    /**
     * Конструктор класса AuthSQLPage.
     *
     * @param driver WebDriver для управления браузером.
     */
    public AuthSQLPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    /**
     * Заполняет поля авторизации и отправляет форму.
     *
     * @param login    логин пользователя.
     * @param password пароль пользователя.
     */
    @Step("Fill in the authentication fields with login: {login} and password: {password}")
    public void fillFieldsAuth(String login, String password) {
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
        inputSubmit.click();
    }
    /**
     * Находит имя Usera и проверяет его видимость.
     *
     * @return true, если заголовок видимый; иначе false.
     */
    @Step("Check visibility of the username")
    public boolean findUsername() {
        return username.isDisplayed();
    }
}
