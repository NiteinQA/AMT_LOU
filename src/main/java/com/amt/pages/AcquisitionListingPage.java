package com.amt.pages;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amt.testBase.TestBase;
import com.amt.testUtil.Click;
import com.amt.testUtil.ExplicitWait;
import com.amt.testUtil.GetExcelFormulaValue;

public class AcquisitionListingPage extends TestBase {

	
	

		@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-list[1]/div[2]/div[1]/div[1]/div[1]/div[2]/ag-grid-angular[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]")
		private WebElement aquisition_quotes_Listinglink;
		
		@FindBy(linkText = "Acquisition quotes")
		private WebElement aquisition_quotes_button;
		
		@FindBy(xpath = "//img[@alt='Loading...']")
		private List<WebElement> loading_icon;	

		
		@FindBy(xpath = "//span[normalize-space()='New quote']")
		private WebElement new_quote_button;
		
	    // list of quotes no. 
		@FindAll({ @FindBy(xpath = "//*[@ref='eCellWrapper']") })
		public List<WebElement> quotes_list;
		
		//copy_quote_button
		
		@FindBy(xpath = "//span[normalize-space()='Copy']")
		private WebElement acquisition_quote_copy_button;
		
			
				
		public AcquisitionListingPage() {
			PageFactory.initElements(driver, this);
		}		
		
		
		public void aquisition_Listingpage_AddnewQuote() throws InterruptedException {
			
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 20);

			JavascriptExecutor jse = (JavascriptExecutor)driver;
			
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
			
			
			//************Part 1 -- Getting quote no. from sheet ************************************	
			//Getting sheet name 
			String sheetName = "";

				if (Thread.currentThread().getStackTrace()[1].getMethodName()
						.contains("business_hire")) {
					sheetName = prop.getProperty("BrokerBCHQuoteNo");
				}

				if (Thread.currentThread().getStackTrace()[1].getMethodName()
						.contains("individual_hire")) {
					sheetName = prop.getProperty("BrokerPCHQuoteNo");
				}

				if (Thread.currentThread().getStackTrace()[1].getMethodName()
						.contains("business_purchase")) {
					sheetName = prop.getProperty("BrokerHPNRQuoteNo");
				}

				if (Thread.currentThread().getStackTrace()[1].getMethodName()
						.contains("individual_purchase")) {
					sheetName = prop.getProperty("BrokerPCPQuoteNo");
				}
				
				

		       //Getting quote no. from sheet
		        
				String quote_no = GetExcelFormulaValue.get_cell_value(1, 0, sheetName);

		//***************Part 2 - Copying the quote to make new quote***************************



					JavascriptExecutor jse = (JavascriptExecutor)driver;
					
					ExplicitWait.clickableElement(driver, aquisition_quotes_button, 30);

					jse.executeScript("arguments[0].click();", aquisition_quotes_button);
					
					
					
					

			
			for(WebElement e: quotes_list)
			{
			ExplicitWait.visibleElement(driver, e, 20);
			if(e.equals(quote_no))
			{
		        e.click();
				break;
			}
			
			}
			
		    Click.on(driver, acquisition_quote_copy_button, 25);
			
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 60);
			
			
			
		//*****************Part 3 - Opening the quote***************************

					 ExplicitWait.waitForListOfVisibleElements(driver, quotes_list, 30);
					 
					 //Get Coppied quote name
			         String newCoppiedQuote  =  quotes_list.get(1).getText();
					 
		//****************Part 4 -  Saving the copied quote to Quote save details as it will be used in LOU **************			 
					 
			try {		 
		   FileInputStream in = new FileInputStream(prop.getProperty("quote_save_excel_path"));
			XSSFWorkbook wb = new XSSFWorkbook(in);
		  
			wb.getSheet(sheetName).getRow(1).getCell(0).setCellValue(quote_no);
		    
			FileOutputStream out = new FileOutputStream(prop.getProperty("quote_save_excel_path"));
			wb.write(out);
			wb.close();
			}catch(Exception e) {}
			
			System.out.println("Quote coppied successfully and saved to Quote save Excel");
			LO.print          ("Quote coppied successfully and saved to Quote save Excel");
			
			
		//******************End of method*******************************************************	
			

			
		}
		



}
