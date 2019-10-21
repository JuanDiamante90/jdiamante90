package Test;

import PageObjects.ResultsPage;
import Utils.TestSetUp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@RunWith(JUnit4.class)
public class ResultsPageTests extends TestSetUp {

    static WebDriver driver;
    ResultsPage ResultsPageElements;

    @Test
    public void secondItemTest() {
        ResultsPageElements = PageFactory.initElements(driver, PageObjects.ResultsPage.class);

        //Dismiss pop up if necessary
        ResultsPageElements.dismissPopUp();

        //Fill search field and enter
        ResultsPageElements.fillSearchBox();
        ResultsPageElements.tapOnSearch();

        //Dismiss pop up on second page
        ResultsPageElements.dismissPopUp();

        //Scroll to the bottom
        ResultsPageElements.scrollToBottom();

        //Go to second page
        ResultsPageElements.fillPageNumberTextBox();
        ResultsPageElements.clickOnGoButton();

        //Click on the second item
        ResultsPageElements.tapOnSecondListItem();

        //Dismiss pop up
        ResultsPageElements.dismissPopUp();

        //Assert that buy now is enabled
        ResultsPageElements.assertBuyNow();
    }

}
