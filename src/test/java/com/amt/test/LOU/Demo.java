package com.amt.test.LOU;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.amt.testUtil.RemoveComma;

public class Demo {
	
	public static void main(String[] args) {
		
		
		//cd C:\Program Files\Google\Chrome\Application
		//chrome.exe --remote-debugging-port=9222
		
//		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
//		
//        ChromeOptions options = new ChromeOptions();
//       
//        options.setExperimentalOption("debuggerAddress", "localhost:3389");
//
//        // Create a new instance of ChromeDriver and connect to the existing session
//        WebDriver driver = new ChromeDriver(options);
//
//        // Perform actions on the browser as needed
//        
//        WebElement underwriting_quote_tab_configuration_configuration_default_broker_margin =  driver.findElement(By.xpath("//input[@id='defaultBrokerMargin']"));
//        
//    	double default_broker_margin_copied = Double.parseDouble(RemoveComma.of(underwriting_quote_tab_configuration_configuration_default_broker_margin.getAttribute("value")));
//
//        System.out.println("Text for input field "+default_broker_margin_copied);
//        // Close the browser when finished
//        driver.quit();
		
        // ANSI escape code for green color
        String ansiGreen = "\u001B[32m";
        
        // ANSI escape code to reset the console color
        String ansiReset = "\u001B[0m";
		
		System.out.println("");
		System.out.println(ansiGreen+"All values on underwriting quote tab verified successfully"+ansiReset);
		System.out.println("All values on underwriting quote tab verified successfully");
		System.out.println("");
		
	}

}
