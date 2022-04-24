package testNgPractice;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.vtiger.GenericUtility.JavaUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 
		 driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		 driver.manage().window().maximize();
		 driver.get("https://www.spicejet.com/");
		 ChromeOptions opt=new ChromeOptions();
		 opt.addArguments("--disable-notification");
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//div[text()='round trip']/ancestor::div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-117bsoe r-1otgn73']/div[@class='css-1dbjc4n r-zso239']/*[name()='svg']/*")).click();
	}
	
	
}
	 
