package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webElements.OverviewElements;

import java.time.Duration;

public class Overview {

    private OverviewElements elements;
    private Wait<WebDriver> wait;

    public Overview(WebDriver driver){
        elements = new OverviewElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getWelcomeMessageText(){
        wait.until(d-> elements.welcomeMessage().isDisplayed());
        return elements.welcomeMessage().getText();
    }

    public void clickLogoutButton(){
        wait.until(d-> elements.logoutButton().isDisplayed());
        elements.logoutButton().click();
    }

}
