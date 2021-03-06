package com.HnM.qe.test.pageobject;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.HnM.qe.framework.common.CommonActionHelper;

public class AEM_SiteHomePagePO extends CommonActionHelper{
	
	
	@FindBy(xpath="//input[@id='username']") 
	public WebElement txtusername;
	
	@FindBy(xpath="//input[@id='password']") 
	public WebElement txtpassword;
	
	@FindBy(xpath="//button[@id='submit-button']") 
	public WebElement btnsubmitbutton;
	
	@FindBy(xpath="//div[text()='Sites']") 
	public WebElement btnSites;
		
	@FindBy(xpath="//div[@title='Academy Sports']") 
	public WebElement btnAcademysports;
	
	@FindBy(xpath="//coral-columnview-column-content/coral-columnview-item[1]/coral-columnview-item-thumbnail/img[@class='foundation-collection-item-thumbnail']") 
	public WebElement imgWebsite;
	
	@FindBy(xpath="//coral-actionbar-primary/coral-actionbar-item[1]/button[@size='M']") 
	public WebElement btncreate;
	
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/coral-actionbar[1]/coral-actionbar-primary[1]/coral-actionbar-item[1]/coral-popover[1]/div[3]/coral-popover-content[1]/coral-anchorlist[1]/a[2]") 
	public WebElement btnpage;
	
	@FindBy(xpath="//coral-masonry[@class='foundation-advancedselect-collection aria-skiphandling foundation-collection foundation-layout-masonry coral-Masonry is-selectable is-loaded']//coral-masonry-item[10]//coral-card[1]//coral-card-asset[1]//img[1]") 
	public WebElement btnHomepageTemplate;
	
	@FindBy(xpath="//coral-button-label[text()='Next']") 
	public WebElement btnNext;
	
	@FindBy(xpath="//input[@name='pageName']") 
	public WebElement txtName;
	
	@FindBy(xpath="//input[@name='./jcr:title']") 
	public WebElement txtTitle;
	
	@FindBy(xpath="//a[text()='Academy']") 
	public WebElement tabAcademy;
	
	@FindBy(xpath="//input[@name='./seoUrl']") 
	public WebElement txtSeourl;
	
	@FindBy(xpath="//input[@name='./seoDescription']") 
	public WebElement txtSeodescription;
	
	@FindBy(xpath="//textarea[@name='./keywords']") 
	public WebElement txtkeywords;
	
	@FindBy(xpath="//coral-button-label[contains(text(),'Create')]") 
	public WebElement btnoncreatepage;
	
	@FindBy(xpath="//coral-button-label[text()='Open']") 
	public WebElement btnopen;
	
	@FindBy(xpath="//coral-button-label[text()='Done']") 
	public WebElement btndone;
	
	
	
	
	public void enterLogindeatils() throws Exception {

		setInputText(txtusername, "ravi.kant3");
		setInputText(txtpassword, "ravi.kant3");
				
	}
	public void enterTitleandtagsndeatils() throws Exception {

		setInputText(txtName, "HomePage");
		setInputText(txtTitle, "Banner");
						
	}
	
	public void enterAcademyndeatils() throws Exception {

		setInputText(txtSeourl, "/shop/browser/Banner");
		setInputText(txtSeodescription, "Posting Banner");
		setInputText(txtkeywords, "Banner,banner");
				
	}
	
	
	

}
