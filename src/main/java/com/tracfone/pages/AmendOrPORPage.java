package com.tracfone.pages;

import com.incessant.bon34.controls.Control;
import com.incessant.bon34.controls.*;
import com.tracfone.reusablemethods.BPATest;
import com.tracfone.testdatamanager.BPATestData;
import org.openqa.selenium.By;

import javax.sound.sampled.LineUnavailableException;

/**
 * This class is to capture Screen object of POR Details Page
 * @author Aparajita Pattanaik
 */
public class AmendOrPORPage extends Control {

    //Object
    private AmendOrPORPage amendOrPORPage;
    private BPATest BPATest;
    private BPATestData BPATestData;


    // Variables


    private TextField shortDescriptionTextField;

    // private RadioButton  temporaryChangeYesRadioButton;


    private Dropdown costCenterDropdown;
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
    private Button clickContinue;
    private RadioButton previousPurchaseOrderRadioButton;
    private RadioButton isThisPORrelatedToProject;
    private RadioButton willPurchaseBeMadeWithACorporateCreditCard;
    private RadioButton iSThisAnExpenseYouWouldLikeReimbursement;

    private Div caseIDDiv;
    private Div caseStatusDiv;



    // Getters


    public TextField getShortDescriptionTextField() {
        return shortDescriptionTextField;
    }

//    public RadioButton getTemporaryChangeYesRadioButton() {
//        return temporaryChangeYesRadioButton;
//    }

    public RadioButton getisThisPORrelatedToProject() {
        return isThisPORrelatedToProject;
    }

    public RadioButton getwillPurchaseBeMadeWithACorporateCreditCard() {
        return willPurchaseBeMadeWithACorporateCreditCard;
    }

    public RadioButton getiSThisAnExpenseYouWouldLikeReimbursement() {
        return iSThisAnExpenseYouWouldLikeReimbursement;
    }
    public RadioButton getpreviousPurchaseOrderRadioButton(){
        return previousPurchaseOrderRadioButton;
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

    public Dropdown getCostCenterDropdown() {
        return costCenterDropdown;
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
    public AmendOrPORPage() {


        //-----------------INITIAL CRITERIA----------------------------------------------

        previousPurchaseOrderRadioButton = new RadioButton(By.xpath("//label[@class=\"rb_ rb_standard radioLabel\"][contains(text(),'No')]"));
        isThisPORrelatedToProject = new RadioButton(By.xpath("//div[@aria-label=\"Is this POR related to a Project?\"]//label[contains(text(),'No')]"));
        willPurchaseBeMadeWithACorporateCreditCard = new RadioButton(By.xpath("//div[@aria-label=\"Will this purchase be made with a corporate Credit Card?\"]//label[contains(text(),'No')]"));
        iSThisAnExpenseYouWouldLikeReimbursement = new RadioButton(By.xpath("//div[@aria-label=\"Is this an Expense you would like to be reimbursed for ?\"]//label[contains(text(),'No')]"));
        submitButton = new Button(By.xpath("//button[contains(text(),'Submit')]"));
        clickContinue = new Button(By.xpath("//button[@data-test-id=\"20161017110917023176385\"]"));
        caseIDDiv = new Div(By.xpath("//span[@class= 'workarea_header_id']"));
        caseStatusDiv = new Div(By.xpath("//div[@node_name= 'pyCaseBadges']"));




//        //----------------------LINE ITEMS---------------------------
//        addItemButton = new TextField(By.xpath("//a[@data-test-id=\"2015071603054009744126\"]"));
//        desciptionField = new TextField(By.xpath("//input[@data-test-id='2016072109335505834280']"));
        // quanityField = new Te
        // priceField
        // partPURDropdown
        // genralLedgerDropdown

        //----------------JUSTIFICATION and ATTACHMENTS-------------------


        //-----------------CONTRACT FORM--------------------


        //---------------REVIEW  & SUBMIT-----------------


        caseIDDiv = new Div(By.xpath("//span[@class= 'workarea_header_id']"));
        caseStatusDiv = new Div(By.xpath("//div[@node_name= 'pyCaseBadges']"));
        costCenterDropdown = new Dropdown(By.xpath("//select[@data-test-id=\"201905302341520427253558\"]"));
        costCenterDropdown.addValue("","");

    }
// This method is for POR case ID
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

    //New Or Amend POR Screen Objects

    //public AmendOrPORPage()
    //{

    //}
// This method is to submit the POR details
    //Screen Object
    public void submitPORDetails() {

         BPATest = new BPATest();
       // BPATest.switchToActiveIFrame();
        getBrowser().sleep(2000);
        previousPurchaseOrderRadioButton.click();
        isThisPORrelatedToProject.click();
        willPurchaseBeMadeWithACorporateCreditCard.click();
        iSThisAnExpenseYouWouldLikeReimbursement.click();
        submitButton.click();
        clickContinue.click();




       // amendOrPORPageDetails = BPATestData.getAmendOrPORPageDetailsData();
    }



}


        // Test Methods

        /**
         * This method is to submit the NewAmend or POR Details Screen
         *
         */
// This method is to submit the POR details
