Feature: To Verify the AEM Banner 

@Regression @Web 
  Scenario: To Create Banner in AEM HomePage
  	 Given user launches the browser and navigates to "AEM" page
  	 When user enter the login credentials
  	 And user click on Sites
  	 And user click on Academy sports
  	 And user click on Website Pages image
  	 And user click on create icon
  	 And user click on Page icon
  	 And user click on Home Page Template image
  	 And click on Next button
  	 When user enter details in Title and Tags tab
  	 And click on ACADEMY tab
  	 When user enter details in Academy tab
  	 And user click on create button
  	 And user click on open button in popup
  	 When user switch to AppHomePage window
  	 And user click on Global Bar Edit button
  	# And user click on railLeft icon
  	 And user double click on Drag component
  	 When user search New component
  	 And user click on search component
  	 And user click on click here to edit banner button
  	 And user click on Configure icon
  	 When user enter details in banner popup and click on save button
  	   
  	 
  	   		