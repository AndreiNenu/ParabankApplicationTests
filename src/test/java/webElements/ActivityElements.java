package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ActivityElements {

    private WebDriver driver;

    public ActivityElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement accountNumber(){
        return driver.findElement(By.cssSelector("td[id='accountId']"));
    }

    public WebElement accountType(){
        return driver.findElement(By.cssSelector("td[id='accountType']"));
    }

    public WebElement balance(){
        return driver.findElement(By.cssSelector("td[id='balance']"));
    }

    public WebElement availableBalance(){
        return driver.findElement(By.cssSelector("td[id='availableBalance']"));
    }

    public WebElement transactionTable(){
        return driver.findElement(By.xpath("//table[@id='transactionTable']"));
    }

    //return all transaction table headers
    public List<WebElement> allTableHeaders(){
        return driver.findElements(By.xpath("//table[@id='transactionTable']//th"));
    }

    //return all transaction lines
    public List<WebElement> allTransactions(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver.findElements(By.xpath("//table[@id='transactionTable']//tbody//td"));
    }
}
