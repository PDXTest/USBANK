package Wipro.com.USBANK;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.Assert;


public class CrossBrowserANDParallelTesting {
        
    public WebDriver driver;
    
    //Expected header value
    public String headerValue = "Applied Selenium";
    
    
    @Test
    @Parameters("browser")
    
    //The @Test method should accept a String variable
    public void verifyHeaderValue(String browserName) {
        
        //check for the browser value and invoke the called browser
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "E:\\Selenium_Data\\Driver\\CH\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        if(browserName.equalsIgnoreCase("ff")) {
            System.setProperty("webdriver.gecko.driver","E:\\Selenium_Data\\geckodriver-v0.26.0-win64\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        
        //print which browser is started
        System.out.println(browserName + "Started");
        driver.manage().window().maximize();
        driver.get("http://www.appliedselenium.com/");
        
        //Locate the header value, get its text value and store in a String variable 
        String actualValue = driver.findElement(By.xpath("//h1[@class='bestwp-site-title']/a[contains(text(),'Applied Selenium')]")).getText();
        
        //Verify if values are equal. Upon inequality the test would fail
        Assert.assertEquals(headerValue, actualValue);
        
        //print which browser is closed
        System.out.println(browserName + "Closed");
        
        driver.quit();
        
    }
    
  
}
