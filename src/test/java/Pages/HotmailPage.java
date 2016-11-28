package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class HotmailPage extends BasePage {

    @FindBy(xpath = ".//*[@id='i0116']")
    private WebElement emailField;

    @FindBy(xpath = ".//*[@id='i0118']")
    private WebElement passField;

    @FindBy(xpath = "//input[@id='idSIButton9']")
    private WebElement submitButton;

    @FindBy(xpath = ".//*[@role='option' and @tabindex='0' and contains(.,'Ihre Registrierung bei smart.com')]")
    private WebElement confirmationEmail;

    @FindBy(xpath = ".//*[@role='option' and @tabindex='0' and contains(.,'Änderung der E-Mail-Adresse bei smart.com')]")
    private WebElement changeEmail;

    @FindBy(xpath = "//a[contains(.,'Registrierung abschließen')]")
    private WebElement confirmVerificationLink;

    @FindBy(xpath = "//a[contains(.,'Neue E-Mail-Adresse aktivieren')]")
    private WebElement changeEmailVerificationLink;

    @FindBy(xpath = "//button[@title='Löschen (Entf)']")
    private WebElement deleteButton;

    @FindBy(xpath = "//button[@title='Alle Elemente in der Ansicht auswählen']")
    private WebElement checkbox;

    @FindBy(xpath = "//span[@autoid='_n_h']")
    private WebElement headerOfMails;

    @FindBy(xpath = "//button[@aria-label='Menü \"Öffnen\"']")
    private WebElement menuButton;

    @FindBy(xpath = ".//*[@id='O365_SubLink_ShellSignout']")
    private WebElement logOutButton;

    @FindBy(xpath = "//span[contains(.,'Wählen Sie ein zu lesendes Element aus.')]")
    private WebElement emptyMail;

    @FindBy(xpath = ".//*[@id='settings']")
    private WebElement settingMsnButton;

    public HotmailPage(WebDriver driver) {
        super(driver);
    }

    public void emailLogin(String email, String password){
        int count = 0;
        emailField.sendKeys(email);
        submitButton.click();

        do {
            try{
                waitOfElement(passField);
            }catch (TimeoutException e){
                System.out.println("Pass field of Email login doesn't find");
                driver.navigate().refresh();
                count++;
                continue;
            }
            break;
        }while (count > 3);

        passField.sendKeys(password);
        submitButton.click();
    }

    public void deleteMails(){
        int countOperations = 0;
        do{
            try{
                moveToElement(headerOfMails);
                waitOfElement(checkbox);
                checkbox.click();
                waitOfElement(deleteButton);
                deleteButton.click();
            }catch ( TimeoutException | NoSuchElementException e){
                System.out.println(e);
                countOperations++;
                driver.navigate().refresh();
                if(driver.findElements(By.xpath("//span[contains(.,'Wählen Sie ein zu lesendes Element aus.')]")).size() != 0)break;
                continue;
            }
            break;
        }while (countOperations < 3);
    }

    public void clickOnConfirmationEmail() throws InterruptedException {
        int countOperations = 0;
        do{
            try {
                waitOfElement(confirmationEmail);
                moveToElement(confirmationEmail);
                confirmationEmail.click();
            }catch (TimeoutException e){
                System.out.println("Email doesn't display");
                countOperations++;
                driver.navigate().refresh();
                Thread.sleep(2000);
                continue;
            }
            break;
        }while (countOperations < 3);
    }

    public void clickOnChangeEmail(){
        int countOperations = 0;
        do{
            try {
                waitOfElement(changeEmail);
                moveToElement(changeEmail);
                changeEmail.click();
            }catch (TimeoutException e){
                System.out.println("Email doesn't display");
                countOperations++;
                driver.navigate().refresh();
                continue;
            }
            break;
        }while (countOperations < 3);
    }

    public void clickOnVerificationLink(){
        waitOfElement(confirmVerificationLink);
        confirmVerificationLink.click();
    }

    public void clickOnChangeEmailVerificationLink(){
        waitOfElement(changeEmailVerificationLink);
        changeEmailVerificationLink.click();
    }

    public void switchToParntHandle(String parentHandle){
        driver.switchTo().window(parentHandle);
    }

    public void deleteEmailButtonClick(){
        deleteButton.click();
    }

    public void logOutFromMail(){
        waitOfElement(menuButton);
        moveToElement(menuButton);
        menuButton.click();
        waitOfElement(logOutButton);
        logOutButton.click();
        waitOfElement(settingMsnButton);
    }
}
