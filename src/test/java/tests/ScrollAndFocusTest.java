package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AuthSQLPage;

/**
 * Класс ScrollTest отвечает за тестирование функциональности прокрутки
 * и управления фокусом в приложении аутентификации.
 */
@Epic("Тестирование функционала страницы")
@Feature("Прокрутка страницы и управление фокусом")
public class ScrollAndFocusTest extends BaseTest {
    private AuthSQLPage authSQLPage;
    /**
     * Установка тестового окружения перед каждым тестом.
     * Инициализирует WebDriver, открывает страницу авторизации и подготавливает необходимые объекты.
     */
    @BeforeEach
    @Override
    public void setUp() {
        driver = new ChromeDriver();
        authSQLPage = new AuthSQLPage(driver);
        driver.manage().window().maximize();
        driver.get(config.getProperty("linkForU6"));
    }
    /**
     * Проверяет, есть ли вертикальная прокрутка страницы.
     */
    @Test
    @Severity(io.qameta.allure.SeverityLevel.NORMAL)
    @Story("Проверка наличия вертикальной прокрутки")
    public void scrollTest() {
        Assertions.assertTrue(authSQLPage.hasVerticalScroll());
    }
    /**
     * Тестирует удаление фокуса с поля для ввода логина.
     */
    @Test
    @Severity(SeverityLevel.NORMAL)
    @Story("Удаление фокуса с поля логина")
    public void removeFocusTest() {
        authSQLPage.enterLogin(config.getProperty("login"));
        authSQLPage.removeFocus(authSQLPage.getInputLogin());
        Assertions.assertTrue(authSQLPage.isFocusRemoved(authSQLPage.getInputLogin()));
    }
}
