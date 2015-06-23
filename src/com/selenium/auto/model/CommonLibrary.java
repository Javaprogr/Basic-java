package com.selenium.auto.model;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.selenium.auto.model.ConfigurationLibrary;

public class CommonLibrary {

	/*
	 * Browser setup
	 */
	public void configuration(WebDriver driver) throws Exception {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	    driver.get(ConfigurationLibrary.url + "/");
	}
	
	/*
	 * Find element on UI
	 */
	public boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	/*
	 * Capture screenshots
	 */
	public void captureScreenshot(WebDriver driver, String ImageName) throws Exception{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(ConfigurationLibrary.screenCapturePath + ImageName + ".jpg"));
	}
	
	/*
	 * Test case pass report
	 */
	public void  pass(Reports reports, String moduleName, String testCaseName, String stepNo, String stepSummary, String stepDescription, String actualResult, String stepStatus) throws Exception {
		ConfigurationLibrary.passCount = ConfigurationLibrary.passCount + 1;
		reports.writeIntoFile(testCaseName, stepNo, stepSummary, stepDescription , actualResult, stepStatus, "", "");
		Reports.summaryReport(moduleName, testCaseName, "Passed");
		reports.closeFile();
	}
	
	/*
	 * Test case fail report
	 */
	public void fail(WebDriver driver, Reports reports, String moduleName, String tcName, String stepNo, String stepSummary, String stepDescription, String actualResult, String message) throws Exception{
		ConfigurationLibrary.failCount = ConfigurationLibrary.failCount + 1;
		String timeStamp = getCurrentTime();
		captureScreenshot(driver, tcName + "_" + timeStamp);
		reports.writeIntoFile(tcName, stepNo, stepSummary, stepDescription, actualResult, "Failed", message, timeStamp);
		Reports.summaryReport(moduleName, tcName, "Failed");
		reports.closeFile();
	}
	
	/*
	 * System current date and time
	 */
	public String getCurrentTime() {
		Calendar cd = Calendar.getInstance();
		SimpleDateFormat datefor= new SimpleDateFormat("dd-MMM-yyyy HH-mm-ss");
		String date = datefor.format(cd.getTime());
		return date;
	}
	
}
