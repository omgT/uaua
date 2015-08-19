package info.uaua;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ServiceKalendarProvivok {
	WebDriver driver;
	By clickOnVse = By.xpath(".//*[@class = 'sub']//a[contains(text(), 'Сервисы')]");
	By chooseKalendarPrivivok = By.partialLinkText("прививок");
	
	
	
	
	public ServiceKalendarProvivok chooseKalendarPrivivok() {
		driver.findElement(chooseKalendarPrivivok).click();
		return this;
	}
	
	public ServiceKalendarProvivok makeScreen(String screen){
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String pathScreen = "d:\\uaua.info\\Screens\\ScreensFF37.0.1\\KalendarPrivivok\\";
			String screenFormat = ".jpg";
			FileUtils.copyFile(scrFile, new File(pathScreen+screen+screenFormat));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	public ServiceKalendarProvivok clickOnVse() {
		driver.findElement(clickOnVse).click();
		return this;
		
	}
	public ServiceKalendarProvivok(WebDriver driver) {
		this.driver = driver;
	}
}
