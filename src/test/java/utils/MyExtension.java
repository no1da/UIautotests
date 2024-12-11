package utils;

import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import tests.BaseTest;

/**
 * Расширение JUnit 5 для обработки событий после выполнения тестов.
 */
public class MyExtension implements AfterTestExecutionCallback {
    /**
     * Этот метод вызывается после выполнения теста.
     *
     * @param extensionContext контекст выполнения теста, предоставляющий информацию
     *                         о состоянии теста, включая наличие исключений.
     * @throws Exception если происходит ошибка при обработке результатов выполнения теста.
     */
    @Override
    public void afterTestExecution(ExtensionContext extensionContext) throws Exception {
        if (extensionContext.getExecutionException().isPresent()) AllureAttachmentsManager.screenshot(BaseTest.getDriver());
    }
}
