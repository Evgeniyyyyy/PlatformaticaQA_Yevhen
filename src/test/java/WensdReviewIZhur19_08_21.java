import base.BaseTestOld;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WensdReviewIZhur19_08_21 extends BaseTestOld {
    // Thread.sleep();
    //Implicit - неявный
    //Explicit - явный
    //Fluent
    @Test
    public void testReviewTestIZhur() {
        getDriver().get("https://www.gismeteo.ua/ua/weather-poltava-4957/");
        WebElement threeDaysButton = getDriver().findElement(By.xpath
                ("//a[@href=\"/ua/weather-poltava-4957/3-days/\"]"));
        threeDaysButton.click();
        WebElement threeDaysTitle = getDriver().findElement(By.xpath
                ("//div[@class='pageinfo_title index-h1']//h1"));
        /*WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.textToBePresentInElement(By.xpath("Bla bla")));*/
                Assert.assertEquals(threeDaysTitle, "Погода у Полтаві на 3 дні");

    }
}
