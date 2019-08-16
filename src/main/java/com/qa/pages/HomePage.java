package com.qa.pages;

import com.qa.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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
    @FindBy(xpath = "//a[contains(text(),'New Contact')]")
    WebElement newContactLink;

    //initialize Page object
    public HomePage(){
        PageFactory.initElements(driver,this);
    }

    //Actions
    public String verifyHomePageTitle(){
        return driver.getTitle();
    }

    public boolean verifyCorrectUserName(){
        return userNameLable.isDisplayed();
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

    public void clickOnNewContactLink(){
        Actions action = new Actions(driver);  //Dropdown thats why first visible the drop down and then click on new contact link
        action.moveToElement(contactLink).build().perform();
        newContactLink.click();

    }


}
