package Tests;

import Constants.UrlOfPages;
import Context.MyDriverFactory;
import Pages.IndexPage;
import Pages.ST_CAN_DLR_FND_AnonymousUserSearchesForDealerWithDirections_Page;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ST_CAN_DLR_FND_AnonymousUserSearchesForDealerWithDirections_Test extends BaseTest {

    ST_CAN_DLR_FND_AnonymousUserSearchesForDealerWithDirections_Page st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page;
    IndexPage indexPage;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new MyDriverFactory().getDriver();
        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page = new ST_CAN_DLR_FND_AnonymousUserSearchesForDealerWithDirections_Page(driver);
        indexPage = new IndexPage(driver);
    }

    /**
     * This test is:
     * opens index page
     * check that url of index page
     * closes Ckookies popup
     * clicks Händlersuche button
     * checks Händlersuche url
     * closes psyma Popup
     * checks empty world card
     * enters in text field "Stuttgart" then submitting it
     * check displayed info content list of dealers
     * enters in text field "70197" then submitting it
     * check displayed info content list of dealers
     * clicks locate button and check list of dealers
     * clicks direction button
     * check direction table with data is displayed
     */
    @Test
    public void testAnonymousUserSearchesForDealerWithDirections () throws InterruptedException {
        driver.get(UrlOfPages.indexPage);

        String indexPageURL = indexPage.getAssertUrl();
        Assert.assertEquals(indexPageURL, UrlOfPages.indexPage);

        indexPage.closeCookiesPopUp();

        indexPage.dealerLocatorClick();

        String brochureOrderURL = indexPage.getAssertUrl();
        Assert.assertEquals(brochureOrderURL, UrlOfPages.dealerLocator);

        indexPage.psymaPopUpClose();

        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.emptyWorldMap();

        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.inputuserAddressField("Stuttgart");
        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.dealerSearchButtonClick();

        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.infoContentList();
        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.deleteInputButtonClick();
        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.inputuserAddressField("70197");
        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.dealerSearchButtonClick();

        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.infoContentList();
        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.locateButtonClick();

        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.getDirection();
        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.directionTable();

    }

}
