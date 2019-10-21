package PageObjects;

import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {

    final WebDriver driver;

    //Elements
    @FindBy(xpath = "//input[@id='search-key']")
    WebElement searchBox;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement searchButton;

    @FindBy(xpath = "//a[@class='close-layer' or @class='next-dialog-close']")
    WebElement closePopUpButton;

    @FindBy(xpath = "//input[@aria-label='Large']")
    WebElement pageNumberTextBox;

    @FindBy(xpath = "//span[@class='jump-btn']")
    WebElement goButton;

    @FindBy(xpath = "//li[@class='list-item'] [1]/div/div[2]/div[1]/div[1]/a")
    WebElement secondItemList;

    @FindBy(xpath = "//button[@class='next-btn next-large next-btn-primary buynow'")
    WebElement buyNow;

    //Data
    public String keyword = "iPhone";
    public String pageNumber = "2";

    //Constructor
    public ResultsPage(WebDriver driver){
        //Initialise Elements
        this.driver = driver;
    }

    //Actions
    public void fillSearchBox() {
        searchBox.sendKeys(keyword);
    }

    public void tapOnSearch() {
        searchButton.click();
    }

    public void scrollToBottom() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public void fillPageNumberTextBox() {
        Actions actions = new Actions(driver);
        actions.moveToElement(pageNumberTextBox);
        pageNumberTextBox.sendKeys(pageNumber);
    }

    public void clickOnGoButton() {
        Actions actions = new Actions(driver);
        actions.moveToElement(goButton);
        goButton.click();
    }

    public void dismissPopUp() {
        try {
            WebDriverWait wait = new WebDriverWait(driver,6);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='close-layer' or @class='next-dialog-close']")));
            closePopUpButton.click();
        }
        catch(Exception a) {
            //do nothing
        }
    }

    public void tapOnSecondListItem() {
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", secondItemList);
    }

    public void assertBuyNow() {
        assertTrue(buyNow.isEnabled());
    }

}
