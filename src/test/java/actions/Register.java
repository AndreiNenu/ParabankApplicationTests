package actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigLoader;
import webElements.RegisterElements;
import java.time.Duration;

public class Register {

    private RegisterElements elements;
    private Wait<WebDriver> wait;
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/userData.properties");

    public Register(WebDriver driver) {
        elements = new RegisterElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public String getRegisterPageTitle(){
        wait.until(d -> elements.registerPageTitle().isDisplayed());
        return elements.registerPageTitle().getText();
    }

    public void setFirstName(String firstName){
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

    public void setPhoneNumber(String phoneNumber){
        elements.phoneNumber().sendKeys(phoneNumber);
    }

    public void setSocialSecurityNumber(String socialSecurityNumber){
        elements.socialSecurityNumber().sendKeys(socialSecurityNumber);
    }

    public void setUsername(String username){
        elements.username().sendKeys(username);
    }

    public void setPassword(String password){
        elements.password().sendKeys(password);
    }

    public void setConfirmPassword(String confirmPassword){
        elements.confirmPassword().sendKeys(confirmPassword);
    }

    public void clickRegisterButton(){
        elements.registerButton().click();
    }

    public void registerUser(){

        String firstName = configLoader.getProperty("firstName");
        String lastName = configLoader.getProperty("lastName");
        String address = configLoader.getProperty("address");
        String city = configLoader.getProperty("city");
        String state = configLoader.getProperty("state");
        String zipCode = configLoader.getProperty("zipCode");
        String phoneNumber = configLoader.getProperty("phoneNumber");
        String socialSecurityNumber = configLoader.getProperty("socialSecurityNumber");
        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");

        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setCity(city);
        setState(state);
        setZipCode(zipCode);
        setPhoneNumber(phoneNumber);
        setSocialSecurityNumber(socialSecurityNumber);

        setUsername(username);
        setPassword(password);
        setConfirmPassword(password);

        clickRegisterButton();

    }

}
