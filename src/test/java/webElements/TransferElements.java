package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferElements {

    WebDriver driver;

    public TransferElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement transferFundsTitle(){ return driver.findElement(By.xpath("//h1[contains(text(),'Transfer Funds')]")); }

    public WebElement transferAmount(){
        return driver.findElement(By.cssSelector("input[id='amount']"));
    }

    public WebElement fromAccount(){ return driver.findElement(By.cssSelector("select[id='fromAccountId']")); }

    public WebElement toAccount(){
        return driver.findElement(By.cssSelector("select[id='toAccountId']"));
    }

    public WebElement transferButton(){
        return driver.findElement(By.cssSelector("input[class='button']"));
    }

    public WebElement transferCompleteMessage(){
        return driver.findElement(By.xpath("//h1[contains(text(),'Transfer Complete!')]"));
    }

    public WebElement fromAccountText(){ return driver.findElement(By.cssSelector("#fromAccountId > option:nth-child(1)")); }

    public WebElement toAccountText(){ return driver.findElement(By.cssSelector("#toAccountId > option:nth-child(1)")); }

}
