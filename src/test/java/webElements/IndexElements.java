package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IndexElements {

    private WebDriver driver;

    public IndexElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement loginTitle(){
        return driver.findElement(By.cssSelector("h2"));
    }

    public WebElement loginUsername(){
        return driver.findElement(By.cssSelector("input[name='username']"));
    }

    public WebElement loginPassword(){
        return driver.findElement(By.cssSelector("input[name='password']"));
    }

    public WebElement loginButton(){
        return driver.findElement(By.cssSelector("input[class='button']"));
    }

    public WebElement indexRegisterLink(){
        return driver.findElement(By.cssSelector("a[href='register.htm']"));
    }

    public WebElement indexForgotLoginInfoLink(){
        return driver.findElement(By.cssSelector("a[href='lookup.htm']"));
    }

}
