package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class OpenAccountElements {

    private WebDriver driver;

    public OpenAccountElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement typeOfAccountDropdown(){
        return driver.findElement(By.cssSelector("select[id='type']"));
    }

    public WebElement fromAccountDropdown(){
        return driver.findElement(By.cssSelector("select[id='fromAccountId']"));
    }

    public WebElement openNewAccountButton(){
        return driver.findElement(By.cssSelector("input[value='Open New Account']"));
    }

    public WebElement openAccountCompleteMessage(){
        return driver.findElement(By.xpath("//h1[contains(text(),'Account Opened!')]"));
    }

    public WebElement openAccountPageTitle(){
        return driver.findElement(By.xpath("//h1[contains(text(),'Open New Account')]"));
    }

    public WebElement accountTypeChecking(){
        return driver.findElement(By.cssSelector("#type > option:nth-child(1)"));
    }

    public WebElement fromAccountDefault(){
        return driver.findElement(By.cssSelector("#fromAccountId > option:nth-child(1)"));
    }

}
