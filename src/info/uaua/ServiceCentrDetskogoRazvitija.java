package info.uaua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ServiceCentrDetskogoRazvitija {

	WebDriver driver;
	By clickOnServices = By.xpath("//li[3]//a[@class='sub']");
	By clickOnCentrDetskogoRazvitija_Service =  By.xpath(".//ul[@class = 'list-3']//a[@href='http://kidscenter.uaua.info/']");
	By clickOnCentrDetskogoRazvitija_Footer = By.xpath("html/body/footer//a[text()='Центры детского развития']");
	By clickOnCentrDetskogoRazvitija_header = By.xpath(".//*[@class = 'sub']//a[text()='Центры детского развития']");
	By clickOnCentrDetskogoRazvitija_Objects = By.xpath(".//*[@id='rd_search_form']//a[text()='Центры детского развития']");
			
	
	public ServiceCentrDetskogoRazvitija(WebDriver driver) {
		this.driver = driver;
	}

	public ServiceCentrDetskogoRazvitija clickOnServices() {
		driver.findElement(clickOnServices).click();
		return this;
	}
	
	public ServiceCentrDetskogoRazvitija clickOnCentrDetskogoRazvitija_Service() {
		driver.findElement(clickOnCentrDetskogoRazvitija_Service).click();
		return this;
	}
	public ServiceCentrDetskogoRazvitija clickOnCentrDetskogoRazvitija_Footer() {
		driver.findElement(clickOnCentrDetskogoRazvitija_Footer).click();
		return this;
	}
	
	public ServiceCentrDetskogoRazvitija clickOnCentrDetskogoRazvitija_header() {
		driver.findElement(clickOnCentrDetskogoRazvitija_header).click();
		return this;
	}
	
	public ServiceCentrDetskogoRazvitija clickOnCentrDetskogoRazvitija_Objects() {
		driver.findElement(clickOnCentrDetskogoRazvitija_Objects).click();
		return this;
	}
	public ServiceCentrDetskogoRazvitija moveToServices() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(
				driver.findElement(By.xpath("//li[3]//a[@class='sub']")))
				.build().perform();
		return this;
	}
	
	
}
