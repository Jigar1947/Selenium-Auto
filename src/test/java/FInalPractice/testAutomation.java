package FInalPractice;

import org.apache.poi.ss.usermodel.Row;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.*;

public class testAutomation {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        // Explicit Wait Declaration
        WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));

//        // Alright First we will start with TextBox, Check BOX and Radio Button
//        driver.findElement(By.id("email")).sendKeys("jigar212@gmail.com"); // Handling Text Box
//        driver.findElement(By.id("male")).click(); // Handling Radio Button
//        driver.findElement(By.id("sunday")).click(); // Handling check boxes
//
//        // Handling Drop-Downs
//        // Select Drop down
//        WebElement dropdownobj = driver.findElement(By.id("country")); // Step-1 Click on drop down
//        Select drp = new Select(dropdownobj); // Make it a select object is step-2
//        drp.selectByVisibleText("Japan"); // There are 2 other methods also like select by value and select by index
//
//        // Auto-suggest drop down
        driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Hello");
        String oldwindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//input[@class=\"wikipedia-search-button\"]")).click();

        //Using Explicit Wait
        mywait.until(ExpectedConditions.visibilityOfElementLocated(By.id("wikipedia-search-result-link")));
        List<WebElement> op = driver.findElements(By.xpath("//a[contains(text(), \"Hello\")]"));
        for(WebElement a:op){
            System.out.println(a.getText());
            if(a.getText().equals("Hello Kitty")){
                a.click();
                Thread.sleep(3000);
                break;
            }
        }
        Thread.sleep(3000);
        Set<String> newIDS = driver.getWindowHandles();
        ArrayList<String> knw = new ArrayList<>(newIDS);
        String child = knw.get(1);
        driver.switchTo().window(child);
        String s = driver.getCurrentUrl();
        System.out.println("We are on this page: "+s);
        driver.close();
        driver.switchTo().window(oldwindow);

//        // Dynamic Button
//        driver.findElement(By.xpath("//button[@onclick=\"toggleButton(this)\"]")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//button[@onclick=\"toggleButton(this)\"]")).click();
//
//        // Alert And POpups
//        // Simple Alert
//        driver.findElement(By.id("alertBtn")).click();
//        Thread.sleep(3000);
//        driver.switchTo().alert().accept();
//
//        // Confirmation alert
//        driver.findElement(By.id("confirmBtn")).click();
//        Thread.sleep(3000);
//        driver.switchTo().alert().accept(); // or could also dismiss
//
//        // Prompt Alert
//        driver.findElement(By.id("promptBtn")).click();
//        Thread.sleep(4000);
//        Alert myalert = driver.switchTo().alert();
//        myalert.sendKeys("Hello World");// To type message in alert
//        myalert.accept();
//
//        // New Tab Handling
//        driver.findElement(By.xpath("//button[@onclick=\"myFunction()\"]")).click();
//        String UrlOfTab1 = driver.getCurrentUrl();
//        System.out.println(UrlOfTab1);
//        Set<String> urls = driver.getWindowHandles();
//        List<String> urlList = new ArrayList<>(urls);
//        String childId = urlList.get(1);
//        String ParentId = urlList.get(0);
//        driver.switchTo().window(childId);
//        System.out.println(driver.getCurrentUrl());
//        driver.close();
//        driver.switchTo().window(ParentId);
//        Thread.sleep(5000);
//        System.out.println(driver.getCurrentUrl());
//
//        // Static Web Tables
//        // we will follow 2 simple steps just get information of rows and columns
//        // 1) Find total number of rows and columns in table
//        // 2) Read data from rows and columns
//        List<WebElement> we = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tbody//tr"));
//        List<WebElement> ce = driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tbody//th"));
//        int colNum = ce.size();
//        int rowNum = we.size();
//        System.out.println("Books Written By Mukesh are as Follows: ");
//        for(int r =2;r<=rowNum;r++){ // leaving header behind
//            String authorName = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tbody//tr["+r+"]//td[2]")).getText();
//            if(authorName.equals("Mukesh")){
//                String bookname = driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tbody//tr["+r+"]//td[1]")).getText();
//                System.out.print(bookname+" ");
//            }
//        }
//
//        // DYNAMIC WEB TABLE
//        List<WebElement> de = driver.findElements(By.xpath("//table[@id=\"taskTable\"]//tbody//tr"));
//        int Rows = de.size();
//        ////table[@id="taskTable"]//thead//tr//th
//        System.out.println();
//        // We wil just print browser name and their network speed
//        HashMap<String,String> hm = new HashMap<>();
//        for(int r =1;r<=Rows;r++){
//            String BrowserName = driver.findElement(By.xpath("//table[@id=\"taskTable\"]//tbody//tr["+r+"]//td[1]")).getText();
//            String NetworkSpeed = driver.findElement(By.xpath("//table[@id=\"taskTable\"]//tbody//tr["+r+"]//td[4]")).getText();
//            hm.put(BrowserName,NetworkSpeed);
//        }
//        System.out.println("Browser Name"+"\t"+"Network Speed");
//        // Getting a set of entries
//        Set<Map.Entry<String,String>> myset1 = hm.entrySet();
//         // Displaying our set
//        for(Map.Entry<String,String> as:myset1){
//            System.out.print(as.getKey()+": ");
//            System.out.println(as.getValue());
//        }

        // Pagination Web Table
        // Same as static table just get number of pages then click on all pages and read

        List<WebElement> pg = driver.findElements(By.xpath("//ul[@id=\"pagination\"]//li"));
        List<WebElement> rowP = driver.findElements(By.xpath("//table[@id=\"productTable\"]//tbody//tr"));
        int rowp = rowP.size();
        List<String> items = new ArrayList<>();
        items.add("Television");
        items.add("Router");
        items.add("Soundbar");
        double totalPrice = 0.00;
        for(WebElement p:pg){
            p.click();
            for(int r=1;r<=rowp;r++){
                String Currentitem = driver.findElement(By.xpath("//table[@id=\"productTable\"]//tbody//tr["+r+"]//td[2]")).getText();
                if(items.contains(Currentitem)){
                    String price = driver.findElement(By.xpath("//table[@id=\"productTable\"]//tbody//tr["+r+"]//td[3]")).getText();
                    String pri = price.substring(1);
                    totalPrice += Double.parseDouble(pri);
                    driver.findElement(By.xpath("//table[@id=\"productTable\"]//tbody//tr["+r+"]//td[4]//input")).click();
                }
            }
        }

        System.out.println("Total Price of our Cart is : "+totalPrice);

        // Date Picker
















    }
}
