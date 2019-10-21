package page_objects;

import utils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class ResultsPage extends TestUtils{

    //Elements
    @FindBy(xpath = "//input[@id='search-key']")
    WebElement searchBox;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement searchButton;

    @FindBy(xpath = "//a[@class='close-layer' or @class='next-dialog-close']")
    WebElement closePopUpButton;

    @FindBy(xpath = "//input[@aria-label='Large']")
    WebElement pageNumberTextBox;

    @FindBy(xpath = "//button[@aria-label='Next page, current page 1']")
    WebElement goButton;

    @FindBy(xpath = "//li[@class='list-item'] [1]/div/div[2]/div[1]/div[1]/a")
    WebElement secondItemList;

    @FindBy(xpath = "//button[@class='next-btn next-large next-btn-primary buynow']")
    WebElement buyNow;

    @FindBy(css = "div.product-quantity-info > div > span")
    WebElement itemsAvailable;

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

    public void scrollToNext() {
        scrollForView(goButton);
    }

    public void fillPageNumberTextBox() {
        moveToElement(pageNumberTextBox);
        pageNumberTextBox.sendKeys(pageNumber);
    }

    public void clickOnGoButton() {
        moveToElement(goButton);
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

    public void assertItemsAreAvailable() {
        //If product quantity doesn't start with zero, then there's items available
        // I'm assuming how the text is displayed when no items are available because I couldn't find an example
        itemsAvailable.isDisplayed();
        String itemCount = itemsAvailable.getText();
        assertTrue(!itemCount.startsWith("0"));
    }

}
