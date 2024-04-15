package com.ait.qa34.homeWorks.tests;

import com.demowebshop.data.UserData;
import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {

        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnLogOutButton();
        }

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User()
                .setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void AddItemToCartPositiveTest() {
        app.getUser().clickOnButtonAddItemToCart();
        app.getUser().clickOnButtonShoppingCart();

        Assert.assertTrue(app.getUser().isItemAdded());

    }

    @AfterMethod
    public void postCondition() {
        app.getUser().removeItem();
    }
}
