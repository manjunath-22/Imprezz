package testcases;

import java.io.IOException;
import java.time.Duration;

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

import pageobjects.HomePage;
import pageobjects.InvoicePage;
import pageobjects.LoginPage;
import resources.Base;
import utilities.ExcelUtils;

public class TC_002_View_invoice extends Base{
	
	LoginPage login;
	HomePage home;
	InvoicePage invoice;
	Actions action;
	WebDriverWait wait;
	
	public WebDriver driver;
	JavascriptExecutor executor;
	ExcelUtils excel;
	String excelPath=System.getProperty("user.dir")+"\\TestData\\TestData.xlsx";
	String sheetName="TC_002";
	String emailID;
	String password;
	String invoiceNo;
	
	
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
		invoiceNo=excel.getCellData(excelPath,sheetName,1,2);
		
		login.setEmailId(emailID);
		login.getLoginRegisterBtn().click();
		login.setPassword(password);
		login.getLogin().click();
		home.getSalesBtn().click();
		home.getInvoiceBtn().click();
		home.getInvoiceNumber(invoiceNo).click();
		String invoiceNoText=home.getInvoiceNoText().getText();
		Assert.assertTrue(invoiceNoText.contains(invoiceNo));
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}

}
