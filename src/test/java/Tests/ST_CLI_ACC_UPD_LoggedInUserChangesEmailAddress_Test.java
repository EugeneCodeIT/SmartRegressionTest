package Tests;

import Constants.UrlOfPages;
import Context.ExtentManager;
import Context.MyDriverFactory;
import Pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ST_CLI_ACC_UPD_LoggedInUserChangesEmailAddress_Test extends BaseTest{
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

    @Test(priority = 1, groups = {"ST_CLI_ACC_UPD_LoggedInUserChangesEmailAddress_Test"})
    public void testClearSmart_automater2MailBox(){
        test = extent.startTest(BasePage.Data()+" ST_CLI_ACC_UPD Logged in user changes e-mail address", "Verify Logged in user changes e-mail address");
        test.log(LogStatus.INFO, basePage.getBrowserName() + basePage.getBrowserVersion());

        test.log(LogStatus.INFO, "Login to smart_automater2@outlook.com mail box");

        driver.get(UrlOfPages.hotmail);
        hotmailPage.emailLogin("smart_automater2@outlook.com", "Testen123");
        hotmailPage.deleteMails();
        test.log(LogStatus.INFO, "Delete all mails");
        test.log(LogStatus.INFO, "Mail box is clear");
    }

    @Test(priority = 2, groups = {"ST_CLI_ACC_UPD_LoggedInUserChangesEmailAddress_Test"})
    public void testClearSmart_automaterMailBox(){

        driver.get(UrlOfPages.hotmail);
        hotmailPage.emailLogin("smart_automater@outlook.com", "Testen123");
        hotmailPage.deleteMails();
        test.log(LogStatus.INFO, "Mail box is clear");
    }

    @Test(priority = 3, groups = {"ST_CLI_ACC_UPD_LoggedInUserChangesEmailAddress_Test"})
    public void testLoggedInUserChangesEmailAddress () throws InterruptedException {
        extent.addSystemInfo("Resolution",basePage.getWindowHeight() +"X"+ basePage.getWindowWidth());

        driver.get(UrlOfPages.indexPage);

        String indexPageURL = indexPage.getAssertUrl();
        Assert.assertEquals(indexPageURL, UrlOfPages.indexPage);

        test.log(LogStatus.INFO, "Index page of smart.com is opened");

        indexPage.closeCookiesPopUp();
        //indexPage.psymaPopUpClose();
        indexPage.connectbuttonClick();

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.switchToFrame();
        test.log(LogStatus.INFO, "Connect frame is opened");

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.emailField("smart_automater@outlook.com");
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.passwordField("Testen123");
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.submitButtonClick();
        test.log(LogStatus.INFO, test.addScreenCapture(ExtentManager.CaptureScreen(driver,"./images/"+ basePage.random())));

        String userName = indexPage.getUserName();
        Assert.assertEquals(userName, "TEST");
        test.log(LogStatus.INFO, "User is logged in");

        indexPage.connectbuttonClick();
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.profileButtonClick();
        st_cli_acc_upd_loggedInUserChangesEmailAddress_page.clickEditmailButton();
        test.log(LogStatus.INFO, "Popup to enter new -email-adress and password opens");

        st_cli_acc_upd_loggedInUserChangesEmailAddress_page.editMail("smart_automater2@outlook.com", "Testen123");
        test.log(LogStatus.INFO, "Data with new email is entered");
        test.log(LogStatus.INFO, "Change email popup is appeared");
        test.log(LogStatus.INFO, "Submit button is clicked");}

    @Test(priority = 4, groups = {"ST_CLI_ACC_UPD_LoggedInUserChangesEmailAddress_Test"})
    public void testConfirmNewEmail() throws InterruptedException {
        driver.get(UrlOfPages.hotmail);
        hotmailPage.emailLogin("smart_automater2@outlook.com", "Testen123");
        hotmailPage.clickOnChangeEmail();
        test.log(LogStatus.INFO, "Mail of confirm new email in profile is come");
        hotmailPage.clickOnChangeEmailVerificationLink();

        st_cli_acc_upd_loggedInUserChangesEmailAddress_page.submitNewEmail();
        test.log(LogStatus.INFO, "Submit new email page is displayed");

        test.log(LogStatus.INFO, "Homepage after submitting new Email is displayed successfully");}

    @Test(priority = 5, groups = {"ST_CLI_ACC_UPD_LoggedInUserChangesEmailAddress_Test"})
    public void testLoginWithNewEmail() throws InterruptedException {
        driver.get(UrlOfPages.indexPage);

        String indexPageURL = indexPage.getAssertUrl();
        Assert.assertEquals(indexPageURL, UrlOfPages.indexPage);

        test.log(LogStatus.INFO, "Index page of smart.com is opened");

        indexPage.closeCookiesPopUp();
        //indexPage.psymaPopUpClose();
        indexPage.connectbuttonClick();

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.switchToFrame();
        test.log(LogStatus.INFO, "Connect frame is opened");

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.emailField("smart_automater2@outlook.com");
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.passwordField("Testen123");
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.submitButtonClick();
        test.log(LogStatus.INFO, test.addScreenCapture(ExtentManager.CaptureScreen(driver,"./images/"+ basePage.random())));

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.waitNameInConnectButton();
        String userName = indexPage.getUserName();
        Assert.assertEquals(userName, "TEST");
        test.log(LogStatus.INFO, "User is logged in with new email successfully");

        indexPage.connectbuttonClick();

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.profileButtonClick();

        String newEmail = st_cli_acc_upd_loggedInUserChangesEmailAddress_page.checkNewEmail();
        System.out.println(newEmail);
        Assert.assertEquals(newEmail,"smart_automater2@outlook.com");
        test.log(LogStatus.INFO, "New email is displayed in email field");}

    @Test(priority = 6, groups = {"ST_CLI_ACC_UPD_LoggedInUserChangesEmailAddress_Test"})
    public void testChangeEmailBack() throws InterruptedException {
        driver.get(UrlOfPages.indexPage);

        String indexPageURL = indexPage.getAssertUrl();
        Assert.assertEquals(indexPageURL, UrlOfPages.indexPage);

        test.log(LogStatus.INFO, "Index page of smart.com is opened");

        indexPage.closeCookiesPopUp();
        //indexPage.psymaPopUpClose();
        indexPage.connectbuttonClick();

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.switchToFrame();
        test.log(LogStatus.INFO, "Connect frame is opened");

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.emailField("smart_automater2@outlook.com");
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.passwordField("Testen123");
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.submitButtonClick();
        test.log(LogStatus.INFO, test.addScreenCapture(ExtentManager.CaptureScreen(driver,"./images/"+ basePage.random())));

        String userName = indexPage.getUserName();
        Assert.assertEquals(userName, "TEST");
        test.log(LogStatus.INFO, "User is logged in with new email");

        indexPage.connectbuttonClick();

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.profileButtonClick();

        st_cli_acc_upd_loggedInUserChangesEmailAddress_page.clickEditmailButton();
        st_cli_acc_upd_loggedInUserChangesEmailAddress_page.editMail("smart_automater@outlook.com", "Testen123");
        test.log(LogStatus.INFO, "New email is filled successfully");}

    @Test(priority = 7, groups = {"ST_CLI_ACC_UPD_LoggedInUserChangesEmailAddress_Test"})
    public void testConfirmNewEmailBack() throws InterruptedException {

        driver.get(UrlOfPages.hotmail);
        hotmailPage.emailLogin("smart_automater@outlook.com", "Testen123");
        hotmailPage.clickOnChangeEmail();
        test.log(LogStatus.INFO, "Mail of confirm new email in profile is come");

        hotmailPage.clickOnChangeEmailVerificationLink();
        st_cli_acc_upd_loggedInUserChangesEmailAddress_page.submitNewEmail();
        test.log(LogStatus.INFO, "Submit new email page is displayed");

        indexPage.closeCookiesPopUp();

        indexPage.connectbuttonClick();

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.profileButtonClick();

        String newEmail = st_cli_acc_upd_loggedInUserChangesEmailAddress_page.checkNewEmail();
        System.out.println(newEmail);
        Assert.assertEquals(newEmail,"smart_automater@outlook.com");
        test.log(LogStatus.INFO, "Email was changed back successfully");}
}
