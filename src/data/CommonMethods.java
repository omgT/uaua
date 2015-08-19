package data;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
public  abstract class CommonMethods implements Autorization, PropertiesDB{
	
	
	public static void correctMailAutorisation(WebDriver driver)   {
		driver.findElement(clickOnAutorization).click();	
		WebElement emailFieldForm = driver.findElement(emailField);
		
		emailFieldForm.click();
		emailFieldForm.sendKeys(correctLogin);
		
		WebElement passFieldForm = driver.findElement(passlField);
		passFieldForm.click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;

		String url = (String)js.executeScript("return navigator.userAgent;");
		if (url.contains("karasuk")){
		passFieldForm.sendKeys(correctPass);
		}
		else {
			passFieldForm.sendKeys(correctPassProd);
		}
		driver.findElement(clickOnVhodUaua).click();
		
	}
	
	
	public static void makeScreen(WebDriver driver, String folder, String screenName ) throws IOException{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		

		String browser = (String)js.executeScript("return navigator.userAgent;");
		
		
			if ( browser.contains("Firefox") ) {
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(screenDir + "Firefox\\"+ folder+screenName +".jpg")); 
			
			} else if ( browser.contains("Chrome/43") && !browser.contains("OPR/") ){
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(screenDir+"\\Chrome\\"+ folder+ screenName +".jpg")); 
				
			} else if ( browser.contains("rv:11") ){
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(screenDir+"\\IE\\"+ folder+ screenName +".jpg")); 
				
			} else if ( browser.contains("OPR/") ){
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(screenDir+"\\Opera\\"+ folder+ screenName +".jpg")); 
		
			/*	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				File newFile = new File("d:\\UaUaScreens\\Opera\\"+ folder+ screenName +".jpg");*/
			} else if ( browser.contains("Safari/534") ) {
				File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(scrFile, new File(screenDir+"\\Safari\\"+ folder+ screenName +".jpg")); 
	
			} else {
				System.out.println("false");
			}
		}
	
	
	
	public static void moveTo(WebDriver driver, String locator) { //наведение на элемент
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath(locator))).build().perform();
	}
	
	synchronized public static void navigateBack(WebDriver driver) {
		driver.navigate().back();
	}
	
	synchronized public static void verifyStaticElements(WebDriver driver){
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String url = (String)js.executeScript("return window.location.href;");
		if (url.contains("forum")){
			driver.findElement(By.xpath(".//*[@class = 'wide_carusel']"));
			driver.findElement(By.xpath(".//*[@class = 'login-block']"));
			driver.findElement(By.xpath(".//*[@class = 'most-recent-title']"));

			driver.findElement(By.xpath(".//*[@id='Panel']"));
			driver.findElement(By.xpath(".//*[@id='footForum']"));
			driver.findElement(By.xpath(".//*[@id='Content']"));
			driver.findElement(By.xpath(".//*[@id='Menu']"));	
		
		}
		
		else {
		driver.findElement(By.xpath(".//*[@class = 'content-wrapper']"));	
		driver.findElement(By.xpath(".//*[@class = 'right-column']"));
		driver.findElement(By.xpath(".//*[@class = 'wide_carusel']"));
		driver.findElement(By.xpath(".//*[@class = 'main-nav cf']")); 
		driver.findElement(By.xpath(".//img[@alt = 'uaua.info']")); 
		driver.findElement(By.xpath(".//*[@class = 'search-field']"));
		driver.findElement(By.xpath(".//*[@class = 'content-column']"));
		driver.findElement(By.xpath(".//*[@class = 'speccorners-title']"));
		driver.findElement(By.xpath(".//*[@class = 'doc_ask']"));
		
		}

	}
	

	
	
	
	
	
	
	
	
	
}
