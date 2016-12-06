package Tests;

import Constants.UrlOfPages;
import Context.MyDriverFactory;
import Pages.*;
import com.Exception;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class ST_CAN_REQ_CRE_AnonymousUserCreatesCONNECTAccountByEmail_Test extends BaseTest {
    ST_CAN_REQ_CRE_AnonymousUserCreatesCONNECTAccountByEmail_Page st_can_req_cre_anonymousUserCreatesCONNECTAccountByEmail_page;
    ST_CLI_ACC_LOG_RegisteredUserLogsInViaUserAccount_Page st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page;
    IndexPage indexPage;
    BasePage basePage;
    HotmailPage hotmailPage;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new MyDriverFactory().getDriver();
        st_can_req_cre_anonymousUserCreatesCONNECTAccountByEmail_page = new ST_CAN_REQ_CRE_AnonymousUserCreatesCONNECTAccountByEmail_Page(driver);
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page = new ST_CLI_ACC_LOG_RegisteredUserLogsInViaUserAccount_Page(driver);
        indexPage = new IndexPage(driver);
        basePage = new BasePage(driver);
        hotmailPage = new HotmailPage(driver);
    }

    /**
     * This test is:
     * Clicks "Connect button"
     * Clicks "Jetzt registrieren" button
     * Fills all required fields with captcha
     * Clicks "Registrieren" button
     * Opens mail box
     * Clicks "Registrierung abschließen" link
     * Fills password fileds
     * Clicks "Weiter" button
     * Checks that name of created user is displayed under connect logo
     */
    @Test(groups = {"ST_CAN_REQ_CRE_AnonymousUserCreatesCONNECTAccountByEmail_Test"})
    public void testLoggedInUserLogsOutViaConnectMenu() throws InterruptedException, IOException, Exception {
        extent.addSystemInfo("Resolution",basePage.getWindowHeight()+"X"+basePage.getWindowWidth());

        driver.get(UrlOfPages.hotmail);
        hotmailPage.emailLogin("smart_automater@outlook.com", "Testen123");
        hotmailPage.deleteMails();

        driver.get(UrlOfPages.indexPage);
        test = extent.startTest(BasePage.Data()+" Anonymous user creates CONNECT account by e-mail","Verify Anonymous user creates CONNECT account by e-mail");

        String indexPageURL = indexPage.getAssertUrl();
        Assert.assertEquals(indexPageURL, UrlOfPages.indexPage);

        test.log(LogStatus.INFO,basePage.getBrowserName()+basePage.getBrowserVersion());
        test.log(LogStatus.INFO,"Index page is opened");

        indexPage.closeCookiesPopUp();
        //indexPage.psymaPopUpClose();
        indexPage.connectbuttonClick();
        st_cli_acc_log_RegisteredUserLogsInViaUserAccount_page.switchToFrame();
        test.log(LogStatus.INFO, "Connect frame is opened");

        st_can_req_cre_anonymousUserCreatesCONNECTAccountByEmail_page.registerButtonClick();
        st_can_req_cre_anonymousUserCreatesCONNECTAccountByEmail_page.andredeRadioButton();
        st_can_req_cre_anonymousUserCreatesCONNECTAccountByEmail_page.firstNameField("TEST");
        st_can_req_cre_anonymousUserCreatesCONNECTAccountByEmail_page.lastNameField("ST_CAN_REQ_CRE - Anonymous user creates CONNECT account by e-mail");

        Random rand = new Random();
        int n = rand.nextInt(99999)+1;
        String email = "smart_automater+"+n+"@outlook.com";

        st_can_req_cre_anonymousUserCreatesCONNECTAccountByEmail_page.emailField(email);
        st_can_req_cre_anonymousUserCreatesCONNECTAccountByEmail_page.rEmailField(email);

        st_can_req_cre_anonymousUserCreatesCONNECTAccountByEmail_page.captcha();
        test.log(LogStatus.INFO, "Captcha is successful");
        test.log(LogStatus.INFO, "All fields are filled");
        test.log(LogStatus.INFO, "Confirmation Title is displayed");

        driver.get(UrlOfPages.hotmail);
        hotmailPage.clickOnConfirmationEmail();
        test.log(LogStatus.INFO, "Mail is come");
        String parentHandle = driver.getWindowHandle();
        hotmailPage.clickOnVerificationLink();

        st_can_req_cre_anonymousUserCreatesCONNECTAccountByEmail_page.createPassword("Testen123");
        test.log(LogStatus.INFO, "New password fields are filled");
        st_can_req_cre_anonymousUserCreatesCONNECTAccountByEmail_page.checkSuccessfulText();
        test.log(LogStatus.INFO, "Registration successful text is displayed");

        String userName = indexPage.getUserName();
        Assert.assertEquals(userName, "TEST");
        test.log(LogStatus.INFO, "After clicking weiter button user is logged in Successful");

        driver.close();
        hotmailPage.switchToParntHandle(parentHandle);

    }
}
