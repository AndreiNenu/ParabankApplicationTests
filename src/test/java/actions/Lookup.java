package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webElements.LookupElements;
import java.time.Duration;

public class Lookup {

    private LookupElements elements;
    private Wait<WebDriver> wait;

    public Lookup(WebDriver driver){
        elements = new LookupElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void setFirstName(String firstName){
        wait.until(d -> elements.findMyLoginInfoButton().isDisplayed());
        elements.firstName().sendKeys(firstName);
    }

    public void setLastName(String lastName){
        elements.lastName().sendKeys(lastName);
    }

    public void setAddress(String address){
        elements.address().sendKeys(address);
    }

    public void setCity(String city){
        elements.city().sendKeys(city);
    }

    public void setState(String state){
        elements.state().sendKeys(state);
    }

    public void setZipCode(String zipCode){
        elements.zipCode().sendKeys(zipCode);
    }

    public void setSocialSecurityNumber(String socialSecurityNumber){
        elements.socialSecurityNumber().sendKeys(socialSecurityNumber);
    }

    public void clickFindMyLoginInfoButton(){
        elements.findMyLoginInfoButton().click();
    }

    public String getRecoveryMessageText(){
        wait.until(d -> elements.recoveryMessage().isDisplayed());
        return elements.recoveryMessage().getText();
    }

    public String getRecoveredUserInfo(){
        return elements.RecoveredUserInfo().getText();
    }

}
