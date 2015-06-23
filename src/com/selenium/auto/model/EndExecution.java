package com.selenium.auto.model;

import org.testng.annotations.Test;


public class EndExecution {

	/*public static void main(String[] args) {
		CommonLibrary commonLibrary = new CommonLibrary();
		ConfigurationLibrary.executionEndTime = commonLibrary.getCurrentTime();
		System.out.println("End Time"+ ConfigurationLibrary.executionEndTime);
	}*/
	
	
	@Test
	public void endTime() throws Exception {
		CommonLibrary commonLibrary = new CommonLibrary();
		ConfigurationLibrary.executionEndTime = commonLibrary.getCurrentTime();
		System.out.println("End Time"+ ConfigurationLibrary.executionEndTime);
		Reports.writtingSummaryReport();
	}
}
