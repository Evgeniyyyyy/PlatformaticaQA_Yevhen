import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class YevhenID {
    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
    }


    @Test
    public void test() throws InterruptedException {
        //    System.setProperty("webdriver.chrome.driver", "C:/Users/ybozhenko/Downloads/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://google.com/");
            //   Thread.sleep(1000);

            WebElement input = driver.findElement(By.name("Search Google or type a URL"));
            input.sendKeys("123\n");
        } finally {

            driver.quit();
        }
    }
}
