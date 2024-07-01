package actions;

import org.openqa.selenium.WebDriver;
import webElements.RegisterElements;

public class Register {

    private RegisterElements elements;

    public Register(WebDriver driver) {
        elements = new RegisterElements(driver);
    }

    public String getRegisterPageTitle(){
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

        setFirstName();
        setLastName();
        setAddress();
        setCity();
        setState();
        setZipCode();
        setPhoneNumber();
        setSocialSecurityNumber();

        setUsername();
        setPassword();
        setConfirmPassword();

        clickRegisterButton();

    }

}
