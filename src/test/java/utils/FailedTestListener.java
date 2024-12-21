package utils;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Слушатель для отслеживания выполнения JUnit тестов.
 * Реализация интерфейса {@link TestExecutionListener}, предназначенная для
 * мониторинга завершения тестов, фиксации всех упавших тестов и вывода информации
 * об их статусе выполнения и причинах ошибок.
 */
public class FailedTestListener implements TestWatcher {
    // Константа для имени файла, где будут сохраняться упавшие тесты
    private static final String FAILED_TESTS_FILE = "failed-tests.txt";

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testClass = context.getTestClass().map(Class::getName).orElse("UnknownClass");
        String testMethod = context.getTestMethod().map(method -> method.getName()).orElse("UnknownMethod");

        String testName = testClass + "#" + testMethod;

        // Логирование упавшего теста в файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FAILED_TESTS_FILE, true))) {
            writer.write(testName);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
