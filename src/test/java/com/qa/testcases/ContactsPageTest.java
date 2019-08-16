package com.qa.testcases;

import com.qa.base.TestBase;
import com.qa.pages.ContactsPage;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ContactsPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    TestUtil testUtil;
    ContactsPage contactsPage;

    String sheetName="sheet1";

    public ContactsPageTest(){
        super();//test constructer call
    }
    @BeforeMethod
    public void setUp(){
        initialization(); // initialize the
        loginPage=new LoginPage();// first reach to the homepage
        testUtil=new TestUtil();
        contactsPage=new ContactsPage();
        homePage=loginPage.login(prop.getProperty("name"),prop.getProperty("password"));
        testUtil.switchToFrame();
        contactsPage=homePage.clickOnContactLink();
    }


    @Test(priority=1)
    public void verifyContactsPageLabel(){
        Assert.assertTrue(contactsPage.verifyContactLabel(), "Failed contact label is not available");
    }

    @Test(priority=2)
    public void selectSingleContactsTest(){
        contactsPage.selectContactBy("khan afridi");
    }

    @Test(priority=3)
    public void selectMultipleContactsTest(){
        contactsPage.selectContactBy("khan afridi");
        contactsPage.selectContactBy("Umer Hamdan");

    }
    @DataProvider
    public Object[][] getDataFromSheet(){
        Object[][] objects =testUtil.getTestDataForInsertNewContacts(sheetName);

        return objects;
    }
    // here we use excel file and drive data from excel file
    @Test(priority = 4,dataProvider = "getDataFromSheet") //xcel sheet colums must be equal to parameter here in function
    public void createNewContact(String title,String fname,String lname,String company){

        homePage.clickOnNewContactLink();
        contactsPage.createNewContact(title,fname,lname,company);
    }


    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
