package com.tracfone.pages;

import com.incessant.bon34.controls.Button;
import com.incessant.bon34.controls.Control;
import com.incessant.bon34.core.GenericMethods;
import com.tracfone.reusablemethods.BPATest;
import org.openqa.selenium.By;
public class ReveiwSubmitPage extends Control {

    //object
    private GenericMethods genericMethods = new GenericMethods();
    private  ReveiwSubmitPage reviewSubmitPage;
    private BPATest BPATest;
    private AmendOrPORPage amendOrPORPage;


    //Varibale Declartion
    private Button finishButton;

    //Getter

    public Button getFinishButton(){return finishButton;}

    //ScreenObject
    public ReveiwSubmitPage() {
          finishButton = new Button(By.xpath("//button[@data-test-id=\"20161017110917023277518\"]"));
    }

    public void submitReveiwPage()
    {
        getBrowser().sleep(1000);
        finishButton.click();
//        getBrowser().sleep(2000);
//
    }
}
