package Tests;

import Constants.UrlOfPages;
import Context.ExtentManager;
import Context.MyDriverFactory;
import Pages.BasePage;
import Pages.IndexPage;
import Pages.ST_CAN_CFG_RST_AnonymousUserConfiguresCarAndResetsConfiguration_Page;
import com.Exception;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ST_CAN_CFG_RST_AnonymousUserConfiguresCarAndResetsConfiguration_Test extends BaseTest {
    IndexPage indexPage;
    BasePage basePage;
    ST_CAN_CFG_RST_AnonymousUserConfiguresCarAndResetsConfiguration_Page st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page;

    @BeforeMethod
    public void setUp() throws Exception {
        driver = new MyDriverFactory().getDriver();
        indexPage = new IndexPage(driver);
        basePage = new BasePage(driver);
        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page = new ST_CAN_CFG_RST_AnonymousUserConfiguresCarAndResetsConfiguration_Page(driver);
    }

    /**
     * This test was created through ST_CAN_CFG_RST test case
     */
    @Test(groups = {"ST_CAN_CFG_RST_AnonymousUserConfiguresCarAndResetsConfiguration_Test"})
    public void testAnonymousUserConfiguresCarAndResetsConfiguration() throws InterruptedException {
        extent.addSystemInfo("Resolution",basePage.getWindowHeight()+"X"+basePage.getWindowWidth());

        test = extent.startTest("Anonymous user configures car and resets configuration", "Verify Anonymous user configures car and resets configuration");
        driver.get(UrlOfPages.indexPage);

        String indexPageURL = indexPage.getAssertUrl();
        Assert.assertEquals(indexPageURL, UrlOfPages.indexPage);

        test.log(LogStatus.INFO, basePage.getBrowserName() + basePage.getBrowserVersion());
        test.log(LogStatus.INFO, "Index page is opened");

        indexPage.closeCookiesPopUp();
        //indexPage.psymaPopUpClose();

        indexPage.smartFortwobuttonClick();
        indexPage.konfiguratorButtonClick();

        String fortwoPageURL = indexPage.getAssertUrl();
        Assert.assertEquals(fortwoPageURL, UrlOfPages.fortwo);
        test.log(LogStatus.INFO, "fortwo configurator page is displayed");

        String sonderaustattung = st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.getPriceOfSonderausstattung();
        Assert.assertEquals(sonderaustattung, "0,00 €");

        test.log(LogStatus.INFO, "Value of \"Sonderaustattung\"  = 0 Euros");

        test.log(LogStatus.INFO, test.addScreenCapture(ExtentManager.CaptureScreen(driver,"./images/"+ basePage.random())));
        test.log(LogStatus.INFO, "Screen of car which is displayed on smart fortwo \"Konfigurieren\" page");

        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.selectingTridionJupiterRed();
        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.checkingTridionJupiterRedSelected();
        test.log(LogStatus.INFO, "Extra \"tridion -> jupiter red\" is selected");

        String sonderaustattungWithTridition = st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.getPriceOfSonderausstattung();
        String priceOfTriditionJupiterRed = st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.getPriceOfTridionJupiterRed();
        Assert.assertEquals(sonderaustattungWithTridition, priceOfTriditionJupiterRed);
        test.log(LogStatus.INFO, "Value of \"Sonderausstattung\"(Extras) = value of \"tridion -> jupiter red\"");

        test.log(LogStatus.INFO, test.addScreenCapture(ExtentManager.CaptureScreen(driver,"./images/"+ basePage.random())));
        test.log(LogStatus.INFO, "Screen of car with applied \"tridion -> jupiter red\"");

        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.closeConfigurator();

        String indexPageUrlAfterClosingConfigurator = indexPage.getAssertUrl();
        Assert.assertEquals(indexPageUrlAfterClosingConfigurator, UrlOfPages.indexPageAfterClosingConfigurator);
        test.log(LogStatus.INFO, "Front page is displayed");

        indexPage.smartFortwoCabrioButtonClick();
        indexPage.smartFortwoCabrioKonfiguratorButtonClick();

        String fortwoCabrioPageURL = indexPage.getAssertUrl();
        Assert.assertEquals(fortwoCabrioPageURL, UrlOfPages.fortwoCabrio);
        test.log(LogStatus.INFO, "fortwo cabrio configurator page is displayed");

        sonderaustattung = st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.getPriceOfSonderausstattung();
        String extrasWith = st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.getPriceOfExtras();
        Assert.assertEquals(sonderaustattung, "0,00 €");
        Assert.assertEquals(extrasWith, "0,00 €");

        test.log(LogStatus.INFO, "Value of \"Sonderaustattung\"  = 0 Euros");
        test.log(LogStatus.INFO, "Value of \"Extras\"  = 0 Euros");

        test.log(LogStatus.INFO, test.addScreenCapture(ExtentManager.CaptureScreen(driver,"./images/"+ basePage.random())));
        test.log(LogStatus.INFO, "Screen of car which is displayed on smart fortwo cabrio \"Konfigurieren\" page");

        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.selectingExtrasP31();
        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.checkingP31CoolAudioPaketSelected();
        test.log(LogStatus.INFO, "Extra \"(P31) Cool & Audio-Paket\" is selected");

        extrasWith = st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.getPriceOfExtras();
        String priceOfP31CoolAudioPaket = st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.getPriceOfP31CoolAudioPaket();
        Assert.assertEquals(extrasWith, priceOfP31CoolAudioPaket);
        test.log(LogStatus.INFO, "Value of \"Extras\" = value of \"(P31) Cool & Audio-Paket\"");

        test.log(LogStatus.INFO, test.addScreenCapture(ExtentManager.CaptureScreen(driver,"./images/"+ basePage.random())));
        test.log(LogStatus.INFO, "Screen of car with applied \"(P31) Cool & Audio-Paket\"");

        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.servicePageBackLinkClick();

        String servicePageURL = indexPage.getAssertUrl();
        Assert.assertEquals(servicePageURL, UrlOfPages.service);
        test.log(LogStatus.INFO, "service page is displayed");

        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.smartForfourButtonClick();

        String forfourPageURL = indexPage.getAssertUrl();
        Assert.assertEquals(forfourPageURL, UrlOfPages.forfour);
        test.log(LogStatus.INFO, "forfour configurator page is displayed");

        sonderaustattung = st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.getPriceOfSonderausstattung();
        extrasWith = st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.getPriceOfExtras();
        Assert.assertEquals(sonderaustattung, "0,00 €");
        Assert.assertEquals(extrasWith, "0,00 €");

        test.log(LogStatus.INFO, "Value of \"Sonderaustattung\"  = 0 Euros");
        test.log(LogStatus.INFO, "Value of \"Extras\"  = 0 Euros");

        test.log(LogStatus.INFO, test.addScreenCapture(ExtentManager.CaptureScreen(driver,"./images/"+ basePage.random())));
        test.log(LogStatus.INFO, "Screen of car which is displayed on smart forfour \"Konfigurieren\" page");

        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.selectingInterieur07U();
        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.checkingInterieur07USelected();
        test.log(LogStatus.INFO, "Extra \"(07U) Polsterung in Stoff schwarz/schwarz\" is selected");

        extrasWith = st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.getPriceOfExtras();
        String priceOfPolsterung07U = st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.getPriceOfPolsterung07U();
        Assert.assertEquals(extrasWith, priceOfPolsterung07U);
        test.log(LogStatus.INFO, "Value of \"Extras\" = value of \"(07U) Polsterung in Stoff schwarz/schwarz\"");

        test.log(LogStatus.INFO, test.addScreenCapture(ExtentManager.CaptureScreen(driver,"./images/"+ basePage.random())));
        test.log(LogStatus.INFO, "Screen of car with applied \"(07U) Polsterung in Stoff schwarz/schwarz\"");

        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.zurKonfigurationButtonClick();
        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.checkZuruckZumConfiguratorButton();
        test.log(LogStatus.INFO, "Button \"Zurück zum Konfigurator\" is visible");

        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.checkLableOnlineCode();
        String lable = st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.checkLableOnlineCode();
        Assert.assertEquals(lable, "Online Code:");
        test.log(LogStatus.INFO, "Label \"Online code\" is displayed");

        String sonderaustattungOnServisePage = st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.getPriceOfSonderausstattungOnservicePage();
        String extrasWithOnServisePage = st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.getPriceOfExtrasOnservicePage();
        Assert.assertEquals(sonderaustattungOnServisePage, "0,00 €");
        Assert.assertEquals(extrasWithOnServisePage, "0,00 €");

        test.log(LogStatus.INFO, "Value of \"Sonderaustattung\"  = 0 Euros");
        test.log(LogStatus.INFO, "Value of \"Extras\"  = 0 Euros");

        test.log(LogStatus.INFO, test.addScreenCapture(ExtentManager.CaptureScreen(driver,"./images/"+ basePage.random())));
        test.log(LogStatus.INFO, "Screen of car which is displayed on service page");

        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.nextBestActionsButtonAvailable();
        test.log(LogStatus.INFO, "Buttons for next best actions are available");

        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.zuruckZumKonfiguratorButtonClick();

        forfourPageURL = indexPage.getAssertUrl();
        Assert.assertEquals(forfourPageURL, UrlOfPages.forfour);
        test.log(LogStatus.INFO, "forfour configurator page is displayed");

        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.checkingInterieur07U();
        test.log(LogStatus.INFO, "Extra \"(07U) Polsterung in Stoff schwarz/schwarz\" is selected");

        test.log(LogStatus.INFO, test.addScreenCapture(ExtentManager.CaptureScreen(driver,"./images/"+ basePage.random())));
        test.log(LogStatus.INFO, "Screen of car after clicking \"Zurück zum Konfigurator\" button");

        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.selectingTridionJupiterRedForForfour();
        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.checkingTridionJupiterRedForfourSelectedSelected();
        test.log(LogStatus.INFO, "Extra \"tridion -> jupiter red\" is selected");

        sonderaustattungWithTridition = st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.getPriceOfSonderausstattung();
        priceOfTriditionJupiterRed = st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.getPriceOfTridionJupiterRedForfour();
        Assert.assertEquals(sonderaustattungWithTridition, priceOfTriditionJupiterRed);
        test.log(LogStatus.INFO, "Value of \"Sonderausstattung\"(Extras) = value of \"tridion -> jupiter red\"");

        test.log(LogStatus.INFO, test.addScreenCapture(ExtentManager.CaptureScreen(driver,"./images/"+ basePage.random())));
        test.log(LogStatus.INFO, "Screen of car with applied \"tridion -> jupiter red\"");

        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.zoomInButtonClick();
        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.infoBoxHdPopUpVisability();
        test.log(LogStatus.INFO, "View to display HD car opens");

        test.log(LogStatus.INFO, test.addScreenCapture(ExtentManager.CaptureScreen(driver,"./images/"+ basePage.random())));
        test.log(LogStatus.INFO, "Screen of view to display HD");

        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.closeInfoBoxHdPopUp();
        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.resetButtonClick();

        sonderaustattung = st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.getPriceOfSonderausstattung();
        extrasWith = st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.getPriceOfExtras();
        Assert.assertEquals(sonderaustattung, "0,00 €");
        Assert.assertEquals(extrasWith, "0,00 €");

        test.log(LogStatus.INFO, "Value of \"Sonderaustattung\"  = 0 Euros");
        test.log(LogStatus.INFO, "Value of \"Extras\"  = 0 Euros");

        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.checkStandartTridion();
        test.log(LogStatus.INFO, "Interieur standard is selected");

        st_can_cfg_rst_anonymousUserConfiguresCarAndResetsConfiguration_page.checkStandartInterieur();
        test.log(LogStatus.INFO, "Tridition standard is selected");












































    }

}
