package info.uaua;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ServiceOpredeleniePola {
WebDriver driver;
	
	By clickMomDays= By.xpath(".//*[@id='fertil_date']");
	By chooseMomMonth= By.xpath(".//*[@id='ui-datepicker-div']//*[@class = 'ui-datepicker-month']//*[contains(text(), 'янв.')]");
	By chooseMomYear= By.xpath(".//*[@id='ui-datepicker-div']//*[@class = 'ui-datepicker-year']//*[contains(text(), '2015')]");
	By chooseMomDate= By.xpath(".//*[@id='ui-datepicker-div']//*[contains(text(), '11')]");
	
	
	By clickChildDays= By.xpath(".//*[@id='birth_date']");
	By chooseChildMonth= By.xpath(".//*[@id='ui-datepicker-div']//*[contains(text(), 'янв.')]");
	By chooseChildYear= By.xpath(".//*[@id='ui-datepicker-div']//*[contains(text(), '2000')]");
	By chooseChildDate= By.xpath(".//*[@id='ui-datepicker-div']//*[contains(text(), '11')]");
	
	
	By saveResult= By.xpath(".//*[@id='left_col']//*[@class = 'save_rezalt']");
	
	By clickOpredelit= By.xpath(".//*[@id='ovul']//*[@class = 'btn_week_berem']");

	By clickAllServices= By.xpath("html/body//a[@class = 'sub'][contains(text(), '—ервисы')]");
	By clickOpredeleniePola_Services= By.xpath(".//*[@class='list-3']//*[@class='icon-services icon-determination-sex-child']");
	
	By clickVhod= By.xpath(".//*[@id='open_login_popup']");
	By emailField = By.xpath(".//*[@id='ua-welcom-window']//*[@class = 'uaww-email']");
	By passlField = By.xpath(".//*[@id='ua-welcom-window']//*[@class = 'uaww-pass']");
	By clickOnVhodUaua = By.xpath(".//*[@id='rrr1']");
	
	
	public ServiceOpredeleniePola chooseDates() {
		driver.findElement(clickAllServices).click();
		driver.findElement(clickOpredeleniePola_Services).click();
		
		driver.findElement(clickMomDays).click();
		driver.findElement(chooseMomMonth).click();
		driver.findElement(chooseMomYear).click();
		driver.findElement(chooseMomDate).click();
		
		driver.findElement(clickChildDays).click();
		driver.findElement(chooseChildMonth).click();
		driver.findElement(chooseChildYear).click();
		driver.findElement(chooseChildDate).click();
			
		return this;
		}
	

	
	public ServiceOpredeleniePola saveResult() {
		driver.findElement(saveResult).click();
		return this;
		}

	public ServiceOpredeleniePola clickOpredelit() {
		driver.findElement(clickOpredelit).click();
		return this;
		}

	public ServiceOpredeleniePola makeScreen(String screen){
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String pathScreen = "d:\\uaua.info\\Screens\\ScreensFF37.0.1\\Services\\ќпределение пола\\";
			String screenFormat = ".jpg";
			FileUtils.copyFile(scrFile, new File(pathScreen+screen+screenFormat));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public ServiceOpredeleniePola(WebDriver driver) {
		this.driver = driver;
	}
}
