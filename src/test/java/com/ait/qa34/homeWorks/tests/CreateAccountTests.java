package com.ait.qa34.homeWorks.tests;

import com.demowebshop.data.UserData;
import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CreateAccountTests extends BasePage {
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

    @Test
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
}
