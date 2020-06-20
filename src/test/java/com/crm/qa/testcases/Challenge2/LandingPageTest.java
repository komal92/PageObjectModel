package com.crm.qa.testcases.Challenge2;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.cpSatLandingPage;

public class LandingPageTest extends TestBase{
	cpSatLandingPage landingPage;
	
	public LandingPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		landingPage = new cpSatLandingPage();	
	}
	
	@Test(priority=1)
	public void landingPageTest() {
		String title = landingPage.validateLandingPage();
		Assert.assertTrue(title.equals("#CTHackATAhon – Continuous Testing HackATAhon"));
		Map<String,String> languagePair= landingPage.translateEachParagraph();
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	

}
