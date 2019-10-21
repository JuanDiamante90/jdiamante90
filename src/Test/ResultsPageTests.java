package Test;

import page_objects.ResultsPage;
import utils.TestSetUp;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.support.PageFactory;

@RunWith(JUnit4.class)
public class ResultsPageTests extends TestSetUp {

    ResultsPage ResultsPageElements;

    @Test
    public void secondItemTest() {
        ResultsPageElements = PageFactory.initElements(driver, page_objects.ResultsPage.class);

        //Dismiss pop up if necessary
        ResultsPageElements.dismissPopUp();

        //Fill search field and enter
        ResultsPageElements.fillSearchBox();
        ResultsPageElements.tapOnSearch();

        //Dismiss pop up on second page
        ResultsPageElements.dismissPopUp();

        //Scroll to the bottom
        ResultsPageElements.scrollToBottom();
        ResultsPageElements.scrollPageByPixels(-600);

        //Go to second page
        //ResultsPageElements.fillPageNumberTextBox();
        ResultsPageElements.clickOnGoButton();

        //Click on the second item
        ResultsPageElements.tapOnSecondListItem();

        //Dismiss pop up
        ResultsPageElements.dismissPopUp();

        //Assert that buy now is enabled
        ResultsPageElements.scrollPageByPixels(500);

        //Assert that items available is displayed
        ResultsPageElements.assertItemsAreAvailable();
    }
}
