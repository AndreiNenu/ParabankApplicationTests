package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webElements.LoginElements;

import java.time.Duration;

public class Login {

    private LoginElements elements;
    private Wait<WebDriver> wait;

    public Login(WebDriver driver){
        elements = new LoginElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getErrorLoginTitleText(){
        wait.until(d-> elements.errorLoginTitle().isDisplayed());
        return elements.errorLoginTitle().getText();
    }

    public String getErrorLoginMessageText(){
        wait.until(d-> elements.errorLoginMessage().isDisplayed());
        return elements.errorLoginMessage().getText();
    }

    public boolean isUserNotRegistered(){
        try {
            wait.until(d -> elements.errorLoginMessage().isDisplayed());
            return elements.errorLoginMessage().isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

}
