package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utility.BrowserDriver;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class SearchValidJobTitle extends BrowserDriver{

    public static String job_title = "//*[@id='keyword']";
    public static String search =  "//*[@id='search']";
    public static String location = "//*[@id='location']";
    public static String cookies_reject = "//*[@id='reject-cookies']";
    public static String result_message = "//*[@id='search-results-heading']";
    public static String results_shown = "//*[@id='first-result-title']";
    public static String results_shown2 = "//*[@id='job-title-2']/a";

    public static void search_valid_job_title_location() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath(cookies_reject)).click();

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
        driver.findElement(By.xpath(job_title)).sendKeys("Test");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(2000);
        driver.findElement(By.xpath(location)).sendKeys("Bristol");

    /*   try{
            Robot robot = new Robot();
            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        }
        catch (Exception e) {
            e.printStackTrace();
        } */

        Actions actions = new Actions(driver);

        // Press Tab key 4 times
        for (int i = 0; i < 4; i++) {
            actions.sendKeys(Keys.TAB).build().perform();
            //actions.sendKeys("\uE004").perform(); // \uE004 is the Unicode for Tab key
        }

       //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Thread.sleep(2000);
        driver.findElement(By.xpath(search)).click();
        System.out.println("Search button clicked");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        Thread.sleep(2000);
    }

    public static void search_result_valid_job_title() throws InterruptedException
    {
        String result_heading = driver.findElement(By.xpath(result_message)).getText();
        System.out.println("Search results heading: "+result_heading);
        try{
            Robot robot = new Robot();
            Thread.sleep(1000);
           // robot.keyPress(KeyEvent.VK_TAB);
            //robot.keyRelease(KeyEvent.VK_TAB);
            robot.keyPress(KeyEvent.VK_PAGE_DOWN);
            robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        String results_title1 = driver.findElement(By.xpath(results_shown)).getText();
        System.out.println("Below are the search results for the valid job title");
        System.out.println("The first job shown on the results page is: "+results_title1);
        try {
            assertEquals("Senior System Test Engineer", results_title1);
            System.out.println("Assertion passed");
        }
        catch(AssertionError e)
        {
           System.out.println("Assertion failed");
        }
        String results_title2 = driver.findElement(By.xpath(results_shown2)).getText();
        System.out.print("The second job shown on the results page is: "+results_title2);
    }

}
