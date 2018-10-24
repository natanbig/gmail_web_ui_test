package com.appsenseca.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
  public void fillInUsername(WebDriver driver, String userName) {
    WebElement usernameTexBox =  driver.findElement(By.xpath("//input[@id='identifierId']"));
    usernameTexBox.clear();
    usernameTexBox.sendKeys(userName);
    WebElement buttonNext = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
    buttonNext.click();
  }

  public void fillInPassword(WebDriver driver, String password) {
    WebDriverWait wait = new WebDriverWait(driver,30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
    WebElement passwordTexBox = driver.findElement(By.xpath("//input[@name='password']"));
    passwordTexBox.sendKeys(password);

  }

  public EmailHomePage clickSignIn(WebDriver driver) {
    WebElement signButton = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
    signButton.click();
    WebDriverWait wait = new WebDriverWait(driver,30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='TN bzz aHS-bnt']//div[@class='aio UKr6le']")));
    return PageFactory.initElements(driver,EmailHomePage.class);
  }

  public boolean isSignedOut(WebDriver driver) {
    return driver.findElements(By.xpath(("//div[@class='qZp31e']//*[@viewBox='0 0 74 37']"))).size()>0;
  }
}
