package com.aso.qe.framework.api.json;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReaderCommon {
	private static final Logger logger = Logger.getLogger(JsonReaderCommon.class);
	public static final String  jsonSchemaFolderPath = System.getProperty("user.dir")+ "/src/test/resources/apiJsonSchema/";
	public static final String  jsonRequestFolderPath = System.getProperty("user.dir")+ "/src/test/resources/apiJsonRequest/";
	public static ObjectMapper mapper = new ObjectMapper();

	public static String getValue( JSONObject jsonObject, String key){
		String val=null;
		try{
			val = (String) jsonObject.get(key);
		}catch (Exception e) {

		}
		return val;
	}

	public static JSONObject parseJsonString(String responseStr){

		JSONObject jsonObject= null;
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(responseStr);

			jsonObject =  (JSONObject) obj;
		} catch (ParseException e) {
			logger.error("parseJsonString ParseException::"+e.getMessage());
			e.printStackTrace();
		}
		return jsonObject;
	}


	public static ErrorCode404Response readErrorCode404Response(String responseStr){

		ErrorCode404Response errorCode404Response= null;
		try {
			errorCode404Response = mapper.readValue(responseStr, ErrorCode404Response.class);
		} catch (Exception e) {
			logger.error("parseJsonString ParseException::"+e.getMessage());
			e.printStackTrace();
		}
		return errorCode404Response;
	}

	public static ErrorCode500Response readErrorCode500Response(String responseStr){

		ErrorCode500Response errorCode500Response= null;
		try {
			errorCode500Response = mapper.readValue(responseStr, ErrorCode500Response.class);
		} catch (Exception e) {
			logger.error("parseJsonString ParseException::"+e.getMessage());
			e.printStackTrace();
		}
		return errorCode500Response;
	}
}
