package tests;

import actions.Index;
import actions.Overview;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTests;
import utils.ConfigLoader;

public class ValidLogin extends BaseTests {

    private Index index;
    private Overview overview = null;
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/userData.properties");

    public ValidLogin(WebDriver driver){
        index = new Index(driver);
    }

    @Test
    public void loginUser(){

        overview = new Overview(driver);
        index = new Index(driver);
        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");
        String firstName = configLoader.getProperty("firstName");
        String lastName = configLoader.getProperty("lastName");
        String expectedMessage = "Welcome " + firstName + " " + lastName;

        //Pasul 1: Deschide pagina de login. (se face in BaseTests-> metoda setUp()

        //Pasul 2: Introduce username și parola valide.
        index.enterUsername(username);
        index.enterPassword(password);

        //Pasul3 : Apasă butonul "Login".
        index.clickLoginButton();

        //Pasul 4: Verifică dacă utilizatorul este redirecționat la pagina de cont.
        String actualMessage = overview.getWelcomeMessageText();
        Assert.assertEquals(actualMessage,expectedMessage);

    }

    public void loginUser(String username, String password){
        index.enterUsername(username);
        index.enterPassword(password);
        index.clickLoginButton();
    }
}
