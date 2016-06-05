package seleniumtests;
/**
 * Created by Marek on 04.06.2016.
 */
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


public class HelloDatabaseManagerTest
{
    @Test
    public void startWebDriver()
    {
        WebDriver driver = new HtmlUnitDriver();

        driver.navigate().to("http://pik02.ii.pw.edu.pl:8080/DatabaseManager/");
        Assert.assertTrue("title should start with Selenium Simplified",driver.getTitle().equals("Database Manager"));

        driver.close();
        driver.quit();
    }

}

