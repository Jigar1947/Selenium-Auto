package MyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlingFrames {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://ui.vision/demo/webtest/frames/");

        //Frame 1
        WebElement Frame1 = driver.findElement(By.xpath("//frame[@src=\"frame_1.html\"]"));
        driver.switchTo().frame(Frame1);
        driver.findElement(By.xpath("//input[@name=\"mytext1\"]")).sendKeys("Hello world");

        driver.switchTo().defaultContent(); // weneed to switch back to default content to switch frames
        //frame 2
        WebElement frame2 = driver.findElement(By.xpath("//frame[@src=\"frame_2.html\"]"));
        driver.switchTo().frame(frame2);
        driver.findElement(By.xpath("//input[@name=\"mytext2\"]")).sendKeys("This is answer 2 ");

        driver.switchTo().defaultContent();

        //frame 3 containing iframe
        WebElement frame3  = driver.findElement(By.xpath("//frame[@src=\"frame_3.html\"]"));
        driver.switchTo().frame(frame3);
        driver.findElement(By.xpath("//input[@name=\"mytext3\"]")).sendKeys("This is answer 3 ");

        //Switching to Iframe
        driver.switchTo().frame(0);
        //div[@id="i6"]//div[@class="vd3tt"]
        driver.findElement(By.xpath("//div[@id=\"i6\"]//div[@class=\"vd3tt\"]")).click();

        //Switching back to default ocnternt
        driver.switchTo().defaultContent();
        // enternng frame 5
        WebElement frame5 = driver.findElement(By.xpath("//frame[@src=\"frame_5.html\"]"));
        driver.switchTo().frame(frame5);
        driver.findElement(By.xpath("//a[@href=\"https://a9t9.com\"]")).click();

        Thread.sleep(3000);

        WebElement logo = driver.findElement(By.xpath("//div[@id=\"header\"]//img[@class=\"responsive-img\"]"));
        if(logo.isDisplayed()) System.out.println("Logo is displayed");




    }
}
