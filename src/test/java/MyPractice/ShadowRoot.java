package MyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowRoot {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");

        driver.manage().window().maximize();
        SearchContext shadow = driver.findElement(By.cssSelector("div[id=\"shadow_host\"]")).getShadowRoot();
        Thread.sleep(1000);
        SearchContext shadow1 = shadow.findElement(By.cssSelector("div[id=\"nested_shadow_host\"]")).getShadowRoot();
        Thread.sleep(1000);
        String answer = shadow1.findElement(By.cssSelector("div")).getText();
        System.out.println(answer);
    }
}
