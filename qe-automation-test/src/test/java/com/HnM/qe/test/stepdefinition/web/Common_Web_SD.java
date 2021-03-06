package com.HnM.qe.test.stepdefinition.web;

import static org.junit.Assert.assertTrue;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.HnM.qe.framework.common.CommonActionHelper;
import com.HnM.qe.test.pageobject.FindStorePO;
import com.HnM.qe.test.pageobject.GlobalElementHeader_HomePO;
import com.HnM.qe.test.pageobject.SearchProductPO;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Common_Web_SD extends CommonActionHelper{
	private static final Logger logger = Logger.getLogger(Common_Web_SD.class);
	public FindStorePO findStorePO;
	public static GlobalElementHeader_HomePO globalElementHeader;
	public static SearchProductPO searchProductPO;
	
	@Given("^User launches the  browser and navigates to Home page$")
	public void user_launches_the_browser_and_navigates_to_Home_page() throws Throwable {
		logger.debug("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&& loading WebDriver");
		initializeDriver();
		homeURL = webPropHelper.getConfigPropProperty("ASO");
		logger.debug("Open Chrome browser with URL::"+homeURL);
		logger.debug("HomeURL:: "+homeURL);
		driver.get(homeURL);
		findStorePO= PageFactory.initElements(driver, FindStorePO.class);
		globalElementHeader= PageFactory.initElements(driver, GlobalElementHeader_HomePO.class);
		searchProductPO = PageFactory.initElements(getDriver(), SearchProductPO.class);
		
	}

	@Given("^user launches the browser and navigates to \"(.*?)\" page$")
	public void user_launches_the_browser_and_navigates_to_page(String url) throws Throwable {
		initializeDriver();
	//	openBaseURL("ASO");
		openBaseURL(url);
		findStorePO= PageFactory.initElements(driver, FindStorePO.class);
		globalElementHeader= PageFactory.initElements(driver, GlobalElementHeader_HomePO.class);
		searchProductPO = PageFactory.initElements(getDriver(), SearchProductPO.class);
	}

	@Then("^User closes the web application$")
	public void user_closes_the_web_application() throws Throwable {
		logger.debug("User closes the application & Browser.............");
		close();
	}








	
}
