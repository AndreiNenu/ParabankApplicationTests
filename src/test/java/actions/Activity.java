package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webElements.ActivityElements;

import java.time.Duration;
import java.util.List;

public class Activity {

    private ActivityElements elements;
    private Wait<WebDriver> wait;
    public static List<WebElement> allHeaders;
    public static List<WebElement> allTransactions;

    public Activity(WebDriver driver){
        elements = new ActivityElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public List<WebElement> getAllTableHeaders(){
        wait.until(d-> elements.transactionTable().isDisplayed());
        allHeaders = elements.allTableHeaders();
        return allHeaders;
    }

    public List<WebElement> getAllTransactions(){
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transactionTable")));
        allTransactions = elements.allTransactions();
        return allTransactions;
    }

}
