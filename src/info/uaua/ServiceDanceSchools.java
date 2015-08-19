package info.uaua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ServiceDanceSchools {
	WebDriver driver;
	By clickOnServices = By.xpath("//li[3]//a[@class='sub']");
	By clickOnDanceSchools_Service =  By.xpath(".//ul[@class = 'list-3']//a[@href='http://dance.uaua.info/']");
	By clickOnDanceSchools_Footer = By.xpath("html/body/footer//a[text()='Ўколы танцев']");
	By clickOnDanceSchools_header = By.xpath(".//*[@class = 'sub']//a[text()='Ўколы танцев']");
	By clickOnDanceSchools_Objects = By.xpath(".//*[@id='rd_search_form']//a[text()='Ўколы танцев']");
			
	
	public ServiceDanceSchools(WebDriver driver) {
		this.driver = driver;
	}

	public  ServiceDanceSchools clickOnServices() {
		driver.findElement(clickOnServices).click();
		return this;
	}
	
	public  ServiceDanceSchools clickOnDanceSchools_Service() {
		driver.findElement(clickOnDanceSchools_Service).click();
		return this;
	}
	public  ServiceDanceSchools clickOnDanceSchools_Footer() {
		driver.findElement(clickOnDanceSchools_Footer).click();
		return this;
	}
	
	public  ServiceDanceSchools clickOnDanceSchools_header() {
		driver.findElement(clickOnDanceSchools_header).click();
		return this;
	}
	
	public  ServiceDanceSchools clickOnDanceSchools_Objects() {
		driver.findElement(clickOnDanceSchools_Objects).click();
		return this;
	}
	public  ServiceDanceSchools moveToServices() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(
				driver.findElement(By.xpath("//li[3]//a[@class='sub']")))
				.build().perform();
		return this;
	}
	
	
}
