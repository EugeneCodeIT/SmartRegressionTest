package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    @FindBy(xpath = "//div[@class='secondary-bar action-bar']/ul/li/div/a[@class='nav-title nav-title-login e-copytext6' or @class='nav-title nav-title-login e-copytext6 nav-title-active' and contains(@href,'#')]")
    private WebElement connectButton;

    @FindBy(xpath = "//div[@class='secondary-bar action-bar']/ul/li/div/a[@class='nav-title nav-title-login e-copytext6' or @class='nav-title nav-title-login e-copytext6 nav-title-active' and contains(@href,'#')]")
    private WebElement connectTestButton;

    @FindBy(xpath = "nav-title nav-title-login e-copytext6 nav-title-active")
    private WebElement connectButtonIsActive;

    @FindBy(xpath = ".//*[@id='ciam-weblogin-auth-login-button']")
    private WebElement anmelden;

    @FindBy(xpath = "//div[@class='secondary-bar action-bar']/ul/li/div/a[@class='nav-title nav-title-login e-copytext6' or @class='nav-title nav-title-login e-copytext6 nav-title-active' and contains(.,'Connect')]")
    private WebElement connectName;

    @FindBy(xpath = "//div[@class='secondary-bar action-bar']/ul/li/div/a[@class='nav-title nav-title-login e-copytext6' or @class='nav-title nav-title-login e-copytext6 nav-title-active' and contains(.,'Test')]")
    private WebElement userTestName;

    @FindBy(xpath = "html/body/div[2]/header/div/div/div[3]/div[2]/ul/li[1]/div/a/span")
    private WebElement smartFortwoButton;

    @FindBy(xpath = "html/body/div[2]/header/div/div/div[3]/div[2]/ul/li[2]/div/a/span")
    private WebElement smartFortwoCabrioButton;

    @FindBy(xpath = "//a[@data-href='/de/de/index/servicepage-library/fortwo-configurator.html']")
    private WebElement smartFortwoKonfiguratorButton;

    @FindBy(xpath = "//a[@data-tracking-elementname='navigation:C-MODEL-FLYOUTS:smart fortwo cabrio:Konfigurator']")
    private WebElement smartFortwoCabrioKonfiguratorButton;

    @FindBy(xpath = "//li[@class='nav-item action-nav-item login-nav-item vp12']/div/div/div/div/div[@class='login-nav-headline']")
    private WebElement logoutPersonalizationButton;

    @FindBy(xpath = "//div[@class='secondary-bar action-bar']//div[@class='login-form']")
    private WebElement loginForm;

    @FindBy(xpath = "//div[@class='secondary-bar action-bar']//a[@href='/de/de/index/personalization/profile-page.html']")
    private WebElement profileButton;

    @FindBy(xpath = "//a[@class='nav-title nav-title-search e-copytext6']")
    private WebElement search;


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
        try{
            waitVisibilityOfElement(closeCookiesPopup);
            clickOnElemenByJS(closeCookiesPopup);
        }catch (TimeoutException | NoSuchElementException e){
            System.out.println("Cookies popup is absent");
        }
    }

    /**
     * Method moves mouse over Broschüre button then click on it
     */
    public void brochureOrderClick() {
        moveToElementAndClick(imageOfMenuOrderButton);
        brochureOrderMenuButton.click();
        waitOfElement(submitButton);
    }

    /**
     * Method moves mouse over Händlersuche button then click on it
     */
    public void dealerLocatorClick() throws InterruptedException {
        moveToElementAndClick(imageOfMenuDealerLocator);
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

    public void connectbuttonClick() throws InterruptedException {
        Thread.sleep(2000);
        int count = 0;
        do {
            try{
                waitOfElement(connectButton);
                moveToElement(connectButton);
                clickOnElemenByJS(connectButton);
            }catch (TimeoutException | NoSuchElementException | ElementNotVisibleException e){
                driver.navigate().refresh();
                moveToElement(search);
                System.out.println("Index page: 229 string");
                count++;
                continue;
            }
            break;
        }while (count < 3);
        //moveToElement(connectButton);
        //clickOnElemenByJS(connectButton);
    }

    public void hoverConnectButton() throws InterruptedException {
        int countConnect = 0;
        int count = 0;
        do {
            try{
                String connect = driver.findElement(By.xpath("//div[@class='secondary-bar action-bar']/ul/li/div/a[@class='nav-title nav-title-login e-copytext6' or @class='nav-title nav-title-login e-copytext6 nav-title-active' and contains(@href,'#')]")).getAttribute("class");
                System.out.println(connect);
                WebElement connectButton = driver.findElement(By.xpath("//div[@class='secondary-bar action-bar']/ul/li/div/a[@class='"+connect+"' and contains(@href,'#')]"));
                WebDriverWait wait = new WebDriverWait(driver,15);
                wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='secondary-bar action-bar']/ul/li/div/a[@class='"+connect+"' and contains(@href,'#')]")));
                connectButton.isDisplayed();
            }catch (StaleElementReferenceException | NoSuchElementException e){
                driver.navigate().refresh();
                System.out.println("Connect button isn't display page will be reloaded");
                count++;
                continue;
            }
            break;
        }while (count < 3);

        do {
            try{
                moveToElementAndClick(connectTestButton);
                logoutPersonalizationButton.isDisplayed();
            }catch (NoSuchElementException e){
                System.out.println("Menu isn't opened page will be reloaded");
                countConnect++;
                driver.navigate().refresh();
                continue;
            }
            break;
        }while (countConnect < 3);
    }

    public String getUserName() throws InterruptedException {
        int count = 0;
        do {
            try{
                userTestName.isDisplayed();
            }catch (NoSuchElementException e){
                System.out.println("Index page: wait of user is loading");
                count ++;
                driver.navigate().refresh();
                continue;
            }
            break;
        }while (count < 3);
        return connectButton.getText();
    }

    public String UserName() throws InterruptedException {
        Thread.sleep(2000);
        int count = 0;
        do {
            try{
                waitOfElement(userTestName);
            }catch (TimeoutException e){
                System.out.println("user name is wrong page will be reloaded");
                count ++;
                driver.navigate().refresh();
                continue;
            }
            break;
        }while (count < 3);

        return connectTestButton.getText();
    }

    public String getConnectButtonName(){
        return connectButton.getText();
    }

    public void smartFortwobuttonClick() {
        moveToElementAndClick(smartFortwoButton);
    }

    public void smartFortwoCabrioButtonClick() throws InterruptedException {
        Thread.sleep(2000);
        moveToElementAndClick(smartFortwoCabrioButton);
    }

    public void konfiguratorButtonClick(){
        waitVisibilityOfElement(smartFortwoKonfiguratorButton);
        smartFortwoKonfiguratorButton.click();
    }

    public void smartFortwoCabrioKonfiguratorButtonClick(){
        waitVisibilityOfElement(smartFortwoCabrioKonfiguratorButton);
        smartFortwoCabrioKonfiguratorButton.click();
    }
}
