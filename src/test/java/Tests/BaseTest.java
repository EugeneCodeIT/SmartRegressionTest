package Tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class BaseTest {
    protected WebDriver driver;

    @AfterMethod
    public void tearSuite() throws Exception {
        driver.quit();
    }
}
