package tests;

import actions.Index;
import actions.OpenAccount;
import actions.Overview;
import actions.Transfer;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTests;
import utils.ConfigLoader;

import java.util.List;

public class TransferFunds extends BaseTests {

    private Index index = null;
    private Overview overview = null;
    private Transfer transfer = null;
    private OpenAccount openAccount = null;
    String[] arr = new String[20];
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/userData.properties");
    private ConfigLoader configLoaderText = new ConfigLoader("src/test/resources/properties/WebElementsText.properties");


    @Test
    public void transferFunds() {

        initTest("Transfer Money");

        index = new Index(driver);
        overview = new Overview(driver);
        transfer = new Transfer(driver);
        openAccount = new OpenAccount(driver);
        String actualTransferMessage;
        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");
        String transferAmount = configLoaderText.getProperty("transferAmount");
        String expectedTransferMessage = configLoaderText.getProperty("expectedTransferCompleteMessage");
        //String defaultAccount = configLoader.getProperty("defaultAccount");
        //String secondAccount = configLoader.getProperty("secondAccount");
        //String thirdAccount = configLoader.getProperty("thirdAccount");
        String balance;


        //Pasul 1: Autentifică-te în aplicație.
        index.loginUser(username, password);

        //Colecteaza datele contului
        arr = overview.getAccountIdAndBalance();
        String defaultAccount = arr[0];
        String secondAccount = arr[3];
        String thirdAccount = arr[6];
        balance = arr[1].replaceAll("[-$]","");
        System.out.println(balance);
        int moneyAcc1 = Integer.parseInt(balance.split(".00")[0]);
        System.out.println(moneyAcc1);
        balance = arr[4].replaceAll("[-$]","");
        System.out.println(balance);
        int moneyAcc2 = Integer.parseInt(balance.split(".00")[0]);
        System.out.println(moneyAcc2);
        balance = arr[7].replaceAll("[-$]","");
        System.out.println(balance);
        int moneyAcc3 = Integer.parseInt(balance.split(".00")[0]);
        System.out.println(moneyAcc3);

        //Pasul 2: Navighează la secțiunea "Transfer Funds".
        //Acest pas se face in interiorul functiei "transferMoney" la inceput

        //Pasul 3: Introduce suma, contul sursă și contul destinație.
        transferMoney(transferAmount, defaultAccount, thirdAccount);
        moneyAcc1 = moneyAcc1 - Integer.parseInt(transferAmount);
        moneyAcc3 = moneyAcc3 + Integer.parseInt(transferAmount);

        transferMoney(transferAmount, secondAccount, defaultAccount);
        moneyAcc2 = moneyAcc2 - Integer.parseInt(transferAmount);
        moneyAcc1 = moneyAcc1 + Integer.parseInt(transferAmount);

        transferMoney(transferAmount, thirdAccount, defaultAccount);
        moneyAcc3 = moneyAcc3 - Integer.parseInt(transferAmount);
        moneyAcc1 = moneyAcc1 +  Integer.parseInt(transferAmount);

        //Pasul 4: Apasă butonul "Transfer".
        //Acest pas se face in interiorul functiei "transferMoney" la sfarsit

        //Pasul 5: Verifică dacă transferul a fost efectuat cu succes și dacă balanțele conturilor sunt actualizate corect.
        actualTransferMessage = transfer.getTransferCompleteText();
        Assert.assertEquals(actualTransferMessage, expectedTransferMessage);

        int actualBalance;
        arr = overview.getAccountIdAndBalance();
        balance = arr[1].replaceAll("[-$]","");
        actualBalance = Integer.parseInt(balance.split(".00")[0]);
        Assert.assertEquals(actualBalance, moneyAcc1);

        balance = arr[4].replaceAll("[-$]","");
        actualBalance = Integer.parseInt(balance.split(".00")[0]);
        Assert.assertEquals(actualBalance, moneyAcc2);

        balance = arr[7].replaceAll("[-$]","");
        actualBalance = Integer.parseInt(balance.split(".00")[0]);
        Assert.assertEquals(actualBalance, moneyAcc3);


    }

    private void transferMoney(String transferAmount, String fromAccount, String toAccount) {
        overview.clickTransferFundsLink();
        transfer.enterTransferAmount(transferAmount);
        transfer.selectValueFromAccount(fromAccount);
        transfer.selectValueToAccount(toAccount);
        transfer.clickTransferButton();
    }

    private void openNewAccount(String typeOfAccount, String fromAccount) {
        overview.clickOpenNewAccountLink();
        openAccount.selectTypeOfAccount(typeOfAccount);
        openAccount.selectFromAccount(fromAccount);
        openAccount.clickOpenNewAccountButton();
    }

}
