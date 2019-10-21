package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage {

    final WebDriver driver;

    //Elements
    @FindBy(xpath = "//input[@id='search-key']")
    WebElement searchBox;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement searchButton;

    //Data
    public String keyword = "iPhone";

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

}
