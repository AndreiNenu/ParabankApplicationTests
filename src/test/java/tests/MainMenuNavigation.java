package tests;

import actions.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTests;
import utils.ConfigLoader;
import webElements.UpdateProfileElements;

public class MainMenuNavigation extends BaseTests {

    public Index index = null;
    private Overview overview = null;
    private OpenAccount openAccount = null;
    private Transfer transfer = null;
    private Billpay billpay = null;
    private UpdateProfile updateProfile = null;
    private FindTrans findTrans = null;
    private RequestLoan requestLoan = null;
    private UpdateProfileElements updateProfileElements;
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/userData.properties");

    @Test
    public void mainMenuNavigation(){

        index = new Index(driver);
        openAccount = new OpenAccount(driver);
        overview = new Overview(driver);
        transfer = new Transfer(driver);
        billpay = new Billpay(driver);
        findTrans = new FindTrans(driver);
        updateProfile = new UpdateProfile(driver);
        requestLoan = new RequestLoan(driver);
        updateProfileElements = new UpdateProfileElements(driver);

        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");
        String[] actualValue;

        //Pasul 1: Autentifică-te în aplicație.
        index.loginUser(username, password);

        //Pasul 2: Navighează prin fiecare secțiune din meniul principal (Accounts Overview, Transfer Funds, Bill Pay, etc.).
        //Pasul 3: Verifică dacă fiecare link duce la pagina corespunzătoare și dacă informațiile sunt afișate corect.

        overview.clickOpenNewAccountLink();
        actualValue = openAccount.getTransferFundsPageInfo();
        Assert.assertTrue(actualValue[0].equalsIgnoreCase("Open New Account"));
        Assert.assertTrue(actualValue[1].equalsIgnoreCase("CHECKING"));
        Assert.assertTrue(actualValue[2].equalsIgnoreCase(configLoader.getProperty("defaultAccount")));
        for(String cuvant:actualValue){System.out.println(cuvant);}

        overview.clickAccountOverview();
        actualValue = overview.getAccountOverviewPageInfo();
        Assert.assertTrue(actualValue[0].equalsIgnoreCase("Accounts Overview"));
        Assert.assertTrue(actualValue[1].equalsIgnoreCase(configLoader.getProperty("defaultAccount")));
        for(String cuvant:actualValue){System.out.println(cuvant);}

        overview.clickTransferFundsLink();
        actualValue = transfer.getTransferFundsPageInfo();
        Assert.assertTrue(actualValue[0].equalsIgnoreCase("Transfer Funds"));
        Assert.assertTrue(actualValue[1].isEmpty());
        Assert.assertTrue(actualValue[2].equalsIgnoreCase(configLoader.getProperty("defaultAccount")));
        Assert.assertTrue(actualValue[3].equalsIgnoreCase(configLoader.getProperty("defaultAccount")));
        for(String cuvant:actualValue){System.out.println(cuvant);}

        overview.clickBillPayLink();
        actualValue[0] = billpay.getBillPayTitle();
        Assert.assertTrue(actualValue[0].equalsIgnoreCase("Bill Payment Service"));
        System.out.println(actualValue[0]);

        overview.clickFindTransactionsLink();
        actualValue[0] = findTrans.getFindTransactionTitle();
        System.out.println(actualValue[0]);

        overview.clickUpdateContactInfoLink();
        actualValue[0] = updateProfile.getUpdateProfileTitle();
        Assert.assertTrue(actualValue[0].equalsIgnoreCase("Update Profile"));
        System.out.println(actualValue[0]);

        overview.clickRequestLoanLink();
        actualValue[0] = requestLoan.getRequestLoanTitle();
        Assert.assertTrue(actualValue[0].equalsIgnoreCase("Apply for a Loan"));
        System.out.println(actualValue[0]);

        overview.clickLogoutButton();
        actualValue[0] = index.getLoginTitle();
        Assert.assertTrue(actualValue[0].equalsIgnoreCase("Customer Login"));
        System.out.println(actualValue[0]);

    }
}
