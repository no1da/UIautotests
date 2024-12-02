package utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Утилита для управления куками в браузере с использованием WebDriver.
 * Позволяет сохранять и загружать куки в формате JSON.
 */
public class CookieManager {
    private static final Gson gson = new Gson();

    /**
     * Сохраняет куки из текущей сессии WebDriver в указанный файл.
     *
     * @param driver   экземпляр WebDriver, из которого будут извлекаться куки.
     * @param filePath путь к файлу, куда будут сохранены куки в формате JSON.
     */
    public static void saveCookies(WebDriver driver, String filePath) {
        Set<Cookie> cookies = driver.manage().getCookies();
        Map<String, String> cookieMap = new HashMap<>();
        cookies.forEach(s -> cookieMap.put(s.getName(), s.getValue()));
        try (Writer writer = new FileWriter(filePath)) {
            gson.toJson(cookieMap, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Загружает куки из указанного файла и добавляет их в текущую сессию WebDriver.
     *
     * @param driver   экземпляр WebDriver, куда будут добавлены загруженные куки.
     * @param filePath путь к файлу, из которого будут загружены куки в формате JSON.
     */
    public static void loadCookies(WebDriver driver, String filePath) {
        try (Reader reader = new FileReader(filePath)) {
            Type cookieMapType = new TypeToken<Map<String, String>>() {
            }.getType();
            Map<String, String> cookieMap = gson.fromJson(reader, cookieMapType);

            cookieMap.forEach((name, value) ->
                    driver.manage().addCookie(new Cookie(name, value))
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}