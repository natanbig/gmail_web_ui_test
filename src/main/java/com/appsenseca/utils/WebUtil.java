package com.appsenseca.utils;

import com.appsenseca.pageobjects.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebUtil {
  public static SignInPage goToSignInPage(WebDriver driver) {
    driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&osid=1&service=mail&ss=1&ltmpl=default&rm=false&flowName=GlifWebSignIn&flowEntry=ServiceLogin&hl=en-GB");
    return PageFactory.initElements(driver, SignInPage.class );

  }

  public static void click(WebDriver driver, By locator) {
    WebElement element = driver.findElement(locator);
    element.click();
  }

  public static void waitForElementVisible(WebDriver driver, By locator) {
    WebDriverWait wait = new WebDriverWait(driver,30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public static boolean isElementExist(WebDriver driver, By locator) {
    return driver.findElements(locator).size()>0;
  }

  public static void sendKeys(WebDriver driver, By locator, String s) {
    WebElement element =driver.findElement(locator);
    element.clear();
    element.sendKeys(s);
  }

  public static String getElementText(WebDriver driver, By locator) {
    WebElement subjectArea = driver.findElement(locator);
    return subjectArea.getText();
  }
}
