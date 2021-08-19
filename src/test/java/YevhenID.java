import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class YevhenID extends BaseTest {

    @Test
    public void test() throws InterruptedException {
        try {
            getDriver().get("https://google.com/");

            WebElement input = getDriver().findElement(By.name("Search Google or type a URL"));
            input.sendKeys("123\n");
            //!!! очень полезная фича поиска элемента
           /* WebDriverWait wait = new WebDriverWait(getDriver(), 20) {
            };
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated
                    (By.name("Search Google or type a URL")));*/
        } finally {

        }
    }
}
