package com.HnM.qe.framework.api.helpers;

import static io.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.apache.log4j.Logger;

import com.HnM.qe.framework.common.PropertiesHelper;
import com.aso.qe.framework.api.json.JsonReaderCommon;

import io.restassured.http.ContentType;
import io.restassured.http.Cookies;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class APIJsonHelper {
	private static final Logger logger = Logger.getLogger(APIJsonHelper.class);
	public static Response response;
	public static PropertiesHelper loadProps = PropertiesHelper.getInstance();
	private String errorTxt;

	public Response initiateRestAPICall(String url){
		//"http://35.224.100.42/api/category?categoryIds=15750"
		try{
			logger.debug("EndPoint URL::"+url);
			response = given().when().get(url);
		}catch (Exception e) {
			response = null;
			logger.error("initiateRestAPICall exception msg::"+e.getMessage());
			e.printStackTrace();
		}
		return response;
	}
	
	public Response initiateRestAPICallWithCookies(String url,List<io.restassured.http.Cookie> restAssuredCookies){
		try{
			logger.debug("EndPoint Cookies URL::"+url);
			response = given().relaxedHTTPSValidation().contentType(ContentType.JSON).cookies(new Cookies(restAssuredCookies)).get(url);
			logger.debug("JSON Response::"+response.asString());
		}catch (Exception e) {
			response = null;
			logger.error("initiateRestAPICallWithCookies exception msg::"+e.getMessage());
			e.printStackTrace();
		}
		return response;
	}
	
	public Response initiateRestPostAPICallWithCookies(String url,List<io.restassured.http.Cookie> restAssuredCookies,String jsonRequestFilePath){
		try{
			logger.debug("EndPoint Cookies URL::"+url);
			String postRequestStr = JSONValidationUtils.convertJsonFileToString(JsonReaderCommon.jsonRequestFolderPath+ jsonRequestFilePath+".json");
			logger.debug("POST Request JSON:"+postRequestStr);
			response = given().relaxedHTTPSValidation().contentType(ContentType.JSON).body(postRequestStr).cookies(new Cookies(restAssuredCookies)).post(url);
			//response = given().contentType(ContentType.JSON).body(postRequestStr).cookies(new Cookies(restAssuredCookies)).post(url);
			logger.debug("JSON Response::"+response.asString());
		}catch (Exception e) {
			response = null;
			logger.error("initiateRestPostAPICallWithCookies exception msg::"+e.getMessage());
			e.printStackTrace();
		}
		return response;
	}
	
	public Response initiateRestPutAPICallWithCookies(String url,List<io.restassured.http.Cookie> restAssuredCookies,String jsonRequestFilePath){
		try{
			logger.debug("EndPoint Cookies URL::"+url);
			String postRequestStr = JSONValidationUtils.convertJsonFileToString(JsonReaderCommon.jsonRequestFolderPath+ jsonRequestFilePath+".json");
			logger.debug("PUT Request JSON:"+postRequestStr);
			response = given().relaxedHTTPSValidation().contentType(ContentType.JSON).body(postRequestStr).cookies(new Cookies(restAssuredCookies)).put(url);
			//response = given().contentType(ContentType.JSON).body(postRequestStr).cookies(new Cookies(restAssuredCookies)).post(url);
			logger.debug("JSON Response::"+response.asString());
		}catch (Exception e) {
			response = null;
			logger.error("initiateRestPutAPICallWithCookies exception msg::"+e.getMessage());
			e.printStackTrace();
		}
		return response;
	}
	public String initiateErrorRestAPICall(String strURL){

		 try{
		 URL url = new URL(strURL);//"http://35.202.244.154/api/categorycategoryIds={15613,15157,15645}");//"http://35.202.244.154/15613,15157,15645");

	     URLConnection urlc = url.openConnection();
	     urlc.setDoOutput(true);
	     urlc.setAllowUserInteraction(false);

	     PrintStream ps = new PrintStream(urlc.getOutputStream());
	     ps.close();

	     BufferedReader br = new BufferedReader(new InputStreamReader(urlc
	         .getInputStream()));
	     String l = null;
	     while ((l=br.readLine())!=null) {
	         logger.debug(l);
	     }
	     br.close();
		 }catch (Exception e) {
			 errorTxt = e.getMessage();
			logger.error("##### initiateErrorRestAPICall() inside Exception msg :: "+e.getMessage());
		}
	     return errorTxt;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		APIJsonHelper.response = response;
	}

	public String toString()
	{
		return APIJsonHelper.response.asString() ;
	}
	
	public int getStatusCode()
	{
		return APIJsonHelper.response.statusCode() ;
	}

	public String getStausLine()
	{
		return APIJsonHelper.response.statusLine();
	}
	
	public String getContentType()
	{
		return APIJsonHelper.response.contentType();
	}

	public String getHeader(String expectedHeader)
	{
		return APIJsonHelper.response.header(expectedHeader);
	}

	public Headers getHeaders()
	{
		return APIJsonHelper.response.headers();
	}
	
	public ResponseBody<?> getResponseBody()
	{
		return APIJsonHelper.response.getBody();
	}
	
	public String getResponseBodyToString()
	{
		return APIJsonHelper.response.getBody().asString();
	}

	public String getErrorTxt() {
		return errorTxt;
	}

	public void setErrorTxt(String errorTxt) {
		this.errorTxt = errorTxt;
	}


}
