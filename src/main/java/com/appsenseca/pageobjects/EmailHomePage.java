package com.appsenseca.pageobjects;

import com.appsenseca.utils.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class EmailHomePage {
  public SignInPage signOut(WebDriver driver) {
    WebUtil.click(driver, By.xpath("//span[@class='gb_9a gbii']"));
    WebUtil.click(driver,By.id("gb_71"));
    WebUtil.waitForElementVisible(driver,By.xpath(("//div[@class='qZp31e']//*[@viewBox='0 0 74 37']")));
    return PageFactory.initElements(driver,SignInPage.class);
  }

  public boolean isInboxExist(WebDriver driver) {
    return WebUtil.isElementExist(driver,By.xpath("//div[@class='TN bzz aHS-bnt']//div[@class='aio UKr6le']"));
  }

  public void clickComposeButton(WebDriver driver) {
    WebUtil.isElementExist(driver,By.cssSelector("div[role='button'][gh='cm']"));
    WebUtil.click(driver,By.cssSelector("div[role='button'][gh='cm']"));
  }

  public void fillingRecipient(WebDriver driver, String recipient) {
    WebUtil.isElementExist(driver,By.xpath("//textarea[@role='combobox']"));
    WebUtil.sendKeys(driver,By.xpath("//textarea[@role='combobox']"),recipient);
  }

  public void fillingSubject(WebDriver driver, String subjectBody) {
    WebUtil.sendKeys(driver,By.xpath("//input[@placeholder='Subject']"),subjectBody);
    WebElement subject = driver.findElement(By.xpath("//input[@placeholder='Subject']"));
  }

  public void fillingEmailBodyMessage(WebDriver driver, String body) {
    WebUtil.sendKeys(driver,By.cssSelector("div[role='textbox'][tabindex='1']"),body);
  }

  public void clickEmailSend(WebDriver driver) {
    WebUtil.click(driver,By.cssSelector("div[role='button'][class='T-I J-J5-Ji aoO T-I-atl L3']"));
  }

  public void clickInboxWithNewEmail(WebDriver driver, String inbox) {
    WebUtil.waitForElementVisible(driver,By.partialLinkText("Inbox"));
    WebUtil.click(driver,By.partialLinkText(inbox));
  }

  public EmailViewPage clickOnNewEmail(WebDriver driver) {
    WebUtil.waitForElementVisible(driver,By.xpath("//span[@class='bog']//span[@class='bqe'][contains(text(),'Test')]"));
    WebUtil.click(driver,By.xpath("//span[@class='bog']//span[@class='bqe'][contains(text(),'Test')]"));
    WebUtil.waitForElementVisible(driver,By.xpath("//h2[@class='hP'] [contains(text(),'Test')]"));
    return PageFactory.initElements(driver,EmailViewPage.class);
  }
}
