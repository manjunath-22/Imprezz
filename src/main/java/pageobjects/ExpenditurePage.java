package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ExpenditurePage {
	
	public WebDriver driver;
	private By createExpenditure=By.xpath("//div[@class=\"topbar-buttons\"]/div/button");
	private By enterPayee=By.xpath("//div[text()='Enter payee']");
	private By invoiceDate=By.cssSelector("[name=\"expense-booking-date\"]");
	private By invoiceNo=By.cssSelector("[data-qs-id=\"expense-edit-receipt-no\"]");
	
	private By enterArticleBtn=By.xpath("//div[contains(text(),'Enter article')]");
	private By descriptionTextBox=By.cssSelector("[class=\"Select-control\"]");
	private By hsnTextBox=By.cssSelector("[name=\"hsnSacCode\"]");
	private By quantity=By.cssSelector("[name=\"amount\"]");
	private By price=By.cssSelector("[name=\"price\"]");
	private By discount=By.xpath("//span[@class=\"discountDisplay\"]");
	private By dicountPercentage=By.cssSelector("[name=\"discountPercent\"]");
	private By paidBtn=By.cssSelector("[data-qs-id=\"expense-edit-ispaid\"]");
	private By saveBtn=By.cssSelector("[class=\"button button-primary button-rounded  \"]");
	private By saveNowBtn=By.cssSelector("[data-qs-id=\"modal-btn-confirm\"]");
	public By message=By.xpath("//div[@class='message']");
	
	public ExpenditurePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getCreateExpenditure()
	{
		return driver.findElement(createExpenditure);
	}
	
	public WebElement getEnterPayee()
	{
		return driver.findElement(enterPayee);
	}
	
	public WebElement getInvoiceDate()
	{
		return driver.findElement(invoiceDate);
	}
	
	public void setInvoiceDate(String str)
	{
		driver.findElement(invoiceDate).sendKeys(str);
	}
	
	public WebElement getInvoiceNo()
	{
		return driver.findElement(invoiceNo);
	}
	
	public void setInvoiceNo(String str)
	{
		driver.findElement(invoiceNo).sendKeys(str);
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
	
	public WebElement getPaidBtn()
	{
		return driver.findElement(paidBtn);
	}
	
	public WebElement getSaveBtn()
	{
		return driver.findElement(saveBtn);
	}

	public WebElement getSaveNowBtn()
	{
		return driver.findElement(saveNowBtn);
	}
	
	public WebElement getMessage()
	{
		return driver.findElement(message);
	}
}
