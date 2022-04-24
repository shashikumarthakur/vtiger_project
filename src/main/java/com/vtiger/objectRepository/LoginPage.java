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
public class LoginPage {
	
	/**
	 *  It is Use for Initialize the variables with WebElements 
	 * @param driver
	 */
	public LoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}

	@FindBy(name="user_name")
	private WebElement userIdField;
	
	@FindBy(name="user_password")
	private WebElement passwordField;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;

	public WebElement getUserIdField() {
		return userIdField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	/**
	 * With this method user can login
	 * @param username
	 * @param password
	 */
	public void loginApp(String username,String password) {
		userIdField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
	}
	

}
