package Tests;

import Constants.UrlOfPages;
import Context.MyDriverFactory;
import Pages.BasePage;
import Pages.IndexPage;
import Pages.ST_CLI_ACC_LOG_RegisteredUserLogsInViaUserAccount_Page;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ST_CLI_ACC_OUT_LoggedInUserLogsOutViaConnectMenu_Test extends BaseTest {

    ST_CLI_ACC_LOG_RegisteredUserLogsInViaUserAccount_Page st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page;
    IndexPage indexPage;
    BasePage basePage;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new MyDriverFactory().getDriver();
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page = new ST_CLI_ACC_LOG_RegisteredUserLogsInViaUserAccount_Page(driver);
        indexPage = new IndexPage(driver);
        basePage = new BasePage(driver);
    }

    /**
     * This test is:
     * Click "Connect button"
     * Fill Email,Password fields by valid data
     * "Andmelden" button is clicked
     * Check name of logged in user
     * Click on user name
     * Click "Log Out"
     * Check that instead of "user name" appears "Connect"
     */
    @Test(groups = {"ST_CLI_ACC_OUT_LoggedInUserLogsOutViaConnectMenu_Test"})
    public void testLoggedInUserLogsOutViaConnectMenu () throws InterruptedException {
        extent.addSystemInfo("Resolution",basePage.getWindowHeight() +"X"+ basePage.getWindowWidth());

        driver.get(UrlOfPages.indexPage);
        test = extent.startTest("Logged In User Logs Out Via Connect Menu", "Verify Logs Out Via Connect Menu");

        String indexPageURL = indexPage.getAssertUrl();
        Assert.assertEquals(indexPageURL, UrlOfPages.indexPage);

        test.log(LogStatus.INFO, basePage.getBrowserName() + basePage.getBrowserVersion());
        test.log(LogStatus.INFO, "Index page is opened");

        indexPage.closeCookiesPopUp();
        //indexPage.psymaPopUpClose();
        indexPage.connectbuttonClick();
        test.log(LogStatus.INFO, "Connect frame is opened");

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.switchToFrame();

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.emailField("tg_tester@outlook.de");
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.passwordField("Testen123");
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.rememberMeCheckCheckbox();
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.submitButtonClick();
        test.log(LogStatus.INFO, "All fields is filled by valid data");

        String userName = indexPage.getUserName();
        Assert.assertEquals(userName, "Test");
        test.log(LogStatus.INFO, "User name is displayed");


        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.switchToWebPage();
        indexPage.connectbuttonClick();
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.logoutButtonClick();

        String connectButtonName = indexPage.getConnectButtonName();
        Assert.assertEquals(connectButtonName, "Connect");
        test.log(LogStatus.INFO, "User is logged out successfully");
    }
}
