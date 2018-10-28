package com.appsenseca.pageobjects;

import com.appsenseca.utils.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailViewPage {


  public String getEmailSubjectText(WebDriver driver) {
    WebUtil.waitForElementVisible(driver,By.xpath("//h2[@class='hP'] [contains(text(),'Test')]"));
    return WebUtil.getElementText(driver,By.xpath("//h2[@class='hP'] [contains(text(),'Test')]"));
  }

  public String getEmailBodyText(WebDriver driver) {
    return WebUtil.getElementText(driver,By.xpath("//div[contains(text(),'Hello all Testers')]"));
  }
}
