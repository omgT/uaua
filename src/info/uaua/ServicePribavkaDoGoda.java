package info.uaua;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ServicePribavkaDoGoda {
	WebDriver driver;
	By clickOnVse = By.xpath(".//*[@class = 'sub']//a[contains(text(), 'Сервисы')]");
	By choosePribavkaVesa = By.partialLinkText("Прибавка");
	By chooseBoy = By.partialLinkText("Мальчик");
	By chooseGirl = By.partialLinkText("Девочка");
	
	
	public ServicePribavkaDoGoda chooseBoy() {
		driver.findElement(chooseBoy).click();
		return this;
	}
	public ServicePribavkaDoGoda chooseGirl() {
		driver.findElement(chooseGirl).click();
		return this;
	}
	
	public ServicePribavkaDoGoda choosePribavkaVesa() {
		driver.findElement(choosePribavkaVesa).click();
		return this;
	}
	
	public ServicePribavkaDoGoda makeScreen(String screen){
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String pathScreen = "d:\\uaua.info\\Screens\\ScreensFF37.0.1\\Pribavka Vesa\\";
			String screenFormat = ".jpg";
			FileUtils.copyFile(scrFile, new File(pathScreen+screen+screenFormat));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	public ServicePribavkaDoGoda clickOnVse() {
		driver.findElement(clickOnVse).click();
		return this;
		
	}
	public ServicePribavkaDoGoda(WebDriver driver) {
		this.driver = driver;
	}
}
