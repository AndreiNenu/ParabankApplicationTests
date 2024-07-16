package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webElements.RequestLoanElements;

import java.time.Duration;

public class RequestLoan {

    private RequestLoanElements elements;
    private Wait<WebDriver> wait;

    public RequestLoan(WebDriver driver){
        elements = new RequestLoanElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getRequestLoanTitle(){
        wait.until(d-> elements.requestLoanTitle().isDisplayed());
        return elements.requestLoanTitle().getText();
    }

}
