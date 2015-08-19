package info.uaua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ServiceUslugi {
	WebDriver driver;
	By clickOnServices = By.xpath("//li[3]//a[@class='sub']");
	By clickOnUslugi_Service =  By.xpath(".//ul[@class = 'list-3']//a[@href='http://services.uaua.info/']");
	By clickOnUslugi_Footer = By.xpath("html/body/footer//a[text()='Услуги']");
	By clickOnUslugi_header = By.xpath(".//*[@class = 'sub']//a[text()='Услуги']");
	By clickOnUslugi_Objects = By.xpath(".//*[@id='rd_search_form']//a[text()='Услуги']");
			
	
	public ServiceUslugi(WebDriver driver) {
		this.driver = driver;
	}

	public ServiceUslugi clickOnServices() {
		driver.findElement(clickOnServices).click();
		return this;
	}
	
	public ServiceUslugi clickOnUslugi_Service() {
		driver.findElement(clickOnUslugi_Service).click();
		return this;
	}
	public ServiceUslugi clickOnUslugi_Footer() {
		driver.findElement(clickOnUslugi_Footer).click();
		return this;
	}
	
	public ServiceUslugi clickOnUslugi_header() {
		driver.findElement(clickOnUslugi_header).click();
		return this;
	}
	
	public ServiceUslugi clickOnUslugi_Objects() {
		driver.findElement(clickOnUslugi_Objects).click();
		return this;
	}
	public ServiceUslugi moveToServices() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(
				driver.findElement(By.xpath("//li[3]//a[@class='sub']")))
				.build().perform();
		return this;
	}
}
