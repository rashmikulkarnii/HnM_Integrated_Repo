package com.HnM.qe.framework.web.helpers;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.log4j.Logger;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.HnM.qe.framework.common.CommonActionHelper;
import com.HnM.qe.framework.common.Constants;
import com.HnM.qe.framework.common.OSInfo;
import com.HnM.qe.framework.common.PropertiesHelper;


public class WebDriverHelper {
	private static final Logger logger = Logger.getLogger(WebDriverHelper.class);
	public static String homeURL;
	public static RemoteWebDriver driver;
	public WebDriverWait wait;
	public PropertiesHelper webPropHelper = PropertiesHelper.getInstance();
	public static String browserType;
	public static String testtype;
	public static int explicitWaitTime;
	public static int pageLoadWaitTime;

	public void initializeDriver(){

		try{
			String isLocalENV = webPropHelper.getConfigPropProperty("isLocalENV");
			testtype = System.getProperty("testtype");
			if(testtype ==null &&("yes".equalsIgnoreCase(isLocalENV)||"true".equalsIgnoreCase(isLocalENV))){
				testtype = webPropHelper.getConfigPropProperty("AppType");
			}

			logger.debug("platformType:: "+testtype);
			browserType = System.getProperty("browser");

			if(browserType ==null &&("yes".equalsIgnoreCase(isLocalENV)||"true".equalsIgnoreCase(isLocalENV))){
				browserType = webPropHelper.getConfigPropProperty("browserType");
			}
			logger.debug("browserType:: "+browserType);
			if(browserType != null){
				browserType = browserType.toLowerCase();
			}

			if("web".equalsIgnoreCase(testtype)){
				initializeWebDriver(browserType);

				logger.debug("Window size maximise........");
				//driver.manage().window().setSize(new Dimension(1500,800));
				driver.manage().window().maximize();

			} else if("mobile".equalsIgnoreCase(testtype)){
				initializeWebDriver(browserType);
				String deviceName =System.getProperty("devicename");
				if(deviceName ==null &&("yes".equalsIgnoreCase(isLocalENV)||"true".equalsIgnoreCase(isLocalENV))){
					deviceName =	webPropHelper.getConfigPropProperty("deviceName");
				}
				logger.debug("Mobile Device Dimension set.....deviceName::"+deviceName);
				addDeviceDimension(deviceName);
			} else if("android".equalsIgnoreCase(testtype)){

			} else if("ios".equalsIgnoreCase(testtype)){

			}else{
				logger.debug("Platform Type Not defined due to not able to initialize Driver---------------------------------platformType::"+testtype);
			}

			if(driver!= null ){
				//driver.manage().timeouts().implicitlyWait(getWaitTime("WEBDRIVER_IMPLICIT_WAITTIME_SECONDS"), TimeUnit.SECONDS);
				explicitWaitTime=getWaitTime("WEBDRIVER_EXPLICIT_WAITTIME_SECONDS");
				pageLoadWaitTime=getWaitTime("PAGELOAD_WAITTIME_SECONDS");
			}

			logger.debug("HEIGHT::"+ driver.manage().window().getSize().getHeight());
			logger.debug("WIDTH::"+ driver.manage().window().getSize().getWidth());
		}catch (Exception e) {
			logger.error("Exception inside initializeRemoteWebDriver() "+e.getMessage());
			e.printStackTrace();
		} 
	}

	public void initializeWebDriver(String browserType){
		logger.debug("initializeWebDriver() inside process......");
		try{

			if("chrome".equalsIgnoreCase(browserType)){
				launchChromeBrowser(getWebDriverFolderPath("chromedriver"));
			}else if("firefox".equalsIgnoreCase(browserType)){
				launchFirefoxBrowser(getWebDriverFolderPath("geckodriver"));
			}else if(browserType.contains("ie")){
				launchIEBrowser(getWebDriverFolderPath("IEDriverServer"));
			}else if("edge".equalsIgnoreCase(browserType)){
				launchEdgeBrowser(getWebDriverFolderPath("MicrosoftWebDriver"));
			}else if("safari".equalsIgnoreCase(browserType)){
				launchSafariBrowser(getWebDriverFolderPath("SafariWebDriver"));
			}else{
				launchChromeBrowser(getWebDriverFolderPath("chromedriver"));
			}

		}catch (Exception e) {
			logger.error("Exception inside initializeRemoteWebDriver() "+e.getMessage());
			e.printStackTrace();
		} catch (Throwable e) {
			logger.error("Throwable inside initializeRemoteWebDriver() "+e.getMessage());
			e.printStackTrace();
		}
	}

	public String getWebDriverFolderPath(String driverFileName){
		String finalPath = null;
		String osName = System.getProperty("osname");
		if(osName != null){
			OSInfo.setOSName(osName);
		}
		if(OSInfo.OS.WINDOWS.equals(OSInfo.getOs())){
			finalPath =Constants.DRIVERSFOLDERPATH=Constants.DRIVERSROOTFOLDERPATH+"windows/"+driverFileName+".exe";
		}else if(OSInfo.OS.MAC.equals(OSInfo.getOs())){
			finalPath =Constants.DRIVERSFOLDERPATH=Constants.DRIVERSROOTFOLDERPATH+"mac/"+driverFileName;
		}else if(OSInfo.OS.UNIX.equals(OSInfo.getOs())){
			finalPath =Constants.DRIVERSFOLDERPATH=Constants.DRIVERSROOTFOLDERPATH+"linux/";
		}else if(OSInfo.OS.POSIX_UNIX.equals(OSInfo.getOs())){
			finalPath =Constants.DRIVERSFOLDERPATH=Constants.DRIVERSROOTFOLDERPATH+"linux/";
		}
		logger.debug("WebDriver Folder Path::"+finalPath);
		return finalPath;
	}
	public boolean openBaseURL(String propKey){ //(String url){
		homeURL = webPropHelper.getConfigPropProperty(propKey);
		logger.debug("Open Chrome browser with URL::"+homeURL);
		logger.debug("HomeURL:: "+homeURL);
		long starTtime = System.currentTimeMillis();
		getDriver().get(homeURL);
		ignoreIECertificate();
		boolean isPageLoad = CommonActionHelper.waitForPageLoad(driver);
		long endTime = System.currentTimeMillis();
		NumberFormat formatter = new DecimalFormat("#0.00000");
		logger.debug("URL page load time is: " + formatter.format((endTime - starTtime) / 1000d) + " seconds");
		return isPageLoad;
	}
	//Opening FF
	public RemoteWebDriver launchFirefoxBrowser(String driverfilePath) throws Throwable
	{
		logger.debug("Launching Firefox Browser....................");
		//System.setProperty("webdriver.gecko.driver", Constants.DRIVERSFOLDERPATH+"geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", driverfilePath);
		driver = new FirefoxDriver();
		return driver;
	}
	
	public void ignoreIECertificate(){
		try{
			
			if (browserType.contains("ie") && driver.getTitle().contains("Certificate")){
				logger.debug("IE Browser Certificates issue found...");
				driver.get("javascript:document.getElementById('overridelink').click()");
				//driver.navigate().to("javascript:document.getElementById('overridelink').click()");
				logger.debug("IE Browser Certificates are accepted..............");
				CommonActionHelper.waitForPageLoad(driver);
			}
			    
		}catch (Exception e) {
			logger.error("ignoreIECertificate execption msg::"+e.getMessage());
		}
	}

	//Opening Google_Chrome
	public RemoteWebDriver launchChromeBrowser(String driverfilePath) throws Throwable
	{
		logger.debug("Launching Chrome Browser....................");
		//System.setProperty("webdriver.chrome.driver",Constants.DRIVERSFOLDERPATH+"chromedriver.exe");
		System.setProperty("webdriver.chrome.driver",driverfilePath);

		/*String deviceName =System.getProperty("devicename");// "iPhone 6";
		if(deviceName != null){
			logger.debug("deviceName:: "+deviceName);
			Map<String, String> mobileEmulation = new HashMap<String, String>();

			//mobileEmulation.put("deviceName", "Nexus 5");
			mobileEmulation.put("deviceName", deviceName);
			ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			driver=new ChromeDriver(chromeOptions);

		}else {*/
		//ChromeOptions options = new ChromeOptions();
		//		options.addArguments("--start-maximized");
		//options.addArguments("--start-fullscreen");
		driver=new ChromeDriver();

		//}

		return driver;
	}

	//Opening IE
	public WebDriver launchIEBrowser(String driverfilePath) throws Throwable 
	{
		logger.debug("Launching IE Browser....................");
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		//System.setProperty("webdriver.ie.driver",Constants.DRIVERSFOLDERPATH+"IEDriverServer.exe");
		System.setProperty("webdriver.ie.driver",driverfilePath);
		driver=new InternetExplorerDriver();
		return driver;
	}

	//Opening Edge
	public WebDriver launchEdgeBrowser(String driverfilePath) throws Throwable 
	{
		logger.debug("Launching Edge Browser....................");
		//System.setProperty("webdriver.edge.driver",Constants.DRIVERSFOLDERPATH+"MicrosoftWebDriver.exe");
		System.setProperty("webdriver.edge.driver",driverfilePath);
		driver=new EdgeDriver();
		return driver;

	}

	public WebDriver launchSafariBrowser(String driverfilePath) throws Throwable 
	{
		logger.debug("Launching Safari Browser....................");
		//System.setProperty("webdriver.edge.driver",Constants.DRIVERSFOLDERPATH+"MicrosoftWebDriver.exe");
		SafariOptions options = new SafariOptions();
	     // options.setUseTechnologyPreview(true);
	      options.setCapability("browserConnectionEnabled", true);
	      options.setCapability("locationContextEnabled", true);
	      options.setCapability("javascriptEnabled", true);
	      
		driver=new SafariDriver(options);
		return driver;

	}
	public static void quitDriver() {
		logger.debug("inside teardown()....");
		if (driver != null) {
			driver.quit();
			logger.debug("driver quit success.");
		}
	}

	public RemoteWebDriver getDriver() {
		return driver;
	}

	public void addDeviceDimension(String deviceName){

		try{
			logger.debug("Adding Mobile device Name::"+deviceName);
			if(driver != null && webPropHelper.containsKeyFromMobileDimension(deviceName)){
				String deviceDimension=webPropHelper.getMobileDimensionProperty(deviceName);
				logger.debug("Mobile device demension::"+deviceDimension);
				String demensionSplit[] = deviceDimension.split(";");
				int width = Integer.valueOf(demensionSplit[0]);
				int hight = Integer.valueOf(demensionSplit[1]);
				logger.debug(width+"::"+hight);
				driver.manage().window().setSize(new Dimension(width,hight));
				logger.debug("Added Mobile device demension Success");
			}

		}catch (Exception e) {
			logger.error("addDeviceDimension msg::"+e.getMessage());
			e.printStackTrace();
		}
	}

	public int getWaitTime(String key){
		int wait=10;
		try{
			if(webPropHelper.containsKeyFromConfigProp(key)){
				String waitTimeStr = webPropHelper.getConfigPropProperty(key);
				logger.debug(key+"::"+waitTimeStr);
				if(waitTimeStr!= null && waitTimeStr.matches("-?\\d+")){
					wait=Integer.valueOf(waitTimeStr);
				}
			}

		}catch (Exception e) {
			logger.error("getImplicitWaitTime error msg::"+e.getMessage());

		}
		return wait;
	}
}


