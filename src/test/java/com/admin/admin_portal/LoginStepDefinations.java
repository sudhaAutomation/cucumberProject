package com.admin.admin_portal;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefinations {
	public WebDriver driver;
	private final DriverContext context;

	public LoginStepDefinations(DriverContext context) {
		this.context = context;
	}

	@Given("admin opens the {string} in the {string} browser")
	public void admin_opens_the_in_the_browser(String url, String browser) {

		System.setProperty("webdriver.chrome.driver", "bin/chromedriver.exe");
		driver = new ChromeDriver();
		context.setDriver(driver);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	@Given("enters the username {string} and password {string}")
	public void enters_the_username_and_password(String username, String password) {
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]"))
				.sendKeys(username);
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/form[1]/div[2]/input[1]"))
				.sendKeys(password);
	}

	@When("click on the login button")
	public void click_on_the_login_button() {
		driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[2]/form[1]/div[3]/input[1]"))
				.sendKeys(Keys.ENTER);
	}

	@Then("then admin views the dashboard with {string} message")
	public void then_admin_views_the_dashboard_with_message(String string) {
		System.out.println("dashboard page");
		String exptitile = "DASHBOARD";
		System.out.println(exptitile);
		String Acttitle = driver.findElement(By.xpath("//header/div[1]/h3[1]")).getText();
		Assert.assertTrue(Acttitle.equals(exptitile));
	}

	@Then("admin view the error message as {string}")
	public void validateErrorMessage(String expError) {/// html/body/div/div/div[2]/form/div[1]
		System.out.println("error message validation");
		String actError = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/form[1]/div[1]")).getText();
		Assert.assertTrue(actError.contains(expError));
	}

	@And("admin close the browser")
	public void admin_close_the_browser() {
		System.out.println("browser close");
		driver.quit();
	}

	@When("wait {int} seconds")
	public void wait_seconds(long seconds)  {
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

}
