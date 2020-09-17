package com.tracfone.pages;

import com.incessant.bon34.controls.*;
import com.tracfone.data.ContractFormData;
import com.tracfone.reusablemethods.BPATest;
import com.tracfone.testdatamanager.BPATestData;
import org.openqa.selenium.By;

public class ContractFormPage extends Control {


    private ContractFormPage contractFormPage;
    private ContractFormData contractFormData;
    private BPATestData BPATestData;
    private BPATest BPATest;

    //Object
    private RadioButton contractRadioButton;
    private Button continueButton;


    public RadioButton getContractRadioButton(){return contractRadioButton;}
    public Button getContinueButton(){return continueButton;}


    //Screen Object
    public ContractFormPage() {

        contractRadioButton = new RadioButton((By.xpath("//label[@class=\"rb_ rb_standard radioLabel\"][contains(text(),'No')]")));
        continueButton = new Button(By.xpath("//button[@data-test-id=\"20161017110917023176385\"]"));
    }

    public void submitContractFormPage()
    {
        BPATest = new BPATest();
        contractRadioButton.click();
        getBrowser().sleep(2000);
        continueButton.click();
    }

}


