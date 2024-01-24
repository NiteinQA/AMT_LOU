package com.amt.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amt.testBase.TestBase;
import com.amt.testUtil.Click;
import com.amt.testUtil.ExplicitWait;
import com.amt.testUtil.GetExcelFormulaValue;

public class AcquisitionListingPage extends TestBase {

	Properties prop;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-list[1]/div[2]/div[1]/div[1]/div[1]/div[2]/ag-grid-angular[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]")
	private WebElement aquisition_quotes_Listinglink;

	@FindBy(linkText = "Acquisition quotes")
	private WebElement aquisition_quotes_button;

	@FindBy(xpath = "//img[@alt='Loading...']")
	private List<WebElement> loading_icon;

	@FindBy(xpath = "//span[normalize-space()='New quote']")
	private WebElement new_quote_button;

	// acquisition_quote_search_bar
     @FindBy(xpath = "//*[@ref='eCenterContainer']")
	public WebElement quote_at_first_position;
     
 	// acquisition_quote_search_bar

 	@FindBy(xpath = "// *[@id='vehicleSearchInp']")
 	private WebElement acquisition_quote_search_bar;  
     
 	// save button
 	@FindBy(xpath = "//div[@class='row acquisition-menu']//div[3]//button[1]")
 	private WebElement quote_summary_save_button;
 	
	// ref no
	@FindBy(xpath = "//*[normalize-space()='Quote reference no.:']//ancestor::div[1]//span[2]")
	private WebElement quote_summary_ref_no;

	



	// copy_quote_button

	@FindBy(xpath = "//span[normalize-space()='Copy']")
	private WebElement acquisition_quote_copy_button;
	
	@FindBy(xpath = "//*[@id='dropdownRole']")
	private WebElement roles_dropdown;	
	
	
	@FindBy(xpath = "//*[contains(text(), 'Super Admin')]")
	private WebElement super_admin;

	public AcquisitionListingPage() {
		PageFactory.initElements(driver, this);

		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"D:\\LOU\\AMT_LOU\\src\\main\\java\\configs\\excelValues.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void aquisition_Listingpage_AddnewQuote() throws InterruptedException {

		Thread.sleep(25000);
		
		Click.on(driver, roles_dropdown, 60);
		
		 Thread.sleep(1000);
		
		Click.on(driver, super_admin, 60);		
					
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 120);
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		ExplicitWait.clickableElement(driver, aquisition_quotes_button, 30);

		jse.executeScript("arguments[0].click();", aquisition_quotes_button);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 20);

		ExplicitWait.clickableElement(driver, new_quote_button, 30);

		jse.executeScript("arguments[0].click();", new_quote_button);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 20);

		LO.print("Clicked on Quote button ");
		System.out.println("Clicked on Quote button ");
	}

	public void copy_quote() throws IOException, InterruptedException, ClassNotFoundException {

		// ************Part 1 -- Getting quote no. from sheet
		// ************************************
		// Getting sheet name
		
		String classOrMethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		
		String sheetName = quote_save_sheet_name_from_quote_save_excel_sheet(classOrMethodName);
		
		System.out.println("Using Sheet Name "+sheetName);

		// Getting quote no. from sheet

		String quote_no = GetExcelFormulaValue.get_cell_value(1, 0, sheetName);
		
		System.out.println("Using Quote number "+quote_no);

		// ***************Part 2 - Copying the quote to make new
		// quote***************************
		Thread.sleep(2000);
		
		Click.on(driver, aquisition_quotes_button, 60);
		
		Thread.sleep(5000);
		
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 120);
		
		Thread.sleep(2000);
		
		Click.sendKeys(driver, acquisition_quote_search_bar, quote_no, 60);		
		
		Thread.sleep(8000);
		
     	ExplicitWait.visibleElement(driver, quote_at_first_position, 30);
     	
     	
        Actions act = new Actions(driver);
     
        act.doubleClick(quote_at_first_position).perform();
       

    	ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 60);
    	
		Click.on(driver, acquisition_quote_copy_button, 25);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 60);

		// *****************Part 3 - Copying the quote***************************
	

		// Get Coppied quote name 
		
		ExplicitWait.visibleElement(driver, quote_summary_save_button, 30);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", quote_summary_save_button);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 150);
		
		ExplicitWait.visibleElement(driver, quote_summary_ref_no, 120);
		
		// quote no.
		String quote_ref_no = quote_summary_ref_no.getText();
		


		// ****************Part 4 - Saving the copied quote to Quote save details as it
		// will be used in LOU **************

		FileInputStream in = new FileInputStream(prop.getProperty("quote_save_excel_path"));
		XSSFWorkbook wb = new XSSFWorkbook(in);

		    
		wb.getSheet(sheetName).getRow(1).getCell(0).setCellValue(quote_ref_no);

		FileOutputStream out = new FileOutputStream(prop.getProperty("quote_save_excel_path"));
		wb.write(out);
		wb.close();


		System.out.println("New Quote generated after copy is "+quote_ref_no+" and saved to Quote save Excel in sheet named "+sheetName);
		LO.print("New Quote generated after copy is "+quote_ref_no+" and saved to Quote save Excel in sheet named "+sheetName);

		// ******************End of
		// method*******************************************************

	}

public String quote_save_sheet_name_from_quote_save_excel_sheet(String classOrMethodName) {
		String sheetName = "";
		
		if (classOrMethodName.contains("broker_business_hire")) {
			sheetName = prop.getProperty("BrokerBCHQuoteNo");
		}

		if (classOrMethodName.contains("broker_individual_hire")) {
			sheetName = prop.getProperty("BrokerPCHQuoteNo");
		}

		if (classOrMethodName.contains("broker_business_purchase")) {
			sheetName = prop.getProperty("BrokerHPNRQuoteNo");
		}

		if (classOrMethodName.contains("broker_individual_purchase")) {
			sheetName = prop.getProperty("BrokerPCPQuoteNo");
		}
		
		if (classOrMethodName.contains("ownbook_business_hire")) {
			
			if (classOrMethodName.contains("ownbook_business_hire_accept_with_changes_for_quotes_of_maint_exists"))
			{				
				sheetName = prop.getProperty("HPNRBCH_withMaint");					
			}else
			{
				sheetName = prop.getProperty("HPNRBCHQuoteNo");
			}
		}

		if (classOrMethodName.contains("ownbook_individual_hire")) {
			sheetName = prop.getProperty("HPNRPCHQuoteNo");
		}

		if (classOrMethodName.contains("ownbook_business_purchase")) {
			sheetName = prop.getProperty("HPNRHPNRQuoteNo");
		}

		if (classOrMethodName.contains("ownbook_individual_purchase")) {
			sheetName = prop.getProperty("HPNRPCPQuoteNo");
		}
		
		if (classOrMethodName.contains("ownbook_business_hire_funder")) {
			sheetName = prop.getProperty("HPNRBCHFunderQuoteNo");
		}
		
		if (classOrMethodName.contains("ownbook_individual_hire_funder")) {
			sheetName = prop.getProperty("HPNRPCHFunderQuoteNo");
		}
		
		if (classOrMethodName.contains("ownbook_business_purchase_funder")) {
			sheetName = prop.getProperty("HPNRHPNRFunderQuoteNo");
		}
		
		if (classOrMethodName.contains("ownbook_individual_purchase_funder")) {
			sheetName = prop.getProperty("HPNRPCPFunderQuoteNo");
		}
		
		if (classOrMethodName.contains("OP_OP")) {
			sheetName = prop.getProperty("OP-OP");
		}
		
		
		
		return sheetName;
	}




   public String calculation_sheet_name_from_quote_save_excel_sheet(String classOrMethodName) {
	String sheetName = "";
	
	
	if (classOrMethodName.contains("ownbook_business_hire")) {
		if(classOrMethodName.contains("used_car"))
		{
			sheetName = prop.getProperty("calculation_sheet_used_car_ownbook_business_hire");	
		}else
		{
		sheetName = prop.getProperty("calculation_sheet_ownbook_business_hire");
		}
		}

	if (classOrMethodName.contains("ownbook_individual_hire")) {
		
		if(classOrMethodName.contains("used_car"))
		{
			sheetName = prop.getProperty("calculation_sheet_used_car_ownbook_individual_hire");	
		}else
		{
			sheetName = prop.getProperty("calculation_sheet_ownbook_individual_hire");
		}
		
		
	}

	if (classOrMethodName.contains("ownbook_business_purchase")) {
		
		if(classOrMethodName.contains("used_car"))
		{
			sheetName = prop.getProperty("calculation_sheet_used_car_ownbook_business_purchase");	
		}else
		{
			sheetName = prop.getProperty("calculation_sheet_ownbook_business_purchase");
		}
				
	}

	if (classOrMethodName.contains("ownbook_individual_purchase")) {
		
		
		if(classOrMethodName.contains("used_car"))
		{
			sheetName = prop.getProperty("calculation_sheet_used_car_ownbook_individual_purchase");	
		}else
		{
			sheetName = prop.getProperty("calculation_sheet_ownbook_individual_purchase");
		}
		
		
	}

	
	
	if (classOrMethodName.contains("ownbook_business_hire_funder")) {
		
		if(classOrMethodName.contains("used_car"))
		{
			sheetName = prop.getProperty("calculation_sheet_used_car_ownbook_business_hire_funder");
	
		}else {		
		sheetName = prop.getProperty("calculation_sheet_ownbook_business_hire_funder");
		}
		}
	

	
	if (classOrMethodName.contains("ownbook_individual_hire_funder")) {
		
		if(classOrMethodName.contains("used_car"))
		{
			sheetName = prop.getProperty("calculation_sheet_used_car_ownbook_individual_hire_funder");

		}else
		{
			sheetName = prop.getProperty("calculation_sheet_ownbook_individual_hire_funder");

		}
		
		
	}
	

	
	
	if (classOrMethodName.contains("ownbook_business_purchase_funder")) {
		
		if(classOrMethodName.contains("used_car"))
		{
			sheetName = prop.getProperty("calculation_sheet_used_car_ownbook_business_purchase_funder");

		}else
		{
			sheetName = prop.getProperty("calculation_sheet_ownbook_business_purchase_funder");
	
		}
			
	}
	
	if (classOrMethodName.contains("ownbook_individual_purchase_funder")) {
	
		if(classOrMethodName.contains("used_car"))
		{
			sheetName = prop.getProperty("calculation_sheet_used_car_ownbook_individual_purchase_funder");

		}else
		{
			sheetName = prop.getProperty("calculation_sheet_ownbook_individual_purchase_funder");

		}		
	}
	
	return sheetName;
}
}
