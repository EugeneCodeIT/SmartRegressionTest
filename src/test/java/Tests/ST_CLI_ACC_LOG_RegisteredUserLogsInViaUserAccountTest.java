package Tests;

import Constants.UrlOfPages;
import Context.MyDriverFactory;
import Pages.BasePage;
import Pages.IndexPage;
import Pages.ST_CLI_ACC_LOG_RegisteredUserLogsInViaUserAccount_Page;
import com.Exception;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ST_CLI_ACC_LOG_RegisteredUserLogsInViaUserAccountTest extends BaseTest {
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
     * Fill Email,Password fields by invalid data
     * "Andmelden" button is clicked
     * Check error message
     * Clear email/password fields
     * Enter valid data in email/password fields
     * Parsing captcha
     * Enter captcha in captcha field
     * "Andmelden" button is clicked
     * Check name of logged in user
     * Click on user name
     * Click "Log Out"
     * Check that instead of "user name" appears "Connect"
     */
    @Test(groups = {"ST_CLI_ACC_LOG_RegisteredUserLogsInViaUserAccountTest"})
    public void testLoggedInUserLogsOutViaConnectMenu () throws InterruptedException, IOException, Exception {
        extent.addSystemInfo("Resolution",basePage.getWindowHeight() +"X"+ basePage.getWindowWidth());

        driver.get(UrlOfPages.indexPage);
        test = extent.startTest("Logged In User Logs Out Via Connect Menu", "Verify Logs In Via Connect Menu using captcha");

        String indexPageURL = indexPage.getAssertUrl();
        Assert.assertEquals(indexPageURL, UrlOfPages.indexPage);

        test.log(LogStatus.INFO, basePage.getBrowserName() + basePage.getBrowserVersion());
        test.log(LogStatus.INFO, "Index page is opened");

        indexPage.closeCookiesPopUp();
        //indexPage.psymaPopUpClose();
        indexPage.connectbuttonClick();
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.switchToFrame();
        test.log(LogStatus.INFO, "Connect frame is opened");

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.emailField("user@gmail.com");
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.passwordField("Password");
        test.log(LogStatus.INFO, "Wrong data is entered");
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.submitButtonClick();

        String serverSideError = st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.serverSideError();
        Assert.assertEquals(serverSideError, "Anmeldung fehlgeschlagen. Bitte überprüfen Sie Ihre Zugangsdaten.");
        test.log(LogStatus.INFO, "Error message is displayed");

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.clearEmailField();
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.clearPasswordField();
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.emailField("tg_tester@outlook.de");
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.passwordField("Testen123");

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.captcha();
        test.log(LogStatus.INFO, "Captcha is entered");

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
