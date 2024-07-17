package tests;

import actions.Index;
import actions.Lookup;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTests;
import utils.ConfigLoader;

public class RecoverLoginInfo extends BaseTests {

    public Index index = null;
    private Lookup lookup = null;
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/userData.properties");
    private ConfigLoader configLoaderText = new ConfigLoader("src/test/resources/properties/WebElementsText.properties");


    @Test
    public void recoverLoginInfo(){

        initTest("Recover Account Data");

        lookup = new Lookup(driver);
        index = new Index(driver);
        String firstName = configLoader.getProperty("firstName");
        String lastName = configLoader.getProperty("lastName");
        String address = configLoader.getProperty("address");
        String city = configLoader.getProperty("city");
        String state = configLoader.getProperty("state");
        String zipCode = configLoader.getProperty("zipCode");
        String socialSecurityNumber = configLoader.getProperty("socialSecurityNumber");
        String expectedRecoveryMessage = configLoaderText.getProperty("expectedRecoveryMessage");
        String expectedUsername = configLoader.getProperty("username");
        String expectedPassword = configLoader.getProperty("password");

        //Pasul 1: Navighează la pagina de login. (se face in BaseTests-> metoda setUp()

        //Pasul 2: Apasă link-ul "Forgot password".
        index.clickIndexForgotLoginInfoLink();

        //Pasul3 : Introduce username-ul.
        lookup.setFirstName(firstName);
        lookup.setLastName(lastName);
        lookup.setAddress(address);
        lookup.setCity(city);
        lookup.setState(state);
        lookup.setZipCode(zipCode);
        lookup.setSocialSecurityNumber(socialSecurityNumber);

        //Pasul 4: Apasă butonul "Find My Password".
        lookup.clickFindMyLoginInfoButton();

        //Pasul 5: Verifică dacă un mesaj de recuperare a parolei este trimis.
        String actualRecoveryPayMessage = lookup.getRecoveryMessageText();
        String userInfo = lookup.getRecoveredUserInfo();
        String[] arr= userInfo.split("\n");
        for(String str:arr){
            System.out.println(str);
        }

        String actualUsername = arr[0].split(" ")[1];
        String actualPassword = arr[1].split(" ")[1];

        //Verify the successful response message
        Assert.assertEquals(actualRecoveryPayMessage, expectedRecoveryMessage);
        //Verify recovered username
        Assert.assertEquals(actualUsername, expectedUsername);
        //Verify recovered password
        Assert.assertEquals(actualPassword, expectedPassword);

    }
}
