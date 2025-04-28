package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demong {

    WebDriver driver;
    @BeforeClass
    @Parameters({"browser"})
    void setup(String br){
        System.out.println("Browser Value is : "+br);
        switch (br.toLowerCase()){
            case "chrome" : driver = new ChromeDriver(); break;
            case "firefox": driver = new FirefoxDriver();break;
            case "edge": driver = new EdgeDriver();break;
            default:
                System.out.println("Invalid Browser");
        }
        driver.get("https://www.google.com/");
    }
    @Test(priority = 1)
    void HindiCheck(){
        boolean status = driver.findElement(By.xpath("//a[contains(text(),\"हिन्दी\")]")).isDisplayed();
        Assert.assertEquals(status, true);
    }
    @Test(priority = 2)
    void teardown(){
        driver.quit();
    }
}
