package testData;

import utils.CommonUtils;

public class FileConstants {

	public static String ROOT_PATH = System.getProperty("user.dir");
	public static final String LOGIN_TEST_DATA_FILE_PATH = ROOT_PATH + "/src/main/java/testData/logindata.properties";
	public static final String HOME_TEST_DATA_FILE_PATH = ROOT_PATH + "/src/main/java/testData/homedata.properties";
	public static final String ACCT_DATA_FILE_PATH = ROOT_PATH + "/src/main/java/testData/accountdata.properties";
	public static final String OPPO_DATA_FILE_PATH = ROOT_PATH + "/src/main/java/testData/opportunitiesdata.properties";
	public static final String TEST_FILE_UPLOAD_PATH = ROOT_PATH+"/src/main/resources/ExcelDemo.xlsx";
	public static final String TEST_PHOTO_UPLOAD_PATH = ROOT_PATH+"/src/main/resources/css.png";
	public static final String SCREENSHOTS_FOLDER_PATH = ROOT_PATH+"/src/main/resources/screenshots/"+CommonUtils.getTimeStamp()+"_SFDC.PNG";
	public static final String REPORTS_FILE_PATH = ROOT_PATH+"/src/main/resources/reports/"+CommonUtils.getTimeStamp()+"_SFDC.html";
} 
