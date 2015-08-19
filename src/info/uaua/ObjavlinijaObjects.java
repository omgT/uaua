package info.uaua;
import data.Autorization;
import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ObjavlinijaObjects   implements Autorization{
	WebDriver driver;
	public String chooseCity = "Москва";
	public String advType = "Ищу";
	public String chooseCategory = "Одежда";
	
	
	By clickOnObjavlenijaPage = By.xpath("html/body//*[contains(text(), 'Объявления')]");
	
	By clickLastPage= By.xpath(".//div[@class='board']//a[@class = 'list_next']");
	By clickFirstPage= By.xpath(".//div[@class='board']//a[@class = 'list_prev']");
	
	By clickOnVse =  By.xpath("html/body//a[@class = 'active']");
	By clickOnProdaju =  By.xpath(".//a[contains(text(), 'Продаю')]");
	By clickOnOtdaju =  By.xpath(".//a[contains(text(), 'Отдаю')]");
	By clickOnKuplju =  By.xpath(".//a[contains(text(), 'Куплю')]");
	By clickOnFindKategory =  By.xpath(".//a[contains(text(), 'Ищу')]");
	
	
	By clickOnAddObyavlenia = By.xpath(".//*[@class= 'add_obyavlenia']");
	
	By fieldZagolovok = By.xpath(".//*[@id='title']");
	By countryField = By.xpath(".//*[@id='country']");
	By cityField = By.xpath(".//*[@id='city']");
	By typeField = By.xpath(".//*[@id='type']");
	By categoryField = By.xpath(".//*[@id='category']");
	By priceFrom = By.xpath(".//*[@id='advr_post_form']//*[@name='start_price']");
	By priceTo = By.xpath(".//*[@id='advr_post_form']//*[@name='end_price']");
	By choosePodarok = By.xpath(".//*[@id='advr_post_form']//*[@name='is_gift']");
	By textObjavlenija = By.xpath(".//*[@id='body']");
	By mainPhoto = By.xpath(".//*[@id='mainPhoto']");
	By clickSend = By.xpath(".//*[@id='advr_post_form']//*[@class = 'btn_send']");
	
	By addKeyWord = By.xpath(".//*[@id='t_keywords']");
	By cityFindField = By.xpath(".//*[@id='t_city']");
	By typeFindField = By.xpath(".//*[@id='t_obyava']");
	By priceFromFindField = By.xpath(".//*[@id='t_cena_ot']");
	By priceToFindField = By.xpath(".//*[@id='t_cena_do']");
	By categoryFindField = By.xpath(".//*[@id='t_tovar']");
	By photoCheckBox = By.xpath(".//*[@id='search_obyavlenia']//*[@type = 'checkbox']");
	By clickFind= By.xpath(".//*[@id='search_obyavlenia']//*[@class = 'img_button_128_26']");
	
	By findFirstElement = By.xpath(".//*[@id='firstrow0']");
	By clickDelete = By.xpath("html/body//a[text()='Удалить']");
	
	
	public ObjavlinijaObjects clickOnFindedAdd() {
		driver.findElement(By.xpath(".//*[@id='firstrow0']/td[3]/a")).click();
		
		/*String zagolovok = "test:!@#$%^&*()_+/.,><]`";
		driver.findElement(By.xpath(".//*[@id='firstrow0']//a[text()='"
				+ zagolovok
				+ "']")).click();*/
		return this;
	}
	
	public ObjavlinijaObjects clickDelete() {
		driver.findElement(clickDelete).click();
		
		return this;
	}
	
	public ObjavlinijaObjects findAddedObyavlenia() {
		String keyWord = "test";
		String priceFrom = "0";
		String priceTo= "10000";
		
		WebElement keyWordField = driver.findElement(addKeyWord);
		keyWordField.sendKeys(keyWord);
		
		Select cityFind = new Select(driver.findElement(cityFindField));
		assertFalse(cityFind.isMultiple()); 
		assertEquals(116, cityFind.getOptions().size());
		cityFind.selectByVisibleText(chooseCity);
		
		Select typeFind = new Select(driver.findElement(typeFindField));
		assertFalse(typeFind.isMultiple()); 
		assertEquals(5, typeFind.getOptions().size());
		typeFind.selectByVisibleText(advType);
		
		WebElement priceFromFind = driver.findElement(priceFromFindField);
		priceFromFind.sendKeys(priceFrom);
		
		WebElement priceToFind = driver.findElement(priceToFindField);
		priceToFind.sendKeys(priceTo);
		
		Select categoryFind = new Select(driver.findElement(categoryFindField));
		assertFalse(categoryFind.isMultiple()); 
		assertEquals(25, categoryFind.getOptions().size());
		categoryFind.selectByVisibleText(chooseCategory);
		
		WebElement airbags = driver.findElement(photoCheckBox);
		 if (!airbags.isSelected())
			 airbags.click();
		 assertTrue(airbags.isSelected());
		 
		 driver.findElement(clickFind).click(); 
		 
		 WebElement message = driver.findElement(findFirstElement);
			String messageText = message.getText();
			assertTrue(messageText.contains(keyWord));
		 
		return this;
	}
	
	
	public ObjavlinijaObjects addCorrectObyavlenia() {
		
		String zagolovok = "test:!@#$%^&*()_+/.,><]`";
		String startPrice = "200";
		String endPrice = "5000";
		String texrtAdd = "Lorem ipsum dolor sit amet, vis ei persecuti disputando, sed in sale detraxit "
				+ "incorrupte. :!@#$%^&*()_+/.,>`<] съешь же ещё этих мягких французских булок, да выпей чаю";
		String adressOfPackage = "D:\\workspace\\UauaHeader\\img\\main.jpg";
		
		
		WebElement fieldFormZagolovok = driver.findElement(fieldZagolovok);
		fieldFormZagolovok.sendKeys(zagolovok);   
	
		Select country = new Select(driver.findElement(countryField));
			assertFalse(country.isMultiple()); 
			assertEquals(179, country.getOptions().size());
			country.selectByVisibleText("Россия");

		Select city = new Select(driver.findElement(cityField));
			assertFalse(city.isMultiple()); 
			city.selectByVisibleText(chooseCity);
		
		Select type = new Select(driver.findElement(typeField));
			assertFalse(type.isMultiple()); 
			assertEquals(5, type.getOptions().size());
			type.selectByVisibleText(advType);
		
		Select category = new Select(driver.findElement(categoryField));
			assertFalse(category.isMultiple()); 
			assertEquals(25, category.getOptions().size());
			category.selectByVisibleText(chooseCategory);
			
		WebElement priceFromField = driver.findElement(priceFrom);
			priceFromField.sendKeys(startPrice);
			
		WebElement priceToField = driver.findElement(priceTo);
			priceToField.sendKeys(endPrice);
		 
		driver.findElement(choosePodarok).click(); 
		
		WebElement textToField = driver.findElement(textObjavlenija);
		textToField.sendKeys(texrtAdd);
		
		driver.findElement(mainPhoto).sendKeys(adressOfPackage);
		/*driver.findElement(otherPhoto).sendKeys(adressOfPackage);
		driver.findElement(otherPhoto).sendKeys(adressOfPackage);
		driver.findElement(otherPhoto).sendKeys(adressOfPackage);	*/ //TODO  изменить айдишники
		
		driver.findElement(clickSend).click();
		return this;
	}
	
	public ObjavlinijaObjects clickOnVse() {
		driver.findElement(clickOnVse).click();
		return this;
	}
	
	public ObjavlinijaObjects clickOnAddObyavlenia() {
		driver.findElement(clickOnAddObyavlenia).click();
		return this;
	}
	public ObjavlinijaObjects clickOnProdaju() {
		driver.findElement(clickOnProdaju).click();
		return this;
	}
	public ObjavlinijaObjects clickOnOtdaju() {
		driver.findElement(clickOnOtdaju).click();
		return this;
	}
	public ObjavlinijaObjects clickOnKuplju() {
		driver.findElement(clickOnKuplju).click();
		return this;
	}
	public ObjavlinijaObjects clickOnFindKategory() {
		driver.findElement(clickOnFindKategory).click();
		return this;
	}
	
	public ObjavlinijaObjects makeScreen(String screen){
		try {
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String pathScreen = "d:\\uaua.info\\Screens\\ScreensFF37.0.1\\Objavlenija\\";
			String screenFormat = ".jpg";
			FileUtils.copyFile(scrFile, new File(pathScreen+screen+screenFormat));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public ObjavlinijaObjects clickLastPage() {
		driver.findElement(clickLastPage).click();
		return this;
	}
	public ObjavlinijaObjects clickFirstPage() {
		driver.findElement(clickFirstPage).click();
		return this;
	}
	
	public ObjavlinijaObjects clickOnObjavlenijaPage() {
		driver.findElement(clickOnObjavlenijaPage).click();
		return this;
	}
	public ObjavlinijaObjects(WebDriver driver) {
		this.driver = driver;
	}
}
