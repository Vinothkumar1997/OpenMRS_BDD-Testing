package OpenMRS.Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import Com.OpenMRS.DriverFactory.driverfactory;
import Com.OpenMRS.Utility.Element_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OpenMRS_HomePage extends driverfactory{
	@When("User click on Active Visit Link")
	public void userClickOnActiveVisitLink() {
		eu=new Element_Util(driver);
		eu.doclick(By.cssSelector("a[href=\"/openmrs/coreapps/activeVisits.page?app=coreapps.activeVisits\"]"));
	}
	@Then("User navigate to Active Visit page")
	public void userNavigateToActiveVisitPage() {
		String header=eu.GetelementText(By.tagName("h3"));
		System.out.println(header);
	}
	@Then("User can see patient Visit details\\(ByTableHeader)")
	public void userCanSeePatientVisitDetailsByTableHeader() {
	   int Act_count= eu.getcountOfElements(By.xpath("//table//th"));
	   Assert.assertEquals(Act_count, 5);
	}
	@Then("User can see patient Ids list")
	public void userCanSeePatientIdsList() {
		eu.GetelementsTextcontains(By.xpath("//table//th"), "Patient ID");
	}
	@Then("User can see name list")
	public void userCanSeeNameList() {
		eu.GetelementsTextcontains(By.xpath("//table//th"), "Patient ID");
	}
	@When("User enter any one patient ID {string} into search box")
	public void userEnterAnyOnePatientIDIntoSearchBox(String ID) {
		eu.dosendkeys(By.cssSelector("input[type=\"search\"]"), ID);

	}
	@Then("User can get the paticular Name {string}")
	public void userCanGetThePaticularName(String Name) {
		String name=eu.GetelementText(By.xpath("//table//td[2]"));
		System.out.println(name);
		if(name.contains(Name)){
			Assert.assertEquals(name.contains(Name), true);
		}  
	}
	@When("User enter any one patient Name {string} into search box")
	public void userEnterAnyOnePatientNameIntoSearchBox(String Name) {
		eu.dosendkeys(By.cssSelector("input[type=\"search\"]"), Name);

	}
	@Then("User can get the paticular ID {string}")
	public void userCanGetThePaticularID(String ID) {
		String name=eu.GetelementText(By.xpath("//table//td[1]"));
		System.out.println(ID);
		if(name.contains(ID)){
			Assert.assertEquals(name.contains(ID), true);
		}
	}
	@When("User enter the wrong data on search box")
	public void userEnterTheWrongDataOnSearchBox() {
		eu.dosendkeys(By.cssSelector("input[type=\"search\"]"), "Vinothmessi");

	}
	@Then("User get no entries text")
	public void userGetNoEntriesText() {
		String Text=eu.GetelementText(By.xpath("//table//td"));
		Assert.assertEquals(Text, "No entries to display");
	}
	@When("User click on Appointment scheduling Link")
	public void userClickOnAppointmentSchedulingLink() {
	    eu.doclick(By.cssSelector("a[href=\"/openmrs//appointmentschedulingui/home.page\"]"));
	}
	@Then("User navigate to Appointment scheduling page")
	public void userNavigateToAppointmentSchedulingPage() {
	    String act_text=eu.GetelementText(By.xpath("(//ul[@id=\"breadcrumbs\"]//li)[2]"));
	    System.out.println(act_text);
	    Assert.assertEquals(act_text.contains("Appointment Scheduling"), true);
	}
	@Given("User can use following links {string}")
	public void userCanUseFollowingLinks(String Links) {
	   eu.EqualTesxts(By.xpath("//div/a[@type=\"button\"]"), Links);
	}
	@When("User click on Manage Service Types link")
	public void userClickOnManageServiceTypesLink() {
	    eu.doclick(By.cssSelector("a[href=\"/openmrs/appointmentschedulingui/manageAppointmentTypes.page\"]"));
	}
	@Then("User can check the available services {string}")
	public void userCanCheckTheAvailableServices(String Service) {
		eu.EqualTesxts(By.xpath("//table//td[1]"), Service);   
	}
	@When("User click on Manage Provider Schedules link")
	public void userClickOnManageProviderSchedulesLink() {
	    eu.doclick(By.cssSelector("a[href=\"/openmrs/appointmentschedulingui/scheduleProviders.page\"]"));
	}
	@Then("User can check the available services")
	public void userCanCheckTheAvailableServices() {
	    String act = eu.GetelementText(By.xpath("//div[@ng-show=\"showCalendar\"]/h1"));
	    Assert.assertEquals(act.contains("Manage Appointment Blocks"), true);
	}
	@When("User click on Manage Appointments link")
	public void userClickOnManageAppointmentsLink() {
		eu.doclick(By.cssSelector("a[href=\"/openmrs/coreapps/findpatient/findPatient.page?app=appointmentschedulingui.schedulingAppointmentApp&\"]"));  
	}
	@Then("User can manage the Appointments services")
	public void userCanManageTheAppointmentsServices() {
		String act_header=eu.GetelementText(By.tagName("h2"));
		Assert.assertEquals(act_header.contains("Manage Appointments"), true);   
	}
	@When("User click on Daily Appointments link")
	public void userClickOnDailyAppointmentsLink() {
	    eu.doclick(By.cssSelector("a[href=\"/openmrs/appointmentschedulingui/dailyScheduledAppointments.page\"]"));
	}
	@Then("User can check the Daily Appointments services")
	public void userCanCheckTheDailyAppointmentsServices() {
		String act_header=eu.GetelementText(By.tagName("h1"));
		Assert.assertEquals(act_header.contains("Daily Appointments"), true);      
	}
	@When("User click on Appointment Requests link")
	public void userClickOnAppointmentRequestsLink() {
	    eu.doclick(By.cssSelector("a[href=\"/openmrs/appointmentschedulingui/appointmentRequests.page\"]"));
	}
	@Then("User can check the Appointment Requests services")
	public void userCanCheckTheAppointmentRequestsServices() {
		String act_header=eu.GetelementText(By.tagName("h1"));
		Assert.assertEquals(act_header.contains("Appointment Requests"), true);
	}
	@Given("User should click on Capture vitals link")
	public void userShouldClickOnCaptureVitalsLink() {
	 eu.doclick(By.cssSelector("a[href=\"/openmrs/coreapps/findpatient/findPatient.page?app=referenceapplication.vitals\"]"));
	}
	@Then("User can navigate to Capture vitals page")
	public void userCanNavigateToCaptureVitalsPage() {
	    String text=eu.GetelementText(By.tagName("h2"));
	    Assert.assertEquals(text.contains("Capture Vitals for Patient"), true);
	}
	@Given("User enter patient ID {string} on serachbox")
	public void userEnterPatientIDOnSerachbox(String ID) {
		driver.findElement(By.id("patient-search")).sendKeys(ID);

	}
	@When("User click on paticular patient ID")
	public void userClickOnPaticularPatientID() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    driver.findElement(By.xpath("//table//td[contains(text(),'100HRU')]")).click();

	}
	@Then("User can Know the full details of paticular patient")
	public void userCanKnowTheFullDetailsOfPaticularPatient() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    String ID=driver.findElement(By.xpath("//div[@class=\"float-sm-right\"]/span")).getText();
	    Assert.assertEquals(ID, "100HRU");
	}@Given("User should click on Configure MetaData link")
	public void userShouldClickOnConfigureMetaDataLink() {
		eu.doclick(By.cssSelector("a[href=\"/openmrs/adminui/metadata/configureMetadata.page\"]"));
	    
	}
	@Then("User can navigate to Configure MetaData")
	public void userCanNavigateToConfigureMetaData() {
	    String act=eu.GetelementText(By.xpath("(//ul[@id=\"breadcrumbs\"]/li)[2]"));
	    Assert.assertEquals(act, "Configure Metadata");
	}
	@Then("User can see ten configuration data.")
	public void userCanSeeTenConfigurationData() {
	    int count=eu.getcountOfElements(By.tagName("h6"));
	    Assert.assertEquals(count, 10);
	}
	@Given("User should click manage encounter role")
	public void userShouldClickManageEncounterRole() {
		eu.doclick(By.cssSelector("a[href=\"/openmrs/adminui/metadata/encounters/encounterroles/manageEncounterRoles.page\"]"));

	}
	@Given("User click on add new encounter")
	public void userClickOnAddNewEncounter() {
		eu.WebDriver_Explicit_Wait(5, By.xpath("//button[text()='Add New Encounter Role']"));
		eu.doclick(By.xpath("//button[text()='Add New Encounter Role']"));

	}
	@Given("User enter the role name")
	public void userEnterTheRoleName() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		eu.dosendkeys(By.xpath("//form//input"), "Medical care");

	}
	@Given("User write the description")
	public void userWriteTheDescription() {
		eu.dosendkeys(By.tagName("textarea"), "which involves the treatment and management of patients through the staff of physicians. Patient Support");

	}
	@When("User click save button")
	public void userClickSaveButton() {
		eu.doclick(By.cssSelector("button[type=\"submit\"]"));

	}
	@Then("new role created succefully")
	public void newRoleCreatedSuccefully() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		eu.GetelementsTextcontains(By.xpath("//table//td[1]"), "Medical care");
	}
	@When("User should click manage Encounter type")
	public void userShouldClickManageEncounterType() {
		eu.doclick(By.cssSelector("a[href=\"/openmrs/adminui/metadata/encounters/encountertypes/manageEncounterTypes.page\"]"));

	}
	@Then("User can see the all encounter type {string}")
	public void userCanSeeTheAllEncounterType(String EncounterName) {
		eu.impli_wait(5);
	    eu.EqualTesxts(By.xpath("//table//td[1]"), EncounterName);
	}
	@When("User click on add new encounter type")
	public void userClickOnAddNewEncounterType() {
		eu.impli_wait(5);
		eu.doclick(By.xpath("//button[text()='Add New Encounter Type']"));
	}
	@When("User should click on manage form link")
	public void userShouldClickOnManageFormLink() {
	    eu.doclick(By.cssSelector("a[href=\"/openmrs/formentryapp/forms.page?app=formentryapp.forms\"]"));
	}
	@Then("User can see the available forms {string}")
	public void userCanSeeTheAvailableForms(String AvailableForm) {
		List <WebElement> forms=driver.findElements(By.xpath("//table//td[1]"));
		ArrayList<String> arr=new ArrayList<String>();
		for(WebElement e:forms) {
			String all=e.getText();
			arr.add(all);
		}
		Assert.assertEquals(arr.contains(AvailableForm),true);
	}
	@When("User click on manage locations")
	public void userClickOnManageLocations() {
	    eu.doclick(By.cssSelector("a[href=\"/openmrs/adminui/metadata/locations/manageLocations.page\"]"));
	}
	@Then("User can see the available locations {string}")
	public void userCanSeeTheAvailableLocations(String locations) {
		eu.AvailableTesxts(By.xpath("//table//td[1]"), locations);

	}
	@When("User click on manage patient identifier type")
	public void userClickOnManagePatientIdentifierType() {
	    eu.doclick(By.cssSelector("a[href=\"/openmrs/adminui/metadata/patients/patientidentifiertypes/managePatientIdentifierTypes.page\"]"));
	}
	@Then("user can see the patient identifier type {string}")
	public void userCanSeeThePatientIdentifierType(String Identifier) {
		eu.impli_wait(5);
	    eu.EqualTesxts(By.xpath("//table//td[1]"), Identifier);
	}
	@When("User click on manage Privileges")
	public void userClickOnManagePrivileges() {
	    eu.doclick(By.cssSelector("a[href=\"/openmrs/adminui/metadata/privileges/managePrivileges.page\"]"));
	}
	@Then("User can see the Privileges")
	public void userCanSeeThePrivileges() {
		eu.impli_wait(5);
	    String act=eu.GetelementText(By.xpath("//h3[text()='Manage Privileges']"));
	    Assert.assertEquals(act.equals("Manage Privileges"), true);
	}
	@Given("User click on DataManagement Link")
	public void userClickOnDataManagementLink() {
	    eu.doclick(By.cssSelector("a[href=\"/openmrs/coreapps/datamanagement/dataManagement.page\"]"));
	}
	@Given("User navigate to DataManagement page")
	public void userNavigateToDataManagementPage() {
	    String act=eu.GetelementText(By.xpath("(//ul[@id=\"breadcrumbs\"]//li)[2]"));
	    Assert.assertEquals(act, "Data Management");
	}
	@When("User click merge patient link")
	public void userClickMergePatientLink() {
	    eu.doclick(By.cssSelector("a[href=\"/openmrs/coreapps/datamanagement/mergePatients.page?app=coreapps.mergePatients\"]"));
	}
	@Then("User can merge the two paitent")
	public void userCanMergeTheTwoPaitent() {
	    String text=eu.GetelementText(By.tagName("h4"));
	    Assert.assertEquals(text, "Please enter the Patient IDs of the two electronic records to merge.");
	}@When("User click on find patient link")
	public void userClickOnFindPatientLink() {
		driver.findElement(By.id("coreapps-activeVisitsHomepageLink-coreapps-activeVisitsHomepageLink-extension")).click();
	}
	@Then("User navigate to find patient link")
	public void userNavigateToFindPatientLink() {
	   String header=driver.findElement(By.tagName("h2")).getText();
	  Assert.assertEquals(header, "Find Patient Record");
	}
	@Then("User can see patient details\\(ByTableHeader)")
	public void userCanSeePatientDetailsByTableHeader() {
	    int act=driver.findElements(By.xpath("//table//th")).size();
		  Assert.assertEquals(act, 5);
	}
	@When("User enter patient {string} into search box")
	public void userEnterPatientIntoSearchBox(String ID) {
		driver.findElement(By.id("patient-search")).sendKeys(ID);
	}
	@Then("User can find the paticular patient details")
	public void userCanFindThePaticularPatientDetails() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    WebElement search=driver.findElement(By.xpath("//div/div[contains(text(),'Showing 1 to 1 of 1 entries')]"));
	    String entries = search.getText();
	    System.out.println(entries);
		Assert.assertEquals(entries, "Showing 1 to 1 of 1 entries");
	}
	@Given("User enter patient {string}")
	public void userEnterPatient(String ID) {
		driver.findElement(By.id("patient-search")).sendKeys(ID);

	}
	@When("User click on paticular patient details")
	public void userClickOnPaticularPatientDetails() {
	    driver.findElement(By.xpath("//table//td[contains(text(),'100FL5')]")).click();
	}
	@Then("User can find the full details of paticular patient")
	public void userCanFindTheFullDetailsOfPaticularPatient() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    String ID=driver.findElement(By.xpath("//div[@class=\"float-sm-right\"]/span")).getText();
	    Assert.assertEquals(ID, "100FL5");
	}
	@Then("User can get all medical information")
	public void userCanGetAllMedicalInformation() {
		Assert.assertEquals(driver.findElements(By.xpath("//div[@class=\"info-header\"]")).size(),11);
	}
	@Then("User can see patient medical record {string}")
	public void userCanSeePatientMedicalRecord(String Record) {
	    boolean act=eu.GetelementsTextcontains(By.xpath("//div[@class=\"info-header\"]//h3"), Record);
	    if(act) {
			Assert.assertTrue(act);
			}
	}
	@When("User enter the wrong ID on search box")
	public void userEnterTheWrongIDOnSearchBox() {
		driver.findElement(By.id("patient-search")).sendKeys("1206");

	}
	@Then("User get No matching found text")
	public void userGetNoMatchingFoundText() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String Message=driver.findElement(By.xpath("//table//td[contains(text(),'No matching records found')]")).getText();
		Assert.assertEquals(Message, "No matching records found");
	}
	@Given("User should click on Register Patient link")
	public void userShouldClickOnRegisterPatientLink() {
		eu.doclick(By.cssSelector("a[href=\"/openmrs/registrationapp/registerPatient.page?appId=referenceapplication.registrationapp.registerPatient\"]"));
	}
	@Then("User can navigate to Register Patient page")
	public void userCanNavigateToRegisterPatientPage() {
		String text=eu.GetelementText(By.tagName("h2"));
		System.out.println(text);
		Assert.assertEquals(text.contains("Register a patient"),true);
	}
	@Given("User enter the Patient given name")
	public void userEnterThePatientGivenName() {
		eu.dosendkeys(By.name("givenName"), "Messi");

	}
	@Given("User enter the Patient middle name")
	public void userEnterThePatientMiddleName() {
		eu.dosendkeys(By.name("middleName"), "V");

	}
	@Given("User enter the Patient family name")
	public void userEnterThePatientFamilyName() {
		eu.dosendkeys(By.name("familyName"), "Besant");

	}
	@Given("User click on next button")
	public void userClickOnNextButton() {
		eu.doclick(By.id("next-button"));

	}
	@Given("User should select the gender and click next")
	public void userShouldSelectTheGenderAndClickNext() {
		eu.selectoption(By.id("gender-field"), "Male");
		eu.doclick(By.id("next-button"));
	}
	@When("User should select the patient DOB")
	public void userShouldSelectThePatientDOB() {
		eu.dosendkeys(By.name("birthdateDay"), "23");
		eu.selectoption(By.id("birthdateMonth-field"), "April");
		eu.dosendkeys(By.name("birthdateYear"), "2007");
		eu.doclick(By.id("next-button"));
	}
	@Then("User should enter the patient address")
	public void userShouldEnterThePatientAddress() {
		eu.doclick(By.id("next-button"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		String err=eu.GetelementText(By.xpath("//span[text()=\"You need to provide a value for at least one field\"]"));
		Assert.assertEquals(err, "You need to provide a value for at least one field");
	}
	@When("User click without entering name")
	public void userClickWithoutEnteringName() {
		eu.doclick(By.id("next-button"));
	}
	@Then("User cannot navigate to further page")
	public void userCannotNavigateToFurtherPage() {
	    String text=eu.GetelementText(By.xpath("(//span[text()='Required'])[1]"));
		Assert.assertEquals(text, "Required");
	}
	@When("User click next button without entering gender")
	public void userClickNextButtonWithoutEnteringGender() {
		eu.doclick(By.id("next-button"));
	}
	@Then("User get error message")
	public void userGetErrorMessage() {
		String text=eu.GetelementText(By.xpath("(//span[text()='Required'])[1]"));
		Assert.assertEquals(text, "Required");   
	}
	@When("User click next button without entering DOB")
	public void userClickNextButtonWithoutEnteringDOB() {
		eu.dosendkeys(By.name("birthdateDay"), "23");
		eu.doclick(By.id("next-button"));
	}
	@Then("User get Required error message")
	public void userGetRequiredErrorMessage() {
	    String err=eu.GetelementText(By.xpath("//span[text()='You need to inform a valid date']"));
	    Assert.assertEquals(err, "You need to inform a valid date");
	}
	@Given("user click on unidentified patient")
	public void userClickOnUnidentifiedPatient() {
	    eu.doclick(By.id("checkbox-unknown-patient"));
	}

	@When("User click confirm")
	public void userClickConfirm() {
		eu.doclick(By.id("submit"));
	}
	@Then("Unidentified Patient registration will be successfull")
	public void unidentifiedPatientRegistrationWillBeSuccessfull() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String act=eu.GetelementText(By.tagName("h1"));
		Assert.assertEquals(act.contains("UNKNOWN"), true);
	    
	}
	@Given("User should click on Reports page link")
	public void userShouldClickOnReportsPageLink() {
	    eu.doclick(By.cssSelector("a[href=\"/openmrs/reportingui/reportsapp/home.page\"]"));
	}
	@Then("User can navigate to Reports page")
	public void userCanNavigateToReportsPage() {
	    String act_url=eu.getcurrentURL();
	    Assert.assertEquals(act_url, "https://demo.openmrs.org/openmrs/reportingui/reportsapp/home.page");
	}
	@Then("User can see the header")
	public void userCanSeeTheHeader() {
	    String text=eu.GetelementText(By.xpath("(//ul[@id=\"breadcrumbs\"]/li)[2]"));
	    Assert.assertEquals(text, "Reports");
	}
	@Given("User click on System Administration Link")
	public void userClickOnSystemAdministrationLink() {
		eu.doclick(By.cssSelector("a[href=\"/openmrs/coreapps/systemadministration/systemAdministration.page\"]"));
	}
	@When("User can see Administration services")
	public void userCanSeeAdministrationServices() {
	    String text=eu.GetelementText(By.xpath("(//ul[@id=\"breadcrumbs\"]/li)[2]"));
	    Assert.assertEquals(text, "System Administration");
	}
	@Then("User navigate to System Administration page")
	public void userNavigateToSystemAdministrationPage() {
	    int count=eu.getcountOfElements(By.xpath("//div/a[@type=\"button\"]"));
	    Assert.assertEquals(count, 6);
	}
	@When("User click Manage Extensions link")
	public void userClickManageExtensionsLink() {
	    eu.doclick(By.cssSelector("a[href=\"/openmrs/referenceapplication/manageExtensions.page\"]"));
	}
	
	@Then("User can see the extensions {string}")
	public void userCanSeeTheExtensions(String extensions) {
		eu.impli_wait(5);
	    boolean action=eu.GetelementsTextcontains(By.xpath("//table//th"), extensions);
		   Assert.assertEquals(action, true);
	}
	@When("User click Manage APP link")
	public void userClickManageAPPLink() {
	    eu.doclick(By.cssSelector("a[href=\"/openmrs/referenceapplication/manageApps.page\"]"));
	}
	@Then("User can manage the App definitions using {string}")
	public void userCanManageTheAppDefinitionsUsing(String value) {
	    String text=eu.GetelementText(By.xpath("//table//th[1]"));
	    Assert.assertEquals(text, value);
	}
	@When("User click Manage Global Properties link")
	public void userClickManageGlobalPropertiesLink() {
	    eu.doclick(By.cssSelector("a[href=\"/openmrs/adminui/systemadmin/globalproperties/manageGlobalProperties.page\"]"));
	}
	@Then("User can see the global property {string}")
	public void userCanSeeTheGlobalProperty(String Property) {
		eu.impli_wait(5);
	   boolean action= eu.GetelementsTextcontains(By.xpath("//table//th"), Property);
	   Assert.assertEquals(action, true);
	}
	@When("User click Manage Accounts link")
	public void userClickManageAccountsLink() {
	    eu.doclick(By.cssSelector("a[href=\"/openmrs/adminui/systemadmin/accounts/manageAccounts.page\"]"));
	}
	@Then("User can see Accounts details")
	public void userCanSeeAccountsDetails() {
	    String text=eu.GetelementText(By.xpath("//ul[@id=\"breadcrumbs\"]/li[3]"));
	    Assert.assertEquals(text, "Manage Accounts");
	}
	@When("User click Style Guide link")
	public void userClickStyleGuideLink() {
	    eu.doclick(By.cssSelector("a[href=\"/openmrs/uicommons/styleGuide.page\"]"));
	}
	@Then("User can see available style {string}")
	public void userCanSeeAvailableStyle(String Style) {
	    boolean action=eu.GetelementsTextcontains(By.xpath("//nav//a"), Style);
	    Assert.assertEquals(action, true);
	}
	@Then("User can customize the design by {string}")
	public void userCanCustomizeTheDesignBy(String Variables) {
		boolean action=eu.GetelementsTextcontains(By.xpath("//ul//a[@href=\"#colors\" or @href=\"#fonts\" or @href=\"#icons\"]"), Variables);
	    Assert.assertEquals(action, true);
	}
	@Then("User can customize the design by Fragments {string}")
	public void userCanCustomizeTheDesignByFragments(String Fragments) {
		boolean action=eu.GetelementsTextcontains(By.xpath("//section[@id='menu']/ul[2]//a"), Fragments);
	    Assert.assertEquals(action, true);
	}
	@When("User click Advanced Administration link")
	public void userClickAdvancedAdministrationLink() {
	    eu.doclick(By.cssSelector("a[href=\"/openmrs/admin/index.htm\"]"));

	}
	@Then("User can navigate to Administrationpage")
	public void userCanNavigateToAdministrationpage() {
	    String text=eu.GetelementText(By.tagName("h2"));
	    Assert.assertEquals(text, "Administration");
	}
	@Then("User can get provided featutres {string}")
	public void userCanGetProvidedFeatutres(String Features) {
	   boolean act= eu.GetelementsTextcontains(By.tagName("h4"), Features);
	   if(act) {
		   Assert.assertTrue(act);
	   }
	}
	@Then("User can do mulitple Advanced settings")
	public void userCanDoMulitpleAdvancedSettings() {
		eu.impli_wait(5);
	    int multiple_setting_count=eu.getcountOfElements(By.tagName("a"));
	    Assert.assertEquals(multiple_setting_count, 149);
	}
	@Then("User can see patient record {string}")
	public void userCanSeePatientRecord(String TableHeader) {
		boolean act=eu.GetelementsTextcontains(By.xpath("//table//th"), TableHeader);
		if(act) {
		Assert.assertTrue(act);
		}
	}
}
