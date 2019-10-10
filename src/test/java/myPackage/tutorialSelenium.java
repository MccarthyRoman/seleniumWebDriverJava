package myPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class tutorialSelenium {
    @Test
    public void loginTest() {
        System.out.println("Starting logging test");

        //create driver
        System.setProperty("webdriver.chrome.driver","/Users/mac/IdeaProjects/testForQAAutomation/drivers/chromedriver/");
        WebDriver driver = new ChromeDriver();

        //maximize window
        driver.manage().window().maximize();

        //open test page
        String url = "https://the-internet.herokuapp.com/login";
        driver.get(url);
        System.out.println("Page is opened");

        //sleep for 3 seconds
        sleep();

        //enter username
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");
        sleep();

        //enter password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");
        sleep();

        //click login button
        WebElement clickButton = driver.findElement(By.className("radius"));
        clickButton.click();
        sleep();

        //verification:
        //new url
        String expectedURL = "https://the-internet.herokuapp.com/secure";
        String currentURL = driver.getCurrentUrl();
        Assert.assertEquals(currentURL, expectedURL, "Incorrect URL Test failed");
        //logout button is visible
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"content\"]/div/a"));
        //Assert.assertTrue();

        //success message
        WebElement successMessage = driver.findElement(By.id("flash"));

        driver.close();
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
