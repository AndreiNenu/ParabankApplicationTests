package tests;

import actions.Billpay;
import actions.Index;
import actions.Overview;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTests;
import utils.ConfigLoader;

public class PayABill extends BaseTests {

    private Index index = null;
    private Overview overview = null;
    private Billpay billpay = null;
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/userData.properties");
    private ConfigLoader configLoaderText = new ConfigLoader("src/test/resources/properties/WebElementsText.properties");


    @Test
    public void payBillTest() {

        initTest("Pay a bill");

        index = new Index(driver);
        overview = new Overview(driver);
        billpay = new Billpay(driver);
        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");
        String expectedBillPayMessage = configLoaderText.getProperty("expectedBillPayMessage");
        String payeeName = configLoader.getProperty("firstName") + " " + configLoader.getProperty("lastName");
        String address = configLoader.getProperty("address");
        String city = configLoader.getProperty("city");
        String state = configLoader.getProperty("state");
        String zipCode = configLoader.getProperty("zipCode");
        String phoneNumber = configLoader.getProperty("phoneNumber");
        String transferAmount = configLoaderText.getProperty("transferAmount");
        String defaultAccount = configLoader.getProperty("defaultAccount");
        String secondAccount = configLoader.getProperty("secondAccount");


        //Pasul 1: Autentifică-te în aplicație.
        index.loginUser(username, password);

        //Pasul 2: Navighează la secțiunea "Bill Pay".
        overview.clickBillPayLink();

        //Pasul 3: Introduce detaliile necesare pentru plată (beneficiar, sumă, cont sursă etc.).
        billpay.setPayeeName(payeeName);
        billpay.setAddress(address);
        billpay.setCity(city);
        billpay.setState(state);
        billpay.setZipCode(zipCode);
        billpay.setPhoneNumber(phoneNumber);
        billpay.enterAccountNumber(secondAccount);
        billpay.verifyAccountNumber(secondAccount);
        billpay.enterMoneyAmount(transferAmount);
        billpay.selectFromAccount(defaultAccount);

        //Pasul 4: Apasă butonul "Send Payment".
        billpay.clickPaymentButton();

        //Pasul 5: Verifică dacă plata a fost efectuată cu succes.
        String actualBillPayMessage = billpay.getBillPayCompleteText();
        Assert.assertEquals(actualBillPayMessage, expectedBillPayMessage);

    }
}
