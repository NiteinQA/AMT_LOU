package com.amt.QuoteSummaryPages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amt.testBase.TestBase;
import com.amt.testUtil.Click;
import com.amt.testUtil.ConfigConstants;
import com.amt.testUtil.ExplicitWait;
import com.amt.testUtil.ReadExcelCalculation;
import com.amt.testUtil.RemoveComma;

public class QuoteSummaryBrokerHPNRPage extends TestBase {
	
	
	
	ReadExcelCalculation obj_read_excel_calculation_page; 
	
	//loading icon
	@FindBy(xpath = "//img[@alt='Loading...']")
	private List<WebElement> loading_icon;

	//quote summary page icon
	@FindBy(xpath = "//p[normalize-space()='Quote summary']")
	private WebElement quote_summary;
	
	//quote summary ref no.
	@FindBy(xpath = "//*[normalize-space()='Quote reference no.:']//ancestor::div[1]//span[2]")
	private WebElement quote_summary_ref_no;

	//Monthly finance payment
	@FindBy(xpath = "//*[normalize-space()='Monthly finance payment']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_monthly_finance_payment;
	
	//acq contract type
	@FindBy(xpath = "//*[@id='headingHoldingCost']//*[normalize-space()='Contract type']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_acq_contract_type;

	//cust contract type
	@FindBy(xpath = "//*[@id='headingHpnrSummary']//*[normalize-space()='Contract type']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_contract_type;
	
	// vehicle details
	@FindBy(xpath = "//*[@class='heading ng-star-inserted']")
	private WebElement quote_summary_vehicle_heading;

	// customer quote summary button
	@FindBy(xpath = "//*[normalize-space()='Customer quote summary']//ancestor::button")
	private WebElement quote_summary_customer_quote_summary_button;

	// terms
	@FindBy(xpath = "//*[normalize-space()='Term']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_terms;

	// Miles per annum
	@FindBy(xpath = "//*[normalize-space()='Miles per annum']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_miles_per_annum;

	// Funder name
	@FindBy(xpath = "//*[normalize-space()='Funder']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_funder_name;

	// quote ref no.
	@FindBy(xpath = "//*[normalize-space()='Quote reference']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_quote_ref_number;

	// quote exp date
	@FindBy(xpath = "//*[normalize-space()='Quote expiry date']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_quote_exp_date;


	// contract mileage
	@FindBy(xpath = "//*[normalize-space()='Contract mileage']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_contract_mileage;	

	//cost OTR price
	@FindBy(xpath = "//*[normalize-space()='Cost OTR price']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_cost_otr_price;

	//cost price ex vat and rfl
	@FindBy(xpath = "//*[normalize-space()='Cost price ex. VAT & RFL']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_cost_price_ex_vat_and_rfl;

	//otr vat
	@FindBy(xpath = "//*[normalize-space()='VAT']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_otr_vat;

	//otr rfl and frf
	@FindBy(xpath = "//*[normalize-space()='RFL & FRF']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_otr_rfl_and_frf;

	// save button
	@FindBy(xpath = "//div[@class='row acquisition-menu']//div[3]//button[1]")
	private WebElement quote_summary_save_button;
	
	
	//Total cash price
	@FindBy(xpath = "//*[normalize-space()='Total cash price']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_total_cash_price;
	
	//Cash deposit
	@FindBy(xpath = "//*[normalize-space()='Cash deposit']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_cash_deposit;
	
	//Balance to finance
	@FindBy(xpath = "(//*[normalize-space()='Balance to finance']//ancestor::div[1]//div//strong)[2]")
	private WebElement quote_summary_customer_quote_summary_balance_to_finance;
	
	//Finance charges
	@FindBy(xpath = "//*[normalize-space()='Finance charges']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_finance_charges;
	
	//Balance payable
	@FindBy(xpath = "//*[normalize-space()='Balance payable']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_balance_payable;
	
	//Initial cash payment inc. document fee
	@FindBy(xpath = "//*[normalize-space()='Initial cash payment inc. document fee']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_initial_cash_payment_inc_document_fee;

	//No. of monthly payments	
	@FindBy(xpath = "//*[normalize-space()='No. of monthly payments']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_no_of_monthly_payments	;
	
	//Final balloon payment	
	@FindBy(xpath = "//*[normalize-space()='Final balloon payment']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_final_balloon_payment	;
	
	//Option to purchase fee	
	@FindBy(xpath = "//*[normalize-space()='Option to purchase fee']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_option_to_purchase_fee	;
	
	//RFL included?	
	@FindBy(xpath = "//*[normalize-space()='RFL included?']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_RFL_included;
	
	//APR
	@FindBy(xpath = "//*[normalize-space()='APR']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_APR;
	
	// commission
	@FindBy(xpath = "//*[normalize-space()='Commission']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_customer_quote_summary_commission;

	Properties prop;
	
	public QuoteSummaryBrokerHPNRPage() {
		
		try
    	{
    		prop=new Properties();
    		FileInputStream ip = new FileInputStream(ConfigConstants.EXCEL_VALUES_PROPERTY_FILE_PATH);
    		prop.load(ip);                            
    	}
    	catch(FileNotFoundException e)
    	{
    		e.printStackTrace();
    	}
    	catch(IOException e)
    	{
    		e.printStackTrace();
    	}

		PageFactory.initElements(driver, this);
	}

	public void quote_summary_broker_HPNR(String sheet_name) throws InterruptedException, IOException {		LO.print("*************Calculations for Quote Summary page gas been started************");
	System.out.println("*************Calculations for Quote Summary page gas been started************");

	obj_read_excel_calculation_page = new ReadExcelCalculation();

	Click.on(driver, quote_summary, 90);

	ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 35);

	ExplicitWait.visibleElement(driver, quote_summary_save_button, 30);

	JavascriptExecutor js = (JavascriptExecutor) driver;

	js.executeScript("arguments[0].click();", quote_summary_save_button);

	ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 150);

	ExplicitWait.visibleElement(driver, quote_summary_vehicle_heading, 120);
	ExplicitWait.visibleElement(driver, quote_summary_ref_no, 120);
	ExplicitWait.visibleElement(driver, quote_summary_cost_otr_price, 60);
	ExplicitWait.visibleElement(driver, quote_summary_customer_contract_type, 60);
	ExplicitWait.visibleElement(driver, quote_summary_cost_otr_price, 120);
	ExplicitWait.visibleElement(driver, quote_summary_cost_price_ex_vat_and_rfl, 120);
	ExplicitWait.visibleElement(driver, quote_summary_otr_vat, 120);
	ExplicitWait.visibleElement(driver, quote_summary_otr_rfl_and_frf, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_button, 120);

	// Cliking on cust quote summary section
	Click.on(driver, quote_summary_customer_quote_summary_button, 30);

	// waiting for summary section elements
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_terms, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_miles_per_annum, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_monthly_finance_payment, 120);		
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_funder_name, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_quote_ref_number, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_quote_exp_date, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_contract_mileage, 120);
	
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_total_cash_price, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_cash_deposit, 120);	
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_balance_to_finance, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_finance_charges, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_balance_payable, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_initial_cash_payment_inc_document_fee, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_no_of_monthly_payments, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_final_balloon_payment, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_option_to_purchase_fee, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_RFL_included, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_APR, 120);
	
	
//	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_initial_finance_rental, 120);
//	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_pence_per_excess_mile_finance, 120);
	
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_commission, 120);

	// Vehicle details
	String vehicle_name = quote_summary_vehicle_heading.getText().trim();

	// quote no.
	String quote_ref_no = quote_summary_ref_no.getText();

	// otr section
	String cost_otr_price_from_screen =RemoveComma.of(quote_summary_cost_otr_price.getText().trim().substring(2));

	String cost_price_ex_vat_and_rfl_from_screen = RemoveComma.of(quote_summary_cost_price_ex_vat_and_rfl.getText().trim().substring(2));

	String otr_vat_from_screen = RemoveComma.of(quote_summary_otr_vat.getText().trim().substring(2));

	String otr_rfl_and_frf_from_screen = RemoveComma.of(quote_summary_otr_rfl_and_frf.getText().trim().substring(2));

	// customer quote section
	// getting text from elements

	String customer_contract_type = quote_summary_customer_contract_type.getText();
	
	String customer_quote_summary_terms = quote_summary_customer_quote_summary_terms.getText().trim().substring(0,2);

	String customer_quote_summary_miles = RemoveComma.of(quote_summary_customer_quote_summary_miles_per_annum.getText().trim());

	String customer_quote_summary_monthly_finance_payment = RemoveComma.of(quote_summary_customer_quote_summary_monthly_finance_payment.getText().trim().substring(2));

	String customer_quote_funder_name = quote_summary_customer_quote_summary_funder_name.getText().trim();

	String customer_quote_summary_quote_ref_number = quote_summary_customer_quote_summary_quote_ref_number.getText().trim();

	String customer_quote_summary_quote_exp_date = quote_summary_customer_quote_summary_quote_exp_date.getText().trim();

	String customer_quote_summary_contract_mileage = RemoveComma.of(quote_summary_customer_quote_summary_contract_mileage.getText().trim());

	String customer_quote_summary_total_cash_price = RemoveComma.of(quote_summary_customer_quote_summary_total_cash_price.getText().trim().substring(2));

	String customer_quote_summary_cash_deposit = RemoveComma.of(quote_summary_customer_quote_summary_cash_deposit.getText().trim().substring(2));
	
	String customer_quote_summary_balance_to_finance = RemoveComma.of(quote_summary_customer_quote_summary_balance_to_finance.getText().trim().substring(2));
	
	String customer_quote_summary_finance_charges = RemoveComma.of(quote_summary_customer_quote_summary_finance_charges.getText().trim().substring(2));
	
	String customer_quote_summary_balance_payable = RemoveComma.of(quote_summary_customer_quote_summary_balance_payable.getText().trim().substring(2));
	
	String customer_quote_summary_initial_cash_payment_inc_document_fee = RemoveComma.of(quote_summary_customer_quote_summary_initial_cash_payment_inc_document_fee.getText().trim().substring(2));
	
	String customer_quote_summary_no_of_monthly_payments = quote_summary_customer_quote_summary_no_of_monthly_payments.getText().trim();
	
	String customer_quote_summary_final_balloon_payment = RemoveComma.of(quote_summary_customer_quote_summary_final_balloon_payment.getText().trim().substring(2));
	
	String customer_quote_summary_option_to_purchase_fee = RemoveComma.of(quote_summary_customer_quote_summary_option_to_purchase_fee.getText().trim().substring(2));
	
	String customer_quote_summary_RFL_included = quote_summary_customer_quote_summary_RFL_included.getText().trim();
	
	String [] APR = quote_summary_customer_quote_summary_APR.getText().trim().split(" ");
	
	String customer_quote_summary_APR = APR[0];

	String customer_quote_summary_commission = RemoveComma.of(quote_summary_customer_quote_summary_commission.getText().trim().substring(2));

	FileInputStream in = new FileInputStream(prop.getProperty("quote_save_excel_path"));
	XSSFWorkbook wb = new XSSFWorkbook(in);

	String sheetname = prop.getProperty("BrokerHPNRQuoteNo");
   //quote ref no 
	wb.getSheet(sheetname).getRow(1).getCell(0).setCellValue(quote_ref_no);
    //quote ref no 
	wb.getSheet(sheetname).getRow(1).getCell(10).setCellValue(vehicle_name);
	//customer quote values
	wb.getSheet(sheetname).getRow(4).getCell(1).setCellValue(customer_contract_type);
	wb.getSheet(sheetname).getRow(4).getCell(3).setCellValue(customer_quote_summary_terms);
	wb.getSheet(sheetname).getRow(6).getCell(1).setCellValue(customer_quote_summary_miles);
	wb.getSheet(sheetname).getRow(6).getCell(3).setCellValue(customer_quote_summary_monthly_finance_payment);
	wb.getSheet(sheetname).getRow(8).getCell(1).setCellValue(customer_quote_funder_name);
	wb.getSheet(sheetname).getRow(8).getCell(3).setCellValue(customer_quote_summary_quote_ref_number);
	wb.getSheet(sheetname).getRow(10).getCell(1).setCellValue(customer_quote_summary_quote_exp_date);
	wb.getSheet(sheetname).getRow(10).getCell(3).setCellValue(customer_quote_summary_contract_mileage);
	wb.getSheet(sheetname).getRow(12).getCell(1).setCellValue(customer_quote_summary_total_cash_price);
	wb.getSheet(sheetname).getRow(12).getCell(3).setCellValue(customer_quote_summary_cash_deposit);
	wb.getSheet(sheetname).getRow(14).getCell(1).setCellValue(customer_quote_summary_balance_to_finance);
	wb.getSheet(sheetname).getRow(14).getCell(3).setCellValue(customer_quote_summary_finance_charges);
	wb.getSheet(sheetname).getRow(16).getCell(1).setCellValue(customer_quote_summary_balance_payable);
	wb.getSheet(sheetname).getRow(16).getCell(3).setCellValue(customer_quote_summary_initial_cash_payment_inc_document_fee);
	wb.getSheet(sheetname).getRow(18).getCell(1).setCellValue(customer_quote_summary_no_of_monthly_payments);
	wb.getSheet(sheetname).getRow(18).getCell(3).setCellValue(customer_quote_summary_final_balloon_payment);
	wb.getSheet(sheetname).getRow(20).getCell(1).setCellValue(customer_quote_summary_option_to_purchase_fee);
	wb.getSheet(sheetname).getRow(20).getCell(3).setCellValue(customer_quote_summary_RFL_included);
	wb.getSheet(sheetname).getRow(22).getCell(1).setCellValue(customer_quote_summary_APR);
	wb.getSheet(sheetname).getRow(22).getCell(3).setCellValue(customer_quote_summary_commission);

	//OTR values
	wb.getSheet(sheetname).getRow(1).getCell(6).setCellValue(cost_price_ex_vat_and_rfl_from_screen);
	wb.getSheet(sheetname).getRow(1).getCell(8).setCellValue(otr_vat_from_screen);
	wb.getSheet(sheetname).getRow(3).getCell(6).setCellValue(otr_rfl_and_frf_from_screen);
	wb.getSheet(sheetname).getRow(3).getCell(8).setCellValue(cost_otr_price_from_screen);
	

	FileOutputStream out = new FileOutputStream(prop.getProperty("quote_save_excel_path"));
	wb.write(out);
	wb.close();
	 
	LO.print("Quote Summary Data collected and sent to Quote save Excel");
	System.out.println("Quote Summary Data collected and sent to Quote save Excel");

	}

	
	public void quote_summary_broker_HPNR_used_car(String sheet_name) throws InterruptedException, IOException {		LO.print("*************Calculations for Quote Summary page gas been started************");
	System.out.println("*************Calculations for Quote Summary page gas been started************");

	obj_read_excel_calculation_page = new ReadExcelCalculation();

	Click.on(driver, quote_summary, 90);

	ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 35);

	ExplicitWait.visibleElement(driver, quote_summary_save_button, 30);

	JavascriptExecutor js = (JavascriptExecutor) driver;

	js.executeScript("arguments[0].click();", quote_summary_save_button);

	ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 150);

	ExplicitWait.visibleElement(driver, quote_summary_vehicle_heading, 120);
	ExplicitWait.visibleElement(driver, quote_summary_ref_no, 120);
	ExplicitWait.visibleElement(driver, quote_summary_cost_otr_price, 60);
	ExplicitWait.visibleElement(driver, quote_summary_customer_contract_type, 60);
	ExplicitWait.visibleElement(driver, quote_summary_cost_otr_price, 120);
	ExplicitWait.visibleElement(driver, quote_summary_cost_price_ex_vat_and_rfl, 120);
	ExplicitWait.visibleElement(driver, quote_summary_otr_vat, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_button, 120);

	// Cliking on cust quote summary section
	Click.on(driver, quote_summary_customer_quote_summary_button, 30);

	// waiting for summary section elements
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_terms, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_miles_per_annum, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_monthly_finance_payment, 120);		
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_funder_name, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_quote_ref_number, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_quote_exp_date, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_contract_mileage, 120);
	
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_total_cash_price, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_cash_deposit, 120);	
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_balance_to_finance, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_finance_charges, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_balance_payable, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_initial_cash_payment_inc_document_fee, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_no_of_monthly_payments, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_final_balloon_payment, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_option_to_purchase_fee, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_RFL_included, 120);
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_APR, 120);
	
	
//	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_initial_finance_rental, 120);
//	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_pence_per_excess_mile_finance, 120);
	
	ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_commission, 120);

	// Vehicle details
	String vehicle_name = quote_summary_vehicle_heading.getText().trim();

	// quote no.
	String quote_ref_no = quote_summary_ref_no.getText();

	// otr section
	String cost_otr_price_from_screen =RemoveComma.of(quote_summary_cost_otr_price.getText().trim().substring(2));

	String cost_price_ex_vat_and_rfl_from_screen = RemoveComma.of(quote_summary_cost_price_ex_vat_and_rfl.getText().trim().substring(2));

	String otr_vat_from_screen = RemoveComma.of(quote_summary_otr_vat.getText().trim().substring(2));


	// customer quote section
	// getting text from elements

	String customer_contract_type = quote_summary_customer_contract_type.getText();
	
	String customer_quote_summary_terms = quote_summary_customer_quote_summary_terms.getText().trim().substring(0,2);

	String customer_quote_summary_miles = RemoveComma.of(quote_summary_customer_quote_summary_miles_per_annum.getText().trim());

	String customer_quote_summary_monthly_finance_payment = RemoveComma.of(quote_summary_customer_quote_summary_monthly_finance_payment.getText().trim().substring(2));

	String customer_quote_funder_name = quote_summary_customer_quote_summary_funder_name.getText().trim();

	String customer_quote_summary_quote_ref_number = quote_summary_customer_quote_summary_quote_ref_number.getText().trim();

	String customer_quote_summary_quote_exp_date = quote_summary_customer_quote_summary_quote_exp_date.getText().trim();

	String customer_quote_summary_contract_mileage = RemoveComma.of(quote_summary_customer_quote_summary_contract_mileage.getText().trim());

	String customer_quote_summary_total_cash_price = RemoveComma.of(quote_summary_customer_quote_summary_total_cash_price.getText().trim().substring(2));

	String customer_quote_summary_cash_deposit = RemoveComma.of(quote_summary_customer_quote_summary_cash_deposit.getText().trim().substring(2));
	
	String customer_quote_summary_balance_to_finance = RemoveComma.of(quote_summary_customer_quote_summary_balance_to_finance.getText().trim().substring(2));
	
	String customer_quote_summary_finance_charges = RemoveComma.of(quote_summary_customer_quote_summary_finance_charges.getText().trim().substring(2));
	
	String customer_quote_summary_balance_payable = RemoveComma.of(quote_summary_customer_quote_summary_balance_payable.getText().trim().substring(2));
	
	String customer_quote_summary_initial_cash_payment_inc_document_fee = RemoveComma.of(quote_summary_customer_quote_summary_initial_cash_payment_inc_document_fee.getText().trim().substring(2));
	
	String customer_quote_summary_no_of_monthly_payments = quote_summary_customer_quote_summary_no_of_monthly_payments.getText().trim();
	
	String customer_quote_summary_final_balloon_payment = RemoveComma.of(quote_summary_customer_quote_summary_final_balloon_payment.getText().trim().substring(2));
	
	String customer_quote_summary_option_to_purchase_fee = RemoveComma.of(quote_summary_customer_quote_summary_option_to_purchase_fee.getText().trim().substring(2));
	
	String customer_quote_summary_RFL_included = quote_summary_customer_quote_summary_RFL_included.getText().trim();
	
	String [] APR = quote_summary_customer_quote_summary_APR.getText().trim().split(" ");
	
	String customer_quote_summary_APR = APR[0];

	String customer_quote_summary_commission = RemoveComma.of(quote_summary_customer_quote_summary_commission.getText().trim().substring(2));

	FileInputStream in = new FileInputStream(prop.getProperty("quote_save_excel_path"));
	XSSFWorkbook wb = new XSSFWorkbook(in);

	String sheetname = prop.getProperty("BrokerHPNRQuoteNo");
   //quote ref no 
	wb.getSheet(sheetname).getRow(1).getCell(0).setCellValue(quote_ref_no);
    //quote ref no 
	wb.getSheet(sheetname).getRow(1).getCell(10).setCellValue(vehicle_name);
	//customer quote values
	wb.getSheet(sheetname).getRow(4).getCell(1).setCellValue(customer_contract_type);
	wb.getSheet(sheetname).getRow(4).getCell(3).setCellValue(customer_quote_summary_terms);
	wb.getSheet(sheetname).getRow(6).getCell(1).setCellValue(customer_quote_summary_miles);
	wb.getSheet(sheetname).getRow(6).getCell(3).setCellValue(customer_quote_summary_monthly_finance_payment);
	wb.getSheet(sheetname).getRow(8).getCell(1).setCellValue(customer_quote_funder_name);
	wb.getSheet(sheetname).getRow(8).getCell(3).setCellValue(customer_quote_summary_quote_ref_number);
	wb.getSheet(sheetname).getRow(10).getCell(1).setCellValue(customer_quote_summary_quote_exp_date);
	wb.getSheet(sheetname).getRow(10).getCell(3).setCellValue(customer_quote_summary_contract_mileage);
	wb.getSheet(sheetname).getRow(12).getCell(1).setCellValue(customer_quote_summary_total_cash_price);
	wb.getSheet(sheetname).getRow(12).getCell(3).setCellValue(customer_quote_summary_cash_deposit);
	wb.getSheet(sheetname).getRow(14).getCell(1).setCellValue(customer_quote_summary_balance_to_finance);
	wb.getSheet(sheetname).getRow(14).getCell(3).setCellValue(customer_quote_summary_finance_charges);
	wb.getSheet(sheetname).getRow(16).getCell(1).setCellValue(customer_quote_summary_balance_payable);
	wb.getSheet(sheetname).getRow(16).getCell(3).setCellValue(customer_quote_summary_initial_cash_payment_inc_document_fee);
	wb.getSheet(sheetname).getRow(18).getCell(1).setCellValue(customer_quote_summary_no_of_monthly_payments);
	wb.getSheet(sheetname).getRow(18).getCell(3).setCellValue(customer_quote_summary_final_balloon_payment);
	wb.getSheet(sheetname).getRow(20).getCell(1).setCellValue(customer_quote_summary_option_to_purchase_fee);
	wb.getSheet(sheetname).getRow(20).getCell(3).setCellValue(customer_quote_summary_RFL_included);
	wb.getSheet(sheetname).getRow(22).getCell(1).setCellValue(customer_quote_summary_APR);
	wb.getSheet(sheetname).getRow(22).getCell(3).setCellValue(customer_quote_summary_commission);

	//OTR values
	wb.getSheet(sheetname).getRow(1).getCell(6).setCellValue(cost_price_ex_vat_and_rfl_from_screen);
	wb.getSheet(sheetname).getRow(1).getCell(8).setCellValue(otr_vat_from_screen);
	wb.getSheet(sheetname).getRow(3).getCell(8).setCellValue(cost_otr_price_from_screen);
	

	FileOutputStream out = new FileOutputStream(prop.getProperty("quote_save_excel_path"));
	wb.write(out);
	wb.close();
	 
	LO.print("Quote Summary Data collected and sent to Quote save Excel");
	System.out.println("Quote Summary Data collected and sent to Quote save Excel");

	}

	
}
