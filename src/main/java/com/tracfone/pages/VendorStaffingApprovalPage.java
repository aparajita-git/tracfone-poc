package com.tracfone.pages;

import com.incessant.bon34.controls.Button;
import com.incessant.bon34.controls.Control;
import com.tracfone.reusablemethods.BPATest;
import org.openqa.selenium.By;

public class VendorStaffingApprovalPage extends Control {

    //Object
    private VendorStaffingApprovalPage vendorStaffingApprovalPage;
    private BPATest BPATest;

    //Variable

    private Button actionButton;
    private Button approvalButton;
    private Button approveButton;

    //Getter
    public Button getActionButton(){return actionButton;}
    public Button getApprovalButton(){return approvalButton;}
    public Button getApproveButton(){return approveButton;}

    //Screen Object

    public VendorStaffingApprovalPage() {

        actionButton = new Button(By.xpath("//button[@data-test-id=\"20141009112850013521365\"]"));
        approvalButton = new Button(By.xpath("//li[@data-test-id=\"201711020911150171330_1\"]"));
        approveButton = new Button(By.xpath("//button[@data-test-id=\"201410290229040300882\"]"));

    }
    //method
}
