package com.amt.QuoteSummaryPages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amt.testBase.TestBase;
import com.amt.testUtil.Click;
import com.amt.testUtil.ExplicitWait;
import com.amt.testUtil.ReadExcelCalculation;
import com.amt.testUtil.RemoveComma;

public class QuoteSummaryBrokerBCHPage extends TestBase {
	
	
	
	ReadExcelCalculation obj_read_excel_calculation_page; 
	
	@FindBy(xpath = "//img[@alt='Loading...']")
	private List<WebElement> loading_icon;

	@FindBy(xpath = "//p[normalize-space()='Quote summary']")
	private WebElement quote_summary;
	
//	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-generic[1]/form[1]/div[1]/div[1]/div[1]/app-acquisition-summary-quote[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-vehicle-details[1]/div[1]/div[1]/div[2]/div[1]/div[2]/app-vehicle-summery[1]/div[1]/div[1]/div[2]/div[2]/div[3]/span[2]")
//	private WebElement quote_summary_ref_no;
	
	@FindBy(xpath = "//*[@class='right-fix vechile-summery']/div/div[2]/div[2]/div[4]/span[2]")
	private WebElement quote_summary_ref_no;
	
	@FindBy(xpath = "//*[@class='row']//*[@id='headingTwo']/div/div/div[4]/div/p/strong")
	private WebElement quote_summary_cost_otr_price;
	
	
	
	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-generic[1]/form[1]/div[1]/div[1]/div[1]/app-acquisition-summary-quote[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[8]/div[1]/div[1]/p[1]/strong[1]")
	private WebElement quote_summary_total_monthly_holding_cost;
	
//	@FindBy(xpath = "//*[@class='row']//*[@id='headingHoldingCost']/div/div[8]/div/div/p/strong")
//	private WebElement quote_summary_total_monthly_holding_cost;
	
//	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-generic[1]/form[1]/div[1]/div[1]/div[1]/app-acquisition-summary-quote[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[5]/div[1]/app-acquisition-quote-summary[1]/div[1]/div[2]/app-hire-customer-quote-summary-header[1]/div[1]/div[4]/div[1]/p[1]/strong[1]")
//	private WebElement quote_summary_monthly_finance_rental;
	
	@FindBy(xpath = "//*[@id=\"headingBchSummary\"]/div/app-broker-bch-customer-quote-summary-header/div/div[4]/div/p/strong")
	private WebElement quote_summary_monthly_finance_rental;
	
//  @FindBy(xpath = "//body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-generic[1]/form[1]/div[1]/div[1]/div[1]/app-acquisition-summary-quote[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/app-acquisition-quote-summary[1]/div[1]/div[2]/app-hire-customer-quote-summary-header[1]/div[1]/div[5]/div[1]/p[1]/strong[1]")
//	private WebElement quote_summary_monthly_maintenance_rental;
	
	@FindBy(xpath = "//*[@class='row']//*[@id='headingCustomerQuote']/div[2]/app-hire-customer-quote-summary-header/div/div[5]/div/p/strong")
	private WebElement quote_summary_monthly_maintenance_rental;
	
//	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-generic[1]/form[1]/div[1]/div[1]/div[1]/app-acquisition-summary-quote[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/app-acquisition-quote-summary[1]/div[1]/div[2]/app-hire-customer-quote-summary-header[1]/div[1]/div[6]/div[1]/p[1]/strong[1]")
//	private WebElement quote_summary_monthly_total_rental;
	
	@FindBy(xpath = "//*[@class='row']//*[@id='headingCustomerQuote']/div[2]/app-hire-customer-quote-summary-header/div/div[6]/div/p/strong")
	private WebElement quote_summary_monthly_total_rental;
	
	@FindBy(xpath = "//*[@class='row']//*[@id='headingHoldingCost']/div/div[1]/div/div/p/strong")
	private WebElement quote_summary_acq_contract_type;
	
	@FindBy(xpath = "//strong[normalize-space()='Business Contract Hire']")
	private WebElement quote_summary_customer_contract_type;
	
	@FindBy(xpath = "//div[@id='headingHoldingCost']//div[7]//div[1]//div[1]//p[1]//strong[1]")
	private WebElement quote_summary_total_monthly_holding_cost_without_maintenance;

	
	
	public QuoteSummaryBrokerBCHPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean quote_summary_broker_BCH_without_maintenance(String sheet_name) throws InterruptedException, IOException {
		
		LO.print("*************Calculations for Quote Summary page gas been started************");
		System.out.println("*************Calculations for Quote Summary page gas been started************");
		
		obj_read_excel_calculation_page =new ReadExcelCalculation();
		
		Click.on(driver, quote_summary, 90);
		
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 35);
	
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER).build().perform();
		
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
		
	    ExplicitWait.visibleElement(driver, quote_summary_ref_no, 120);
		ExplicitWait.visibleElement(driver, quote_summary_cost_otr_price, 60);
		ExplicitWait.visibleElement(driver, quote_summary_customer_contract_type, 60);
		
		LO.print("Reading values from sceen -Quote Summary Page");
		System.out.println("Reading values from sceen -Quote Summary Page");
		
	    String quote_ref_no = quote_summary_ref_no.getText();
		String temp_quote_summary_cost_otr_price=quote_summary_cost_otr_price.getText().trim().substring(2);
		String customer_contract_type=quote_summary_customer_contract_type.getText();
		
		
		LO.print("Getting values from screen");
		System.out.println("Getting values from screen");
		
		LO.print("Quote_summary_cost_otr_price ="+temp_quote_summary_cost_otr_price);
		System.out.println("Quote_summary_cost_otr_price ="+temp_quote_summary_cost_otr_price);
			
		LO.print("Customer contract_type ="+customer_contract_type);
		System.out.println("Customer contract_type ="+customer_contract_type);	
		
		LO.print("Customer Quote generated successfully and Quote_ref_no ="+quote_ref_no);
		System.out.println("Customer Quote generated successfully and Quote_ref_no ="+quote_ref_no);
		
		String quote_summary_cost_otr_price_from_screen=RemoveComma.of(temp_quote_summary_cost_otr_price);
			
		double quote_summary_cost_otr_price_from_screen_converted =Double.parseDouble(quote_summary_cost_otr_price_from_screen);

		
		FileInputStream in = new FileInputStream(prop.getProperty("quote_save_excel_path"));
		XSSFWorkbook wb = new XSSFWorkbook(in);
		
		wb.getSheet("BrokerBCHQuoteNo").getRow(0).getCell(0).setCellValue(quote_ref_no);
		
		
		FileOutputStream out = new FileOutputStream(prop.getProperty("quote_save_excel_path"));
		wb.write(out);
	wb.close();
		
		
		return obj_read_excel_calculation_page.verify_quote_summary_values_for_broker_bch_pch_fl_from_excel_without_maintenance(quote_summary_cost_otr_price_from_screen_converted, 
		 sheet_name);	

	}

	public boolean quote_summary_broker_BCH_with_maintenance(String sheet_name) throws InterruptedException, IOException {
		
		LO.print("*************Calculations for Quote Summary page gas been started************");
		System.out.println("*************Calculations for Quote Summary page gas been started************");
		
		obj_read_excel_calculation_page =new ReadExcelCalculation();
		Click.on(driver, quote_summary, 60);
		
		Thread.sleep(12000);

		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER).build().perform();		
		
		Thread.sleep(35000);

			
		
		ExplicitWait.visibleElement(driver, quote_summary_ref_no, 120);
		ExplicitWait.visibleElement(driver, quote_summary_cost_otr_price, 120);
		ExplicitWait.visibleElement(driver, quote_summary_customer_contract_type, 120);
		
		LO.print("Reading values from sceen -Quote Summary Page");
		System.out.println("Reading values from sceen -Quote Summary Page");
		
	    String quote_ref_no = quote_summary_ref_no.getText();
		String temp_quote_summary_cost_otr_price=quote_summary_cost_otr_price.getText().trim().substring(2);
		String customer_contract_type=quote_summary_customer_contract_type.getText();
		
		
		LO.print("Getting values from screen");
		System.out.println("Getting values from screen");
		
		LO.print("Quote_summary_cost_otr_price ="+temp_quote_summary_cost_otr_price);
		System.out.println("Quote_summary_cost_otr_price ="+temp_quote_summary_cost_otr_price);
		
		
		
		LO.print("Customer contract_type ="+customer_contract_type);
		System.out.println("Customer contract_type ="+customer_contract_type);	
		
		LO.print("Customer Quote generated successfully and Quote_ref_no ="+quote_ref_no);
		System.out.println("Customer Quote generated successfully and Quote_ref_no ="+quote_ref_no);
		
		
		String quote_summary_cost_otr_price_from_screen=RemoveComma.of(temp_quote_summary_cost_otr_price);
		
		
		double quote_summary_cost_otr_price_from_screen_converted =Double.parseDouble(quote_summary_cost_otr_price_from_screen);

		
		return obj_read_excel_calculation_page.verify_quote_summary_values_for_broker_bch_pch_fl_from_excel_with_maintenance(quote_summary_cost_otr_price_from_screen_converted, 
                                                 sheet_name);	

	}	

}
