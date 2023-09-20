package com.admin.admin_portal;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(snippets = SnippetType.CAMELCASE, features = { "src/test/resources/features" }, glue = {
		"com.swhizz.admin_portal" }, tags = "")
public class TestNgCucumberSuiteRunner extends AbstractTestNGCucumberTests {

	public TestNgCucumberSuiteRunner() {
		System.out.println("TestNgCucumberSuiteRunner execution started...");
	}

}