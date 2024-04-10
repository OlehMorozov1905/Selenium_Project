package com.demowebshop.fw;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class ApplicationManager {
    static WebDriver driver;
    String browser;
    UserHelper user;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }
        if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        user = new UserHelper(driver);
    }

    public UserHelper getUser() {
        return user;
    }

    public void stop() {
        driver.quit();
    }
}
