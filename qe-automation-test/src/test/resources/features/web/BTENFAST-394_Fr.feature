Feature: [UI]- To Verify H&M Header Links on French Page

  @H&MRegression @Header @sanity @BTENFAST-394_Fr @BTENFAST-TC-20
  Scenario Outline:  To Verify the Header link functionality
      Given user launches the browser and navigates to "H&M_HOME_French" page
      Then User clicks on Accept All Cookies
      Then User hovers on "<SignIn>" link
      
      Examples: 
      
       |SignIn|
       |Connexion|
	
      
      
  @H&MRegression @sanity @BTENFAST-394_Fr  @BTENFAST-TC-20
 Scenario Outline:  To Verify that the user is able to create H&M Account
       
      Given user launches the browser and navigates to "H&M_HOME_French" page
      Then User clicks on Accept All Cookies
       Then User hovers on "<SignIn>" link
       And User clicks on Become A Member Button

 Examples: 
      
       |SignIn|
       |Connexion|
	