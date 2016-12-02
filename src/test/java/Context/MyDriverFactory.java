package Context;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class MyDriverFactory {
    private WebDriver driver;

    public WebDriver getDriver(){
        String name = System.getProperty("driver");
        if (name.equals("chrome")){
            driver = new ChromeDriver();}
        if (name.equals("firefox")){
            // "firefox47" this is a profile of Firefox for allow location
            // need create profile on an environment which will run tests
            File pathToBinary = new File("C:\\Program Files (x86)\\Mozilla Firefox_47.0.1\\firefox.exe");
            ProfilesIni profile = new ProfilesIni();
            FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
            FirefoxProfile firefoxProfile = profile.getProfile("firefox47");
            driver = new FirefoxDriver(ffBinary,firefoxProfile);
        }


        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}
