package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InvoicePage {

	public WebDriver driver;
	
	private By createInvoiceBtn=By.cssSelector("[class=\"button button-primary button-rounded  \"]");
	private By enterCustomerBtn=By.cssSelector("[class=\"recipientEmpty_label\"]");
	private By enterCustomerTextBox=By.cssSelector("[id=\"react-select-4--value\"]");
	private By enterArticleBtn=By.xpath("//div[contains(text(),'Enter article')]");
	private By descriptionTextBox=By.cssSelector("[name=\"title\"]");
	private By hsnTextBox=By.cssSelector("[name=\"hsnSacCode\"]");
	private By quantity=By.cssSelector("[name=\"amount\"]");
	private By price=By.cssSelector("[name=\"price\"]");
	private By discount=By.xpath("//span[@class=\"discountDisplay\"]");
	private By dicountPercentage=By.cssSelector("[name=\"discountPercent\"]");
	private By saveBtn=By.cssSelector("[class=\"button button-primary button-rounded  \"]");
	private By invoiceSection=By.cssSelector("[placeholder=\"Invoice\"]");
	private By finaliseBtn=By.xpath("//button[@data-qs-id=\"invoiceDetail-topbar-btn-lockInvoice\"]/span[@class=\"text-content\"]/span");
	private By finaliseNowBtn=By.cssSelector("[data-qs-id=\"modal-btn-confirm\"]");
	public By message=By.xpath("//div[@class='message']");
	public By outerMenu=By.xpath("//div[@class=\\\"Select-menu-outer\\\"]");

	
	public InvoicePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getCreateInvoiceBtn()
	{
		return driver.findElement(createInvoiceBtn);
	}

	public WebElement getEnterCustomerBtn()
	{
		return driver.findElement(enterCustomerBtn);
	}
	
	public WebElement getEnterCustomerTextBox()
	{
		return driver.findElement(enterCustomerTextBox);
	}
	
	public WebElement getEnterArticleBtn()
	{
		return driver.findElement(enterArticleBtn);
	}
	
	public WebElement getDescriptionTextBox()
	{
		return driver.findElement(descriptionTextBox);
	}
	
	public WebElement getHsnTextBox()
	{
		return driver.findElement(hsnTextBox);
	}
	
	public void setHsnTextBox(String str)
	{
		driver.findElement(hsnTextBox).sendKeys(str);
	}
	
	public WebElement getQuantity()
	{
		return driver.findElement(quantity);
	}
	
	public void setQuantity(String str)
	{
		driver.findElement(quantity).sendKeys(str);
	}
	
	public WebElement getPrice()
	{
		return driver.findElement(price);
	}
	
	public void setPrice(String str)
	{
		driver.findElement(price).sendKeys(str);
	}

	public WebElement getDiscount()
	{
		return driver.findElement(discount);
	}
	
	public WebElement getDiscountPercentage()
	{
		return driver.findElement(dicountPercentage);
	}
	
	public void setDiscountPercentage(String str)
	{
		driver.findElement(dicountPercentage).sendKeys(str);
	}
	
	public WebElement getSaveBtn()
	{
		return driver.findElement(saveBtn);
	}
	
	public WebElement getInvoiceSection()
	{
		return driver.findElement(invoiceSection);
	}
	
	public WebElement getFinalise()
	{
		return driver.findElement(finaliseBtn);
	}
	
	public WebElement getFinaliseNowBtn()
	{
		return driver.findElement(finaliseNowBtn);
	}
	
	public WebElement getMessage()
	{
		return driver.findElement(message);
	}
	
}
