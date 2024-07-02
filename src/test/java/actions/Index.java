package actions;

import org.openqa.selenium.WebDriver;
import webElements.IndexElements;

public class Index {

    private IndexElements elements;

    public Index(WebDriver driver){
        elements = new IndexElements(driver);
    }

    public void enterUsername(String username){
        elements.loginUsername().sendKeys(username);
    }

    public void enterPassword(String password){
        elements.loginPassword().sendKeys(password);
    }

    public void clickLoginButton(){
        elements.loginButton().click();
    }

    public void clickIndexRegisterLink(){
        elements.indexRegisterLink().click();
    }

}
