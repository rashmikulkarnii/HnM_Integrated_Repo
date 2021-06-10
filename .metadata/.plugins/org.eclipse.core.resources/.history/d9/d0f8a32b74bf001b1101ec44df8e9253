package com.aso.qe.test.stepdefinition.web;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import com.aso.qe.framework.common.CommonActionHelper;
import com.aso.qe.test.pageobject.FindStorePO;
import com.aso.qe.test.pageobject.GlobalElementHeader_HomePO;

import cucumber.api.java.en.Then;

public class R1SP1_KER_721_Mob_SD<globalElementHeader> extends CommonActionHelper{
	private static final Logger logger = Logger.getLogger(R1SP1_KER_721_Mob_SD.class);
	public FindStorePO findStorePO= PageFactory.initElements(driver, FindStorePO.class);
	public GlobalElementHeader_HomePO globalElementHeader= PageFactory.initElements(driver, GlobalElementHeader_HomePO.class);



	@Then("^User should not be able to see the searchBox$")
	public void User_should_not_be_able_to_see_Searchbox(){
		logger.debug("");
		globalElementHeader.validatingPresenceOfTextSearchBox();

	}

	@Then("^User should be able to see FindStore Navigation Categories and MyAccount links$")
	public void User_should_be_able_to_see_FindStore_Navigation_Categories_and_MyAccount_links() throws Exception {
		globalElementHeader.validatePreseneceOfFindStore();
		globalElementHeader.validatePresenceOfNavigationCategories();
		globalElementHeader.validatePresenceOfMyAccountLink();
	}


	@Then("^Verify user is able to see the search box after clicking on the magnifying glass$")
	public void Verify_user_is_able_to_see_the_search_box_after_clicking_on_the_magnifying_glass() throws Exception{
		globalElementHeader.validatingPresenceOfTextSearchBox();
	}

	@Then ("^User should be able to see open Search text box$")
	public void User_should_be_able_to_see_open_Search_text_box() {
		globalElementHeader.validatingPresenceOfTextSearchBoxHomePage();

	}



}
