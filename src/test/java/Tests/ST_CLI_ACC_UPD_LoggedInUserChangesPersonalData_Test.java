package Tests;

import Constants.UrlOfPages;
import Context.MyDriverFactory;
import Pages.*;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ST_CLI_ACC_UPD_LoggedInUserChangesPersonalData_Test extends BaseTest{
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
    public void testLoggedInUserChangesPersonalData () throws InterruptedException {
        extent.addSystemInfo("Resolution",basePage.getWindowHeight() +"X"+ basePage.getWindowWidth());

        driver.get(UrlOfPages.indexPage);
        test = extent.startTest("Logged in user changes personal data", "Verify Logged in user changes personal data");

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
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.submitButtonClick();

        String userName = indexPage.UserName();
        Assert.assertEquals(userName, "Test");
        test.log(LogStatus.INFO, "User is logged in");

        indexPage.hoverConnectButton();
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.profileButtonClick();
        st_cli_acc_upd_loggedInUserChangesEmailAddress_page.clickEditPersonalData();
        test.log(LogStatus.INFO, "\"Bearbeiten\" button is visible");
        System.out.println(BasePage.Data());
        String data = BasePage.Data();
        st_cli_acc_upd_loggedInUserChangesEmailAddress_page.enterPersonalData("12345 "+ BasePage.Data(), "Teststrasse 123", "123", "Testhausen","12345");
        test.log(LogStatus.INFO, "\"Speichern\" button is visible");
        test.log(LogStatus.INFO, "Data is changed");

        String mobileField = st_cli_acc_upd_loggedInUserChangesEmailAddress_page.mobileField();
        Assert.assertEquals(mobileField, "12345 "+data);

        String streetField = st_cli_acc_upd_loggedInUserChangesEmailAddress_page.streetField();
        Assert.assertEquals(streetField, "Teststrasse 123");

        String houseNumberField = st_cli_acc_upd_loggedInUserChangesEmailAddress_page.houseNumberField();
        Assert.assertEquals(houseNumberField, "123");

        String cityField = st_cli_acc_upd_loggedInUserChangesEmailAddress_page.cityField();
        Assert.assertEquals(cityField, "Testhausen");

        String postalCodeField = st_cli_acc_upd_loggedInUserChangesEmailAddress_page.postalCodeField();
        Assert.assertEquals(postalCodeField, "12345");

        test.log(LogStatus.INFO, "Changes are applied");
    }
}
