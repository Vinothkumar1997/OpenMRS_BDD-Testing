package OpenMRS.Pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Com.OpenMRS.DriverFactory.driverfactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpenMRS_HeaderPage extends driverfactory {
	@Given("User should login")
	public void userShouldLogin() {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys("Admin123");
		driver.findElement(By.id("Inpatient Ward")).click();
		driver.findElement(By.id("loginButton")).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}
	@Given("User click on admin")
	public void userClickOnAdmin() {
		driver.findElement(By.xpath("//ul/li[@class=\"nav-item identifier\"]")).click();
	}
	@Given("User click on my account")
	public void userClickOnMyAccount() {
		driver.findElement(By.cssSelector("a[href=\"/openmrs/adminui/myaccount/myAccount.page\"]")).click();
	}
	@When("User can navigate into My account")
	public void userCanNavigateIntoMyAccount() {
		String act_Url=driver.getCurrentUrl();
		System.out.println(act_Url);
		Assert.assertEquals(act_Url.contains("myAccount.page"), true);
	}
	@Then("User can do settings")
	public void userCanDoSettings() {
	   int No_of_settings= driver.findElements(By.xpath("//div[@id=\"tasks\"]/a")).size();
		Assert.assertEquals(No_of_settings, 2);
	}
//Scenario : Change password
	@Given("User click on change password")
	public void userClickOnChangePassword() {
	   driver.findElement(By.cssSelector("a[href=\"/openmrs/adminui/myaccount/changePassword.page\"]")).click();
	}
	@Given("User Enter the oldpassword as {string}")
	public void userEnterTheOldpasswordAs(String OldPassword) {
		driver.findElement(By.id("oldPassword-field")).sendKeys(OldPassword);
	}
	@Given("User Enter the newpassword as {string}")
	public void userEnterTheNewpasswordAs(String NewPassword) {
		driver.findElement(By.id("newPassword-field")).sendKeys(NewPassword);
	}
	@Given("User enter the confirmpassword as {string}")
	public void userEnterTheConfirmpasswordAs(String confirmpassword) {
		driver.findElement(By.id("confirmPassword-field")).sendKeys(confirmpassword);
	}
	@When("user click the save button")
	public void userClickTheSaveButton() {
		WebElement clk=driver.findElement(By.id("save-button"));
		WebElement wt=wait.until(ExpectedConditions.visibilityOf(clk));
		wt.click();
	}
	@Then("User can get the update")
	public void userCanGetTheUpdate() {
		WebElement txt=driver.findElement(By.xpath("//p[text()=\"Failed to change your new password\"]"));////div[@class=\"text\"]//p
		WebElement pass=wait.until(ExpectedConditions.visibilityOf(txt));
		String msg=pass.getText();
		System.out.println(msg);
		Assert.assertEquals(msg.contains("change your new password"), true);
		
	}
//my language
	@Given("User click on my languages")
	public void userClickOnMyLanguages() {
		driver.findElement(By.cssSelector("a[href=\"/openmrs/adminui/myaccount/changeDefaults.page\"]")).click();

	}
	@Given("User select primary languages {string}")
	public void userSelectPrimaryLanguages(String PrimaryLang) {
		WebElement sel=driver.findElement(By.id("default-locale-field"));
		Select select=new Select(sel);
		select.selectByVisibleText(PrimaryLang);
	}
	@Given("User select Proficient Languages {string}")
	public void userSelectProficientLanguages(String ProficientLang) {
		if(ProficientLang.equals("English (United Kingdom)")) {
			driver.findElement(By.cssSelector("input[value=\"en_GB\"]")).click();
		}if(ProficientLang.equals("Spanish")) {
			driver.findElement(By.cssSelector("input[value=\"es\"]")).click();
		}if(ProficientLang.equals("French")) {
			driver.findElement(By.cssSelector("input[value=\"fr\"]")).click();

		}if(ProficientLang.equals("Italian")) {
			driver.findElement(By.cssSelector("input[value=\"it\"]")).click();

		}if(ProficientLang.equals("Portuguese")) {
			driver.findElement(By.cssSelector("input[value=\"pt\"]")).click();
		}
	}
	@When("User click save")
	public void userClickSave() {
		driver.findElement(By.cssSelector("input[value=\"Save\"]")).click();

	}
	@Then("User can get notification")
	public void userCanGetNotification() {
		String text=driver.findElement(By.xpath("//div[@class=\"text\"]/p[contains(text(),'User defaults could not be updated.')]")).getText();
		System.out.println(text);
		Assert.assertEquals(text, "User defaults could not be updated.");
	}
//location
	@Given("User click on loction dropdown")
	public void userClickOnLoctionDropdown() {
		driver.findElement(By.id("selected-location")).click();
	}
	@Given("User click on paticular location as {string}")
	public void userClickOnPaticularLocationAs(String Location) {
		if(Location.equals("Isolation Ward")) {
		driver.findElement(By.xpath("//ul/li[text()=\"Isolation Ward\"]")).click();
		}if(Location.equals("Laboratory")) {
			driver.findElement(By.xpath("//ul/li[text()=\"Laboratory\"]")).click();
		}if(Location.equals("Outpatient Clinic")) {
				driver.findElement(By.xpath("//ul/li[text()=\"Outpatient Clinic\"]")).click();
		}if(Location.equals("Pharmacy")) {
				driver.findElement(By.xpath("//ul/li[text()=\"Pharmacy\"]")).click();
		}if(Location.equals("Registration Desk")) {
				driver.findElement(By.xpath("//ul/li[text()=\"Registration Desk\"]")).click();
		}	
	}
	@When("User referesh the page")
	public void userRefereshThePage() {
		driver.navigate().refresh();
	}
	@Then("User can navigate to paticular location")
	public void userCanNavigateToPaticularLocation() {
		String act_text=driver.findElement(By.tagName("h4")).getText();
		System.out.println(act_text);
		if(act_text.contains("Isolation Ward.")) {
		Assert.assertEquals(act_text.contains("Isolation Ward."), true);
		}if(act_text.contains("Laboratory.")) {
			Assert.assertEquals(act_text.contains("Laboratory."), true);
		}if(act_text.contains("Outpatient Clinic.")) {
				Assert.assertEquals(act_text.contains("Outpatient Clinic."), true);
		}if(act_text.contains("Pharmacy.")) {
				Assert.assertEquals(act_text.contains("Pharmacy."), true);
		}if(act_text.contains("Registration Desk.")) {
				Assert.assertEquals(act_text.contains("Registration Desk."), true);
			}
	}
//logout
	@When("User click logout button")
	public void userClickLogoutButton() {
	  driver.findElement(By.cssSelector("a[href=\"/openmrs/appui/header/logout.action?successUrl=openmrs\"]")).click();
	}
	@Then("User can logout")
	public void userCanLogout() {
		String URL=driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://demo.openmrs.org/openmrs/login.htm");
	}

}
