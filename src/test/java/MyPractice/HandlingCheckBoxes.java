package MyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandlingCheckBoxes {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class=\"form-check-input\" and @type = \"checkbox\"]"));

//        for(WebElement checkbox : checkboxes){
//            checkbox.click();
//        }

        for(int i =4;i<checkboxes.size();i++){
            checkboxes.get(i).click();
        }

        for(int i =0;i< checkboxes.size();i++){
            if(checkboxes.get(i).isSelected()){
                checkboxes.get(i).click();
            }
        }

    }
}
