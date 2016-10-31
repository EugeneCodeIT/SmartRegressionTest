package Pages;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getAssertUrl(){
        return driver.getCurrentUrl();
    }

    public void waitOfElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitVisibilityOfElement(WebElement element){
        (new WebDriverWait(driver, 30))
                .until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Method moves mouse over element
     */
    public void moveToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public String getWindowWidth(){
        int widwowWidth = driver.manage().window().getSize().getWidth();
        String width = Integer.toString(widwowWidth);
        return width;
    }

    public String getWindowHeight(){
        int widwowHeight = driver.manage().window().getSize().getHeight();
        String height = Integer.toString(widwowHeight);
        return height;
    }

    public String getBrowserName(){
        Capabilities caps = ((RemoteWebDriver)driver).getCapabilities();
        String browserName = caps.getBrowserName();
        return browserName;
    }

    public String getBrowserVersion(){
        Capabilities caps = ((RemoteWebDriver)driver).getCapabilities();
        String browserVersion = caps.getVersion();
        return browserVersion;
    }



    public WebDriver getDriver() {
        return driver;
    }
}
