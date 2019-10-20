package Test;

import PageObjects.PageObject;
import PageObjects.ResultsPage;
import Utils.TestSetUp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.jvm.hotspot.debugger.Page;

@RunWith(JUnit4.class)
public class ResultsPageTests extends TestSetUp {

    ResultsPage resultsPage = new ResultsPage(driver);

    @Test
    public void secondItemTest() {
        resultsPage.fillSearchBox();
        resultsPage.tapOnSearch();
    }

}
