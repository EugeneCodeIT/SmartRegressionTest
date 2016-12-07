package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;

public class ST_CLI_ACC_UPD_LoggedInUserChangesEmailAddress_Page extends BasePage {

    @FindBy(xpath = "//input[contains(@id,'email')]")
    private WebElement emailField;

    @FindBy(xpath = "//input[contains(@id,'password')]")
    private WebElement passField;

    @FindBy(xpath = "//a[@class='edit edit-email']")
    private WebElement editEmailButton;

    @FindBy(xpath = "//a[@class='edit edit-password']")
    private WebElement editPassButton;

    @FindBy(xpath = ".//*[@id='frameemail']")
    private WebElement frameOfEditMail;

    @FindBy(xpath = ".//*[@id='framepassword']")
    private WebElement frameOfEditPass;

    @FindBy(xpath = ".//*[@id='password_change_email_input']")
    private WebElement passwordField;

    @FindBy(xpath = ".//*[@id='email_input']")
    private WebElement newEmailField;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitEmailButton;

    @FindBy(xpath = "//div[@id='ciam-description' and contains(.,'smart_automater2@outlook.com')]")
    private WebElement changeEmailPopUp;

    @FindBy(xpath = "//div[@id='ciam-description' and contains(.,'smart_automater@outlook.com')]")
    private WebElement returnBackEmailPopUp;

    @FindBy(xpath = "//a[@class='btn btn-sm btn-primary']")
    private WebElement submitChangeEmailButton;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement changedEmailField;

    @FindBy(xpath = ".//*[@id='passwordold']")
    private WebElement oldPassField;

    @FindBy(xpath = ".//*[@id='new-password']")
    private WebElement newPassField;

    @FindBy(xpath = ".//*[@id='new-password-repeated']")
    private WebElement newRePassField;

    @FindBy(xpath = ".//*[@id='ciam-profile-password-change-save-button']")
    private WebElement submitNewPassButton;

    @FindBy(xpath = "//a[@class='btn btn-sm btn-primary']")
    private WebElement confirmNewPassButton;

    @FindBy(xpath = "//button[contains(@class,'nba edit h-vp3 h-vp4')]")
    private WebElement changeSalutationButton;

    @FindBy(xpath = "//button[contains(.,'Speichern')]")
    private WebElement saveDataButton;

    @FindBy(xpath = ".//*[@id='mobile']")
    private WebElement mobileInput;

    @FindBy(xpath = ".//*[@id='street']")
    private WebElement streetInput;

    @FindBy(xpath = ".//*[@id='streetno']")
    private WebElement houseNumberInput;

    @FindBy(xpath = ".//*[@id='city']")
    private WebElement cityInput;

    @FindBy(xpath = ".//*[@id='zip']")
    private WebElement zipInput;

    public ST_CLI_ACC_UPD_LoggedInUserChangesEmailAddress_Page(WebDriver driver) {
        super(driver);
    }

    public void clickEditmailButton() throws InterruptedException {
        waitVisibilityOfElement(emailField);
        scrollDown();
        //Thread.sleep(5000);
        editEmailButton.click();
        waitOfElement(frameOfEditMail);
    }

    public void clickEditPasswordButton(){
        waitVisibilityOfElement(passField);
        scrollDown();
        editPassButton.click();
        waitOfElement(frameOfEditPass);
    }

    public void clickEditPersonalData() throws InterruptedException {
        waitVisibilityOfElement(changeSalutationButton);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 1300);");
        changeSalutationButton.click();
        waitOfElement(saveDataButton);
    }

    public void enterPersonalData(String Mobile, String Street, String HouseNumber, String City, String PostalCode) throws InterruptedException {
        mobileInput.clear();
        mobileInput.sendKeys(Mobile);
        streetInput.clear();
        streetInput.sendKeys(Street);
        houseNumberInput.clear();
        houseNumberInput.sendKeys(HouseNumber);
        cityInput.clear();
        cityInput.sendKeys(City);
        zipInput.clear();
        zipInput.sendKeys(PostalCode);
        saveDataButton.click();
        Thread.sleep(10000);
        waitVisibilityOfElement(changeSalutationButton);
    }

    public String mobileField(){
        return mobileInput.getAttribute("value");
    }

    public String streetField(){
        return streetInput.getAttribute("value");
    }

    public String houseNumberField(){
        return houseNumberInput.getAttribute("value");
    }

    public String cityField(){
        return cityInput.getAttribute("value");
    }

    public String postalCodeField(){
        return zipInput.getAttribute("value");
    }

    public void editMail(String email, String pass){
        driver.switchTo().frame(driver.findElement(By.xpath(".//*[@id='frameemail']")));
        newEmailField.sendKeys(email);
        passwordField.sendKeys(pass);
        submitEmailButton.click();
        submitChangeEmailButton.click();
        try{
            waitVisibilityOfElement(emailField);
        }catch (TimeoutException e){
            System.out.println(e);
        }

    }

    public void editPassword(String oldPassword, String newPassword){
        driver.switchTo().frame(driver.findElement(By.xpath(".//*[@id='framepassword']")));
        oldPassField.sendKeys(oldPassword);
        newPassField.sendKeys(newPassword);
        newRePassField.sendKeys(newPassword);
        submitNewPassButton.click();
        waitOfElement(confirmNewPassButton);
        confirmNewPassButton.click();
    }

    public void waitPaswordField(){
        waitVisibilityOfElement(passField);
    }

    public void submitNewEmail(){
        ArrayList<String> windowHandles = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(windowHandles.get(1));
        waitOfElement(submitChangeEmailButton);
        submitChangeEmailButton.click();
    }

    public String checkNewEmail(){
        return changedEmailField.getText();
    }
}
