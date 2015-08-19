package info.uaua;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

public class ForumObjects {
	

	WebDriver driver;
	String chooseCategory="Карьера";
	String themeText = "Lorem ipsum dolor sit amet, vis ei persecuti disputando, sed in sale detraxit "
				+ "incorrupte. :!@#$%^&*()_+/.,>`<] съешь же ещё этих мягких французских булок, да выпей чаю";
	
	By clickOnForum_Header =  By.xpath(".//nav[@class = 'header-menu']//a[text()='Форум']");
	By clickOnForum_Beremenost =  By.xpath(".//*[@id='beremennost']//a[text()='Форум']");
	By clickOnForum_Rodu =  By.xpath(".//*[@id='rody']//a[text()='Форум']");
	By clickOnForum_Novorozhdeny =  By.xpath(".//*[@id='novorozhdeny']//a[text()='Форум']");
	By clickOnForum_Grudnichok =  By.xpath(".//*[@id='grudnichok']//a[text()='Форум']");
	By clickOnForum_1do3 =  By.xpath(".//*[@id='ot-1-do-3']//a[text()='Форум']");
	By clickOnForum_3do6 =  By.xpath(".//*[@id='ot-3-do-6']//a[text()='Форум']");
	By clickOnForum_6do9 =  By.xpath(".//*[@id='ot-6-do-9']//a[text()='Форум']");
	By clickOnForum_9do16 =  By.xpath(".//*[@id='ot-9-do-16']//a[text()='Форум']");
	By clickOnForum_Semya =  By.xpath(".//*[@id='semya']//a[text()='Форум']");
	By moveToRodu = By.xpath(".//*[@id='main_nav_wrapper_id']//a[@hash='rody']");
	By moveToNovorozhdeny = By.xpath(".//*[@id='main_nav_wrapper_id']//a[@hash='novorozhdeny']");
	By moveToGrudnichok = By.xpath(".//*[@id='main_nav_wrapper_id']//a[@hash='grudnichok']");
	By moveTo1do3 = By.xpath(".//*[@id='main_nav_wrapper_id']//a[@hash='ot-1-do-3']");
	By moveTo3do6 = By.xpath(".//*[@id='main_nav_wrapper_id']//a[@hash='ot-3-do-6']");
	By moveTo6do9 = By.xpath(".//*[@id='main_nav_wrapper_id']//a[@hash='ot-6-do-9']");
	By moveTo9do16 = By.xpath(".//*[@id='main_nav_wrapper_id']//a[@hash='ot-9-do-16']");
	By moveToSemya = By.xpath(".//*[@id='main_nav_wrapper_id']//a[@hash='semya']");
	By moveToBeremenost = By.xpath(".//*[@id='main_nav_wrapper_id']//a[@hash='beremennost']");
	By clickArrowVoprosu = By.xpath(".//*[@id='1001']//div[@class='arrow']");
	By clickOnLogo = By.xpath(".//*[@id='Logo']");
	By clickOnVhodForum = By.xpath(".//*[@id='Head']//a[@href='http://www.uaua.info/user/login/']");
	By emailField = By.xpath(".//*[@id='authForm']//input[@name ='email']");
	By passlField = By.xpath(".//*[@id='authForm']//input[@name ='password']");
	By clickOnVhodUaua = By.xpath(".//*[@id='authForm']//input[@type ='submit']");
	By clickOn1stPodpisatsja = By.xpath(".//*[@id='1056']//a[@class='category_subscription'][text() = 'Подписаться']");
	By clickOnMoiTemu = By.xpath(".//*[@id='Panel']//a[@href='/profile/discussions/']");
	By PodpisatsjaButtons = By.xpath(".//a[@class='category_subscription']");
	By clickOnMoiPodpiski = By.xpath(".//*[@id='Panel']//a[text()='Мои подписки']");
	
	By pravilaPage  = By.xpath(".//*[@id='Menu']//*[text()='Правила']");
	By faqPage  = By.xpath(".//*[@id='Menu']//*[text()='FAQ']");
	
	By newTheme = By.xpath(".//*[@id='new-theme']/a");
	By themeName = By.xpath(".//*[@id='Form_Name']");
	By categoryField = By.xpath(".//*[@id='Form_CategoryID']");
	By themeTextLocator = By.xpath(".//*[@id = 'Form_Body']");
	By emailCheckbox = By.xpath(".//*[@id='Form_Discussion']//*[@type = 'checkbox']");
	By saveChernovik = By.xpath(".//*[@id='Form_SaveDraft']");
	By mainForumPage = By.xpath(".//*[@id='Menu']//a[text()='Главная форума']");
	By blockShernoviki = By.xpath(".//*[@id='Content']//a[@class = 'MyDrafts TabLink']");
	By clickOtpisatja = By.xpath(".//*[@id='Popup']//table[@class='PreferenceGroup']//a[text()='отписать']");
	
	
	By clickSearchField = By.id("Form_Search");
	By clickFind = By.id("Form_Go");
	
	public ForumObjects clickSearchField() {
		driver.findElement(clickSearchField).click();
		return this;
	}
	public ForumObjects clickFind() {
		driver.findElement(clickFind).click();
		return this;
	}
	
	public ForumObjects clickMainForumPage() {
		driver.findElement(mainForumPage).click();
		return this;
	}
	public ForumObjects clickOtpisatja() {
		driver.findElement(clickOtpisatja).click();
		return this;
	}
	
	public ForumObjects findBlockChernoviki() {
		driver.findElement(mainForumPage);
		return this;
	}
	public ForumObjects clickBlockChernoviki() {
		driver.findElement(blockShernoviki).click();
		return this;
	}
	public ForumObjects deleteFirstChernovik() {
		driver.findElement(By.xpath(".//*[@id='Content']//a[@class = 'Delete']")).click();
		return this;
	}
	
	
	
	
	public ForumObjects autorisation() {
	
		String correctLogin = "testforumuaua@ukr.net";
		String correctPass = "testforumuaua";
		
		WebElement emailFieldForm = driver.findElement(emailField);
		emailFieldForm.sendKeys(correctLogin);
		
		WebElement passFieldForm = driver.findElement(passlField);
		passFieldForm.sendKeys(correctPass);
		
		driver.findElement(clickOnVhodUaua).click();
		
		return this;
	}
	
	public ForumObjects clickNewTheme() {
		driver.findElement(newTheme).click();
		return this;
	}
	
	public ForumObjects createNewTheme() {
	String nameForTheme = "test@#$%^&*()_+|/?/.,";
		
		driver.findElement(themeName).sendKeys(nameForTheme);
		
		Select categoryFind = new Select(driver.findElement(categoryField));
		assertFalse(categoryFind.isMultiple()); 
		assertEquals(93, categoryFind.getOptions().size());
	
		((JavascriptExecutor)driver).executeScript("document.getElementById('Form_Body').value = 'test "
				+ "Lorem ipsum dolor sit amet, vis ei persecuti disputando, sed in sale "
				+ "incorrupte. :!@#$%^&*()_+/.,>`<] съешь же ещё этих мягких французских булок, да выпей чаю';");
		
		driver.findElement(emailCheckbox).click();
		
		return this;
	}
	
	
	public ForumObjects saveChernovik() {
		driver.findElement(saveChernovik).click();
		return this;
	}
	
	public ForumObjects pravilaPage() {
		driver.findElement(pravilaPage).click();
		return this;
	}
	public ForumObjects faqPage() {
		driver.findElement(faqPage).click();
		return this;
	}
	
	public ForumObjects correctMailAutorisationOnForum() {
		driver.findElement(clickOnVhodForum).click();
		String correctLogin = "testforumuaua@ukr.net";
		String correctPass = "testforumuaua";
		
		WebElement emailFieldForm = driver.findElement(emailField);
		emailFieldForm.sendKeys(correctLogin);
		
		WebElement passFieldForm = driver.findElement(passlField);
		passFieldForm.sendKeys(correctPass);
		
		driver.findElement(clickOnVhodUaua).click();
		
		return this;
	}
	public ForumObjects clickOn1stPodpisatsja() {
		driver.findElement(clickOn1stPodpisatsja).click();
		return this;
	}
	public ForumObjects clickOnMoiPodpiski() {
		driver.findElement(clickOnMoiPodpiski).click();
		return this;
	}
	
	public ForumObjects clickOnMoiTemu() {
		driver.findElement(clickOnMoiTemu).click();
		return this;
	}	
	public ForumObjects clickArrowVoprosu() {
		driver.findElement(clickArrowVoprosu).click();
		return this;
	}
	public ForumObjects clickOnLogo() {
		driver.findElement(clickOnLogo).click();
		return this;
	}	
	public ForumObjects makeScreen(String screen){
	try {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String pathScreen = "d:\\uaua.info\\Screens\\ScreensFF37.0.1\\Forum\\";
		String screenFormat = ".jpg";
		FileUtils.copyFile(scrFile, new File(pathScreen+screen+screenFormat));
	} catch (Exception e) {
		e.printStackTrace();
	}
	return this;	
	}	
	public ForumObjects svernutVseRasdeluForuma() { 
		driver.findElement(By.xpath(".//*[@id='1001']//div[@class='arrow']")).click();
		driver.findElement(By.xpath(".//*[@id='1002']//div[@class='arrow']")).click();
		driver.findElement(By.xpath(".//*[@id='1003']//div[@class='arrow']")).click();
		driver.findElement(By.xpath(".//*[@id='1005']//div[@class='arrow']")).click();
		driver.findElement(By.xpath(".//*[@id='1010']//div[@class='arrow']")).click();
		driver.findElement(By.xpath(".//*[@id='1017']//div[@class='arrow']")).click();
		driver.findElement(By.xpath(".//*[@id='1007']//div[@class='arrow']")).click();
		driver.findElement(By.xpath(".//*[@id='1031']//div[@class='arrow']")).click();
		driver.findElement(By.xpath(".//*[@id='1004']//div[@class='arrow']")).click();
		driver.findElement(By.xpath(".//*[@id='1006']//div[@class='arrow']")).click();
		driver.findElement(clickArrowVoprosu).click();
		return this;
	}
	public ForumObjects moveToSemya() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(moveToSemya)).build().perform();
		return this;
	}		
	public ForumObjects moveTo9do16() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(moveTo9do16)).build().perform();
		return this;
	}
	public ForumObjects moveTo6do9() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(moveTo6do9)).build().perform();
		return this;
	}
	public ForumObjects moveTo3do6() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(moveTo3do6)).build().perform();
		return this;
	}
	public ForumObjects moveTo1do3() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(moveTo1do3)).build().perform();
		return this;
	}
	public ForumObjects moveToBeremenost() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(moveToBeremenost)).build().perform();
		return this;
	}
	public ForumObjects moveToRodu() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(moveToRodu)).build().perform();
		return this;
	}
	public ForumObjects moveToNovorozhdeny() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(moveToNovorozhdeny)).build().perform();
		return this;
	}
	public ForumObjects moveToGrudnichok() { 
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(moveToGrudnichok)).build().perform();
		return this;
	}
	public ForumObjects clickOnForum_Header() {
		driver.findElement(clickOnForum_Header).click();
		return this;
	}
	public ForumObjects clickOnForum_Beremenost() {
		driver.findElement(clickOnForum_Beremenost).click();
		return this;
	}
	public ForumObjects clickOnForum_Rodu() {
		driver.findElement(clickOnForum_Rodu).click();
		return this;
	}
	public ForumObjects clickOnForum_Novorozhdeny() {
		driver.findElement(clickOnForum_Novorozhdeny).click();
		return this;
	}
	public ForumObjects clickOnForum_Grudnichok() {
		driver.findElement(clickOnForum_Grudnichok).click();
		return this;
	}
	public ForumObjects clickOnForum_1do3() {
		driver.findElement(clickOnForum_1do3).click();
		return this;
	}
	public ForumObjects clickOnForum_3do6() {
		driver.findElement(clickOnForum_3do6).click();
		return this;
	}
	public ForumObjects clickOnForum_6do9() {
		driver.findElement(clickOnForum_6do9).click();
		return this;
	}
	public ForumObjects clickOnForum_9do16() {
		driver.findElement(clickOnForum_9do16).click();
		return this;
	}
	public ForumObjects clickOnForum_Semya() {
		driver.findElement(clickOnForum_Semya).click();
		return this;
	}
	public ForumObjects findForumMenu() {
		driver.findElement(By.xpath(".//*[@id='Menu']")); 
		return this;
	}
	public  ForumObjects navigateBack() {
	driver.navigate().back();
	return this;
	}	
	
	
	public ForumObjects(WebDriver driver) {
		this.driver = driver;
	}

	
	
}
