package com.automatizacion.ripley;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import pages.WD;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/com/automatizacion/ripley",
    tags = "@DemoRipley",
    plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"})

public class FlujoRipleyRunner {
	
	@BeforeClass
	public static void setuppre(){

	    DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
	    Date date = new Date();
	    String dateG = dateFormat.format(date);
	
	    ExtentProperties extentProperties = ExtentProperties.INSTANCE;
	    extentProperties.setReportPath("output/CreateCampaign-" + dateG + ".html");
	}
	
	@AfterClass
	public static void setup() {
		WD.closeDriver();
		Reporter.loadXMLConfig(new File("reports/extent-config.xml"));
	}
	
	public static void writeExtentReport() {
	    System.setProperty("target/cucumber-reports/", "report_____" + ".html");
	    Reporter.setSystemInfo("user", System.getProperty("user.name"));
	    Reporter.setTestRunnerOutput("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	   // Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
	}
}