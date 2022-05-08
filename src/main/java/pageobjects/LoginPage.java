package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	private By emailId=By.id("login-email");
	private By loginRegisterBtn=By.xpath("//button[@data-qs-id=\"login-btn-login\"]");
	private By password=By.id("login-password");
	private By login=By.xpath("//span[text()='Login']");
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getEmailId()
	{
		return driver.findElement(emailId);
	}
	
	public void setEmailId(String str)
	{
		driver.findElement(emailId).sendKeys(str);
	}
	
	public WebElement getLoginRegisterBtn()
	{
		return driver.findElement(loginRegisterBtn);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public void setPassword(String str)
	{
		driver.findElement(password).sendKeys(str);
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}



}
