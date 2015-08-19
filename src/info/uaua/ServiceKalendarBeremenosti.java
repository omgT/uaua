package info.uaua;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import data.CommonMethods;
import data.PropertiesDB;
import data.Autorization;
public class ServiceKalendarBeremenosti {
	WebDriver driver;
	
	By clickDays= By.xpath(".//*[@id='sel-days']/span");
	By clickAllServices= By.xpath("html/body//a[@class = 'sub'][contains(text(), 'Сервисы')]");
	//By clickKalendBerem_Services= By.xpath("html/body/div[3]//a[text()='Календарь беременности']");
	By clickKalendBerem_Services= By.xpath(".//*[@class = 'list-3']//*[@href = 'http://www.uaua.info/beremenost/']");
	By clickKalendBerem_Footer= By.xpath("html/body/footer//a[text() = 'Календарь беременности']");
	By chooseDate= By.xpath(".//*[@id='select-days']/li[7]"); //день
	By clickMonths= By.xpath(".//*[@id='sel-months']/span");
	By chooseMonths= By.xpath(".//*[@id='select-months']/li[3]"); //3 - март
	By clickYears= By.xpath(".//*[@id='sel-years']/span");
	By chooseYear= By.xpath(".//*[@id='select-years']/li[3]"); // 3 - 2013
	
	By clickRasschitat= By.xpath(".//*[@id='left_col']//input[@type = 'submit']");
	
	
	public ServiceKalendarBeremenosti clickRasschitat() {
		driver.findElement(clickRasschitat).click();
		return this;
		}
	
	public ServiceKalendarBeremenosti perehodCheresService() {
		driver.findElement(clickAllServices).click();
		driver.findElement(clickKalendBerem_Services).click();
		return this;
		}
	
	public ServiceKalendarBeremenosti perehodCheresFooter() {
		driver.findElement(clickKalendBerem_Footer).click();
		return this;
		}
	

	
	public ServiceKalendarBeremenosti chooseIncorrectDay() {
	
	driver.findElement(clickDays).click();
	driver.findElement(chooseDate).click();
	
	driver.findElement(clickMonths).click();
	driver.findElement(chooseMonths).click();
	
	driver.findElement(clickYears).click();
	driver.findElement(chooseYear).click();
	
	return this;
	}
	
	public ServiceKalendarBeremenosti chooseDay() {
		
		driver.findElement(clickAllServices).click();
		driver.findElement(clickKalendBerem_Services).click();
		
		driver.findElement(clickDays).click();
		driver.findElement(chooseDate).click();
		
		driver.findElement(clickMonths).click();
		driver.findElement(chooseMonths).click();
		
		driver.findElement(clickYears).click();
		driver.findElement(By.xpath(".//*[@id='select-years']/li[1]")).click();
		
		return this;
	}
	
	
	public ServiceKalendarBeremenosti makeScreen(String screen){
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String pathScreen = "d:\\uaua.info\\Screens\\ScreensFF37.0.1\\Services\\Календарь беременности\\";
			String screenFormat = ".jpg";
			FileUtils.copyFile(scrFile, new File(pathScreen+screen+screenFormat));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	
	public ServiceKalendarBeremenosti(WebDriver driver) {
		this.driver = driver;
	}
}
