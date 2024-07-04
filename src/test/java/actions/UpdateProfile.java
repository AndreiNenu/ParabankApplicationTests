package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webElements.UpdateProfileElements;

import java.time.Duration;

public class UpdateProfile {

    private UpdateProfileElements elements;
    private Wait<WebDriver> wait;

    public UpdateProfile(WebDriver driver){
        elements = new UpdateProfileElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void setFirstName(String firstName){
        elements.firstName().clear();
        elements.firstName().sendKeys(firstName);
    }

    public void setLastName(String lastName){
        elements.lastName().clear();
        elements.lastName().sendKeys(lastName);
    }

    public void setAddress(String address){
        elements.address().clear();
        elements.address().sendKeys(address);
    }

    public void setCity(String city){
        elements.city().clear();
        elements.city().sendKeys(city);
    }

    public void setState(String state){
        elements.state().clear();
        elements.state().sendKeys(state);
    }

    public void setZipCode(String zipCode){
        elements.zipCode().clear();
        elements.zipCode().sendKeys(zipCode);
    }

    public void setPhoneNumber(String phoneNumber){
        elements.phoneNumber().clear();
        elements.phoneNumber().sendKeys(phoneNumber);
    }

    public void clickUpdateProfileButton(){
        elements.updateProfileButton().click();
    }

    public String getProfileUpdateMessageText(){
        wait.until(d -> elements.profileUpdateMessage().isDisplayed());
        return elements.profileUpdateMessage().getText();
    }
}
