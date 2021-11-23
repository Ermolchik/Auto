package itStep.tests;


import io.qameta.allure.Story;
import itStep.pages.LoginPage;
import itStep.pages.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static itStep.pages.MainPage.*;
import static itStep.resurses.Const.*;


public class Test {
    WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;

    @BeforeEach
    public void driverSet() {
        System.setProperty(NAME_DRIVER, HOME_DRIVER);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
    }

    @DisplayName("Авторизация с валидными данными")
    @org.junit.jupiter.api.Test
    @Story("5.1")
    public void loginTest() {
        loginPage.sendLogin(LOGIN).
                sendPassword(PASSWORD).
                clickButton();

        Assertions.assertEquals("Welcome Paul", driver.findElement(NAME_CLIENT).getText());

    }

    @DisplayName("Авторизация с невалидным паролем")
    @org.junit.jupiter.api.Test
    public void wrongPassTest() {

        loginPage.sendLogin(LOGIN).
                sendPassword(WRONG_PASSWORD).
                clickButton();

        Assertions.assertEquals("Invalid credentials", driver.findElement(loginPage.ERROR_MESSAGE).getText());
    }

    @DisplayName("Авторизация без пароля")
    @org.junit.jupiter.api.Test
    public void noPassTest() {
        loginPage.sendLogin(LOGIN).
                clickButton();

        Assertions.assertEquals("Password cannot be empty", driver.findElement(loginPage.ERROR_MESSAGE).getText());
    }

    @DisplayName("Авторизация без логина")
    @org.junit.jupiter.api.Test
    public void noLoginTest() {
        loginPage.sendPassword(PASSWORD).
                clickButton();

        Assertions.assertEquals("Username cannot be empty", driver.findElement(loginPage.ERROR_MESSAGE).getText());
    }

    @DisplayName("Авторизация без логина и без пароля")
    @org.junit.jupiter.api.Test
    public void noLoginNoPassTest() {
        loginPage.
                clickButton();

        Assertions.assertEquals("Username cannot be empty", driver.findElement(loginPage.ERROR_MESSAGE).getText());
    }

    @DisplayName("Авторизация с невалидным логином")
    @org.junit.jupiter.api.Test
    public void wrongLogTest() {
        loginPage.sendLogin(WRONG_LOGIN).
                sendPassword(PASSWORD).
                clickButton();

        Assertions.assertEquals("Invalid credentials", driver.findElement(loginPage.ERROR_MESSAGE).getText());
    }

    @DisplayName("Выход из портала")
    @org.junit.jupiter.api.Test
    public void logout() {
        loginPage.singIn();
        Assertions.assertEquals("Welcome Paul", driver.findElement(NAME_CLIENT).getText());

        mainPage.clickName().
                clickExit();
        Assertions.assertEquals("LOGIN Panel", driver.findElement(loginPage.LOGIN_PANEL).getText());

    }

    @AfterEach
    public void driverOut() {
        driver.quit();
    }
}
