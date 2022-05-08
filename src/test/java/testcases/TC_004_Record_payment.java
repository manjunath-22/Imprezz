package testcases;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageobjects.ExpenditurePage;
import pageobjects.HomePage;
import pageobjects.InvoicePage;
import pageobjects.LoginPage;
import resources.Base;
import utilities.ExcelUtils;
public class TC_004_Record_payment extends Base {	
	LoginPage login;
	HomePage home;
	ExpenditurePage expenditure;
	InvoicePage invoice;
	Actions action;
	WebDriverWait wait;	
	public WebDriver driver;
	JavascriptExecutor executor;	
	String expectedFinalMessage="The expense has been saved";
	ExcelUtils excel;
	String excelPath=System.getProperty("user.dir")+"\\TestData\\TestData.xlsx";
	String sheetName="TC_004";	
	String emailID;
	String password;
	String user;
	String invoiceNo;
	String article;
	String hsn;
	String quantity;
	String price;
	String discountPercentage;	
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
		expenditure=new ExpenditurePage(driver);
		executor = (JavascriptExecutor) driver;
		excel=new ExcelUtils();		
		emailID=excel.getCellData(excelPath,sheetName,1,0);
		password=excel.getCellData(excelPath,sheetName,1,1);
		user=excel.getCellData(excelPath,sheetName,1,2);
		invoiceNo=excel.getCellData(excelPath,sheetName,1,3);
		article=excel.getCellData(excelPath,sheetName,1,4);
		hsn=excel.getCellData(excelPath,sheetName,1,5);
		quantity=excel.getCellData(excelPath,sheetName,1,6);
		price=excel.getCellData(excelPath,sheetName,1,7);
		discountPercentage=excel.getCellData(excelPath,sheetName,1,8);	
		login.setEmailId(emailID);
		login.getLoginRegisterBtn().click();
		login.setPassword(password);
		login.getLogin().click();
		home.getExpenditureBtn().click();
		expenditure.getCreateExpenditure().click();
		action.sendKeys(user).build().perform();
		expenditure.getEnterPayee().click();
		action.sendKeys(Keys.DOWN);
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(invoice.outerMenu));
	    
		action.sendKeys(Keys.ENTER);
		action.build().perform();
		
		expenditure.setInvoiceNo(invoiceNo);
		
		expenditure.getEnterArticleBtn().click();
		executor.executeScript("arguments[0].click()",expenditure.getDescriptionTextBox());
		action.sendKeys(article).build().perform();
		action.sendKeys(Keys.ENTER);
		action.build().perform();
		
		expenditure.setHsnTextBox(hsn);
		expenditure.setQuantity(quantity);
		expenditure.setPrice(price);
		expenditure.getDiscount().click();
		expenditure.setDiscountPercentage(discountPercentage);
		
		executor.executeScript("arguments[0].scrollIntoView(true)", expenditure.getPaidBtn());
		expenditure.getPaidBtn().click();
		
		expenditure.getSaveBtn().click();
		expenditure.getSaveNowBtn().click();
		
		String actualFinalMessage=expenditure.getMessage().getText();
		Assert.assertEquals(actualFinalMessage,expectedFinalMessage);
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
