package com.project.pom;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementesPage extends BaseAutomation{

	public ElementesPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//ELEMENTS MENU
	By elements_locator = By.xpath("//h5[contains(.,'Elements')]");
	By elements_title_locator = By.className("header-text");
	
	//TEXT BOX
	By elements_text_box_menu_locator = By.xpath("//span[contains(.,'Text Box')]");
	By elements_text_box_FullName_tb_locator = By.id("userName");
	By elements_text_box_UserEmail_tb_locator = By.id("userEmail");
	By elements_text_box_current_address_locator = By.id("currentAddress");
	By elements_text_box_permanent_address_locator = By.id("permanentAddress");
	By elements_text_box_submit_button_locator = By.id("submit");
	By elements_text_box_output_locator = By.id("output");
	By elements_text_box_output_name_locator = By.xpath("//div[@id='output']/div/p[1]");
	By elements_text_box_output_email_locator = By.xpath("//div[@id='output']/div/p[2]");
	By elements_text_box_output_current_address_locator = By.xpath("//div[@id='output']/div/p[3]");
	By elements_text_box_output_permanent_address_locator = By.xpath("//div[@id='output']/div/p[4]");
	
	//CHECK BOX
	By elements_check_box_menu_locator = By.xpath("//span[contains(.,'Check Box')]");
	By elements_check_box_home_locator = By.xpath("//span[text()='Home']");
	
	By elements_check_box_results = By.className("text-success");
	

	//@SuppressWarnings("deprecation")
	public void TextBoxFillSendForm() throws InterruptedException {
		String username = "Rayus";
		String email = "007@007.com";
		String currentAddress = "Santo Domingo";
		String permanentAddress = "Barrio Manaco";
		click(elements_locator);
		Thread.sleep(2000);
		//driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		if(isDisplayed(elements_check_box_menu_locator)) {
			click(elements_text_box_menu_locator);
			typeText(username, elements_text_box_FullName_tb_locator);
			typeText(email, elements_text_box_UserEmail_tb_locator);
			typeText(currentAddress, elements_text_box_current_address_locator);
			typeText(permanentAddress, elements_text_box_permanent_address_locator);
			click(elements_text_box_submit_button_locator);
			//Thread.sleep(1000);
			
		}
		
		else {
			System.out.println("Page not found");
		}
	}
	
	public void CheckBoxSelection() throws InterruptedException {
		click(elements_locator);
		Thread.sleep(2000);
		if (isDisplayed(elements_title_locator)){
			click(elements_check_box_menu_locator);
			click(elements_check_box_home_locator);
			
		}
		else {
			System.out.println("Page not found");
		}
	}
	

}
