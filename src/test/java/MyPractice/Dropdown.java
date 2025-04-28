package MyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Dropdown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();


        // Select Drop down
        WebElement drpcountryele  = driver.findElement(By.xpath("//select[@id=\"country\"]"));
        Select drpcountry = new Select(drpcountryele);
        drpcountry.selectByVisibleText("France");


        // TO select multiple drop down stuff

        List<WebElement> options = driver.findElements(By.xpath("//select[@id=\"colors\"]//option"));
        for(WebElement op:options){
            String option = op.getText();
            if(option.equals("Blue") || option.equals("Red") || option.equals("Green")){
                op.click();
            }
        }
    }
}
