package com.amt.test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amt.CustomerQuotePackage.CustomerQuotePageOutrightFLPage;
import com.amt.HoldingCostPages.HoldingCostOutrightFLPage;
import com.amt.QuoteSummaryPages.QuoteSummaryOutrightFLPage;
import com.amt.pages.AcquisitionListingPage;
import com.amt.pages.LoginPage;
import com.amt.pages.OptionsAccessoriesPage;
import com.amt.pages.VehicleSelectionPage;
import com.amt.pages.ContractTypesAndOTRPages.ContractTypesAndOTR_Outright_FL_Ownbook_CalculationPage;
import com.amt.testBase.TestBase;
import com.amt.testUtil.ReadExcelData;

@Listeners(com.amt.testUtil.ScreenshotListener.class)
public class Acquisition_Quotes_Outright_FL_without_maintenance_Test extends TestBase {
    

	
	TestBase TB;
	LoginPage obj_Login_Page;
	AcquisitionListingPage obj_acq_listing_page;
	VehicleSelectionPage obj_vehicle_selection_page;
	OptionsAccessoriesPage obj_options_accessories;
	ContractTypesAndOTR_Outright_FL_Ownbook_CalculationPage obj_contract_types_and_OTR_page;
	HoldingCostOutrightFLPage obj_holding_cost_Outright_FL_page;
	CustomerQuotePageOutrightFLPage obj_customer_quote_page;
	QuoteSummaryOutrightFLPage obj_quote_summary_page;

	@Test(priority = 1, dataProvider = "testData")
	public void aquisition_quotes_outright_FL_OTR_calculation_without_maintenance_test(String manufacturer, String model,
			String  road_tax_for_first_year, String on_road_price_for_invoice, String percentage_cap_residual_value_used,
			String residual_value_used , String actual_part_exchange_value_from_excel, String given_part_exchange_value_from_excel,
			String less_finance_settlement_from_excel, String order_deposit_from_excel, String document_fee_from_excel,
			String upsell, String maintenance_required, String maintenance_margin, String initial_payment,
			String part_exchange_status, String target_rental, String sheet_name) throws InterruptedException, IOException, UnsupportedFlavorException {

		obj_acq_listing_page = new AcquisitionListingPage();
		obj_vehicle_selection_page = new VehicleSelectionPage();
		obj_options_accessories = new OptionsAccessoriesPage();
		obj_contract_types_and_OTR_page = new ContractTypesAndOTR_Outright_FL_Ownbook_CalculationPage();
	

		obj_acq_listing_page.aquisition_Listingpage_AddnewQuote();
		obj_vehicle_selection_page.select_vehicle(manufacturer, model);
		obj_options_accessories.options_And_Accessories_selection();
		boolean subtotal_after_discount = obj_contract_types_and_OTR_page
				.contractTypes_and_OTR_selection_outright_FL_Ownbook_calculation(sheet_name);
		Assert.assertTrue(subtotal_after_discount);


	}
	@Test(priority=2, dataProvider="testData", dependsOnMethods = { "aquisition_quotes_outright_FL_OTR_calculation_without_maintenance_test" })
	
	public void aquisition_quotes_outright_FL_after_discount_calculations_without_maintenance_test(String manufacturer, String model,
			String  road_tax_for_first_year, String on_road_price_for_invoice, String percentage_cap_residual_value_used,
			String residual_value_used , String actual_part_exchange_value_from_excel, String given_part_exchange_value_from_excel,
			String less_finance_settlement_from_excel, String order_deposit_from_excel, String document_fee_from_excel,
			String upsell, String maintenance_required, String maintenance_margin, String initial_payment,
			String part_exchange_status, String target_rental, String sheet_name) throws InterruptedException, IOException, UnsupportedFlavorException {


		obj_contract_types_and_OTR_page = new ContractTypesAndOTR_Outright_FL_Ownbook_CalculationPage();
		boolean otr_price_check = obj_contract_types_and_OTR_page
				.verify_after_discount_calculations_contract_types_page(sheet_name);
		Assert.assertTrue(otr_price_check);
	}
	
	@Test(priority=3, dataProvider="testData", dependsOnMethods = { "aquisition_quotes_outright_FL_after_discount_calculations_without_maintenance_test" })
	
	public void aquisition_quotes_outright_FL_holding_cost_calculations_without_maintenance_test(String manufacturer, String model,
			String  road_tax_for_first_year, String on_road_price_for_invoice, String percentage_cap_residual_value_used,
			String residual_value_used , String actual_part_exchange_value_from_excel, String given_part_exchange_value_from_excel,
			String less_finance_settlement_from_excel, String order_deposit_from_excel, String document_fee_from_excel,
			String upsell, String maintenance_required, String maintenance_margin, String initial_payment,
			String part_exchange_status, String target_rental, String sheet_name) throws InterruptedException, IOException, UnsupportedFlavorException {

		obj_holding_cost_Outright_FL_page = new HoldingCostOutrightFLPage();
	
		boolean holding_cost_before_editing_percentage_value = obj_holding_cost_Outright_FL_page
				.verify_holding_cost_before_editing_cap_values_without_maintenance(residual_value_used, percentage_cap_residual_value_used,
						maintenance_required, target_rental, sheet_name);
		Assert.assertTrue(holding_cost_before_editing_percentage_value);


	}
	@Test(priority=4, dataProvider="testData", dependsOnMethods = { "aquisition_quotes_outright_FL_holding_cost_calculations_without_maintenance_test" })
	
	public void aquisition_quotes_outright_FL_customer_quote_payment_profile_calculations_without_maintenance_test(String manufacturer, String model,
			String  road_tax_for_first_year, String on_road_price_for_invoice, String percentage_cap_residual_value_used,
			String residual_value_used , String actual_part_exchange_value_from_excel, String given_part_exchange_value_from_excel,
			String less_finance_settlement_from_excel, String order_deposit_from_excel, String document_fee_from_excel,
			String upsell, String maintenance_required, String maintenance_margin, String initial_payment,
			String part_exchange_status, String target_rental, String sheet_name) throws InterruptedException, IOException, UnsupportedFlavorException {

	
		obj_customer_quote_page = new CustomerQuotePageOutrightFLPage();	

		boolean customer_quote_for_payment_boolean = obj_customer_quote_page
				.customer_Quote_outright_FL_for_one_payment_option_without_maintenance_calculation(
						actual_part_exchange_value_from_excel, given_part_exchange_value_from_excel,
						less_finance_settlement_from_excel, order_deposit_from_excel, document_fee_from_excel, upsell,
						 maintenance_required, maintenance_margin, initial_payment,
						part_exchange_status, target_rental,sheet_name);
		System.out.println(customer_quote_for_payment_boolean);
		Assert.assertTrue(customer_quote_for_payment_boolean);

		boolean cutomer_quote_monthly_rental = obj_customer_quote_page
				.customer_Quote_outright_FL_for_all_payment_option_without_maintenance_calculation(initial_payment,sheet_name);
		Assert.assertTrue(cutomer_quote_monthly_rental);

	

	}
	@Test(priority=5, dataProvider="testData", dependsOnMethods = { "aquisition_quotes_outright_FL_customer_quote_payment_profile_calculations_without_maintenance_test" })
	
	public void aquisition_quotes_outright_FL_quote_summary_values_verification_without_maintenance_test(String manufacturer, String model,
			String  road_tax_for_first_year, String on_road_price_for_invoice, String percentage_cap_residual_value_used,
			String residual_value_used , String actual_part_exchange_value_from_excel, String given_part_exchange_value_from_excel,
			String less_finance_settlement_from_excel, String order_deposit_from_excel, String document_fee_from_excel,
			String upsell, String maintenance_required, String maintenance_margin, String initial_payment,
			String part_exchange_status, String target_rental, String sheet_name) throws InterruptedException, IOException, UnsupportedFlavorException {

		obj_quote_summary_page = new QuoteSummaryOutrightFLPage();

		boolean quote_summary_page_status = obj_quote_summary_page.quote_summary_outright_FL_without_maintenance(sheet_name);
		Assert.assertTrue(quote_summary_page_status);

	}
	
	

	@DataProvider(name = "testData")
	public Object[][] getTestData() throws IOException {
		Object[][] data = ReadExcelData.getTestData("OutrightFLwithoutMaintenance");
		return data;
	}

}
