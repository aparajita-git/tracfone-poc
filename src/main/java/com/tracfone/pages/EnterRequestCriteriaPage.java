package com.tracfone.pages;

import com.incessant.bon34.controls.*;
import com.tracfone.data.EnterRequestCriteriaData;
import com.tracfone.reusablemethods.BPATest;
import com.tracfone.testdatamanager.BPATestData;
import org.openqa.selenium.By;

public class EnterRequestCriteriaPage extends Control {


    private EnterRequestCriteriaPage enterRequestCriteriaPage;
    private BPATest BPATest;
    private BPATestData BPATestData;
    private EnterRequestCriteriaData enterRequestCriteria;


    //Object

    private RadioButton previousPurchaseOrderRadioButton;
    private RadioButton isThisPORrelatedToProject;
    private RadioButton willPurchaseBeMadeWithACorporateCreditCard;
    private RadioButton iSThisAnExpenseYouWouldLikeReimbursement;
    private RadioButton isExistingVendorYes;
    private Dropdown departmentDropdown;
    private Dropdown requestTypeDropdown;
    private Dropdown shipToLocationDropdown;
    private AutoComplete vendorAutoComplete;
    private TextField vendorNameTextField;
    private TextField vendoeEmaiAddressTextField;
    private Dropdown costCenterDropdown;
    private TextField shortDescriptionTextField;
    private Button clickContinue;

    public Dropdown getRequestTypeDropdown() {
        return requestTypeDropdown;
    }


    public AutoComplete getVendorAutoComplete(){
        return vendorAutoComplete;
    }

    public TextField getVendoeEmaiAddressTextField(){
        return vendoeEmaiAddressTextField;
    }

    public TextField getVendorNameTextField(){
        return vendorNameTextField;
    }

    public TextField getshortDescriptionTextField(){
        return shortDescriptionTextField;
    }


    public RadioButton getisExistingVendor() {
        return isExistingVendorYes;
    }

    public Dropdown getDepartmentDropdown(){
        return departmentDropdown;
    }

    public Dropdown getCostCenterDropdown(){
        return costCenterDropdown;
    }

    public Button getclickContinue() {
        return clickContinue;
    }




//Screen Object
public EnterRequestCriteriaPage() {

//-----------------ENTER REQUEST CRITERIA:----------------------------------------------
    requestTypeDropdown = new Dropdown(By.xpath("//select[@data-test-id=\"201905302341520427251136\"]"));
    requestTypeDropdown.addValue("Select...","Select...");
    //requestTypeDropdown.addValue("Fixed Bid Consultant", "Fixed Bid Consultant");
       requestTypeDropdown.addValue("Hardware/Software Purchase","Hardware/Software Purchase");
//        requestTypeDropdown.addValue("Consultant","Consultant");
//        requestTypeDropdown.addValue("Property Holdings","Property Holdings");
//        requestTypeDropdown.addValue("Regular Purchase","Regular Purchase");

    costCenterDropdown = new Dropdown(By.xpath("//select[@data-test-id=\"201905302341520427253558\"]"));
    costCenterDropdown.addValue("Select...","Select...");
    costCenterDropdown.addValue("210", "ACCOUNTING - 210");

    departmentDropdown = new Dropdown(By.xpath("//select[@id=\"831e565d\"]"));
    departmentDropdown.addValue("Select...","Select...");
    departmentDropdown.addValue("ACCT", "ACCT");
    shipToLocationDropdown = new Dropdown(By.xpath("//input[@data-test-id=\"201905302341520427253558\"]"));
    shipToLocationDropdown.addValue("TF_HQ", "TF_HQ");

    shortDescriptionTextField = new TextField(By.xpath("//input[@data-test-id='20200116165450027568383']"));
    isExistingVendorYes = new RadioButton(By.xpath("//input[@id='5ab78971true']"));
    vendorAutoComplete = new AutoComplete(By.xpath("//input[@data-test-id=\"201905302341520428262326\"]"));
    vendorNameTextField = new TextField(By.xpath("//input[@id=\"6b1e3156\"]"));
    vendoeEmaiAddressTextField = new TextField(By.xpath("//input[@id=\"0b46630f\"]"));
    clickContinue = new Button(By.xpath("//button[@data-test-id=\"20161017110917023176385\"]"));
//         isExistingVendorNo
//         nameTextField
//         nameContactTextField
//         emailTextField
//         phoneNumberTextField

//vendorField
//emailAddressTextField = new TextField(By.xpath(""))
}

   public void submitEnterRequestDetails()
   {
       BPATest = new BPATest();
       enterRequestCriteria = BPATestData.getRequestCriteriaDetails();
       getBrowser().sleep(1000);
       BPATest.switchToActiveIFrame();
       shortDescriptionTextField.enterText(enterRequestCriteria.getShortDescription());
       shortDescriptionTextField.isControlMandatory();
       getBrowser().sleep(500);
       waitForElementToBeClickable(getRequestTypeDropdown().getSelector());
       requestTypeDropdown.selectFromDropdownByText(enterRequestCriteria.getRequestType());
       waitForElementToBeClickable(getDepartmentDropdown().getSelector());
       departmentDropdown.selectFromDropdownByText(enterRequestCriteria.getDepartment());
       getBrowser().sleep(3000);
       waitForElementToBeClickable(getCostCenterDropdown().getSelector());
       costCenterDropdown.selectFromDropdownByText(enterRequestCriteria.getCostCenter());
       getBrowser().sleep(2000);
      // brandAutoComplete.enterTextThenSelectFromAutoComplete(requestDetails.getBrand());
       vendorAutoComplete.enterTextThenSelectFromAutoComplete(enterRequestCriteria.getVendor());
    //waitForElementToBeClickable(getVendorTextField().getSelector());
        //vendorTextField.enterText(enterRequestCriteria.getVendor());
       getBrowser().sleep(3000);

       //vendorTextField.enterText("1010DATA SERVICES LLC");
       //vendorTextField.waitForElementToBeClickable(getVendorTextField().getSelector());
        vendorNameTextField.enterText(enterRequestCriteria.getVendorName());

       vendoeEmaiAddressTextField.enterText(enterRequestCriteria.getVendorEmailAddress());
       clickContinue.click();








   }
}