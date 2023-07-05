package testPolicyBazaar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import policyBazaarUsingPOMFramework.LoginPage;
import policyBazaarUsingPOMFramework.MyAccountPage;
import utilityPolicyBazaar.Utility;


public class testPolicyPB1001 extends Base
{
	LoginPage login;
	MyAccountPage acc;
	@ BeforeClass
	public void launchPolicyBazaar() {
		launchBrowser();
		login=new LoginPage(driver);
		acc=new MyAccountPage(driver);
		}
	@BeforeMethod
	public void loginInApplication() throws InterruptedException, EncryptedDocumentException, IOException {
		login.clickOnHomePageSignInButton();
		Utility.wait(3000);
		login.enterMobileNum();
		Utility.wait(3000);
		login.clickOnSignInWithPassword();
		Utility.wait(3000);
		login.enterPassword();
		Utility.wait(3000);
		login.clickOnSignInButton();
		Utility.wait(3000);
		login.clickOnMyAccountButton();
		Utility.wait(3000);
		login.clickOnMyProfileButton();
		Utility.wait(3000);
		Set<String> allId = driver.getWindowHandles();
		ArrayList<String>al=new ArrayList<>(allId);
		String mainPageId = al.get(0);
		String childPageId = al.get(1);
		driver.switchTo().window(childPageId);
		Utility.wait(3000);
		
		
		
	}
  @Test
  public void verifyUserName() throws EncryptedDocumentException, IOException {
	  
		String actualUN = acc.getUserName();
		String ExpUN = Utility.readDataFromExcel(0, 2);
		Assert.assertEquals(actualUN,ExpUN,"TC fail because actual and expected not matching" );
		
  }
}
