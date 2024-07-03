package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webElements.TransferElements;

import java.time.Duration;

public class Transfer {

    private TransferElements elements;
    private Select select;
    private Wait<WebDriver> wait;

    public Transfer(WebDriver driver) {
        elements = new TransferElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void enterTransferAmount(String amount) {
        wait.until(d -> elements.transferAmount().isDisplayed());
        elements.transferAmount().sendKeys(amount);
    }

    public void selectIndexFromAccount(String value) {
        wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver driver)
            {
                select = new Select(elements.fromAccount());
                return select.getOptions().size()>1;
            }
        });
        select = new Select(elements.fromAccount());
        select.selectByValue(value);
    }

    public void selectIndexToAccount(String value) {
        wait.until((ExpectedCondition<Boolean>) new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver driver)
            {
                select = new Select(elements.toAccount());
                return select.getOptions().size()>1;
            }
        });
        select = new Select(elements.toAccount());
        select.selectByValue(value);
    }

    public void clickTransferButton() {
        elements.transferButton().click();
    }

    public String getTransferCompleteText() {
        wait.until(d -> elements.transferCompleteMessage().isDisplayed());
        return elements.transferCompleteMessage().getText();
    }

}

