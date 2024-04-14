package com.ait.qa34.homeWorks.tests;

import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class CreateAccountFromDataProviderWithCsvFileTests extends BasePage{

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()) {
            app.getUser().clickOnLogOutButton();
        }
    }

    @DataProvider
    public Iterator<Object[]> createNewAccountFromCsvFile() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/dataForAppShopToCreateAccounts.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User().setFirstName(split[0]).setLastName(split[1]).setEmail(split[2]).setPassword(split[3]).setPassword(split[4])});
            line = reader.readLine();
        }
        return list.iterator();
    }
    @Test(dataProvider = "createNewAccountFromCsvFile")
    public void createNewAccountPositiveTestFromDataProviderWithCsvFile(User user) {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm(user);
        app.getUser().clickOnRegistrationButton();
        Assert.assertTrue(app.getUser().isAccountEmailPresent());
    }
}
