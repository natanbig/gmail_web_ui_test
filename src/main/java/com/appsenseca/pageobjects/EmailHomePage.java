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
}
