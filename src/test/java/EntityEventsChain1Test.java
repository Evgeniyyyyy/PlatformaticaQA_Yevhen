import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ProjectUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EntityEventsChain1Test extends BaseTest {

    @Test
    public void testCreateNewRecord() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        By eventsChain2 = By.xpath("//p[contains(.,'Events Chain 1')]");
        By createNewFolder = By.xpath ("//i[text()='create_new_folder']");
        By existRecords = By.xpath("//table[@id='pa-all-entities-table']/tbody/tr");
        By existCells = By.xpath("//table[@id='pa-all-entities-table']/tbody/tr/td/a");
        By buttonSaveChain1 = By.xpath("//button[@id='pa-entity-form-save-btn']");
        String f1Value = "1";
        List<String> expectedValues = Arrays.asList("1", "2", "4", "8", "16", "32", "64", "128", "256", "512");


        ProjectUtils.get(getDriver());
        WebElement GetLoginButton = getDriver().findElement(By.xpath
                ("//input[@placeholder='Login name...']"));
        GetLoginButton.sendKeys("tester72@tester.test");
        WebElement GetPasswordButton = getDriver().findElement(By.xpath
                ("//input[@placeholder='Password...']"));
        GetPasswordButton.sendKeys("4oz8XDEZOT");
        WebElement GetSignInButton = getDriver().findElement(By.xpath
                ("//button[normalize-space()='Sign in']"));
        GetSignInButton.click();
        ProjectUtils.reset(getDriver());

        WebElement eventsChain1 = getDriver().findElement(eventsChain2);
        ProjectUtils.scrollClick(getDriver(), eventsChain1);

        WebElement ButtonNewChain = getDriver().findElement(createNewFolder);
        wait.until(ExpectedConditions.elementToBeClickable(ButtonNewChain)).click();

        WebElement AddNewChain = getDriver().findElement(By.xpath("//input[@id='f1']"));
        AddNewChain.sendKeys(f1Value);
        wait.until(ExpectedConditions.attributeToBeNotEmpty(getDriver().findElement(By.id("f10")),
                "value" ));
    
        WebElement ButtonSaveChain = getDriver().findElement(buttonSaveChain1);
        ProjectUtils.scrollClick(getDriver(), ButtonSaveChain);

        List<WebElement> records = getDriver().findElements(existRecords);

        List<String> actualValues = new ArrayList<>();
        List<WebElement> cells = getDriver().findElements(existCells);
        for (WebElement cell: cells){
             actualValues.add(cell.getText());
        }
        WebElement checkBox = getDriver().findElement(By.xpath("//i[@class='fa fa-check-square-o']"));
        Assert.assertEquals(records.size(), 1);
        Assert.assertEquals(actualValues, expectedValues);
        Assert.assertTrue(checkBox.isDisplayed());


    }
}
