package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ST_CAN_REQ_CRE_AnonymousUserConsultationRequest_Page extends BasePage {

    @FindBy(xpath = ".//*[@id='psyma_close_button_link']")
    private WebElement closePopup;

    @FindBy(xpath = "//div[@class='mod modFeedbackformlogictrigger']")
    private WebElement feedbackformlogictrigger;

    public ST_CAN_REQ_CRE_AnonymousUserConsultationRequest_Page(WebDriver driver) {
        super(driver);
    }

    /**
     * This method check presence feedback form
     */
    public void bodyCheck() {
        try {
            driver.findElement(By.xpath("//div[@data-symbolicpagename='requestInfoBrochure']")).isDisplayed();
            System.out.println("Feedback form is Visible");
        } catch (NoSuchElementException e) {
            System.out.println("Feedback form is Invisible");
        }
    }

    /**
     * These methods are check presence of required elements with asterisk
     */

    public void adresstypCheck() {
        try {
            driver.findElement(By.xpath("//div[@class='row clearfix']/span[contains(@class,'radio-label mandatory')]")).isDisplayed();
            System.out.println("Adresstyp field is marked with asteriks");
        } catch (NoSuchElementException e) {
            System.out.println("Adresstyp field isn't marked with asterisk");
        }
    }

    public void anredeCheck() {
        try {
            driver.findElement(By.xpath("//label[@class='mandatory' and @for='fpf_salutation']")).isDisplayed();
            System.out.println("Anrede field is marked with asteriks");
        } catch (NoSuchElementException e) {
            System.out.println("Anrede field isn't marked with asterisk");
        }
    }

    public void vornameCheck() {
        try {
            driver.findElement(By.xpath("//label[@class='mandatory' and @for='fpf_firstName']")).isDisplayed();
            System.out.println("Vorname field is marked with asterisk");
        } catch (NoSuchElementException e) {
            System.out.println("Vorname field isn't marked with asterisk");
        }
    }

    public void nachnameCheck() {
        try {
            driver.findElement(By.xpath("//label[@class='mandatory' and @for='fpf_name1']")).isDisplayed();
            System.out.println("Nachname field is marked with asteriks");
        } catch (NoSuchElementException e) {
            System.out.println("Nachname field isn't marked with asterisk");
        }
    }

    public void straßeCheck() {
        try {
            driver.findElement(By.xpath("//label[@class='mandatory' and @for='fpf_street']")).isDisplayed();
            System.out.println("Straße field is marked with asteriks");
        } catch (NoSuchElementException e) {
            System.out.println("Straße field isn't marked with asterisk");
        }
    }

    public void plzCheck() {
        try {
            driver.findElement(By.xpath("//label[@class='mandatory' and @for='fpf_zipCode']")).isDisplayed();
            System.out.println("PLZ field is marked with asterisk");
        } catch (NoSuchElementException e) {
            System.out.println("PLZ field isn't marked with asterisk");
        }
    }

    public void wohnortCheck() {
        try {
            driver.findElement(By.xpath("//label[@class='mandatory' and @for='fpf_city']")).isDisplayed();
            System.out.println("Wohnort field is marked with asterisk");
        } catch (NoSuchElementException e) {
            System.out.println("Wohnort field isn't marked with asterisk");
        }
    }

    public void emailCheck() {
        try {
            driver.findElement(By.xpath("//label[@class='mandatory' and @for='fpf_email']")).isDisplayed();
            System.out.println("Email field is marked with asterisk");
        } catch (NoSuchElementException e) {
            System.out.println("Email field isn't marked with asterisk");
        }
    }

    public void informationsmaterialCheck() {
        try {
            driver.findElement(By.xpath("//h3[contains(@class,'e-copy-datasheet-1 mandatory')]")).isDisplayed();
            System.out.println("Informationsmaterial field is marked with asterisk");
        } catch (NoSuchElementException e) {
            System.out.println("Informationsmaterial field isn't marked with asterisk");
        }
    }

    public void perTelefonCheck() {
        try {
            driver.findElement(By.xpath("//div[@id='dataPrivacy_channel1']/span[@class='radio-label mandatory']")).isDisplayed();
            System.out.println("Per Telefon field is marked with asterisk");
        } catch (NoSuchElementException e) {
            System.out.println("Per Telefon field isn't marked with asterisk");
        }
    }

    public void perElektronischerPostCheck() {
        try {
            driver.findElement(By.xpath("//div[@id='dataPrivacy_channel2']/span[@class='radio-label mandatory']")).isDisplayed();
            System.out.println("Per Elektronischer Post field is marked with asterisk");
        } catch (NoSuchElementException e) {
            System.out.println("Per Elektronischer Post field isn't marked with asterisk");
        }
    }

    public void perPostCheck() {
        try {
            driver.findElement(By.xpath("//div[@id='dataPrivacy_channel3']/span[@class='radio-label mandatory']")).isDisplayed();
            System.out.println("Per Post field is marked with asterisk");
        } catch (NoSuchElementException e) {
            System.out.println("Per Post field isn't marked with asterisk");
        }
    }
}
