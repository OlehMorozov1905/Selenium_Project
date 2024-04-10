package com.ait.qa34.homeWorks.tests;

import com.demowebshop.data.UserData;
import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BasePage {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnLogOutButton();
        }
    }

    @Test
    public void loginPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isAccountEmailPresent());
    }

    @Test
    public void loginNegativeTestWithWrongPassword() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.WRONG_PASSWORD));
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isErrorMessagePresent());
    }
}
