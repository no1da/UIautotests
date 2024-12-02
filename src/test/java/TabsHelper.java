import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class TabsHelper {
    private WebDriver driver;
    private List<String> tabHandles;

    public TabsHelper(WebDriver driver) {
        this.driver = driver;
        this.tabHandles = new ArrayList<>();
    }

    /**
     * Обновляет список вкладок в текущем окне браузера.
     */
    public void updateTabs() {
        this.tabHandles = new ArrayList<>(driver.getWindowHandles());
    }

    /**
     * Переключает фокус на вкладку по индексу.
     *
     * @param index Индекс вкладки.
     * @throws IndexOutOfBoundsException Если индекс выходит за границы существующих вкладок.
     */
    public void switchToTab(int index) {
        if (index < 0 || index >= tabHandles.size()) {
            throw new IndexOutOfBoundsException("Вкладка с индексом " + index + " не существует.");
        }
        driver.switchTo().window(tabHandles.get(index));
    }

    /**
     * Возвращает количество открытых вкладок.
     *
     * @return Количество вкладок.
     */
    public int getTabCount() {
        return tabHandles.size();
    }
}
