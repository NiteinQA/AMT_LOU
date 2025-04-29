package com.amt.testUtil;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.awt.Robot;

import java.awt.datatransfer.StringSelection;


import org.openqa.selenium.WebElement;

import com.amt.testBase.TestBase;

public class CommonClass extends TestBase {
	
	
//	public static void main(String args[]) throws IOException
//	{
//		CommonClass cs = new CommonClass();
//		
//		cs.get_the_default_broker_margin_value_from_excel_based_on_configurations_for_hire_contract_types(76, "Default Broker Margin Values");
//		
//	//	cs.get_the_default_broker_margin_value_from_excel_based_on_configurations_for_purchase_contract_types(12, "A1 Credit", "Default Broker Margin Values");
//	}
	
	
	public double get_the_default_broker_margin_value_from_excel_based_on_configurations_for_hire_contract_types(double terms , String sheet_name) throws IOException
	{
       return  get_broker_margin(0  , terms, sheet_name); 		
	}
	
	
	
	public double get_the_default_broker_margin_value_from_excel_based_on_configurations_for_purchase_contract_types(double terms , String credit_type , String sheet_name) throws IOException
	{

		double broker_margin = 0 ;
	
		
		if(credit_type.equals(GetExcelFormulaValue.get_string_cell_value(10, 0, sheet_name)))
		{
			
			broker_margin = get_broker_margin(10 , terms, sheet_name);
		}
		
		if(credit_type.equals(GetExcelFormulaValue.get_string_cell_value(18, 0, sheet_name)))
		{
			
			broker_margin =  get_broker_margin(18 , terms, sheet_name);
		}
		
		if(credit_type.equals(GetExcelFormulaValue.get_string_cell_value(26, 0, sheet_name)))
		{
			
			broker_margin = get_broker_margin(26 , terms, sheet_name);
		}
	
		System.out.println(broker_margin);
		
        return broker_margin;   
				
	}


	public double get_broker_margin( int rowNum , double terms, String sheet_name) throws IOException {
		//min 1 and max 1
		
	
				
        double min1 =  GetExcelFormulaValue.get_formula_value((rowNum+2), 0, sheet_name);
        double max1 =  GetExcelFormulaValue.get_formula_value((rowNum+2), 1,sheet_name);
        
		//min 2 and max 2
        double min2 =  GetExcelFormulaValue.get_formula_value((rowNum+3), 0, sheet_name);
        double max2 =  GetExcelFormulaValue.get_formula_value((rowNum+3), 1, sheet_name);
        
		//min 3 and max 3
        double min3 =  GetExcelFormulaValue.get_formula_value((rowNum+4), 0, sheet_name);
        double max3 =  GetExcelFormulaValue.get_formula_value((rowNum+4), 1, sheet_name);
        
		//min 4 and max 4
        double min4 =  GetExcelFormulaValue.get_formula_value((rowNum+5), 0, sheet_name);
        double max4 =  GetExcelFormulaValue.get_formula_value((rowNum+5), 1, sheet_name);        
        
       
        
        double[][]ranges = {{min1, max1}, {min2, max2}, {min3, max3}, {min4, max4}};
        
        double minimum = 0;
        double maximum = 0;
        
        int count=0;
        int whichRange =0 ;
        
        for (int i = 0; i < ranges.length; i++) {
        	
        	count++;
        	
            if (terms >= ranges[i][0] && terms <= ranges[i][1])
            {

            	whichRange=count;
            	
            	System.out.println(whichRange);
            	
            	break;
            	
            }
        }
        
        double broker_margin = 0 ;
        
        if(whichRange==1) { broker_margin = GetExcelFormulaValue.get_formula_value((rowNum+2), 2, sheet_name);}
        if(whichRange==2) { broker_margin = GetExcelFormulaValue.get_formula_value((rowNum+3), 2, sheet_name);}
        if(whichRange==3) { broker_margin = GetExcelFormulaValue.get_formula_value((rowNum+4), 2, sheet_name);}
        if(whichRange==4) { broker_margin = GetExcelFormulaValue.get_formula_value((rowNum+5), 2, sheet_name);}
        
        System.out.println(broker_margin);
        
		return broker_margin;
	}

	public double[] get_doc_fee_and_commission_for_hire(String sheet_name) throws IOException
	{
		double docFee =  GetExcelFormulaValue.get_formula_value(1, 0, sheet_name);
		 
		double docFeeCommission = GetExcelFormulaValue.get_formula_value(1, 1, sheet_name);	
		
		
		double [] values = {docFee , docFeeCommission};
		
		return values ;
		
	}
	
	public double[] get_doc_fee_and_commission_for_purchase(String sheet_name) throws IOException
	{
		double docFee =  GetExcelFormulaValue.get_formula_value(4, 0, sheet_name);
		 
		double docFeeCommission = GetExcelFormulaValue.get_formula_value(4, 1, sheet_name);	 
		 
		double [] values = {docFee , docFeeCommission};
		
		return values;
	}
	
	public void upload_file(WebElement e, String filepath) throws AWTException, InterruptedException {


		
	     Thread.sleep(10000);

		Robot rb = new Robot();//
		// copying File path to Clipboard

		StringSelection str = new StringSelection(filepath);

		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		// press Contol+V for pasting
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		
		Thread.sleep(2000);

		// release Contol+V for pasting
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		
		Thread.sleep(2000);

		// for pressing and releasing Enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		Thread.sleep(3000);

		System.out.println("File is Uploaded Successfully");
		LO.print("File is Uploaded Successfully");

	}



}
