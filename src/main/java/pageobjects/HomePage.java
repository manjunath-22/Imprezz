package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	public WebDriver driver;
	private By salesBtn=By.xpath("//div[@data-qs-id=\"global-menu-item-invoices\"]");
	private By invoiceBtn=By.cssSelector("[data-qs-id=\"global-menu-item-invoices\"]");
	private By invoiceNoText=By.xpath("//div[@class=\"topbar-title\"]");
	private By sendEmail=By.cssSelector("[data-qs-id=\"invoiceDetail-head-action-email\"]");
	private By sendEmailBtn=By.cssSelector("[data-qs-id=\"emailSend-topbar-btn-send\"]");
	private By sendEmailMessage=By.xpath("//div[@class=\"message\"]");
	private By expenditureBtn=By.cssSelector("[data-qs-id=\"global-menu-item-expenditure\"]");
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getSalesBtn()
	{
		return driver.findElement(salesBtn);
	}
	
	public WebElement getInvoiceBtn()
	{
		return driver.findElement(invoiceBtn);
	}
	
	public WebElement getInvoiceNumber(String str)
	{
		return driver.findElement(By.xpath("//div[@col-id=\"number\"]/span[text()='"+str+"']"));
	}
	
	public WebElement getInvoiceNoText()
	{
		return driver.findElement(invoiceNoText);
	}
	
	public WebElement getSendEmail()
	{
		return driver.findElement(sendEmail);
	}
	
	public WebElement getSendEmailBtn()
	{
		return driver.findElement(sendEmailBtn);
	}
	
	public WebElement getSendEmailMessage()
	{
		return driver.findElement(sendEmailMessage);
	}
	
	public WebElement getExpenditureBtn()
	{
		return driver.findElement(expenditureBtn);
	}
	
}
