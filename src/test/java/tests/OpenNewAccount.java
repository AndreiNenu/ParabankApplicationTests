package tests;

import actions.Index;
import actions.OpenAccount;
import actions.Overview;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTests;
import utils.ConfigLoader;

public class OpenNewAccount extends BaseTests {

    private Index index = null;
    private Overview overview = null;
    private OpenAccount openAccount = null;
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/userData.properties");
    private ConfigLoader configLoaderText = new ConfigLoader("src/test/resources/properties/WebElementsText.properties");

    @Test
    public void openNewAccount() {

        index = new Index(driver);
        overview = new Overview(driver);
        openAccount = new OpenAccount(driver);
        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");
        String expectedOpenAccountMessage = configLoaderText.getProperty("expectedOpenAccountMessage");
        String checkingAccount = configLoader.getProperty("checkingAccount");
        String savingsAccount = configLoader.getProperty("savingsAccount");
        String defaultAccount = configLoader.getProperty("defaultAccount");
        String secondAccount = configLoader.getProperty("secondAccount");
        String thirdAccount = configLoader.getProperty("thirdAccount");

        //Pasul 1: Autentifică-te în aplicație.
        index.loginUser(username, password);

        //Pasul 2: Navighează la secțiunea "Open New Account".
        overview.clickOpenNewAccountLink();

        //Pasul 3: Selectează tipul de cont și contul sursă.
        //openAccount.selectTypeOfAccount(checkingAccount);
        openAccount.selectTypeOfAccount(savingsAccount);
        //openAccount.selectFromAccount(defaultAccount);
        openAccount.selectFromAccount(secondAccount);
        //openAccount.selectFromAccount(thirdAccount);

        //Pasul 4: Apasă butonul "Open New Account".
        openAccount.clickOpenNewAccountButton();

        //Pasul 5: Verifică dacă contul nou a fost creat cu succes.
        String actualOpenAccountMessage = openAccount.getOpenAccountCompleteText();
        Assert.assertEquals(actualOpenAccountMessage, expectedOpenAccountMessage);

    }
}
