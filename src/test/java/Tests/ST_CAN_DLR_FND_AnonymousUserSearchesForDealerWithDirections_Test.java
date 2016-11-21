package Tests;

import Constants.UrlOfPages;
import Context.ExtentManager;
import Context.MyDriverFactory;
import Pages.BasePage;
import Pages.IndexPage;
import Pages.ST_CAN_DLR_FND_AnonymousUserSearchesForDealerWithDirections_Page;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ST_CAN_DLR_FND_AnonymousUserSearchesForDealerWithDirections_Test extends BaseTest {

    ST_CAN_DLR_FND_AnonymousUserSearchesForDealerWithDirections_Page st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page;
    IndexPage indexPage;
    BasePage basePage;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new MyDriverFactory().getDriver();
        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page = new ST_CAN_DLR_FND_AnonymousUserSearchesForDealerWithDirections_Page(driver);
        indexPage = new IndexPage(driver);
        basePage = new BasePage(driver);
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
        extent.addSystemInfo("Resolution",basePage.getWindowHeight() +"X"+ basePage.getWindowWidth());

        driver.get(UrlOfPages.indexPage);
        test = extent.startTest("Anonymous User Searches For Dealer With Directions", "Verify IndexPage");

        String indexPageURL = indexPage.getAssertUrl();
        Assert.assertEquals(indexPageURL, UrlOfPages.indexPage);
        test.log(LogStatus.INFO, basePage.getBrowserName() + basePage.getBrowserVersion());
        test.log(LogStatus.INFO, "Index page is opened");

        indexPage.closeCookiesPopUp();

        indexPage.dealerLocatorClick();

        String brochureOrderURL = indexPage.getAssertUrl();
        Assert.assertEquals(brochureOrderURL, UrlOfPages.dealerLocator);
        test.log(LogStatus.INFO, "Dealer locator page is opened");

        //indexPage.psymaPopUpClose();

        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.emptyWorldMap();
        test.log(LogStatus.INFO, "Empty world map is displayed");

        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.inputuserAddressField("Stuttgart");
        test.log(LogStatus.INFO, "\"Stuttgart\" is entered");

        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.dealerSearchButtonClick();

        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.infoContentList();
        test.log(LogStatus.INFO, "Info content list of \"Stuttgart\" dealers is displayed");
        test.log(LogStatus.INFO, test.addScreenCapture(ExtentManager.CaptureScreen(driver,"./images/"+ basePage.random())));

        Integer listOfDialers = st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.countOfDialers();
        test.log(LogStatus.INFO, "Number of dialers is: "+ listOfDialers);

        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.deleteInputButtonClick();
        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.inputuserAddressField("70197");

        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.dealerSearchButtonClick();

        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.infoContentList();
        test.log(LogStatus.INFO, "Info content list of \"70197\" dealers is displayed");
        test.log(LogStatus.INFO, test.addScreenCapture(ExtentManager.CaptureScreen(driver,"./images/"+ basePage.random())));

        listOfDialers = st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.countOfDialers();
        test.log(LogStatus.INFO, "Number of dialers is: "+ listOfDialers);

        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.locateButtonClick();

        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.getDirection();
        test.log(LogStatus.INFO, "Dealers in the proximity of user location are displayed in the list");

        st_can_dlr_fnd_anonymousUserSearchesForDealerWithDirections_page.directionTable();
        test.log(LogStatus.INFO, test.addScreenCapture(ExtentManager.CaptureScreen(driver,"./images/"+ basePage.random())));
        test.log(LogStatus.INFO, "Route is calculated and displayed as text");

    }

}
