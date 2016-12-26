package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
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

    @FindBy(xpath = ".//*[@role='option' and contains(.,'Änderung der E-Mail-Adresse bei smart.com')]")
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

    @FindBy(xpath = ".//span[contains(.,'Posteingang')]")
    private WebElement posteingangButton;

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
                String name = System.getProperty("driver");
                if (name.equals("chrome")){
                    waitOfElement(posteingangButton);
                    posteingangButton.click();
                    if(driver.findElements(By.xpath("//span[contains(.,'Sie sind auf dem Laufenden')]")).size() != 0)break;
                    waitVisibilityOfElement(headerOfMails);
                    moveToElementAndClick(checkbox);
                }
                if (name.equals("firefox")){
                    clickOnElemenByJS(posteingangButton);
                    if(driver.findElements(By.xpath("//span[contains(.,'Sie sind auf dem Laufenden')]")).size() != 0)break;
                    moveToElement(headerOfMails);
                    waitOfElement(checkbox);
                    clickOnElemenByJS(checkbox);
                }
                waitOfElement(deleteButton);
                deleteButton.click();
                if(driver.findElements(By.xpath("//span[contains(.,'Sie sind auf dem Laufenden')]")).size() != 0)break;
            }catch ( TimeoutException | NoSuchElementException e){
                System.out.println(e);
                countOperations++;
                driver.navigate().refresh();
                posteingangButton.click();
                if(driver.findElements(By.xpath("//span[contains(.,'Sie sind auf dem Laufenden')]")).size() != 0)break;
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
                moveToElementAndClick(confirmationEmail);
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

    public void clickOnChangeEmail() throws InterruptedException {
        Thread.sleep(3000);
        int countOperations = 0;
        do{
            try {
                waitOfElement(changeEmail);
                clickOnElemenByJS(posteingangButton);
                clickOnElemenByJS(changeEmail);
                waitOfElement(changeEmailVerificationLink);
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
        int countOperations = 0;
        do {
            try{
                waitOfElement(changeEmailVerificationLink);
            }catch (TimeoutException e){
                System.out.println("Link doesn't display");
                countOperations++;
                driver.navigate().refresh();
                continue;
            }
            break;
        }while (countOperations < 3);
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
        moveToElementAndClick(menuButton);
        menuButton.click();
        waitOfElement(logOutButton);
        waitVisibilityOfElement(logOutButton);
        logOutButton.click();
        waitOfElement(settingMsnButton);
    }
}
