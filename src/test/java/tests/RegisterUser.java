package tests;

import actions.Index;
import actions.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTests;

public class RegisterUser extends BaseTests {

    private Index index = null;
    private Register register = null;

    @Test
    public void registerUser(){

        index = new Index(driver);
        register = new Register(driver);

        index.clickIndexRegisterLink();

        Assert.assertTrue(register.getRegisterPageTitle().equalsIgnoreCase("Signing up is easy!"));

        register.registerUser();

    }

}
