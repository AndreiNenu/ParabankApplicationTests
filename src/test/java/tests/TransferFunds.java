package tests;

import actions.Index;
import actions.Overview;
import actions.Transfer;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTests;
import utils.ConfigLoader;


public class TransferFunds extends BaseTests {

    private Index index = null;
    private Overview overview = null;
    private Transfer transfer = null;
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/userData.properties");
    private ConfigLoader configLoaderText = new ConfigLoader("src/test/resources/properties/WebElementsText.properties");


    @Test
    public void transferFunds() {

        index = new Index(driver);
        overview = new Overview(driver);
        transfer = new Transfer(driver);
        String actualTransferMessage;
        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");
        String transferAmount = configLoaderText.getProperty("transferAmount");
        String expectedTransferMessage = configLoaderText.getProperty("expectedTransferCompleteMessage");
        String defaultAccount = configLoader.getProperty("defaultAccount");
        String secondAccount = configLoader.getProperty("secondAccount");
        String thirdAccount = configLoader.getProperty("thirdAccount");

        //Pasul 1: Autentifică-te în aplicație.
        index.loginUser(username, password);

        //Pasul 2: Navighează la secțiunea "Transfer Funds".
        overview.clickTransferFundsLink();

        //Pasul 3: Introduce suma, contul sursă și contul destinație.
        transfer.enterTransferAmount(transferAmount);
        transfer.selectValueFromAccount(thirdAccount);
        transfer.selectValueToAccount(secondAccount);

        //Pasul 4: Apasă butonul "Transfer".
        transfer.clickTransferButton();

        //Pasul 5: Verifică dacă transferul a fost efectuat cu succes și dacă balanțele conturilor sunt actualizate corect.
        actualTransferMessage = transfer.getTransferCompleteText();
        Assert.assertEquals(actualTransferMessage, expectedTransferMessage);

        //!!!Verificarea balantelor trebuie terminata!!!

    }
}
