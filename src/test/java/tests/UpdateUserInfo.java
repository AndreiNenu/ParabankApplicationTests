package tests;

import actions.Index;
import actions.Overview;
import actions.UpdateProfile;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTests;
import utils.ConfigLoader;

public class UpdateUserInfo extends BaseTests {

    private Index index = null;
    private Overview overview = null;
    private UpdateProfile updateProfile = null;
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/userData.properties");
    private ConfigLoader configLoaderText = new ConfigLoader("src/test/resources/properties/WebElementsText.properties");

    @Test
    public void updateUserInfo() {

        index = new Index(driver);
        overview = new Overview(driver);
        updateProfile = new UpdateProfile(driver);
        String username = configLoader.getProperty("username");
        String password = configLoader.getProperty("password");
        String expectedUpdateMessage = configLoaderText.getProperty("expectedUpdateMessage");
        String firstName = configLoader.getProperty("firstName");
        String lastName = configLoader.getProperty("lastName");
        String address = configLoader.getProperty("address");
        String city = configLoader.getProperty("city");
        String state = configLoader.getProperty("state");
        String zipCode = configLoader.getProperty("zipCode");
        String phoneNumber = configLoader.getProperty("phoneNumber");

        //Pasul 1: Autentifică-te în aplicație.
        index.loginUser(username, password);

        //Pasul 2: Navighează la secțiunea "Update Contact Info".
        overview.clickUpdateContactInfoLink();

        //Pasul 3: Actualizează informațiile personale.
        updateProfile.setFirstName(firstName);
        updateProfile.setLastName(lastName);
        updateProfile.setAddress(address);
        updateProfile.setCity(city);
        updateProfile.setState(state);
        updateProfile.setZipCode(zipCode);
        updateProfile.setPhoneNumber(phoneNumber);

        //Pasul 4: Apasă butonul "Update Profile".
        updateProfile.clickUpdateProfileButton();

        //Pasul 5: Verifică dacă informațiile sunt actualizate corect.
        String actualUpdateMessage = updateProfile.getProfileUpdateMessageText();
        Assert.assertEquals(actualUpdateMessage, expectedUpdateMessage);

    }
}
