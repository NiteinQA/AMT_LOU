package com.amt.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amt.testBase.TestBase;
import com.amt.testUtil.Click;
import com.amt.testUtil.ExplicitWait;
import com.amt.testUtil.GetExcelFormulaValue;
import com.amt.testUtil.HelperClass;
import com.amt.testUtil.RemoveComma;
import com.amt.testUtil.Dropdown;

public class UnderwritingPopupPage extends TestBase {

	JavascriptExecutor js;

	Properties prop;
	// 1.underwriting_menu_link
	@FindBy(xpath = "//span[contains(text(),'Underwriting')]")
	private WebElement underwriting_menu_link;

	// Underwriting popup code --

	// 1.underwriting_icon_link
	@FindBy(xpath = "(//img[@src='../../assets/images/opportunity/underwritting.svg'])[1]")
	private WebElement underwriting_icon_link;

	// 2.underwriting_popup_send_for_underwriting_button
	@FindBy(xpath = "(//button[normalize-space()='Send for underwriting'])[1]")
	private WebElement underwriting_send_for_underwriting_button;

	// 3.underwriting_popup_proposal_id
	@FindBy(xpath = "//*[@id='underwriting_popup']/div/div/div[1]/h4")
	private WebElement underwriting_popup_proposal_id;

	// 4.underwriting_popup_quote_ref_no
	@FindBy(xpath = "//*[normalize-space()='Quote reference no.:']//ancestor::div[1]")
	private WebElement underwriting_popup_quote_ref_no;

	// 5.underwriting_popup_cancel_button
	@FindBy(xpath = "(//button[@class='btn btn-outline-secondary mr-2'][normalize-space()='Cancel'])[3]")
	private WebElement underwriting_popup_cancel_button;

	@FindBy(xpath = "//img[@alt='Loading...']")
	private List<WebElement> loading_icon;

	// 6.underwriting_popup_download_contract_file
	@FindBy(xpath = "(//i[@class='btn-icon-contract-file'])[1]")
	private WebElement underwriting_popup_download_contract_file;

	// 7.underwriting_popup_download_proposal
	@FindBy(xpath = "(//button[normalize-space()='Download Proposal'])[1]")
	private WebElement underwriting_popup_download_proposal;

	// 8.underwriting_popup_close
	@FindBy(xpath = "//div[@class='statusandclose d-flex']//button[@type='button'][normalize-space()='×']")
	private WebElement underwriting_popup_close_icon;

	// 8.underwriting_popup_close button
	@FindBy(xpath = "(//button[@data-dismiss='modal'][normalize-space()='Close'])[1]")
	private WebElement underwriting_popup_close_button;
	
	//  vehicle details
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

		// payment profile
		@FindBy(xpath = "//*[normalize-space()='Payment profile']//ancestor::div[1]//div//strong")
		private WebElement quote_summary_customer_quote_summary_payment_profile;

		// contract mileage
		@FindBy(xpath = "//*[normalize-space()='Contract mileage']//ancestor::div[1]//div//strong")
		private WebElement quote_summary_customer_quote_summary_contract_mileage;	

		// Initial finance rental
		@FindBy(xpath = "//*[normalize-space()='Initial finance rental']//ancestor::div[1]//div//strong")
		private WebElement quote_summary_customer_quote_summary_initial_finance_rental;

		// initial maint rental
		@FindBy(xpath = "//*[normalize-space()='Initial maint. rental']//ancestor::div[1]//div//strong")
		private WebElement quote_summary_customer_quote_summary_initial_maint_rental;

		// Total initial rental
		@FindBy(xpath = "//*[normalize-space()='Total initial rental']//ancestor::div[1]//div//strong")
		private WebElement quote_summary_customer_quote_summary_total_initial_rental;

		// Pence per excess mile - finance
		@FindBy(xpath = "//*[normalize-space()='Pence per excess mile - finance']//ancestor::div[1]//div//strong")
		private WebElement quote_summary_customer_quote_summary_pence_per_excess_mile_finance;

		// Pence per excess mile - maint.
		@FindBy(xpath = "//*[normalize-space()='Pence per excess mile - maint.']//ancestor::div[1]//div//strong")
		private WebElement quote_summary_customer_quote_summary_pence_per_excess_mile_maint;

		// Pence per excess mile - total
		@FindBy(xpath = "//*[normalize-space()='Pence per excess mile - total']//ancestor::div[1]//div//strong")
		private WebElement quote_summary_customer_quote_summary_pence_per_excess_mile_total;

		// commission
		@FindBy(xpath = "//*[normalize-space()='Commission']//ancestor::div[1]//div//strong")
		private WebElement quote_summary_customer_quote_summary_commission;
		
		@FindBy(xpath = "//*[normalize-space()='Contract type']//ancestor::div[1]//div//strong")
		private WebElement quote_summary_customer_contract_type;

	// Ownbook - pop up values for accept

	//// ownbook_underwriting_popup_accept (//button[normalize-space()='Accept'])[1]
	// ownbook_underwriting_popup_reject - (//button[normalize-space()='Reject'])[1]

	@FindBy(xpath = "//*[@id=\"underwriting_popup\"]/div/div/div[3]/div[2]/div/button[1]")
	private WebElement ownbook_underwriting_popup_accept;

	@FindBy(xpath = "(//button[normalize-space()='Reject'])[1]")
	private WebElement ownbook_underwriting_popup_reject;

	@FindBy(xpath = "//*[@id=\"confirm-sales-user-decision\"]/div/div/div[3]/div/button[2]")
	private WebElement ownbook_underwriting_popup_accept_ok_button;

	public UnderwritingPopupPage() {

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
		PageFactory.initElements(driver, this);
	}

	/*
	 * public void underwriting_menu_link_availbale () throws InterruptedException {
	 * 
	 * ExplicitWait.visibleElement(driver, underwriting_menu_link, 30);
	 * 
	 * 
	 * 
	 * underwriting_menu_link.click();
	 * System.out.println("Click on  underwriting icon is available");
	 * LO.print("Click on  underwriting icon is available ");
	 * 
	 * ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

	public void search_and_verify_underwriting_icon_is_availabale() throws InterruptedException {

		ExplicitWait.visibleElement(driver, underwriting_icon_link, 30);

		if (underwriting_icon_link.isEnabled()) {

			underwriting_icon_link.click();
		}
		System.out.println("Underwriting icon is available");
		LO.print(" Underwriting icon is available ");

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 40);

	}

	public void search_and_verify_underwriting_icon_is_close() throws InterruptedException {

		ExplicitWait.visibleElement(driver, underwriting_popup_close_icon, 30);

		underwriting_popup_close_icon.click();

		System.out.println("Underwriting pop up will close");
		LO.print(" Underwriting pop up will close");

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);

	}

	public void search_and_verify_underwriting_pop_up_close_button() throws InterruptedException {

		ExplicitWait.visibleElement(driver, underwriting_popup_close_button, 30);

		underwriting_popup_close_button.click();

		System.out.println("Underwriting pop up will close");
		LO.print(" Underwriting pop up will close");

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);

	}

	// 3.underwriting_popup_proposal_id

	public boolean search_and_verify_underwriting_pop_up_summary_values()
			throws InterruptedException, IOException, ClassNotFoundException {

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
		
		
		//underwriting pop ........

		ExplicitWait.visibleElement(driver, quote_summary_vehicle_heading, 120);
		
		
		ExplicitWait.visibleElement(driver, quote_summary_customer_contract_type, 60);
	
		ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_button, 120);

		// Cliking on cust quote summary section
		Click.on(driver, quote_summary_customer_quote_summary_button, 30);

		// waiting for summary section elements
		ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_terms, 120);
		ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_miles_per_annum, 120);
		ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_initial_finance_rental, 120);		
		ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_funder_name, 120);
		ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_quote_ref_number, 120);
		ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_quote_exp_date, 120);
		ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_payment_profile, 120);
		ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_contract_mileage, 120);
		ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_initial_finance_rental, 120);
		ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_pence_per_excess_mile_finance, 120);
		ExplicitWait.visibleElement(driver, quote_summary_customer_quote_summary_commission, 120);

		// Vehicle details
		String vehicleNameActual = quote_summary_vehicle_heading.getText().trim();

		ExplicitWait.visibleElement(driver, underwriting_popup_quote_ref_no, 30);

		String quotRefNoActual = underwriting_popup_quote_ref_no.getText();
		
		
		// customer quote section
		// getting text from elements

		String contractTypeActual = quote_summary_customer_contract_type.getText();
		
		double termActual = Double.parseDouble(quote_summary_customer_quote_summary_terms.getText().trim().substring(0,2));

		double mileageActual = Double.parseDouble(RemoveComma.of(quote_summary_customer_quote_summary_miles_per_annum.getText().trim()));

		double monthlyFinanceRentalActual = Double.parseDouble(RemoveComma.of(quote_summary_customer_quote_summary_initial_finance_rental.getText().trim().substring(2)));

		String funderNameActual = quote_summary_customer_quote_summary_funder_name.getText().trim();

		String funderQuoteRefNumberActual = quote_summary_customer_quote_summary_quote_ref_number.getText().trim();

		String expiryDateActual = quote_summary_customer_quote_summary_quote_exp_date.getText().trim();

		String paymentProfileActual = quote_summary_customer_quote_summary_payment_profile.getText().trim();
		
		double contractMileageActual = Double.parseDouble(RemoveComma.of(quote_summary_customer_quote_summary_contract_mileage.getText().trim()));

		double initialFinanceRentalActual = Double.parseDouble(RemoveComma.of(quote_summary_customer_quote_summary_initial_finance_rental.getText().trim().substring(2)));

		String pencePerExcessMileFinanceActual = quote_summary_customer_quote_summary_pence_per_excess_mile_finance.getText().trim();

		double commissionActual = Double.parseDouble(RemoveComma.of(quote_summary_customer_quote_summary_commission.getText().trim().substring(2)));
		


		System.out.println("Underwriting pop up - quote ref no  =>" + quotRefNoActual);
		LO.print          ("Underwriting pop up -quote ref no => " + quotRefNoActual);
		
		
		ExplicitWait.visibleElement(driver, underwriting_popup_proposal_id, 30);
		String UnderwritingPopupProposalId = underwriting_popup_proposal_id.getText();
		Thread.sleep(2000);
		String UnderwritingPopupProposalIdFromScreen = UnderwritingPopupProposalId.substring(14, 21);
		Thread.sleep(2000);
		System.out.println("Underwriting Popup Proposal Id is =" + UnderwritingPopupProposalIdFromScreen);
		LO.print("Underwriting Popup Proposal Id is =" + UnderwritingPopupProposalIdFromScreen);

		String sheetName = "";

		if (Class.forName(Thread.currentThread().getStackTrace()[2].getClassName()).getName().contains("business")) {
			sheetName = prop.getProperty("BrokerBCHQuoteNo");
		}

		if (Class.forName(Thread.currentThread().getStackTrace()[2].getClassName()).getName().contains("individual")) {
			sheetName = prop.getProperty("BrokerPCHQuoteNo");
		}

		Thread.sleep(1000);
		FileInputStream in = new FileInputStream(prop.getProperty("quote_save_excel_path"));
		Thread.sleep(1000);
		XSSFWorkbook wb = new XSSFWorkbook(in);
		Thread.sleep(1000);

		wb.getSheet(sheetName).getRow(1).getCell(3).setCellValue(UnderwritingPopupProposalIdFromScreen);

		FileOutputStream out = new FileOutputStream(prop.getProperty("quote_save_excel_path"));
		Thread.sleep(1000);
		wb.write(out);
		
		
		
		String quotRefNoExpected            = GetExcelFormulaValue.get_cell_value(1, 0, sheetName);
		String vehicleNameExpected          = GetExcelFormulaValue.get_cell_value(1, 10, sheetName);
		
		String contractTypeExpected         = GetExcelFormulaValue.get_cell_value(4, 1, sheetName);
		double termExpected                 = Double.parseDouble(GetExcelFormulaValue.get_cell_value(4, 3, sheetName));
		
		double mileageExpected              = Double.parseDouble(GetExcelFormulaValue.get_cell_value(6, 1, sheetName));
		double monthlyFinanceRentalExpected = Double.parseDouble(GetExcelFormulaValue.get_cell_value(6, 3, sheetName));
		
//		GetExcelFormulaValue.get_string_value(8, 1, sheetName);
//		GetExcelFormulaValue.get_string_value(8, 3, sheetName);
		
		String funderNameExpected                = GetExcelFormulaValue.get_cell_value(10, 1, sheetName);
		String funderQuoteRefNumberExpected      = GetExcelFormulaValue.get_cell_value(10, 3, sheetName);
		
		String expiryDateExpected                = GetExcelFormulaValue.get_cell_value(12, 1, sheetName);
		String paymentProfileExpected            = GetExcelFormulaValue.get_cell_value(12, 3, sheetName);
		
		double contractMileageExpected           = Double.parseDouble(GetExcelFormulaValue.get_cell_value(14, 1, sheetName));
		double initialFinanceRentalExpected      = Double.parseDouble(GetExcelFormulaValue.get_cell_value(14, 3, sheetName));
	
//		GetExcelFormulaValue.get_string_value(16, 1, sheetName);
//		GetExcelFormulaValue.get_string_value(16, 3, sheetName);
	
		String pencePerExcessMileFinanceExpected = GetExcelFormulaValue.get_cell_value(18, 1, sheetName);
//		GetExcelFormulaValue.get_string_value(18, 3, sheetName);
	
//		GetExcelFormulaValue.get_string_value(20, 1, sheetName);
		double commissionExpected                = Double.parseDouble(GetExcelFormulaValue.get_cell_value(20, 3, sheetName));
		
		//********************************
		
		System.out.println("");
	    LO.print          ("");
		System.out.println("Started Verifying Summary values");
	    LO.print          ("Started Verifying Summary values");

	    //*******************************
	    
		int count =0;
		
		// comparing quote no.
		if (quotRefNoActual.equals(quotRefNoExpected)) {
			count++;

			System.out.println("");
			LO.print          ("");
			System.out.println(quotRefNoActual + " = " + quotRefNoExpected);
			LO.print          (quotRefNoActual + " = " + quotRefNoExpected);
			System.out.println("Quote no. compared and found ok");
			LO.print          ("Quote no. compared and found ok");
		} else {
			System.out.println("");
			LO.print          ("");
			System.err.println(quotRefNoActual + " != " + quotRefNoExpected);
			LO.print          (quotRefNoActual + " != " + quotRefNoExpected);
			System.err.println("Quote no. compared but found not ok");
			LO.print          ("Quote no. compared but found not ok");
		}

		// comparing vehicle name
		if (vehicleNameActual.equals(vehicleNameExpected)) {
			count++;

			System.out.println("");
			LO.print          ("");
			System.out.println(vehicleNameActual + " = " + vehicleNameExpected);
			LO.print          (vehicleNameActual + " = " + vehicleNameExpected);
			System.out.println("Vehicle name compared and found ok");
			LO.print          ("Vehicle name compared and found ok");

		} else {
			System.out.println("");
			LO.print          ("");
			System.err.println(vehicleNameActual + " != " + vehicleNameExpected);
			LO.print          (vehicleNameActual + " != " + vehicleNameExpected);
			System.err.println("Vehicle name compared but found not ok");
			LO.print          ("Vehicle name compared but found not ok");

		}

		// comparing contract type
		if (contractTypeActual.equals(contractTypeExpected)) {
			count++;
			System.out.println("");
			LO.print          ("");
			System.out.println(contractTypeActual + " = " + contractTypeExpected);
			LO.print          (contractTypeActual + " = " + contractTypeExpected);
			System.out.println("Contract type compared and found ok");
			LO.print          ("Contract type compared and found ok");

		} else {
			System.out.println("");
			LO.print          ("");
			System.err.println(contractTypeActual + " != " + contractTypeExpected);
			LO.print          (contractTypeActual + " != " + contractTypeExpected);
			System.err.println("Contract type compared but found not ok");
			LO.print          ("Contract type compared but found not ok");
		}

		// comparing monthly finance payment
		if (monthlyFinanceRentalActual == monthlyFinanceRentalExpected) {
			
			count++;

			System.out.println("");
			LO.print          ("");
			System.out.println(monthlyFinanceRentalActual + " = " + monthlyFinanceRentalExpected);
			LO.print          (monthlyFinanceRentalActual + " = " + monthlyFinanceRentalExpected);
			System.out.println("Monthly finance rental compared and found ok");
			LO.print          ("Monthly finance rental compared and found ok");

		} else {
			System.out.println("");
			LO.print          ("");
			System.err.println(monthlyFinanceRentalActual + " != " + monthlyFinanceRentalExpected);
			LO.print          (monthlyFinanceRentalActual + " != " + monthlyFinanceRentalExpected);
			System.err.println("Monthly finance rental compared but found not ok");
			LO.print          ("Monthly finance rental compared but found not ok");

		}

		// comparing mileage
		if (mileageActual == mileageExpected) {
			count++;

			System.out.println("");
			LO.print          ("");
			System.out.println(mileageActual + " = " + mileageExpected);
			LO.print          (mileageActual + " = " + mileageExpected);
			System.out.println("Mileage compared and found ok");
			LO.print          ("Mileage compared and found ok");

		} else {
			System.out.println("");
			LO.print          ("");
			System.err.println(mileageActual + " != " + mileageExpected);
			LO.print          (mileageActual + " != " + mileageExpected);
			System.err.println("Mileage compared but found not ok");
			LO.print          ("Mileage compared but found not ok");

		}

		// comparing term
		if (termActual == termExpected) {
			count++;

			System.out.println("");
			LO.print          ("");
			System.out.println(termActual + " = " + termExpected);
			LO.print          (termActual + " = " + termExpected);
			System.out.println("Terms compared and found ok");
			LO.print          ("Terms compared and found ok");

		} else {
			System.out.println("");
			LO.print          ("");
			System.err.println(termActual + " != " + termExpected);
			LO.print          (termActual + " != " + termExpected);
			System.err.println("Terms compared but found not ok");
			LO.print          ("Terms compared but found not ok");

		}

		// comparing expiry date
		if (expiryDateActual.equals(expiryDateExpected)) {
			count++;

			System.out.println("");
			LO.print          ("");
			System.out.println(expiryDateActual + " = " + expiryDateExpected);
			LO.print          (expiryDateActual + " = " + expiryDateExpected);
			System.out.println("Expiry date compared and found ok");
			LO.print          ("Expiry date compared and found ok");

		} else {
			System.out.println("");
			LO.print          ("");
			System.err.println(expiryDateActual + " != " + expiryDateExpected);
			LO.print          (expiryDateActual + " != " + expiryDateExpected);
			System.err.println("Expiry date compared but found not ok");
			LO.print          ("Expiry date compared but found not ok");

		}

		// comparing funder name
		if (funderNameActual.equals(funderNameExpected)) {
			count++;

			System.out.println("");
			LO.print          ("");
			System.out.println(funderNameActual + " = " + funderNameExpected);
			LO.print          (funderNameActual + " = " + funderNameExpected);
			System.out.println("Funder name compared and found ok");
			LO.print          ("Funder name compared and found ok");

		} else {
			System.out.println("");
			LO.print          ("");
			System.err.println(funderNameActual + " != " + funderNameExpected);
			LO.print          (funderNameActual + " != " + funderNameExpected);
			System.err.println("Funder name compared but found not ok");
			LO.print          ("Funder name compared but found not ok");

		}

		// comparing funder quote ref no.
		if (funderQuoteRefNumberActual.equals(funderQuoteRefNumberExpected)) {
			count++;

			System.out.println("");
			LO.print          ("");
			System.out.println(funderQuoteRefNumberActual + " = " + funderQuoteRefNumberExpected);
			LO.print          (funderQuoteRefNumberActual + " = " + funderQuoteRefNumberExpected);
			System.out.println("Funder quote ref no. compared and found ok");
			LO.print          ("Funder quote ref no. compared and found ok");

		} else {
			System.out.println("");
			LO.print          ("");
			System.err.println(funderQuoteRefNumberActual + " != " + funderQuoteRefNumberExpected);
			LO.print          (funderQuoteRefNumberActual + " != " + funderQuoteRefNumberExpected);
			System.err.println("Funder quote ref no. compared but found not ok");
			LO.print          ("Funder quote ref no. compared but found not ok");

		}

		// comparing payment profile
		if (paymentProfileActual.equals(paymentProfileExpected)) {
			count++;

			System.out.println("");
			LO.print          ("");
			System.out.println(paymentProfileActual + " = " + paymentProfileExpected);
			LO.print          (paymentProfileActual + " = " + paymentProfileExpected);
			System.out.println("Payment profile compared and found ok");
			LO.print          ("Payment profile compared and found ok");

		} else {
			System.out.println("");
			LO.print          ("");
			System.err.println(paymentProfileActual + " != " + paymentProfileExpected);
			LO.print          (paymentProfileActual + " != " + paymentProfileExpected);
			System.err.println("Payment profile compared but found not ok");
			LO.print          ("Payment profile compared but found not ok");

		}

		// comparing contract mileage
		if (contractMileageActual == contractMileageExpected) {
			count++;

			System.out.println("");
			LO.print          ("");
			System.out.println(contractMileageActual + " = " + contractMileageExpected);
			LO.print          (contractMileageActual + " = " + contractMileageExpected);
			System.out.println("Contract mileage compared and found ok");
			LO.print          ("Contract mileage compared and found ok");

		} else {
			System.out.println("");
			LO.print          ("");
			System.err.println(contractMileageActual + " != " + contractMileageExpected);
			LO.print          (contractMileageActual + " != " + contractMileageExpected);
			System.err.println("Contract mileage compared but found not ok");
			LO.print          ("Contract mileage compared but found not ok");

		}

		// comparing Initial finance rental
		if (initialFinanceRentalActual == initialFinanceRentalExpected) {
			count++;

			System.out.println("");
			LO.print          ("");
			System.out.println(initialFinanceRentalActual + " = " + initialFinanceRentalExpected);
			LO.print          (initialFinanceRentalActual + " = " + initialFinanceRentalExpected);
			System.out.println("Initial finance rental compared and found ok");
			LO.print          ("Initial finance rental compared and found ok");

		} else {
			System.out.println("");
			LO.print          ("");
			System.err.println(initialFinanceRentalActual + " != " + initialFinanceRentalExpected);
			LO.print          (initialFinanceRentalActual + " != " + initialFinanceRentalExpected);
			System.err.println("Initial finance rental compared but found not ok");
			LO.print          ("Initial finance rental compared but found not ok");

		}

		// comparing pense per excess mile finance
		if (pencePerExcessMileFinanceActual.equals(pencePerExcessMileFinanceExpected)) {
			count++;

			System.out.println("");
			LO.print          ("");
			System.out.println(pencePerExcessMileFinanceActual + " = " + pencePerExcessMileFinanceExpected);
			LO.print          (pencePerExcessMileFinanceActual + " = " + pencePerExcessMileFinanceExpected);
			System.out.println("Pense per excess mile finance compared and found ok");
			LO.print          ("Pense per excess mile finance compared and found ok");

		} else {
			System.out.println("");
			LO.print          ("");
			System.err.println(pencePerExcessMileFinanceActual + " != " + pencePerExcessMileFinanceExpected);
			LO.print          (pencePerExcessMileFinanceActual + " != " + pencePerExcessMileFinanceExpected);
			System.err.println("Pense per excess mile finance compared but found not ok");
			LO.print          ("Pense per excess mile finance compared but found not ok");

		}

		// comparing commission
		if (commissionActual == commissionExpected) {
			count++;

			System.out.println("");
			LO.print          ("");
			System.out.println(commissionActual + " = " + commissionExpected);
			LO.print          (commissionActual + " = " + commissionExpected);
			System.out.println("commission compared and found ok");
			LO.print          ("commission compared and found ok");

		} else {
			System.out.println("");
			LO.print          ("");
			System.err.println(commissionActual + " != " + commissionExpected);
			LO.print          (commissionActual + " != " + commissionExpected);
			System.err.println("commission compared but found not ok");
			LO.print          ("commission compared but found not ok");

		}
								
		
		boolean status = false;
		if (count==14)
			
		{
			status = true;
		}
		
		return status;
		
		
		

	}

	public void search_and_verify_ownbook_underwriting_get_proposal_id() throws InterruptedException, IOException {

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
		ExplicitWait.visibleElement(driver, underwriting_popup_proposal_id, 30);

		Thread.sleep(2000);

		String UnderwritingPopupProposalId = underwriting_popup_proposal_id.getText();
		Thread.sleep(2000);
		String UnderwritingPopupProposalIdFromScreen = UnderwritingPopupProposalId.substring(14, 21);
		Thread.sleep(2000);
		System.out.println("Underwriting Popup Proposal Id is =" + UnderwritingPopupProposalIdFromScreen);
		LO.print("Underwriting Popup Proposal Id is =" + UnderwritingPopupProposalIdFromScreen);

		Thread.sleep(1000);
		FileInputStream in = new FileInputStream(prop.getProperty("quote_save_excel_path"));
		Thread.sleep(1000);
		XSSFWorkbook wb = new XSSFWorkbook(in);

		Thread.sleep(1000);
		wb.getSheet("HPNRBCHQuoteNo").getRow(0).getCell(1).setCellValue(UnderwritingPopupProposalIdFromScreen);
		// wb.getSheet("BrokerBCHQuoteNo").getRow(0).getCell(2).setCellValue(UnderwritingPopupProposalId);
		Thread.sleep(1000);
		Thread.sleep(1000);
		FileOutputStream out = new FileOutputStream(prop.getProperty("quote_save_excel_path"));
		Thread.sleep(1000);
		wb.write(out);

	}

	public void search_and_verify_ownbook_hire_underwriting_get_proposal_id() throws InterruptedException, IOException {

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
		ExplicitWait.visibleElement(driver, underwriting_popup_proposal_id, 30);

		Thread.sleep(2000);

		String UnderwritingPopupProposalId = underwriting_popup_proposal_id.getText();
		Thread.sleep(2000);
		String UnderwritingPopupProposalIdFromScreen = UnderwritingPopupProposalId.substring(14, 21);
		Thread.sleep(2000);
		System.out.println("Underwriting Popup Proposal Id is =" + UnderwritingPopupProposalIdFromScreen);
		LO.print("Underwriting Popup Proposal Id is =" + UnderwritingPopupProposalIdFromScreen);

		Thread.sleep(1000);
		FileInputStream in = new FileInputStream(prop.getProperty("quote_save_excel_path"));
		Thread.sleep(1000);
		XSSFWorkbook wb = new XSSFWorkbook(in);

		Thread.sleep(1000);
		wb.getSheet("HPNRBCHQuoteNo").getRow(0).getCell(1).setCellValue(UnderwritingPopupProposalIdFromScreen);
		// wb.getSheet("BrokerBCHQuoteNo").getRow(0).getCell(2).setCellValue(UnderwritingPopupProposalId);
		Thread.sleep(1000);
		Thread.sleep(1000);
		FileOutputStream out = new FileOutputStream(prop.getProperty("quote_save_excel_path"));
		Thread.sleep(1000);
		wb.write(out);

	}

	public void search_and_verify_ownbook_purchase_underwriting_get_proposal_id()
			throws InterruptedException, IOException {

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
		ExplicitWait.visibleElement(driver, underwriting_popup_proposal_id, 30);

		Thread.sleep(2000);

		String UnderwritingPopupProposalId = underwriting_popup_proposal_id.getText();
		Thread.sleep(2000);
		String UnderwritingPopupProposalIdFromScreen = UnderwritingPopupProposalId.substring(14, 21);

		System.out.println("Underwriting Popup Proposal Id is =" + UnderwritingPopupProposalIdFromScreen);
		LO.print("Underwriting Popup Proposal Id is =" + UnderwritingPopupProposalIdFromScreen);

		FileInputStream in = new FileInputStream(prop.getProperty("quote_save_excel_path"));
		Thread.sleep(1000);
		XSSFWorkbook wb = new XSSFWorkbook(in);

		Thread.sleep(1000);
		wb.getSheet(prop.getProperty("HPNR_HPNR_QuoteNo")).getRow(1).getCell(3)
				.setCellValue(UnderwritingPopupProposalIdFromScreen);

		Thread.sleep(1000);
		FileOutputStream out = new FileOutputStream(prop.getProperty("quote_save_excel_path"));
		Thread.sleep(1000);
		wb.write(out);

	}

	public void search_and_verify_underwriting_send_for_underwriting_button() throws InterruptedException {

		ExplicitWait.visibleElement(driver, underwriting_send_for_underwriting_button, 30);
		underwriting_send_for_underwriting_button.click();

		System.out.println("Click on Send for Underwriting button");
		LO.print("Click on Send for Underwriting button");

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);

	}

	public void search_and_verify_underwriting_get_quote_no()

	{

		ExplicitWait.visibleElement(driver, underwriting_popup_quote_ref_no, 30);

		String underwriting_quote_ref_no = underwriting_popup_quote_ref_no.getText();

		System.out.println("Underwriting pop up - quote ref no  =>" + underwriting_quote_ref_no);
		LO.print("Underwriting pop up -quote ref no => " + underwriting_quote_ref_no);

	}

	public void search_and_verify_underwriting_download_contract_file() throws InterruptedException {

		ExplicitWait.visibleElement(driver, underwriting_popup_download_contract_file, 30);

		underwriting_popup_download_contract_file.click();

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);

		System.out.println("Click on underwriting pop up download contract file");
		LO.print("Click on underwriting pop up download contract file ");

	}

	public void search_and_verify_underwriting_download_proposal() throws InterruptedException {

		ExplicitWait.visibleElement(driver, underwriting_popup_download_proposal, 30);

		underwriting_popup_download_proposal.click();

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);

		System.out.println("Click on underwriting pop up download proposal");
		LO.print("Click on underwriting pop up download proposal ");

		ArrayList<String> browserwindow = new ArrayList<String>(driver.getWindowHandles());
		// switch to active tab
		driver.switchTo().window(browserwindow.get(1));

		System.out.println("Page title of active tab: " + driver.getTitle());
		LO.print("Page title of active tab: " + driver.getTitle());
		// switch to parent
		// driver.wait(2000);
		driver.switchTo().window(browserwindow.get(0));
		System.out.println("Page title of parent window: " + driver.getTitle());
		LO.print("Page title of parent window: " + driver.getTitle());
		// driver.quit();

	}

	public void verify_underwriting_cancel_button() {

		ExplicitWait.visibleElement(driver, underwriting_popup_cancel_button, 30);

		underwriting_popup_cancel_button.click();

		System.out.println("click on underwriting pop up cancel button");
		LO.print("click on underwriting pop up cancel button ");
	}

	public void verify_send_for_underwriting_button() throws InterruptedException {

		ExplicitWait.visibleElement(driver, underwriting_send_for_underwriting_button, 60);

		underwriting_send_for_underwriting_button.click();
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 60);

		System.out.println("click on underwriting_send_for_underwriting  button");
		LO.print("click on underwriting_send_for_underwriting  button ");
	}

	public void verify_ownbook_underwriting_popup_accept_with_change_flow() throws InterruptedException {

		ExplicitWait.visibleElement(driver, ownbook_underwriting_popup_accept, 30);

		ownbook_underwriting_popup_accept.click();

		ExplicitWait.visibleElement(driver, ownbook_underwriting_popup_accept_ok_button, 30);

		ownbook_underwriting_popup_accept_ok_button.click();

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);

		System.out.println("click on underwriting_send_for_underwriting  button");
		LO.print("click on underwriting_send_for_underwriting  button ");
	}
	// ownbook_underwriting_popup_accept (//button[normalize-space()='Accept'])[1]
	// ownbook_underwriting_popup_reject - (//button[normalize-space()='Reject'])[1]

}
