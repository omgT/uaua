package info.uaua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ServiceKyrsuDljaBeremenuh {
	WebDriver driver;
	By clickOnServices = By.xpath("//li[3]//a[@class='sub']");
	By clickOnKyrsuDljaBeremenuh_Service =  By.xpath(".//ul[@class = 'list-3']//a[@href='http://antenatal-classes.uaua.info/']");
	By clickOnKyrsuDljaBeremenuh_Footer = By.xpath("html/body/footer//a[text()='Курсы для беременных']");
	By clickOnKyrsuDljaBeremenuh_header = By.xpath(".//*[@class = 'sub']//a[@href='http://antenatal-classes.uaua.info/']");
	By clickOnKyrsuDljaBeremenuh_Objects = By.xpath(".//*[@id='rd_search_form']//a[text()='Курсы для беременных']");
			
	
	public ServiceKyrsuDljaBeremenuh(WebDriver driver) {
		this.driver = driver;
	}

	public ServiceKyrsuDljaBeremenuh clickOnServices() {
		driver.findElement(clickOnServices).click();
		return this;
	}
	
	public ServiceKyrsuDljaBeremenuh clickOnKyrsuDljaBeremenuh_Service() {
		driver.findElement(clickOnKyrsuDljaBeremenuh_Service).click();
		return this;
	}
	public ServiceKyrsuDljaBeremenuh clickOnKyrsuDljaBeremenuh_Footer() {
		driver.findElement(clickOnKyrsuDljaBeremenuh_Footer).click();
		return this;
	}
	
	public ServiceKyrsuDljaBeremenuh clickOnKyrsuDljaBeremenuh_header() {
		driver.findElement(clickOnKyrsuDljaBeremenuh_header).click();
		return this;
	}
	
	public ServiceKyrsuDljaBeremenuh clickOnKyrsuDljaBeremenuh_Objects() {
		driver.findElement(clickOnKyrsuDljaBeremenuh_Objects).click();
		return this;
	}
	public ServiceKyrsuDljaBeremenuh moveToServices() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(
				driver.findElement(By.xpath("//li[3]//a[@class='sub']")))
				.build().perform();
		return this;
	}
}
