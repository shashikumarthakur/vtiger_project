package practices;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectAllCheckBoxTest {

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
		List <WebElement> checkbox=	driver.findElements(By.xpath("//input[@onclick='check_object(this)']"));
		WebElement mouseover=driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td[1]/img"));
		
		for(WebElement wl:checkbox) {
			Thread.sleep(500);
			wl.click();
		}
		
		Actions ac=new Actions(driver);
		ac.moveToElement(mouseover).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}

}
