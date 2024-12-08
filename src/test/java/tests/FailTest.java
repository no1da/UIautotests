package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import pages.LifeTimePage;
import pages.WayPageNavigationBlock;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FailTest extends MainPageTest {
    private LifeTimePage lifeTimePage;
    private WayPageNavigationBlock wayPageNavigationBlock;
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
        assertEquals(lifeTimePage.getTextHeader(), config.getProperty("headerFailed"));
    }
}
