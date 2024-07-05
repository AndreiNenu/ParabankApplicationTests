package tests;

import actions.Index;
import actions.OpenAccount;
import actions.Overview;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTests;
import utils.ConfigLoader;
import webElements.OpenAccountElements;

public class MainMenuNavigation extends BaseTests {

    public Index index = null;
    private Overview overview = null;
    private OpenAccount openAccount = null;
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/userData.properties");
    private ConfigLoader configLoaderText = new ConfigLoader("src/test/resources/properties/WebElementsText.properties");

    @Test
    public void mainMenuNavigation(){

        index = new Index(driver);
        overview = new Overview(driver);
        openAccount = new OpenAccount(driver);
        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");
        String[] actualValue = new String[10];

        //Pasul 1: Autentifică-te în aplicație.
        index.loginUser(username, password);

        //Pasul 2: Navighează prin fiecare secțiune din meniul principal (Accounts Overview, Transfer Funds, Bill Pay, etc.).
        //Pasul 3: Verifică dacă fiecare link duce la pagina corespunzătoare și dacă informațiile sunt afișate corect.

        overview.clickOpenNewAccountLink();
        actualValue = openAccount.getOpenAccountPageInfo();
        Assert.assertTrue(actualValue[0].equalsIgnoreCase("Open New Account"));
        Assert.assertTrue(actualValue[1].equalsIgnoreCase("CHECKING"));
        Assert.assertTrue(actualValue[2].equalsIgnoreCase(configLoader.getProperty("defaultAccount")));

        overview.clickAccountOverview();





    }
}
