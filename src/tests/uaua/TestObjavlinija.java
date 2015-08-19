package tests.uaua;
import data.Autorization;



import data.CommonMethods;
import data.PropertiesDB;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.ITestResult;

import info.uaua.ObjavlinijaObjects;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;*/
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.gargoylesoftware.htmlunit.BrowserVersion;

public class TestObjavlinija  implements PropertiesDB, Autorization {
	BrowserVersion browser;
	WebDriver driver;
	ObjavlinijaObjects serviceAdvert;
	By clickLastPage= By.xpath(".//div[@class='board']//a[@class = 'list_next']");
	String folder = "Objavlenija\\";
	
		
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
				System.out.println("TestDetskoePitanie BeforeSuite 1 ");
		}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.navigate().to(adress);
		driver.manage().window().setPosition(new Point(-3000, 0));
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
}
	
	@Test(description = "ID = <Ad01> Проверка перехода на ВСЕ ТЕМЫ, навигация по страницам + скрин", alwaysRun = true)
	public void testAd01() {
		try {
			serviceAdvert = new ObjavlinijaObjects(driver);
			serviceAdvert = serviceAdvert.clickOnObjavlenijaPage().clickOnVse();
				serviceAdvert.clickLastPage();
				CommonMethods.verifyStaticElements(driver);
				CommonMethods.makeScreen(driver, "Objavlenija\\", "ВСЕ Обьявления_последняя_страница");
				serviceAdvert.clickFirstPage();
				CommonMethods.verifyStaticElements(driver);
				CommonMethods.makeScreen(driver, "Objavlenija\\", "ВСЕ Обьявления_первая_страница");
	} catch(Exception e){ 
		Assert.fail(); 
	}
	}
	
	/*@Test(description = "ID = <Ad02> Проверка перехода на ПРОДАЮ, навигация по страницам + скрин", alwaysRun = true)
	public void testAd02() {
		try {
		serviceAdvert = new ObjavlinijaObjects(driver);
		serviceAdvert = serviceAdvert.clickOnObjavlenijaPage().clickOnProdaju();
		serviceAdvert.clickLastPage();	
		CommonMethods.verifyStaticElements(driver);
		CommonMethods.makeScreen(driver, "Objavlenija\\", "ПРОДАЮ Обьявления_последняя_страница");
			serviceAdvert.clickFirstPage();
		CommonMethods.verifyStaticElements(driver);
		CommonMethods.makeScreen(driver, "Objavlenija\\", "ПРОДАЮ Обьявления_первая_страница");
		} catch(Exception e){ 
			Assert.fail(); 
		}		
	}	
	@Test(description = "ID = <Ad03> Проверка перехода на ОТДАЮ, навигация по страницам + скрин", alwaysRun = true)
	public void testAd03() throws IOException {
		try {
			serviceAdvert = new ObjavlinijaObjects(driver);
			serviceAdvert.clickOnObjavlenijaPage().clickOnOtdaju();
				serviceAdvert.clickLastPage();
				CommonMethods.verifyStaticElements(driver);
					CommonMethods.makeScreen(driver, "Objavlenija\\", "ОТДАЮ Обьявления_последняя_страница");
						serviceAdvert.clickFirstPage();
					CommonMethods.verifyStaticElements(driver);
					CommonMethods.makeScreen(driver, "Objavlenija\\", "ОТДАЮ Обьявления_первая_страница");	
					
		} catch(Exception e){ 
			CommonMethods.verifyStaticElements(driver);
			CommonMethods.makeScreen(driver, "Objavlenija\\", "ОТДАЮ Обьявления");
			
		}						
	}
	
	@Test(description = "ID = <Ad04> Проверка перехода на КУПЛЮ, навигация по страницам + скрин", alwaysRun = true)
	public void testAd04()  throws IOException{
		try {
		serviceAdvert = new ObjavlinijaObjects(driver);
		serviceAdvert = serviceAdvert.clickOnObjavlenijaPage().clickOnKuplju();
		CommonMethods.verifyStaticElements(driver);
		CommonMethods.makeScreen(driver, "Objavlenija\\", "КУПЛЮ Обьявления_последняя_страница");
			serviceAdvert.clickFirstPage();
		CommonMethods.verifyStaticElements(driver);
		CommonMethods.makeScreen(driver, "Objavlenija\\", "КУПЛЮ Обьявления_первая_страница");
		} catch(Exception e){ 
			CommonMethods.verifyStaticElements(driver);
			CommonMethods.makeScreen(driver, "Objavlenija\\", "КУПЛЮ Обьявления"); 
		}								
	}	
		
	@Test(description = "ID = <Ad05> Проверка перехода на ИЩУ, навигация по страницам + скрин", alwaysRun = true)
	public void testAd05() {
	try {
		serviceAdvert = new ObjavlinijaObjects(driver);
		serviceAdvert = serviceAdvert.clickOnObjavlenijaPage().clickOnFindKategory();
		
		CommonMethods.verifyStaticElements(driver);
		CommonMethods.makeScreen(driver, "Objavlenija\\", "ИЩУ Обьявления_последняя_страница");
			serviceAdvert.clickFirstPage();
		CommonMethods.verifyStaticElements(driver);
		CommonMethods.makeScreen(driver, "Objavlenija\\", "ИЩУ Обьявления_первая_страница");
	} catch(Exception e){ 
		Assert.fail(); 
	}
	}
	
	@Test(description = "ID = <Ad06> ДОБАВИТЬ КОРРЕКТНОЕ ОБЬЯВЛЕНИЕ  -  Удалить", alwaysRun = true)
	public void testAd06() {
		try {
		CommonMethods.correctMailAutorisation(driver);
		serviceAdvert = new ObjavlinijaObjects(driver);
		serviceAdvert.clickOnObjavlenijaPage().clickOnAddObyavlenia().addCorrectObyavlenia();
		CommonMethods.makeScreen(driver, "Objavlenija\\", "Новое обьявление");
		driver.get("http://board.uaua.info/");
		serviceAdvert.findAddedObyavlenia().clickOnFindedAdd().clickDelete();
		CommonMethods.makeScreen(driver, "Objavlenija\\", "Нет обьявления");
		} catch(Exception e){ 
			Assert.fail(); 
		}
	} 
	
	@Test(description = "ID = <Ad08> проверка поиска", alwaysRun = true)
	public void testAd08() {
		serviceAdvert = new ObjavlinijaObjects(driver);
		serviceAdvert.clickOnObjavlenijaPage().findAddedObyavlenia();
	}
	*/
		 
	/*@Test(description = "ID = <Ad07> проверка записи в БАЗЕ данных, удаление", alwaysRun = true, dependsOnMethods = "testAd08" )
	public void testAd07() throws Exception {
		  
			  	String zagolovok = "test:!@#$%^&*()_+/.,><]`";
				String startPrice = "20000";
				String  endPrice = "500000";
				String texrtAdd = "Lorem ipsum dolor sit amet, vis ei persecuti disputando, sed in sale detraxit "
						+ "incorrupte. :!@#$%^&*()_+/.,>`<] съешь же ещё этих мягких французских булок, да выпей чаю";
				String gift = "1";
				
				
			String username = "tester";
			String pass =  "9aT5ARfdTmO1";
			String query = "SELECT * FROM advert_items WHERE adv_title LIKE '%test%';";
			String query1 = "DELETE FROM advert_items WHERE adv_title LIKE '%test%' and adv_body LIKE '%lorem%';";
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection(bdAdress, username, pass);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			while(rs.next()){
					AssertJUnit.assertEquals(rs.getString(9), zagolovok); 
					AssertJUnit.assertEquals(rs.getString(10), texrtAdd); 
					AssertJUnit.assertEquals(rs.getString(11).toString(), startPrice); 
					AssertJUnit.assertEquals(rs.getString(12).toString(), endPrice); 
					AssertJUnit.assertEquals(rs.getString(13).toString(), gift); 
			}
			stmt.executeUpdate(query1);
			
			con.close();		 
	} */
	
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
