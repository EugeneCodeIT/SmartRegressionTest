package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage {

    @FindBy(xpath = "//span[contains(@class,'ui-icon ui-icon-closethick')]")
    private WebElement closeCookiesPopup;

    //Buttons on sticky navigation
    // How to get the path ????
    @FindBy(xpath = "//div[@class='mod authorComponent modStickynavigation']/ul/li[1]")
    private WebElement configurationMenuButton;

    @FindBy(xpath = "//div[@class='mod authorComponent modStickynavigation']/ul/li[2]")
    private WebElement testDriveMenuButton;

    @FindBy(xpath = "//div[@class='mod authorComponent modStickynavigation']/ul/li[3]")
    private WebElement brochureOrderMenuButton;

    @FindBy(xpath = "//div[@class='mod authorComponent modStickynavigation']/ul/li[4]")
    private WebElement dealerSearchMenuButton;

    @FindBy(xpath = "//div[@class='mod authorComponent modStickynavigation']/ul/li[5]")
    private WebElement consultationMenuButton;

    // How to get this path ????
    @FindBy(xpath = "html/body/div[2]/div[2]/div/div/ul/li[1]/a/img")
    private WebElement imageOfMenuConfiguratorButton;

    @FindBy(xpath = "html/body/div[2]/div[2]/div/div/ul/li[2]/a/img")
    private WebElement imageOfMenuTestDriveButton;

    @FindBy(xpath = "html/body/div[2]/div[2]/div/div/ul/li[3]/a/img")
    private WebElement imageOfMenuBrochureOrderButton;

    @FindBy(xpath = "html/body/div[2]/div[2]/div/div/ul/li[4]/a/img")
    private WebElement imageOfMenuDealerSearchButton;

    @FindBy(xpath = "html/body/div[2]/div[2]/div/div/ul/li[5]/a/img")
    private WebElement imageOfMenuConsultationButton;

    @FindBy(xpath = "//button[contains(@class,'na')]")
    private WebElement submitButton;

    @FindBy(xpath = "//label[@for='fpf_addressType_private']")
    private WebElement adresstypPrivat;

    @FindBy(xpath = "//div[@class='select-wrapper custom-select']")
    private WebElement anredeDropList;

    //rel not save for international use ???
    @FindBy(xpath = "//a[@rel='Herr']")
    private WebElement herrInDropList;

    @FindBy(xpath = "//a[@rel='Frau']")
    private WebElement frauInDropList;

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement vornameField;

    @FindBy(xpath = "//input[@name='name1']")
    private WebElement nachnameField;

    @FindBy(xpath = "//input[@name='street']")
    private WebElement straßeField;

    @FindBy(xpath = "//input[@name='zipCode']")
    private WebElement plzField;

    @FindBy(xpath = "//input[@name='city']")
    private WebElement wohnortField;

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//label[@for='infoCheckbox0']")
    private WebElement smartFortwoCheckbox;

    @FindBy(xpath = "//label[@for='question_2_6']")
    private WebElement firstMonateCheckbox;

    @FindBy(xpath = "//label[@for='dataPrivacy_channel1_1']")
    private WebElement perTelefonCheckbox;

    @FindBy(xpath = "//label[@for='dataPrivacy_channel2_1']")
    private WebElement perElektronischerPostCheckbox;

    @FindBy(xpath = "//label[@for='dataPrivacy_channel3_1']")
    private WebElement perPostCheckbox;

    @FindBy(xpath = "//h2[contains(.,'Vielen Dank für Ihre Anfrage.')]")
    private WebElement successText;

    @FindBy(xpath = "//div[@id='psyma_close_link_container']")
    private WebElement closePopUp;

    @FindBy(xpath = "html/body/div[2]/div[2]/div/div/ul/li[4]/a/img")
    private WebElement imageOfMenuDealerLocator;

    @FindBy(xpath = "//a[@class='nba vp12 btn_dealer_search']")
    private WebElement dealerSearchButton;

    public IndexPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method closes Psyma popup
     */
    public void psymaPopUpClose(){
        try {
            closePopUp.click();
        }catch (NoSuchElementException e){
            System.out.println("Psyma popup isn't displayed");
        }
    }

    /**
     * Method closes cookies popup
     */
    public void closeCookiesPopUp(){
        waitOfElement(closeCookiesPopup);
        closeCookiesPopup.click();
    }

    /**
     * Method moves mouse over "Konfigurator" (configuration) button then clicks on it
     */
    public void configuratorClick() {
        moveToElement(imageOfMenuConfiguratorButton);
        configurationMenuButton.click();
        waitOfElement(submitButton);
    }

    /**
     * Method moves mouse over "Probefahrt" (test drive) button then clicks on it
     */
    public void testDriveClick() {
        moveToElement(imageOfMenuTestDriveButton);
        testDriveMenuButton.click();
        waitOfElement(submitButton);
    }

    /**
     * Method moves mouse over "Broschüre" (broschure) button then clicks on it
     */
    public void brochureOrderClick() {
        moveToElement(imageOfMenuBrochureOrderButton);
        brochureOrderMenuButton.click();
        waitOfElement(submitButton);
    }

    /**
     * Method moves mouse over "Beratung" (consultation) button then clicks on it
     */
    public void consultationRequestClick() {
        moveToElement(imageOfMenuConsultationButton);
        consultationMenuButton.click();
        waitOfElement(submitButton);
    }
    /**
     * Method moves mouse over "Händlersuche" (dealer search) button then click on it
     */
    public void dealerLocatorClick() throws InterruptedException {
        moveToElement(imageOfMenuDealerLocator);
        imageOfMenuDealerLocator.click();
        waitVisibilityOfElement(dealerSearchButton);
        Thread.sleep(1000);
    }

    /**
     * Next methods fill required fields and check required checkboxes
     */
    // personal data
    public void adresstypSelectCheckBox(){
        adresstypPrivat.click();
    }
    public void anredeDropListSelect(){
        anredeDropList.click();
        herrInDropList.click();
    }
    public void vornameTextField(String name){
        vornameField.sendKeys(name);
    }
    public void nachnameTextField(String lastname){
        nachnameField.sendKeys(lastname);
    }

    // address data
    public void straßeTextField(String street){
        straßeField.sendKeys(street);
    }
    public void plzTextField(String zip){
        plzField.sendKeys(zip);
    }
    public void wohnortTextField(String city){
        wohnortField.sendKeys(city);
    }


    // contact data
    public void emailTextField(String email){
        emailField.sendKeys(email);
    }

    // product data
    public void smartFortwoSelectCheckbox(){
        smartFortwoCheckbox.click();
    }

    // purchase data
    public void firstMonateSelectCheckbox(){
        firstMonateCheckbox.click();
    }

    // DSE data
    public void acceptUsingPersonalData(){
        perTelefonCheckbox.click();
        perElektronischerPostCheckbox.click();
        perPostCheckbox.click();
        //??? why is submitButton part of this procedure?
        submitButton.click();
    }

    /**
     * Method checks presence of success text after form was send via submit
     */
    public void succesPage() {
        try {
            successText.isDisplayed();
            System.out.println("Success page is displayed - form was sent");
        } catch (NoSuchElementException e) {
            System.out.println("Success page is NOT displayed - form was NOT sent");
        }
    }
}
