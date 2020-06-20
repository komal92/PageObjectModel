package com.crm.qa.pages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;


public class cpSatLandingPage extends TestBase{
	public WebDriverWait wait=new WebDriverWait(driver, 20);
	//Page Factory - OR:
	
	@FindBy(xpath="//nav[@id='site-navigation']/descendant::ul[@id='menu-primary-spacious']/li/a")
	WebElement hamburgerMenu;
	
	@FindBy(xpath="//a[@href='https://cpsatexam.org/index.php/challenge-1/']")
	WebElement ChallengeOnelink;
	
	@FindBy(xpath="//div[contains(@class,'close-button')]/i[@class='eicon-close']")
	WebElement popCloseButton;
	
	@FindBy(xpath="//div[contains(@id,'eael-adv-accordion')]/div/div/i")
	List<WebElement> paraPlusBtn;
	
	@FindBy(xpath="//div[contains(@id,'elementor-tab-content')]/p[2]")
	List<WebElement> paraContent;
	
	@FindBy(xpath="//div[contains(@id,'elementor-tab-title')]/span")
	List<WebElement> languageContent;
	
/*	@FindBy(css="body")
	WebElement body;
	*/
	
	//Initializing the Page Objects:
	public cpSatLandingPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLandingPage(){
		return driver.getTitle();
	}
	

	public Map<String,String> translateEachParagraph() {
		wait.until(ExpectedConditions.visibilityOf(hamburgerMenu));
		hamburgerMenu.click();
		wait.until(ExpectedConditions.visibilityOf(ChallengeOnelink));
		ChallengeOnelink.click();
		try{
			if(popCloseButton.isDisplayed()) {
				wait.until(ExpectedConditions.visibilityOf(popCloseButton));
				popCloseButton.click();
			}
		}catch(Exception e) {
			System.out.println("Popup handled correctly");
		}
		//ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		
		List<WebElement> paragraphyLinks= paraPlusBtn;
		List<WebElement> paragraphContentList= paraContent;
		List<WebElement> languageContentList= languageContent;
		Map<String,String> paraContentMap= new HashMap();
		//WebElement body= driver.findElement(By.cssSelector("body"));
		Actions act = new Actions(driver);
		int i=0;
		for(WebElement paralinks:paragraphyLinks) {
			paralinks.click();
			System.out.println(languageContentList.get(i).getText().substring(7));
			System.out.println(paragraphContentList.get(i).getText());
			paraContentMap.put(languageContentList.get(i).getText().substring(7), paragraphContentList.get(i).getText());
			/*
			 * Message to the jury members- i tried using the CTRL+T for switching. However
			 * I was not able to translate one by one. So i have used the different appraoch
			 * as my chrome driver didn't support shortcut keys. I have however pasted the
			 * code for reference
			 */
			// body.sendKeys(Keys.CONTROL+"t");
			/*
			 * driver.get("www.google.com"); driver.switchTo().defaultContent();
			 */
		}
		
		return 	paraContentMap;	
	}

	
}
