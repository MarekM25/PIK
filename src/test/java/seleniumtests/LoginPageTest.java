package seleniumtests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * Created by Marek on 05.06.2016.
 */
public class LoginPageTest
{
    private String loginPageUrl = "http://pik02.ii.pw.edu.pl:8080/DatabaseManager/";
    private WebDriver driver = new HtmlUnitDriver();

    @Before
    public void setup() {
        driver.navigate().to(loginPageUrl);
    }

    @Test
    public void hasLoginPage()
    {
        Assert.assertTrue("title should be DatabaseManager",driver.getTitle().equals("Database Manager"));
    }


    @Test
    public void hasLoginFields()
    {
        driver.findElement(By.id("username"));
        driver.findElement(By.id("password"));
    }

    @After
    public void cleanUp()
    {
        driver.close();
        driver.quit();
    }
}
