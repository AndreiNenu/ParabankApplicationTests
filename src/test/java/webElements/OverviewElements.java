package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewElements {

    private WebDriver driver;

    public OverviewElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement welcomeMessage(){
        return driver.findElement(By.cssSelector("p[class='smallText']"));
    }

    public WebElement logoutButton(){
        return driver.findElement(By.cssSelector("a[href='logout.htm']"));
    }

    public WebElement transferFundsLink(){
        return driver.findElement(By.cssSelector("a[href='transfer.htm']"));
    }

    public WebElement billPayLink(){
        return driver.findElement(By.cssSelector("a[href='billpay.htm']"));
    }

    public WebElement openNewAccountLink(){
        return driver.findElement(By.cssSelector("a[href='openaccount.htm']"));
    }

    public WebElement updateContactInfoLink(){
        return driver.findElement(By.cssSelector("a[href='updateprofile.htm']"));
    }

    public WebElement accountOverview(){
        return driver.findElement(By.cssSelector("a[href='overview.htm']"));
    }

    public WebElement defaultAccount(){
        return driver.findElement(By.cssSelector("#accountTable > tbody > tr:nth-child(1) > td:nth-child(1) > a"));
    }

}
