package info.uaua;



import static org.testng.AssertJUnit.assertEquals;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class DetskoePitanieObjects {

	static WebDriver driver;
	

	By clickOnDetskoePitanie_Specrasdel = By.xpath(".//*[@class = 'speccorners']//a[@href = 'http://babyfood.uaua.info/']");
	//By clickOnDetskoePitanie_Header = By.xpath(".//nav[@class = 'header-menu']//a[@href = 'http://babyfood.uaua.info/']");
	By clickOnDetskoePitanie_Header = By.xpath(".//nav[@class = 'header-menu']//a[text() = 'Детское питание']");
	By objectsOnDetskoePitaniePage = By.xpath(".//*[@class='b-article__tit']");
	
	By clickLastPage= By.xpath(".//*[@id='left_col']//a[@class = 'list_next']");
	By clickFirstPage= By.xpath(".//*[@id='left_col']//a[@class = 'list_prev']");
	
	By clickOnReceptu= By.xpath(".//a[@class='b-article__tit'][text() = 'Рецепты']");
	By clickOnReceptu_Vse= By.xpath(".//*[@id='left_col']/div[1]/a[2]");  //!!!!!!!!!!!!! TODO
	By clickOnReceptu_Temu = By.xpath(".//div[@class = 'bord_box topics']//a[text() = 'Рецепты']");
	By verifyPageReceptuConsistArticls= By.xpath(".//*[contains(text(), 'рецепт')]");
	
	By clickOnPricorm= By.xpath(".//a[@class='b-article__tit'][text() = 'Прикорм']");
	By clickOnPricorm_Vse= By.xpath(".//*[@id='left_col']/div[2]/a[2]");  //!!!!!!!!!!!!! TODO
	By clickOnPricorm_Temu = By.xpath(".//div[@class = 'bord_box topics']//a[text() = 'Прикорм']");
	By verifyPagePricormConsistArticls= By.xpath(".//*[contains(text(), 'прикорм')]");
	
	By clickOnPitanieMalushei= By.xpath(".//a[@class='b-article__tit'][text() = 'Питание для малышей до 3-х лет']");
	By clickOnPitanieMalushei_Vse= By.xpath(".//*[@id='left_col']//a[@href = 'http://babyfood.uaua.info/articles/pitanie-do-trech-let/'][text() = 'Читать все статьи раздела']");  
	By clickOnPitanieMalushei_Temu = By.xpath(".//div[@class = 'bord_box topics']//a[text() = 'Питание для малышей до 3-х лет']");
	
	By clickOnPitanieDoshkolnikov= By.xpath(".//a[@class='b-article__tit'][text() = 'Питание дошкольников']");
	By clickOnPitanieDoshkolnikov_Vse= By.xpath(".//*[@id='left_col']/div[4]/a[2]");  //!!!!!!!!!!!!! TODO
	By clickOnPitanieDoshkolnikov_Temu = By.xpath(".//div[@class = 'bord_box topics']//a[text() = 'Питание дошкольников']");
	
	By clickOnPitanieShkolnikov= By.xpath(".//a[@class='b-article__tit'][text() = 'Питание школьников']");
	By clickOnPitanieShkolnikov_Vse= By.xpath(".//*[@id='left_col']/div[5]/a[2]");  //!!!!!!!!!!!!! TODO
	By clickOnPitanieShkolnikov_Temu = By.xpath(".//div[@class = 'bord_box topics']//a[text() = 'Питание школьников']");
	
	By clickOnEnciklopedia= By.xpath(".//a[@class='b-article__tit'][text() = 'Энциклопедия детского питания']");
	By clickOnEnciklopedia_Vse= By.xpath(".//*[@id='left_col']/div[6]/a[2]");  //!!!!!!!!!!!!! TODO
	By clickOnEnciklopedia_Temu = By.xpath(".//div[@class = 'bord_box topics']//a[text() = 'Энциклопедия детского питания']");
	
	By clickOnPitanieBeremenuh= By.xpath(".//a[@class='b-article__tit'][text() = 'Питание беременных']");
	By clickOnPitanieBeremenuh_Vse= By.xpath(".//*[@id='left_col']/div[7]/a[2]");  //!!!!!!!!!!!!! TODO
	By clickOnPitanieBeremenuh_Temu = By.xpath(".//div[@class = 'bord_box topics']//a[text() = 'Питание беременных']");
	
	By clickOnBlog= By.xpath(".//a[@class='b-article__tit'][text() = 'Блог']");
	By waitForImg= By.xpath(".//*[@id='left_col']//img");
	
	By clickOnVse_Temu = By.xpath(".//div[@class = 'bord_box topics']//a[text() = 'Все']");
	
	By findBlockKonsultacii = By.xpath(".//*[@id='left_col']//div[@class = 'b-advice__i']");
	By findLinkKonsultacii = By.xpath(".//*[@id='left_col']//a[text() = 'Консультации']");
	
	
	By findNews = By.xpath(".//*[@id='uaua-new-infrm']");
	By findSocilNetworks = By.xpath(".//*[@class = 'speccorners-title'][text() = 'uaua.info']");
	By findOChemGovorjatMamu = By.xpath(".//*[@class = 'content-block dotted-line forum-links']");
	By findBlockThems = By.xpath(".//*[@class='bord_box topics']");
	By findTags = By.xpath(".//*[@class='bord_box tags']");
	
	
	public DetskoePitanieObjects verifyElementsInThems() {
		driver.findElement(findNews);
		driver.findElement(findSocilNetworks);
		driver.findElement(findOChemGovorjatMamu);
		driver.findElement(findBlockThems);
		driver.findElement(findTags);
		return this;
	}
	public DetskoePitanieObjects findBlockKonsultacii() {
		driver.findElement(findBlockKonsultacii);
		return this;
	}
	public DetskoePitanieObjects findLinkKonsultacii() {
		WebElement message = driver.findElement(findLinkKonsultacii);
		String messageText = message.getText();
		assertEquals("Консультации", messageText);
		return this;
	}
	public DetskoePitanieObjects clickOnBlog() {
		driver.findElement(clickOnBlog).click();
		return this;
	}
	public DetskoePitanieObjects waitForImg() {
		driver.findElement(waitForImg);
		return this;
	}
	public DetskoePitanieObjects clickOnVse_Temu() {
		driver.findElement(clickOnVse_Temu).click();
		return this;
	}
	public DetskoePitanieObjects clickOnPitanieBeremenuh() {
		driver.findElement(clickOnEnciklopedia).click();
		return this;
	}
	public DetskoePitanieObjects clickOnPitanieBeremenuh_Vse() {
		driver.findElement(clickOnEnciklopedia_Vse).click();
		return this;
	}
	public DetskoePitanieObjects clickOnPitanieBeremenuh_Temu() {
		driver.findElement(clickOnEnciklopedia_Temu).click();
		return this;
	}	
	public DetskoePitanieObjects clickOnEnciklopedia() {
		driver.findElement(clickOnEnciklopedia).click();
		return this;
	}
	public DetskoePitanieObjects clickOnEnciklopedia_Vse() {
		driver.findElement(clickOnEnciklopedia_Vse).click();
		return this;
	}
	public DetskoePitanieObjects clickOnEnciklopedia_Temu() {
		driver.findElement(clickOnEnciklopedia_Temu).click();
		return this;
	}
	public DetskoePitanieObjects clickOnPitanieShkolnikov() {
		driver.findElement(clickOnPitanieShkolnikov).click();
		return this;
	}
	public DetskoePitanieObjects clickOnPitanieShkolnikov_Vse() {
		driver.findElement(clickOnPitanieShkolnikov_Vse).click();
		return this;
	}
	public DetskoePitanieObjects clickOnPitanieShkolnikov_Temu() {
		driver.findElement(clickOnPitanieShkolnikov_Temu).click();
		return this;
	}		
	public DetskoePitanieObjects clickOnPitanieDoshkolnikov() {
		driver.findElement(clickOnPitanieDoshkolnikov).click();
		return this;
	}
	public DetskoePitanieObjects clickOnPitanieDoshkolnikov_Vse() {
		driver.findElement(clickOnPitanieDoshkolnikov_Vse).click();
		return this;
	}
	public DetskoePitanieObjects clickOnPitanieDoshkolnikov_Temu() {
		driver.findElement(clickOnPitanieDoshkolnikov_Temu).click();
		return this;
	}
	public DetskoePitanieObjects clickOnPitanieMalushei() {
		driver.findElement(clickOnPitanieMalushei).click();
		return this;
	}
	public DetskoePitanieObjects clickOnPitanieMalushei_Vse() {
		driver.findElement(clickOnPitanieMalushei_Vse).click();
		return this;
	}
	public DetskoePitanieObjects clickOnPitanieMalushei_Temu() {
		driver.findElement(clickOnPitanieMalushei_Temu).click();
		return this;
	}
	public DetskoePitanieObjects clickOnPricorm() {
		driver.findElement(clickOnPricorm).click();
		return this;
	}
	public DetskoePitanieObjects clickOnPricorm_Vse() {
		driver.findElement(clickOnPricorm_Vse).click();
		return this;
	}
	public DetskoePitanieObjects clickOnPricorm_Temu() {
		driver.findElement(clickOnPricorm_Temu).click();
		return this;
	}
	public DetskoePitanieObjects findTextPricorm() {
		driver.findElement(verifyPagePricormConsistArticls);
		return this;
	}
	public DetskoePitanieObjects clickOnReceptu() {
		driver.findElement(clickOnReceptu).click();
		return this;
	}
	public DetskoePitanieObjects clickOnReceptu_Vse() {
		driver.findElement(clickOnReceptu_Vse).click();
		return this;
	}
	public DetskoePitanieObjects clickOnReceptu_Temu() {
		driver.findElement(clickOnReceptu_Temu).click();
		return this;
	}	
	public DetskoePitanieObjects findTextRecept() {
		driver.findElement(verifyPageReceptuConsistArticls);
		return this;
	}
	public  DetskoePitanieObjects navigateBack() {
		driver.navigate().back();
		return this;
		}
	public DetskoePitanieObjects clickLastPage() {
		driver.findElement(clickLastPage).click();
		return this;
	}
	public DetskoePitanieObjects clickFirstPage() {
		driver.findElement(clickFirstPage).click();
		return this;
	}
	public DetskoePitanieObjects verifyObjectsOnDetskoePitaniePage() {
		List<WebElement> elementsOnPageDP = driver.findElements(objectsOnDetskoePitaniePage);
		Assert.assertTrue(elementsOnPageDP.size()>3);
		return this;
	}
	synchronized public DetskoePitanieObjects clickOnDetskoePitanie_Specrasdel() {
		driver.findElement(clickOnDetskoePitanie_Specrasdel).click();
		return this;
	}	
	synchronized public DetskoePitanieObjects clickOnDetskoePitanie_Header() {
		driver.findElement(clickOnDetskoePitanie_Header).click();
		return this;
	}
	public DetskoePitanieObjects(WebDriver driver) {
		this.driver = driver;
	}
}


