package itStep.tests;


import itStep.pages.LoginPage;
import itStep.pages.MainPage;
import jdk.jfr.Description;
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

    @org.junit.jupiter.api.Test
    @Description("Авторизация с валидными данными")
    public void loginTest() {
        loginPage.sendLogin(LOGIN).
                sendPassword(PASSWORD).
                clickButton();

        Assertions.assertEquals("Welcome Paul", driver.findElement(NAME_CLIENT).getText());

    }

    @org.junit.jupiter.api.Test
    @Description("Авторизация с невалидным паролем")
    public void wrongPassTest() {

        loginPage.sendLogin(LOGIN).
                sendPassword(WRONG_PASSWORD).
                clickButton();

        Assertions.assertEquals("Invalid credentials", driver.findElement(loginPage.ERROR_MESSAGE).getText());
    }

    @org.junit.jupiter.api.Test
    @Description("Авторизация с без пароля")
    public void noPassTest() {
        loginPage.sendLogin(LOGIN).
                clickButton();

        Assertions.assertEquals("Password cannot be empty", driver.findElement(loginPage.ERROR_MESSAGE).getText());
    }

    @org.junit.jupiter.api.Test
    @Description("Авторизация с невалидным логином")
    public void wrongLogTest() {
        loginPage.sendLogin(WRONG_LOGIN).
                sendPassword(PASSWORD).
                clickButton();

        Assertions.assertEquals("Invalid credentials", driver.findElement(loginPage.ERROR_MESSAGE).getText());
    }

    @org.junit.jupiter.api.Test
    @Description("Выход из портала")
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
