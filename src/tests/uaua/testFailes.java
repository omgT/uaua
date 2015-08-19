package tests.uaua;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import info.uaua.DetskoePitanieObjects;
import info.uaua.FormIdRdSearchForm;
import info.uaua.ForumObjects;
import info.uaua.MenuObjects;
import info.uaua.ObjavlinijaObjects;
import info.uaua.ServiceBudjetMalusha;
import info.uaua.ServiceBudjetRodu;
import info.uaua.ServiceCentrDetskogoRazvitija;
import info.uaua.ServiceDanceSchools;
import info.uaua.ServiceDetskiePolikliniki;
import info.uaua.ServiceDetskieSadu;
import info.uaua.ServiceDomaTvorchestva;
import info.uaua.ServiceKalendarBeremenosti;
import info.uaua.ServiceKalendarProvivok;
import info.uaua.ServiceKyrsuDljaBeremenuh;
import info.uaua.ServiceMusicSchools;
import info.uaua.ServiceOpredeleniePola;
import info.uaua.ServiceOtduhZdorovje;
import info.uaua.ServicePribavkaDoGoda;
import info.uaua.ServiceRaschetDatuRodov;
import info.uaua.ServiceRazvitiePoMesjacam;
import info.uaua.ServiceRoddoma;
import info.uaua.ServiceSchools;
import info.uaua.ServiceSportSekcii;
import info.uaua.ServiceTablitsaPricorma;
import info.uaua.ServiceUslugi;
import info.uaua.ServiceZhenskieKonsultasii;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.BrowserVersion;

import data.Autorization;
import data.CommonMethods;
import data.PropertiesDB;


public class testFailes extends CommonMethods implements PropertiesDB, Autorization {
	
	BrowserVersion browser;
	WebDriver driver;
	
	ServiceDetskiePolikliniki service;
	FormIdRdSearchForm form;
	ServiceDetskieSadu serviceDS;
	ServiceDomaTvorchestva servicesDS;
	ServiceDomaTvorchestva serviceDT;
	ServiceZhenskieKonsultasii serviceZhK;
	ServiceKyrsuDljaBeremenuh serviceKdB;
	ServiceMusicSchools serviceMS;
	ServiceOtduhZdorovje serviceOZ;
	ServiceSportSekcii serviceSS;
	ServiceUslugi serviceU;
	ServiceCentrDetskogoRazvitija  serviceCDR;
	ServiceSchools serviceSch;
	ServiceDanceSchools serviceDSch;
	ServiceRoddoma serviceRod;
	
	ServiceKalendarBeremenosti kalendarBerem;
	ServiceRaschetDatuRodov raschetRodov;
	ServiceOpredeleniePola polRebenka;
	ServiceTablitsaPricorma pricorm;
	ServiceRazvitiePoMesjacam poMesjacam;
	ServicePribavkaDoGoda doGoda;
	ServiceKalendarProvivok privivki;
	ServiceBudjetRodu rodu;
	ServiceBudjetMalusha malush;
	String folder = "Rasschetnue_Service";
	
	ObjavlinijaObjects serviceAdvert;
	By clickLastPage= By.xpath(".//div[@class='board']//a[@class = 'list_next']");
	
	MenuObjects menu;
	ForumObjects forum;
	
	DetskoePitanieObjects servicePitanie;
	
	@BeforeMethod
	public void beforeMethod() {
		driver = new FirefoxDriver();
		driver.get(adress);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
}
		
	
 

	
	@AfterClass
	public void tearDown() {
				driver.quit(); 
				
	
		}
}
