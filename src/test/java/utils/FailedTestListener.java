package utils;

import org.junit.platform.engine.TestExecutionResult;
import org.junit.platform.launcher.TestExecutionListener;
import org.junit.platform.launcher.TestIdentifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 * Слушатель для отслеживания выполнения JUnit тестов.
 * Реализация интерфейса {@link TestExecutionListener}, предназначенная для
 * мониторинга завершения тестов, фиксации всех упавших тестов и вывода информации
 * об их статусе выполнения и причинах ошибок.
 */
public class FailedTestListener implements TestExecutionListener {
    /**
     * Список уникальных идентификаторов (`UniqueId`) тестов, которые завершились сбоем.
     */
    private final List<String> failedTests = new ArrayList<>();
    /**
     * Вызывается после завершения выполнения теста.
     * Этот метод реализует логику записи информации о каждом тесте, который завершился
     * неуспешно. Если тест имеет статус FAILED, его уникальный идентификатор
     * добавляется в список failedTests. Также выводится имя теста и сообщение
     * указанного исключения, если оно присутствует.
     */
    @Override
    public void executionFinished(TestIdentifier testIdentifier, TestExecutionResult testExecutionResult) {
        if (testExecutionResult.getStatus() == TestExecutionResult.Status.FAILED) {
            failedTests.add(testIdentifier.getUniqueId());
            System.out.println("Тест не пройден: " + testIdentifier.getDisplayName());

            Optional<Throwable> throwable = testExecutionResult.getThrowable();
            throwable.ifPresent(t -> System.out.println("Возникла следующая ошибка: " + t.getMessage()));
        }
    }
    /**
     * Возвращает список уникальных идентификаторов тестов, которые завершились сбоем.
     * @return список строковых идентификаторов упавших тестов.
     */
    public List<String> getFailedTests() {
        return failedTests;
    }
}
