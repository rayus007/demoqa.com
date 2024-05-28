package com.project.pom;

import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

class checkBoxTest {
	
	private WebDriver driver;
	ElementesPage elementsPage;
	String url = "https://demoqa.com";

	@Before
	public void setUp() throws Exception {
		elementsPage = new ElementesPage(driver);
		driver = elementsPage.chromeDriverConnection();
		elementsPage.goTo(url);
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		elementsPage.CheckBoxSelection();
		List<WebElement> results = elementsPage.findElements(elementsPage.elements_check_box_results);
		System.out.println(elementsPage.getText(results.get(0)));
		assertEquals(elementsPage.getText(results.get(0)),"home");
	}

}
