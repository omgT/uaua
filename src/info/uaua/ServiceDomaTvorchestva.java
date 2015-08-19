package info.uaua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ServiceDomaTvorchestva {
	WebDriver driver;
	By clickOnServices = By.xpath("//li[3]//a[@class='sub']");
	By clickOnDomaTvorchestva_Service =  By.xpath(".//ul[@class = 'list-3']//a[@href='http://house-art.uaua.info/']");
	By clickOnDomaTvorchestva_Footer = By.xpath("html/body/footer//a[text()='Дома творчества']");
	By clickOnDomaTvorchestva_header = By.xpath(".//*[@class = 'sub']//a[@href='http://house-art.uaua.info/']");
	By clickOnDomaTvorchestva_Objects = By.xpath(".//*[@id='rd_search_form']//a[text()='Дома творчества']");
			
	
	public ServiceDomaTvorchestva(WebDriver driver) {
		this.driver = driver;
	}

	public ServiceDomaTvorchestva clickOnServices() {
		driver.findElement(clickOnServices).click();
		return this;
	}
	
	public ServiceDomaTvorchestva clickOnDomaTvorchestva_Service() {
		driver.findElement(clickOnDomaTvorchestva_Service).click();
		return this;
	}
	public ServiceDomaTvorchestva clickOnDomaTvorchestva_Footer() {
		driver.findElement(clickOnDomaTvorchestva_Footer).click();
		return this;
	}
	
	public ServiceDomaTvorchestva clickOnDomaTvorchestva_header() {
		driver.findElement(clickOnDomaTvorchestva_header).click();
		return this;
	}
	
	public ServiceDomaTvorchestva clickOnDomaTvorchestva_Objects() {
		driver.findElement(clickOnDomaTvorchestva_Objects).click();
		return this;
	}
	public ServiceDomaTvorchestva moveToServices() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(
				driver.findElement(By.xpath("//li[3]//a[@class='sub']")))
				.build().perform();
		return this;
	}
	
	
	
	
	
	
	
}