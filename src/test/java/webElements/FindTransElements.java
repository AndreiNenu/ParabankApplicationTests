package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindTransElements {

    private WebDriver driver;

    public FindTransElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement findTransactionTitle(){ return driver.findElement(By.xpath("//h1[contains(text(),'Find Transactions')]")); }

}
