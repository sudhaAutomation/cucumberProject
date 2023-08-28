package com.swhizz.admin_portal;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/features" }, glue = { "com.swhizz.admin_portal" })
public class TestNgCucumberSuiteRunner extends AbstractTestNGCucumberTests {

	public TestNgCucumberSuiteRunner() {
		System.out.println("TestNgCucumberSuiteRunner execution started...");
	}

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}

}