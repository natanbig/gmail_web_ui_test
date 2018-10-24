package com.appsenseca.utils;

import com.appsenseca.pageobjects.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WebUtil {
  public static SignInPage goToSignInPage(WebDriver driver) {
    driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&osid=1&service=mail&ss=1&ltmpl=default&rm=false&flowName=GlifWebSignIn&flowEntry=ServiceLogin&hl=en-GB");
    return PageFactory.initElements(driver, SignInPage.class );

  }
}
