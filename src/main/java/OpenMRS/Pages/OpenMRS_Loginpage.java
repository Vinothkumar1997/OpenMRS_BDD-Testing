package OpenMRS.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Com.OpenMRS.DriverFactory.driverfactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpenMRS_Loginpage extends driverfactory{
	@Given("User enter the username as {string}")
	public void userEnterTheUsernameAs(String Username) {
		driver.findElement(By.id("username")).sendKeys(Username);
	}
	
	@Given("User enter the password as {string}")
	public void userEnterThePasswordAs(String Password) {
		driver.findElement(By.id("password")).sendKeys(Password);
	}
	
	@Given("User should select Location for this session")
	public void userShouldSelectLocationForThisSession() {
		driver.findElement(By.id("Inpatient Ward")).click();
	}
	
	@When("User click on login button")
	public void userClickOnLoginButton() {
		driver.findElement(By.id("loginButton")).click();
	}
	
	@Then("user can login successfull")
	public void userCanLoginSuccessfull() {
		String text=driver.findElement(By.tagName("h4")).getText();
		System.out.println(text);
		Assert.assertEquals(text.contains("Inpatient Ward"), true);
	}
	
	@Then("user cannot login")
	public void userCannotLogin() {
		String err_msg=driver.findElement(By.id("error-message")).getText();
		System.out.println(err_msg);
		Assert.assertEquals(err_msg,"Invalid username/password. Please try again.");
	}
	
	@When("User click on login button without select Location for this session")
	public void userClickOnLoginButtonWithoutSelectLocationForThisSession() {
		driver.findElement(By.id("loginButton")).click();
	}
	
	@Then("user cannot login without paticular location")
	public void userCannotLoginWithoutPaticularLocation() {
	    String act_err=driver.findElement(By.id("sessionLocationError")).getText();
		Assert.assertEquals(act_err,"You must choose a location!");
	}
	
	@When("User clicks on cannot login?")
	public void userClicksOnCannotLogin() {
		driver.findElement(By.id("cantLogin")).click();   
	}
	
	@Then("User can find the solution")
	public void userCanFindTheSolution() {
	    String instructions=driver.findElement(By.className("dialog-instructions")).getText();
		Assert.assertEquals(instructions,"Please contact your System Administrator.");
		driver.findElement(By.cssSelector("button[class=confirm]")).click();
	}
	@Given("User enter the login credentials as {string} and {string}")
	public void userEnterTheLoginCredentialsAsAnd(String Username, String Password) {
		driver.findElement(By.id("username")).sendKeys(Username);
		driver.findElement(By.id("password")).sendKeys(Password);
	}
	@Given("Verify The session count")
	public void verifyTheSessionCount() {
		List<WebElement> link_count=driver.findElements(By.xpath("//ul/li"));
		int act_count=link_count.size();
		Assert.assertEquals(act_count, 6);
	}
	@Given("User should select any one {string}")
	public void userShouldSelectAnyOne(String session) {
		if(session.equals("Inpatient Ward")) {
			driver.findElement(By.id("Inpatient Ward")).click();
			System.out.println("User loged In with :"+session);
		}
		if(session.equals("Isolation Ward")) {
			driver.findElement(By.id("Isolation Ward")).click();
			System.out.println("User loged In with :"+session);
		}
		if(session.equals("Laboratory")) {
			driver.findElement(By.id("Laboratory")).click();
			System.out.println("User loged In with :"+session);
		}
		if(session.equals("Outpatient Clinic")) {
			driver.findElement(By.id("Outpatient Clinic")).click();
			System.out.println("User loged In with :"+session);
		}
		if(session.equals("Pharmacy")) {
			driver.findElement(By.id("Pharmacy")).click();
			System.out.println("User loged In with :"+session);
		}
		if(session.equals("Registration Desk")) {
			driver.findElement(By.id("Registration Desk")).click();
			System.out.println("User loged In with :"+session);
		}
	}
	
	@Then("User can navigate to paticular session")
	public void userCanNavigateToPaticularSession() {
		String act_text=driver.findElement(By.tagName("h4")).getText();
		if(act_text.contains("Inpatient Ward.")) {
		Assert.assertEquals(act_text.contains("Inpatient Ward."), true);
		}
		if(act_text.contains("Isolation Ward.")) {
			Assert.assertEquals(act_text.contains("Isolation Ward."), true);
			}
		if(act_text.contains("Laboratory.")) {
			Assert.assertEquals(act_text.contains("Laboratory"), true);
			}
		if(act_text.contains("Outpatient Clinic.")) {
			Assert.assertEquals(act_text.contains("Outpatient Clinic."), true);
			}
		if(act_text.contains("Pharmacy.")) {
			Assert.assertEquals(act_text.contains("Pharmacy."), true);
			}
		if(act_text.contains("Registration Desk.")) {
			Assert.assertEquals(act_text.contains("Registration Desk."), true);
			}
	}

}
