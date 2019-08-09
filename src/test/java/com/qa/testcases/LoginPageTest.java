package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
       LoginPage loginPage;
       HomePage homePage;

    public LoginPageTest(){
        super();//initialize the TestBase class constructor

    }
   @BeforeMethod
    public void setUp(){
        initialization();
        loginPage=new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest(){
        String title=loginPage.validateLoginPageTitle();
        Assert.assertEquals(title,"CRMPRO - CRM software for customer relationship management, sales, and support.");
    }
    @Test(priority = 2)
    public void crmLogoImageTest(){
        boolean flag=loginPage.validateCRMimage();
        Assert.assertTrue(flag);
    }
    @Test(priority = 3)
    public void loginTest(){
        homePage=loginPage.login(prop.getProperty("name"),prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
