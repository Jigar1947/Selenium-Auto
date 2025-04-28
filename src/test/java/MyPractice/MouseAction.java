package MyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseAction {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        WebElement pointMe = driver.findElement(By.xpath("//button[@class=\"dropbtn\"]"));
        WebElement Mobile = driver.findElement(By.xpath("//a[contains(.,\"Mobiles\")]"));


        Actions act = new Actions(driver);
        act.moveToElement(pointMe).moveToElement(Mobile).build().perform();
        WebElement minSlider = driver.findElement(By.xpath("//span[@class=\"ui-slider-handle ui-corner-all ui-state-default\"][1]"));
        Point myPoint = minSlider.getLocation();
        System.out.println("Default location of firstSlider"+myPoint);
        Actions myAct = new Actions(driver);
        myAct.dragAndDropBy(minSlider, 200,0).perform();
        System.out.println("Updated location of slider is : "+ minSlider.getLocation());


    }
}
