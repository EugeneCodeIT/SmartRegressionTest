package Pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    @FindBy(xpath = "//a[contains(.,'Registrierung abschließen')]")
    private WebElement verificationLink;

    @FindBy(xpath = "//button[@title='Löschen (Entf)']")
    private WebElement deleteButton;

    @FindBy(xpath = "//button[@class='_n_W noMargin ms-font-m o365button']")
    private WebElement checkbox;

    @FindBy(xpath = "//div[@class='_n_V']")
    private WebElement headerOfMails;

    public HotmailPage(WebDriver driver) {
        super(driver);
    }

    public void emailLogin(String email, String password){
        emailField.sendKeys(email);
        submitButton.click();
        waitOfElement(passField);
        passField.sendKeys(password);
        submitButton.click();
    }

    public void deleteMails(){
        try{
            moveToElement(headerOfMails);
            Thread.sleep(1000);
            checkbox.click();
            waitOfElement(deleteButton);
            deleteButton.click();
        }catch ( TimeoutException | NoSuchElementException e){
            System.out.println(e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickOnEmail(){
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
                continue;
            }
            break;
        }while (countOperations < 3);
    }

    public void clickOnVerificationLink(){
        waitOfElement(verificationLink);
        verificationLink.click();
    }

    public void switchToParntHandle(String parentHandle){
        driver.switchTo().window(parentHandle);
    }

    public void deleteEmailButtonClick(){
        deleteButton.click();
    }
}
