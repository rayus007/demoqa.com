package com.project.pom;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;

public class TextBoxTests {
	WebDriver driver;
	ElementesPage elementsPage;
	String url = "https://demoqa.com";

	@Before
	public void setUp() throws Exception {
		elementsPage = new ElementesPage(driver);
		driver = elementsPage.chromeDriverConnection();
		System.out.println(driver);
		elementsPage.goTo(url);
	}


	@Test
	public void fillAndSubmitForm() throws InterruptedException {
		String username = "Rayus";
		String email = "007@007.com";
		String currentAddress = "Santo Domingo";
		String permanentAddress = "Barrio Manaco";
		
		elementsPage.TextBoxFillSendForm();
		//System.out.println(elementsPage.getText(elementsPage.elements_text_box_output_locator));
		assertEquals(elementsPage.getText(elementsPage.elements_text_box_output_name_locator), "Name:"+username+email);
		assertEquals(elementsPage.getText(elementsPage.elements_text_box_output_email_locator), "Email:"+email);
		assertEquals(elementsPage.getText(elementsPage.elements_text_box_output_current_address_locator), "Current Address :"+currentAddress);
		assertEquals(elementsPage.getText(elementsPage.elements_text_box_output_permanent_address_locator), "Permananet Address :"+permanentAddress);
		//fail("Not yet implemented");
	}
	
	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}
	
	@Rule
	public TestRule watcher = new TestWatcher() {
		@Override
		public void failed(Throwable throwable, Description description) {
			System.out.println("Test4");
			System.out.println(driver);
			File screenshotfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(screenshotfile, new File("Error_"+description.getMethodName()+".png"));
			}
			catch(Exception e){
				e.printStackTrace();
				
			}
		}
		
		@Override
		protected void finished(Description description) {
			driver.quit();
		}
	};
	
}
