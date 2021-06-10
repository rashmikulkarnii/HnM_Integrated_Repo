package com.aso.qe.test.stepdefinition.android;


import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aso.qe.framework.android.helpers.utils.AndroidCommonMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class AndroidHomePageStepdefinition {
	private static final Logger logger = Logger.getLogger(AndroidHomePageStepdefinition.class);
	AndroidCommonMethods commonMethods = new AndroidCommonMethods();
	WebDriverWait wait;

	@Given("^User launches the android mobile \"(.*?)\" and navigates to page \"(.*?)\"$")
	public void user_navigates_to_HomePage(String browserType, String url) throws Throwable {
		logger.info("user_navigates_to_HomePage");
		commonMethods.launchMobileBrowserAndOpenURL(browserType, url);   
	}

	@When("^user clicks in text box \"(.*?)\"$")
	public void user_clicks_in_text_box (String object) throws Throwable {
		commonMethods.click(object);
		
	}

	@Then("^user enters in \"([^\"]*)\" with product \"(.*?)\"$")
	public void user_enters_in_with_product(String object, String value) throws Throwable {
		System.out.println(object);
		commonMethods.sendkeys(object, value);
	}

	@Then("^user clicks on button \"(.*?)\"$")
	public void user_clicks_on_button (String object)throws Throwable 
	{
		commonMethods.click(object);
	}


	@When("^user clicks on the \"(.*?)\"$")
	public void user_clicks_on_the(String btnBurgerMenu) throws Throwable{

		System.out.println("Burger menu is displayed and clicked"+ btnBurgerMenu);
		commonMethods.click(btnBurgerMenu);
	}


	@Then("^user clicks on product \"(.*?)\"$")
	public void user_clicks_on_product(String object) throws Throwable{ 
		commonMethods.click(object);
	}

}
