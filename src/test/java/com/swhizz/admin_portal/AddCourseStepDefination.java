package com.swhizz.admin_portal;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddCourseStepDefination {

	private final WebDriver driver;

	public AddCourseStepDefination(DriverContext context) {
		this.driver = context.getDriver();
	}

	@Then("browser navigates to courses list page")
	public void browser_navigates_to_courses_list_page() {
		String acttitle = driver.findElement(By.xpath("//h3[contains(text(),'Courses List')]")).getText();
		Assert.assertTrue("Courses List".equalsIgnoreCase(acttitle));
	}

	@When("admin clicks on the add course button")
	public void admin_clicks_on_the_add_course_button() {
		driver.findElement(By.xpath("//header/div[1]/div[1]/div[1]/a[1]")).click();
	}

	@Then("browser naviagtes to add course page")
	public void browser_naviagtes_to_add_course_page() {
		String actTitle = driver.findElement(By.xpath("//h3[contains(text(),'Add Course')]")).getText();
		Assert.assertTrue(actTitle.equalsIgnoreCase("Add Course"));
	}

	@Given("following course details")
	public void following_course_details(DataTable dataTable) {
		Map<String, String> details = dataTable.asMap();

		new Select(driver.findElement(By.name("category_id"))).selectByVisibleText(details.get("Category"));
		driver.findElement(By.name("course_name")).sendKeys(details.get("Course Name"));
		driver.findElement(By.name("course_slug")).sendKeys(details.get("Course URL"));
		driver.findElement(By.name("userfile")).sendKeys(details.get("choose file"));
		driver.findElement(By.name("traning_video")).sendKeys(details.get("course video link"));
		new Select(driver.findElement(By.name("popular_type"))).selectByVisibleText(details.get("is popular"));
		driver.findElement(By.name("sort_order")).sendKeys(details.get("sort order"));
		driver.findElement(
				By.xpath("/html/body/div[1]/section/div/div/section/div/div/div/div/form/div[8]/div[2]/input"))
				.sendKeys(details.get("rating"));
		driver.findElement(By.xpath(
				"/html[1]/body[1]/div[1]/section[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[9]/div[1]/input[1]"))
				.sendKeys(details.get("Leraners"));
		driver.findElement(By.name("meta_title")).sendKeys(details.get("meta title"));
		driver.findElement(By.name("meta_desc")).sendKeys(details.get("meta desrciption"));
		driver.findElement(By.name("meta_keywords")).sendKeys(details.get("meta keywords"));
		driver.findElement(By.name("google_code_one")).sendKeys(details.get("Google code script"));
		driver.findElement(By.name("submit")).click();
	}
}
