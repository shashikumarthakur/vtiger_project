package practices;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.GenericUtility.ExcelUtility;
import com.vtiger.GenericUtility.JavaUtility;
import com.vtiger.GenericUtility.PropertyUtility;
import com.vtiger.GenericUtility.WebDriverUtility;
import com.vtiger.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginByPageFactoryTest {

	public static void main(String[] args) throws Exception {
	
		
		WebDriverUtility we=new WebDriverUtility();
		PropertyUtility prop=new PropertyUtility();
		String browser=prop.getPropertiesFileData("browser");
		String url=prop.getPropertiesFileData("url");
		String user=prop.getPropertiesFileData("user");
		String pass=prop.getPropertiesFileData("pass");
		WebDriver driver=null;
		
		/* Browser Choose */
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Browser Launch- Chrome");
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println("Browser Launch- FireFox");
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println("Browser Launch- Edge");
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println("Default Browser- Chrome ");
		}

		/* Maximize Browser Window */
		we.maximizeWindow(driver);

		/* Implecitly Wait */
		we.waitForPageToLoad(driver);

		/* Launch Browser With URL */
		driver.get(url);
		//
		LoginPage lp=new LoginPage(driver);
		lp.loginApp(user,pass);
	}

}
