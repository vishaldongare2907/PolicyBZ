package policyBazaarUsingPOMFramework;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilityPolicyBazaar.Utility;

public class LoginPage {
	
	//variable
	@FindBy(xpath = "//a[text()='Sign in']") private WebElement signInButtonHomePage;
	@FindBy(xpath = "(//input[@type='number'])[2]")private WebElement mobileNumberFiled;
	@FindBy(xpath = "(//span[text()='Sign in with Password'])[2]") private WebElement signInWithPassword;
	@FindBy(name = "password") private WebElement passwordField;
	@FindBy(xpath = "//span[text()='Sign in']") private WebElement signInButton;
	@FindBy(xpath = "//div[text()='My Account']") private WebElement myAccountButton;
	@FindBy(xpath = "//span[text()=' My profile ']")private WebElement myProfile;
	
	//Constructor
	public LoginPage(WebDriver driver)
	{
	 PageFactory.initElements(driver, this);
	}
    
	//methods
	public void clickOnHomePageSignInButton()
	{
	signInButtonHomePage.click();
	}
	public void enterMobileNum() throws EncryptedDocumentException, IOException
	{
	mobileNumberFiled.sendKeys(Utility.readDataFromExcel(0, 0));
	}
	public void clickOnSignInWithPassword()
	{
	signInWithPassword.click();
	}
	public void enterPassword() throws EncryptedDocumentException, IOException
	{
	passwordField.sendKeys(Utility.readDataFromExcel(0, 1));
	}
	public void clickOnSignInButton()
	{
	signInButton.click();
	}
	public void clickOnMyAccountButton()
	{
	myAccountButton.click();
	}
	public void clickOnMyProfileButton()
	{
	myProfile.click();
	}
	
}
