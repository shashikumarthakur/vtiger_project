package testNgPractice;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderTest{
	
	@Test(dataProvider = "getData")
	public void createContact(String lastName,String phoneNo) {
		System.out.println(lastName);
		System.out.println(phoneNo);
		Random ran=new Random();
		String input="DXC"+ran.nextInt(1000);
	/* Browser Configure */
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
	/* Login To Application */
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		/* create Contact */
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(phoneNo);
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
		/* Logout From Application */
		WebElement logout=driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td[1]/img"));
		Actions act=new Actions(driver);
		act.moveToElement(logout).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		driver.close();
		
	}
	
//	@Test(dataProvider = "getData")
//	public void createSecoundContact(String lastName,String phoneNo) {
//		Random ran=new Random();
//		String input="Testyantra"+ran.nextInt(1000);
//	/* Browser Configure */
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver=new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		driver.get("http://localhost:8888");
//	/* Login To Application */
//		driver.findElement(By.name("user_name")).sendKeys("admin");
//		driver.findElement(By.name("user_password")).sendKeys("root");
//		driver.findElement(By.id("submitButton")).click();
//		/* create Contact */
//		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
//		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
//		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(input);
//		driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(null);
//		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
//		/* Logout From Application */
//		WebElement logout=driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td[1]/img"));
//		Actions act=new Actions(driver);
//		act.moveToElement(logout).perform();
//		
//		driver.findElement(By.linkText("Sign Out")).click();
//		driver.close();
//	}
	@DataProvider
	public Object[][] getData() {
		Object[][] objArr=new Object[2][2];
		
		objArr[0][0]="Ambani";
		objArr[0][1]="9078885566";
		
		objArr[1][0]="Manhotra";
		objArr[1][1]="8800112233";
		
		return objArr;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
