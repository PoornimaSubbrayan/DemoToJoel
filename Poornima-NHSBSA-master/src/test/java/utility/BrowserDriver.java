package utility;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserDriver {
    public  static RemoteWebDriver driver;
    public static void invokedriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;

        }
        driver.get("https://www.jobs.nhs.uk/candidate/search");
        driver.manage().window().maximize();
        System.out.println("Title of the page:"+driver.getTitle());

    }
    public static void close() throws InterruptedException {
        driver.close();
    }
}

