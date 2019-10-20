package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class resultsPageObjects extends PageObject{

    private static WebElement element = null;

    public resultsPageObjects(WebDriver driver) {
        super(driver);
    }

    public static WebElement searchBox(WebDriver driver) {
        element = driver.findElement(By.xpath("//input[@id='search-key']"));
        return element;
    }


}
