package info.uaua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ServiceZhenskieKonsultasii {
	WebDriver driver;
	By clickOnServices = By.xpath("//li[3]//a[@class='sub']");
	By clickOnZhenskieKonsultasii_Service =  By.xpath(".//ul[@class = 'list-3']//a[@href='http://antenatal-consult.uaua.info/']");//ToDo
	By clickOnZhenskieKonsultasii_Footer = By.xpath("html/body/footer//a[text()='Женские консультации']");
	By clickOnZhenskieKonsultasii_header = By.xpath(".//*[@class = 'sub']//a[@href='http://antenatal-consult.uaua.info/']");//ToDo
	By clickOnZhenskieKonsultasii_Objects = By.xpath(".//*[@id='rd_search_form']//a[text()='Женские консультации']");
			
	
	public ServiceZhenskieKonsultasii(WebDriver driver) {
		this.driver = driver;
	}

	public ServiceZhenskieKonsultasii clickOnServices() {
		driver.findElement(clickOnServices).click();
		return this;
	}
	
	public ServiceZhenskieKonsultasii clickOnZhenskieKonsultasii_Service() {
		driver.findElement(clickOnZhenskieKonsultasii_Service).click();
		return this;
	}
	public ServiceZhenskieKonsultasii clickOnZhenskieKonsultasii_Footer() {
		driver.findElement(clickOnZhenskieKonsultasii_Footer).click();
		return this;
	}
	
	public ServiceZhenskieKonsultasii clickOnZhenskieKonsultasii_header() {
		driver.findElement(clickOnZhenskieKonsultasii_header).click();
		return this;
	}
	
	public ServiceZhenskieKonsultasii clickOnZhenskieKonsultasii_Objects() {
		driver.findElement(clickOnZhenskieKonsultasii_Objects).click();
		return this;
	}
	public ServiceZhenskieKonsultasii moveToServices() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(
				driver.findElement(By.xpath("//li[3]//a[@class='sub']")))
				.build().perform();
		return this;
	}
}
