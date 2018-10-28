package com.appsenseca.pageobjects;

import com.appsenseca.utils.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
  public void fillInUsername(WebDriver driver, String userName) {
    WebUtil.sendKeys(driver,By.xpath("//input[@id='identifierId']"),userName);
    WebUtil.click(driver,By.xpath("//span[contains(text(),'Next')]"));
  }

  public void fillInPassword(WebDriver driver, String password) {
    WebUtil.waitForElementVisible(driver,By.xpath("//input[@name='password']"));
    WebUtil.sendKeys(driver,By.xpath("//input[@name='password']"),password);
  }

  public EmailHomePage clickSignIn(WebDriver driver) {
    WebUtil.click(driver,By.xpath("//span[contains(text(),'Next')]"));
    WebUtil.waitForElementVisible(driver,By.xpath("//div[@class='TN bzz aHS-bnt']//div[@class='aio UKr6le']"));
    return PageFactory.initElements(driver,EmailHomePage.class);
  }

  public boolean isSignedOut(WebDriver driver) {
    return WebUtil.isElementExist(driver,By.xpath(("//div[@class='qZp31e']//*[@viewBox='0 0 74 37']")));
  }
}
