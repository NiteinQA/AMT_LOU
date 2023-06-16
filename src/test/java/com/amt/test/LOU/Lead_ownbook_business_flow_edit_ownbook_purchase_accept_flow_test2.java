package com.amt.test.LOU;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.amt.pages.Leads;
import com.amt.pages.Opportunities;
import com.amt.pages.Proposal;
import com.amt.pages.Underwriting;
import com.amt.pages.UnderwritingPopupPage;
import com.amt.testBase.TestBase;
import com.amt.testUtil.Difference;
import com.amt.testUtil.GetExcelFormulaValue;
import com.amt.testUtil.RemoveComma;

@Listeners(com.amt.testUtil.ScreenshotListener.class)
public class Lead_ownbook_business_flow_edit_ownbook_purchase_accept_flow_test2 extends TestBase {

	Leads obj_Leads_Page;
	Opportunities obj_Opportunities_Page;
	Proposal obj_Proposal_Page;

	UnderwritingPopupPage obj_Underwriting_Popup_Page;

	Underwriting obj_Underwriting_page;
	
	

	@Test(priority = 1)
	public void L1_ownbook_create_lead_business() throws Exception {

		obj_Leads_Page = new Leads();
		obj_Leads_Page.lead_General_info();
		obj_Leads_Page.lead_Customer_info_business();
		obj_Leads_Page.lead_vehicle_request_ownbook();

		// Business = HPNR + HPNR
		obj_Leads_Page.lead_map_new_quote_owbook_purchase_business();

		obj_Leads_Page.lead_map_new_quote_broker_business_save_and_Convert();

	}

	@Test(priority = 2)
	public void L2_ownbook_create_opportunity_business() throws Exception {

		// Opportunity flow

		obj_Opportunities_Page = new Opportunities();
		Thread.sleep(1000);
		obj_Opportunities_Page.opp_menu_link();

		obj_Proposal_Page = new Proposal();
		// Opportunity listing screen - Proposal status
		obj_Proposal_Page.Opp_listing_proposal_status();

		obj_Opportunities_Page.opp_search_textbox();
		
		

	}

	@Test(priority = 3)

	public void L3_Ownbook_create_opportunity_business_currentstatus_before_sending_to_proposal() throws Exception {

		obj_Opportunities_Page = new Opportunities();

		boolean opp_CurrentStatus = obj_Opportunities_Page
				.verify_current_status_of_opportunity_before_sending_to_proposal();

		Assert.assertTrue(opp_CurrentStatus);

		System.out.println("Status Verified : Before sending the proposal ");
		LO.print("Status Verified : Before sending the proposal");

	}

	@Test(priority = 4)

	public void L4_ownbook_create_opportunity_business_adding_proposal() throws Exception {

		obj_Opportunities_Page.opp_listing_detail_page();

		obj_Opportunities_Page.opp_opp_fact_find();

		// Proposal page for adding data in opportunity - Customer info, Additionalinfo
		// , Bank detail

		obj_Proposal_Page.proposal_Add_Customer_info();

		obj_Proposal_Page.Opp_listing_proposal_fill_form_manually();

	}

	/*
	 * obj_Opportunities_Page.opp_listing_detail_page();
	 * 
	 * obj_Opportunities_Page.opp_opp_fact_find();
	 * 
	 * 
	 * //Proposal page for adding data in opportunity - Customer info, Additional
	 * info , Bank detail
	 * 
	 * 
	 * obj_Proposal_Page.proposal_Add_Customer_info();
	 * 
	 * obj_Proposal_Page.Opp_listing_proposal_fill_form_manually();
	 * 
	 * 
	 * // Opportunity listing screen - Proposal status
	 * obj_Proposal_Page.Opp_listing_proposal_status();
	 * 
	 * // Send Contract flow
	 * 
	 * obj_Opportunities_Page.opp_find_channel_status();
	 * 
	 * obj_Opportunities_Page.opp_find_send_contract_icon();
	 * 
	 * obj_Opportunities_Page.opp_find_channel_status();
	 * 
	 * 
	 * 
	 * }
	 */

	@Test(priority = 5)

	public void L5_ownbook_create_opportunity_business_currentstatus_after_sending_to_proposal() throws Exception {
		obj_Opportunities_Page = new Opportunities();

		// Opportunity listing screen - Proposal status
		boolean opp_AfterCurrentStatus = obj_Opportunities_Page
				.verify_current_status_of_opportunity_after_sending_to_proposal();

		Assert.assertTrue(opp_AfterCurrentStatus);

		System.out.println("Status Verified : After sending the proposal ");
		LO.print("Status Verified : After sending the proposal");

	}
	
	//verifying monthly payment before sending contract to sign
	
	@Test(priority = 6)

	public void L6_ownbook_verify_monthly_payment_before_sending_contract() throws Exception {

		obj_Opportunities_Page = new Opportunities();
			
		Assert.assertTrue(obj_Opportunities_Page.opp_verify_monthly_payment());

	}


	@Test(priority = 6)

	public void L7_ownbook_create_opportunity_business_sending_to_contract() throws Exception {

		obj_Opportunities_Page = new Opportunities();

		// Opportunity listing screen - Proposal status
		// obj_Proposal_Page.Opp_listing_proposal_status();

		// Send Contract flow

		// obj_Opportunities_Page.opp_Find_Channel_Status();

		obj_Opportunities_Page.opp_find_send_contract_icon();

		// obj_Opportunities_Page.opp_Find_Channel_Status();

		Thread.sleep(4000);

	}

	@Test(priority = 7)

	public void L8_ownbook_create_opportunity_business_currentstatus_after_sending_to_contract() throws Exception {

		obj_Opportunities_Page = new Opportunities();

		// Opportunity listing screen - Proposal status
		boolean opp_AfterCurrentStatus_contract = obj_Opportunities_Page
				.verify_current_status_of_opportunity_after_sending_to_customer_contract();

		Assert.assertTrue(opp_AfterCurrentStatus_contract);

		System.out.println("Status Verified : Sent to customer ");
		LO.print("Status Verified : Status Verified : Sent to customer");

		// String GetOpportunityid
		// =obj_Leads_Page.lead_map_new_quote_broker_business_getting_the_opportunityno();

		// obj_Opportunities_Page.opp_search_textbox(GetOpportunityid);

	}

	@Test(priority = 8)
	public void L9_ownbook_signed_contract_status_with_api_call() throws Exception

	{

		obj_Opportunities_Page = new Opportunities();

		String[] OppDATA = obj_Opportunities_Page.get_api_data_opp();

		String opp_id_screen = OppDATA[0];
		String quote_ref_screen = OppDATA[1];

		System.out.println("opp_id_screen" + opp_id_screen);

		System.out.println("quote_ref_screen" + quote_ref_screen);

		int statuscode = obj_Opportunities_Page.postAPITest(quote_ref_screen, opp_id_screen);

		Assert.assertEquals(statuscode, 200);

		System.out.println("Status code 200 received ");

		obj_Opportunities_Page.opp_search_textbox();

	}

	
	  @Test(priority = 9)
	  
	  public void L10_ownbook_status_after_contract_signed() throws Exception {
	  
	  obj_Opportunities_Page = new Opportunities();
	  
	 boolean CurrentStatusafterContractSigned = obj_Opportunities_Page
	  .verify_current_status_of_opportunity_after_contract_signed();
	  Assert.assertTrue(CurrentStatusafterContractSigned);
	  
	  }
	 

	@Test(priority = 10)

	public void UW1_verify_underwriting_flow_ownbook_with_status() throws Exception {

		obj_Underwriting_Popup_Page = new UnderwritingPopupPage();

		obj_Underwriting_Popup_Page.search_and_verify_underwriting_icon_is_availabale();

		obj_Underwriting_Popup_Page.search_and_verify_ownbook_purchase_underwriting_get_proposal_id();
		obj_Underwriting_Popup_Page.search_and_verify_underwriting_get_quote_no();

		// obj_Underwriting_Popup_Page.search_and_verify_underwriting_download_contract_file();
		// //
		// obj_Underwriting_Popup_Page.search_and_verify_underwriting_download_proposal();

		obj_Underwriting_Popup_Page.verify_send_for_underwriting_button();

	}

	@Test(priority = 11)

	public void UW2_verify_status_after_sending_to_underwriting() throws Exception {

		obj_Opportunities_Page = new Opportunities();

		boolean CurrentStatusafterSendingToUnderwriting = obj_Opportunities_Page
				.verify_current_status_of_opportunity_after_contract_sending_to_underwriting();
		Assert.assertTrue(CurrentStatusafterSendingToUnderwriting);

	}

	@Test(priority = 12)

	public void UW3_verify_underwriting_lisitig_page() throws Exception {

		// obj_Underwriting_Popup_Page = new UnderwritingPopupPage();

		obj_Underwriting_page = new Underwriting();

		obj_Underwriting_page.verify_underwriting_menulink();

		obj_Underwriting_page.verify_underwriting_menulink_ownbook();

		obj_Underwriting_page.verify_underwriting_proposal_ownbook_purchase_search_text_box();

	}

	
	  @Test(priority = 12)
	  
	  public void UW4_verify_ownbook_underwriting_proposal_page_flow() throws
	  Exception {
	  
	  // obj_Underwriting_Popup_Page = new UnderwritingPopupPage();
	  
	  obj_Underwriting_page = new Underwriting();
	  
	  // obj_Underwriting_page.verify_underwriting_menulink();
	  
	  // obj_Underwriting_page.verify_underwriting_menulink_broker();
	  
	  obj_Underwriting_page.find_underwriting_listing_detail_for_proposal();
	  
	  //
	  obj_Underwriting_page.find_underwriting_listing_detail_listing_yes_option();
	  
	  obj_Underwriting_page.find_underwriting_tab_quote_page();
	  
	  //obj_Underwriting_page.find_underwriting_tab_creditfile_page();
	  
	  //obj_Underwriting_page.find_underwriting_tab_document_page();
	  obj_Underwriting_page.find_underwriting_tab_decision_page();
	  
	  }
	 

		/*
		 * @Test(priority = 13)
		 * 
		 * public void UW6_verify_ownbook_underwriting_proposal_decision_with_declined()
		 * throws Exception {
		 * 
		 * obj_Underwriting_page = new Underwriting();
		 * 
		 * // obj_Underwriting_page.find_underwriting_listing_detail_for_proposal();
		 * obj_Underwriting_page.find_underwriting_tab_decision_page();
		 * 
		 * obj_Underwriting_page.find_decision_decline(); obj_Underwriting_page.
		 * verification_underwriting_tab_decision_page_saveandexit_button();
		 * 
		 * boolean statusofdecline = obj_Underwriting_page
		 * .verify_current_status_of_underwriting_after_sending_to_decline();
		 * Assert.assertTrue(statusofdecline);
		 * 
		 * }
		 */

	
	 @Test(priority = 15)
	  
	  public void UW7_verify_ownbook_underwriting_proposal_decision_with_accept()
	  throws Exception {
	  
	 obj_Underwriting_page = new Underwriting();
	  
	  //obj_Underwriting_page.find_underwriting_listing_detail_for_proposal();
	  
	  //obj_Underwriting_page.find_underwriting_listing_detail_listing_yes_option()
	  ;
	  
	 //obj_Underwriting_page.find_underwriting_tab_decision_page();
	 obj_Underwriting_page.find_underwriting_tab_decision_page_accept_button();
	  
	 // obj_Underwriting_page.find_underwriting_tab_decision_page_accept_upload();
	 // //
	  obj_Underwriting_page.verification_underwriting_tab_decision_page_view_icon()
	 ; obj_Underwriting_page.
	  verification_underwriting_tab_decision_page_saveandexit_button();
	  
	 // Assert for Accept condition 
	 boolean statusofaccept =
	 obj_Underwriting_page.
	 verify_current_status_of_underwriting_after_sending_to_accept();
	  Assert.assertTrue(statusofaccept);
	  
	 }
	 

	/*
	 * @Test(priority = 13)
	 * 
	 * public void
	 * UW5_verify_ownbook_underwriting_proposal_decision_accept_with_changes
	 * ()throws Exception {
	 * 
	 * obj_Underwriting_page = new Underwriting();
	 * 
	 * //obj_Underwriting_page.find_underwriting_listing_detail_for_proposal();
	 * 
	 * 
	 * 
	 * //obj_Underwriting_page.find_underwriting_tab_decision_page();
	 * obj_Underwriting_page.find_underwriting_tab_decision_page_accept_button();
	 * obj_Underwriting_page.ownbook_purchase_accept_with_change_the_data_quote();
	 * 
	 * 
	 * obj_Underwriting_page.
	 * verification_underwriting_tab_decision_page_saveandexit_button();
	 * 
	 * // obj_Underwriting_page.find_underwriting_decision_yes_option();
	 * 
	 * 
	 * // Assert for Accept condition boolean statusofaccept =
	 * obj_Underwriting_page.
	 * verify_current_status_of_underwriting_after_sending_to_accept_with_changes();
	 * Assert.assertTrue(statusofaccept);
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @Test(priority = 14)
	 * 
	 * public void
	 * UW6_verify_ownbook_opportunity_search_text_box_accept_with_changes ()throws
	 * Exception {
	 * 
	 * obj_Opportunities_Page = new Opportunities(); obj_Underwriting_Popup_Page =
	 * new UnderwritingPopupPage();
	 * 
	 * obj_Opportunities_Page.opp_menu_link();
	 * 
	 * obj_Opportunities_Page.
	 * verify_opportunity_ownbook_purchase_quote_search_text_box();
	 * 
	 * 
	 * }
	 * 
	 * 
	 * @Test(priority = 15)
	 * 
	 * public void
	 * UW7_verify_ownbook_opportunity_accept_with_changes_underwriting_pop_up
	 * ()throws Exception
	 * 
	 * { obj_Underwriting_Popup_Page = new UnderwritingPopupPage();
	 * 
	 * 
	 * obj_Underwriting_Popup_Page.search_and_verify_underwriting_icon_is_availabale
	 * ();
	 * 
	 * obj_Underwriting_Popup_Page.
	 * verify_ownbook_underwriting_popup_accept_with_change_flow();
	 * 
	 * }
	 * 
	 * 
	 * 
	 * @Test(priority = 16)
	 * 
	 * public void
	 * UW8_verify_ownbook_opportunity_underwriting_accept_with_changes_cancel_flow_verification
	 * ()throws Exception
	 * 
	 * { obj_Underwriting_Popup_Page = new UnderwritingPopupPage();
	 * obj_Opportunities_Page = new Opportunities();
	 * 
	 * //obj_Opportunities_Page.verify_opportunity_ownbook_quote_search_text_box();
	 * 
	 * 
	 * 
	 * boolean CurrentStatusafterAcceptingTheNewChangesFromUnderwritingPopup =
	 * obj_Opportunities_Page.
	 * verify_current_status_after_accept_new_changes_from_underwriting_pop_up();
	 * Assert.assertTrue(
	 * CurrentStatusafterAcceptingTheNewChangesFromUnderwritingPopup);
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @Test(priority = 17)
	 * 
	 * public void
	 * UW8_verify_ownbook_opportunity_underwriting_accept_with_changes_underwriting_pop_up
	 * ()throws Exception
	 * 
	 * { obj_Underwriting_Popup_Page = new UnderwritingPopupPage();
	 * obj_Opportunities_Page = new Opportunities();
	 * 
	 * obj_Opportunities_Page.
	 * verify_opportunity_ownbook_purchase_quote_search_text_box();
	 * 
	 * 
	 * 
	 * //boolean CurrentStatusafterAcceptingTheNewChangesFromUnderwritingPopup =
	 * obj_Opportunities_Page.
	 * verify_current_status_after_accept_new_changes_from_underwriting_pop_up();
	 * //Assert.assertTrue(
	 * CurrentStatusafterAcceptingTheNewChangesFromUnderwritingPopup);
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * @Test(priority = 18) public void
	 * UW9_ownbook_after_opportunity_underwriting_accept_with_changes_signed_contract_status_with_api_call
	 * () throws Exception
	 * 
	 * {
	 * 
	 * obj_Opportunities_Page = new Opportunities();
	 * 
	 * String[] OppDATA = obj_Opportunities_Page.
	 * get_api_data_opp_after_decision_underwriting_accpet_the_changes();
	 * 
	 * String opp_id_screen = OppDATA[0]; String quote_ref_screen2 = OppDATA[1];
	 * 
	 * System.out.println("opp_id_screen" + opp_id_screen);
	 * 
	 * System.out.println("quote_ref_screen" + quote_ref_screen2);
	 * 
	 * int statuscode = obj_Opportunities_Page.postAPITest(quote_ref_screen2,
	 * opp_id_screen);
	 * 
	 * Assert.assertEquals(statuscode, 200);
	 * 
	 * System.out.println("Status code 200 received ");
	 * 
	 * obj_Opportunities_Page.opp_search_textbox(opp_id_screen);
	 * 
	 * }
	 */

	/*
	 * @Test(priority = 19)
	 * 
	 * public void
	 * OP1_verify_underwriting_flow_ownbook_after_contract_signed_with_latest_changes
	 * () throws Exception {
	 * 
	 * obj_Underwriting_Popup_Page = new UnderwritingPopupPage();
	 * obj_Opportunities_Page = new Opportunities(); //obj_Opportunities_Page.
	 * search_and_verify_underwriting_icon_is_availabale_after_cancel_flow();
	 * //obj_Underwriting_Popup_Page.
	 * search_and_verify_underwriting_pop_up_close_button();
	 * 
	 * 
	 * }
	 */

	/*
	 * @Test(priority = 20) public void
	 * UW9B_ownbook_after_Underwriting_accepted_mothlty_payment_price() throws
	 * Exception
	 * 
	 * { Thread.sleep(2000);
	 * 
	 * obj_Opportunities_Page = new Opportunities();
	 * 
	 * String[] DataValue1 =
	 * obj_Opportunities_Page.get_new_quote_price_after_underwriting_accepted();
	 * 
	 * 
	 * 
	 * String Quoteref_web_1 = DataValue1[0]; String MonthlyPayment_web_1 =
	 * DataValue1[1];
	 * 
	 * String QuoteCancelled_web_1 = DataValue1[2];
	 * 
	 * String MonthlyPayment_cancelled_1 = DataValue1[3] ;
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * System.out.println(" New Quote ref value is  =" + Quoteref_web_1);
	 * 
	 * System.out.println("New Monthly Payment value is  = " +
	 * MonthlyPayment_web_1);
	 * 
	 * 
	 * 
	 * System.out.println(" Cancelled Quote ref value is  =" +
	 * QuoteCancelled_web_1);
	 * System.out.println("Cancelled Mothly Payment value is  = " +
	 * MonthlyPayment_cancelled_1);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @Test(priority = 21) public void
	 * UW9D_ownbook_mothlty_payment_price_moving_to_excelsheet() throws Exception
	 * 
	 * {
	 * 
	 * obj_Opportunities_Page = new Opportunities();
	 * 
	 * 
	 * 
	 * double screen_quote_monthly_payment =obj_Opportunities_Page.
	 * fetching_the_new_quote_monthly_payment_sending_to_excel();
	 * 
	 * double screen_total_cap_maint_value = obj_Opportunities_Page.
	 * open_the_underwriting_accepted_get_the_holdingcost_total_cap_maint_value();
	 * double excel_quote_monthly_payment
	 * =obj_Opportunities_Page.set_the_orderdepositandcashdeposit_in_excelsheet(
	 * screen_total_cap_maint_value);
	 * 
	 * 
	 * boolean flag=false; double diff1
	 * =Difference.of_two_Double_Values(screen_quote_monthly_payment,
	 * excel_quote_monthly_payment); if(diff1<0.2)
	 * {LO.print("Monthly payment price compared ");
	 * 
	 * System.out.println("Monthly payment price compared"); flag=true;
	 * 
	 * } else {LO.
	 * print("Found difference between Monthly rental price actual price and Monthly rental price  excel "
	 * );
	 * 
	 * System.out.
	 * println("Found difference between Monthly rental price actual price and Monthly rental price  excel"
	 * );}
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

}
