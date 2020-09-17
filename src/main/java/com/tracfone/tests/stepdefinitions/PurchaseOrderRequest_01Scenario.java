package com.tracfone.tests.stepdefinitions;

import com.incessant.bon34.core.GenericMethods;
import com.incessant.bon34.tests.CucumberGenericTest;
import com.tracfone.data.BPACrossTestData;
import com.tracfone.data.BPAUser;
import com.tracfone.data.UserData;
import com.tracfone.pages.*;
import com.tracfone.reusablemethods.BPATest;
import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class PurchaseOrderRequest_01Scenario extends CucumberGenericTest {

    private GenericMethods genericMethods = new GenericMethods();
    private com.tracfone.data.BPAUser BPAUser;
    private com.tracfone.reusablemethods.BPATest BPATest;
    private com.tracfone.data.BPACrossTestData BPACrossTestData;
    private HomePage homePage;
    private AmendOrPORPage amendOrPORPage;
    private EnterRequestCriteriaPage enterRequestCriteriaPage;
    private LineItemPage lineItemPage;
    private JustificationAndAttachmentsPage justficationAndAttachmentsPage;
    private ContractFormPage contractFormPage;
    private ReveiwSubmitPage reveiwSubmitPage;
    private CostCenterApprovalPage costCenterApprovalPage;
    private PurchasingApprovalPage purchasingApprovalPage;
    private VPITComputeApprovalPage vpitComputeApprovalPage;
    private FixedAssetsReviewPage fixedAssetsReviewPage;

    public PurchaseOrderRequest_01Scenario(BPACrossTestData BPACrossTestData) {
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

    @Given("^user login into 'BPA Tracfone' application as \"([^\"]*)\"$")
    public void userLoginIntoBPAApplicationAs(String loginUser) {
        BPAUser = UserData.valueOf(loginUser).getBPAUser();
        //	BPATest.login(BPAUser.getUserID(), BPAUser.getPassword());
        BPATest.login(BPAUser.getUserID(), "rules@123");
        logScreenshot();
    }


    @Then("^user click on Create New Link and then click on \"([^\"]*)\" case type$")
    public void user_click_on_New_Link_and_then_click_on_case_type(String caseType) throws InterruptedException {
        homePage = new HomePage();
        homePage.closeAllOpenCases();
        homePage.clearAllRecentCase();
        homePage.clickOnNewLink();
        homePage.clickOnNewSubTaskLink(caseType);

    }

    @Then("^user submit the New Or Amend POR screen$")
    public void user_submit_the_New_Or_Amend_POR_Details_screen() {

        amendOrPORPage = new AmendOrPORPage();
        String PRID = amendOrPORPage.returnPORCaseID();
        BPACrossTestData.setPORCaseID(PRID);
        amendOrPORPage.getCaseStatusDiv().verifyDivContains("Open");
        logScreenshot();
        amendOrPORPage.submitPORDetails();
        getBrowser().sleep(2000);
        logScreenshot();

    }

    @Then("^user submit the EnterRequestCriteriaPage$")
    public void user_submit_the_EnterRequestCriteriaPage() {
        enterRequestCriteriaPage = new EnterRequestCriteriaPage();
        enterRequestCriteriaPage.submitEnterRequestDetails();

    }

    @Then("^user submit the Line Item Page$")
    public void user_submit_the_Line_Item_Page() {
        lineItemPage = new LineItemPage();
        lineItemPage.submitLineItemPage();
    }

    @Then("^user submit the JustificationAndAttachment Page$")

    public void user_submit_the_JustficationAndAttachment_Page() {
        justficationAndAttachmentsPage = new JustificationAndAttachmentsPage();
        justficationAndAttachmentsPage.submitJustificationAndAttachmentsPage();

    }

    @Then("^user submit the ContractForm Page$")
    public void user_submit_the_ContractForm_Page() {
        contractFormPage = new ContractFormPage();
        contractFormPage.submitContractFormPage();
    }

    @Then("^user submit the Review Page$")
    public void user_submit_the_Review_Page() {
        reveiwSubmitPage = new ReveiwSubmitPage();
        reveiwSubmitPage.submitReveiwPage();
        getDriver().switchTo().defaultContent();
        BPATest.switchToActiveIFrame();
        getBrowser().sleep(5000);
       // amendOrPORPage.getCaseID();
       // amendOrPORPage.getCaseStatusDiv().verifyDivContains("Pending-CostCenterApproval");
    }

    @And("^user click on Approval from ActionMenu and submit CostCenterApproval Page$")
    public void user_click_on_Approval_from_ActionMenu_and_submit_CostCenterApproval_Page() {
        amendOrPORPage = new AmendOrPORPage();
        String PRID = amendOrPORPage.returnPORCaseID();
        BPACrossTestData.setPORCaseID(PRID);
        amendOrPORPage.getCaseStatusDiv().verifyDivContains("Pending-CostCenterApproval");
        costCenterApprovalPage = new CostCenterApprovalPage();
        costCenterApprovalPage.submitCostCenterApprovalPage();
        getDriver().switchTo().defaultContent();
        BPATest.switchToActiveIFrame();
        getBrowser().sleep(5000);
        //amendOrPORPage.getCaseStatusDiv().verifyDivContains("Pending-PurchasingApproval");

    }

    @And("^user click on Approval from ActionMenu and submit Pending Purchasing Approval$")
    public void user_click_on_Approve_and_submit_PendingPurchasing_Approval_from_Actions_Menu() {
        amendOrPORPage = new AmendOrPORPage();
        String PRID = amendOrPORPage.returnPORCaseID();
        BPACrossTestData.setPORCaseID(PRID);
        amendOrPORPage.getCaseStatusDiv().verifyDivContains("Pending-PurchasingApproval");
        purchasingApprovalPage = new PurchasingApprovalPage();
        purchasingApprovalPage.submitPurchasingApprovalPage();
        getDriver().switchTo().defaultContent();
        getBrowser().sleep(5000);
    }

    @And("^user click on Approval from ActionMenu and submit VPITCompute Approval$")
    public void user_click_on_Approve_and_submit_VPITCompute_Approval_from_Actions_Menu() {
        amendOrPORPage = new AmendOrPORPage();
        String PRID = amendOrPORPage.returnPORCaseID();
        BPACrossTestData.setPORCaseID(PRID);
        amendOrPORPage.getCaseStatusDiv().verifyDivContains("Pending-VPITComputeApproval");
        vpitComputeApprovalPage = new VPITComputeApprovalPage();
        vpitComputeApprovalPage.submitVPITComputeApprovalPage();

    }

    @And("^user click on FixedAssets from ActionMenu and submit FixedAssetsReview$")
    public void user_click_on_FixedAssets_from_ActionMenu_and_submit_FixedAssetsReview(){
        fixedAssetsReviewPage = new FixedAssetsReviewPage();
        fixedAssetsReviewPage.submitFixedAssetsReviewPage();

    }

    @Then("^user verify the status as ResolvedCompleted$")
    public void user_verify_the_status_as_ResolvedCompleted()
    {
        amendOrPORPage = new AmendOrPORPage();
        String PRID = amendOrPORPage.returnPORCaseID();
        BPACrossTestData.setPORCaseID(PRID);
        amendOrPORPage.getCaseStatusDiv().verifyDivContains("Resolved-Completed");
        getDriver().switchTo().defaultContent();
        BPATest.switchToActiveIFrame();
        getBrowser().sleep(5000);

    }
}