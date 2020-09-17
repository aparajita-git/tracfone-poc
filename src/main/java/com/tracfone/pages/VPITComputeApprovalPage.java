package com.tracfone.pages;

import com.incessant.bon34.controls.Button;
import com.incessant.bon34.controls.Control;
import com.tracfone.reusablemethods.BPATest;
import org.openqa.selenium.By;

public class VPITComputeApprovalPage extends Control {

    //object
    private BPATest BPATest;
    private VPITComputeApprovalPage vpitComputeApprovalPage;

    //Variable
    private Button actionButton;
    private Button approvalButton;
    private Button approveButton;


    //Getter

    public Button getActionButton() {
        return actionButton;
    }

    public Button getApproveButton() {
        return approveButton;
    }

    public Button getApprovalButton() {
        return approvalButton;
    }

    //Screen Object
    public VPITComputeApprovalPage() {
        actionButton = new Button(By.xpath("//button[@title='Actions']"));
        approvalButton = new Button(By.xpath("//li[@data-test-id=\"201711020911150171330_1\"]"));
        approveButton = new Button(By.xpath("//button[@data-test-id=\"201410290229040300882\"]"));

    }
    //method
    public void submitVPITComputeApprovalPage(){
        BPATest = new BPATest();
        getBrowser().sleep(1000);
        BPATest.switchToActiveIFrame();
        getBrowser().sleep(3000);
        actionButton.click();
        approvalButton.click();
        approveButton.click();
    }

}
