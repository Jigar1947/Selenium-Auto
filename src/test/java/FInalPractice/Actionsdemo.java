package FInalPractice;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.util.List;
import java.util.Set;

public class Actionsdemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        Actions act = new Actions(driver);
        driver.get("https://testautomationpractice.blogspot.com/");

//        WebElement pointMe = driver.findElement(By.xpath("//button[@class=\"dropbtn\"]"));
//        WebElement Mobile = driver.findElement(By.xpath("//a[contains(.,\"Mobiles\")]"));
//        // This will hover over it
//        act.moveToElement(pointMe).moveToElement(Mobile).build().perform();
//
//
//        // DOuble click
//        WebElement copyText = driver.findElement(By.xpath("//button[@ondblclick=\"myFunction1()\"]"));
//        act.doubleClick(copyText);
//
//        // Drag and Drop
//        WebElement drag = driver.findElement(By.id("draggable"));
//        WebElement drop = driver.findElement(By.id("droppable"));
//        act.dragAndDrop(drag,drop).build().perform();
//
//        // Slider action
//        WebElement maxslider = driver.findElement(By.xpath("//span[@class=\"ui-slider-handle ui-corner-all ui-state-default\"][2]"));
//        Point mypoint = maxslider.getLocation();
//        System.out.println("maxslider location: "+mypoint);
//        act.dragAndDropBy(maxslider, -100,0).perform();
//        System.out.println("Updated location of maxslider: "+maxslider.getLocation());
//
//        // How to fill a input box without using sendKeys?
//        WebElement inputbox = driver.findElement(By.xpath("//input[@id=\"name\"]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].setAttribute('value','Jigar Sharma')",inputbox);

        // 1) scroll till pixel
//        js.executeScript("window.scrollBy(0,1500)","");
//        System.out.println(js.executeScript("return window.pageYOffset"));

        // 2) Scroll till Visible Element
//        Thread.sleep(5000);
//        WebElement ele = driver.findElement(By.xpath("//a[@href=\"http://testautomationpractice.blogspot.com/\"]"));
//        js.executeScript("arguments[0].scrollIntoView();",ele);

        //3 Scroll till end of the page
        //js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        // Taking Screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File fs = ts.getScreenshotAs(OutputType.FILE);
        File tf = new File(System.getProperty("user.dir")+"\\ScreenShot\\newPage.png");
        fs.renameTo(tf);

        SearchContext shadow01 = driver.findElement(By.cssSelector("div[id=\"shadow_host\"]")).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow1 = shadow01.findElement(By.cssSelector("div[id=\"nested_shadow_host\"]")).getShadowRoot();
        Thread.sleep(1000);
        String answer = shadow1.findElement(By.cssSelector("div")).getText();
        System.out.println(answer);


    }
}
