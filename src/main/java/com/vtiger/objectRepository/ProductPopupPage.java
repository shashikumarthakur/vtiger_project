package com.vtiger.objectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Shashi
 *
 */
public class ProductPopupPage {
	
	/**
	 *  It is Use for Initialize the variables with WebElements 
	 * @param driver
	 */
	public ProductPopupPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchField;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchButton;

	public WebElement getSearchField() {
		return searchField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}
	
	/**
	 * This Method Select data of popup window with dynamic values
	 * @param driver
	 * @param productName
	 */
	public void dynamicXpath(WebDriver driver,String productName) {
		
		driver.findElement(By.xpath("//a[text()='"+productName+"']")).click();
	}
	

}
