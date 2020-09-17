package com.tracfone.pages;

import com.incessant.bon34.controls.*;
import com.tracfone.data.ReviewRequestData;
import com.tracfone.reusablemethods.BPATest;
import com.tracfone.testdatamanager.BPATestData;
import org.openqa.selenium.By;

public class ReviewRequestPage extends Control {

    //Object
    private ReviewRequestPage reviewRequestPage;
    private BPATest BPATest;
    private ReviewRequestData reviewRequest;

    // Variables

    private TextField deliveryDateTextField;
    private Dropdown assigneeDropdown;

    private Button submitButton;


    // Getters


    public TextField getDeliveryDateTextField() {
        return deliveryDateTextField;
    }

    public Dropdown getAssigneeDropdown() {
        return assigneeDropdown;
    }

    public Button getSubmitButton() {
        return submitButton;
    }

    // Screen Objects
    public ReviewRequestPage() {


        deliveryDateTextField = new TextField(By.xpath("//input[@id= '582104ad']"));
        assigneeDropdown = new Dropdown(By.xpath("//select[@id= '5cd6c55e']"));
        assigneeDropdown.addValue("TDTestManager", "TD Test Manager");
        submitButton = new Button(By.xpath("//button[@title= 'Complete this assignment']"));
    }


    // Test Methods
    public void submitReviewRequest() {
        BPATest = new BPATest();
        reviewRequest = BPATestData.getReviewRequestDetails();
        getDriver().switchTo().defaultContent();
        getBrowser().sleep(2000);
        BPATest.switchToActiveIFrame();
        deliveryDateTextField.enterText(reviewRequest.getDeliveryDate());
        getBrowser().sleep(2000);
        assigneeDropdown.selectFromDropdown(reviewRequest.getAssignee());
        getBrowser().sleep(2000);
        submitButton.click();
    }


}
                         