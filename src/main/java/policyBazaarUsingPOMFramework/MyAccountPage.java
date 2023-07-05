package policyBazaarUsingPOMFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage
  {
	//variable
	@FindBy(xpath = "//div[@class='textCapitalize sc-ckVGcZ kWpXlQ']") private WebElement userName; 
	
	//constructor
	public MyAccountPage(WebDriver driver)
	{ 
		PageFactory.initElements(driver, this); 
	} 
	//methods
	public String getUserName() {
	String UN = userName.getText();
	return UN;
	
	}

    }
