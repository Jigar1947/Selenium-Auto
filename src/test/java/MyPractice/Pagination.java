package MyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Pagination {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://testautomationpractice.blogspot.com/");

        /*
        Pagination requirs three important steps
        1) Find total number of pages
        2) Click on all pages
        3) Read all the data from the pages
        */

        // STEP-1 FINDING NUMBER OF PAGES
        List<WebElement> pages = driver.findElements(By.xpath("//ul[@class=\"pagination\"]//li"));

        for(int p =1;p<= pages.size();p++){
            // Clicking on all pages
            if(p>1){
                WebElement activePage = driver.findElement(By.xpath("//ul[@class=\"pagination\"]//*[text()=\"1\"]"));
                activePage.click();
                Thread.sleep(3000);
            }

            // STEP - 3 reading all data
            // We need to identify number of rows also
            int noofRows = driver.findElements(By.xpath("//table[@id=\"productTable\"]//tbody//tr")).size();
            for(int r =1;r<noofRows;r++){
                String Name = driver.findElement(By.xpath("//table[@id=\"productTable\"]//tbody//tr["+r+"]//td[2]")).getText();
                String Price = driver.findElement(By.xpath("//table[@id=\"productTable\"]//tbody//tr["+r+"]//td[3]")).getText();
                System.out.println(Name +"\t"+Price);


            }

        }



    }
}
