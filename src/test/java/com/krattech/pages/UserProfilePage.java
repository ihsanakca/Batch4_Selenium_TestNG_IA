package com.krattech.pages;

import com.krattech.utilities.BrowserUtils;
import com.krattech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePage extends BasePage{

    @FindBy(css = ".breadcrumb>li:nth-of-type(2)")
    public WebElement userProfilePageTitle;

    public void navigateEditProfileTabs(String tabName){
        WebElement tab = Driver.get().findElement(By.xpath("//button[text()='" + tabName + "'][./parent::li]"));
        BrowserUtils.clickWithJS(tab);
    }

    public String addedEducation(String schoolName){
        return Driver.get().findElement(By.xpath("(//span[text()='"+schoolName+"'])[last()]")).getText();
    }

    public void deleteEducationRecord(String schoolName){
        WebElement element = Driver.get().findElement(By.xpath("(//span[text()='"+schoolName+"'])[last()]/ancestor::tr//a"));
        BrowserUtils.clickWithJS(element);
        BrowserUtils.waitFor(2);
        Driver.get().switchTo().alert().accept();
    }
}
