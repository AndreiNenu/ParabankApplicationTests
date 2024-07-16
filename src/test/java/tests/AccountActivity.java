package tests;

import actions.Activity;
import actions.Index;
import actions.Overview;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTests;
import utils.ConfigLoader;

import java.util.List;

public class AccountActivity extends BaseTests {

    private Index index = null;
    private Overview overview = null;
    private Activity activity = null;
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/userData.properties");

    @Test
    public void accountActivity() {

        index = new Index(driver);
        overview = new Overview(driver);
        activity = new Activity(driver);
        List<WebElement> allHeaders;
        List<WebElement> allTransactions;
        String[] actualHeaders;
        String[] actualTransactions;
        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");
        String[] expectedHeaders = {"Date", "Transaction", "Debit (-)", "Credit (+)"};
        String[] expectedTransactions = {
                "07-16-2024", "Funds Transfer Sent", "$100.00", "",
                "07-16-2024", "Funds Transfer Sent", "$99.00", "",
                "07-16-2024", "Funds Transfer Received", "", "$99.00",
                "07-16-2024", "Funds Transfer Received", "", "$99.00"
        };

        //Pasul 1: Autentifică-te în aplicație.
        index.loginUser(username, password);

        //Pasul 2: Navighează la secțiunea "Accounts Overview".
        overview.clickAccountOverview();

        //Pasul 3: Selectează un cont.
        overview.clickDefaultAccount();

        //Pasul 4: Verifică dacă istoricul tranzacțiilor este afișat corect.
        allHeaders = activity.getAllTableHeaders();
        allTransactions = activity.getAllTransactions();

        actualHeaders = new String[allHeaders.size()];
        for (int i = 0; i < allHeaders.size(); i++) {
            actualHeaders[i] = allHeaders.get(i).getText();
            System.out.print(actualHeaders[i] + "   ");
        }

        System.out.println();
        Assert.assertEquals(actualHeaders, expectedHeaders);

        actualTransactions = new String[allTransactions.size()];
        for (int i = 0; i < allTransactions.size(); i++) {
            actualTransactions[i] = allTransactions.get(i).getText();
            System.out.print(actualTransactions[i] + "   ");
            if ((i + 1) % 4 == 0) {
                System.out.println();
            }
        }

        Assert.assertEquals(actualTransactions, expectedTransactions);

    }
}
