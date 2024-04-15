package com.ait.qa34.homeWorks.tests;

import com.demowebshop.data.UserData;
import com.demowebshop.models.User;
import com.demowebshop.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnLogOutButton();
        }
    }

    @Test(enabled = false)
    public void createNewAccountPositiveTest() {

        app.getUser().clickOnRegisterLink();

        app.getUser().fillRegisterForm(new User()
                .setFirstName(UserData.FIRST_NAME)
                .setLastName(UserData.LAST_NAME)
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD)
                .setPassword(UserData.PASSWORD));

        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isAccountEmailPresent());
    }

    @Test (enabled = false)
    public void createNewAccountWithExistedEmailNegativeTest() {
        app.getUser().clickOnRegisterLink();

        app.getUser().fillRegisterForm(new User()
                .setFirstName(UserData.FIRST_NAME)
                .setLastName(UserData.LAST_NAME)
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD)
                .setPassword(UserData.PASSWORD));

        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isErrorMessagePresent());
    }

    @Test(dataProvider = "createNewAccountFromCsvFile", dataProviderClass = DataProviders.class)
    public void createNewAccountPositiveTestFromDataProviderWithCsvFile(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm(user);
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isAccountEmailPresent());
    }
}
