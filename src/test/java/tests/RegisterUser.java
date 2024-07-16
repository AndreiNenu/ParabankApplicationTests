package tests;

import actions.Index;
import actions.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTests;
import utils.ConfigLoader;

public class RegisterUser extends BaseTests {

    private Index index = null;
    private Register register = null;
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/userData.properties");


    @Test
    public void registerUser(){

        index = new Index(driver);
        register = new Register(driver);
        String username = configLoader.getProperty("username");
        String expectedMessage = "Welcome " + username;

        index.clickIndexRegisterLink();

        Assert.assertTrue(register.getRegisterPageTitle().equalsIgnoreCase("Signing up is easy!"));

        register.registerUser();

        String actualMessage = register.getRegisterPageTitle();
        Assert.assertEquals(actualMessage, expectedMessage);

    }
}
