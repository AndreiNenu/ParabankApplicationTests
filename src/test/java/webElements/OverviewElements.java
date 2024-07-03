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

}
