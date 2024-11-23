package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
/**
 * Эта страница представляет собой страницу регистрации PPW (Protractor practice website - Regisration,
 * https://www.way2automation.com/angularjs-protractor/registeration/#/login).
 * Она содержит элементы управления для ввода учетных данных пользователя и
 * взаимодействия с компонентами страницы.
 */
public class PPWRegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(xpath = "//*[@id=\"username\"]")
    private WebElement inputUsername;
    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement inputPassword;
    @FindBy(xpath = "//*[@id=\"formly_1_input_username_0\"]")
    private WebElement inputUsername1;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/form/div[3]/button")
    private WebElement buttonLogin;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/p[1]")
    private WebElement loggedText;
    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[2]")
    private WebElement authAllert;
    /**
     * Конструктор класса PPWRegistrationPage.
     * Инициализирует веб-драйвер и WebDriverWait, а также
     * инициализирует элементы страницы с помощью PageFactory.
     *
     * @param driver экземпляр WebDriver для управления браузером.
     */
    public PPWRegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    /**
     * Заполняет поля логина и пароля.
     *
     * @param username имя пользователя для первого поля.
     * @param password пароль для авторизации.
     * @param username1 дополнительное имя пользователя (например, для второго поля).
     */
    public void fillFieldsLogin(String username, String password, String username1) {
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        inputUsername1.sendKeys(username1);
    }
    /**
     * Нажимает кнопку "Login".
     */
    public void clickLogin() {
        buttonLogin.click();
    }
    /**
     * Проверяет, было ли выполнено успешное логирование.
     *
     * @return true, если текст для успешного логирования найден, иначе false.
     */
    public boolean findLogged() {
        List<WebElement> elements = driver.findElements(By.xpath("/html/body/div[1]/div/div/div/p[1]"));
        return !elements.isEmpty();
    }
    /**
     * Получает текст алерта об авторизации.
     *
     * @return текст уведомления об авторизации.
     */
    public String getTextAuthAllert() {
        return authAllert.getText();
    }
}
