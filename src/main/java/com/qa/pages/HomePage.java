package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {

  @FindBy(xpath = "//td[contains(text(),'User: Umer Hamdan')]")
    WebElement userNameLable;

  @FindBy(xpath = "//a[contains(text(),'Contacts')]")
    WebElement contactLink;

    @FindBy(xpath = "//a[contains(text(),'Deals')]")
    WebElement dealLink;

    @FindBy(xpath = "//a[contains(text(),'Tasks')]")
    WebElement taskLink;

    //initialize Page object
    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    //Actions
    public String verifyHomePageTitle(){
        return driver.getTitle();
    }

    public ContactsPage clickOnContactLink(){
     contactLink.click();
     return new ContactsPage();
    }
    public DealPage clickOnDealLink(){
        dealLink.click();
        return new DealPage();
    }

    public TasksPage clickOnTasksLink(){
        taskLink.click();
        return new TasksPage();
    }


}
