package com.HnM.qe.test.stepdefinition.web;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.support.PageFactory;
import org.apache.log4j.Logger;
import com.HnM.qe.framework.common.CommonActionHelper;
import com.HnM.qe.test.pageobject.GlobalElementHeader_HomePO;
import com.HnM.qe.test.pageobject.HnM_Home_PagePO;
import com.HnM.qe.test.pageobject.SearchProductPO;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HnM_Home_Page extends CommonActionHelper{
	private static final Logger logger = Logger.getLogger(HnM_Home_Page.class);
	HnM_Home_PagePO HomePageElement = PageFactory.initElements(driver, HnM_Home_PagePO.class);

	
@Then("^User clicks on Customer Service Link$")
public void user_clicks_on_Customer_Service_Link() throws Throwable {
	
	HomePageElement.clickCustomerLink();
   
}
@Then("^User sees the presence and clicks on Customer Link$")
public void user_sees_the_presence_and_clicks_on_Customer_Link() throws Throwable {
   
	HomePageElement.clickCustomerLink();
}


//@Then("^User hovers on Sign In link$")
//public void user_hovers_on_Sign_In_link() throws Throwable {
//	HomePageElement.clickSignInLink();
//}

@Then("^User clicks on Accept All Cookies$")
public void user_clicks_on_Accept_All_Cookies() throws Throwable {
	HomePageElement.AcceptCookie();
}

@Then("^User clicks on Become A Member Button$")
public void user_clicks_on_Become_A_Member_Button() throws Throwable {
	HomePageElement.ClickBecomeMemberButton();  
}


@Then("^User hovers on \"(.*?)\" link$")
public void user_hovers_on_link(String expText) throws Throwable {
	HomePageElement.clickSignInLink(expText);
}
	
}

