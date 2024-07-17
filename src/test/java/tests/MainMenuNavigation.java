package tests;

import actions.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTests;
import utils.ConfigLoader;

public class MainMenuNavigation extends BaseTests {

    public Index index = null;
    private Overview overview = null;
    private OpenAccount openAccount = null;
    private Transfer transfer = null;
    private Billpay billpay = null;
    private UpdateProfile updateProfile = null;
    private FindTrans findTrans = null;
    private RequestLoan requestLoan = null;
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/userData.properties");


    @Test
    public void mainMenuNavigation(){

        initTest("Check Main Menu Links ");

        index = new Index(driver);
        openAccount = new OpenAccount(driver);
        overview = new Overview(driver);
        transfer = new Transfer(driver);
        billpay = new Billpay(driver);
        findTrans = new FindTrans(driver);
        updateProfile = new UpdateProfile(driver);
        requestLoan = new RequestLoan(driver);

        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");
        String defaultAccount = configLoader.getProperty("defaultAccount");
        String[] actualValue;
        String expectedValue;
        String[] expectedArr;

        //Pasul 1: Autentifică-te în aplicație.
        index.loginUser(username, password);

        //Pasul 2: Navighează prin fiecare secțiune din meniul principal (Accounts Overview, Transfer Funds, Bill Pay, etc.).
        //Pasul 3: Verifică dacă fiecare link duce la pagina corespunzătoare și dacă informațiile sunt afișate corect.

        overview.clickOpenNewAccountLink();
        actualValue = openAccount.getTransferFundsPageInfo();
        expectedArr = new String[]{"Open New Account", "CHECKING", defaultAccount };
        System.out.println("Array length: " + expectedArr.length);
        Assert.assertTrue(actualValue[0].equalsIgnoreCase("Open New Account"));
        Assert.assertTrue(actualValue[1].equalsIgnoreCase("CHECKING"));
        Assert.assertTrue(actualValue[2].equalsIgnoreCase(defaultAccount));
        for(int i=0; i< actualValue.length; i++){
            System.out.println("Actual value: " + actualValue[i] + "\n" +
                    "Expected value: " + expectedArr[i]);
        }

        overview.clickAccountOverview();
        actualValue = overview.getAccountOverviewPageInfo();
        expectedArr = new String[]{"Accounts Overview", defaultAccount };
        System.out.println("Array length: " + expectedArr.length);
        Assert.assertTrue(actualValue[0].equalsIgnoreCase("Accounts Overview"));
        Assert.assertTrue(actualValue[1].equalsIgnoreCase(defaultAccount));
        for(int i=0; i< actualValue.length; i++){
            System.out.println("Actual value: " + actualValue[i] + "\n" +
                    "Expected value: " + expectedArr[i]);
        }

        overview.clickTransferFundsLink();
        actualValue = transfer.getTransferFundsPageInfo();
        expectedArr = new String[]{"Transfer Funds", "", defaultAccount, defaultAccount };
        System.out.println("Array length: " + expectedArr.length);
        Assert.assertTrue(actualValue[0].equalsIgnoreCase("Transfer Funds"));
        Assert.assertTrue(actualValue[1].isEmpty());
        Assert.assertTrue(actualValue[2].equalsIgnoreCase(defaultAccount));
        Assert.assertTrue(actualValue[3].equalsIgnoreCase(defaultAccount));
        for(int i=0; i< actualValue.length; i++){
            System.out.println("Actual value: " + actualValue[i] + "\n" +
                    "Expected value: " + expectedArr[i]);
        }

        overview.clickBillPayLink();
        actualValue[0] = billpay.getBillPayTitle();
        expectedValue = "Bill Payment Service";
        Assert.assertTrue(actualValue[0].equalsIgnoreCase(expectedValue));
        System.out.println("Actual value: " + actualValue[0] + "\n" +
                "Expected value: " + expectedValue);

        overview.clickFindTransactionsLink();
        actualValue[0] = findTrans.getFindTransactionTitle();
        expectedValue = "Find Transactions";
        Assert.assertTrue(actualValue[0].equalsIgnoreCase(expectedValue));
        System.out.println("Actual value: " + actualValue[0] + "\n" +
                "Expected value: " + expectedValue);

        overview.clickUpdateContactInfoLink();
        actualValue[0] = updateProfile.getUpdateProfileTitle();
        expectedValue = "Update Profile";
        Assert.assertTrue(actualValue[0].equalsIgnoreCase(expectedValue));
        System.out.println("Actual value: " + actualValue[0] + "\n" +
                "Expected value: " + expectedValue);

        overview.clickRequestLoanLink();
        actualValue[0] = requestLoan.getRequestLoanTitle();
        expectedValue = "Apply for a Loan";
        Assert.assertTrue(actualValue[0].equalsIgnoreCase(expectedValue));
        System.out.println("Actual value: " + actualValue[0] + "\n" +
                "Expected value: " + expectedValue);

        overview.clickLogoutButton();
        actualValue[0] = index.getLoginTitle();
        expectedValue = "Customer Login";
        Assert.assertTrue(actualValue[0].equalsIgnoreCase(expectedValue));
        System.out.println("Actual value: " + actualValue[0] + "\n" +
                "Expected value: " + expectedValue);

    }
}
