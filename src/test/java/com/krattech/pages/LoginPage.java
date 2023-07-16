package com.krattech.pages;

import com.krattech.utilities.ConfigurationReader;
import com.krattech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage extends BasePage{
//    public LoginPage(){
//        PageFactory.initElements(Driver.get(),this);
//    }


    @FindBy(id="email")
    public WebElement userEmailBox;

    @FindBy(id = "yourPassword")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[text()='Login']")
    public WebElement loginBtn;

    @FindBy(css = ".form-control,[type='submit']")
    public List<WebElement> inputs;


    public void login(){
        inputs.get(0).sendKeys(ConfigurationReader.get("userEmail"));
        inputs.get(1).sendKeys(ConfigurationReader.get("password"));
        inputs.get(2).click();
    }

    public void login(String userEmail,String password){
        inputs.get(0).sendKeys(userEmail);
        inputs.get(1).sendKeys(password);
        inputs.get(2).click();
    }
}
