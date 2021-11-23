package itStep.resurses;


import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static itStep.resurses.Const.*;

public class Driver {
    // Пока не применяется
//    static WebDriver driver = null;
//    public static WebDriver startDriver(TypeBrowser typeBrowser) {
//
//        switch (typeBrowser){
//            case CHROME:
//                System.setProperty(NAME_DRIVER, HOME_DRIVER);
//                driver = new ChromeDriver();
//                break;
//            case FIREFOX:
//                break;
//            default:
//                Assertions.fail("Поломалося");
//        }
//
//        driver.manage().deleteAllCookies();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
////        driver.get(Const.BASE_URL);
//
//        Capabilities caps = ((RemoteWebDriver) driver).getCapabilities();
//
//        String browserName = caps.getBrowserName();
//        String browserVersion = caps.getVersion();
//        System.out.println(browserName + "  " + browserVersion);
//        return driver;
//    }
//
//    public static void close(){
//        driver.quit();
//    }

}