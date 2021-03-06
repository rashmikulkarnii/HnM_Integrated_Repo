package com.HnM.qe.test.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.HnM.qe.framework.common.CommonActionHelper;

public class PLP_PO extends CommonActionHelper{
	//private   final Logger logger = Logger.getLogger(PLP_PO.class);

	@FindBy(xpath="//div[@data-auid='sort_by']//span[text()='Best Selling']")
	public   WebElement drpdwnSortBy;
	
	@FindBy(xpath="//div[@data-auid='sort_by']//span[text()='Most Relevant']")
	public   WebElement searchdrpdwnSortBy;

	@FindBy(xpath="//div[@data-auid='product-sort-dropdown']//span[text()='Best Selling']|//span[text()='Best Selling']")
	public   WebElement drpdwnSortByMobile;

	@FindBy(xpath="//div[@data-auid='sort_by_M']")
	public   WebElement drpdwnSortByScrollMobile;

	@FindBy(xpath="//div[@class='Select-menu-outer']//div[@aria-label='SORT_OPTIONS") 
	public   WebElement optnSortBy;

	@FindBy(xpath="//div[@data-auid='facetdrawer_drawer_Related Categories']") 
	public   WebElement lnkRelatedCategories;

	@FindBy(xpath="//div[@data-auid='facetdrawer_drawer_Related Categories_m']") //danush 19/july
	public   WebElement lnkRelatedCategories_Mobile;


	@FindBy(xpath="//li[@data-auid=\"drawer_Men's Gloves\"]/a")
	public   WebElement lnkCategories_RelatedCategories;
    
	@FindBy(xpath="(//div[@data-auid='facetdrawer_drawer_Related Categories_m']//a)[2]") //danush 19/july
	public   WebElement lnkCategories_RelatedCategories_Mobile;

	@FindBy(xpath="//div[contains(@data-component,'sectionTitle')]") 
	public   WebElement txtSectionTitle;

	@FindBy(xpath="//div[@data-auid='shopbycategorysection']//div[@data-auid='shopByCategory_1']") 
	public WebElement secCategory_CLP;


	//@FindBy(xpath="(//div[contains(@data-auid,'productCard_')]//img)[1]") 
	@FindBy(xpath="(//button[contains(@data-auid,'productCard_')]/following::div)[1]") 
	public   WebElement productPLP1;

	@FindBy(xpath="(//a[contains(@data-auid,'productCard_')])[1]") 
	public   WebElement productPLP1_Mobile;

	public PLP_PO(WebDriver webDriver) {
		super();
	}
}
