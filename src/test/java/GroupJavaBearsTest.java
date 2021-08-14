import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GroupJavaBearsTest {
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }

    private WebDriver driver;

    @BeforeMethod
    public void beforeTest() {
        driver = new ChromeDriver();
    }

    @Test
    public void reviewTest() throws InterruptedException {
        driver.get("https://shop.demoqa.com/my-account/");
        Thread.sleep(2000);
        driver.findElement(By.linkText("Lost your password?")).click();
        Thread.sleep(2000);
        driver.navigate().to("https://shop.demoqa.com/my-account/");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();


    }
    public static void newClick (WebDriver driver, WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    @Test
    public void Test2() throws InterruptedException {
        driver.get("https://demoqa.com/automation-practice-form");
       /* driver.findElement(By.id("firstName")).sendKeys("John");
        Thread.sleep(2000);
        driver.findElement(By.id("lastName")).sendKeys("Parker");
        Thread.sleep(2000);
        driver.findElement(By.id("lastName")).clear();
        Thread.sleep(2000);
        driver.findElement(By.id("lastName")).sendKeys("Brown");
        Thread.sleep(2000);

        // Second way(51-58 lines)
        WebElement textName = driver.findElement(By.id("lastName"));
        Thread.sleep(2000);*/
        //textName.sendKeys("BrowN");
        // Thread.sleep(2000);
      //  driver.findElement(By.xpath("//input[@name='gender'][@value='Male']")).click();

        //Collection with Test
        List<WebElement> gender = driver.findElements(By.id("//input[@type='radio']"));
        gender.size();
        for (int i = 0; i < gender.size(); i++) {
            String value = gender.get(i).getAttribute("value");
            if (value.equalsIgnoreCase("male")){
             //   gender.get(i).click();
                newClick(driver, gender.get(i));
                break;
            }
            Thread.sleep(5000);
        }

    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }

}
