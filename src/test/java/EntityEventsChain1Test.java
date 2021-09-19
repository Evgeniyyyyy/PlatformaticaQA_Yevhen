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
    WebDriverWait wait = new WebDriverWait(getDriver(), 20);
    private static final By EVENTS_CHAIN1_MENU = By.xpath("//p[contains(.,'Events Chain 1')]");
    private static final By CREATE_NEW_FOLDER = By.xpath ("//i[text()='create_new_folder']");
    private static final By EXIST_RECORDS = By.xpath("//table[@id='pa-all-entities-table']/tbody/tr");
    private static final By EXIST_CELLS = By.xpath("//table[@id='pa-all-entities-table']/tbody/tr/td/a");
    private static final By BUTTON_SAVE_CHAIN_1 = By.xpath("//button[@id='pa-entity-form-save-btn']");
    private static final By CHECK_BOX = By.xpath("//i[@class='fa fa-check-square-o']");
    private static final By F_1_FIELD = By.xpath("//input[@id='f1']");
    private static final By F_10_FIELD = By.id("f10");

    private void clickMenu(){
        ProjectUtils.scrollClick(getDriver(), getDriver().findElement(EVENTS_CHAIN1_MENU));
        wait.until(ExpectedConditions.elementToBeClickable(getDriver().findElement(CREATE_NEW_FOLDER)));
    }
    private void clickCreateNewFolder(){
        getDriver().findElement(CREATE_NEW_FOLDER).click();
    }
    private void clickSaveButton(){
        getDriver().findElement(BUTTON_SAVE_CHAIN_1).click();
    }
    private void inputF1Value(String f1Value){
        getDriver().findElement(F_1_FIELD)
                .sendKeys(f1Value);
        wait.until(ExpectedConditions.attributeToBeNotEmpty(getDriver().findElement(F_10_FIELD), "value"));

    }
    private List<WebElement> getRecords(){
        return getDriver().findElements(EXIST_RECORDS);
    }
    
    private List<WebElement> getCells(){
        return getDriver().findElements(EXIST_CELLS);
    }

    private List<String> getRowValues(List<WebElement> cellsActual) {
        List<String> actualValues = new ArrayList<>();
             for (WebElement cell : cellsActual) {
            actualValues.add(cell.getText());
        }
        return actualValues;
    }


    @Test
    public void testCreateNewRecord() {
        final String f1Value = "1";
        final List<String> expectedValues = Arrays.asList("1", "2", "4", "8", "16", "32", "64", "128", "256", "512");



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

        WebElement eventsChain1 = getDriver().findElement(EVENTS_CHAIN1_MENU);
        ProjectUtils.scrollClick(getDriver(), eventsChain1);

        WebElement ButtonNewChain = getDriver().findElement(CREATE_NEW_FOLDER);
        wait.until(ExpectedConditions.elementToBeClickable(ButtonNewChain)).click();

        WebElement AddNewChain = getDriver().findElement(F_1_FIELD);
        AddNewChain.sendKeys(f1Value);
        wait.until(ExpectedConditions.attributeToBeNotEmpty(getDriver().findElement(F_10_FIELD),
                "value" ));
    
        WebElement ButtonSaveChain = getDriver().findElement(BUTTON_SAVE_CHAIN_1);
        ProjectUtils.scrollClick(getDriver(), ButtonSaveChain);

        List<WebElement> records = getDriver().findElements(EXIST_RECORDS);
        List<WebElement> cellsActual = getDriver().findElements(EXIST_CELLS);





        Assert.assertEquals(records.size(), 1);
        Assert.assertEquals(getRowValues(cellsActual), expectedValues);
        Assert.assertTrue(getDriver().findElement(CHECK_BOX).isDisplayed());




    }
}
