package MyPractice;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class HandleAlert {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//        driver.findElement(By.xpath("//button[@onclick=\"jsAlert()\"]")).click();
//        Thread.sleep(5000);
//
//        Alert myalert  = driver.switchTo().alert();
//        System.out.println(myalert.getText());
//        myalert.accept();

        // Now lets use confirmatio alert
        driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();
        Thread.sleep(5000);
        Alert myalert = driver.switchTo().alert();
        System.out.println(myalert.getText());
        myalert.accept();
        //driver.switchTo().alert().dismiss();
    }
}
