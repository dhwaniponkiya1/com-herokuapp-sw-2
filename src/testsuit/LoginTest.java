package testsuit;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 BaseUrl = http://the-internet.herokuapp.com/login
 2. Create the package ‘testsuite’ and create the
 following class inside the ‘testsuite’ package.
 1. LoginTest
 3. Write down the following test into ‘LoginTest’ class
 1. userSholdLoginSuccessfullyWithValidCredentials
 * Enter “tomsmith” username
 * Enter “SuperSecretPassword!” password
 * Click on ‘LOGIN’ button
 * Verify the text “Secure Area”
 2. verifyTheUsernameErrorMessage
 * Enter “tomsmith1” username
 * Enter “SuperSecretPassword!” password
 * Click on ‘LOGIN’ button
 * Verify the error message “Your username
 is invalid!”
 3. verifyThePasswordErrorMessage
 * Enter “tomsmith” username
 * Enter “SuperSecretPassword” password
 * Click on ‘LOGIN’ button
 * Verify the error message “Your password
 is invalid!”

 */

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        WebElement emailElement = driver.findElement(By.id("username"));
        WebElement passwordElement = driver.findElement(By.id("password"));

        emailElement.sendKeys("tomsmith");
        passwordElement.sendKeys("SuperSecretPassword!");

        //click login button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

        String expectedText = "Secure Area";
        String actualText = driver.findElement(By.xpath("//h2")).getText();

        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyTheUsernameErrorMessage(){
        WebElement emailElement = driver.findElement(By.id("username"));
        WebElement passwordElement = driver.findElement(By.id("password"));

        emailElement.sendKeys("tomsmith1");
        passwordElement.sendKeys("SuperSecretPassword!");

        //click login button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

        String expectedText = "Your username is invalid!";
        String actualText = driver.findElement(By.xpath("//div[contains(text(), 'Your username is invalid!')]")).getText().substring(0,25);
        Assert.assertEquals(expectedText, actualText);
    }

    @Test
    public void verifyThePasswordErrorMessage(){
        WebElement emailElement = driver.findElement(By.id("username"));
        WebElement passwordElement = driver.findElement(By.id("password"));

        emailElement.sendKeys("tomsmith");
        passwordElement.sendKeys("SuperSecretPassword");

        //click login button
        driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();

        String expectedText = "Your password is invalid!";
        String actualText = driver.findElement(By.xpath("//div[contains(text(), 'Your password is invalid!')]")).getText().substring(0,25);
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void tearDown(){
        closeBrowser();
    }
}
