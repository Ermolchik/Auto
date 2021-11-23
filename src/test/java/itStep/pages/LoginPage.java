package itStep.pages;

import io.qameta.allure.Step;
import itStep.resurses.Const;
import itStep.tests.Test;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    private final By LOGIN = By.id("txtUsername");
    private final By PASSWORD = By.id("txtPassword");
    private final By BUTTON_SING = By.id("btnLogin");
    public final By LOGIN_PANEL = By.id("logInPanelHeading");
    public final By ERROR_MESSAGE = By.id("spanMessage");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Вводим логин")
    public LoginPage sendLogin(String login) {
        driver.findElement(LOGIN).sendKeys(login);
        return this;
    }

    @Step("Вводим пароль")
    public LoginPage sendPassword(String password) {
       driver.findElement(PASSWORD).sendKeys(password);
        return this;
    }

    @Step("Нажимаем кнопку войти")
    public LoginPage clickButton() {
        driver.findElement(BUTTON_SING).click();
        return this;
    }

    @Step("Полная авторизация")
    public void singIn(){
        sendLogin(Const.LOGIN);
        sendPassword(Const.PASSWORD);
        clickButton();
    }

}
