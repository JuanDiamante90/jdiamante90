package Test;

import PageObjects.ResultsPage;
import Utils.TestSetUp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import sun.jvm.hotspot.debugger.Page;

import java.util.concurrent.TimeUnit;

@RunWith(JUnit4.class)
public class ResultsPageTests {

    static WebDriver driver;
    ResultsPage ResultsPageElements = PageFactory.initElements(driver, PageObjects.ResultsPage.class);

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/juandiamante/Downloads/chromedriver");

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.aliexpress.com/");
    }

    @Test
    public void secondItemTest() {
        ResultsPageElements.fillSearchBox();
        ResultsPageElements.tapOnSearch();
    }

    @After
    public void tearDown(){
        driver.close();
    }

}
