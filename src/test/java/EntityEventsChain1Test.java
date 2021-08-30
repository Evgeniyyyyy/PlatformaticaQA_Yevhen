import base.BaseTest;
import base.LoginUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ProjectUtils;

public class EntityEventsChain1Test extends BaseTest {

    @Test
    public void test() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(getDriver(), 20);
        getDriver().get("https://ref2.eteam.work/");
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

        getDriver().get("https://ref2.eteam.work/index.php?action=action_list&entity_id=61&mod=2");
        Thread.sleep(3000);
        WebElement ButtonNewChain = getDriver().findElement(By.xpath
                ("//i[text()='create_new_folder']"));
        wait.until(ExpectedConditions.elementToBeClickable(ButtonNewChain)).click();

        WebElement AddNewChain = getDriver().findElement(By.xpath("//input[@id='f1']"));
        AddNewChain.sendKeys("1");
    
        WebElement ButtonSaveChain = getDriver().findElement(By.xpath
                ("//button[@id='pa-entity-form-save-btn']"));
        ProjectUtils.scrollClick(getDriver(), ButtonSaveChain);

    }
}
