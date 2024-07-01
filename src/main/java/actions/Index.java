package actions;

import org.openqa.selenium.WebDriver;
import webElements.IndexElements;

public class Index {

    private IndexElements elements;

    public Index(WebDriver driver){
        elements = new IndexElements(driver);
    }

    public void clickIndexRegisterButton(){
        elements.indexRegisterButton().click();
    }
}
