package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateProfileElements {

    WebDriver driver;

    public UpdateProfileElements(WebDriver driver){
        this.driver = driver;
    }

    public WebElement firstName(){
        return driver.findElement(By.xpath("//input[@id='customer.firstName']"));
    }

    public WebElement lastName(){
        return driver.findElement(By.xpath("//input[@id='customer.lastName']"));
    }

    public WebElement address(){
        return driver.findElement(By.xpath("//input[@id='customer.address.street']"));
    }

    public WebElement city(){
        return driver.findElement(By.xpath("//input[@id='customer.address.city']"));
    }

    public WebElement state(){
        return driver.findElement(By.xpath("//input[@id='customer.address.state']"));
    }

    public WebElement zipCode(){
        return driver.findElement(By.xpath("//input[@id='customer.address.zipCode']"));
    }

    public WebElement phoneNumber(){
        return driver.findElement(By.xpath("//input[@id='customer.phoneNumber']"));
    }

    public WebElement updateProfileButton(){
        return driver.findElement(By.cssSelector("input[value='Update Profile']"));
    }

    public WebElement profileUpdateMessage(){
        return driver.findElement(By.cssSelector("#updateProfileResult > h1"));
    }

}
