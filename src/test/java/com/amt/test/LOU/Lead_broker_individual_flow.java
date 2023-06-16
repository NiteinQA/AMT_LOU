package com.amt.test.LOU;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amt.pages.Leads;
import com.amt.pages.Opportunities;
import com.amt.pages.Proposal;
import com.amt.testBase.TestBase;
import com.amt.testUtil.GetExcelFormulaValue;

@Listeners(com.amt.testUtil.ScreenshotListener.class)
public class Lead_broker_individual_flow extends TestBase {

	Leads obj_Leads_Page;
	Opportunities obj_Opportunities_Page;
	Proposal obj_Proposal_Page;

	@Test(priority = 1)
	public void broker_create_lead_individual() throws Exception {

		obj_Leads_Page = new Leads();

		obj_Leads_Page.lead_General_info();
		
		obj_Leads_Page.lead_Customer_info_individual();
		// obj_Leads_Page.lead_communication_log_Add_Note();

		// obj_Leads_Page.lead_communication_log_log_a_call();
		obj_Leads_Page.lead_vehicle_request_broker();

		
		// Individual = Broker + PCH
		obj_Leads_Page.lead_map_new_quote_broker_individual();
		

		// verifying table values with Quote save excel sheet values before saving
		boolean table_verification_before_save = obj_Leads_Page.verify_table_values_on_lead_page();

		// obj_Leads_Page.lead_map_new_quote_ownbook_individual();
		obj_Leads_Page.lead_map_new_quote_broker_business_save_and_Convert();

		// verifying table values with Quote save excel sheet values before saving
		boolean table_verification_after_save = obj_Leads_Page.verify_table_values_on_lead_page();

		boolean flag = false;
		if (table_verification_before_save && table_verification_after_save)

		{
			flag = true;
		}

		// Assert.assertTrue(flag);

		// Getting oppo ID and Saving to excel sheet and printing to console
		obj_Leads_Page.lead_map_new_quote_broker_business_getting_the_opportunityno();

	}

	@Test(priority = 2)
	public void broker_create_opportunity_individual() throws Exception {

		// Opportunity flow

		obj_Opportunities_Page = new Opportunities();

		obj_Opportunities_Page.opp_menu_link();

		obj_Opportunities_Page.opp_search_textbox();

	}

	@Test(priority = 3)

	public void broker_create_opportunity_individual_currentstatus_before_sending_to_proposal() throws Exception {

		obj_Opportunities_Page = new Opportunities();

		boolean opp_CurrentStatus = obj_Opportunities_Page
				.verify_current_status_of_opportunity_before_sending_to_proposal();

		Assert.assertTrue(opp_CurrentStatus);

		System.out.println("Status Verified : Before sending the proposal ");
		LO.print("Status Verified : Before sending the proposal");

	}

	@Test(priority = 4)

	public void broker_create_opportunity_individual_adding_proposal() throws Exception {

		obj_Opportunities_Page.opp_listing_detail_page();

		obj_Opportunities_Page.opp_listing_detail_update_individual();
		// obj_Opportunities_Page.opp_opp_fact_find_Find();

		// Proposal page for adding data in opportunity - Customer info, Additional info
		// , Bank detail

		// obj_Proposal_Page.proposal_Add_Customer_info();

		obj_Proposal_Page.proposal_Add_Individual_info();

		obj_Proposal_Page.Opp_listing_proposal_fill_form_manually();

	}

	@Test(priority = 5)

	public void broker_create_opportunity_individual_currentstatus_after_sending_to_proposal() throws Exception {
		obj_Opportunities_Page = new Opportunities();

		// Opportunity listing screen - Proposal status
		boolean opp_AfterCurrentStatus = obj_Opportunities_Page
				.verify_current_status_of_opportunity_after_sending_to_proposal();

		Assert.assertTrue(opp_AfterCurrentStatus);

		System.out.println("Status Verified : After sending the proposal ");
		LO.print("Status Verified : After sending the proposal");

	}

	// Send Contract flow

	@Test(priority = 6)

	public void broker_create_opportunity_individual_sending_to_contract() throws Exception {
		obj_Opportunities_Page = new Opportunities();

		obj_Opportunities_Page.opp_find_send_contract_icon();

	}

	@Test(priority = 7)

	public void broker_create_opportunity_individual_currentstatus_after_sending_to_contract() throws Exception {
		obj_Opportunities_Page = new Opportunities();

		// Opportunity listing screen - Proposal status
		boolean opp_AfterCurrentStatus_contract = obj_Opportunities_Page
				.verify_current_status_of_opportunity_after_sending_to_customer_contract();

		Assert.assertTrue(opp_AfterCurrentStatus_contract);

		System.out.println("Status Verified : Sent to customer ");
		LO.print("Status Verified : Status Verified : Sent to customer");

	}

}
