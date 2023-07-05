package utilityPolicyBazaar;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Utility  {
	     //screenshot
		   public static void captureScreenshot(WebDriver driver,String myFile) throws IOException
		{
			
		   File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   File dest= new File("E:\\Selenium\\ScreenShots\\MySeleniumScreenShots"+myFile+".png");
		   FileHandler.copy(src, dest);
		   Reporter.log("taking screenshot", true);
		   Reporter.log("screenShot location is ... "+dest, true);
		}
		 // wait 
		public static void wait(int waitTime) throws InterruptedException {
			Reporter.log("waiting for "+waitTime+" milli sec", true);
			Thread.sleep(waitTime);
				
		}
		// scrolling
		public static void scrollIntoView(WebDriver driver,WebElement element) {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true)", element);
			Reporter.log("scrollingIntoView", true);
		}
		// Read data from excelSheet
		public static String readDataFromExcel(int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		
			FileInputStream myFile=new FileInputStream("E:\\Selenium\\Excelsheets\\TestingExcel.xlsx");
			
		String value = WorkbookFactory.create(myFile).getSheet("sheet1").getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
		}
		public static String readDataFromPropertyFile(String key) throws IOException  {
			Properties prop=new Properties();
			FileInputStream myFile=new FileInputStream("C:\\Users\\donga\\eclipse-workspace\\Feb18SeleniumStudy\\abc.properties");
			prop.load(myFile);
			String value = prop.getProperty(key);
			return value;
			
			
		}
		
}
