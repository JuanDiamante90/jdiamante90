package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultsPage {

    final WebDriver driver;

    //Elements
    @FindBy(xpath = "//input[@id='search-key']")
    WebElement searchBox;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement searchButton;

    @FindBy(xpath = "//a[@href='javascript:;' and @class='close-layer']")
    WebElement closePopUpButton;

    @FindBy(xpath = "//input[@aria-label='Large']")
    WebElement pageNumberTextBox;

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
        pageNumberTextBox.sendKeys(pageNumber);
    }

    public void dismissPopUp() {
        try {
            closePopUpButton.click();
        }
        catch(Exception a) {
            //do nothing
        }
    }

}
