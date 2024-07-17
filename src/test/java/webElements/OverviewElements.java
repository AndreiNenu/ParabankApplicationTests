package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class OverviewElements {

    private WebDriver driver;

    public OverviewElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement welcomeMessage(){
        return driver.findElement(By.cssSelector("p[class='smallText']"));
    }

    public WebElement defaultAccount(){
        return driver.findElement(By.cssSelector("#accountTable > tbody > tr:nth-child(1) > td:nth-child(1) > a"));
    }

    public WebElement accountOverviewTitle(){
        return driver.findElement(By.xpath("//h1[contains(text(),'Accounts Overview')]"));
    }

    //Selects first two collumns of account overview table, first collumn is account ids, second is balance
    public List<WebElement> userAccountAndBalance(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver.findElements(By.xpath("//table[@id='accountTable']//tbody//td"));
    }


    //Main Menu WebElements Links
    public WebElement openNewAccountLink(){
        return driver.findElement(By.cssSelector("a[href='openaccount.htm']"));
    }

    public WebElement accountOverview(){
        return driver.findElement(By.cssSelector("a[href='overview.htm']"));
    }

    public WebElement transferFundsLink(){
        return driver.findElement(By.cssSelector("a[href='transfer.htm']"));
    }

    public WebElement billPayLink(){
        return driver.findElement(By.cssSelector("a[href='billpay.htm']"));
    }

    public WebElement findTransactionsLink(){
        return driver.findElement(By.cssSelector("a[href='findtrans.htm']"));
    }

    public WebElement updateContactInfoLink(){
        return driver.findElement(By.cssSelector("a[href='updateprofile.htm']"));
    }

    public WebElement requestLoanLink(){
        return driver.findElement(By.cssSelector("a[href='requestloan.htm']"));
    }

    public WebElement logoutButton(){
        return driver.findElement(By.cssSelector("a[href='logout.htm']"));
    }

}
