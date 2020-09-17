package com.tracfone.pages;

import com.incessant.bon34.controls.Button;
import com.incessant.bon34.controls.Control;
import com.incessant.bon34.controls.TextField;
import com.tracfone.reusablemethods.BPATest;
import com.tracfone.testdatamanager.BPATestData;
import org.openqa.selenium.By;


public class PurchasingApprovalPage extends Control {

    //object
    private PurchasingApprovalPage purchasingApprovalPage;
    private BPATest BPATest;
    private BPATestData BPATestData;
    private AmendOrPORPage amendOrPORPage;


    //variable

    private Button actionButton;
    private Button approvalButton;
    private Button approveButton;
    private Button yesRadioButton;
    private TextField conclusionTextField;


    //getter

    public Button getActionButton() {
        return actionButton;
    }

    public Button getApprovalButton() {
        return approvalButton;
    }

    public Button getApproveButton(){
        return approveButton;
    }

    public Button getYesRadioButton(){
        return yesRadioButton;
    }

    public TextField getConclusionTextField(){
        return conclusionTextField;
    }

    //screenobject
    public PurchasingApprovalPage() {
       // actionButton = new Button(By.xpath("[//button[@data-test-id=\"2014100911285001362285\"]"));
        actionButton = new Button(By.xpath("//button[contains(text(),'Actions')]"));
        approvalButton = new Button(By.xpath("//li[@data-test-id=\"201711020911150171330_1\"]"));
        approveButton = new Button(By.xpath("//button[@data-test-id=\"201410290229040300882\"]"));
        yesRadioButton = new Button(By.xpath("//div[@aria-label=\"Did Purchasing review three independently sourced bids?\"]//label[contains(text(),'Yes')]"));
        conclusionTextField= new TextField(By.xpath("//textarea[@id=\"50b9dd0e\"]"));
    }

    //method

    public void submitPurchasingApprovalPage(){

        getBrowser().sleep(3000);
        actionButton.click();
        getBrowser().sleep(1000);
        approvalButton.click();
        getBrowser().sleep(2000);
        yesRadioButton.click();
        getBrowser().sleep(1000);
        conclusionTextField.enterText("abcd");
        getBrowser().sleep(2000);
        approveButton.click();

    }


}
