package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransferElements {

    WebDriver driver;

    public TransferElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement transferAmount(){
        return driver.findElement(By.cssSelector("input[id='amount']"));
    }

    public WebElement fromAccount(){

        return driver.findElement(By.cssSelector("select[id='fromAccountId']"));
    }

    public WebElement toAccount(){
        return driver.findElement(By.cssSelector("select[id='toAccountId']"));
    }

    public WebElement transferButton(){
        return driver.findElement(By.cssSelector("input[class='button']"));
    }

    public WebElement transferCompleteMessage(){
        return driver.findElement(By.xpath("//h1[contains(text(),'Transfer Complete!')]"));
    }

}
