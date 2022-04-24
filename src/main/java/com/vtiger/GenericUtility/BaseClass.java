package com.vtiger.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.vtiger.objectRepository.HomePage;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Shashi
 *
 */
public class BaseClass {
	
	public WebDriver driver=null;
	public PropertyUtility pu=new PropertyUtility();
	public WebDriverUtility wdu=new WebDriverUtility();;
	public LoginPage lp=null;
	public HomePage hp=null;
	public static WebDriver sDriver=null;
	
	
	@BeforeSuite(groups = {"Smoke","Integration","Regration"})
	public void beforesuiteBS() {System.out.println("Data Base Connection and Initialization Or log Reprots");}
	
	@BeforeTest(groups = {"Smoke","Integration","Regration"})
	public void beforTestBT() {System.out.println("For Parallel Execution");}
	
	//@Parameters("browsers")
	@BeforeClass(groups = {"Smoke","Integration","Regration"})
	public void beforeClassBC(/*@Optional("chrome") String browser*/) throws Exception {
		
		String browser=pu.getPropertiesFileData("browser");
		String url=pu.getPropertiesFileData("url");
		
		if(browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			 driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			 driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		wdu.maximizeWindow(driver);
		
		wdu.waitForPageToLoad(driver);
		
		driver.get(url);
		
		sDriver=driver;
	}
	
	@BeforeMethod(groups = {"Smoke","Integration","Regration"})
	public void beforeMethodBM() throws Exception {
		lp=new LoginPage(driver);
		String user=pu.getPropertiesFileData("user");
		String pass=pu.getPropertiesFileData("pass");
		lp.loginApp(user, pass);
		
	}
	
	@AfterMethod(groups = {"Smoke","Integration","Regration"})
	public void afterMethodAM() {
		hp=new HomePage(driver);
		hp.Logout(driver);
	}
	
	
	@AfterClass(groups = {"Smoke","Integration","Regration"})
	public void afterClassAC() {
		driver.quit();
	}
	
	
	@AfterTest(groups = {"Smoke","Integration","Regration"})
	public void afterTestAT() {System.out.println("Close Parallel Execution");}
		
	@AfterSuite(groups = {"Smoke","Integration","Regration"})
	public void afterSuiteAS() {System.out.println("Close Datebase Connection");}
	

}
