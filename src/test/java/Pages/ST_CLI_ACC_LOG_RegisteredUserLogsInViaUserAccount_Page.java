package Pages;

import com.Captcha;
import com.Exception;
import com.SocketClient;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * Created by QA on 27.10.2016.
 */
public class ST_CLI_ACC_LOG_RegisteredUserLogsInViaUserAccount_Page extends BasePage {

    @FindBy(xpath = ".//*[@id='name']")
    private WebElement emailField;

    @FindBy(xpath = ".//*[@id='password']")
    private WebElement passwordField;

    @FindBy(xpath = ".//*[@id='remember-me']")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = ".//*[@id='ciam-weblogin-auth-login-button']")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class='secondary-bar action-bar']/ul/li[2]/div/div/div/div/ul/li[5]/a[@href='/de/de/index/_jcr_content/header.logout.html']")
    private WebElement logoutButton;

    @FindBy(xpath = "//form[@class='form-horizontal no-obvious-asterisk']")
    private WebElement loginForm;

    @FindBy(xpath = "//div[@class='secondary-bar action-bar']/ul/li[2]/div/a/span[@class='nav-title-text' and contains(.,'Connect')]")
    private WebElement connectButtonContainsConnect;

    @FindBy(xpath = "html/body/div[2]/header/div/div/div[3]/div[7]/ul/li[2]/div/a/span")
    private WebElement connectButton;

    @FindBy(xpath = "//div[contains(@class,'server-side-error')]")
    private WebElement serverSideError;

    @FindBy(xpath = ".//*[@id='captcha_input']")
    private WebElement captchaField;

    public ST_CLI_ACC_LOG_RegisteredUserLogsInViaUserAccount_Page(WebDriver driver) {
        super(driver);
    }

    public void clearEmailField(){
        emailField.clear();
    }

    public void clearPasswordField(){
        passwordField.clear();
    }

    public void emailField(String email){
        waitOfElement(emailField);
        emailField.sendKeys(email);
    }

    public void passwordField(String pass){
        waitOfElement(passwordField);
        passwordField.sendKeys(pass);
    }

    public void submitButtonClick(){
        submitButton.click();
    }

    public void rememberMeCheckCheckbox(){
        rememberMeCheckbox.click();
    }

    public void logoutButtonClick() throws InterruptedException {
        waitOfElement(logoutButton);
        logoutButton.click();
        moveToElement(connectButton);
        waitOfElement(connectButtonContainsConnect);
    }

    public void switchToFrame(){
        driver.switchTo().frame(driver.findElement(By.xpath(".//*[@id='framelogin']")));
    }

    public void switchToWebPage(){
        driver.switchTo().defaultContent();
    }

    public String serverSideError (){
        return serverSideError.getText();
    }

    public void captchaField (String test){
        captchaField.sendKeys(test);
    }

    /**
     * This is method which is parsing captcha
     */
    public void captcha() throws IOException, Exception, InterruptedException {
        int countOperations = 0;
        do {
            try{
                byte[] arrScreen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                Thread.sleep(1000);
                BufferedImage imageScreen = ImageIO.read(new ByteArrayInputStream(arrScreen));
                WebElement cap = driver.findElement(By.xpath(".//*[@id='captchaImage']"));
                Dimension capDimension = cap.getSize();
                //Point capLocation = cap.getLocation();
                Integer capLocationX = 1078;
                Integer capLocationY = 400;

                //BufferedImage imgCap = imageScreen.getSubimage(capLocation.x, capLocation.y, capDimension.width, capDimension.height);
                BufferedImage imgCap = imageScreen.getSubimage(capLocationX, capLocationY, capDimension.width, capDimension.height);
                ByteArrayOutputStream os = new ByteArrayOutputStream();
                File f = new File("MyFile.png");
                ImageIO.write(imgCap, "PNG", f);
                ImageIO.write(imgCap, "png", os);

                SocketClient client = new SocketClient("lunananebe", "Sciphone98");
                Captcha res = client.decode(new ByteArrayInputStream(os.toByteArray()));
                System.out.println(res.text);

                captchaField.sendKeys(res.text);
                submitButton.click();
                driver.findElement(By.xpath("//li[@class='nav-item action-nav-item login-nav-item vp12']/div/a/span[@class='nav-title-text' and contains(.,'Test')]"));

            } catch (IOException|Exception|NoSuchElementException e) {
                System.out.println("Captcha is wrong");
                countOperations++;
                passwordField.sendKeys("Testen123");
                continue;
            }
            break;
        }while (countOperations < 3 );
    }

}
