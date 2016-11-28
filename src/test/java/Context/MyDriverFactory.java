package Context;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import java.util.concurrent.TimeUnit;

public class MyDriverFactory {
    private WebDriver driver;

    public WebDriver getDriver(){
        String name = System.getProperty("driver");
        if (name.equals("chrome")){
            driver = new ChromeDriver();}
        if (name.equals("firefox")){
            ProfilesIni profile = new ProfilesIni();
            // "profileAutomation" this is a profile of Firefox for allow location
            // need create profile on an environment which will run tests
            FirefoxProfile myprofile = profile.getProfile("profileAutomation");
            driver = new FirefoxDriver(myprofile);}


        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
