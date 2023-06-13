package com.test.demo;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amt.CustomerQuotePackage.CustomerQuotePageBrokerHPNRPage;
import com.amt.CustomerQuotePackage.CustomerQuotePageBrokerHPRPage;
import com.amt.QuoteSummaryPages.QuoteSummaryBrokerHPNRPage;
import com.amt.QuoteSummaryPages.QuoteSummaryBrokerHPRPage;
import com.amt.pages.AcquisitionListingPage;
import com.amt.pages.OptionsAccessoriesPage;
import com.amt.pages.VehicleSelectionPage;
import com.amt.pages.ContractTypesAndOTRPages.ContractTypesAndOTR_Broker_HPNR_Page;
import com.amt.pages.ContractTypesAndOTRPages.ContractTypesAndOTR_Broker_HPR_Page;
import com.amt.testBase.TestBase;
import com.amt.testUtil.ReadExcelData;


@Listeners(com.amt.testUtil.ScreenshotListener.class)
public class Acquisition_Quotes_Broker_HPNR_Test extends TestBase {
	
	AcquisitionListingPage obj_acq_listing_page;
	VehicleSelectionPage obj_vehicle_selection_page;
	OptionsAccessoriesPage obj_options_accessories;
	ContractTypesAndOTR_Broker_HPNR_Page obj_contract_types_and_OTR_page;
	CustomerQuotePageBrokerHPNRPage obj_customer_quote_page;
	QuoteSummaryBrokerHPNRPage  obj_quote_summary_page;
	
	//1.Aquisition_quotes_user_flow_Broker_HPNR_OTR_calculation_subtotal_after_discount
		
	@Test(priority=1, dataProvider="testData")
	public void aquisition_quotes_user_flow_broker_HPNR_OTR_calculation_test(String manufacturer, String model,String vehicleProfit,
			String quoteRef,String quoteExpiryDate, String term, String milesperannum,String contractMileage,String cahDeposit,String financeCharges, 
			String noOfMonthlyPayments, String monthlyFinancePayment, String finalBallonPayment, String optionToPurchaseFee, 
			String rflIncluded, String apr, String commission,String partExchangeActual, String partExchangeGiven, String lessFinanceSettlemnet, String sheet_name) throws InterruptedException, IOException, UnsupportedFlavorException {
			
		
		 obj_acq_listing_page = new AcquisitionListingPage();
		 obj_vehicle_selection_page = new VehicleSelectionPage();
	     obj_options_accessories = new OptionsAccessoriesPage();
	     obj_contract_types_and_OTR_page = new ContractTypesAndOTR_Broker_HPNR_Page();
		
	     System.out.println( "1.********************Assert check for subtotal_after_discount**********************************");
	     
		obj_acq_listing_page.aquisition_Listingpage_AddnewQuote();
		obj_vehicle_selection_page.select_vehicle(manufacturer, model);
		obj_options_accessories.options_And_Accessories_selection();
		
		//1. Assert check for subtotal_after_discount
		
		boolean subtotal_after_discount=obj_contract_types_and_OTR_page.contractTypes_and_OTR_selection_broker_hpnr(sheet_name);
		
		Assert.assertTrue(subtotal_after_discount);	
		
		
		
		System.out.println( "Assert check for subtotal after discount is completed");
		
		
		System.out.println( "******************************************************");
		System.out.println( "----------------------------------------------------");
		System.out.println( "----------------------------------------------------");
		System.out.println( "----------------------------------------------------");
		System.out.println( "----------------------------------------------------");
		
		
	}
	
	
	
	
	
	
	
	  //2.OTR_on the road price for invoice
	  
	  @Test(priority=2, dataProvider="testData", dependsOnMethods = {
	  "aquisition_quotes_user_flow_broker_HPNR_OTR_calculation_test" })
	  
	  
	  public void
	  aquisition_quotes_user_flow_broker_HPNR_after_discount_calculations_test(
	  String manufacturer, String model,String vehicleProfit, String
	  quoteRef,String quoteExpiryDate, String term, String milesperannum,String
	  contractMileage,String cahDeposit,String financeCharges, String
	  noOfMonthlyPayments, String monthlyFinancePayment, String finalBallonPayment,
	  String optionToPurchaseFee, String rflIncluded, String apr, String
	  commission,String partExchangeActual, String partExchangeGiven, String
	  lessFinanceSettlemnet, String sheet_name) throws InterruptedException,
	  IOException, UnsupportedFlavorException {
	  
	  
	  obj_contract_types_and_OTR_page = new ContractTypesAndOTR_Broker_HPNR_Page();
	  
	  
	  System.out.println(  "2.********************Assert check for on the road price for invoice**********************************");
	  
	  //2. Assert check for on the road price for invoice
	  
	  boolean otr_price_check = obj_contract_types_and_OTR_page.
	  verify_after_discount_calculations_contract_types_page(sheet_name);
	  
	  Assert.assertTrue(otr_price_check);
	  
	  
	  System.out.println(
	  "Assert check for on the road price for invoice is completed");
	  
	  System.out.println(
	  "******************************************************");
	  System.out.println( "----------------------------------------------------");
	  System.out.println( "----------------------------------------------------");
	  System.out.println( "----------------------------------------------------");
	  System.out.println( "----------------------------------------------------");
	  
	  
	  System.out.println( "OTR Calculation is completed");
	  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  //3. Aquisition_quotes_user_flow_broker_HPNR_Customer_quote_adding_Vehicle_profit_check
	  
	  
	  @Test(priority=3, dataProvider="testData", dependsOnMethods = {
	  "aquisition_quotes_user_flow_broker_HPNR_after_discount_calculations_test" })
	  
	  public void
	  aquisition_quotes_user_flow_broker_HPNR_vehicle_profit_check_test(String
	  manufacturer, String model,String vehicleProfit, String quoteRef,String
	  quoteExpiryDate, String term, String milesperannum,String
	  contractMileage,String cahDeposit,String financeCharges, String
	  noOfMonthlyPayments, String monthlyFinancePayment, String finalBallonPayment,
	  String optionToPurchaseFee, String rflIncluded, String apr, String
	  commission,String partExchangeActual, String partExchangeGiven, String
	  lessFinanceSettlemnet, String sheet_name) throws InterruptedException,
	  IOException, UnsupportedFlavorException {
	  
	  
	  obj_customer_quote_page = new CustomerQuotePageBrokerHPNRPage();
	  
	  
	  System.out.println(
	  "3.********************Assert check customer_quote_vehicle_profit_check**********************************"
	  );
	  
	  // 3.Assert check customer_quote_vehicle_profit_check
	  
	  boolean customer_quote_vehicle_profit_check=obj_customer_quote_page.
	  customer_Quote_vehicle_profit_checking_broker_hpnr(vehicleProfit,quoteRef,
	  quoteExpiryDate, term, milesperannum, contractMileage,cahDeposit,
	  noOfMonthlyPayments, monthlyFinancePayment, finalBallonPayment,
	  optionToPurchaseFee, rflIncluded, apr,commission, partExchangeActual,
	  partExchangeGiven, lessFinanceSettlemnet, sheet_name);
	  
	  Assert.assertTrue(customer_quote_vehicle_profit_check);
	  
	  System.out.println(
	  "Assert check customer_quote_vehicle_profit_check is completed");
	  System.out.println(
	  "******************************************************");
	  System.out.println( "----------------------------------------------------");
	  System.out.println( "----------------------------------------------------");
	  System.out.println( "----------------------------------------------------");
	  System.out.println( "----------------------------------------------------");
	  
	  
	  
	  
	  }
	  
	  
	  
	  
	  
	  
	  //4.Aquisition_quotes_user_flow_broker_HPNR_Balance to finance
	  
	  @Test(priority=4, dataProvider="testData", dependsOnMethods = {
	  "aquisition_quotes_user_flow_broker_HPNR_vehicle_profit_check_test" })
	  
	  public void
	  aquisition_quotes_user_flow_broker_HPNR_balance_to_finance_check_test(String
	  manufacturer, String model,String vehicleProfit, String quoteRef,String
	  quoteExpiryDate, String term, String milesperannum,String
	  contractMileage,String cahDeposit,String financeCharges, String
	  noOfMonthlyPayments, String monthlyFinancePayment, String finalBallonPayment,
	  String optionToPurchaseFee, String rflIncluded, String apr, String
	  commission,String partExchangeActual, String partExchangeGiven, String
	  lessFinanceSettlemnet, String sheet_name) throws InterruptedException,
	  IOException, UnsupportedFlavorException {
	  
	  
	  obj_customer_quote_page = new CustomerQuotePageBrokerHPNRPage();
	  
	  
	  System.out.println(
	  "4.********************Assert check customer_quote_Balance to finance *********************************"
	  );
	  
	  // 4.Assert check customer_quote_Balance to finance
	  
	  
	  boolean customer_quote_balance_to_finance_check=obj_customer_quote_page.
	  customer_Quote_balance_to_finance_checking_broker_hpnr(vehicleProfit,quoteRef
	  ,quoteExpiryDate, term, milesperannum, contractMileage,cahDeposit,
	  financeCharges,noOfMonthlyPayments, monthlyFinancePayment,
	  finalBallonPayment, optionToPurchaseFee, rflIncluded, apr,commission,
	  partExchangeActual, partExchangeGiven, lessFinanceSettlemnet, sheet_name);
	  Assert.assertTrue(customer_quote_balance_to_finance_check); 
	  
	 
	  
	  System.out.println(
	  "Assert check customer_quote_Balance to finance is completed");
	  
	  System.out.println(
	  "******************************************************");
	  System.out.println( "----------------------------------------------------");
	  System.out.println( "----------------------------------------------------");
	  System.out.println( "----------------------------------------------------");
	  System.out.println( "----------------------------------------------------");
	  
	  
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  @Test(priority=5, dataProvider="testData", dependsOnMethods = {
	  "aquisition_quotes_user_flow_broker_HPNR_balance_to_finance_check_test" })
	  
	  public void
	  aquisition_quotes_user_flow_broker_HPNR_quote_summary_values_verification_test
	  (String manufacturer, String model,String vehicleProfit, String
	  quoteRef,String quoteExpiryDate, String term, String milesperannum,String
	  contractMileage,String cahDeposit,String financeCharges, String
	  noOfMonthlyPayments, String monthlyFinancePayment, String finalBallonPayment,
	  String optionToPurchaseFee, String rflIncluded, String apr, String
	  commission,String partExchangeActual, String partExchangeGiven, String
	  lessFinanceSettlemnet, String sheet_name) throws InterruptedException,
	  IOException, UnsupportedFlavorException {
	  
	  
	  obj_quote_summary_page =new QuoteSummaryBrokerHPNRPage();
	  
	  
	  System.out.println(
	  "5.********************Assert check the quote summary  *********************************"
	  );
	  
	  
	  boolean quote_summary_page_status =
	  obj_quote_summary_page.quote_summary_broker_HPNR(sheet_name);
	  Assert.assertTrue(quote_summary_page_status);
	  
	  
	  
	  System.out.println( "Assert check the quote summary is completed");
	  
	  System.out.println(
	  "******************************************************");
	  System.out.println( "----------------------------------------------------");
	  System.out.println( "----------------------------------------------------");
	  System.out.println( "----------------------------------------------------");
	  System.out.println( "----------------------------------------------------");
	  
	  }
	 
	// Test data file for using this quote 
	
	@DataProvider(name="testData")
	
	public Object[][]  getTestData1() throws IOException {
		
		
		System.out.println("Test data file name passing in excel sheet = BrokerHPNR") ;
		
		Object[][] data=ReadExcelData.getTestData("BrokerHPNR");
		
		//System.out.println("Data getting from excel sheet = "  + Object[][] data ) ;
		
		return data;
		
		
	}

}
