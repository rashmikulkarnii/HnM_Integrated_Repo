package com.HnM.qe.test.pageobject;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import com.HnM.qe.framework.common.CommonActionHelper;

public class HnM_Home_PagePO extends CommonActionHelper {
	private static final Logger logger = Logger.getLogger(HnM_Home_PagePO.class);
	
	
	
	@FindBy(xpath="((//a[contains(text(),'Customer Service')])[1]")public WebElement Link_CustomerService;
	@FindBy(xpath="(//a[contains(text(),'Connexion') or contains(text(),'Sign in')])[1]")public WebElement Link_Sign_In;
	@FindBy(xpath="((//button[@id=\"onetrust-accept-btn-handler\" or @id='onetrust-accept-btn-handler']))")public WebElement Btn_Accept_All_Cookies;
	@FindBy(xpath="(//button[contains(text(),'DEVENIR MEMBRE') or contains(text(),'BECOME A MEMBER')])[2]")public WebElement Btn_Become_Member;

	
	public void clickCustomerLink()
	 
	{
		assertTrue(isDisplayed(Link_CustomerService));
		clickOnLink(Link_CustomerService);
	}
	
	public void clickSignInLink(String Exptxt) throws InterruptedException
	 
	{
		assertTrue(isDisplayed(Link_Sign_In));
		String actualSignInTxt = getText(Link_Sign_In);
		logger.debug("actualSignInTxt:: " + actualSignInTxt);
		Assert.assertEquals(actualSignInTxt, Exptxt);
		System.out.println("Exptxt" + Exptxt);
		clickOnLink(Link_Sign_In);
		Thread.sleep(2000);
		
		
		
	}
	
	public void AcceptCookie() throws InterruptedException
	{
		assertTrue(isDisplayed(Btn_Accept_All_Cookies));
		clickOnButton(Btn_Accept_All_Cookies);
		Thread.sleep(2000);
	}
		

	public void ClickBecomeMemberButton() throws InterruptedException
	{
		assertTrue(isDisplayed(Btn_Become_Member));
		clickOnButton(Btn_Become_Member);
		Thread.sleep(2000);
	}
		
		
	
		
	
		
			
	

	
//		public void addressBookDeatils(String exceptedAddressBookTxt) throws Exception {
//			String actualAddressBookTxt = getText(addressBookTxt);
//			logger.debug("addressbookTxt:: " + actualAddressBookTxt);
//			Assert.assertEquals(actualAddressBookTxt, exceptedAddressBookTxt);
//		}
//
//		

//		public void clickMyAccountDropDown() throws Exception {
//
//			assertTrue(clickOnButton(myAccountDropDown));
//
//		}
//		
		
		
//		public void enterInvalidEmailAddressandPassword() throws Exception {
//
//			setInputText(txtEmailAddress, "rashika@gmail.com");
//			setInputText(txtPassword, "rashika@123");
//
//		}


//		
//		
//		public void enterEmailAddress_signup() throws Exception {
//			
//			 UUID uuid = UUID.randomUUID();
//		     String randomUUIDString = uuid.toString();
//		     
//		     String txtemailaddress_random="abc"+randomUUIDString+"@gmail.com";
//
//			setInputText(txtEmail, txtemailaddress_random);
//
//		}
		

//	public void navigateToPLPViaClick_Desktop() throws Exception{
//		
//		assertTrue(clickOnButton(btnShopCategory));
//		Actions hover = new Actions(getDriver());
//		hover.moveToElement(btnClothingCategory).build().perform();
//		//assertTrue(clickOnButton(btnMen_Clothing_Shop));
//		assertTrue(clickOnButton(btnMensShirt_Men_Clothing_Shop));
//	}
//	
	

}
