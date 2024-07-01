package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IndexElements {

    private WebDriver driver;

    public IndexElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement indexRegisterButton(){
        return driver.findElement(By.cssSelector("a[href='register.htm']"));
    }

}
