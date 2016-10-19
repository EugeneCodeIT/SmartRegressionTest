package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IndexPage extends BasePage {

    @FindBy(xpath = "//span[contains(@class,'ui-icon ui-icon-closethick')]")
    private WebElement closeCookiesPopup;

    @FindBy(xpath = "//div[@class='mod authorComponent modStickynavigation']/ul/li[3]")
    private WebElement brochureOrderMenuButton;

    @FindBy(xpath = "html/body/div[2]/div[2]/div/div/ul/li[3]/a/img")
    private WebElement imageOfMenuOrderButton;

    @FindBy(xpath = "//button[contains(@class,'na')]")
    private WebElement submitButton;

    @FindBy(xpath = "//label[@for='fpf_addressType_private']")
    private WebElement adresstypPrivat;

    @FindBy(xpath = "//div[@class='select-wrapper custom-select']")
    private WebElement anredeDropList;

    @FindBy(xpath = "//a[@rel='Herr']")
    private WebElement herrInDropList;

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
     * Method closes psyma popup
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
     * Method moves mouse over Broschüre button then click on it
     */
    public void brochureOrderClick() {
        moveToElement(imageOfMenuOrderButton);
        brochureOrderMenuButton.click();
        waitOfElement(submitButton);
    }

    /**
     * Method moves mouse over Händlersuche button then click on it
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

    public void straßeTextField(String street){
        straßeField.sendKeys(street);
    }

    public void plzTextField(String zip){
        plzField.sendKeys(zip);
    }

    public void wohnortTextField(String city){
        wohnortField.sendKeys(city);
    }

    public void emailTextField(String email){
        emailField.sendKeys(email);
    }

    public void smartFortwoSelectCheckbox(){
        smartFortwoCheckbox.click();
    }

    public void firstMonateSelectCheckbox(){
        firstMonateCheckbox.click();
    }

    public void acceptUsingPersonalData(){
        perTelefonCheckbox.click();
        perElektronischerPostCheckbox.click();
        perPostCheckbox.click();
        submitButton.click();
    }

    /**
     * Method checks that success text presence after send form submit
     */
    public void succesPage() {
        try {
            successText.isDisplayed();
            System.out.println("Success page is displayed");
        } catch (NoSuchElementException e) {
            System.out.println("Success page isn't displayed");
        }
    }
}
