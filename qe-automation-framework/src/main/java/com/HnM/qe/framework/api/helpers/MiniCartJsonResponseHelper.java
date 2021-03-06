package com.HnM.qe.framework.api.helpers;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import com.HnM.qe.framework.common.Constants;

public class MiniCartJsonResponseHelper {
	private static final Logger logger = Logger.getLogger(MiniCartJsonResponseHelper.class);
	private JSONObject minicartRespRoot;

	public MiniCartJsonResponseHelper() {}

	public MiniCartJsonResponseHelper(String responseStr){

		try {
			minicartRespRoot = JSONValidationUtils.getJSONObject(responseStr);

		} catch (ParseException e) {
			logger.error("MiniCartJsonResponseHelper ParseException msg::"+e.getMessage());
		}
	}



	public boolean isMiniCartPropertyValueNull(String name){
		boolean flag = false;
		Constants.API_ERROR_DESCRIPTION="";
		try{
			if(minicartRespRoot.containsKey(name)){
				if (JSONValidationUtils.isNotNull(minicartRespRoot, name)){
					flag = true;
				}else{
					flag = false;
				}
			}
		}catch (Exception e) {
			flag = false;
			logger.error(name+"   :isMiniCart Requried PropertyValueNull Exception Msg::"+e.getMessage());
		}
		if(!flag){
			Constants.API_ERROR_DESCRIPTION=name+Constants.API_ERROR_TEXT;
			logger.debug(Constants.API_ERROR_DESCRIPTION);
		}
		return flag;
	}

	public boolean isMinicartQuantityPropertyValueNull(String name){
		boolean flag = false;
		Constants.API_ERROR_DESCRIPTION="";
		try{
			if(minicartRespRoot.containsKey("quantity")){
				JSONObject quantity =(JSONObject) minicartRespRoot.get("quantity");
				if(quantity.containsKey(name)){
					if (JSONValidationUtils.isNotNull(quantity, name)){
						flag = true;
					}else{
						flag = false;
					}
				}
			}
		}catch (Exception e) {
			flag = false;
			logger.error(name+"   :isMiniCart quantity Requried PropertyValueNull Exception Msg::"+e.getMessage());
		}
		if(!flag){
			Constants.API_ERROR_DESCRIPTION=name+Constants.API_ERROR_TEXT;
			logger.debug(Constants.API_ERROR_DESCRIPTION);
		}
		return flag;
	}
}
