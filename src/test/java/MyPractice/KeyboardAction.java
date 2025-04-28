package MyPractice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class KeyboardAction {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Actions myACT = new Actions(driver);

        driver.get("https://text-compare.com/");
        driver.findElement(By.xpath("//textarea[@id=\"inputText1\"]")).sendKeys("Hello world");

        // Ctrl+ A to select the text
        myACT.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).perform();
        // Ctrl + C
        myACT.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).perform();
        // TAb to shift to another text box
        myACT.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
        // Ctrl +V
        myACT.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

        // Use this to switch to new blank tab in same window
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://demo.nopcommerce.com/");
        WebElement reglink = driver.findElement(By.xpath("//a[@class=\"ico-register\"]"));

        // Now lets click on register with control button
        myACT.keyDown(Keys.CONTROL).click(reglink).keyUp(Keys.CONTROL).perform();
        Thread.sleep(3000);


        // Switching to registration page
        List<String> Ids = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(Ids.get(2));


    }
}
