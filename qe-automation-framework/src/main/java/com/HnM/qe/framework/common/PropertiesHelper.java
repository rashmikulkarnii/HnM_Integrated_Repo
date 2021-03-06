package com.HnM.qe.framework.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Logger;

public class PropertiesHelper {
	private static final Logger logger = Logger.getLogger(PropertiesHelper.class);
	private final Properties configProp = new Properties();
	private final Properties apiEndPoints = new Properties();
	private final Properties mobileDimension = new Properties();
	public String captureOnlyFAIL;
	public String captureScreenShot;

	private PropertiesHelper()
	{
		//Private constructor to restrict new instances
		logger.debug("Read all properties from file");
		try {

			FileInputStream configPropFis = getFileInputStrem(System.getProperty("user.dir")+ "/src/test/resources/config/Config.properties");
			if(configPropFis != null){
				configProp.load(configPropFis);
			}
			logger.debug("properties file load Done.");
			getCaptureScreenProp();

			FileInputStream apiEndPointFis = getFileInputStrem(System.getProperty("user.dir")+ "/src/test/resources/object_repo/api/EndPoints.properties");
			if(apiEndPointFis != null){
				apiEndPoints.load(apiEndPointFis);
			}

			FileInputStream mobileViewPropFis = getFileInputStrem(System.getProperty("user.dir")+ "/src/test/resources/config/MobileViewportConfig.properties");
			if(mobileViewPropFis != null){
				mobileDimension.load(mobileViewPropFis);
			}

		} catch (IOException e) {
			logger.error("PropertiesHelper IOException:: "+e.getMessage());
			e.printStackTrace();
		}
	}


	public Properties loadPropertyFile(String absolutepath){
		Properties propFile = new Properties();
		try{
			FileInputStream propFileFis = new FileInputStream(absolutepath);
			propFile.load(propFileFis);

		}catch (Exception e) {
			logger.error("PropertiesHelper.loadPropertyFile Exception:: "+e.getMessage());
			e.printStackTrace();
		}
		return propFile;
	}

	//Bill Pugh Solution for singleton pattern
	private static class LazyHolder
	{
		private static final PropertiesHelper INSTANCE = new PropertiesHelper();
	}

	public static PropertiesHelper getInstance()
	{
		return LazyHolder.INSTANCE;
	}

	public String getConfigPropProperty(String key){
		return configProp.getProperty(key);
	}

	public Set<String> getConfigPropAllPropertyNames(){
		return configProp.stringPropertyNames();
	}

	public boolean containsKeyFromConfigProp(String key){
		return configProp.containsKey(key);
	}

	

	public String getEndpointProProperty(String key){
		return apiEndPoints.getProperty(key);
	}

	public void getCaptureScreenProp(){
		captureScreenShot = configProp.getProperty("CaptureScreenShot");
		captureOnlyFAIL = configProp.getProperty("CaptureOnlyFAIL");
	}

	public FileInputStream getFileInputStrem(String filePath){
		FileInputStream fileInputStrem = null;
		try{
			fileInputStrem = new FileInputStream(filePath);
		}catch (Exception e) {
			logger.error("getFileInputStrem() exception msg::"+e.getMessage());
			logger.error("FILE NOT FOUND::"+filePath);
		}
		return fileInputStrem;
	}
	
	public String getMobileDimensionProperty(String key){
		return mobileDimension.getProperty(key);
	}

	public Set<String> getMobileDimensionAllPropertyNames(){
		return mobileDimension.stringPropertyNames();
	}

	public boolean containsKeyFromMobileDimension(String key){
		return mobileDimension.containsKey(key);
	}
}
