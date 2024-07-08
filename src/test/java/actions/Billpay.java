package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webElements.BillpayElements;

import java.time.Duration;

public class Billpay {

    private BillpayElements elements;
    private Wait<WebDriver> wait;
    private Select select;

    public Billpay(WebDriver driver){
        elements = new BillpayElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getBillPayTitle(){
        wait.until(d-> elements.billPayTitle().isDisplayed());
        return elements.billPayTitle().getText();
    }

    public void setPayeeName(String payeeName){
        elements.payeeName().sendKeys(payeeName);
    }

    public void setAddress(String address){
        elements.address().sendKeys(address);
    }

    public void setCity(String city){
        elements.city().sendKeys(city);
    }

    public void setState(String state){
        elements.state().sendKeys(state);
    }

    public void setZipCode(String zipCode){
        elements.zipCode().sendKeys(zipCode);
    }

    public void setPhoneNumber(String phoneNumber){
        elements.phoneNumber().sendKeys(phoneNumber);
    }

    public void enterAccountNumber(String account){
        elements.accountNumber().sendKeys(account);
    }

    public void verifyAccountNumber(String account){
        elements.verifyAccount().sendKeys(account);
    }

    public void enterMoneyAmount(String moneyAmount){
        elements.moneyAmount().sendKeys(moneyAmount);
    }

    public void selectFromAccount(String value) {
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

    public void clickPaymentButton(){
        elements.paymentButton().click();
    }

    public String getBillPayCompleteText() {
        wait.until(d -> elements.billPayCompleteMessage().isDisplayed());
        return elements.billPayCompleteMessage().getText();
    }
}
