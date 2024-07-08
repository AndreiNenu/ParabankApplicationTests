package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webElements.OverviewElements;

import java.time.Duration;

public class Overview {

    private OverviewElements elements;
    private Wait<WebDriver> wait;

    public Overview(WebDriver driver){
        elements = new OverviewElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getWelcomeMessageText(){
        wait.until(d-> elements.welcomeMessage().isDisplayed());
        return elements.welcomeMessage().getText();
    }

    public void clickDefaultAccount(){
        wait.until(d-> elements.defaultAccount().isDisplayed());
        elements.defaultAccount().click();
    }

    public String getAccountOverviewTitle(){
        wait.until(d-> elements.accountOverviewTitle().isDisplayed());
        return elements.accountOverviewTitle().getText();
    }

    public String getDefaultAccountNumber(){
        wait.until(d-> elements.defaultAccount().isDisplayed());
        return elements.defaultAccount().getText();
    }

    public String[] getAccountOverviewPageInfo() {
        wait.until(d -> elements.accountOverviewTitle().isDisplayed());
        String[] array = new String[2];
        array[0] = getAccountOverviewTitle();
        array[1] = getDefaultAccountNumber();

        return array;
    }

    //temporary method from Find Transaction page
    public String getFindTransactionTitle(){
        wait.until(d-> elements.findTransactionTitle().isDisplayed());
        return elements.findTransactionTitle().getText();
    }

    //temporary method from Request Loan page
    public String getRequestLoanTitle(){
        wait.until(d-> elements.requestLoanTitle().isDisplayed());
        return elements.requestLoanTitle().getText();
    }


    //Main Menu Action Links
    public void clickOpenNewAccountLink(){
        wait.until(d-> elements.openNewAccountLink().isDisplayed());
        elements.openNewAccountLink().click();
    }

    public void clickAccountOverview(){
        wait.until(d-> elements.accountOverview().isDisplayed());
        elements.accountOverview().click();
    }

    public void clickTransferFundsLink(){
        wait.until(d-> elements.transferFundsLink().isDisplayed());
        elements.transferFundsLink().click();
    }

    public void clickBillPayLink(){
        wait.until(d-> elements.billPayLink().isDisplayed());
        elements.billPayLink().click();
    }

    public void clickFindTransactionsLink(){
        wait.until(d-> elements.findTransactionsLink().isDisplayed());
        elements.findTransactionsLink().click();
    }

    public void clickUpdateContactInfoLink(){
        wait.until(d-> elements.updateContactInfoLink().isDisplayed());
        elements.updateContactInfoLink().click();
    }

    public void clickRequestLoanLink(){
        wait.until(d-> elements.requestLoanLink().isDisplayed());
        elements.requestLoanLink().click();
    }

    public void clickLogoutButton(){
        wait.until(d-> elements.logoutButton().isDisplayed());
        elements.logoutButton().click();
    }

}
