package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/**
 * Утилита для выполнения операций с помощью JavaScript в контексте Selenium WebDriver.
 * Этот класс предоставляет методы для управления фокусом на элементах,
 * проверки наличия вертикальной прокрутки и других JavaScript операций.
 */
public class JSHelper {
    private WebDriver driver;
    /**
     * Конструктор для инициализации JSHelper с переданным WebDriver.
     *
     * @param driver экземпляр WebDriver, который будет использоваться для выполнения JavaScript.
     */
    public JSHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Удалить фокус с указанного поля ввода.
     *
     * @param element элемент, с которого нужно убрать фокус.
     */
    public void removeFocus(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].blur();", element);
    }

    /**
     * Проверяет, был ли фокус удален с указанного элемента.
     *
     * @param element элемент, для которого проверяется статус фокуса.
     * @return true, если фокус убран, иначе false.
     * Это достигается путем проверки, является ли элемент активным.
     */
    public boolean isFocusRemoved(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String script = "return document.activeElement !== arguments[0];";
        return (Boolean) js.executeScript(script, element);
    }

    /**
     * Проверяет наличие вертикального скролла на странице.
     *
     * @return true, если скролл присутствует, иначе false.
     * Это определяется на основе высоты содержимого страницы и высоты окна браузера.
     */
    public boolean hasVerticalScroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Boolean) js.executeScript("return document.body.scrollHeight > window.innerHeight;");
    }


}
