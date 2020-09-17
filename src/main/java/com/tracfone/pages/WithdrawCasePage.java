package com.tracfone.pages;

import com.incessant.bon34.controls.*;
import com.tracfone.data.WithdrawCaseData;
import com.tracfone.testdatamanager.BPATestData;
import org.openqa.selenium.By;

/**
 * This class is to capture Screen object of Service Page
 * @author Mohan.Akula
 */
public class WithdrawCasePage extends Control {

    //Object
    private WithdrawCasePage withdrawCasePage;
    private WithdrawCaseData withdrawCase;


	// Variables

	private TextField reasonsForWithdrawalTextField ;
	private Button submitButton;

	// Getters



	public Button getSubmitButton() {
		return submitButton;
	}

	// Screen Objects
	public WithdrawCasePage() {

	reasonsForWithdrawalTextField = new TextField(By.xpath("//textarea[@id= 'b87193b6']"));
	submitButton = new Button(By.xpath("//button[@title= 'Complete this assignment']"));

	}

	// Test Methods

	public void enterWithdrawalReasonAndSubmit(){
		withdrawCase = BPATestData.getWithdrawReason();
		reasonsForWithdrawalTextField.enterText(withdrawCase.getReasonsForWithdrawal());
		reasonsForWithdrawalTextField.isControlMandatory();
		log("Mandatory Check Is Happening....!! ");
		logScreenshot();
		submitButton.click();

	}
}
                         