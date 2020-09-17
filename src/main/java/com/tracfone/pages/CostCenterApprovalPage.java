package com.tracfone.pages;

import com.incessant.bon34.controls.Button;
import com.incessant.bon34.controls.Control;
import com.tracfone.reusablemethods.BPATest;
import org.openqa.selenium.By;

public class CostCenterApprovalPage extends Control {

    //object
    private CostCenterApprovalPage costCenterApprovalPage;
    private BPATest BPATest;
    //variable
    private Button actionButton;
    private Button approvalButton;
    private Button approveButton;
    //Getter

    public Button getActionButton() {
        return actionButton;
    }

    public Button getApprovalButton() {
        return approvalButton;
    }

    public Button getApproveButton() {
        return approveButton;
    }

    //screen objects

    public CostCenterApprovalPage() {

        actionButton = new Button(By.xpath("//button[@data-test-id=\"2014100911285001362285\"]"));
        approvalButton = new Button(By.xpath("//li[@data-test-id=\"201711020911150171330_1\"]"));
        approveButton = new Button(By.xpath("//button[@data-test-id=\"201410290229040300882\"]"));
    }

     public void submitCostCenterApprovalPage(){

        actionButton.click();
        getBrowser().sleep(1000);
        approvalButton.click();
        getBrowser().sleep(1000);
        approveButton.click();

     }



}


