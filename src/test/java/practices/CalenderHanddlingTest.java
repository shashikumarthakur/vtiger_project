package practices;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderHanddlingTest {

	public static void main(String[] args) {
		
		int date=0;
		String month=null;
		int year=0;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a Date: ");
		date=sc.nextInt();
		System.out.print("Enter a Month (In String) : ");
		month=sc.next();
		System.out.print("Enter a Year: ");
		year=sc.nextInt();
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--disable-notifications");
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver(co);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/");
		
		driver.findElement(By.xpath("//div[@id='corover-close-btn']/img")).click();
		//driver.findElement(By.className("btn btn-primary")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//p-calendar[@formcontrolname='journeyDate']")).click();
		String path="//div[@class='ui-datepicker-group ui-widget-content ng-tns-c59-10 ng-star-inserted']/div/div/span[1][text()='"+month+"']/following-sibling::span[text()='"+year+"']/../../../div/following-sibling::div/table/tbody/tr/following-sibling::tr/td/a[text()='"+date+"']";
		
		//div[@class='ui-datepicker-group ui-widget-content ng-tns-c59-10 ng-star-inserted']/div/div/span[1][text()='March']/following-sibling::span[text()='2022']
		//div[@class='ui-datepicker-group ui-widget-content ng-tns-c59-10 ng-star-inserted']/div/div/span[1][text()='March']/following-sibling::span[text()='2022']/../../../div/following-sibling::div/table/tbody/tr/following-sibling::tr/td/a[text()='8']
		
		for(;;) {
			try {
				driver.findElement(By.xpath(path)).click();
				break;
			}
			catch(Exception e) {
				
				driver.findElement(By.xpath("//a[@class='ui-datepicker-next ui-corner-all ng-tns-c59-10 ng-star-inserted']")).click();
			}
		}
		
		driver.close();
		
	}

}
