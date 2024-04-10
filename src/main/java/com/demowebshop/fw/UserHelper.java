package com.demowebshop.fw;

import com.demowebshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("[class='button-1 login-button']"));
    }

    public void fillLoginForm(User user) {
        type(By.name("Email"), user.getEmail());
        type(By.name("Password"), user.getPassword());
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void clickOnLogOutButton() {
        click(By.xpath("//a[text()='Log out']"));
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector("[href='/register']"));
    }

    public void fillRegisterForm(User user) {
        type(By.id("FirstName"), user.getFirstName());
        type(By.id("LastName"), user.getLastName());
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
        type(By.id("ConfirmPassword"), user.getPassword());
    }

    public void clickOnRegistrationButton() {
        click(By.id("register-button"));
    }

    public boolean isAccountEmailPresent() {
        return isElementPresent(By.xpath("//a[.='pulp_fiction2024@gmail.com']"));
    }

    public boolean isItemAdded() {

        List<WebElement> items = ApplicationManager.driver.findElements(By.xpath("//input[contains(@name, 'itemquantity')]"));
        for (WebElement item : items) {
            if (item.isDisplayed()) {
                return true;
            }
        }
        return false;
    }

    public boolean isErrorMessagePresent() {
        boolean isErrorMessageOfLoginPresent = isElementPresent(By.xpath("//span[contains(text(), 'Login was unsuccessful')]"));
        boolean isErrorMessageOfRegistrationPresent = isElementPresent(By.xpath("//li[text()='The specified email already exists']"));
        return isErrorMessageOfLoginPresent || isErrorMessageOfRegistrationPresent;
    }

    public void removeItem() {
        click(By.xpath("//input[@name='removefromcart']"));
        click(By.xpath("//input[@name='updatecart']"));
    }

    public void clickOnButtonAddItemToCartAndViewShoppingCart() {
        click(By.xpath("(//input[@type='button'])[4]"));
        click(By.xpath("//span[contains(text(),'Shopping cart')]"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }

    public int sizeOfItems() {
        if (isElementPresent(By.xpath("//input[contains(@name, 'itemquantity')]"))) {
            return ApplicationManager.driver.findElements(By.xpath("//input[contains(@name, 'itemquantity')]")).size();
        }
        return 0;
    }
}
