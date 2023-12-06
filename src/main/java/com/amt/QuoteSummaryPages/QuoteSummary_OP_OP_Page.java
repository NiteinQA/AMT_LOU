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
import com.amt.testUtil.Difference;
import com.amt.testUtil.ExplicitWait;
import com.amt.testUtil.GetExcelFormulaValue;
import com.amt.testUtil.ReadExcelCalculation;
import com.amt.testUtil.ReadExcelCalculationForPurchaseAgreement;
import com.amt.testUtil.RemoveComma;

public class QuoteSummary_OP_OP_Page extends TestBase {

	ReadExcelCalculation obj_read_excel_calculation_page;

	@FindBy(xpath = "//img[@alt='Loading...']")
	private List<WebElement> loading_icon;

	@FindBy(xpath = "//p[normalize-space()='Quote summary']")
	private WebElement quote_summary;

	@FindBy(xpath = "//*[normalize-space()='Quote reference no.:']//ancestor::div[1]//span[2]")
	private WebElement quote_summary_ref_no;

	@FindBy(xpath = "//*[text()='Vehicle sales price']//ancestor::div[1]//div//p//strong")
	private WebElement vehicle_sales_price;

	@FindBy(xpath = "//*[normalize-space()='Cost price ex. VAT & RFL']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_cost_price_ex_vat_and_rfl;

	@FindBy(xpath = "//*[normalize-space()='VAT']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_otr_vat;

	@FindBy(xpath = "//*[normalize-space()='RFL & FRF']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_otr_rfl_and_frf;
	
	@FindBy(xpath = "//*[normalize-space()='Cost OTR price']//ancestor::div[1]//div//strong")
	private WebElement quote_summary_cost_otr_price;


	@FindBy(xpath = "//*[text()=' Save']")
	private WebElement quote_summary_save_button;

	
	Properties prop;
	
	public QuoteSummary_OP_OP_Page() {

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
	
public void write_vehicle_sales_price_to_excel(String sheet_name) throws InterruptedException, IOException {
					
		
		
	    LO.print          ("Writing Vehicle Sales Price to Excel");	    
		System.out.println("Writing Vehicle Sales Price to Excel");

		
		Click.on(driver, quote_summary, 90);		
		//First collect OTR elements		
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 120);


		//save the record
		
		Click.on(driver, quote_summary_save_button, 20);
		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 300);
		
		// quote no.
	    String quote_ref_no = quote_summary_ref_no.getText();

		String vehicleSalesPrice = RemoveComma.of(vehicle_sales_price.getText().trim().substring(2));	
		
	    LO.print          ("Vehicle Sales Price from screen is "+vehicleSalesPrice);	    
		System.out.println("Vehicle Sales Price from screen is "+vehicleSalesPrice);



		FileInputStream in = new FileInputStream(prop.getProperty("quote_save_excel_path"));
		XSSFWorkbook wb = new XSSFWorkbook(in);

		String sheetname = prop.getProperty(sheet_name);
	   //quote ref no 
		
		wb.getSheet(sheetname).getRow(1).getCell(0).setCellValue(quote_ref_no);    //quote ref no 
		wb.getSheet(sheetname).getRow(1).getCell(1).setCellValue(vehicleSalesPrice);    //quote ref no 
			
		FileOutputStream out = new FileOutputStream(prop.getProperty("quote_save_excel_path"));
		wb.write(out);
		wb.close();
		
		
		LO.print("Writing completed for Vehicle Sales Price to quote save excel sheet in the sheet "+sheetname);
		System.out.println("Writing completed for Vehicle Sales Price to quote save excel sheet in the sheet "+sheetname);

}

	
	public boolean quote_summary_OTR_calculation_for_used_car() throws InterruptedException, IOException {

		LO.print("*************OTR Calulation on quote summary page has been started************");
		System.out.println("*************OTR Calulation on quote summary page has been started************");

		obj_read_excel_calculation_page = new ReadExcelCalculation();

		Thread.sleep(2000);

		Click.on(driver, quote_summary, 60);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 150);

		ExplicitWait.visibleElement(driver, quote_summary_cost_otr_price, 120);

		ExplicitWait.visibleElement(driver, quote_summary_cost_price_ex_vat_and_rfl, 120);

		ExplicitWait.visibleElement(driver, quote_summary_otr_vat, 120);
		
		 

		LO.print("Reading values from OTR calculation -Quote Summary Page");
		System.out.println("Reading values from OTR calculation -Quote Summary Page");

		double cost_otr_price = Double
				.parseDouble(RemoveComma.of(quote_summary_cost_otr_price.getText().trim().substring(2)));

		double cost_price_ex_vat_and_rfl = Double
				.parseDouble(RemoveComma.of(quote_summary_cost_price_ex_vat_and_rfl.getText().trim().substring(2)));

		double vat = Double
				.parseDouble(RemoveComma.of(quote_summary_otr_vat.getText().trim().substring(2)));

		 

		LO.print("Cost otr price from screen =" + cost_otr_price);
		System.out.println("Cost otr price from screen =" + cost_otr_price);

		LO.print("Cost price ex vat and rfl from screen ="+ cost_price_ex_vat_and_rfl);
		System.out.println("Cost price ex vat and rfl from screen ="+ cost_price_ex_vat_and_rfl);

		LO.print("OTR vat from screen =" + vat);
		System.out.println("OTR vat from screen =" + vat);
		
	 

		double cost_price_ex_vat_and_rfl_expected = (cost_otr_price
				- vat);

		double diff = Difference.of_two_Double_Values(cost_price_ex_vat_and_rfl,
				cost_price_ex_vat_and_rfl_expected);

		int count = 0;
		boolean status = false;
		if (diff < 0.2) {
			LO.print("Cost price compared");
			System.out.println("Cost price compared");
			count++;
		} else {
			LO.print("Cost price found wrong");
			System.out.println("Cost price found wrong");
		}

		if (count == 1) {
			status = true;
		}
		
		ExplicitWait.visibleElement(driver, quote_summary_save_button, 30);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", quote_summary_save_button);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 150);
		
		ExplicitWait.visibleElement(driver, quote_summary_ref_no, 120);
		
		String quote_ref_no = quote_summary_ref_no.getText();		
	
		LO.print("Quote no. "+quote_ref_no+" generated successfully after saving the quote ");
		System.out.println("Quote no. "+quote_ref_no+" generated successfully after saving the quote ");

		return status;

	}


	public boolean quote_summary_OTR_calculation(String sheet_name) throws InterruptedException, IOException {

		LO.print("*************OTR Calulation on quote summary page has been started************");
		System.out.println("*************OTR Calulation on quote summary page has been started************");

		obj_read_excel_calculation_page = new ReadExcelCalculation();

		Thread.sleep(2000);

		Click.on(driver, quote_summary, 60);

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		ExplicitWait.visibleElement(driver, quote_summary_cost_otr_price, 120);

		ExplicitWait.visibleElement(driver, quote_summary_cost_price_ex_vat_and_rfl, 120);

		ExplicitWait.visibleElement(driver, quote_summary_otr_vat, 120);
		
		ExplicitWait.visibleElement(driver, quote_summary_otr_rfl_and_frf, 120);
		
		

		LO.print("Reading values from OTR calculation -Quote Summary Page");
		System.out.println("Reading values from OTR calculation -Quote Summary Page");

		double OTR_calculation_cost_otr_price_from_screen_converted = Double
				.parseDouble(RemoveComma.of(quote_summary_cost_otr_price.getText().trim().substring(2)));

		double OTR_calculation_cost_price_ex_vat_and_rfl_from_screen_converted = Double
				.parseDouble(RemoveComma.of(quote_summary_cost_price_ex_vat_and_rfl.getText().trim().substring(2)));

		double OTR_calculation_otr_vat_from_screen_converted = Double
				.parseDouble(RemoveComma.of(quote_summary_otr_vat.getText().trim().substring(2)));
		
		double OTR_calculation_otr_rfl_and_frf_from_screen_converted = Double
				.parseDouble(RemoveComma.of(quote_summary_otr_rfl_and_frf.getText().trim().substring(2)));


		LO.print("Cost otr price from screen =" + OTR_calculation_cost_otr_price_from_screen_converted);
		System.out.println("Cost otr price from screen =" + OTR_calculation_cost_otr_price_from_screen_converted);

		LO.print("Cost price ex vat and rfl from screen ="+ OTR_calculation_cost_price_ex_vat_and_rfl_from_screen_converted);
		System.out.println("Cost price ex vat and rfl from screen ="+ OTR_calculation_cost_price_ex_vat_and_rfl_from_screen_converted);

		LO.print("OTR vat from screen =" + OTR_calculation_otr_vat_from_screen_converted);
		System.out.println("OTR vat from screen =" + OTR_calculation_otr_vat_from_screen_converted);


		double OTR_calculation_cost_price_ex_vat_and_rfl_expected = (OTR_calculation_cost_otr_price_from_screen_converted
				- OTR_calculation_otr_vat_from_screen_converted-OTR_calculation_otr_rfl_and_frf_from_screen_converted);

		double diff = Difference.of_two_Double_Values(OTR_calculation_cost_price_ex_vat_and_rfl_from_screen_converted,
				OTR_calculation_cost_price_ex_vat_and_rfl_expected);

		int count = 0;
		boolean status = false;
		if (diff < 0.2) {
			LO.print("Cost price compared");
			System.out.println("Cost price compared");
			count++;
		} else {
			LO.print("Cost price found wrong");
			System.out.println("Cost price found wrong");
		}

		if (count == 1) {
			status = true;
		}

		return status;

	}

	

public void save_quote() throws InterruptedException {

		ExplicitWait.visibleElement(driver, quote_summary_save_button, 30);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", quote_summary_save_button);
		

		ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 200);

		ExplicitWait.visibleElement(driver, quote_summary_ref_no, 120);

		String quote_ref_no = quote_summary_ref_no.getText();

		LO.print("*********Customer Quote generated successfully and Quote_ref_no is=" + quote_ref_no);
		System.out.println("*********Customer Quote generated successfully and Quote_ref_no is=" + quote_ref_no);

	}



}
