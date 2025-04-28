package MyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class JavaScriptExecutorDemo {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        WebElement inputbox = driver.findElement(By.xpath("//input[@id=\"name\"]"));

        // Now create a javascriptExecutor variable
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('value','Jigar Sharma')",inputbox);

        WebElement radioButton = driver.findElement(By.xpath("//input[@id=\"male\"]"));
        js.executeScript("arguments[0].click()",radioButton);

        // SCROLLING BAR DEMO

        // 1) Scroll till a particular pixel
        //js.executeScript("window.scrollBy(0,1500)","");
        //System.out.println(js.executeScript("return window.pageYOffset;"));

        // 2) Scroll till a visible element
//        WebElement ele = driver.findElement(By.xpath("//h2[contains(text(),\"Pagination Web Table\")]"));
//        js.executeScript("arguments[0].scrollIntoView();",ele);
//        System.out.println(js.executeScript("return window.pageYOffset;"));

        // 3) Scroll Till end of the Page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(5000);

        // scroll back to beginning of page
        js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");

        // zoomin in and out
        js.executeScript("document.body.style.zoom='50%'");


    }
}
