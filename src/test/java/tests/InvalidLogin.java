package tests;

import actions.Index;
import actions.Login;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTests;
import utils.ConfigLoader;

public class InvalidLogin extends BaseTests {

    private Index index = null;
    private Login login = null;
    private ConfigLoader configLoaderData = new ConfigLoader("src/test/resources/properties/userData.properties");
    private ConfigLoader configLoaderText = new ConfigLoader("src/test/resources/properties/WebElementsText.properties");

    @Test
    public void loginUser(){

        index = new Index(driver);
        login = new Login(driver);
        String username = configLoaderData.getProperty("username");
        String password = configLoaderData.getProperty("password");
        String injectedError = configLoaderText.getProperty("injectErrorText");
        String expectedLoginErrorTitle = configLoaderText.getProperty("expectedLoginErrorTitle");
        String expectedLoginErrorMessage = configLoaderText.getProperty("expectedLoginErrorMessage");

        //Pasul 1: Deschide pagina de login. (se face in BaseTests-> metoda setUp()

        //Pasul 2: Introduce username și parola invalide.
        index.enterUsername(username + injectedError);
        index.enterPassword(password + injectedError);

        //Pasul3 : Apasă butonul "Login".
        index.clickLoginButton();

        //Pasul 4: Verifică dacă apare un mesaj de eroare.
        String actualLoginErrorTitle = login.getErrorLoginTitleText();
        String actualLoginErrorMessage = login.getErrorLoginMessageText();
        Assert.assertEquals(actualLoginErrorTitle, expectedLoginErrorTitle);
        Assert.assertEquals(actualLoginErrorMessage, expectedLoginErrorMessage);

    }
}
