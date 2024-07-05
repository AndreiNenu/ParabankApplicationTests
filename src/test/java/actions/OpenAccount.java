package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webElements.OpenAccountElements;

import java.time.Duration;

public class OpenAccount {

    private OpenAccountElements elements;
    private Select select;
    private Wait<WebDriver> wait;

    public OpenAccount(WebDriver driver){
        elements = new OpenAccountElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void clickOpenNewAccountButton(){
        elements.openNewAccountButton().click();
    }

    public void selectTypeOfAccount(String value){
        wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver driver)
            {
                select = new Select(elements.typeOfAccountDropdown());
                return select.getOptions().size()>1;
            }
        });
        select = new Select(elements.typeOfAccountDropdown());
        select.selectByValue(value);
    }

    public void selectFromAccount(String value){
        wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver driver)
            {
                select = new Select(elements.fromAccountDropdown());
                return select.getOptions().size()>1;
            }
        });
        select = new Select(elements.fromAccountDropdown());
        select.selectByValue(value);
    }

    public String getOpenAccountCompleteText() {
        wait.until(d -> elements.openAccountCompleteMessage().isDisplayed());
        return elements.openAccountCompleteMessage().getText();
    }

    public String[] getOpenAccountPageInfo() {
        wait.until(d -> elements.openAccountCompleteMessage().isDisplayed());
        String[] array = new String[3];
        array[0] = elements.openAccountPageTitle().getText();
        array[1] = elements.typeOfAccountDropdown().getText();
        array[2] = elements.fromAccountDropdown().getText();

        return array;
    }


}
