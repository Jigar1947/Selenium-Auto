package MyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DatePicker {

    static void selectPastDate(WebDriver driver, String year , String month,String date){
        driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).click();
        while (true){
            String currentyear = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText();
            String currentMonth = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText();

            if(currentyear.equals(year) && currentMonth.equals(month)){
                break;
            }

            driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-w\"]")).click(); // Clicking previous button
        }

        //now lets get the date
        List<WebElement> dates = driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody//tr//td//a"));
        for(WebElement dt :dates){
            if(dt.getText().equals(date)){
                dt.click();
                break;
            }
        }

    }
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryui.com/datepicker/");
        driver.switchTo().frame(0);

        // Method 1 by sending keys
        //driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).sendKeys("04/05/2025");

        // Method 2 by using Datepicker
        // Expected data
        String month = "August";
        String date = "24";
        String year = "2023";

        // Now we just need to call our method
        selectPastDate(driver,year,month,date);
    }
}
