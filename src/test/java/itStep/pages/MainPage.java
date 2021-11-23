package itStep.pages;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private final WebDriver driver;
    public static final By NAME_CLIENT = By.id("welcome");
    private static final By LOG_OUT = By.xpath("//a[@href='/index.php/auth/logout']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Выход из личного кабинета")
    public void clickExit() {
        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(LOG_OUT));
        driver.findElement(LOG_OUT).click();
    }

    @Step("Открываем выпадающее меню")
    public MainPage clickName() {
        driver.findElement(NAME_CLIENT).click();
        return this;
    }


}
