package Utils;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class TestSetUp  {

    protected WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/juandiamante/Downloads/chromedriver");
        final ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.aliexpress.com/");
    }

    @After
    public void tearDown() {
        driver.close();
    }
}
