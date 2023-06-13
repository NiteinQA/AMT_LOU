package com.amt.pages;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amt.testBase.TestBase;
import com.amt.testUtil.Click;
import com.amt.testUtil.ExplicitWait;

import net.bytebuddy.agent.builder.AgentBuilder.RedefinitionStrategy.DiscoveryStrategy.Explicit;

public class AcquisitionListingPage extends TestBase {

	
	

		@FindBy(xpath = "/html[1]/body[1]/app-root[1]/div[1]/div[2]/div[2]/div[1]/app-aquisition-list[1]/div[2]/div[1]/div[1]/div[1]/div[2]/ag-grid-angular[1]/div[1]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/span[1]")
		private WebElement aquisition_quotes_Listinglink;
		
		@FindBy(linkText = "Acquisition quotes")
		private WebElement aquisition_quotes_button;
		
		@FindBy(xpath = "//img[@alt='Loading...']")
		private List<WebElement> loading_icon;	

		
		@FindBy(xpath = "//span[normalize-space()='New quote']")
		private WebElement new_quote_button;
		
			
				
		public AcquisitionListingPage() {
			PageFactory.initElements(driver, this);
		}		
		
		
		public void aquisition_Listingpage_AddnewQuote() throws InterruptedException {
			
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 20);

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(50));
		    
			// Thread.sleep(5000);			
				
			//Click.on(driver, aquisition_quotes_button, 50);
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			
			ExplicitWait.clickableElement(driver, aquisition_quotes_button, 30);

			jse.executeScript("arguments[0].click();", aquisition_quotes_button);

			
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 20);
			
			ExplicitWait.clickableElement(driver, new_quote_button, 30);

			jse.executeScript("arguments[0].click();", new_quote_button);
		
			ExplicitWait.waitTillLoadingIconDisappears(driver, loading_icon, 20);
			
			 
				
			LO.print("Clicked on Quote button ");
			System.out.println("Clicked on Quote button ");
		}
		



}
