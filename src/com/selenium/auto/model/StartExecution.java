package com.selenium.auto.model;

import org.testng.annotations.Test;

public class StartExecution {

	
	@Test
	public void startTime() {
		CommonLibrary commonLibrary = new CommonLibrary(); 
		ConfigurationLibrary.executionStartTime = commonLibrary.getCurrentTime();
	}
}
