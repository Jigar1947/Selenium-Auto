package MyPractice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

public class CaptureScreenshots {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.nopcommerce.com/");

        // TakesScreenshot instace variable
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
//
//        // Providin f locaiton to be stored screnshot
//        File targetFile = new File(System.getProperty("user.dir")+"\\ScreenShot\\FullPage.png");
//        sourceFile.renameTo(targetFile);

        // 2) Capture Specific Area of web PAge
        WebElement FeaturedProducts = driver.findElement(By.xpath("//div[@class=\"product-grid home-page-product-grid\"]"));
        File sf = FeaturedProducts.getScreenshotAs(OutputType.FILE);
        File tf = new File(System.getProperty("user.dir")+"\\ScreenShot\\FeaturedProduct.png");
        sf.renameTo(tf);
        driver.quit();
        
    }
}
