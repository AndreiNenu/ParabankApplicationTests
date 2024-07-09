package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginElements {

    private WebDriver driver;

    public LoginElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement errorLoginTitle(){
        return driver.findElement(By.cssSelector("h1[class='title']"));
    }

    public WebElement errorLoginMessage(){
        return driver.findElement(By.cssSelector("p[class='error']"));
    }

}
