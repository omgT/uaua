package info.uaua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ServiceRoddoma {
	WebDriver driver;
	By clickOnServices = By.xpath("//li[3]//a[@class='sub']");
	By clickOnRoddoma_Service =  By.xpath(".//ul[@class = 'list-3']//a[@href='http://roddom.uaua.info/']");
	By clickOnRoddoma_Footer = By.xpath("html/body/footer//a[text()='Роддома']");
	By clickOnRoddoma_header = By.xpath(".//*[@class = 'sub']//a[text()='Роддома']");
	By clickOnRoddoma_Objects = By.xpath(".//*[@id='rd_search_form']//a[text()='Роддома']");
			
	
	public ServiceRoddoma(WebDriver driver) {
		this.driver = driver;
	}

	public ServiceRoddoma clickOnServices() {
		driver.findElement(clickOnServices).click();
		return this;
	}
	
	public ServiceRoddoma clickOnRoddoma_Service() {
		driver.findElement(clickOnRoddoma_Service).click();
		return this;
	}
	public ServiceRoddoma clickOnRoddoma_Footer() {
		driver.findElement(clickOnRoddoma_Footer).click();
		return this;
	}
	
	public ServiceRoddoma clickOnRoddoma_header() {
		driver.findElement(clickOnRoddoma_header).click();
		return this;
	}
	
	public ServiceRoddoma clickOnRoddoma_Objects() {
		driver.findElement(clickOnRoddoma_Objects).click();
		return this;
	}
	public ServiceRoddoma moveToServices() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(
				driver.findElement(By.xpath("//li[3]//a[@class='sub']")))
				.build().perform();
		return this;
	}
}
