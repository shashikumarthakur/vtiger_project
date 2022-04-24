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
public class OrganizationPopupPage {
	
/**
 *  It is Use for Initialize the variables with WebElements 
 * @param driver
 */

public OrganizationPopupPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
}

@FindBy(xpath = "//input[@name='search_text']")
private WebElement searchTextField;

@FindBy(xpath = "//input[@name='search']")
private WebElement searchButton;

public WebElement getSearchTextField() {
	return searchTextField;
}

public WebElement getSearchButton() {
	return searchButton;
}

/**
 * This Method Select data of popup window with dynamic values
 * @param driver
 * @param orgName
 */
	public void dynamicXpath(WebDriver driver,String orgName) {
		
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
	}
}
