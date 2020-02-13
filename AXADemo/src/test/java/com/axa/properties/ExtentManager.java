package com.axa.properties;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.NetworkMode;

public class ExtentManager {

	private static ExtentReports extent;


	public static ExtentReports getInstance() {
		if (extent == null) {
			prepareExtent();
		}
		return extent;
	}

	private static void prepareExtent() {
		extent = new ExtentReports("./extendreport.html", Boolean.TRUE, NetworkMode.ONLINE);
		extent.config().documentTitle("AXA Test Report").reportName("Suite - ").reportHeadline("AXA Test Report");
		/* extent.addSystemInfo("Selenium Version", "2.47.1").addSystemInfo("Environment", "QA");*/
		}
}
