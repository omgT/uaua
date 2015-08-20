package tests.uaua;

import info.uaua.DetskoePitanieObjects;

import java.util.concurrent.TimeUnit;

import data.CommonMethods;
import data.PropertiesDB;
import data.Autorization;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
/*import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.Parameters;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Point;
import org.openqa.selenium.opera.OperaDriver;*/
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.TakesScreenshot;

import com.gargoylesoftware.htmlunit.BrowserVersion;


public class TestDetskoePitanie extends CommonMethods implements PropertiesDB, Autorization {
	BrowserVersion browser;
	WebDriver driver;
	DetskoePitanieObjects servicePitanie;
	String folder = "Детское питание\\";
	
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
			System.out.println("Test DP START ");
			
	}
	
	@BeforeMethod
	public void beforeMethod() {
		driver.navigate().to(adress);
		driver.manage().window().setPosition(new Point(-3000, 0));
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
		
}

	@Test
	public void testDetP013() throws IOException {
		
	}
	
	@Test(description = "ID = <DetP011> Проверка перехода на детское питание с uaua + скрин", alwaysRun = true)
	public void testDetP011() throws IOException {
		try {
			servicePitanie = new  DetskoePitanieObjects(driver);
			servicePitanie.clickOnDetskoePitanie_Header().verifyObjectsOnDetskoePitaniePage();
			CommonMethods.verifyStaticElements(driver);
			CommonMethods.makeScreen(driver, folder, "Главная страница детского питания");
			
		} catch(Exception e){ 
			Assert.fail(); 
		}
		
	}
	
	
	  	@Test(description = "ID = <DetP012> Проверка перехода на детское питание через Спецраздел с uauа", alwaysRun = true)
	public void testDetP012() throws IOException {
		try {
			servicePitanie = new  DetskoePitanieObjects(driver);
		servicePitanie.clickOnDetskoePitanie_Specrasdel().verifyObjectsOnDetskoePitaniePage();
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}
		
	}
	  	
		@Test(description = "ID = <DetP021> Проверка перехода на РЕЦЕПТЫ через 'рецепты', навигация по страницам ", alwaysRun = true)
		public void testDetP021() throws IOException {
			try {
				servicePitanie = new  DetskoePitanieObjects(driver);
			servicePitanie = servicePitanie.clickOnDetskoePitanie_Header().clickOnReceptu().findTextRecept();
			CommonMethods.verifyStaticElements(driver);
			CommonMethods.makeScreen(driver, folder, "Рецепты");
				} catch(Exception e){ 
					e.printStackTrace();
				Assert.fail(); 
				}
			}
		
		@Test(description = "ID = <DetP022> Проверка перехода на РЕЦЕПТЫ через 'темы' и  'все статьи', навигация по страницам + скрин", alwaysRun = true)
		public void testDetP022() throws IOException {
			try {
				servicePitanie = new  DetskoePitanieObjects(driver);
			servicePitanie.clickOnDetskoePitanie_Header().clickOnReceptu_Vse().findTextRecept().clickLastPage();
			CommonMethods.verifyStaticElements(driver);
			CommonMethods.makeScreen(driver, folder, "Рецепты_последняя_страница");
			servicePitanie.clickFirstPage();
			CommonMethods.makeScreen(driver, folder, "Рецепты_первая_страница");
			} catch(Exception e){ 
				Assert.fail(); 
			}	
		}
	  
	   @Test(description = "ID = <DetP081> Проверка перехода на ПИТАНИЕ ШКОЛЬНИКОВ через 'питание школьников', навигация по страницам", alwaysRun = true)
	public void testDetP081() throws IOException {
		try {
			servicePitanie = new DetskoePitanieObjects(driver);
		servicePitanie = servicePitanie.clickOnDetskoePitanie_Header().clickOnPitanieShkolnikov().findTextRecept();
		CommonMethods.verifyStaticElements(driver);
		} catch(Exception e){ 
			Assert.fail(); 
		}	
	}
	   
	   @Test(description = "ID = <DetP082> Проверка перехода на ПИТАНИЕ ШКОЛЬНИКОВ через 'рецепты', 'темы' и  'все статьи', навигация по страницам + скрин", alwaysRun = true)
	public void testDetP082() throws IOException{
		   try {
			   servicePitanie = new DetskoePitanieObjects(driver);
			servicePitanie.clickOnDetskoePitanie_Header().clickOnPitanieShkolnikov_Vse().findTextRecept().clickLastPage();
			CommonMethods.verifyStaticElements(driver);
			CommonMethods.makeScreen(driver, folder, "ПИТАНИЕ ШКОЛЬНИКОВ_последняя_страница");
			servicePitanie.clickFirstPage();
			CommonMethods.makeScreen(driver, folder, "ПИТАНИЕ ШКОЛЬНИКОВ_первая_страница");
		} catch(Exception e){ 
			Assert.fail(); 
		}	
	}
	
	@Test(description = "ID = <DetP03> Проверка перехода на ПРИКОРМ через 'прикорм', 'темы' и  'все статьи', навигация по страницам + скрин", alwaysRun = true)
	public void testDetP03() throws IOException{
	try {
		servicePitanie = new DetskoePitanieObjects(driver);
		servicePitanie = servicePitanie.clickOnDetskoePitanie_Header().clickOnPricorm().
				findTextPricorm();
		
		CommonMethods.verifyStaticElements(driver);
	} catch(Exception e){ 
		Assert.fail(); 
	}
	}
	
	@Test(description = "ID = <DetP031> Проверка перехода на ПРИКОРМ через 'темы' и  'все статьи', навигация по страницам + скрин", alwaysRun = true)
	public void testDetP032() throws IOException {
		try {
			servicePitanie = new DetskoePitanieObjects(driver);
		servicePitanie.clickOnDetskoePitanie_Header().clickOnPricorm_Vse().findTextPricorm().clickLastPage();
		CommonMethods.verifyStaticElements(driver);
		CommonMethods.makeScreen(driver, folder, "Прикорм_последняя_страница");
		servicePitanie.clickFirstPage();
		CommonMethods.makeScreen(driver, folder, "Прикорм_первая_страница");
		
		} catch(Exception e){ 
			e.printStackTrace();
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <DetP041> Проверка перехода на ПИТАНИЕ МАЛЫШЕЙ через 'питание..', навигация по страницам + скрин", alwaysRun = true)
public void testDetP041() throws IOException {
try {
	servicePitanie = new DetskoePitanieObjects(driver);
	servicePitanie = servicePitanie.clickOnDetskoePitanie_Header().clickOnPitanieMalushei();
	CommonMethods.verifyStaticElements(driver);
} catch(Exception e){ 
		Assert.fail(); 
	}
}
	
	@Test(description = "ID = <DetP042> Проверка перехода на ПИТАНИЕ МАЛЫШЕЙ через 'питание..', 'темы' и  'все статьи', навигация по страницам + скрин", alwaysRun = true)
	public void testDetP042() throws IOException {
	try {
		servicePitanie = new DetskoePitanieObjects(driver);
			servicePitanie.clickOnDetskoePitanie_Header().clickOnPitanieMalushei_Vse().clickLastPage();
			CommonMethods.verifyStaticElements(driver);
		CommonMethods.makeScreen(driver, folder, "Питание_малышам_последняя_страница");
			servicePitanie.clickFirstPage();
		CommonMethods.makeScreen(driver, folder, "Питание_малышам_первая_страница");
		} catch(IOException e){
			Assert.fail(); 
		}	
	}	
	
	@Test(description = "ID = <DetP051> Проверка перехода на ПИТАНИЕ ДОШКОЛЬНИКОВ через 'питание...',  навигация по страницам + скрин", alwaysRun = true)
	public void testDetP051() throws IOException {
	try {
		servicePitanie = new DetskoePitanieObjects(driver);
		servicePitanie = servicePitanie.clickOnDetskoePitanie_Header().clickOnPitanieDoshkolnikov();
		CommonMethods.verifyStaticElements(driver);
	} catch(Exception e){ 
		Assert.fail(); 
	}
	}
	
	@Test(description = "ID = <DetP052> Проверка перехода на ПИТАНИЕ ДОШКОЛЬНИКОВ через  'темы' и  'все статьи', навигация по страницам + скрин", alwaysRun = true)
	public void testDetP052() throws IOException{
	try {
		servicePitanie = new DetskoePitanieObjects(driver);
		servicePitanie.clickOnDetskoePitanie_Header().clickOnPitanieDoshkolnikov_Vse().clickLastPage();
		CommonMethods.verifyStaticElements(driver);
		CommonMethods.makeScreen(driver, folder, "Питание_дошкольников_последняя_страница");		
		servicePitanie.clickFirstPage();
		CommonMethods.makeScreen(driver, folder, "Питание_дошкольников_первая_страница");
		} catch(Exception e){ 
			Assert.fail(); 
		}		
	}
	
	@Test(description = "ID = <DetP061> Проверка перехода на Энциклопедия детского питания через 'Энциклопедия...' 'все статьи', переход по страницам + скрин", alwaysRun = true)
	public void testDetP061() throws IOException{
	try {
		servicePitanie = new DetskoePitanieObjects(driver);
		servicePitanie = servicePitanie.clickOnDetskoePitanie_Header().clickOnEnciklopedia();
		CommonMethods.verifyStaticElements(driver);;
	} catch(Exception e){ 
		Assert.fail(); 
	}		
}
	
		@Test(description = "ID = <DetP062> Проверка перехода на Энциклопедия детского питания через 'Энциклопедия...', 'темы' и   навигация по страницам + скрин", alwaysRun = true)
	
	public void testDetP062() throws IOException{
		try {	
			servicePitanie = new DetskoePitanieObjects(driver);
		servicePitanie.clickOnDetskoePitanie_Header().clickOnEnciklopedia_Vse().clickLastPage();
		CommonMethods.verifyStaticElements(driver);
		CommonMethods.makeScreen(driver, folder, "Энциклопедия_последняя_страница"); 
		servicePitanie.clickFirstPage();
		CommonMethods.makeScreen(driver, folder, "Энциклопедия_первая_страница"); 
		} catch(Exception e){ 
			Assert.fail(); 
		}		
	}
		
	@Test(description = "ID = <DetP071> Проверка перехода на Питание беременных через 'Питание беременных...', 'темы' и  'все статьи', навигация по страницам + скрин", alwaysRun = true)
	public void testDetP071() throws IOException{
	try {
		servicePitanie = new DetskoePitanieObjects(driver);
		servicePitanie = servicePitanie.clickOnDetskoePitanie_Header().clickOnPitanieBeremenuh();
		CommonMethods.verifyStaticElements(driver);
	} catch(Exception e){ 
		Assert.fail(); 
	}		
}
	
	@Test(description = "ID = <DetP072> Проверка перехода на Питание беременных через 'Питание беременных...', 'темы' и  'все статьи', навигация по страницам + скрин", alwaysRun = true)
	public void testDetP072() throws IOException{
	try {
		servicePitanie = new DetskoePitanieObjects(driver);
	servicePitanie.clickOnDetskoePitanie_Header().clickOnPitanieBeremenuh_Vse().clickLastPage();
	CommonMethods.verifyStaticElements(driver);
	CommonMethods.makeScreen(driver, folder, "Питание беременных_последняя_страница");
	servicePitanie.clickFirstPage();
	CommonMethods.makeScreen(driver, folder, "Питание беременных_первая_страница");
		} catch(Exception e){ 
			Assert.fail(); 
		}		
	} 
	
	@Test(description = "ID = <DetP09> Проверка перехода на ВСЕ ТЕМЫ, навигация по страницам + скрин", alwaysRun = true)
	public void testDetP09() throws IOException{
	try {
		servicePitanie = servicePitanie.clickOnDetskoePitanie_Header().clickOnEnciklopedia().clickLastPage();
		CommonMethods.verifyStaticElements(driver);
			CommonMethods.makeScreen(driver, folder, "Все темы_последняя_страница");
			servicePitanie.clickFirstPage();
		CommonMethods.verifyStaticElements(driver);
			CommonMethods.makeScreen(driver, folder, "Все темы_первая_страница"); 		
		} catch(Exception e){ 
			Assert.fail(); 
		}
	}
	
	@Test(description = "ID = <DetP10> наличие блока консультации, Проверка названия", alwaysRun = true)
	public void testDetP10() throws IOException{
	try {
		servicePitanie = servicePitanie.clickOnDetskoePitanie_Header().findBlockKonsultacii().findLinkKonsultacii();
		} catch(Exception e){ 
			Assert.fail(); 
		}		
	}
	
	/*		// пока не трогать @Test(description = "ID = <DetP08> Проверка перехода на Блог через 'Блог', 'темы' и  'все статьи', навигация по страницам + скрин", alwaysRun = true)
	public void testDetP08() {
	try {
		servicePitanie = servicePitanie.clickOnDetskoePitanie_Header().clickOnBlog().clickLastPage().waitForImg();
		servicePitanie.verifyElementsInThems();		
		CommonMethods.makeScreen(driver, folder, "Блог_последняя_страница");
		servicePitanie.clickFirstPage().waitForImg();
		servicePitanie.verifyElementsInThems();	
		CommonMethods.makeScreen(driver, folder, "Блог_первая_страница");	
		} catch(Exception e){ 
			Assert.fail(); 
		}	
	}*/
	
	
	@AfterMethod
	public void takeScreenShotOnFailure(ITestResult testResult, Method method) // делает скрин если тесты падают и ложит в папку errors
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
