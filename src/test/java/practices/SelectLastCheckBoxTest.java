package practices;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectLastCheckBoxTest {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		
		Thread.sleep(1000);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,5000);");
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//input[@onclick='check_object(this)'])[last()]")).click();
		Thread.sleep(2000);
		WebElement mouseover=driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td[1]/img"));
	
		Actions ac=new Actions(driver);
		ac.moveToElement(mouseover).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
