package com.appsenseca.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmailViewPage {


  public String getEmailSubjectText(WebDriver driver) {
    WebDriverWait wait = new WebDriverWait(driver,30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='hP'] [contains(text(),'Test')]")));
    WebElement subjectArea = driver.findElement(By.xpath("//h2[@class='hP'] [contains(text(),'Test')]"));
    return subjectArea.getText();

  }

  public String getEmailBodyText(WebDriver driver) {
    WebElement bodyArea = driver.findElement(By.xpath("//div[contains(text(),'Hello all Testers')]"));
    return bodyArea.getText();
  }
}
