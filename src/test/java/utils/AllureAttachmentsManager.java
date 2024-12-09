package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import tests.MainPageTest;

import java.io.IOException;
/**
 * Класс для управления вложениями Allure, связанными с тестами.
 *
 * Этот класс предоставляет статический метод для захвата и прикрепления
 * скриншотов экрана в отчеты Allure. Скриншоты могут быть полезны для
 * анализа состояния приложения на момент сбоя теста.
 */
public class AllureAttachmentsManager {
    /**
     * Захватывает скриншот текущего состояния экрана и прикрепляет его
     * к отчету Allure.
     *
     * @return массив байтов, представляющий изображение скриншота в формате PNG.
     * @throws IOException если не удается выполнить захват скриншота.
     */
    @Attachment(value = "Снимок экрана", type = "image/png")
    public static byte[] screenshot() throws IOException {
        return ((TakesScreenshot) MainPageTest.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
