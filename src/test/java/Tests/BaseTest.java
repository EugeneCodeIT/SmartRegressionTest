package Tests;

import Context.ExtentManager;
import Pages.BasePage;
import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected WebDriver driver;
    protected ExtentReports extent;
    protected ExtentTest test;

    @AfterMethod
    protected void afterMethod(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(LogStatus.FAIL, result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
        } else {
            test.log(LogStatus.PASS, "Test passed");
        }

        extent.endTest(test);
        extent.flush();
        driver.quit();

    }
    @BeforeClass
    public void M1(){
        extent = ExtentManager.Instance();
    }
    @AfterClass
    public void tear() throws Exception {
        extent.endTest(test);
        extent.flush();
        extent.close();
    }
}
