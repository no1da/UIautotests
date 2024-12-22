package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
/**
 * Фабрика для создания экземпляра WebDriver.
 * Поддерживает как локальные драйверы, так и удаленный запуск через Selenium Grid.
 */
public class DriverFactory {
    /**
     * Создаёт WebDriver в зависимости от заданных параметров.
     *
     * @param browser   Тип браузера (например, chrome, firefox).
     * @param gridUrl   URL Selenium Grid; если null, запускается локально.
     * @return WebDriver объект для взаимодействия с браузером.
     */
    public static WebDriver getDriver(String browser, String gridUrl) throws MalformedURLException {
        WebDriver driver;
        if (gridUrl != null && !gridUrl.isEmpty()) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            switch (browser.toLowerCase()) {
                case "chrome":
                    capabilities.setBrowserName("chrome");
                    break;
                case "firefox":
                    capabilities.setBrowserName("firefox");
                    break;
                case "edge":
                    capabilities.setBrowserName("MicrosoftEdge");
                    break;
                case "ie":
                    capabilities.setBrowserName("internet explorer");
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser specified for GRID: " + browser);
            }
            driver = new RemoteWebDriver(new URL(gridUrl), capabilities);
        } else {
            switch (browser.toLowerCase()) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "ie":
                    driver = new InternetExplorerDriver();
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported browser specified for Local: " + browser);
            }
        }
        return driver;
    }
}
