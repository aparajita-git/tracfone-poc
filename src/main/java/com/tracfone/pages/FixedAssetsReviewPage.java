package com.tracfone.pages;

import com.incessant.bon34.controls.Button;
import com.incessant.bon34.controls.Control;
import com.incessant.bon34.controls.TextField;
import com.tracfone.reusablemethods.BPATest;
import com.tracfone.testdatamanager.BPATestData;
import org.openqa.selenium.By;

public class FixedAssetsReviewPage extends Control {

    //object
    private BPATest BPATest;
    private BPATestData BPATestData;
    private FixedAssetsReviewPage fixedAssetsReviewPage;

    //variable
    private Button actionButton;
    private Button resolveCaseButton;
    private TextField reasonForResolveTextField;
    private Button submitButton;

    //getter

    public Button getActionButton() {
        return actionButton;
    }

    public Button getResolveCaseButton() {
        return resolveCaseButton;
    }

    public TextField getReasonForResolveTextField() {
        return reasonForResolveTextField;
    }

    public Button getSubmitButton() {
        return submitButton;
    }


    //screen object
    public FixedAssetsReviewPage() {
        actionButton = new Button(By.xpath("//button[@title=\"Actions\"]"));
        resolveCaseButton = new Button(By.xpath("//li[@title=\"Resolve case\"]"));
        reasonForResolveTextField = new TextField(By.xpath("//textarea[@data-test-id=\"2019102109065503377649\"]"));
        submitButton = new Button(By.xpath("//button[@data-test-id=\"2014121801251706289770\"]"));
    }

    //method.

    public void submitFixedAssetsReviewPage() {
        BPATest = new BPATest();
        getBrowser().sleep(1000);
        BPATest.switchToActiveIFrame();
        getBrowser().sleep(3000);
        actionButton.click();
        getBrowser().sleep(2000);
        resolveCaseButton.click();
        reasonForResolveTextField.enterText("abcd");
        submitButton.click();
    }

}

