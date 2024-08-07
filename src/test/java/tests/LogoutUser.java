package tests;

import actions.Index;
import actions.Overview;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTests;
import utils.ConfigLoader;

public class LogoutUser extends BaseTests {

    private Overview overview = null;
    private Index index = null;
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/userData.properties");
    private ConfigLoader configLoaderText = new ConfigLoader("src/test/resources/properties/WebElementsText.properties");


    @Test
    public void logoutUser(){

        initTest("User Logout ");

        overview = new Overview(driver);
        index = new Index(driver);
        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");
        String expectedLoginTitle = configLoaderText.getProperty("expectedLoginTitle");

        //Pasul 1: Autentifică-te în aplicație.
        index.loginUser(username, password);

        //Pasul 2: Apasă butonul "Logout".
        overview.clickLogoutButton();

        //Pasul3 : Verifică dacă utilizatorul este redirecționat la pagina de login.
        Assert.assertTrue(index.getLoginTitle().equalsIgnoreCase(expectedLoginTitle));

    }
}
