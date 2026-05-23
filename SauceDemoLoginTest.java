package againnnn;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SauceDemoLoginTest {

    WebDriver driver;

    @BeforeTest
    void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
        driver.get("https://www.saucedemo.com/");
        System.out.println("Website Open");
    }

    @Test
    void Testing() throws EncryptedDocumentException, IOException, InterruptedException {

        FileInputStream excel = new FileInputStream
        ("C:\\Users\\praju\\OneDrive\\Desktop\\xyz.xlsx");

        Sheet a = WorkbookFactory.create(excel).getSheet("Sheet1");

        for(int i = 1; i <= 4; i++) {
            Row row = a.getRow(i);
            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();
            String expected = row.getCell(2).getStringCellValue();

            driver.findElement(By.id("user-name")).clear();
            driver.findElement(By.id("user-name")).sendKeys(username);
            driver.findElement(By.id("password")).clear();
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.id("login-button")).click();

            Thread.sleep(3000);

            if(expected.equals("Pass")) {
                System.out.println(username + "PASSED");
                driver.navigate().back();
                Thread.sleep(2000);
            } else {
                System.out.println(username + "FAILED as expected");
                Thread.sleep(2000);
            }
        }
    }

    @AfterClass
    void teardown() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Website Close");
        driver.quit();
    }
}