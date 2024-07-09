package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webElements.FindTransElements;

import java.time.Duration;

public class FindTrans {

    private FindTransElements elements;
    private Wait<WebDriver> wait;

    public FindTrans(WebDriver driver){
        elements = new FindTransElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getFindTransactionTitle(){
        wait.until(d-> elements.findTransactionTitle().isDisplayed());
        return elements.findTransactionTitle().getText();
    }

}
