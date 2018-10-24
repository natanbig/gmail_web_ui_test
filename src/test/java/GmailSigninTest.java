import com.appsenseca.pageobjects.EmailHomePage;
import com.appsenseca.pageobjects.SignInPage;
import com.appsenseca.utils.WebUtil;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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
    //    1.Go to Gmail website

    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&osid=1&service=mail&ss=1&ltmpl=default&rm=false&flowName=GlifWebSignIn&flowEntry=ServiceLogin&hl=en-GB");
//    Fill in username
    WebElement usernameTexBox =  driver.findElement(By.xpath("//input[@id='identifierId']"));
    usernameTexBox.sendKeys("forcepoint.test2");
    WebElement buttonNext = driver.findElement(By.xpath("//span[contains(text(),'Next')]"));
    buttonNext.click();
    WebDriverWait wait = new WebDriverWait(driver,30);
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
    WebElement passwordTexBox = driver.findElement(By.xpath("//input[@name='password']"));

    passwordTexBox.sendKeys("@p-DATA#1");
    Thread.sleep(1000);
    driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
//    Fill in password
//    click sign in
//    verify user did sign in

    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='TN bzz aHS-bnt']//div[@class='aio UKr6le']")));
    Assert.assertTrue("Inbox should exist",driver.findElements(By.xpath("//div[@class='TN bzz aHS-bnt']//div[@class='aio UKr6le']")).size()>0);


    //2.Click compose
    wait.until((ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[role='button'][gh='cm']"))));
    WebElement composeButton =driver.findElement(By.cssSelector("div[role='button'][gh='cm']"));
    composeButton.click();
    //3.Fill in recipient
    WebElement toTextArea =driver.findElement(By.xpath("//textarea[@role='combobox']"));
    toTextArea.sendKeys("forcepoint.test2@gmail.com");
    //4.Fill in subject
    WebElement subject = driver.findElement(By.xpath("//input[@placeholder='Subject']"));
    subject.sendKeys("Test send an email");
    final String subjectString = "Test send an email";
    //5.Fill in email body
    WebElement emailBody = driver.findElement(By.cssSelector("div[role='textbox'][tabindex='1']"));
    emailBody.sendKeys("Hello all Testers");
    final String emailBodyString = "Hello all Testers";
    //6.Click send
    WebElement sendButton = driver.findElement(By.cssSelector("div[role='button'][class='T-I J-J5-Ji aoO T-I-atl L3']"));
    sendButton.click();
    //7.Click Inbox again
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Inbox")));
    WebElement inboxLinkage = driver.findElement(By.partialLinkText("Inbox"));
    inboxLinkage.click();
    //8.Click email
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='bog']//span[@class='bqe'][contains(text(),'Test')]")));
    WebElement newEmail = driver.findElement(By.xpath("//span[@class='bog']//span[@class='bqe'][contains(text(),'Test')]"));
    newEmail.click();
//    //9.Verify the email and email body is correct
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[@class='hP'] [contains(text(),'Test')]")));
    WebElement subjectArea = driver.findElement(By.xpath("//h2[@class='hP'] [contains(text(),'Test')]"));
    String test1 = subjectArea.getText();
    Assert.assertEquals("Email subject should be the same",subjectString,subjectArea.getText());
    WebElement bodyArea = driver.findElement(By.xpath("//div[contains(text(),'Hello all Testers')]"));
    Assert.assertEquals("Email body should be the same", emailBodyString,bodyArea.getText());
//    //10.Sign out
    Thread.sleep(5000);
    WebElement profileButton = driver.findElement(By.xpath("//span[@class='gb_9a gbii']"));
    profileButton.click();
    WebElement  quitAccountButton = driver.findElement(By.id("gb_71"));
    quitAccountButton.click();
    //    verified user did sign out
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(("//div[@class='qZp31e']//*[@viewBox='0 0 74 37']"))));


    Assert.assertTrue("Choose an account should exist", driver.findElements(By.xpath(("//div[@class='qZp31e']//*[@viewBox='0 0 74 37']"))).size()>0);
  }

  @After
  public void tearDown(){
    driver.quit();
  }
}
