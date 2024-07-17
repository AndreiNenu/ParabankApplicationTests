package tests;

import actions.Index;
import actions.OpenAccount;
import actions.Overview;
import actions.Transfer;
import org.testng.annotations.Test;
import utils.BaseTests;
import utils.ConfigLoader;

public class SimulateAccounts extends BaseTests {

    private Index index = null;
    private Overview overview = null;
    private OpenAccount openAccount = null;
    private Transfer transfer = null;
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/userData.properties");
    private ConfigLoader configLoaderText = new ConfigLoader("src/test/resources/properties/WebElementsText.properties");


    @Test
    public void simulateAccounts() {

        initTest("User activity simulation");

        index = new Index(driver);
        overview = new Overview(driver);
        openAccount = new OpenAccount(driver);
        transfer = new Transfer(driver);
        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");
        String transferAmount = configLoaderText.getProperty("transferAmount");
        //String defaultAccount = configLoader.getProperty("defaultAccount");
        String defaultAccount ;
        //String secondAccount = configLoader.getProperty("secondAccount");
        String secondAccount;
        //String thirdAccount = configLoader.getProperty("thirdAccount");
        String thirdAccount;
        String checkingAccount = configLoader.getProperty("checkingAccount");
        String savingsAccount = configLoader.getProperty("savingsAccount");

        //Pasul 1: Autentifică-te în aplicație.
        index.loginUser(username, password);

        //Pasul 2: Creeaza 2 conturi noi(un savings si un checking)
        //Get default account
        overview.clickAccountOverview();
        for(String str:overview.getAccountIdAndBalance()){System.out.print(str + " ");}
        System.out.println();
        defaultAccount = overview.getAccountIdAndBalance()[0];

        //open second account
        openNewAccount(savingsAccount, defaultAccount);
        for(String str:overview.getAccountIdAndBalance()){System.out.print(str + " ");}
        System.out.println();
        secondAccount = overview.getAccountIdAndBalance()[3];

        //open third account
        openNewAccount(checkingAccount, defaultAccount);
        for(String str:overview.getAccountIdAndBalance()){System.out.print(str + " ");}
        System.out.println();
        thirdAccount = overview.getAccountIdAndBalance()[6];

        //Pasul 3: Transfera bani intre conturi
        //transfer money from default to third account
        transferMoney(transferAmount, defaultAccount, thirdAccount);

        //transfer money from second to default account
        transferMoney(transferAmount, secondAccount, defaultAccount);

        //transfer money from second to default account
        transferMoney(transferAmount, secondAccount, defaultAccount);


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
