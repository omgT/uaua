package info.uaua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ServiceSchools {
	WebDriver driver;
	By clickOnServices = By.xpath("//li[3]//a[@class='sub']");
	By clickOnSchools_Service =  By.xpath("html/body/div[2]/header//a[@href = 'http://school.uaua.info/']");
	By clickOnSchools_Footer = By.xpath("html/body/footer//a[text()='Ўколы']");
	By clickOnSchools_header = By.xpath(".//*[@class = 'sub']//a[text()='Ўколы']");
	By clickOnSchools_Objects = By.xpath(".//*[@id='rd_search_form']//a[text()='Ўколы']");
			
	
	public ServiceSchools(WebDriver driver) {
		this.driver = driver;
	}

	public ServiceSchools clickOnServices() {
		driver.findElement(clickOnServices).click();
		return this;
	}
	
	public ServiceSchools clickOnSchools_Service() {
		driver.findElement(clickOnSchools_Service).click();
		return this;
	}
	public ServiceSchools clickOnSchools_Footer() {
		driver.findElement(clickOnSchools_Footer).click();
		return this;
	}
	
	public ServiceSchools clickOnSchools_header() {
		driver.findElement(clickOnSchools_header).click();
		return this;
	}
	
	public ServiceSchools clickOnSchools_Objects() {
		driver.findElement(clickOnSchools_Objects).click();
		return this;
	}
	public ServiceSchools moveToServices() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(
				driver.findElement(By.xpath("//li[3]//a[@class='sub']")))
				.build().perform();
		return this;
	}
	
}
