package com.amt.test.copyquote;

import java.io.IOException;

import org.testng.annotations.Test;

import com.amt.pages.AcquisitionListingPage;
import com.amt.testBase.TestBase;


public class Copy_Quote_Test extends TestBase {
	
	
	AcquisitionListingPage obj_acq_listing_page;
	
	@Test
	public void copy_Quote_for_broker_business_hire_Test() throws IOException, InterruptedException, ClassNotFoundException{			
		
		 obj_acq_listing_page = new AcquisitionListingPage();
		 
		 obj_acq_listing_page.copy_quote();
	}
	
	@Test
	public void copy_Quote_for_broker_business_purchase_Test() throws IOException, InterruptedException, ClassNotFoundException{			
		
		 obj_acq_listing_page = new AcquisitionListingPage();
		 
		 obj_acq_listing_page.copy_quote();
	}
	
	@Test
	public void copy_Quote_for_broker_individual_hire_Test() throws IOException, InterruptedException, ClassNotFoundException{			
		
		 obj_acq_listing_page = new AcquisitionListingPage();
		 
		 obj_acq_listing_page.copy_quote();
	}
	
	@Test
	public void copy_Quote_for_broker_individual_purchase_Test() throws IOException, InterruptedException, ClassNotFoundException{			
		
		 obj_acq_listing_page = new AcquisitionListingPage();
		 
		 obj_acq_listing_page.copy_quote();
	}
	
	@Test
	public void copy_Quote_for_ownbook_individual_purchase_Test() throws IOException, InterruptedException, ClassNotFoundException{			
		
		 obj_acq_listing_page = new AcquisitionListingPage();
		 
		 obj_acq_listing_page.copy_quote();
	}
	
	
	@Test
	public void copy_Quote_for_ownbook_business_purchase_Test() throws IOException, InterruptedException, ClassNotFoundException{			
		
		 obj_acq_listing_page = new AcquisitionListingPage();
		 
		 obj_acq_listing_page.copy_quote();
	}
	
	
	@Test
	public void copy_Quote_for_ownbook_individual_hire_Test() throws IOException, InterruptedException, ClassNotFoundException{			
		
		 obj_acq_listing_page = new AcquisitionListingPage();
		 
		 obj_acq_listing_page.copy_quote();
	}
	
	
	@Test
	public void copy_Quote_for_ownbook_business_hire_Test() throws IOException, InterruptedException, ClassNotFoundException{			
		
		 obj_acq_listing_page = new AcquisitionListingPage();
		 
		 obj_acq_listing_page.copy_quote();
	}


}
