package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junitpioneer.jupiter.RetryingTest;
import pages.LifeTimePage;
import pages.WayPageNavigationBlock;
import utils.FailedTestListener;
import utils.MyExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Класс тестирования страницы (https://www.way2automation.com/) содержит тест
 * для проверки функционала создания скриншотов невыполненных тестов
 * и функциональности веб-страницы, используя фреймворк JUnit.
 */
@ExtendWith({MyExtension.class, FailedTestListener.class})
public class FailTest extends BaseTestDriverFactory {
    private LifeTimePage lifeTimePage;
    private WayPageNavigationBlock wayPageNavigationBlock;
    private static final int MAX_RETRY_COUNT = 2;
    /**
     * Тестирует переход на страницу 'LIFETIME MEMBERSHIP CLUB' и сверяет
     * заголовок страницы с ожидаемым заголовком из конфигурации.
     */
    @RetryingTest(MAX_RETRY_COUNT)
    @Severity(SeverityLevel.NORMAL)
    @Feature("Lifetime Membership Navigation")
    @Story("Test navigation to lifetime membership page")
    public void testGoToLifeTime() {
        lifeTimePage = new LifeTimePage(driver);
        wayPageNavigationBlock = new WayPageNavigationBlock(driver);
        wayPageNavigationBlock.goToLifeTime();
        assertEquals(lifeTimePage.getTextHeader(), config.getProperty("headerFailed"));
    }
}
