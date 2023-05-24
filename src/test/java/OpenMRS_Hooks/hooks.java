package OpenMRS_Hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import Com.OpenMRS.DriverFactory.driverfactory;
import Com.OpenMRS.Utility.Element_Util;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class hooks extends driverfactory{
	@Before
	public void beforescenario(Scenario scenario) {
		driver=new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		eu=new Element_Util(driver);
	}
	
	@After
	public void afterscenario(Scenario scenario) {
		boolean true_false=scenario.isFailed();
		if(true_false) {
			TakesScreenshot ts=(TakesScreenshot) driver;
			byte[] ss=ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(ss, "image/png", "Failed Scenarion's Screenshot");
		}
		driver.quit();
	}

}
