package com.selenium.auto.model;

public class ConfigurationLibrary 
{
	static public final String projectName = "Amalgam";
	static public final String url = "https://amalgamplus.techendeavour.com";
	
	
	
	public static String xlpath_controller = "src\\com\\selenium\\auto\\input\\Controller.xls";
	public static String xlsheet_controller = "ControllerSheet";
	public static String xlDataTable_controller = "ControllerData";
	
	
	public static String xlpath_login = "src\\com\\selenium\\auto\\inputdata\\Login.xls";
	public static String xlsheet_login = "DataSheet";
	public static String xlDataTable_login = "DataTable";

	
	
	public static final String screenCapturePath = "src\\com\\selenium\\auto\\result\\detailResult\\";
	public static final String summaryResultPath = "src\\com\\selenium\\auto\\result";
	public static final String detailResultPath = "src\\com\\selenium\\auto\\result\\detailResult";
	
	
	public static int failCount = 0;
	public static int passCount = 0;
	public static String executionStartTime=null;
	public static String executionEndTime=null;
}