package info.uaua;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ServiceRazvitiePoMesjacam {
WebDriver driver;
	
	
	By clickOnVse = By.xpath(".//*[@class = 'sub']//a[contains(text(), '—ервисы')]");
	By choose2 = By.partialLinkText("2 мес€ца");
	By choosePoMesjacam = By.partialLinkText("по мес€цам");
	By clickMonth = By.id("CurSelAge");
	
	
	
	
	public ServiceRazvitiePoMesjacam chooseMonth() {
		driver.manage().window().maximize();
		int month = 0;
		Actions builder = new Actions(driver); 
		builder.sendKeys(Keys.chord(Keys.CONTROL, "-")).build().perform();
		for (month = 1; month<=12; month ++){
			Actions actions = new Actions(driver);
			actions.moveToElement(
					driver.findElement(By.xpath(".//*[@id='CurSelAge']")))
					.build().perform();
		driver.findElement(By.xpath(".//*[@id='selectAgeWrapper']/ul/li["
				+ month
				+ "]/a")).click();
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String pathScreen = "d:\\uaua.info\\Screens\\ScreensFF37.0.1\\RazvitiePoMesjacam\\";
			String screenFormat = ".jpg";
			FileUtils.copyFile(scrFile, new File(pathScreen+month+screenFormat));
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
		return this;
		}
	public ServiceRazvitiePoMesjacam moveToMonth() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(
				driver.findElement(By.xpath(".//*[@id='CurSelAge']")))
				.build().perform();
		return this;
	}
	
	public ServiceRazvitiePoMesjacam choosePoMesjacam() {
		driver.findElement(choosePoMesjacam).click();
		return this;
	}
	public ServiceRazvitiePoMesjacam clickOnVse() {
		driver.findElement(clickOnVse).click();
		return this;
		
	}
	
	
	public ServiceRazvitiePoMesjacam(WebDriver driver) {
		this.driver = driver;
	}
	
	public ServiceRazvitiePoMesjacam makeScreen(String screen){
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String pathScreen = "d:\\uaua.info\\Screens\\ScreensFF37.0.1\\RazvitiePoMesjacam\\";
			String screenFormat = ".jpg";
			FileUtils.copyFile(scrFile, new File(pathScreen+screen+screenFormat));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
}
