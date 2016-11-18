package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Random;

public class ST_CAN_DLR_FND_AnonymousUserSearchesForDealerWithDirections_Page extends BasePage{

    @FindBy(xpath = "//input[@class='textfield input_user_address']")
    private WebElement inputUserAddressField;

    @FindBy(xpath = "//a[@class='btn-deleteinput']")
    private WebElement deleteInputButton;

    @FindBy(xpath = "//div[@class='row infocontent' and contains(@style,'display: block;')]/a[contains(@class,'cc-link dealer-open tabDealers e-copytext3')]")
    private WebElement infoContentList;

    @FindBy(xpath = "//a[@class='nba vp12 btn_dealer_search']")
    private WebElement dealerSearchButton;

    @FindBy(xpath = "//div[@class='row map']/div[@class='mapToggle vp__34' and @style='display: none;']")
    private WebElement mapStatic;

    @FindBy(xpath = "//span[@class='cc-icon cc-icon-locate']")
    private WebElement locateButton;

    @FindBy(xpath = "//div[@class='row dealercontent' and contains(@style,'display: block;')]/div/ul/li/a[contains(@class,'cc-link cc-link-route')]/span")
    private WebElement linkRoute;

    @FindBy(xpath = "//div[@jsaction='directionsPanel.selectLeg']")
    private WebElement directionsPanel;

    @FindBy(xpath = "//table[@class='adp-directions']")
    private WebElement directionsTable;

    public ST_CAN_DLR_FND_AnonymousUserSearchesForDealerWithDirections_Page(WebDriver driver) {
        super(driver);
    }

    public void deleteInputButtonClick(){
        deleteInputButton.click();
    }

    public void dealerSearchButtonClick() throws InterruptedException {
        Thread.sleep(1000);
        dealerSearchButton.click();
    }

    public void emptyWorldMap() throws InterruptedException {
        Thread.sleep(1000);
        try {
            mapStatic.isDisplayed();
        }catch (NoSuchElementException e){
            System.out.println("mapStatic element not present");
        }
    }

    public void locateButtonClick(){
        locateButton.click();
    }

    public void inputuserAddressField(String address){
        inputUserAddressField.sendKeys(address);
    }

    public void infoContentList() throws InterruptedException {
        Thread.sleep(3000);
        try{
            waitVisibilityOfElement(infoContentList);
            infoContentList.isDisplayed();
        }catch (NoSuchElementException e){
            System.out.println("infoContentList is not displayed");
        }
    }

    public void getDirection() throws InterruptedException {
        boolean breakIt = true;
        while (true) {
            breakIt = true;
            try {
                waitVisibilityOfElement(linkRoute);
                linkRoute.click();
            } catch (Exception e) {
                if (e.getMessage().contains("element is not attached")) {
                    breakIt = false;
                }
            }
            if (breakIt) {
                break;
            }

        }
        waitVisibilityOfElement(directionsPanel);
    }

    public void directionTable() throws InterruptedException {
        Thread.sleep(3000);
        try{
            directionsTable.isDisplayed();
        }catch (NoSuchElementException e){
            System.out.println("Direction table is absent");
        }

    }

    public int countOfDialers(){

        List<WebElement> optionCount = driver.findElements(By.xpath("//div[@class='row infocontent']/a"));
        optionCount.size();
        return optionCount.size();
    }

}
