package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;


public class RegistrationTestTwo extends BaseTestTestNG {
    /**
     * DataProvider для возвращения различных наборов данных для теста авторизации.
     *
     * @return массив объектов с данными для входа.
     */
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"angular", "password", "123", true},
                {"angular1", "password", "123", false},
                {"angular", "password1", "123", false}
        };
    }
    /**
     * Тест авторизации с использованием различных данных, предоставленных DataProvider.
     *
     * @param username        Имя пользователя для входа.
     * @param password        Пароль для входа.
     * @param username1       Дополнительное имя пользователя.
     * @param expectedSuccess Ожидаемый результат (true = успешный логин, false = неуспешный логин).
     */
    @Test(dataProvider = "loginData")
    public void testRegistration(String username, String password, String username1, boolean expectedSuccess) {
        boolean isLoggedIn = ppwRegistrationPage
                .fillFieldsLogin(username, password, username1)
                .clickLogin()
                .findLogged();

        assertTrue(isLoggedIn == expectedSuccess);
    }
}
