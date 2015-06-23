package com.selenium.auto.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.PrintStream;

public class Reports {

	String htmlheader;
	String bodyHeader ;
	String htmlfooter;
	BufferedWriter fileObj;
	FileWriter fileHTML;
		
	private static final char NEWLINE = '\n';

	private static final long MAX_BUFFER_SIZE = 1024;

	private static StringBuilder resultBuffer = new StringBuilder();
	
	public void creatFile(String testCaseName) throws Exception {
		
		
		File detailResultDir = new File(ConfigurationLibrary.detailResultPath);
		
		if(!detailResultDir.isDirectory()){
			detailResultDir.mkdirs();
		}

		String path = detailResultDir + "/" + testCaseName + ".html";
		
		File testCaseFile = new File(path);
		
		if(testCaseFile.exists())
			testCaseFile.delete();
		
		testCaseFile.createNewFile();

		FileWriter fileHTML = new FileWriter(testCaseFile, true);
			
		fileObj = new BufferedWriter(fileHTML);

		htmlheader = htmlheader + "<html><head>";
		htmlheader += "<title>Test Execution Report </title>";
		htmlheader += "</head><body>";
		String hometable = "<Table width = 100% height = 3% align = center border =0>";
		bodyHeader = hometable;
		String homelink = "<a style ='text-decoration: none ; color: #000080' href =' ../Summary.html' title='View Summary result'>";
		bodyHeader = bodyHeader + "<tr><td width = 90%></td><td align = center><Font face='verdana'><b>" + homelink + "Summary" + "</a></b></font></td></tr></table>";
		String table = "<Table width = 800 height=6% align = center border='1' bordercolordark='#C0C0C0' cellspacing='0' cellpadding='0' bordercolorlight='#C0C0C0' bordercolor='#C0C0C0'>";
		bodyHeader = bodyHeader + table;
		bodyHeader = bodyHeader + "<tr bgcolor = #000099><th align = center COLSPAN = 2><font color =  #FFFFFF face='verdana'>" + "Test Script Execution Result" + "\t" + "</font></th></tr></table>";
		bodyHeader = bodyHeader + "<Table width = 800 align = center border='1' bordercolordark='#C0C0C0' cellspacing='0' cellpadding='0' bordercolorlight='#C0C0C0' bordercolor='#C0C0C0'>" +"<tr><th align = left width = 30%><font face='verdana' size= '2'>" + "Project Name" + "\t" + "</font></th><td align = left width = 70%><font face='verdana'>" + ConfigurationLibrary.projectName + "</td></tr>";
		bodyHeader = bodyHeader + "<tr><th  align = left width = 30%><font face='verdana' size= '2'>" + "Test Script Name" + "\t" + "</font></th><td align = left width = 70%> <font face='verdana'>" + testCaseName + "</td></tr></table>";
		bodyHeader = bodyHeader + "<table width = 100% align = center border = 0 height = 5%><tr><td></td></tr>";
		String table1 = "<table width = 800 align = center border='1' bordercolordark='#C0C0C0' cellspacing='0' cellpadding='0' bordercolorlight='#C0C0C0' bordercolor='#C0C0C0'>"; 
		bodyHeader = bodyHeader + table1 + "<tr><th width = 35% bgcolor = #000099><font color = #ffffff face='verdana'>" + "Step Description" + "</font></th>";
		bodyHeader = bodyHeader + "<th width = 35% bgcolor = #000099><font color = #ffffff face='verdana'>" + "Actual Result" + "</font></th>";
		bodyHeader = bodyHeader +  "<th width = 10% bgcolor = #000099><font color = #ffffff face='verdana'>" + "Status" + "</font></th>";
		bodyHeader = bodyHeader +  "<th width = 20% bgcolor = #000099><font color = #ffffff face='verdana'>" + "Remarks" + "</font></th></tr>";
		
		fileObj.write(bodyHeader);
	}
	
	public void writeIntoFile(String testCaseName, String stepNo, String stepSummary, String stepDecription, String ActualResult, String stepStatus, String message, String timeStamp) {
		
		try {

			String htmlBody = "<tr><td border : none colspan = 4><font color = #000099 face='verdana' size= '2'><b>" + "Step " + stepNo + ": " +  stepSummary + "</font><b></td></tr>";
			htmlBody = htmlBody + "<tr><td width = 35% border = none> <font face='verdana' size= '2'>" + stepDecription + "</font></td>";
			htmlBody = htmlBody + "<td 35% Boder = 0> <font face='verdana' size= '2'>" + ActualResult + "</font></td>";
			if(stepStatus.equals("Failed")){
				String imgLink = "<a style ='text-decoration: none ; color: #FF0000' ; face:'verdana'  href=\"../detailResult/" + testCaseName + "_" + timeStamp + ".jpg\">";
				htmlBody = htmlBody + "<td align = center> <font face='verdana' size= '2'>" + imgLink + stepStatus + "</font></td>";
			}else
				htmlBody = htmlBody + "<td align = center> <Font color = #3FCE30 face='verdana' size= '2'>" + stepStatus + "</font></td>";
			htmlBody = htmlBody + "<td align = center> <Font face='verdana' size= '2'>" + message + "</font></td>";
			
			fileObj.write(htmlBody);

		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
		}
	}
	 
	public void closeFile() throws Exception {
		htmlfooter = "</table></table>";
		htmlfooter = htmlfooter + "<table height = 5%><tr><th>" + "" + "</th></tr>";;
		fileObj.write(htmlfooter);
		fileObj.close();
	}
	
	public static void summaryReport(final String module, final String tcName, final String status) {
		try {

			if (resultBuffer.length() > 0) {
				resultBuffer.append(NEWLINE);
			}

			resultBuffer.append(module + " # " + tcName + " # " + status + "`");

			if (resultBuffer.length() < MAX_BUFFER_SIZE) {

				return;
			}

		} catch (Exception e) {
		}
	}
	
	public static void writtingSummaryReport() {
		
		if (resultBuffer.length() > 0) {
			System.out.println("Into Writing");
			writeResultBufferToFile();
		}
	}

	private static synchronized void writeResultBufferToFile() {
		System.out.println("*******"+ ConfigurationLibrary.executionStartTime + "/////////" + ConfigurationLibrary.executionEndTime);
		int total = ConfigurationLibrary.failCount + ConfigurationLibrary.passCount;
		
		int passPercentage  =  (ConfigurationLibrary.passCount * 100) / total ;
	    int failPercentage  =  (ConfigurationLibrary.failCount * 100) / total ;

		try {
			
//			String dirPath = sdCard + "/Result";
			
			File detailResultDir = new File(ConfigurationLibrary.summaryResultPath);
			
			if(!detailResultDir.isDirectory()){
				detailResultDir.mkdirs();
			}

			String path = ConfigurationLibrary.summaryResultPath + "/Summary.html";
						
			OutputStream htmlfile = new FileOutputStream(new File(path));
			PrintStream printhtml = new PrintStream(htmlfile);
			
			String htmlheader = "<html><head>";
			htmlheader += "<title>Execution Report</title>";
			htmlheader += "</head><body>";
			String bodyHeader;
			String htmlfooter = "</body></html>";
			String htmlBody = "<Table width = 100% height = 3% align = center border =0><tr><td></td></tr></table>";
			htmlBody = htmlBody + "<table width = 800 height = 6% align = center border='1' bordercolordark='#C0C0C0' cellspacing='0' cellpadding='0' bordercolorlight='#C0C0C0' bordercolor='#C0C0C0'>";
			bodyHeader = "<tr bgcolor = #000099><th COLSPAN = 3 align = center><font color = #FFFFFF face='verdana' size= '4'>" + ConfigurationLibrary.projectName +" Automation Execution Report" + "</font></th></tr></table>";
			bodyHeader = bodyHeader + "<table height = 5%><tr><th>" + "" + "</th></tr>";
			bodyHeader = bodyHeader + "<table width = 800 align = center border='1' bordercolordark='#C0C0C0' cellspacing='0' cellpadding='0' bordercolorlight='#C0C0C0' bordercolor='#C0C0C0'>";
			bodyHeader = bodyHeader + "<tr ><th  align = left width = 40%><font face='verdana' size= '2'>" + "Date & Time" + "</font></th><td align = left colspan = 2><font face='verdana' size= '2'>" +  ConfigurationLibrary.executionStartTime + "</font></td></tr>";
			bodyHeader = bodyHeader + "<tr><th  align = left width = 40%><font face='verdana' size= '2'>" + "# Test Cases Executed" +  "</font></th><td align = left colspan = 2><font face='verdana' size= '2'>" +  total   + "</font></td></tr>";
			bodyHeader = bodyHeader + "<tr><th  align = left width = 40%><font color = #3FCE30 face='verdana' size= '2'>" + " # Test Cases Passed" + "</font></th><td align = left width = 30% ><font face='verdana' size= '2'>" + ConfigurationLibrary.passCount  + "</font></td><td width = 30%>" + passPercentage + " %" + "</td></tr>";
			bodyHeader = bodyHeader + "<tr><th  align = left width = 40%><font color = #FF0000 face='verdana' size= '2'>" + "# Test Cases Failed" + "</font></th><td align = left width = 30%><font face='verdana' size= '2'>" +  ConfigurationLibrary.failCount + "</font></td><td width = 30%>" + failPercentage + " %" + "</td></tr></table>";
			bodyHeader = bodyHeader + "<table height = 5%><tr><th>" + "" + "</th></tr>";
			bodyHeader = bodyHeader + "<table width = 800 height = 4% align = center border='1' bordercolordark='#C0C0C0' cellspacing='0' cellpadding='0' bordercolorlight='#C0C0C0' bordercolor='#C0C0C0'><tr bgcolor = #000099><th width = 30%><font color = #ffffff face='verdana' size= '3'>" + "Module Name" + "</font></th>";
			bodyHeader = bodyHeader + "<th width = 50% ><font color = #ffffff face='verdana' size= '3'>" + "Test Script Name" + "</font></th>";
			bodyHeader = bodyHeader + "<th width = 20%><font color = #ffffff face='verdana' size= '3'>" + "Status" + "</font></th></table>";
			bodyHeader = bodyHeader + "<table width = 800 align = center border='1' bordercolordark='#C0C0C0' cellspacing='0' cellpadding='0' bordercolorlight='#C0C0C0' bordercolor='#C0C0C0'>";

			htmlBody = htmlBody + bodyHeader;
			
			String[] temp = resultBuffer.toString().split("`");

			for (String s : temp) {

				String[] data = s.trim().split("#");
				htmlBody = htmlBody + "<tr>";

				for (int i = 0; i < data.length; i++) {

					if (i == data.length - 1) {
						if(data[i].trim().equals("Passed")){
							String fileLink = "<a style ='text-decoration: none ; color: #3FCE30' href= \"../result/detailResult/" + data[1].trim() + ".html\"  title='View detail result' >";
							htmlBody = htmlBody + "<td width = 20% align = center><font color = #000000 face='verdana' size= '2'>" + fileLink	+ data[i].trim() + "</a></font></td>";
						}else{
							String fileLink = "<a style ='text-decoration: none ; color: #FF0000' href= \"../result/detailResult/" + data[1].trim() + ".html\"  title='View detail result' >";
							htmlBody = htmlBody + "<td width = 20% align = center><font color = #000000 face='verdana' size= '2'>" + fileLink	+ data[i].trim() + "</a></font></td>";
						}
					}else if(i == data.length-2)
						htmlBody = htmlBody + "<td width = 50%> <font face='verdana' size= '2'>" + data[i].trim() + "</font></td>";
					else
						htmlBody = htmlBody + "<td width = 30%> <font face='verdana' size= '2'>" + data[i].trim() + "</font></td>";
				}
				htmlBody = htmlBody + "</tr>";
			}
			htmlBody = htmlBody + "</table>";
		    htmlBody = htmlBody + "<table height = 5%><tr><th>" + "" + "</th></tr>";
		    htmlBody = htmlBody + "<table width = 800 align = center border='1' bordercolordark='#C0C0C0' cellspacing='0' cellpadding='0' bordercolorlight='#C0C0C0' bordercolor='#C0C0C0'><tr bgcolor = #888888 ><th COLSPAN = 2 align = center><font color =  #FFFFFF face='verdana'>" + "Execution Time" + "</font></th></tr><tr><th align=left><font face='verdana' size= '2'>" + "Start Time" + "</font></th><td><font face='verdana' size= '2'>" + ConfigurationLibrary.executionStartTime + "</font></td></tr>";
		    htmlBody = htmlBody + "<tr><th align=left><font face='verdana' size= '2'>" + "End Time" + "</font></th><td><font face='verdana' size= '2'>" + ConfigurationLibrary.executionEndTime + "</font></td></tr></table>";

			printhtml.println(htmlheader + htmlBody + htmlfooter);
	
			printhtml.close();
			htmlfile.close();
			System.out.println("Writing into Summary is completed");
	
			resultBuffer.delete(0, resultBuffer.length());

		} catch (Exception e) {
			e.getMessage();
		}
	}


}
