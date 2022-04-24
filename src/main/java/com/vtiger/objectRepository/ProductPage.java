package com.vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Shashi
 *
 */

public class ProductPage {
	
	/**
	 * It is Use for Initialize the variables with WebElements
	 * @param driver
	 */
	public ProductPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="img[title='Create Product...']")
	private WebElement createProductIcon;
	

	public WebElement getCreateProductIcon() {
		return createProductIcon;
	}
	
	
	
	
	
	
}
