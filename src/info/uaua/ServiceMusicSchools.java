package info.uaua;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class ServiceMusicSchools {
	WebDriver driver;
	By clickOnServices = By.xpath("//li[3]//a[@class='sub']");
	By clickOnMusicSchools_Service =  By.xpath(".//ul[@class = 'list-3']//a[@href='http://musicschool.uaua.info/']");
	By clickOnMusicSchools_Footer = By.xpath("html/body/footer//a[text()='Музыкальные школы']");
	By clickOnMusicSchools_header = By.xpath(".//*[@class = 'sub']//a[text()='Музыкальные школы']");
	By clickOnMusicSchools_Objects = By.xpath(".//*[@id='rd_search_form']//a[text()='Музыкальные школы']");
			
	
	public ServiceMusicSchools(WebDriver driver) {
		this.driver = driver;
	}

	public ServiceMusicSchools clickOnServices() {
		driver.findElement(clickOnServices).click();
		return this;
	}
	
	public ServiceMusicSchools clickOnMusicSchools_Service() {
		driver.findElement(clickOnMusicSchools_Service).click();
		return this;
	}
	public ServiceMusicSchools clickOnMusicSchools_Footer() {
		driver.findElement(clickOnMusicSchools_Footer).click();
		return this;
	}
	
	public ServiceMusicSchools clickOnMusicSchools_header() {
		driver.findElement(clickOnMusicSchools_header).click();
		return this;
	}
	
	public ServiceMusicSchools clickOnMusicSchools_Objects() {
		driver.findElement(clickOnMusicSchools_Objects).click();
		return this;
	}
	public ServiceMusicSchools moveToServices() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(
				driver.findElement(By.xpath("//li[3]//a[@class='sub']")))
				.build().perform();
		return this;
	}
}
