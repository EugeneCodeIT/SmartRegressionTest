package Tests;

import Constants.UrlOfPages;
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

    @Test
    public void testLoggedInUserChangesEmailAddress () throws InterruptedException {
        extent.addSystemInfo("Resolution",basePage.getWindowHeight() +"X"+ basePage.getWindowWidth());

        driver.get(UrlOfPages.hotmail);
        hotmailPage.emailLogin("smart_automater2@outlook.com", "Testen123");
        hotmailPage.deleteMails();

        driver.get(UrlOfPages.indexPage);
        test = extent.startTest("Logged in user changes e-mail address", "Verify Logged in user changes e-mail address");

        String indexPageURL = indexPage.getAssertUrl();
        Assert.assertEquals(indexPageURL, UrlOfPages.indexPage);

        test.log(LogStatus.INFO, basePage.getBrowserName() + basePage.getBrowserVersion());
        test.log(LogStatus.INFO, "Index page is opened");

        indexPage.closeCookiesPopUp();
        //indexPage.psymaPopUpClose();
        indexPage.connectbuttonClick();
        test.log(LogStatus.INFO, "Connect frame is opened");

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.switchToFrame();

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.emailField("smart_automater@outlook.com");
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.passwordField("Testen123");
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.rememberMeCheckCheckbox();
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.submitButtonClick();

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
        test.log(LogStatus.INFO, "Submit button is clicked");

        driver.get(UrlOfPages.hotmail);
        hotmailPage.clickOnChangeEmail();
        test.log(LogStatus.INFO, "Mail of confirm new email in profile is come");
        String browserFirst = driver.getWindowHandle();
        hotmailPage.clickOnChangeEmailVerificationLink();

        st_cli_acc_upd_loggedInUserChangesEmailAddress_page.submitNewEmail();
        test.log(LogStatus.INFO, "Submit new email page is displayed");

        indexPageURL = indexPage.getAssertUrl();
        Assert.assertEquals(indexPageURL, UrlOfPages.homePageAfterSubmittingNewEmail);

        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.profileButtonClick();

        String newEmail = st_cli_acc_upd_loggedInUserChangesEmailAddress_page.checkNewEmail();
        System.out.println(newEmail);
        Assert.assertEquals(newEmail,"smart_automater2@outlook.com");
        test.log(LogStatus.INFO, "New email is set successfully");

        st_cli_acc_upd_loggedInUserChangesEmailAddress_page.clickEditmailButton();
        st_cli_acc_upd_loggedInUserChangesEmailAddress_page.editMail("smart_automater@outlook.com", "Testen123");
        driver.get(UrlOfPages.hotmail);
        hotmailPage.logOutFromMail();
        driver.get(UrlOfPages.hotmail);
        hotmailPage.emailLogin("smart_automater@outlook.com", "Testen123");
        hotmailPage.clickOnChangeEmail();
        String browserSecond = driver.getWindowHandle();
        hotmailPage.clickOnChangeEmailVerificationLink();
        st_cli_acc_upd_loggedInUserChangesEmailAddress_page.submitNewEmail();

        indexPageURL = indexPage.getAssertUrl();
        Assert.assertEquals(indexPageURL, UrlOfPages.homePageAfterSubmittingNewEmail);
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.profileButtonClick();

        newEmail = st_cli_acc_upd_loggedInUserChangesEmailAddress_page.checkNewEmail();
        System.out.println(newEmail);
        Assert.assertEquals(newEmail,"smart_automater@outlook.com");
        test.log(LogStatus.INFO, "Email was changed back successfully");

        driver.get(UrlOfPages.hotmail);
        hotmailPage.deleteMails();

        driver.close();
        hotmailPage.switchToParntHandle(browserFirst);
        driver.close();
        hotmailPage.switchToParntHandle(browserSecond);
    }
}
