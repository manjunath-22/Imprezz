package testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageobjects.HomePage;
import pageobjects.InvoicePage;
import pageobjects.LoginPage;
import resources.Base;
import utilities.ExcelUtils;

public class TC_001_Create_an_invoice extends Base {
	
	LoginPage login;
	HomePage home;
	InvoicePage invoice;
	Actions action;
	WebDriverWait wait;
	String customerName="Test";
	String expectedMessage="Finalise";
	String expectedFinalMessage="The invoice was finalized successfully.";
	ExcelUtils excel;
	String excelPath=System.getProperty("user.dir")+"\\TestData\\TestData.xlsx";
	String sheetName="TC_001";
	
	String emailID;
	String password;
	String user;
	String invoiceNo;
	String article;
	String hsn;
	String quantity;
	String price;
	String discountPercentage;
	
	public WebDriver driver;
	JavascriptExecutor executor;
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	
	@Test
	public void TC_001() throws InterruptedException, IOException
	{
		login=new LoginPage(driver);
		action=new Actions(driver);
		home=new HomePage(driver);
		invoice=new InvoicePage(driver);
		executor = (JavascriptExecutor) driver;
		excel=new ExcelUtils();
		
		
		emailID=excel.getCellData(excelPath,sheetName,1,0);
		password=excel.getCellData(excelPath,sheetName,1,1);
		user=excel.getCellData(excelPath,sheetName,1,2);
		article=excel.getCellData(excelPath,sheetName,1,3);
		hsn=excel.getCellData(excelPath,sheetName,1,4);
		quantity=excel.getCellData(excelPath,sheetName,1,5);
		price=excel.getCellData(excelPath,sheetName,1,6);
		discountPercentage=excel.getCellData(excelPath,sheetName,1,7);
		
		login.setEmailId(emailID);
		login.getLoginRegisterBtn().click();
		login.setPassword(password);
		login.getLogin().click();
		home.getSalesBtn().click();
		home.getInvoiceBtn().click();
		invoice.getCreateInvoiceBtn().click();
		
		executor.executeScript("arguments[0].click()",invoice.getEnterCustomerBtn());
		action.sendKeys(user).build().perform();
		action.sendKeys(Keys.DOWN);
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(invoice.outerMenu));
	    
		action.sendKeys(Keys.ENTER);
		action.build().perform();
		
		executor.executeScript("arguments[0].scrollIntoView(true)", invoice.getInvoiceSection());
		
		
		invoice.getEnterArticleBtn().click();
		executor.executeScript("arguments[0].click()",invoice.getDescriptionTextBox());
		action.sendKeys(article).build().perform();
		action.sendKeys(Keys.ENTER);
		action.build().perform();
		
		invoice.setHsnTextBox(hsn);
		invoice.setQuantity(quantity);
		invoice.setPrice(price);
		invoice.getDiscount().click();
		invoice.setDiscountPercentage(discountPercentage);
		invoice.getSaveBtn().click();
		
		
		invoice.getFinalise().click();
		
		invoice.getFinaliseNowBtn().click();
		
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.presenceOfElementLocated(invoice.message));
	    
		String actualFinalMessage=invoice.getMessage().getText();
		Assert.assertEquals(actualFinalMessage,expectedFinalMessage);
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	

}
