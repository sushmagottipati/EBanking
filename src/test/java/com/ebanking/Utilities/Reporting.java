package com.ebanking.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	
	public void onStart(ITestContext testContext)
	{
		String timeStamp=new SimpleDateFormat("YYYY.MM.DD.HH.MM.SS").format(new Date());//time stamp
		String repName="Test-Report"+timeStamp+".html";
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);//specify location
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-confing.xml");
		
		
		extent=new ExtentReports();
		
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("user", "sushma");
		
		htmlReporter.config().setDocumentTitle("EBanking Test Project");//title of the report
		htmlReporter.config().setReportName("Function Test Report");//name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);//location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
	}
	public void onTestSuccess(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());//create new entry in the report
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));//send the passedinformation
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
		
		File f=new File(screenshotPath);
		
		if(f.exists())
		{
			try {
				logger.fail("Screenshot is below:" +logger.addScreenCaptureFromPath(screenshotPath));
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
}
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());//create new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
		public void onFinish(ITestContext testcontext)
		{
			extent.flush();
		}
		
	
	}
	
	


