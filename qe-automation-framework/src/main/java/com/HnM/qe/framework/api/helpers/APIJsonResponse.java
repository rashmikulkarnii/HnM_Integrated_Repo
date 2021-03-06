package com.HnM.qe.framework.api.helpers;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.HnM.qe.framework.common.Constants;

public class APIJsonResponse {
	private static final Logger logger = Logger.getLogger(APIJsonResponse.class);
	public JSONObject jsonResponseObj;


	public APIJsonResponse() { }
	public APIJsonResponse(String responseStr) {
		try {
			jsonResponseObj = JSONValidationUtils.getJSONObject(responseStr);

		} catch (ParseException e) {
			logger.error("JSON Response Read excetion msg::"+e.getMessage());
			e.printStackTrace();
		}
	}


	public boolean isPropertyValueNull(String name){
		boolean flag = false;
		Constants.API_ERROR_DESCRIPTION="";
		try{
			if(jsonResponseObj.containsKey(name)){
				flag = JSONValidationUtils.isNotNull(jsonResponseObj, name);
			}
		}catch (Exception e) {
			flag = false;
			logger.error(name+" :isPropertyValueNull Exception Msg::"+e.getMessage());
		}
		if(!flag){
			Constants.API_ERROR_DESCRIPTION=name+Constants.API_ERROR_TEXT;
			logger.debug(Constants.API_ERROR_DESCRIPTION);
		}
		return flag;
	}

	public boolean isAutoSuggestionPropertyValueNull(String name){
		boolean flag = false;
		Constants.API_ERROR_DESCRIPTION="";
		try{
			logger.debug("Json Response:: "+jsonResponseObj);
			if(jsonResponseObj.containsKey("typeAheadResults")){
				 JSONArray suggestionArray = (JSONArray) jsonResponseObj.get("typeAheadResults");
		            
		            for (Object productinfoObj : suggestionArray) {
		            	String autoSuggestion = productinfoObj.toString();
		            	logger.debug(name+"::"+autoSuggestion);
		            	if(autoSuggestion != null && autoSuggestion.toLowerCase().contains(name.toLowerCase())){
		            		flag = true;
		            	}else{
		            		flag = false;
		            		break;
		            	}
		            }
			}
		}catch (Exception e) {
			flag = false;
			logger.error(name+" :isPropertyValueNull Exception Msg::"+e.getMessage());
		}
		if(!flag){
			Constants.API_ERROR_DESCRIPTION=Constants.API_AUTOSUGGESTION_ERROR_TEXT+name;
			logger.debug(Constants.API_ERROR_DESCRIPTION);
		}
		return flag;
	}

	
	public boolean isSitecontentPropertyValueNull(String suggestionType, String name){
		boolean flag = false;
		Constants.API_ERROR_DESCRIPTION="";
		try{
			logger.debug("Json Response:: "+jsonResponseObj);
			if(jsonResponseObj.containsKey(suggestionType)){ //"categorysuggestion"
				 JSONArray siteContentArray = (JSONArray) jsonResponseObj.get(suggestionType);
		            
		            for (Object sitecontentObj : siteContentArray) {
		            	JSONObject jsonObj = (JSONObject) sitecontentObj;
		            	flag = JSONValidationUtils.isNotNull(jsonObj, name);
		            }
			}
		}catch (Exception e) {
			flag = false;
			logger.error(name+" :isPropertyValueNull Exception Msg::"+e.getMessage());
		}
		if(!flag){
			Constants.API_ERROR_DESCRIPTION=name+Constants.API_ERROR_TEXT;
			logger.debug(Constants.API_ERROR_DESCRIPTION);
		}
		return flag;
	}
	
	public boolean isContainsSitecontentPropertyValue(String suggestionType, String suggestionText, String name){
		boolean flag = false;
		Constants.API_ERROR_DESCRIPTION="";
		try{
			logger.debug("Json Response:: "+jsonResponseObj);
			if(jsonResponseObj.containsKey(suggestionType)){ //"categorysuggestion"
				 JSONArray siteContentArray = (JSONArray) jsonResponseObj.get(suggestionType);
		            
		            for (Object sitecontentObj : siteContentArray) {
		            	JSONObject jsonObj = (JSONObject) sitecontentObj;
		            	String searchtxt =(String) jsonObj.get(name);
		            	if(searchtxt != null && searchtxt.toLowerCase().contains(suggestionText.toLowerCase())){
		            		flag = true;
		            	}else{
		            		flag = false;
		            		break;
		            	}
		            	
		            }
			}
		}catch (Exception e) {
			flag = false;
			logger.error(name+" :isPropertyValueNull Exception Msg::"+e.getMessage());
		}
		if(!flag){
			Constants.API_ERROR_DESCRIPTION=name+Constants.API_ERROR_TEXT;
			logger.debug(Constants.API_ERROR_DESCRIPTION);
		}
		return flag;
	}
	
	public boolean verifyInventorySpecificationOnline(String name,String rootName){
		boolean flag = false;
		Constants.API_ERROR_DESCRIPTION="";
		try{
			logger.debug("Json Response:: "+jsonResponseObj);
			if(jsonResponseObj.containsKey(rootName)){ //"online"
				 JSONArray onlineArray = (JSONArray) jsonResponseObj.get(rootName);
		            
		            for (Object sitecontentObj : onlineArray) {
		            	JSONObject jsonObj = (JSONObject) sitecontentObj;
		            	flag = JSONValidationUtils.isNotNull(jsonObj, name);
		            }
			}
		}catch (Exception e) {
			flag = false;
			logger.error(name+" :isPropertyValueNull Exception Msg::"+e.getMessage());
		}
		if(!flag){
			Constants.API_ERROR_DESCRIPTION=name+Constants.API_ERROR_TEXT;
			logger.debug(Constants.API_ERROR_DESCRIPTION);
		}
		return flag;
	}
	
	public boolean verifyInventoryStoreOnline(String name,String rootName, String type){
		boolean flag = false;
		Constants.API_ERROR_DESCRIPTION="";
		try{
			logger.debug("Json Response:: "+jsonResponseObj);
			if(jsonResponseObj.containsKey(rootName)){ //"online"
				JSONObject inventoryObj = (JSONObject) jsonResponseObj.get(rootName);
				if(inventoryObj.containsKey(type)){
				 JSONArray storeArray = (JSONArray) inventoryObj.get(type);
		            
		            for (Object sitecontentObj : storeArray) {
		            	JSONObject jsonObj = (JSONObject) sitecontentObj;
		            	flag = JSONValidationUtils.isNotNull(jsonObj, name);
		            }
				}
			}
		}catch (Exception e) {
			flag = false;
			logger.error(name+" :isPropertyValueNull Exception Msg::"+e.getMessage());
		}
		if(!flag){
			Constants.API_ERROR_DESCRIPTION=name+Constants.API_ERROR_TEXT;
			logger.debug(Constants.API_ERROR_DESCRIPTION);
		}
		return flag;
	}
	
	public boolean verifyAddtoCartProp(String name,String rootName){
		boolean flag = false;
		Constants.API_ERROR_DESCRIPTION="";
		try{
			logger.debug("Json Response:: "+jsonResponseObj);
			if(jsonResponseObj.containsKey(rootName)){ //"online"
				JSONObject inventoryObj = (JSONObject) jsonResponseObj.get(rootName);
				if(inventoryObj.containsKey(name)){
		            	flag = JSONValidationUtils.isNotNull(inventoryObj, name);
				}
			}
		}catch (Exception e) {
			flag = false;
			logger.error(name+" :isPropertyValueNull Exception Msg::"+e.getMessage());
		}
		if(!flag){
			Constants.API_ERROR_DESCRIPTION=name+Constants.API_ERROR_TEXT;
			logger.debug(Constants.API_ERROR_DESCRIPTION);
		}
		return flag;
	}
}
