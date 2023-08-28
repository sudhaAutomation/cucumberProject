package com.swhizz.admin_portal;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;

public class DashboardStepDefination {
	
	private final WebDriver driver;

	public DashboardStepDefination(DriverContext context) {
		this.driver = context.getDriver();
	}

	@When("admin clicks on courses list option")
	public void admin_clicks_on_courses_list_option() {
		driver.findElement(By.xpath("//span[contains(text(),'Courses List')]")).click();
	}

}
