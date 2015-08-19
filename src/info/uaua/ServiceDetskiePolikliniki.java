package info.uaua;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class ServiceDetskiePolikliniki {
	WebDriver driver;
	By clickOnServices = By.xpath("//li[3]//a[@class='sub']");
	//By clickOnDetskieBolnitsuPolikliniki_Header = By.xpath("html/body/div[3]/header/nav[1]/ul/li[3]/ul/li[4]/a"); //пока будет так
	By clickOnDetskieBolnitsuPolikliniki_Header = By.xpath(".//*[@class = 'sub']//a[@href='http://baby-hospitals.uaua.info/']");
	By clickOnDetskieBolnitsuPolikliniki_Footer = By.xpath("html/body/footer//a[text()='Детские поликлиники/больницы']"); 
	//By clickOnDetskieBolnitsuPolikliniki_Services = By.xpath("html/body/div[3]/div[1]/div/article/div[1]/ul/li[3]/a"); //ну не видит оно статический локатор
	By clickOnDetskieBolnitsuPolikliniki_Services = By.xpath(".//ul[@class = 'list-3']//a[@href='http://baby-hospitals.uaua.info/']");
	By clickOnDetskieBolnitsuPolikliniki_Objects = By.xpath(".//*[@id='rd_search_form']//a[text()='Детские поликлиники/больницы']");

	public ServiceDetskiePolikliniki(WebDriver driver) {
		this.driver = driver;
	}

	public ServiceDetskiePolikliniki clickOnServices() {
		driver.findElement(clickOnServices).click();
		return this;
	}

	public ServiceDetskiePolikliniki clickOnDetskieBolnitsuPolikliniki_Services() {
		driver.findElement(clickOnDetskieBolnitsuPolikliniki_Services).click();
		return this;
	}

	public ServiceDetskiePolikliniki clickOnDetskieBolnitsuPolikliniki_Footer() {
		driver.findElement(clickOnDetskieBolnitsuPolikliniki_Footer).click();
		return this;
	}

	public ServiceDetskiePolikliniki moveToServices() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(
				driver.findElement(By.xpath("//li[3]//a[@class='sub']")))
				.build().perform();
		return this;
	}
	

	public ServiceDetskiePolikliniki clickOnDetskieBolnitsuPolikliniki_Header() {
		driver.findElement(clickOnDetskieBolnitsuPolikliniki_Header).click();
		return this;
	}

	public ServiceDetskiePolikliniki clickOnDetskieBolnitsuPolikliniki_Objects() {
		driver.findElement(clickOnDetskieBolnitsuPolikliniki_Objects).click();
		return this;
	}
		
	
}
