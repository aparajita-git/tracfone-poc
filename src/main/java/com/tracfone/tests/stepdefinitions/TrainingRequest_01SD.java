package com.tracfone.tests.stepdefinitions;

import com.incessant.bon34.controls.AutoComplete;
import com.tracfone.data.BPAUser;
import com.tracfone.pages.*;
import com.tracfone.reusablemethods.BPATest;
import com.tracfone.data.BPACrossTestData;
import com.tracfone.data.UserData;
import com.incessant.bon34.core.GenericMethods;
import com.incessant.bon34.tests.CucumberGenericTest;
import com.tracfone.testdatamanager.BPATestData;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class TrainingRequest_01SD extends CucumberGenericTest {

	private GenericMethods genericMethods = new GenericMethods();
	private BPAUser BPAUser;
	private BPATest BPATest;
	private BPACrossTestData BPACrossTestData;
	private HomePage homePage;
	private RequestDetailsPage requestDetailsPage;
	private ReviewRequestPage reviewRequestPage;
	private ContinueProcessPage continueProcessPage;
	private RequestDetailsPage amendOrPORPage;


	private WithdrawCasePage withdrawCasePage;


	private String TRCaseID;
	private String TDCaseID;


	public TrainingRequest_01SD(BPACrossTestData BPACrossTestData) {
		this.BPACrossTestData = BPACrossTestData;
		BPATest = new BPATest();
	}

	@Before
	public void initialiseCucumberTest(Scenario scenario) {
		readProperties();
		initialise(scenario.getName().replace("/", " or ").replace("\"", " "));
		this.getDriver().get(this.getBrowser().getBrowserProperties().getEnvironmentURL());
		log("Env Name:" + getEnvironment());
//		log("Env URL:" + getBrowser().getBrowserProperties().getEnvironmentURL());
		log("Env Name:" + getBrowser().getBrowserProperties().getEnvironmentName());

		this.maximiseWindow();
	}

//	@After
//	public void killBrowser(Scenario scenario) {
//		if (scenario.equals("Failed")) {
//			log("Test Failed" + scenario);
//			logScreenshot();
//		}
//		getDriver().close();
//		getDriver().quit();
//
//	}


	@Given("^user login into 'BPA' application as \"([^\"]*)\"$")
	public void userLoginIntoBPAApplicationAs(String loginUser) {
		BPAUser = UserData.valueOf(loginUser).getBPAUser();
		//	BPATest.login(BPAUser.getUserID(), BPAUser.getPassword());
		BPATest.login(BPAUser.getUserID(), "rules@123");
		logScreenshot();
	}


	@Then("^user click on New Link and then click on \"([^\"]*)\" case type$")
	public void user_click_on_New_Link_and_then_click_on_case_type(String caseType) throws InterruptedException {
		homePage = new HomePage();
		homePage.closeAllOpenCases();
		homePage.clickOnNewLink();

		if (caseType.equals("Agent Training Request")) {
			homePage.clickOnAgentTrainingRequestLink();
		}

	}


	@Then("^user submit the Request Details screen$")
	public void user_submit_the_Request_Details_screen() {

		requestDetailsPage = new RequestDetailsPage();
		String PRID = requestDetailsPage.returnTRCaseID();
		BPACrossTestData.setTRCaseID(PRID);
		requestDetailsPage.getCaseStatusDiv().verifyDivContains("New");
		logScreenshot();
		requestDetailsPage.submitTrainingRequestDetails();
		getBrowser().sleep(2000);
		logScreenshot();

	}


//	@Then("^user submit the New Or Amend POR screen$")
//	public void user_submit_the_New_Or_Amend_POR_Screens(){
//	amendOrPORPage = new AmendOrPORPage();
//	String PRID = amendOrPORPage.returnPORCaseID();
//	BPACrossTestData.setPORCaseID(PRID);
//	amendOrPORPage.getCaseStatusDiv().verifyDivContains("New");
//	logScreenshot();
//	amendOrPORPage.submitPORDetails();
//	getBrowser().sleep(2000);
//	logScreenshot();
//
//}






	@And("^user navigate to \"([^\"]*)\" Work queues and open the same TR Case$")
	public void userNavigateToWorkQueuesAndOpenTheSameTRCase(String workQueues) {
		homePage = new HomePage();
		requestDetailsPage = new RequestDetailsPage();

		if (workQueues.equals("Agent Training Request")) {
			homePage.navigateToAgentTRWorkQueues();
			log("case id is:  " + BPACrossTestData.getTRCaseID());
			homePage.clickOnCaseFilterIcon();
			homePage.getSearchTextField().enterText(BPACrossTestData.getTRCaseID());
			homePage.getApplyButton().click();
		} else if (workQueues.equals("Assigned Training Request")) {
			homePage.navigateToAssignedTRWorkQueues();
		}

		logScreenshot();

		homePage.clickSearchResult();
		getDriver().switchTo().defaultContent();
		BPATest.switchToActiveIFrame();
		getBrowser().sleep(3000);
		requestDetailsPage.getCaseStatusDiv().verifyDivContains("Pending-Assignment");
	}

	@And("^user submit the Review Request screen$")
	public void userSubmitTheReviewRequestScreen() {
		reviewRequestPage = new ReviewRequestPage();
		reviewRequestPage.submitReviewRequest();
		getDriver().switchTo().defaultContent();
		BPATest.switchToActiveIFrame();
		getBrowser().sleep(5000);
		requestDetailsPage.getCaseStatusDiv().verifyDivContains("Pending-ChildTD");

	}

	@Given("^user click on \"([^\"]*)\" from Actions menu$")
	public void user_click_on_from_Actions_menu(String menuItem){

		if (menuItem.equals("Withdraw case")) {
			BPATest.clickActionsMenu(menuItem);
			logScreenshot();

		}else if(menuItem.equals("Continue Process")){
			BPATest.clickActionsMenu(menuItem);
			logScreenshot();
		}

	}


	@And("^user submit the Continue Process screen$")
	public void userSubmitTheContinueProcessScreen() {
		continueProcessPage = new ContinueProcessPage();

		continueProcessPage.submitContinueProcess();
		getDriver().switchTo().defaultContent();
		BPATest.switchToActiveIFrame();
		getBrowser().sleep(3000);
		requestDetailsPage.getCaseStatusDiv().verifyDivContains("Resolved-Completed");


	}


	@Given("^user provide the reason and Submit the request for Withdrawal$")
	public void user_provide_the_reason_and_Submit_the_request_for_Withdrawal(){

		withdrawCasePage = new WithdrawCasePage();
		BPATest.switchToActiveIFrame();
		withdrawCasePage.enterWithdrawalReasonAndSubmit();

		BPATest.switchToActiveIFrame();
		getBrowser().sleep(3000);
		logScreenshot();
		requestDetailsPage.getCaseStatusDiv().verifyDivContains("Resolved-Withdrawn");
		logScreenshot();


	}


	@And("^user Log out from application$")
	public void userLogOutFromApplication() {
		getBrowser().sleep(2000);
		BPATest.logout();
		logScreenshot();

	}

	@Then("^Kill the browser session$")
	public void kill_the_browser_session() {
		getDriver().close();
		getDriver().quit();
	}



}
