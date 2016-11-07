package Pages;

import com.Captcha;
import com.Exception;
import com.SocketClient;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class ST_CAN_REQ_CRE_AnonymousUserCreatesCONNECTAccountByEmail_Page extends BasePage {

    @FindBy(xpath = ".//*[@id='ciam-weblogin-auth-register-link']")
    private WebElement registerButton;

    @FindBy(xpath = ".//*[@id='sm']")
    private WebElement herr;

    @FindBy(xpath = ".//*[@id='firstName_input']")
    private WebElement firstnameField;

    @FindBy(xpath = ".//*[@id='lastName_input']")
    private WebElement lastNameField;

    @FindBy(xpath = ".//*[@id='email_input']")
    private WebElement emailField;

    @FindBy(xpath = ".//*[@id='r_email_input']")
    private WebElement rEmailField;

    @FindBy(xpath = ".//*[@id='captcha_input']")
    private WebElement captchaField;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
    private WebElement submitButton;

    @FindBy(xpath = ".//*[@id='agb_input']")
    private WebElement agbInput;

    @FindBy(xpath = "//input[@id='new-password']")
    private WebElement newPassword;

    @FindBy(xpath = "//input[@id='new-password-repeated']")
    private WebElement repeatPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitPassword;

    @FindBy(xpath = "//span[contains(.,'Registrierung erfolgreich')]")
    private WebElement registrationSuccessful;

    @FindBy(xpath = "//a[contains(.,'Weiter')]")
    private WebElement weiterButton;

    @FindBy(xpath = "//span[contains(.,'Ihr Benutzerkonto wurde erstellt')]")
    private WebElement confirmationTitle;

    public ST_CAN_REQ_CRE_AnonymousUserCreatesCONNECTAccountByEmail_Page(WebDriver driver) {
        super(driver);
    }

    public void registerButtonClick(){
        registerButton.click();
    }

    public void andredeRadioButton(){
        herr.click();
    }

    public void firstNameField(String name){
        firstnameField.sendKeys(name);
    }

    public void lastNameField(String lastName){
        lastNameField.sendKeys(lastName);
    }

    public void emailField(String email){
        emailField.sendKeys(email);
    }

    public void rEmailField(String rEmail){
        rEmailField.sendKeys(rEmail);
    }

    public void createPassword(String pass){
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        waitOfElement(newPassword);
        newPassword.sendKeys(pass);
        repeatPassword.sendKeys(pass);
        submitPassword.click();
    }

    public void checkSuccessfulText(){
        registrationSuccessful.isDisplayed();
        weiterButton.click();
    }

    public void captcha() throws IOException, Exception, InterruptedException {
        int countOperations = 0;
        do {
            try{
                byte[] arrScreen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Thread.sleep(1000);
                BufferedImage imageScreen = ImageIO.read(new ByteArrayInputStream(arrScreen));
                WebElement cap = driver.findElement(By.xpath(".//*[@id='captchaImage']"));
                Dimension capDimension = cap.getSize();
                Integer capDimensionWidth = 180;
                Integer capDimensionHeight = 180;
                //Point capLocation = cap.getLocation();
                Integer capLocationX = 1082;
                Integer capLocationY = 526;

                //BufferedImage imgCap = imageScreen.getSubimage(capLocation.x, capLocation.y, capDimension.width, capDimension.height);
                BufferedImage imgCap = imageScreen.getSubimage(capLocationX, capLocationY, capDimensionWidth, capDimensionHeight);
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                File f = new File("MyFile.png");
                ImageIO.write(imgCap, "PNG", f);
                ImageIO.write(imgCap, "png", os);

                SocketClient client = new SocketClient("lunananebe", "Sciphone98");
                Captcha res = client.decode(new ByteArrayInputStream(os.toByteArray()));
                System.out.println(res.text);

                captchaField.sendKeys(res.text);
                agbInput.click();
                submitButton.click();
                confirmationTitle.isDisplayed();
            } catch (IOException| Exception |NoSuchElementException e) {
                System.out.println("Captcha is wrong");
                countOperations++;
                agbInput.click();
                continue;
            }
            break;
        }while (countOperations < 3 );
    }
}
