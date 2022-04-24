package practices;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * 
 * @author Shashi
 *
 */
public class OrganizationListSearchTest {
	public static void main(String[] args) throws InterruptedException {
		int count=1;
		
	/* Random Number With Thier Name(For Unique Organization Name) */
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
	/* create Organization */
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();
		driver.findElement(By.cssSelector("input[name='accountname']")).sendKeys(input);
		driver.findElement(By.cssSelector("input[title='Save [Alt+S]']")).click();
	/* Avoiding StealElementRefrenceException (Freash DOM To Be Loaded) */
		Navigation nav=driver.navigate();
		nav.refresh();
	/* Scroling Down For Better View or Avoiding NoSuchElementException */
		driver.findElement(By.linkText("Organizations")).click();
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("window.scrollBy(0,3000);");
	/* PageCount For Using In For Loop And Arrange In Formate */
		String pageCount=driver.findElement(By.xpath("//span[@name='Accounts_listViewCountContainerName']")).getText();
		pageCount=pageCount.substring(3);
		int pageCounts=Integer.parseInt(pageCount);
		
		
		//List<WebElement> allList=driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]/a"));
		
	/* For Counting and List Of All Organization Name */
		for(int i=1;i<=pageCounts;i++) {
		List<WebElement> allList=driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]/a"));
			for(WebElement wb:allList) {
			String text=wb.getText();
			System.out.println(count+" -"+text);
			count++;
				if(text.contains(input)){
				wb.click();
				driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
				driver.switchTo().alert().accept();
				}	
			}
	/* For Avoiding Exception While Clicking Next Page At Last Page */
			try {
			WebElement nextPage=driver.findElement(By.xpath("//a[@title='Next']/img"));
			nextPage.click();
			Thread.sleep(2000);
			}
			catch(Exception e) {
			System.out.println("Page Number- "+pageCounts);
			}	
		}	
		
	/* Logout From Application */
		WebElement logout=driver.findElement(By.xpath("//span[@class='userName']/../following-sibling::td[1]/img"));
		Actions act=new Actions(driver);
		act.moveToElement(logout).perform();
		
		driver.findElement(By.linkText("Sign Out")).click();
		
	} 	//Main Method			
} 		//Class
	


