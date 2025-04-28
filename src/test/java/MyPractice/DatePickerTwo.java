package MyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DatePickerTwo {
    static void SelectByTareek(WebDriver driver, String year, String month, String date){
        driver.findElement(By.id("datepicker")).click();
        // This will select Month and year
        while(true){
            String CurrentYear = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]")).getText();
            String CurrentMonth = driver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]")).getText();

            if(CurrentYear.equals(year) && CurrentMonth.equals(month)){
                break;
            }

            if(year.compareTo(CurrentYear)>0) driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-e\"]")).click();// to click forward
            else driver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-w\"]")).click();
        }

        // Now we will selct date
        List<WebElement> dates = driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody/tr//td//a"));
        int d =0;
        for(WebElement dt:dates){
            d++;
            if(dt.getText().equals(date)){
                driver.findElement(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody/tr//td//a[@data-date="+d+"]")).click();
                System.out.println("Hello this is outr desired date: "+d);
                break;
            }
        }
    }
    static void SelectByDropDownDate(WebDriver driver, String year ,String month, String date) throws InterruptedException {
        driver.findElement(By.id("txtDate")).click();
        // Select month and year by dropdwon
        WebElement currentmonth = driver.findElement(By.xpath("//select[@class=\"ui-datepicker-month\"]"));
        Select mon = new Select(currentmonth);
        mon.selectByVisibleText(month);

        WebElement currentyear = driver.findElement(By.xpath("//select[@class=\"ui-datepicker-year\"]"));
        Select ye = new Select(currentyear);
        ye.selectByVisibleText(year);


        WebDriverWait newwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        newwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody/tr//td//a")));

        // Select Date
        List<WebElement> dat = driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody/tr//td//a"));
        int dq =0;
        for(WebElement dt:dat){
            dq++;
            if(dt.getText().equals(date)){
                driver.findElement(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody/tr//td//a[@data-date="+dq+"]")).click();
                System.out.println("Hello this is our desired date for Calendar 2: "+dq);
                break;
            }
        }
    }
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");

        // test data
        String requiredDate = "4";
        String requiredyear= "2023";
        String requiredMonth = "May";

        //SelectByTareek(driver,requiredyear,requiredMonth,requiredDate);
        try{
            SelectByDropDownDate(driver,requiredyear,requiredMonth,requiredDate);
        } catch (Exception e){
            System.out.println("we got following error: "+e);
        }
    }
}
