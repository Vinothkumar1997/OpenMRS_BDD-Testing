package OpenMRS_Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(
		features = {"src/main/java/OpenMRS_Features/OpenMRS_HeaderPage.feature"},
		dryRun = !true,
		glue = {"OpenMRS.Pages","OpenMRS_Hooks"},
		snippets = SnippetType.CAMELCASE,
		tags = "@ActiveLink or @Appointmentscheduling or @CaptureVitals or @MetaData" ,
		plugin = {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)
public class Runner extends AbstractTestNGCucumberTests {

}
