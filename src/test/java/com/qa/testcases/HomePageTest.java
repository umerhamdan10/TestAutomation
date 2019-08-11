package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    public HomePageTest(){
        super();//test constructer call
    }
    @BeforeMethod
    public void setUp(){
        initialization(); // initialize the
        loginPage=new LoginPage();// first reach to the homepage
        testUtil=new TestUtil();
        contactsPage=new ContactsPage();
        homePage=loginPage.login(prop.getProperty("name"),prop.getProperty("password"));
    }

    @Test(priority = 1)
    public void verifyHomePageTitle(){
        String title=homePage.verifyHomePageTitle();
       Assert.assertEquals(title,"CRMPRO","Home page title not match");
    }
    @Test(priority = 2)
    public void verifyCorrectUserNameTest(){
        testUtil.switchToFrame();
        Assert.assertTrue(homePage.verifyCorrectUserName());
    }
    @Test(priority = 3)
    public void verifyContactLinkTest(){
        testUtil.switchToFrame();
        contactsPage=homePage.clickOnContactLink();
    }




    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
