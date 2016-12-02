package Tests;


import Constants.UrlOfPages;
import Context.MyDriverFactory;
import Pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ST_CLI_ACC_UPD_LoggedInUserChangesPassword_Test extends BaseTest{
    ST_CLI_ACC_LOG_RegisteredUserLogsInViaUserAccount_Page st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page;
    ST_CLI_ACC_UPD_LoggedInUserChangesEmailAddress_Page st_cli_acc_upd_loggedInUserChangesEmailAddress_page;
    IndexPage indexPage;
    BasePage basePage;
    HotmailPage hotmailPage;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new MyDriverFactory().getDriver();
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page = new ST_CLI_ACC_LOG_RegisteredUserLogsInViaUserAccount_Page(driver);
        st_cli_acc_upd_loggedInUserChangesEmailAddress_page = new ST_CLI_ACC_UPD_LoggedInUserChangesEmailAddress_Page(driver);
        indexPage = new IndexPage(driver);
        basePage = new BasePage(driver);
        hotmailPage = new HotmailPage(driver);
    }

    @Test(priority=1, groups = {"ST_CLI_ACC_UPD_LoggedInUserChangesPassword_Test"})
    public void testLoggedInUserChangesPassword () throws InterruptedException {
        extent.addSystemInfo("Resolution", basePage.getWindowHeight() + "X" + basePage.getWindowWidth());

        driver.get(UrlOfPages.indexPage);
        test = extent.startTest("ST_CLI_ACC_UPD Logged in user changes password", "Verify Logged in user changes password");

        String indexPageURL = indexPage.getAssertUrl();
        Assert.assertEquals(indexPageURL, UrlOfPages.indexPage);

        test.log(LogStatus.INFO, basePage.getBrowserName() + basePage.getBrowserVersion());
        test.log(LogStatus.INFO, "Index page is opened");

        indexPage.closeCookiesPopUp();
        //indexPage.psymaPopUpClose();
        indexPage.connectbuttonClick();

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.switchToFrame();
        test.log(LogStatus.INFO, "Connect frame is opened");

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.emailField("tg_tester@outlook.de");
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.passwordField("Testen123");
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.submitButtonClick();

        String userName = indexPage.UserName();
        Assert.assertEquals(userName, "Test");
        test.log(LogStatus.INFO, "User is logged in");

        indexPage.hoverConnectButton();
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.profileButtonClick();
        st_cli_acc_upd_loggedInUserChangesEmailAddress_page.clickEditPasswordButton();
        test.log(LogStatus.INFO, "Popup to enter new password opens");

        st_cli_acc_upd_loggedInUserChangesEmailAddress_page.editPassword("Testen123", "Testen123#");

        test.log(LogStatus.INFO, "Change pass popup is appeared");
        test.log(LogStatus.INFO, "Data with new pass is entered");
        test.log(LogStatus.INFO, "Submit button is clicked");

        indexPage.hoverConnectButton();
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.logoutFromEditProfile();

        String connectButtonName = indexPage.getConnectButtonName();
        Assert.assertEquals(connectButtonName, "Connect");
        test.log(LogStatus.INFO, "User is logged out successfully");
    }

    @Test(priority=2, groups = {"ST_CLI_ACC_UPD_LoggedInUserChangesPassword_Test"})
    public void testLoginByChangedPassword() throws InterruptedException {
        extent.addSystemInfo("Resolution", basePage.getWindowHeight() + "X" + basePage.getWindowWidth());

        driver.get(UrlOfPages.indexPage);
        test = extent.startTest("ST_CLI_ACC_UPD Login By Changed Password", "Verify Login By Changed Password");
        test.log(LogStatus.INFO, basePage.getBrowserName() + basePage.getBrowserVersion());

        indexPage.closeCookiesPopUp();

        indexPage.connectbuttonClick();

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.switchToFrame();

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.emailField("tg_tester@outlook.de");
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.passwordField("Testen123#");
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.submitButtonClick();

        String userName = indexPage.getUserName();
        Assert.assertEquals(userName, "Test");
        test.log(LogStatus.INFO, "User is logged in with new password successfully");}

    @Test(priority = 3, groups = {"ST_CLI_ACC_UPD_LoggedInUserChangesPassword_Test"})
    public void testChangePasswordBack() throws InterruptedException {
        driver.get(UrlOfPages.indexPage);
        test = extent.startTest("ST_CLI_ACC_UPD Change Password Back", "Verify Change Password Back");
        test.log(LogStatus.INFO, basePage.getBrowserName() + basePage.getBrowserVersion());

        indexPage.closeCookiesPopUp();

        indexPage.connectbuttonClick();

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.switchToFrame();

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.emailField("tg_tester@outlook.de");
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.passwordField("Testen123#");
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.submitButtonClick();

        String userName = indexPage.getUserName();
        Assert.assertEquals(userName, "Test");
        test.log(LogStatus.INFO, "User is logged in with new password successfully");

        indexPage.hoverConnectButton();

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.profileButtonClick();
        st_cli_acc_upd_loggedInUserChangesEmailAddress_page.clickEditPasswordButton();
        test.log(LogStatus.INFO, "Popup to enter new password opens");

        st_cli_acc_upd_loggedInUserChangesEmailAddress_page.editPassword("Testen123#", "Testen123");
        test.log(LogStatus.INFO, "Change pass popup is appeared");
        test.log(LogStatus.INFO, "Data with new pass is entered");
        test.log(LogStatus.INFO, "Submit button is clicked");

        indexPage.hoverConnectButton();
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.logoutFromEditProfile();

        String connectButtonName = indexPage.getConnectButtonName();
        Assert.assertEquals(connectButtonName, "Connect");
        test.log(LogStatus.INFO, "User is logged out successfully");

        indexPage.connectbuttonClick();

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.switchToFrame();

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.emailField("tg_tester@outlook.de");
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.passwordField("Testen123");
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.submitButtonClick();

        userName = indexPage.getUserName();
        Assert.assertEquals(userName, "Test");
        test.log(LogStatus.INFO, "User is logged in with changed back password successfully");
    }
}
