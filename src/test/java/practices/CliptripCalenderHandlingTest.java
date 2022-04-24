package practices;

import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CliptripCalenderHandlingTest {
	
		
	public static void main(String[] args) {
	int date=20;
	String month="April 2022";
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter Date: ");
	date=sc.nextInt();
	System.out.print("Enter Month(String) and Year(Int): ");
	sc.skip("\\R?");
	month=sc.nextLine();//number
	
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://www.cleartrip.com/");
	driver.findElement(By.xpath("//*[@class='t-all ml-2']")).click();
	String path="//div[@class='DayPicker-Caption']/div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::div[@class='DayPicker-Body']/div/div/div/div[text()='"+date+"']";
	
	for (;;) {
		try {
			driver.findElement(By.xpath(path)).click();
			break;
		}
		catch(Exception e) {
			driver.findElement(By.xpath("//*[@data-testid='rightArrow']")).click();
		}
		
	}
	driver.close();
}
}