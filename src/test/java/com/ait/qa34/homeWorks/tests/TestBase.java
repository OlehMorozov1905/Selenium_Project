package com.ait.qa34.homeWorks.tests;

import com.demowebshop.fw.ApplicationManager;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TestBase {
    protected static ApplicationManager app = new ApplicationManager(System.getProperty("browser", Browser.CHROME.browserName()));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    //    @BeforeMethod
    @BeforeSuite
    public void setUp() {
        app.init();
    }

    //    @AfterMethod(enabled = false)
    @AfterSuite
    public void tearDown() {
        app.stop();
    }

    @BeforeMethod
    public void startTest(Method method) {
        logger.info("Start test: " + method.getName());
    }
    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED " + result.getMethod().getMethodName() + " Screenshot: " + app.getUser().takeScreenshot());
        }
        logger.info("Stop test");
        logger.info("======================================================================");
    }

}

