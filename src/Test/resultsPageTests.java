package Test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@RunWith(JUnit4.class)
public class resultsPageTests {

    @Test
    public void secondItemTest() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "/Users/juandiamante/Downloads/chromedriver");

        driver = new ChromeDriver();
        driver.get("http://www.aliexpress.com/");
    }

}
