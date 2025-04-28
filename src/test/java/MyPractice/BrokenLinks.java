package MyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args)  {
        // Headless Exceuction
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.deadlinkcity.com/");

        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links is "+links.size());
        int noOfBrokenLinks=0;
        for(WebElement linkelements : links){
            String hrefatValue = linkelements.getAttribute("href");
            if(hrefatValue ==null || hrefatValue.isEmpty()){
                System.out.println("Href value is empty so cannot be checked");
                continue;
            }
            // now we need to get status code
            try{
                URL linkurl = new URL(hrefatValue); // Converts string value to url
                HttpURLConnection conn = (HttpURLConnection) linkurl.openConnection();
                conn.connect(); // Connects to server and Send requests to server
                if(conn.getResponseCode()>=400){
                    System.out.println(hrefatValue+"This link is Broken");
                    noOfBrokenLinks++;
                }
                else{
                    System.out.println(hrefatValue + "This LINK is NOT BROKEN");
                }
            }catch (Exception e){
            }
        }
        System.out.println("TOtal number of Broken Links are: "+noOfBrokenLinks);
    }
}
