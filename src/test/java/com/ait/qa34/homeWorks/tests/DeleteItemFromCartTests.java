package com.ait.qa34.homeWorks.tests;

import com.demowebshop.data.UserData;
import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteItemFromCartTests extends TestBase {

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

        app.getUser().clickOnButtonAddItemToCartAndViewShoppingCart();
    }

    @Test
    public void deleteItemPositiveTest() {
        int sizeBefore = app.getUser().sizeOfItems();
        app.getUser().removeItem();

        app.getUser().pause(500);
        int sizeAfter = app.getUser().sizeOfItems();
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }
}
