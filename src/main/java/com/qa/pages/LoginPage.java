package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    //Page Factory or Object Repository

    @FindBy(name = "username")
    WebElement username;

    @FindBy(name = "password")
    WebElement password;
    //create own xpath( xpath="//header[@type or name or class =value ]")
    @FindBy(xpath = "//input[@type='submit']")
    WebElement loginBtn;
    @FindBy(xpath = "//button[contains(@text(),'Sign Up')]")
    WebElement signUpBtn;
    @FindBy(xpath = "//img[contains(@class,'img-responsive')]")
    WebElement crmLogo;

    //Initialize the page factory
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    //Action
    public String validateLoginPageTitle(){
        return driver.getTitle();
    }

    public  boolean validateCRMimage(){
        return crmLogo.isDisplayed();
    }

    public HomePage login(String un, String psw){
        username.sendKeys(un);
        password.sendKeys(psw);

        return new HomePage();//Langding page is homeoage
    }












}
