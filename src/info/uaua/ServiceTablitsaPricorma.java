package info.uaua;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ServiceTablitsaPricorma {
	
	WebDriver driver;
	
	
	By clickOnVse = By.xpath(".//*[@class = 'sub']//a[contains(text(), 'Сервисы')]");

	
	
	By clickTablitsaPricorma = By.partialLinkText("Таблица прикорма");
	By clickMOZ = By.partialLinkText("МОЗ");
	
	
	public ServiceTablitsaPricorma clickOnVse() {
		driver.findElement(clickOnVse).click();
		return this;
	}
	
	public ServiceTablitsaPricorma clickTablitsaPricorma() {
		driver.findElement(clickTablitsaPricorma).click();
		return this;
	}
	public ServiceTablitsaPricorma clickMOZ() {
		driver.findElement(clickMOZ).click();
		return this;
	}
	public ServiceTablitsaPricorma(WebDriver driver) {
		this.driver = driver;
	}
	
	public ServiceTablitsaPricorma makeScreen(String screen){
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String pathScreen = "d:\\uaua.info\\Screens\\ScreensFF37.0.1\\TablitsaPricorma\\";
			String screenFormat = ".jpg";
			FileUtils.copyFile(scrFile, new File(pathScreen+screen+screenFormat));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
}
