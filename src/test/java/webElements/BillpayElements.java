package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BillpayElements {

    WebDriver driver;

    public BillpayElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement billPayTitle(){ return driver.findElement(By.xpath("//h1[contains(text(),'Bill Payment Service')]")); }

    public WebElement payeeName(){
        return driver.findElement(By.cssSelector("input[name='payee.name']"));
    }

    public WebElement address(){
        return driver.findElement(By.cssSelector("input[name='payee.address.street']"));
    }

    public WebElement city(){
        return driver.findElement(By.cssSelector("input[name='payee.address.city']"));
    }

    public WebElement state(){
        return driver.findElement(By.cssSelector("input[name='payee.address.state']"));
    }

    public WebElement zipCode(){
        return driver.findElement(By.cssSelector("input[name='payee.address.zipCode']"));
    }

    public WebElement phoneNumber(){
        return driver.findElement(By.cssSelector("input[name='payee.phoneNumber']"));
    }

    public WebElement accountNumber(){
        return driver.findElement(By.cssSelector("input[name='payee.accountNumber']"));
    }

    public WebElement verifyAccount(){
        return driver.findElement(By.cssSelector("input[name='verifyAccount']"));
    }

    public WebElement moneyAmount(){
        return driver.findElement(By.cssSelector("input[name='amount']"));
    }

    public WebElement fromAccount(){
        return driver.findElement(By.cssSelector("select[name='fromAccountId']"));
    }

    public WebElement paymentButton(){
        return driver.findElement(By.cssSelector("input[value='Send Payment']"));
    }

    public WebElement billPayCompleteMessage(){
        return driver.findElement(By.xpath("//h1[contains(text(),'Bill Payment Complete')]"));
    }

}
