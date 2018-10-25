import com.appsenseca.pageobjects.EmailHomePage;
import com.appsenseca.pageobjects.EmailViewPage;
import com.appsenseca.pageobjects.SignInPage;
import com.appsenseca.utils.WebUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GmailSigninTest {

  WebDriver driver = new ChromeDriver();
  @Test
  public void gmailLoginShouldBeSuccesfull() throws InterruptedException {

    /* Go to Gmail website */
    SignInPage signInPage = WebUtil.goToSignInPage(driver);
    /* Fill in username */
    signInPage.fillInUsername(driver,"forcepoint.test2");
    /* Fill in password */
    signInPage.fillInPassword(driver,"@p-DATA#1");
    /* click sign in */
    EmailHomePage emailHomePage =signInPage.clickSignIn(driver);
    /* verify user did sign in */
    Assert.assertTrue("Inbox should exist",emailHomePage.isInboxExist(driver));
    /* sign out */
    signInPage = emailHomePage.signOut(driver);
    /* verified user did sign out */
    Assert.assertTrue("Choose an account should exist", signInPage.isSignedOut(driver));
  }

  @Test
  public void gmailSendAndReceiveEmailTest() throws InterruptedException {
    /* 1.Go to Gmail website */
    SignInPage signInPage = WebUtil.goToSignInPage(driver);
    /* Fill in username */
    signInPage.fillInUsername(driver,"forcepoint.test2");
    /* Fill in password */
    signInPage.fillInPassword(driver,"@p-DATA#1");
    /* click sign in */
    EmailHomePage emailHomePage =signInPage.clickSignIn(driver);
    /* 2.Click compose */
    emailHomePage.clickComposeButton(driver);
    /* 3.Fill in recipient */
    emailHomePage.fillingRecipient(driver,"forcepoint.test2@gmail.com");
    /* 4.Fill in subject */
    emailHomePage.fillingSubject(driver,"Test send an email");
    final String subjectString = "Test send an email";
    /* 5.Fill in email body */
    emailHomePage.fillingEmailBodyMessage(driver,"Hello all Testers");
    final String emailBodyString = "Hello all Testers";
    /* 6.Click send */
    emailHomePage.clickEmailSend(driver);
    Thread.sleep(5000);
    /* 7.Click Inbox again */
    emailHomePage.clickInboxWithNewEmail(driver,"Inbox");
    /* 8.Click email */
    EmailViewPage emailViewPage = emailHomePage.clickOnNewEmail(driver);
    /* //9.Verify the email and email body is correct */
    String subject =emailViewPage.getEmailSubjectText(driver);
    Assert.assertEquals("Email subject should be the same",subjectString,subject);
    String bodyArea = emailViewPage.getEmailBodyText(driver);
    Assert.assertEquals("Email body should be the same", emailBodyString,bodyArea);
    /* //10.Sign out */
    signInPage = emailHomePage.signOut(driver);

  }

  @After
  public void tearDown(){
    driver.quit();
  }
}
