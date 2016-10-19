package Context;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyDriverFactory {
    private WebDriver driver;

    public WebDriver getDriver(){
        String name = System.getProperty("driver");
        if (name.equals("chrome")){
            driver = new ChromeDriver();}

        driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
