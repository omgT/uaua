package info.uaua;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ServiceRaschetDatuRodov {

	WebDriver driver;
	
	By clickDays= By.xpath(".//*[@id='fertil_date']");
	By chooseMonth= By.xpath(".//*[@id='ui-datepicker-div']//*[@class = 'ui-datepicker-month']//*[contains(text(), 'Янв.')]");
	By chooseYear= By.xpath(".//*[@id='ui-datepicker-div']//*[@class = 'ui-datepicker-year']//*[contains(text(), '2015')]");
	By chooseDate= By.xpath(".//*[@id='ui-datepicker-div']//*[contains(text(), '18')]"); //день
	
	By clickOpredelitDaty= By.xpath(".//*[@id='beremenost']//*[@class ='btn_week_berem' ]");

	By clickAllServices= By.xpath("html/body//a[@class = 'sub'][contains(text(), 'Сервисы')]");
	By clickRaschetDatuRodov_Services= By.xpath(".//*[@class = 'list-3']//*[@class = 'icon-services icon-calculation-date-birth']");
	By clickPereschitat= By.xpath(".//*[@id='left_col']//a[@class = 'btn_recalc']");
	
	

		
	
	public ServiceRaschetDatuRodov chooseDate() {
		driver.findElement(clickAllServices).click();
		driver.findElement(clickRaschetDatuRodov_Services).click();
		driver.findElement(clickDays).click();
		
	
		driver.findElement(chooseMonth).click();
		driver.findElement(chooseYear).click();
		driver.findElement(chooseDate).click();
		return this;
		}
	
	public ServiceRaschetDatuRodov clickOpredelitDaty() {
		driver.findElement(clickOpredelitDaty).click();
		return this;
		}
	
	public ServiceRaschetDatuRodov clickPereschitat() {
		driver.findElement(clickPereschitat).click();
		return this;
		}
	

	
	public ServiceRaschetDatuRodov makeScreen(String screen){
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String pathScreen = "d:\\uaua.info\\Screens\\ScreensFF37.0.1\\Services\\Расчет даты родов\\";
			String screenFormat = ".jpg";
			FileUtils.copyFile(scrFile, new File(pathScreen+screen+screenFormat));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public ServiceRaschetDatuRodov(WebDriver driver) {
		this.driver = driver;
	}
}	
	

