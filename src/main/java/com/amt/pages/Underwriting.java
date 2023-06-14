package com.amt.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
import com.amt.testUtil.Dropdown;

public class Underwriting extends TestBase {

	JavascriptExecutor js;


	@FindBy(xpath = "//img[@alt='Loading...']")
	private List<WebElement> loading_icon;

	
	@FindBy(xpath = "//i[@class='icon-opportunity']")
	private WebElement opportunities;

	//1.underwriting_menu_link
    @FindBy(xpath = "//span[contains(text(),'Underwriting')]")
	private WebElement underwriting_menu_link;
	
    
  //2a.underwriting_menu_link_broker;
  	@FindBy(xpath = "/html/body/app-root/div[1]/div[2]/div[1]/div/app-sidemenu/div/div[11]/ul/li[1]/a/span")
  	private WebElement underwriting_menu_link_broker;
  	
  	
    //2a.underwriting_menu_link_ownbook;
  	@FindBy(xpath = "/html/body/app-root/div[1]/div[2]/div[1]/div/app-sidemenu/div/div[11]/ul/li[2]/a/span")
  	private WebElement underwriting_menu_link_ownbook;
  	
  	

  	
  
  	
  	//3.underwriting_proposal_id
  	
	 @FindBy(xpath = "//*[@id='cWraper']/div/app-underwriting-management/div[2]/div/div/app-uw-listing/div[1]/app-grid/div[2]/div/div[2]/div[1]/table/tbody/tr[1]/td[1]")
private WebElement underwriting_proposal_id;

	 
	//4.underwriting_seach_text_box;
		
		
@FindBy(xpath = "//input[@placeholder='Search something here']")
private WebElement underwriting_Seach_text_box;




@FindBy(xpath = "//*[@id='cWraper']/div/app-underwriting-management/div[2]/div/div/app-uw-listing/div[1]/app-grid/div[2]/div/div[2]/div[1]/table/tbody/tr")
private WebElement proposal_detail_listing_data;



	@FindBy(xpath = "//p[contains(text(),'Quote')]")
private WebElement underwriting_tab_quote;


@FindBy(xpath = "//p[contains(text(),'Credit File')]")
private WebElement underwriting_tab_creditfile;


   @FindBy(xpath = "//p[contains(text(),'Documents')]")
private WebElement underwriting_tab_document;


   
  
   
   @FindBy(xpath = "(//p[normalize-space()='Decision'])[1]")
   private WebElement decision_tab_document;

   

//Accept_button
  @FindBy(xpath = "//button[normalize-space()='Accept']")
private WebElement Accept_button;

  
  // Please confirm
  @FindBy(xpath = "//div[@id='changeConfirmationModal']//button[@class='btn btn-secondary float-right'][normalize-space()='Yes']")
private WebElement confirm_button;
  
 
	
	
  
  
// Upload 
  @FindBy(xpath = "//button[normalize-space()='Upload']")
private WebElement accept_upload_button;


  
 // accept_security_deposit_required 
  @FindBy(xpath = "//input[@id='securityDeposit']")
private WebElement accept_security_deposit_required;
  
  
  
//accept_increased_order_deposit
 @FindBy(xpath = "(//input[@id='increasedOrderDeposit'])[1]")
private WebElement accept_increased_order_deposit;
  

 //accept_Maintained contract required
 
 @FindBy(xpath = "//label[contains(text(),'Required')]")
private WebElement accept_maintained_contract_required;
 
 
 
// finance deposit
 
 @FindBy(xpath = "//input[@id='increasedFinanceDeposit']")
 private WebElement accept_finance_deposit;

 ///
 
 @FindBy(xpath = "//label[contains(text(),'Thatcham approved tracker must be fitted')]")
 private WebElement accept_tracker_must_be_fitted;

 
 @FindBy(xpath = "//label[normalize-space()='Manufacturer tracker must be activated by customer']")
 private WebElement  Manufacturer_tracker_must_be_activated_by_customer;
 
 @FindBy(xpath = "//label[normalize-space()='AMT tracker required']")
 private WebElement  AMT_tracker_required;
 
 @FindBy(xpath = "//label[normalize-space()='Satisfied']")
 private WebElement  StatisfyCheckbox;
 
 
 
 
 @FindBy(xpath = "//label[normalize-space()='Contract must include insurance']")
 private WebElement   Contract_must_include_insurance;
 
 
 @FindBy(xpath = "//label[normalize-space()='Other Conditions']")
 private WebElement   Other_conditions;
 
 
 @FindBy(xpath = "//input[@placeholder='Other']")
 private WebElement   Other_conditions_textbox;
 
 
 @FindBy(xpath = "//textarea[@placeholder='Enter special remarks']")
 private WebElement   Notestoapplicant;
 
 //Accept condition 
 
 
 //Driving licence for Accept
 
 
 @FindBy(xpath = "//ng-select[@name='drivingLicenceFor']//input[@role='combobox']")
 private WebElement   Driving_licence_for_Accept;
 
		
 //Proof of address for
 
	@FindBy(xpath = "//ng-select[@name='addressProofFor']//input[@role='combobox']")
	private WebElement   Proof_of_address_for;
	
	
	//Director's guarantee in the name(s) of
	
	@FindBy(xpath = "//ng-select[@name='directorGuarantee']//input[@role='combobox']")
	private WebElement   Director_guarantee_in_the_name;
	
	
	//Cross company guarantee in the name of
	@FindBy(xpath = "//input[@id='crosscompanyguarantee']")
	private WebElement   Cross_company_guarantee_in_the_name_of;
	
	
	
		 
		 
		 
		 
 
 

 



 

 
 
			
 
 //
 
 
//accept_select_Payment_profile
@FindBy(xpath = "(//span[@class='ng-arrow-wrapper'])[4]")
private WebElement accept_payment_profile;
	
//accept_Initial payment amount
@FindBy(xpath = "//*[@id=\"initialPayments\"]")
private WebElement Initial_payment_amount;

	
	//Initial_payment_amount
 
			
 
 //underw_listing_decision_yes_option
		
		
//accept_increased_order_deposit
@FindBy(xpath = "(//button[@class='btn btn-secondary'][normalize-space()='Yes'])[1]")
private WebElement underw_listing_decision_yes_option;
 
  
  
  
  
	
	// View Upload 
	  @FindBy(xpath = "//*[@src='/assets/images/view.svg']")
	private WebElement desicion_upload_view;
	
	
	// view close
	  
		
		  
		  @FindBy(xpath = "//*[@id='FileView']//*[@class='close']")
			private WebElement desicion_upload_view_close;
			
	  
	  
		// Save and exit 
	  @FindBy(xpath = "//button[normalize-space()='Save & Exit']")
	private WebElement desicion_save_exit_button;
	
	
	  
	  // Con - Yes button
	  
	
	  @FindBy(xpath = "//*[@id='decisionConfirmation']//button[contains(text(),'Yes')]")
		private WebElement desicion_save_exit_button_confirm_yes;
	  
	  

	  @FindBy(xpath = "//button[normalize-space()='Refer']")
		private WebElement refer_button;
		
	  
	  @FindBy(xpath = "//div[@class='custom-control custom-checkbox withoutlabel text-center']//input[@id='Payslips']")
		private WebElement refer_check_box_icon;
	  
	 
	  
	  @FindBy(xpath = "//textarea[@class='ng-valid ng-dirty ng-touched'] ")
		private WebElement refer_notes_textbox;  

	  


// underwriting current status 
	  
	  @FindBy(xpath = "(//td[@class='ng-star-inserted'])[9]")
		private WebElement underw_current_status;  

	  
	  @FindBy(xpath = "//div[@id='confirmationModal']//button[@class='btn btn-secondary float-right'][normalize-space()='Yes']")
		private WebElement underw_listing_yes_option;  
	  

	  
			



// decision_decline_tab
	  @FindBy(xpath ="//button[normalize-space()='Decline']")
		private WebElement underw_decision_decline_tab; 
	  
	

//
	  
	  @FindBy(xpath ="(//span[normalize-space()='Spread rentals initial payment'])[1]")
		private WebElement underw_accept_spread_rental_payment_value; 
	  

//















Properties prop;

	public Underwriting() 
	{
	try
	{
		prop=new Properties();
		FileInputStream ip = new FileInputStream("D:\\LOU\\AMT_LOU\\src\\main\\java\\configs\\excelValues.properties");
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


		public void verify_underwriting_menulink()
		{
		
		ExplicitWait.visibleElement(driver, underwriting_menu_link, 30);
		
		HelperClass.highlightElement(driver, underwriting_menu_link);
		
		
		underwriting_menu_link.click();
		
		System.out.println("Click on Underwriting menu_link "); 
		LO.print("Click on Underwriting menu_link ");

		
		}
		
		
		
		public void verify_underwriting_menulink_broker() throws InterruptedException
		{
		
			ExplicitWait.visibleElement(driver, underwriting_menu_link_broker, 20);
			
			HelperClass.highlightElement(driver, underwriting_menu_link_broker);
			
			underwriting_menu_link_broker.click();
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
			
			System.out.println("Click on Underwriting - broker tab "); 
			LO.print("Click on Underwriting - broker tab " );
		
		}
		
		
		
		
		public void verify_underwriting_menulink_ownbook() throws InterruptedException
		{
		
			ExplicitWait.visibleElement(driver, underwriting_menu_link_ownbook, 30);
			
			//HelperClass.highlightElement(driver, underwriting_menu_link_ownbook);
			
			//underwriting_menu_link_ownbookclick();
			underwriting_menu_link_ownbook.click();
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
			
			System.out.println("Click on Underwriting - ownbook tab "); 
			LO.print("Click on Underwriting - ownbook tab " );
		
		}
		
		
		
		
		
		/*
		 * public String verify_underwriting_proposal_id() throws InterruptedException {
		 * 
		 * ExplicitWait.visibleElement(driver, underwriting_proposal_id, 20);
		 * 
		 * HelperClass.highlightElement(driver, underwriting_proposal_id);
		 * 
		 * String proposalID = underwriting_proposal_id.getText(); return proposalID;
		 * 
		 * 
		 * 
		 * 
		 * }
		 */

		
		
		
		
		
		public void verify_underwriting_proposal_search_text_box() throws InterruptedException, IOException
		{
		
			ExplicitWait.visibleElement(driver, underwriting_Seach_text_box, 20);
			
			HelperClass.highlightElement(driver, underwriting_Seach_text_box);
			System.out.println("Click on Search text box - broker tab"); 
			LO.print("Click on Search text box - broker tab" );
			Thread.sleep(6000);
			
			
		
			
		FileInputStream fis = new FileInputStream(prop.getProperty("quote_save_excel_path"));
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("HPNRBCHQuoteNo");// selecting sheet with its name as a parameter
		Thread.sleep(1000);
		//System.out.println("Taking the sheet name is  =" + fis); 
		System.out.println("Taking the sheet name is  =" + sheet.getSheetName()); 
		
		XSSFRow row = sheet.getRow(0);// read data from first row as 0th row contains header
		XSSFCell cell = row.getCell(1);// read data from first cell
		
       // System.out.println(cell);
System.out.println(sheet.getRow(0).getCell(1));
Thread.sleep(1000);
String UnderwritingPrposalId = cell.getStringCellValue();

System.out.println("Getting the  proposal id from excel sheet  =" + UnderwritingPrposalId); 
LO.print("Getting the  proposal id from excel sheet =" + UnderwritingPrposalId);

Thread.sleep(1000);
//System.out.println(cellval);
		
		//String UnderwritingPrposalId =cell.getStringCellValue();
		
		//System.out.println("proposal id before send to search text box   =" + UnderwritingPrposalId); 
			
			//Obj_Underwriting_Page = new	Underwriting();
			
ExplicitWait.visibleElement(driver, underwriting_Seach_text_box, 20);			

			Click.sendKeys(driver, underwriting_Seach_text_box, UnderwritingPrposalId, 20);
			
			System.out.println("Enter the proposal in search text box =" + UnderwritingPrposalId); 
			LO.print("Enter the proposal in search text box =" + UnderwritingPrposalId);
			
			
			
			
		
			
			
			underwriting_Seach_text_box.sendKeys(Keys.ENTER);
	
		
			
		
		}
		
		
		
		
		
		public void verify_underwriting_proposal_ownbook_hire_search_text_box() throws InterruptedException, IOException
		{
		
			ExplicitWait.visibleElement(driver, underwriting_Seach_text_box, 20);
			
			HelperClass.highlightElement(driver, underwriting_Seach_text_box);
			System.out.println("Click on Search text box - broker tab"); 
			LO.print("Click on Search text box - broker tab" );
			Thread.sleep(6000);
			
			
		
			
		FileInputStream fis = new FileInputStream(prop.getProperty("quote_save_excel_path"));
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("HPNRBCHQuoteNo");// selecting sheet with its name as a parameter
		Thread.sleep(1000);
		//System.out.println("Taking the sheet name is  =" + fis); 
		System.out.println("Taking the sheet name is  =" + sheet.getSheetName()); 
		
		XSSFRow row = sheet.getRow(0);// read data from first row as 0th row contains header
		XSSFCell cell = row.getCell(1);// read data from first cell
		
       // System.out.println(cell);
System.out.println(sheet.getRow(0).getCell(1));
Thread.sleep(1000);
String UnderwritingPrposalId = cell.getStringCellValue();

System.out.println("Getting the  proposal id from excel sheet  =" + UnderwritingPrposalId); 
LO.print("Getting the  proposal id from excel sheet =" + UnderwritingPrposalId);

Thread.sleep(1000);
//System.out.println(cellval);
		
		//String UnderwritingPrposalId =cell.getStringCellValue();
		
		//System.out.println("proposal id before send to search text box   =" + UnderwritingPrposalId); 
			
			//Obj_Underwriting_Page = new	Underwriting();
			
ExplicitWait.visibleElement(driver, underwriting_Seach_text_box, 20);			

			Click.sendKeys(driver, underwriting_Seach_text_box, UnderwritingPrposalId, 20);
			
			System.out.println("Enter the proposal in search text box =" + UnderwritingPrposalId); 
			LO.print("Enter the proposal in search text box =" + UnderwritingPrposalId);
			
			
			
			
		
			
			
			underwriting_Seach_text_box.sendKeys(Keys.ENTER);
	
		
			
		
		}
		
		
		
		
		
		public void verify_underwriting_proposal_ownbook_purchase_search_text_box() throws InterruptedException, IOException
		{
		
			ExplicitWait.visibleElement(driver, underwriting_Seach_text_box, 20);
			
			HelperClass.highlightElement(driver, underwriting_Seach_text_box);
			System.out.println("Click on Search text box - broker tab"); 
			LO.print("Click on Search text box - broker tab" );
			Thread.sleep(6000);
			
			
		
			
		FileInputStream fis = new FileInputStream(prop.getProperty("quote_save_excel_path"));
		XSSFWorkbook book = new XSSFWorkbook(fis);
		XSSFSheet sheet = book.getSheet("HPNR_HPNR_QuoteNo");// selecting sheet with its name as a parameter
		Thread.sleep(1000);
		//System.out.println("Taking the sheet name is  =" + fis); 
		System.out.println("Taking the sheet name is  =" + sheet.getSheetName()); 
		
		XSSFRow row = sheet.getRow(0);// read data from first row as 0th row contains header
		XSSFCell cell = row.getCell(1);// read data from first cell
		
       // System.out.println(cell);
System.out.println(sheet.getRow(0).getCell(1));
Thread.sleep(1000);
String UnderwritingPrposalId = cell.getStringCellValue();

System.out.println("Getting the  proposal id from excel sheet  =" + UnderwritingPrposalId); 
LO.print("Getting the  proposal id from excel sheet =" + UnderwritingPrposalId);

Thread.sleep(1000);
//System.out.println(cellval);
		
		//String UnderwritingPrposalId =cell.getStringCellValue();
		
		//System.out.println("proposal id before send to search text box   =" + UnderwritingPrposalId); 
			
			//Obj_Underwriting_Page = new	Underwriting();
			
ExplicitWait.visibleElement(driver, underwriting_Seach_text_box, 20);			

			Click.sendKeys(driver, underwriting_Seach_text_box, UnderwritingPrposalId, 20);
			
			System.out.println("Enter the proposal in search text box =" + UnderwritingPrposalId); 
			LO.print("Enter the proposal in search text box =" + UnderwritingPrposalId);
			
			
			
			
		
			
			
			underwriting_Seach_text_box.sendKeys(Keys.ENTER);
	
		
			
		
		}
		
		
		
		
		


		
		// Ownbook - search with Quote id - common in both Underwriting & Opp
		
		
		
		

		
		
		
		
		
		  public void find_underwriting_listing_detail_listing_yes_option() throws InterruptedException {
		  
			  
			  
		  ExplicitWait.visibleElement(driver, underw_listing_yes_option, 20);
		  
		  HelperClass.highlightElement(driver, underw_listing_yes_option);
		  
		  Thread.sleep(2000);
		  
		  
		  underw_listing_yes_option.click();
		  
		  ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
		  
		  }
		 
		  
		  

		  public void find_underwriting_decision_yes_option() throws InterruptedException {
		  
			  
			  
		  ExplicitWait.visibleElement(driver, underw_listing_decision_yes_option, 20);
		  
		  HelperClass.highlightElement(driver, underw_listing_decision_yes_option);
		  
		
		  
		  ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
		  underw_listing_decision_yes_option.click();
		  
		  ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
		  
		  }
		
		

		
		public void find_underwriting_listing_detail_for_proposal() throws InterruptedException
			{
			
			ExplicitWait.visibleElement(driver, proposal_detail_listing_data, 20);
			
			HelperClass.highlightElement(driver, proposal_detail_listing_data);
			
			Thread.sleep(2000);
			
			
			Actions actions = new Actions(driver);
	
			actions.doubleClick(proposal_detail_listing_data).perform();
			
			
			
		//	Click.on(driver, proposal_detail_listing_data, 30);
			
			
			
			System.out.println("Click on Underwriting detail page for proposal"); 
			LO.print("Click on Underwriting detail page for proposal");

			
			
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
			
			}
			
			
			
			public void find_underwriting_tab_quote_page() throws InterruptedException
			{
				
				ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
				Thread.sleep(7000);
			
			ExplicitWait.visibleElement(driver, underwriting_tab_quote, 30);
			
			//HelperClass.highlightElement(driver, underwriting_tab_quote);
			
			Click.on(driver, underwriting_tab_quote, 30);
		
			
			System.out.println("Click on Underwriting quote page"); 
			LO.print("Click on Underwriting quote page");

			  ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
			
			}
			
			
			
			public void find_underwriting_tab_creditfile_page() throws InterruptedException
			{
			
				  ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);	
				Thread.sleep(4000);
			ExplicitWait.visibleElement(driver, underwriting_tab_creditfile, 30);
			
			HelperClass.highlightElement(driver, underwriting_tab_creditfile);
			
			Click.on(driver, underwriting_tab_creditfile, 30);

			
			System.out.println("Click on credit file tab page "); 
			LO.print("Click on credit file page ");
			

			
		}
		


		
			public void find_underwriting_tab_document_page() throws InterruptedException
			{
				
				  ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
				Thread.sleep(4000);
				
			
			ExplicitWait.visibleElement(driver, underwriting_tab_document, 30);
			
			HelperClass.highlightElement(driver, underwriting_tab_document);
			
			Click.on(driver, underwriting_tab_document, 30);

			
			System.out.println("Click on document file tab page "); 
			LO.print("Click on document file page ");
			

			
		}
		
		
		public void find_underwriting_tab_decision_page() throws InterruptedException
			{
			
			 
			Thread.sleep(4000);
			
			  ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
			
			ExplicitWait.visibleElement(driver, decision_tab_document, 20);
			
			HelperClass.highlightElement(driver, decision_tab_document);
			
			Click.on(driver, decision_tab_document, 30);
		
			
			System.out.println("Click on decision tab page"); 
			LO.print("Click on decision tab page");
			

			
		}
		
		public void find_underwriting_tab_decision_page_accept_button() throws InterruptedException
			{
			
			Thread.sleep(4000);
			ExplicitWait.visibleElement(driver, Accept_button, 20);
			
			HelperClass.highlightElement(driver, Accept_button);
			
			Click.on(driver, Accept_button, 30);
			
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
			
			System.out.println("Click on decision tab Accept button "); 
			LO.print("Click on decision Accept button");
			

			
		}
		
		
		public void onchanging_refer_to_accept_underwriting_please_confirm_button() throws InterruptedException
		{
		
	ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
		
		ExplicitWait.visibleElement(driver, confirm_button, 30);
		
		//HelperClass.highlightElement(driver, confirm_button);
		
		Click.on(driver, confirm_button, 30);
		
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
		
		System.out.println("On changing refer to accept button - Please confirm pop will display "); 
		LO.print("On changing refer to accept button - Please confirm pop will display ");
		

		
	}
		
		
		
		
		
		
		public void ownbook_accept_with_change_the_data_quote() throws Exception

		{
	           //input[@id='securityDeposit']

			//1.proposal_indvidual_first_name 
			ExplicitWait.visibleElement(driver, accept_security_deposit_required, 20);
			
			
			
			Click.sendKeys(driver, accept_security_deposit_required, "5000", 30);

			 //(//input[@id='increasedOrderDeposit'])[1]
			//2.proposal_indvidual_first_name 
			ExplicitWait.visibleElement(driver, accept_increased_order_deposit, 20);
			
			
			Click.sendKeys(driver, accept_increased_order_deposit, "5000", 30);
			
			System.out.println("Now selecting the payment profile option "); 
			
			
			
			 
			
			//ExplicitWait.visibleElement(driver, accept_payment_profile, 30);
			
			HelperClass.highlightElement(driver, accept_payment_profile);
			
			Thread.sleep(2000);
			accept_payment_profile.click();
			
		   underw_accept_spread_rental_payment_value.click();
			Thread.sleep(2000);
			
			
			//accept_payment_profile.sendKeys("Spread rentals initial payment");
			
			//Thread.sleep(5000);
			
		//	Click.sendKeys(driver, accept_payment_profile, "Spread rentals initial payment", 30);
			
			
			ExplicitWait.visibleElement(driver, Initial_payment_amount, 30);
			Thread.sleep(5000);
			Click.sendKeys(driver, Initial_payment_amount, "500", 30);
			Thread.sleep(5000);
			
			
			
		
			
	
		}
		
		

		public void ownbook_hire_accept_with_change_the_data_quote() throws Exception

		{
	           //input[@id='securityDeposit']

			//1.proposal_indvidual_first_name 
			ExplicitWait.visibleElement(driver, accept_security_deposit_required, 20);
			
			
			
			Click.sendKeys(driver, accept_security_deposit_required, "5000", 30);

			 //(//input[@id='increasedOrderDeposit'])[1]
			//2.proposal_indvidual_first_name 
			ExplicitWait.visibleElement(driver, accept_increased_order_deposit, 20);
			
			
			Click.sendKeys(driver, accept_increased_order_deposit, "5000", 30);
			
			System.out.println("Now selecting the payment profile option "); 
			
			
			
			 
			
			//ExplicitWait.visibleElement(driver, accept_payment_profile, 30);
			
			HelperClass.highlightElement(driver, accept_payment_profile);
			
			Thread.sleep(2000);
			accept_payment_profile.click();
			
		   underw_accept_spread_rental_payment_value.click();
			Thread.sleep(2000);
			
			
			//accept_payment_profile.sendKeys("Spread rentals initial payment");
			
			//Thread.sleep(5000);
			
		//	Click.sendKeys(driver, accept_payment_profile, "Spread rentals initial payment", 30);
			
			
			ExplicitWait.visibleElement(driver, Initial_payment_amount, 30);
			Thread.sleep(5000);
			Click.sendKeys(driver, Initial_payment_amount, "500", 30);
			Thread.sleep(5000);
			
			
			
		
			
	
		}
		
		
		
		
		public void ownbook_purchase_accept_with_change_the_data_quote() throws Exception

		{
	           
			ExplicitWait.visibleElement(driver, accept_security_deposit_required, 20);
			Click.sendKeys(driver, accept_security_deposit_required, "5000", 30);

			
			ExplicitWait.visibleElement(driver, accept_increased_order_deposit, 20);
			Click.sendKeys(driver, accept_increased_order_deposit, "5000", 30);
			
			
			ExplicitWait.visibleElement(driver, accept_finance_deposit, 20);
			Click.sendKeys(driver, accept_finance_deposit, "5000", 30);
			
			
			ExplicitWait.visibleElement(driver, accept_maintained_contract_required, 20);
			accept_maintained_contract_required.click();
			
			
			
			
			///////////////////
			
			  ExplicitWait.visibleElement(driver, accept_tracker_must_be_fitted, 20);
			  accept_tracker_must_be_fitted.click();
			  
			  
			  ExplicitWait.visibleElement(driver,
			  Manufacturer_tracker_must_be_activated_by_customer, 20);
			  Manufacturer_tracker_must_be_activated_by_customer.click();
			  
			  
			  ExplicitWait.visibleElement(driver, AMT_tracker_required, 20);
			  AMT_tracker_required.click();
			  
			  ExplicitWait.visibleElement(driver, StatisfyCheckbox, 20);
			  StatisfyCheckbox.click();
			  
			  
			  ExplicitWait.visibleElement(driver, Contract_must_include_insurance, 20);
			  Contract_must_include_insurance.click();
			  
			  
			  
			  ExplicitWait.visibleElement(driver, Other_conditions, 20);
			  Other_conditions.click();
			  
			  
			  
			  ExplicitWait.visibleElement(driver, Other_conditions_textbox, 20);
			  Click.sendKeys(driver, Other_conditions_textbox, "Test", 30);
			  
			  
			  
			  ExplicitWait.visibleElement(driver, Notestoapplicant, 20);
			  Click.sendKeys(driver, Notestoapplicant, "Test Notes", 30);
			 
			  
			  
			 
			 
			  
			
			 
		
			
			////////////////
			
			
			  ExplicitWait.visibleElement(driver, Driving_licence_for_Accept, 20);
			  
			  Click.sendKeys(driver, Driving_licence_for_Accept, "QA comp2Test", 30);
			  
			  Thread.sleep(2000);
			  Driving_licence_for_Accept.sendKeys(Keys.ENTER);
			  
			  
			  Thread.sleep(2000);
			  
			  ExplicitWait.visibleElement(driver, Proof_of_address_for, 20);
			  Click.sendKeys(driver, Proof_of_address_for, "QA comp2Test", 30);
			  
			  Thread.sleep(2000);
			  Proof_of_address_for.sendKeys(Keys.ENTER);
			  
			  
			  ExplicitWait.visibleElement(driver, Director_guarantee_in_the_name, 20);
			  Click.sendKeys(driver, Director_guarantee_in_the_name, "QA comp2Test", 30);
			  
			  Thread.sleep(2000);
			  Director_guarantee_in_the_name.sendKeys(Keys.ENTER);
			  
			  
			  ExplicitWait.visibleElement(driver, Cross_company_guarantee_in_the_name_of,  20); 
			  Click.sendKeys(driver, Driving_licence_for_Accept, "QA comp2 Test", 30);
			  Thread.sleep(2000);
			  Driving_licence_for_Accept.sendKeys(Keys.ENTER);
			
			
		

			

			


			
			
			
			
			
			
			
			
		
			
	
		}
		
		
		
		
		public void find_underwriting_tab_decision_page_accept_upload() throws InterruptedException, AWTException
			{
			Thread.sleep(4000);
			
			ExplicitWait.visibleElement(driver, accept_upload_button, 20);
			
			HelperClass.highlightElement(driver, accept_upload_button);
			
			Click.on(driver, accept_upload_button, 30);
			
			
			Thread.sleep(4000);

			 Robot rb = new Robot();
			 
			 
			    // copying File path to Clipboard
			    StringSelection str = new StringSelection("C:\\Users\\mehul.nagar\\Desktop\\test2.pdf");
			    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
			 
			     // press Contol+V for pasting
			     rb.keyPress(KeyEvent.VK_CONTROL);
			     rb.keyPress(KeyEvent.VK_V);
			 
			    // release Contol+V for pasting
			    rb.keyRelease(KeyEvent.VK_CONTROL);
			    rb.keyRelease(KeyEvent.VK_V);
			 
			    // for pressing and releasing Enter
			    rb.keyPress(KeyEvent.VK_ENTER);
			    rb.keyRelease(KeyEvent.VK_ENTER);
			    
				System.out.println("File is Uploaded Successfully");
				
			   }
			

		
		public void find_underwriting_tab_decision_page_refer_button() throws InterruptedException
		{
		
		Thread.sleep(4000);
		ExplicitWait.visibleElement(driver, refer_button, 20);
		
		HelperClass.highlightElement(driver, refer_button);
		
		Click.on(driver, refer_button, 30);

		
		System.out.println("Click on decision tab Refer button "); 
		LO.print("Click on decision tab Refer button");
		

		
	}
		
		
		
		public void edit_underwriting_tab_decision_page_refer_button() throws InterruptedException
		{
		
		Thread.sleep(4000);
		//ExplicitWait.visibleElement(driver, refer_check_box_icon, 20);
		
		HelperClass.highlightElement(driver, refer_check_box_icon);
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//JavascriptExecutor js = (JavascriptExecutor)driver;   
		js.executeScript("arguments[0].click();",refer_check_box_icon);
		
	
	
				
		
	
				//js.executeScript(refer_check_box_icon);
				
		
		
		
		System.out.println("Click on checkbox value in refer page"); 
		LO.print("Click on checkbox value in refer page");
		

		
	}
		
		
		public void find_underwriting_tab_decision_page_refer_notes_textbox() throws InterruptedException
		{
		
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
		//Thread.sleep(4000);
		ExplicitWait.visibleElement(driver, refer_notes_textbox, 20);
		
		HelperClass.highlightElement(driver, refer_notes_textbox);
		
		Click.on(driver, refer_notes_textbox, 30);

		
		
		
		
		System.out.println("Enter the refer notes in text box button"); 
		LO.print("Enter the refer notes in text box button");
		

		
		
		//ExplicitWait
		
		Click.sendKeys(driver, refer_notes_textbox, "Need to update document", 30);
		
		
		
		
	}
		

		
		

		
		
		
		
		public void verification_underwriting_tab_decision_page_view_icon() throws InterruptedException
			{
			
			ExplicitWait.visibleElement(driver, desicion_upload_view, 30);
			
			HelperClass.highlightElement(driver, desicion_upload_view);
			
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
			//Thread.sleep(4000);
			Click.on(driver, desicion_upload_view, 30);
			
			Thread.sleep(4000);
			
		System.out.println("click on view icon ");

		System.out.println("Document is visible");
	
		
		
		Click.on(driver, desicion_upload_view_close, 30); 
		//*[@id="FileView"]//*[@class="close"]
		System.out.println("Document is visible");
		
		Thread.sleep(4000);
		System.out.println("click on view icon close icon ");
		
		}
		
		
		
		public void verification_underwriting_tab_decision_page_saveandexit_button() throws InterruptedException
			{
			
			ExplicitWait.visibleElement(driver, desicion_save_exit_button, 30);
			
			HelperClass.highlightElement(driver, desicion_save_exit_button);
			
			
			Click.on(driver, desicion_save_exit_button, 30);
			
			
			System.out.println("Click on save and exit button");
			
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);

			
			// Yes button on confirmation  
			
			
			
			Click.on(driver, desicion_save_exit_button_confirm_yes, 30);
			
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
			
			
			
		}
		
		
		
		
		public boolean verify_current_status_of_underwriting_after_sending_to_refer() throws Exception

		{

			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);

		
			ExplicitWait.visibleElement(driver, underw_current_status, 30);

		
		

			String ScreenValueforRefer = underw_current_status.getText();

			

			System.out.println("::::::::::::::::::::::::::::::Current Status for underwriting for refer :::::::::::::::::::::::::::::::::::::");

			System.out.println(" ");
			
			

			System.out.println(" Current Status of refer screen value is = " + ScreenValueforRefer);
			LO.print("Current Status of refer value is = " + ScreenValueforRefer);

		

			boolean CurrentStatusofUndewriting = ScreenValueforRefer.equals("Referred");

			System.out.println("Mapping the current Status of Referred in Underwriting page is =" + CurrentStatusofUndewriting);

			

			boolean flag = false;
			if (CurrentStatusofUndewriting )

			{

				flag = true;
			}

			System.out.println(":::::::::::::::::::Referred status is verified on underwriting listing page:: ::::::::::::::::::::::::::::::::::::::::::::::::");


			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			
			return flag;

		}
		
		
		
		
		
		
		public boolean verify_current_status_of_underwriting_after_sending_to_accept() throws Exception

		{

			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);

		
			ExplicitWait.visibleElement(driver, underw_current_status, 30);

		
		

			String ScreenValueforAccept = underw_current_status.getText();

			

			System.out.println("::::::::::::::::::::::::::::::Current Status for underwriting for Accept  :::::::::::::::::::::::::::::::::::::");

			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			

			System.out.println(" Current Status of accept screen value is = " + ScreenValueforAccept);
			LO.print("Current Status of accept value is = " + ScreenValueforAccept);

		

			boolean CurrentStatusofUndewriting = ScreenValueforAccept.equals("Accepted");

			System.out.println(" Mapping the current Status of Accept in Underwriting page is   = " + CurrentStatusofUndewriting);

			

			boolean flag = false;
			if (CurrentStatusofUndewriting )

			{

				flag = true;
			}

			System.out.println(":::::::::::::::::::::::Accept status is verified on underwriting listing page:::::::::::::::::::::::::::::::::::::::::::::");
			System.out.println(" ");
			System.out.println(" ");
			
			return flag;

		}
		
		
		public boolean verify_current_status_of_underwriting_after_sending_to_accept_with_changes() throws Exception

		{

			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);

		
			ExplicitWait.visibleElement(driver, underw_current_status, 30);

		
		

			String ScreenValueforAccept = underw_current_status.getText();

			

			System.out.println("::::::::::::::::::::::::::::::Current Status for underwriting for Accept  :::::::::::::::::::::::::::::::::::::");

			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			

			System.out.println(" Current Status of accept screen value is = " + ScreenValueforAccept);
			LO.print("Current Status of accept value is = " + ScreenValueforAccept);

		

			boolean CurrentStatusofUndewriting = ScreenValueforAccept.equals("Conditional acceptance");

			System.out.println(" Mapping the current Status of Accept in Underwriting page is   = " + CurrentStatusofUndewriting);

			

			boolean flag = false;
			if (CurrentStatusofUndewriting )

			{

				flag = true;
			}

			System.out.println(":::::::::::::::::::::::Accept status is verified on underwriting listing page:::::::::::::::::::::::::::::::::::::::::::::");
			System.out.println(" ");
			System.out.println(" ");
			
			return flag;

		}
		
		
		
		
		
		
		public boolean verify_current_status_of_underwriting_after_sending_to_direct_accept() throws Exception

		{

			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);

		
			ExplicitWait.visibleElement(driver, underw_current_status, 30);

		
		

			String ScreenValueforAccept = underw_current_status.getText();

			

			System.out.println("::::::::::::::::::::::::::::::Current Status for underwriting for  direct Accept  :::::::::::::::::::::::::::::::::::::");

			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			

			System.out.println(" Current Status of accept screen value is = " + ScreenValueforAccept);
			LO.print("Current Status of accept value is = " + ScreenValueforAccept);

		

			boolean CurrentStatusofUndewriting = ScreenValueforAccept.equals("Accepted");

			System.out.println(" Mapping the current Status of Accept in Underwriting page is   = " + CurrentStatusofUndewriting);

			

			boolean flag = false;
			if (CurrentStatusofUndewriting )

			{

				flag = true;
			}

			System.out.println(":::::::::::::::::::::::Accept status is verified on underwriting listing page:::::::::::::::::::::::::::::::::::::::::::::");
			System.out.println(" ");
			System.out.println(" ");
			
			return flag;

		}
		
		
		
		
		
		
		
		
		
		
		
		public void find_decision_decline() throws InterruptedException

		{

			

			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);
		
			ExplicitWait.visibleElement(driver, underw_decision_decline_tab, 30);
			underw_decision_decline_tab.click();
			

		
		
		}
		
		
		
		public boolean verify_current_status_of_underwriting_after_sending_to_decline() throws Exception

		{

			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 30);

		
			ExplicitWait.visibleElement(driver, underw_current_status, 30);

		
		

			String ScreenValueforDecline = underw_current_status.getText();

			

			System.out.println("::::::::::::::::::::::::::::::Current Status for decline  :::::::::::::::::::::::::::::::::::::");

			System.out.println(" ");
			
			

			System.out.println(" Current Status of decline screen value is = " + ScreenValueforDecline);
			LO.print("Current Status of decline value is = " + ScreenValueforDecline);

		

			boolean CurrentStatusofUndewriting = ScreenValueforDecline.equals("Declined");

			System.out.println(" Mapping the current Status of decline in Underwriting page is    = " + CurrentStatusofUndewriting);

			

			boolean flag = false;
			if (CurrentStatusofUndewriting )

			{

				flag = true;
			}

			System.out.println(":::::::::::::::::::::::Declined status is verified on underwriting listing page:::::::::::::::::::::::::::::::::::::::::::");
			System.out.println(" ");
			System.out.println(" ");
			return flag;

		}
		
		

		
		
		
		
		
	}
		
		
		
		
		
		
		
			
		
		
		
		
	
		
		
		
		
		
		

	

	

	

	