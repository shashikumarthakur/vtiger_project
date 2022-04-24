package practices;

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

public class DataProviderCreateContact {
	
	/* In Data Provider @Test Script Will Execute As Per Set Of Data Is Available In @DataProvider */
	
	
	@Test(dataProvider = "getData")
	public void createContact(String lastName,String phoneNo) {
		System.out.println(lastName);
		System.out.println(phoneNo);

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
	
	@DataProvider
	public Object[][] getData() {
		Object[][] objArr=new Object[2][2];
		
		objArr[0][0]="Bachan";
		objArr[0][1]="9078885566";
		
		objArr[1][0]="Reddy";
		objArr[1][1]="8800112233";
		
		objArr[2][0]="Mehta";
		objArr[2][1]="5464644656";
		
		objArr[3][0]="Thakur";
		objArr[3][1]="9078634173";
		
		objArr[4][0]="Tiwari";
		objArr[4][1]="5623987412";
		
		objArr[5][0]="Singh";
		objArr[5][1]="4455887711";
		
		
		return objArr;
		
	}
}
