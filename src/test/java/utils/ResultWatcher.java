package utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;

import java.io.IOException;
/**
 * Наблюдатель за результатами тестов JUnit 5.
 * <p>
 * Этот класс реализует интерфейс {@link TestWatcher} и предоставляет
 * механизм для выполнения определённых действий в случае неудачи теста.
 * В частности, он захватывает скриншоты при неудачных тестах с помощью
 * {@link AllureAttachmentsManager}.
 * </p>
 */
public class ResultWatcher implements TestWatcher {
    /**
     * Метод, вызываемый при неудаче теста.
     *
     * @param context контекст выполнения теста, предоставляющий информацию о тесте.
     * @param cause причина сбоя, предоставляющая информацию об исключении,
     *              приведшем к провалу теста.
     */
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        try {
            AllureAttachmentsManager.screenshot();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        TestWatcher.super.testFailed(context, cause);
    }
}
