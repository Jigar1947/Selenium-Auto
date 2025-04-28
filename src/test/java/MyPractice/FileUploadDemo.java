package MyPractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadDemo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
        driver.findElement(By.xpath("//input[@name=\"filesToUpload\"]")).sendKeys("C:\\Users\\jigar-sharma\\OneDrive - MMC\\Desktop\\Excel Files\\ResponseDemo.csv");
        WebElement FileTExt = driver.findElement(By.xpath("//ul[@id=\"fileList\"]"));
        if(FileTExt.getText().equals("ResponseDemo.csv")){
            System.out.println("Correct file Uploaded");
        }
        else{
            System.out.println("Wrong File Uploaded");
        }
    }
}
