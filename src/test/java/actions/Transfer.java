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

    public String getTransferFundsTitle(){
        wait.until(d -> elements.transferFundsTitle().isDisplayed());
        return elements.transferFundsTitle().getText();
    }

    public void enterTransferAmount(String amount) {
        wait.until(d -> elements.transferAmount().isDisplayed());
        elements.transferAmount().sendKeys(amount);
    }

    public void selectValueFromAccount(String value) {
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

    public void selectValueToAccount(String value) {
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

    public String getFromAccountText(){
        wait.until(d -> elements.fromAccountText().isDisplayed());
        return elements.fromAccountText().getText();
    }

    public String getToAccountText(){
        wait.until(d -> elements.toAccountText().isDisplayed());
        return elements.toAccountText().getText();
    }

    public String[] getTransferFundsPageInfo() {
        wait.until(d -> elements.transferFundsTitle().isDisplayed());
        String[] array = new String[4];

        array[0] = getTransferFundsTitle();
        array[1] = elements.transferAmount().getText();
        array[2] = getFromAccountText();
        array[3] = getToAccountText();

        return array;
    }

}

