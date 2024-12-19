import org.junit.platform.engine.DiscoverySelector;
import org.junit.platform.engine.discovery.DiscoverySelectors;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import utils.FailedTestListener;

import java.util.List;
/**
 * Класс TestRunner отвечает за запуск тестов, сбор информации об упавших тестах
 * и их повторный запуск.
 */
public class TestRunner {
    public static void main(String[] args) {
        // Создание слушателя для отслеживания упавших тестов
        FailedTestListener failedTestListener = new FailedTestListener();
        // Создаём экземпляр тестового "Лаунчера" через LauncherFactory
        Launcher launcher = LauncherFactory.create();
        /**
         * LauncherDiscoveryRequest запрашивает тесты, используя DiscoverySelectors.
         * Мы указываем, что хотим выполнять тесты, находящиеся в пакете "tests".
         */
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(DiscoverySelectors.selectPackage("tests"))
                .build();
        launcher.registerTestExecutionListeners(failedTestListener);
        launcher.execute(request);
        // Получаем список упавших тестов
        List<String> failedTests = failedTestListener.getFailedTests();
        if (failedTests.isEmpty()) {
            System.out.println("Все тесты успешно пройдены!");
            return;
        }
        // Строим запрос на основе списка уникальных идентификаторов упавших тестов
        /**
         * Для повторного запроса используем уникальные идентификаторы (UniqueId),
         * которые предоставляет ранее сохранённый список `failedTests`.
         */
        System.out.println("Перезапуск упавших тестов:");
        LauncherDiscoveryRequest failedTestsRequest = LauncherDiscoveryRequestBuilder.request()
                .selectors(failedTests.stream()
                        .map(DiscoverySelectors::selectUniqueId)
                        .toArray(DiscoverySelector[]::new))
                .build();
        launcher.execute(failedTestsRequest);
    }
}
