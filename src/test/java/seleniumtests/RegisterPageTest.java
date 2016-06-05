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
public class RegisterPageTest
{
    private String registerPageUrl = "http://pik02.ii.pw.edu.pl:8080/DatabaseManager/account/create";
    private WebDriver driver = new HtmlUnitDriver();

    @Before
    public void setup() {
        driver.navigate().to(registerPageUrl);
    }

    @Test
    public void hasRegisterPage()
    {
        Assert.assertTrue("title should be DatabaseManager",driver.getTitle().equals("Database Manager"));
    }



    @Test
    public void hasRegisterFields()
    {
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement matchingPassword = driver.findElement(By.id("matchingPassword"));
    }

    @After
    public void cleanUp()
    {
        driver.close();
        driver.quit();
    }

}
