package com.appsenseca.pageobjects;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailHomePage {
  public SignInPage signOut(WebDriver driver) {
    WebElement profileButton = driver.findElement(By.xpath("//span[@class='gb_9a gbii']"));
    profileButton.click();
    WebElement  quitAccountButton = driver.findElement(By.id("gb_71"));
    quitAccountButton.click();
    WebDriverWait wait = new WebDriverWait(driver,30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//div[@class='qZp31e']//*[@viewBox='0 0 74 37']"))));
    return PageFactory.initElements(driver,SignInPage.class);
  }

  public boolean isInboxExist(WebDriver driver) {
    return driver.findElements(By.xpath("//div[@class='TN bzz aHS-bnt']//div[@class='aio UKr6le']")).size()>0;
  }

  public void clickComposeButton(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver,30);
    wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[role='button'][gh='cm']"))));
    WebElement composeButton =driver.findElement(By.cssSelector("div[role='button'][gh='cm']"));
    composeButton.click();
  }

  public void fillingRecipient(WebDriver driver, String recipient) {
    WebDriverWait wait = new WebDriverWait(driver,30);
    wait.until((ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@role='combobox']"))));
    WebElement toTextArea =driver.findElement(By.xpath("//textarea[@role='combobox']"));
    toTextArea.sendKeys(recipient);
  }

  public void fillingSubject(WebDriver driver, String subjectBody) {
    WebElement subject = driver.findElement(By.xpath("//input[@placeholder='Subject']"));
    subject.clear();
    subject.sendKeys(subjectBody);
  }

  public void fillingEmailBodyMessage(WebDriver driver, String body) {
    WebElement emailBody = driver.findElement(By.cssSelector("div[role='textbox'][tabindex='1']"));
    emailBody.clear();
    emailBody.sendKeys(body);
  }

  public void clickEmailSend(WebDriver driver) {

    WebElement sendButton = driver.findElement(By.cssSelector("div[role='button'][class='T-I J-J5-Ji aoO T-I-atl L3']"));
    sendButton.click();
  }

  public void clickInboxWithNewEmail(WebDriver driver, String inbox) {
    WebDriverWait wait = new WebDriverWait(driver,30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
    WebElement inboxLinkage = driver.findElement(By.partialLinkText(inbox));
    inboxLinkage.click();
  }

  public EmailViewPage clickOnNewEmail(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver,30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='bog']//span[@class='bqe'][contains(text(),'Test')]")));
    WebElement newEmail = driver.findElement(By.xpath("//span[@class='bog']//span[@class='bqe'][contains(text(),'Test')]"));
    newEmail.click();
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='hP'] [contains(text(),'Test')]")));
    return PageFactory.initElements(driver,EmailViewPage.class);
  }
}
