import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class GmailSigninTest {
  WebDriver driver = new ChromeDriver();
  @Test
  public void gmailLoginShouldBeSuccesfull() throws InterruptedException {
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
//    sign out
      WebElement profileButton = driver.findElement(By.xpath("//span[@class='gb_9a gbii']"));
      profileButton.click();
      WebElement  quitAccountButton = driver.findElement(By.id("gb_71"));
      quitAccountButton.click();

      //    verified user did sign out
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("yDmH0d")));


    Assert.assertTrue("Choose an account should exist", driver.findElements(By.id("yDmH0d")).size()>0);
  }

  @After
  public void tearDown(){
    driver.quit();
  }
}
