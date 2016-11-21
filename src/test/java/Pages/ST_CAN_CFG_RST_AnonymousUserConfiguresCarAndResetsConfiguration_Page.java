package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ST_CAN_CFG_RST_AnonymousUserConfiguresCarAndResetsConfiguration_Page extends BasePage {

    @FindBy(xpath = "//table[@class='table-price']")
    private WebElement tablePrice;

    @FindBy(xpath = ".//*[@id='option']")
    private WebElement sonderausstattungValue;

    @FindBy(xpath = ".//*[@id='option-sum']")
    private WebElement sonderausstattungValueOnservicePage;

    @FindBy(xpath = ".//*[@id='extra']")
    private WebElement extrasValue;

    @FindBy(xpath = ".//*[@id='extra-sum']")
    private WebElement extrasValueOnservicePage;

    @FindBy(xpath = ".//*[@id='tridion']")
    private WebElement tridionButton;

    @FindBy(xpath = "//a[contains(.,'Sonderausstattung')]")
    private WebElement sonderausstattungButton;

    @FindBy(xpath = "//img[contains(@src,'/pab/imagedb/807/def/def/453/c453/def/eq/en8u_tridion_jupiter_red_size2.jpg')]")
    private WebElement tridionJupiterRed;

    @FindBy(xpath = "//img[@src='/pab/imagedb/807/def/def/453/w453/def/eq/er4u_cadmium_red_metallic_size2.jpg']")
    private WebElement tridionJupiterRedForForfour;

    @FindBy(xpath = "//div[@class='submenu-box submenu-product active' and contains(.,'tridion Sicherheitszelle in jupiter red')]")
    private WebElement tridionJupiterRedSelected;

    @FindBy(xpath = "//div[@class='submenu-box submenu-product active' and contains(.,'tridion Sicherheitszelle in cadmium red (metallic)')]")
    private WebElement tridionJupiterRedForfourSelected;

    @FindBy(xpath = "//div[@class='submenu-box submenu-product active' and contains(.,'tridion Sicherheitszelle in black')]")
    private WebElement tridionSicherheitszelleInBlackSelected;

    @FindBy(xpath = "//div[@class='submenu-box submenu-product active' and contains(.,'tridion Sicherheitszelle in jupiter red')]/div/div[@class='submenu-price e-copytext5']")
    private WebElement priceOfTridionJupiterRed;

    @FindBy(xpath = "//div[@class='submenu-box submenu-product active' and contains(.,'tridion Sicherheitszelle in cadmium red (metallic)')]/div/div[@class='submenu-price e-copytext5']")
    private WebElement priceOfTridionJupiterRedForfour;

    @FindBy(xpath = "//div[@class='mod modServicepagelayerCloseColumn open']/button[@class='servicepagelayer-close-button']")
    private WebElement closeButton;

    @FindBy(xpath = ".//*[@id='extras']")
    private WebElement extrasButton;

    @FindBy(xpath = "//img[contains(@src,'/pab/imagedb/807/def/def/453/a453/def/eq/p31_cool_audio_paket_size2.jpg')]")
    private WebElement p31CoolAudioPaket;

    @FindBy(xpath = "//div[@class='submenu-box submenu-product active' and contains(.,'(P31) Cool & Audio-Paket')]")
    private WebElement p31CoolAudioPaketSelected;

    @FindBy(xpath = "//div[@class='submenu-box submenu-product active' and contains(.,'(P31) Cool & Audio-Paket')]/div/div[@class='submenu-price e-copytext5']")
    private WebElement p31CoolAudioPaketValue;

    @FindBy(xpath = "//a[contains(.,'Modellauswahl ändern')]")
    private WebElement servicePageBackLink;

    @FindBy(xpath = "//img[contains(@src,'1761015208.imgresize.width=294.png/1461044029461.png')]")
    private WebElement smartForfourButton;

    @FindBy(xpath = ".//*[@id='interior']")
    private WebElement interiorButton;

    @FindBy(xpath = "//img[contains(@src,'/pab/imagedb/807/def/def/453/w453/def/eq/07u_upholsteries_size2.jpg')]")
    private WebElement polsterung07U;

    @FindBy(xpath = "//div[@class='submenu-box submenu-product active' and contains(.,'(07U) Polsterung in Stoff schwarz/schwarz')]")
    private WebElement polsterung07USelected;

    @FindBy(xpath = "//div[@class='submenu-box submenu-product active' and contains(.,'(02U) Polsterung in Stoff schwarz/orange')]")
    private WebElement polsterung02USelected;

    @FindBy(xpath = "//div[@class='submenu-box submenu-product active' and contains(.,'(07U) Polsterung in Stoff schwarz/schwarz')]/div/div[@class='submenu-price e-copytext5']")
    private WebElement polsterung07UValue;

    @FindBy(xpath = "//a[contains(.,'zur Konfigurationsübersicht')]")
    private WebElement zurKonfigurationButton;

    @FindBy(xpath = "//span[contains(.,'Zurück zum')]")
    private WebElement zuruckKonfiguratorButton;

    @FindBy(xpath = "//label[@for='ocform_code_output']")
    private WebElement lableOnlineCode;

    @FindBy(xpath = "//div[@style='']/div/div[@class='summary-nba e-copytext3']/ul/li/a[@class='cc-link cc-link-testdrive']")
    private WebElement probefahrtVereinbarenButton;

    @FindBy(xpath = "//div[@style='']/div/div[@class='summary-nba e-copytext3']/ul/li/a[@class='cc-link cc-link-consultation']")
    private WebElement beratungVereinbarenButton;

    @FindBy(xpath = "//div[@style='']/div/div[@class='summary-nba e-copytext3']/ul/li/a[@class='cc-link cc-link-offer']")
    private WebElement angebotAnfordernButton;

    @FindBy(xpath = "//div[@style='']/div/div[@class='summary-nba e-copytext3']/ul/li/a[@class='cc-link cc-link-dealer']")
    private WebElement handlerFindenButton;

    @FindBy(xpath = "//div[@style='']/div/div[@class='summary-nba e-copytext3']/ul/li/a[@class='cc-link cc-link-brochure']")
    private WebElement brochureBestellenButton;

    @FindBy(xpath = "//a[contains(.,'Zurück zum Konfigurator')]")
    private WebElement zuruckZumKonfiguratorButton;

    @FindBy(xpath = "//a[contains(.,'Zoom in')]")
    private WebElement zoomInButton;

    @FindBy(xpath = ".//*[@id='infoBoxHD']")
    private WebElement infoBoxHdPopUp;

    @FindBy(xpath = "//span[contains(.,'close')]")
    private WebElement closeInfoBoxHdPopUp;

    @FindBy(xpath = "//a[@class='contentarea-toolbox-reset']")
    private WebElement resetButton;

    @FindBy(xpath = ".//*[@id='infoBoxHD']/div/div/div[1]/canvas[1]")
    private WebElement imageOfCarInHd;

    public ST_CAN_CFG_RST_AnonymousUserConfiguresCarAndResetsConfiguration_Page(WebDriver driver) {
        super(driver);
    }

    public String getPriceOfSonderausstattung() throws InterruptedException {
        Thread.sleep(1000);
        waitVisibilityOfElement(sonderausstattungValue);
        return sonderausstattungValue.getText();
    }

    public String getPriceOfSonderausstattungOnservicePage(){
        return sonderausstattungValueOnservicePage.getText();
    }

    public void selectingTridionJupiterRed(){
        tridionButton.click();
        sonderausstattungButton.click();
        waitVisibilityOfElement(tridionJupiterRed);
        tridionJupiterRed.click();
    }

    public void selectingTridionJupiterRedForForfour(){
        tridionButton.click();
        sonderausstattungButton.click();
        waitVisibilityOfElement(tridionJupiterRedForForfour);
        tridionJupiterRedForForfour.click();
    }

    public void checkingTridionJupiterRedSelected(){
        tridionJupiterRedSelected.isDisplayed();
    }

    public void checkingTridionJupiterRedForfourSelectedSelected(){
        tridionJupiterRedForfourSelected.isDisplayed();
    }

    public String getPriceOfTridionJupiterRed() throws InterruptedException {
        Thread.sleep(1000);
        return priceOfTridionJupiterRed.getText();
    }

    public String getPriceOfTridionJupiterRedForfour() throws InterruptedException {
        Thread.sleep(1000);
        return priceOfTridionJupiterRedForfour.getText();
    }

    public void closeConfigurator(){
        closeButton.click();
    }

    public void selectingExtrasP31(){
        extrasButton.click();
        waitVisibilityOfElement(p31CoolAudioPaket);
        p31CoolAudioPaket.click();
    }

    public void checkingP31CoolAudioPaketSelected(){
        p31CoolAudioPaketSelected.isDisplayed();
    }

    public String getPriceOfExtras() throws InterruptedException {
        Thread.sleep(1000);
        waitOfElement(tablePrice);
        return extrasValue.getText();
    }

    public String getPriceOfExtrasOnservicePage() throws InterruptedException {
        Thread.sleep(1000);
        return extrasValueOnservicePage.getText();
    }

    public String getPriceOfP31CoolAudioPaket() throws InterruptedException {
        Thread.sleep(1000);
        return p31CoolAudioPaketValue.getText();
    }

    public String getPriceOfPolsterung07U() throws InterruptedException {
        Thread.sleep(1000);
        return polsterung07UValue.getText();
    }

    public void servicePageBackLinkClick(){
        servicePageBackLink.click();
    }

    public void smartForfourButtonClick(){
        smartForfourButton.click();
    }

    public void selectingInterieur07U(){
        interiorButton.click();
        waitVisibilityOfElement(polsterung07U);
        polsterung07U.click();
    }

    public void checkingInterieur07U() throws InterruptedException {
        interiorButton.click();
        waitVisibilityOfElement(polsterung07USelected);
        polsterung07USelected.isDisplayed();
        Thread.sleep(1000);
    }

    public void checkingInterieur07USelected(){
        polsterung07USelected.isDisplayed();
    }

    public void zurKonfigurationButtonClick(){
        zurKonfigurationButton.click();
    }

    public void checkZuruckZumConfiguratorButton(){
        zuruckKonfiguratorButton.isDisplayed();
    }

    public String checkLableOnlineCode(){
        waitVisibilityOfElement(lableOnlineCode);
        lableOnlineCode.isDisplayed();
        return lableOnlineCode.getText();
    }

    public void nextBestActionsButtonAvailable(){
        probefahrtVereinbarenButton.isDisplayed();
        beratungVereinbarenButton.isDisplayed();
        angebotAnfordernButton.isDisplayed();
        handlerFindenButton.isDisplayed();
        brochureBestellenButton.isDisplayed();
    }

    public void zuruckZumKonfiguratorButtonClick(){
        zuruckKonfiguratorButton.click();
    }

    public void zoomInButtonClick(){
        zoomInButton.click();
        waitVisibilityOfElement(infoBoxHdPopUp);
    }

    /**
     * sleep in this method is used because need long time to load 3d image of car
     */
    public void infoBoxHdPopUpVisability() throws InterruptedException {
        Thread.sleep(5000);
        infoBoxHdPopUp.isDisplayed();
    }

    public void closeInfoBoxHdPopUp(){
        waitVisibilityOfElement(closeInfoBoxHdPopUp);
        closeInfoBoxHdPopUp.click();
    }

    /**
     * sleep in this method is used because after reset data values don't reset immediately
     */
    public void resetButtonClick() throws InterruptedException {
        resetButton.click();
        waitOfElement(tablePrice);
        Thread.sleep(5000);
    }

    public void checkStandartTridion(){
        tridionButton.click();
        waitVisibilityOfElement(tridionSicherheitszelleInBlackSelected);
        tridionSicherheitszelleInBlackSelected.isDisplayed();
    }

    public void checkStandartInterieur(){
        interiorButton.click();
        waitVisibilityOfElement(polsterung02USelected);
        polsterung02USelected.isDisplayed();
    }



}
