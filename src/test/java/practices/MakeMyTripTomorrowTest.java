package practices;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTripTomorrowTest {

	public static void main(String[] args) throws InterruptedException {
		 String src="Ranchi, India";
		 String dest="Hyderabad, India";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		LocalDateTime localTime=LocalDateTime.now().plusDays(2);
		
		int year=localTime.getYear();
		
		int tomorrowDate=localTime.getDayOfMonth();
		
		String month=localTime.getMonth().toString();
		month=month.substring(0,1)+month.substring(1).toLowerCase();
		
		String monthAndYear=month+" "+year;
		
		
		   Actions action=new Actions(driver);
	       action.moveByOffset(10, 10).click().perform();
	       driver.findElement(By.xpath("//span[text()='From']")).click();
	       driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(src);
	       driver.findElement(By.xpath("//div[@class='makeFlex hrtlCenter']/descendant::div/p[text()='"+src+"']")).click();
	       driver.findElement(By.xpath("//span[text()='To']")).click();
	       driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(dest);
	       driver.findElement(By.xpath("//div[@class='makeFlex hrtlCenter']/descendant::div/p[text()='"+dest+"']")).click();
	    //   driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
	       driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
	       String path="//div[text()='"+monthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+tomorrowDate+"']";
	       
	       for(;;) {
	    	   try {
	    		   driver.findElement(By.xpath(path)).click();
	    		   break;
	    		   
	    	   }catch (Exception e) {
	    		   driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		
	    	   }
	    	   
	       }
	       driver.findElement(By.xpath("//a[text()='Search']")).click(); 
	       Thread.sleep(2000);
	       WebElement close=driver.findElement(By.xpath("//button[text()='OKAY, GOT IT!']"));
	       WebDriverWait wait=new WebDriverWait(driver,10);
	       wait.until(ExpectedConditions.elementToBeClickable(close)).click();
	       List<WebElement> allFlights=driver.findElements(By.xpath("//div[@class='makeFlex simpleow']/descendant::span/following-sibling::div/span"));
	       int count=1;
	       for(WebElement wl:allFlights) {
	    	   
	    	   String list=wl.getText();
	    	System.out.println(count+" "+list);   
	    	count++;
	       }
		}
	}