package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResultsPage extends PageObject{

    public ResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Elements
    @FindBy(xpath = ("//input[@id='search-key']"))
    private WebElement searchBox;

    @FindBy(xpath = ("//input[@type='submit']"))
    private WebElement searchButton;

    //Data
    public String keyword = "iPhone";

    //Actions
    public void fillSearchBox() {
        this.searchBox.sendKeys(keyword);
    }

    public void tapOnSearch() {
        this.searchButton.click();
    }

}
