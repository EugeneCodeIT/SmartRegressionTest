package Tests;

import Constants.UrlOfPages;
import Context.MyDriverFactory;
import Pages.ST_CAN_REQ_CRE_AnonymousUserConsultationRequest_Page;
import Pages.IndexPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ST_CAN_REQ_CRE_AnonymousUserConsultationRequest_Test extends BaseTest{

    ST_CAN_REQ_CRE_AnonymousUserConsultationRequest_Page st_can_req_cre_anonymousUserConsultationRequest_page;
    IndexPage indexPage;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new MyDriverFactory().getDriver();
        st_can_req_cre_anonymousUserConsultationRequest_page = new ST_CAN_REQ_CRE_AnonymousUserConsultationRequest_Page(driver);
        indexPage = new IndexPage(driver);
    }

    /**
     * This test:
     * opens "Beratung vereinbaren" (consultation request) via URL
     * checks url ???
     * closes Psyma PopUp
     * checks that all mandatory fields are marked with a star
     */
    @Test
    public void testConsultationRequest() {
        driver.get(UrlOfPages.consultationRequest1);

        String consultationRequestURL = st_can_req_cre_anonymousUserConsultationRequest_page.getAssertUrl();

        //???
        Assert.assertEquals(consultationRequestURL, UrlOfPages.consultationRequest1);

        indexPage.psymaPopUpClose();

        st_can_req_cre_anonymousUserConsultationRequest_page.bodyCheck();
        st_can_req_cre_anonymousUserConsultationRequest_page.adresstypCheck();
        st_can_req_cre_anonymousUserConsultationRequest_page.anredeCheck();
        st_can_req_cre_anonymousUserConsultationRequest_page.vornameCheck();
        st_can_req_cre_anonymousUserConsultationRequest_page.nachnameCheck();
        st_can_req_cre_anonymousUserConsultationRequest_page.straßeCheck();
        st_can_req_cre_anonymousUserConsultationRequest_page.plzCheck();
        st_can_req_cre_anonymousUserConsultationRequest_page.wohnortCheck();
        st_can_req_cre_anonymousUserConsultationRequest_page.emailCheck();
        st_can_req_cre_anonymousUserConsultationRequest_page.informationsmaterialCheck();
        st_can_req_cre_anonymousUserConsultationRequest_page.perTelefonCheck();
        st_can_req_cre_anonymousUserConsultationRequest_page.perElektronischerPostCheck();
        st_can_req_cre_anonymousUserConsultationRequest_page.perPostCheck();

    }

    /**
     * This test:
     * opens index page
     * check url
     * closes cookies popup
     * selects "Beratung vereinbaren" (consultation request) from side navigation
     * checks url of order brochure
     * closes psyma PopUp
     * checks that all mandatory fields are marked with a star
     */
    @Test
    public void testSelectConsultationRequestFromSideNavigator() {
        driver.get(UrlOfPages.indexPage);

        String indexPageURL = indexPage.getAssertUrl();
        Assert.assertEquals(indexPageURL, UrlOfPages.indexPage);

        indexPage.closeCookiesPopUp();

        indexPage.consultationRequestClick();

        String consultationRequestURL = indexPage.getAssertUrl();
        Assert.assertEquals(consultationRequestURL, UrlOfPages.consultationRequest1);

        indexPage.psymaPopUpClose();

        st_can_req_cre_anonymousUserConsultationRequest_page.adresstypCheck();
        st_can_req_cre_anonymousUserConsultationRequest_page.anredeCheck();
        st_can_req_cre_anonymousUserConsultationRequest_page.vornameCheck();
        st_can_req_cre_anonymousUserConsultationRequest_page.nachnameCheck();
        st_can_req_cre_anonymousUserConsultationRequest_page.straßeCheck();
        st_can_req_cre_anonymousUserConsultationRequest_page.plzCheck();
        st_can_req_cre_anonymousUserConsultationRequest_page.wohnortCheck();
        st_can_req_cre_anonymousUserConsultationRequest_page.emailCheck();
        st_can_req_cre_anonymousUserConsultationRequest_page.informationsmaterialCheck();
        st_can_req_cre_anonymousUserConsultationRequest_page.perTelefonCheck();
        st_can_req_cre_anonymousUserConsultationRequest_page.perElektronischerPostCheck();
        st_can_req_cre_anonymousUserConsultationRequest_page.perPostCheck();
    }

    /**
     * This test:
     * opens index page
     * check url
     * closes cookies popup
     * selects "Beratung vereinbaren" (consultation request) from side navigation
     * checks url of order brochure
     * closes Psyma PopUp
     * fills Form and send it (hard coded)
     */
    @Test
    public void testSelectConsultationRequestAndFillForm() {
        driver.get(UrlOfPages.indexPage);

        String indexPageURL = indexPage.getAssertUrl();
        Assert.assertEquals(indexPageURL, UrlOfPages.indexPage);

        indexPage.closeCookiesPopUp();

        indexPage.consultationRequestClick();

        String consultationRequestURL = indexPage.getAssertUrl();
        Assert.assertEquals(consultationRequestURL, UrlOfPages.consultationRequest1);

        indexPage.psymaPopUpClose();

        indexPage.adresstypSelectCheckBox();
        indexPage.anredeDropListSelect();
        indexPage.vornameTextField("Test");
        indexPage.nachnameTextField("[ST_CAN_REQ_CRE_AnonymousUserConsultationRequest]");
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
