package Tests;

import Constants.UrlOfPages;
import Context.MyDriverFactory;
import Pages.BasePage;
import Pages.ST_CAN_REQ_CRE_AnonymousUserOrdersBrochure_Page;
import Pages.IndexPage;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.*;

public class ST_CAN_REQ_CRE_AnonymousUserOrdersBrochure_Test extends BaseTest{

    ST_CAN_REQ_CRE_AnonymousUserOrdersBrochure_Page st_can_req_cre_anonymousUserOrdersBrochure_page;
    IndexPage indexPage;
    BasePage basePage;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new MyDriverFactory().getDriver();
        st_can_req_cre_anonymousUserOrdersBrochure_page = new ST_CAN_REQ_CRE_AnonymousUserOrdersBrochure_Page(driver);
        indexPage = new IndexPage(driver);
        basePage = new BasePage(driver);
    }

    /**
     * This test is:
     * opens (order brochure) via URL
     * checks url
     * closes psyma PopUp
     * checks that all mandatory fields are marked with a star
     */

    @Test(groups = {"ST_CAN_REQ_CRE_AnonymousUserOrdersBrochure_Test"})
    public void testBroschüreBestellen() {
        extent.addSystemInfo("Resolution",basePage.getWindowHeight() +"X"+ basePage.getWindowWidth());

        driver.get(UrlOfPages.broschüre_bestellen);
        test = extent.startTest(BasePage.Data()+" Broschüre Bestellen", "Verify broschüre bestellen");

        String broschüreBestellenURL = st_can_req_cre_anonymousUserOrdersBrochure_page.getAssertUrl();
        Assert.assertEquals(broschüreBestellenURL, UrlOfPages.broschüre_bestellen);

        test.log(LogStatus.INFO, basePage.getBrowserName() + basePage.getBrowserVersion());
        test.log(LogStatus.INFO, "Broschüre bestellen page is opened");


        //indexPage.psymaPopUpClose();

        st_can_req_cre_anonymousUserOrdersBrochure_page.bodyCheck();
        test.log(LogStatus.INFO, "Feedback form is Visible");

        st_can_req_cre_anonymousUserOrdersBrochure_page.adresstypCheck();
        test.log(LogStatus.INFO, "Adresstyp field is marked with asteriks");

        st_can_req_cre_anonymousUserOrdersBrochure_page.anredeCheck();
        test.log(LogStatus.INFO, "Anrede field is marked with asteriks");

        st_can_req_cre_anonymousUserOrdersBrochure_page.vornameCheck();
        test.log(LogStatus.INFO, "Vorname field is marked with asterisk");

        st_can_req_cre_anonymousUserOrdersBrochure_page.nachnameCheck();
        test.log(LogStatus.INFO, "Nachname field is marked with asteriks");

        st_can_req_cre_anonymousUserOrdersBrochure_page.straßeCheck();
        test.log(LogStatus.INFO, "Straße field is marked with asteriks");

        st_can_req_cre_anonymousUserOrdersBrochure_page.plzCheck();
        test.log(LogStatus.INFO, "PLZ field is marked with asterisk");

        st_can_req_cre_anonymousUserOrdersBrochure_page.wohnortCheck();
        test.log(LogStatus.INFO, "Wohnort field is marked with asterisk");

        st_can_req_cre_anonymousUserOrdersBrochure_page.emailCheck();
        test.log(LogStatus.INFO, "Email field is marked with asterisk");

        st_can_req_cre_anonymousUserOrdersBrochure_page.informationsmaterialCheck();
        test.log(LogStatus.INFO, "Informationsmaterial field is marked with asterisk");

        st_can_req_cre_anonymousUserOrdersBrochure_page.perTelefonCheck();
        test.log(LogStatus.INFO, "Per Telefon field is marked with asterisk");

        st_can_req_cre_anonymousUserOrdersBrochure_page.perElektronischerPostCheck();
        test.log(LogStatus.INFO, "Per Telefon field is marked with asterisk");

        st_can_req_cre_anonymousUserOrdersBrochure_page.perPostCheck();
        test.log(LogStatus.INFO, "Per Post field is marked with asterisk");
    }

    /**
     * This test is:
     * opens index page
     * check url
     * closes cookies popup
     * selects (order brochure) from side navigation
     * checks url of order brochure
     * closes psyma PopUp
     * checks that all mandatory fields are marked with a star
     */
    @Test(groups = {"ST_CAN_REQ_CRE_AnonymousUserOrdersBrochure_Test"})
    public void testSelectBroschüreBestellenFromSideNavigator() {
        driver.get(UrlOfPages.indexPage);
        test = extent.startTest(BasePage.Data()+" Select Broschüre Bestellen From Side Navigator", "Verify broschüre bestellen");

        String indexPageURL = indexPage.getAssertUrl();
        Assert.assertEquals(indexPageURL, UrlOfPages.indexPage);
        test.log(LogStatus.INFO, basePage.getBrowserName() + basePage.getBrowserVersion());
        test.log(LogStatus.INFO, "Index Page page is opened");

        indexPage.closeCookiesPopUp();

        indexPage.brochureOrderClick();

        String brochureOrderURL = indexPage.getAssertUrl();
        Assert.assertEquals(brochureOrderURL, UrlOfPages.brochureOrder);
        test.log(LogStatus.INFO, "Brochure Order Page page is opened");

        //indexPage.psymaPopUpClose();

        st_can_req_cre_anonymousUserOrdersBrochure_page.adresstypCheck();
        test.log(LogStatus.INFO, "Adresstyp field is marked with asteriks");

        st_can_req_cre_anonymousUserOrdersBrochure_page.anredeCheck();
        test.log(LogStatus.INFO, "Anrede field is marked with asteriks");

        st_can_req_cre_anonymousUserOrdersBrochure_page.vornameCheck();
        test.log(LogStatus.INFO, "Vorname field is marked with asterisk");

        st_can_req_cre_anonymousUserOrdersBrochure_page.nachnameCheck();
        test.log(LogStatus.INFO, "Nachname field is marked with asteriks");

        st_can_req_cre_anonymousUserOrdersBrochure_page.straßeCheck();
        test.log(LogStatus.INFO, "Straße field is marked with asteriks");

        st_can_req_cre_anonymousUserOrdersBrochure_page.plzCheck();
        test.log(LogStatus.INFO, "PLZ field is marked with asterisk");

        st_can_req_cre_anonymousUserOrdersBrochure_page.wohnortCheck();
        test.log(LogStatus.INFO, "Wohnort field is marked with asterisk");

        st_can_req_cre_anonymousUserOrdersBrochure_page.emailCheck();
        test.log(LogStatus.INFO, "Email field is marked with asterisk");

        st_can_req_cre_anonymousUserOrdersBrochure_page.informationsmaterialCheck();
        test.log(LogStatus.INFO, "Informationsmaterial field is marked with asterisk");

        st_can_req_cre_anonymousUserOrdersBrochure_page.perTelefonCheck();
        test.log(LogStatus.INFO, "Per Telefon field is marked with asterisk");

        st_can_req_cre_anonymousUserOrdersBrochure_page.perElektronischerPostCheck();
        test.log(LogStatus.INFO, "Per Telefon field is marked with asterisk");

        st_can_req_cre_anonymousUserOrdersBrochure_page.perPostCheck();
        test.log(LogStatus.INFO, "Per Post field is marked with asterisk");
    }

    /**
     * This test is:
     * opens index page
     * check url
     * closes cookies popup
     * selects (order brochure) from side navigation
     * checks url of order brochure
     * closes psyma PopUp
     * fills Form and send it (hard coded)
     */
    @Test(groups = {"ST_CAN_REQ_CRE_AnonymousUserOrdersBrochure_Test"})
    public void testSelectBroschüreAndFillForm() {
        driver.get(UrlOfPages.indexPage);
        test = extent.startTest(BasePage.Data()+" Select Broschüre And FillForm", "Verify broschüre bestellen");

        String indexPageURL = indexPage.getAssertUrl();
        Assert.assertEquals(indexPageURL, UrlOfPages.indexPage);
        test.log(LogStatus.INFO, basePage.getBrowserName() + basePage.getBrowserVersion());
        test.log(LogStatus.INFO, "Index Page page is opened");

        indexPage.closeCookiesPopUp();

        indexPage.brochureOrderClick();

        String brochureOrderURL = indexPage.getAssertUrl();
        Assert.assertEquals(brochureOrderURL, UrlOfPages.brochureOrder);
        test.log(LogStatus.INFO, "Brochure Order page is opened");

        //indexPage.psymaPopUpClose();

        indexPage.adresstypSelectCheckBox();
        indexPage.anredeDropListSelect();
        indexPage.vornameTextField("Test");
        indexPage.nachnameTextField("[Test Summary]");
        indexPage.straßeTextField("Teststrasse 123");
        indexPage.plzTextField("12345");
        indexPage.wohnortTextField("Testhausen");
        indexPage.emailTextField("tg_tester@outlook.de");
        indexPage.smartFortwoSelectCheckbox();
        indexPage.firstMonateSelectCheckbox();
        indexPage.acceptUsingPersonalData();
        test.log(LogStatus.INFO, "All data is entered");

        indexPage.succesPage();
        test.log(LogStatus.INFO, "Succes Page page is displayed");
    }

}