package com.tracfone.pages;

import com.incessant.bon34.controls.Control;
import com.incessant.bon34.controls.*;
import com.tracfone.data.RequestDetailsData;
import com.tracfone.reusablemethods.BPATest;
import com.tracfone.testdatamanager.BPATestData;
import org.openqa.selenium.By;

import javax.sound.sampled.LineUnavailableException;

/**
 * This class is to capture Screen object of Request Details Page
 * @author Mohan.Akula
 */
public class RequestDetailsPage extends Control {

    //Object
    private RequestDetailsPage requestDetailsPage;
    private BPATest BPATest;
    private RequestDetailsData requestDetails;
    private BPATestData BPATestData;





	// Variables


	private TextField shortDescriptionTextField;

	private RadioButton  temporaryChangeYesRadioButton;
	private RadioButton  temporaryChangeNoRadioButton;
	private AutoComplete brandAutoComplete;
	private Link selectAllLink;
	private Link clearAllLink;


	private Dropdown requestTypeDropdown;
	private Dropdown priorityDropdown;
	private TextField expectedReleaseDateTextField;


	private Button addButton;

	private TextField reasonForRequestTextField;
	private Button attachFileButton;
	private Button selectButton;
	private Button attachButton;
	private Button submitButton;

	private Div caseIDDiv;
	private Div caseStatusDiv;




	// Getters


	public TextField getShortDescriptionTextField() {
		return shortDescriptionTextField;
	}

	public RadioButton getTemporaryChangeYesRadioButton() {
		return temporaryChangeYesRadioButton;
	}

	public RadioButton getTemporaryChangeNoRadioButton() {
		return temporaryChangeNoRadioButton;
	}

	public AutoComplete getBrandAutoComplete() {
		return brandAutoComplete;
	}

	public Link getSelectAllLink() {
		return selectAllLink;
	}

	public Link getClearAllLink() {
		return clearAllLink;
	}

	public Dropdown getRequestTypeDropdown() {
		return requestTypeDropdown;
	}

	public Dropdown getPriorityDropdown() {
		return priorityDropdown;
	}

	public TextField getExpectedReleaseDateTextField() {
		return expectedReleaseDateTextField;
	}

	public Button getAddButton() {
		return addButton;
	}

	public TextField getReasonForRequestTextField() {
		return reasonForRequestTextField;
	}

	public Button getAttachFileButton() {
		return attachFileButton;
	}


	public Button getSelectButton() {
		return selectButton;
	}

	public Button getAttachButton() {
		return attachButton;
	}

	public Button getSubmitButton() {
		return submitButton;
	}

	public Div getCaseIDDiv() {
		return caseIDDiv;
	}

	public Div getCaseStatusDiv() {
		return caseStatusDiv;
	}

	// Screen Objects
	public RequestDetailsPage() {

		shortDescriptionTextField = new TextField(By.xpath("//input[@id= 'c74f0970']"));
		temporaryChangeYesRadioButton = new RadioButton(By.xpath("//input[@id='TemporaryChangetrue']"));
		temporaryChangeNoRadioButton = new RadioButton(By.xpath("//input[@id='TemporaryChangefalse']"));
		brandAutoComplete = new AutoComplete(By.xpath("//input[@id='12604286']"));
		selectAllLink = new Link(By.xpath("//a[@name= 'RequestDetailsMain_pyWorkPage_14']"));
		clearAllLink = new Link(By.xpath("//a[@name='RequestDetailsMain_pyWorkPage_16']"));
		reasonForRequestTextField = new TextField(By.xpath("//textarea[@id='2467bdaa']"));
		attachFileButton = new Button(By.xpath("//button[@name='EnterRequestDetails_pyWorkPage_27']"));
		selectButton = new Button(By.xpath("//input[@id= '$PpyAttachmentPage$ppxAttachName']"));
		attachButton = new Button(By.xpath("//button[@id= 'ModalButtonSubmit']"));
		requestTypeDropdown = new Dropdown(By.xpath("//select[@id='f41d82d7']"));
		requestTypeDropdown.addValue("Select...","Select...");
		requestTypeDropdown.addValue("Training Flash","Training Flash");
		requestTypeDropdown.addValue("Job Aids","Job Aids");
		requestTypeDropdown.addValue("Training Manuals","Training Manuals");
		requestTypeDropdown.addValue("Reference guides","Reference guides");
		requestTypeDropdown.addValue("Videos","Videos");
		requestTypeDropdown.addValue("Announcements","Announcements");
		priorityDropdown = new Dropdown(By.xpath("//select[@id= '282dad3a']"));
		priorityDropdown.addValue("Select...","Select...");
		priorityDropdown.addValue("High","High");
		priorityDropdown.addValue("Medium","Medium");
		priorityDropdown.addValue("Low","Low");
		expectedReleaseDateTextField = new TextField(By.xpath("//input[@id= '5aa6eca8']"));
		addButton = new Button(By.xpath("//button[@name='EnterRequestDetails_pyWorkPage_39']"));
		submitButton = new Button(By.xpath("//button[@title= 'Complete this assignment']"));
		caseIDDiv = new Div(By.xpath("//span[@class= 'workarea_header_id']"));
		caseStatusDiv = new Div(By.xpath("//div[@node_name= 'pyCaseBadges']"));

	}

	//New Or Amend POR Screen Objects

	//public AmendOrPORPage()
	//{

	//}
// This method is to submit the POR details
	public void submitPORDetails() {
	}


	// Test Methods

	/**
	 * This method is to submit the Request Details Screen
	 *
	 */
	public void submitTrainingRequestDetails() {
		BPATest = new BPATest();
		requestDetails = BPATestData.getTrainingRequestDetails();
		getBrowser().sleep(1000);
		BPATest.switchToActiveIFrame();
		shortDescriptionTextField.enterText(requestDetails.getShortDescription());
		shortDescriptionTextField.isControlMandatory();
		getBrowser().sleep(2000);
		temporaryChangeNoRadioButton.click();
		//selectAllLink.click();
		//getBrowser().sleep(2000);
		//clearAllLink.click();
		getBrowser().sleep(500);
		brandAutoComplete.enterTextThenSelectFromAutoComplete(requestDetails.getBrand());
		getBrowser().sleep(500);
		brandAutoComplete.enterTextThenSelectFromAutoComplete("Tracfone");
		getBrowser().sleep(100);
		tab();
		reasonForRequestTextField.enterText(requestDetails.getReasonForRequest());
		getBrowser().sleep(500);
		attachFileButton.click();
		getBrowser().sleep(2000);
	    getDriver().findElement(By.xpath("//input[@id= '$PpyAttachmentPage$ppxAttachName']")).sendKeys((System.getProperty("user.dir")+"\\Documents\\SupportingDocument.txt" ));
		getBrowser().sleep(5000);
		attachButton.click();
		getBrowser().sleep(5000);
		waitForElementToBeClickable(getRequestTypeDropdown().getSelector());
		requestTypeDropdown.selectFromDropdown(requestDetails.getRequestType());
		priorityDropdown.selectFromDropdown(requestDetails.getPriority());
		getBrowser().sleep(2000);
		expectedReleaseDateTextField.enterText(requestDetails.getExpectedReleaseDate());
		getBrowser().sleep(2000);
		addButton.click();
		getBrowser().sleep(100);
		submitButton.click();
	}

	/**
	 * This method is to capture TR Case ID
	 * @return TR Case ID
	 * @throws InterruptedException
	 */
	public String returnTRCaseID() {
		getBrowser().sleep(2000);
		BPATest = new BPATest();
		getDriver().switchTo().defaultContent();
		BPATest.switchToActiveIFrame();
		String TRcaseID = getCaseIDDiv().getElement().getText();
		TRcaseID = TRcaseID.replace("(", "").replace(")", "");
		log("The created TR Case ID is :" +TRcaseID);
		return TRcaseID;
	}

	public String returnPORCaseID(){
		getBrowser().sleep(2000);
		BPATest = new BPATest();
		getDriver().switchTo().defaultContent();
		BPATest.switchToActiveIFrame();
		String PORCaseID = getCaseIDDiv().getElement().getText();
		PORCaseID = PORCaseID.replace("(", "").replace(")", "");
		log("The created POR Case ID is :" +PORCaseID);
		return PORCaseID;

	}



}
                         