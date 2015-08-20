package tests.uaua;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import info.uaua.ForumObjects;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
/*import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;*/
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import data.Autorization;
import data.CommonMethods;
import data.PropertiesDB;

public class TestForum implements PropertiesDB, Autorization {
	BrowserVersion browser;

	WebDriver driver;
	ForumObjects forum;
	String folder = "Forum\\";
	
	
	//@Parameters("browser") //для кроссбраузерного тестирования, смотреть chrome.xml
			@BeforeClass
			public void setUp() {
			/*public void setUp(String browser) {

					if (browser.equalsIgnoreCase("firefox")) {
						driver = new FirefoxDriver();
					} else if (browser.equalsIgnoreCase("chrome")) {
						System.setProperty("webdriver.chrome.driver",
								"D:\\chromedriver.exe");
						driver = new ChromeDriver();
					} else if (browser.equalsIgnoreCase("ie")) {
						File file = new File("D:\\IEDriverServer.exe");
						System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
						DesiredCapabilities capabilities = DesiredCapabilities
								.internetExplorer();
						driver = new InternetExplorerDriver(capabilities);
					} else if (browser.equalsIgnoreCase("opera")) {
						System.setProperty("webdriver.opera.driver", "D:\\operadriver.exe");
						driver = new OperaDriver();
					} else if (browser.equalsIgnoreCase("safari")) {
						driver = new SafariDriver();
					}*/
				
				
				driver = new FirefoxDriver();
				driver.get(adress);
				System.out.println("Test forum START ");
				
		}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.navigate().to(adress);
		driver.manage().window().setPosition(new Point(-3000, 0));
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
}
	
	
 
// Проверка перехода на форум с uaua покрывается другими тестами (в основном TestMenu)
	
	@Test(description = "ID = <ForS01> Снятие скриншотов  с развернутого и свернутого вариантов форума", alwaysRun = true)
	public void testForS01() throws IOException {
		try {
		forum = new ForumObjects(driver);
		forum.clickOnForum_Header().clickArrowVoprosu();
		CommonMethods.makeScreen(driver, "Forum\\", "Развернутые все разделы форума");
		forum.svernutVseRasdeluForuma();
		CommonMethods.makeScreen(driver, "Forum\\", "Закрытые все разделы форума");
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}

	@Test(description = "ID = <ForU01> обратно на uaua.info", alwaysRun = true)
	public void testForU01() {
		try {
		forum = new ForumObjects(driver);
		forum.clickOnForum_Header().clickOnLogo();
		driver.findElement(By.xpath(".//*[@id='main_nav_wrapper_id']")); 
		} catch(Exception e){ 
			Assert.fail(); 
		}
		
	} 
	
		@Test(description = "ID = <ForP01> НЕ Авторизированный пользователь не видит 'подписаться'", alwaysRun = true)
	public void testForP01() {	
		try {
		forum = new ForumObjects(driver);
		forum.clickOnForum_Header();	
		List<WebElement> podpisatsja = driver.findElements(By.xpath(".//a[@class='category_subscription']"));
		Assert.assertTrue(podpisatsja.size()==0);	
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	
		@Test(description = "ID = <ForP02> Авторизированный пользователь видит  элементы подписаться", alwaysRun = true)
		public void testForP02() {
			try {
			forum = new ForumObjects(driver);
			forum.clickOnForum_Header().correctMailAutorisationOnForum();
			
			
			By podpisatsja = By.xpath(".//*[@id='1056']//a[text() = 'Подписаться']");
			(new WebDriverWait(driver, 30))
	        .until(ExpectedConditions
	                  .visibilityOfElementLocated(podpisatsja));
			
			} catch(Exception e) { 
				e.printStackTrace();
				Assert.fail(); 
			}
		}
		
	
	@Test(description = "ID = <ForP03> Авторизированный пользователь пожет подписаться/отписаться  1й элемент", alwaysRun = true)
	public void testForP03() throws IOException {
		try {
		forum = new ForumObjects(driver);
	forum.clickOnForum_Header().correctMailAutorisationOnForum();
	CommonMethods.verifyStaticElements(driver);
	WebElement topicOnMainPage = driver.findElement(By.xpath(".//*[@class='Title'][text() = 'Планирование беременности']"));  
	String topicNameOnMainPage = topicOnMainPage.getText();
	forum.clickOn1stPodpisatsja().clickOnMoiTemu().clickOnMoiPodpiski();
	CommonMethods.makeScreen(driver, "Forum\\", "Мои подписки");
	WebElement topicOnProfilePage = driver.findElement(By.xpath(".//*[@id='Popup']//table[@class='PreferenceGroup']/tbody//td[1]"));  
	String topicNameOnProfilePage = topicOnProfilePage.getText();

	assertEquals(topicNameOnProfilePage, topicNameOnMainPage);
	
	forum.clickOtpisatja();
	CommonMethods.makeScreen(driver, "Forum\\", "Отписаться отновостей форума");
		} catch(Exception e) { 
			Assert.fail(); 
		}
	
	}
	@Test(description = "ID = <ForI01> правила и FAQ", alwaysRun = true)
	public void testForI01() {	
		try {
		forum = new ForumObjects(driver);
		forum.clickOnForum_Header().pravilaPage();
		CommonMethods.makeScreen(driver, "Forum\\", "Страница правил");
		forum.navigateBack().navigateBack();
		forum.clickOnForum_Header().faqPage();
		CommonMethods.makeScreen(driver, "Forum\\", "Раздел FAQ");	
		} catch(Exception e) { 
			Assert.fail(); 
		}
	}
	

	@Test(description = "ID = <ForP05> Поиск по форуму", alwaysRun = true)
	public void testForP05() {
		try {
		forum = new ForumObjects(driver);
		forum.clickOnForum_Header().clickSearchField();
		String serchWord = "набор веса";
			WebElement searchFieldForm = driver.findElement(By.id("Form_Search"));
			searchFieldForm.sendKeys(serchWord);
		forum.clickFind();
			CommonMethods.verifyStaticElements(driver);
		WebElement message = driver.findElement(By.xpath(".//*[@id='Content']//li[1]/div/div[1]/a"));
		String messageText = message.getText();
			
		assertTrue(messageText.toLowerCase().contains(serchWord));	
		} catch(Exception e) { 
			Assert.fail(); 
		}
	}
	
	
	@Test(description = "ID = <ForN01> Добавление новой темы в черновики. удаление черновика", alwaysRun = true)
	public void testForN01() {	
		try {
		forum = new ForumObjects(driver);
		forum.clickOnForum_Header().clickNewTheme().autorisation().createNewTheme().saveChernovik().
			clickMainForumPage().findBlockChernoviki();
		WebElement numberOfChernoviki = driver.findElement(By.xpath(".//*[@id='Content']//a[@class = 'MyDrafts TabLink']/span"));
		String ch = "1";
		assertEquals(ch, numberOfChernoviki.getText().toString());
		CommonMethods.makeScreen(driver, "Forum\\", "Черновик");
		CommonMethods.verifyStaticElements(driver);
		forum.clickBlockChernoviki().deleteFirstChernovik();
		
		} catch(Exception e) { 
			e.printStackTrace();
			Assert.fail(); 
		}
	}
	
	

	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult, Method method)
			throws IOException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String methodName = method.getName();
		String browser = (String)js.executeScript("return navigator.userAgent;");
		String errorName = null;
		if (browser.contains("Firefox_")) {
			errorName = "Firefox_";
		} else if (browser.contains("Chrome/43") && !browser.contains("OPR/")) {
			errorName = "Chrome_";
		} else if (browser.contains("rv:11")) {
			errorName = "IE_";
		} else if (browser.contains("OPR/")) {
			errorName = "Opera_";
		} else if (browser.contains("Safari/534")) {
			errorName = "Safari_";
		}
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(screenDir + "Errors\\"+ folder +errorName+methodName + ".jpg"));
		}
	
	@AfterClass
	  public void tearDown() {
		  driver.quit(); 
		  }
	
}

