package Tests;

import Constants.UrlOfPages;
import Context.MyDriverFactory;
import Pages.ST_CAN_REQ_CRE_AnonymousUserOrdersBrochure_Page;
import Pages.IndexPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ST_CAN_REQ_CRE_AnonymousUserOrdersBrochure_Test extends BaseTest{

    ST_CAN_REQ_CRE_AnonymousUserOrdersBrochure_Page st_can_req_cre_anonymousUserOrdersBrochure_page;
    IndexPage indexPage;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new MyDriverFactory().getDriver();
        st_can_req_cre_anonymousUserOrdersBrochure_page = new ST_CAN_REQ_CRE_AnonymousUserOrdersBrochure_Page(driver);
        indexPage = new IndexPage(driver);
    }

    /**
     * This test is:
     * opens "Broschüre bestellen" (order brochure) via URL
     * checks url
     * closes psyma PopUp
     * checks that all mandatory fields are marked with a star
     */
    @Test
    public void testBroschureOrderViaURL() {
        driver.get(UrlOfPages.brochureOrder2);

        String broschüreBestellenURL = st_can_req_cre_anonymousUserOrdersBrochure_page.getAssertUrl();
        Assert.assertEquals(broschüreBestellenURL, UrlOfPages.brochureOrder2);

        indexPage.psymaPopUpClose();

        st_can_req_cre_anonymousUserOrdersBrochure_page.bodyCheck();
        st_can_req_cre_anonymousUserOrdersBrochure_page.adresstypCheck();
        st_can_req_cre_anonymousUserOrdersBrochure_page.anredeCheck();
        st_can_req_cre_anonymousUserOrdersBrochure_page.vornameCheck();
        st_can_req_cre_anonymousUserOrdersBrochure_page.nachnameCheck();
        st_can_req_cre_anonymousUserOrdersBrochure_page.straßeCheck();
        st_can_req_cre_anonymousUserOrdersBrochure_page.plzCheck();
        st_can_req_cre_anonymousUserOrdersBrochure_page.wohnortCheck();
        st_can_req_cre_anonymousUserOrdersBrochure_page.emailCheck();
        st_can_req_cre_anonymousUserOrdersBrochure_page.informationsmaterialCheck();
        st_can_req_cre_anonymousUserOrdersBrochure_page.perTelefonCheck();
        st_can_req_cre_anonymousUserOrdersBrochure_page.perElektronischerPostCheck();
        st_can_req_cre_anonymousUserOrdersBrochure_page.perPostCheck();

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
    @Test
    public void testSelectBroschureOrderFromSideNavigator() {
        driver.get(UrlOfPages.indexPage);

        String indexPageURL = indexPage.getAssertUrl();
        Assert.assertEquals(indexPageURL, UrlOfPages.indexPage);

        indexPage.closeCookiesPopUp();

        indexPage.brochureOrderClick();

        String brochureOrderURL = indexPage.getAssertUrl();
        Assert.assertEquals(brochureOrderURL, UrlOfPages.brochureOrder1);

        indexPage.psymaPopUpClose();

        st_can_req_cre_anonymousUserOrdersBrochure_page.adresstypCheck();
        st_can_req_cre_anonymousUserOrdersBrochure_page.anredeCheck();
        st_can_req_cre_anonymousUserOrdersBrochure_page.vornameCheck();
        st_can_req_cre_anonymousUserOrdersBrochure_page.nachnameCheck();
        st_can_req_cre_anonymousUserOrdersBrochure_page.straßeCheck();
        st_can_req_cre_anonymousUserOrdersBrochure_page.plzCheck();
        st_can_req_cre_anonymousUserOrdersBrochure_page.wohnortCheck();
        st_can_req_cre_anonymousUserOrdersBrochure_page.emailCheck();
        st_can_req_cre_anonymousUserOrdersBrochure_page.informationsmaterialCheck();
        //??? not acceptUsingPersonalData() without accept
        st_can_req_cre_anonymousUserOrdersBrochure_page.perTelefonCheck();
        st_can_req_cre_anonymousUserOrdersBrochure_page.perElektronischerPostCheck();
        st_can_req_cre_anonymousUserOrdersBrochure_page.perPostCheck();
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
    @Test
    public void testSelectBroschureOrderAndFillForm() {
        driver.get(UrlOfPages.indexPage);

        String indexPageURL = indexPage.getAssertUrl();
        Assert.assertEquals(indexPageURL, UrlOfPages.indexPage);

        indexPage.closeCookiesPopUp();

        indexPage.brochureOrderClick();

        String brochureOrderURL = indexPage.getAssertUrl();
        Assert.assertEquals(brochureOrderURL, UrlOfPages.brochureOrder1);

        indexPage.psymaPopUpClose();

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

        indexPage.succesPage();
    }

}