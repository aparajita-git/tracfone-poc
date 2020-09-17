package com.tracfone.pages;

import com.incessant.bon34.controls.*;
import com.tracfone.reusablemethods.BPATest;
import org.openqa.selenium.By;

public class ContinueProcessPage extends Control {

    //Object
    private ContinueProcessPage servicePage;
	private BPATest BPATest;
	// Variables



	private Button yesContinueButton;


	// Getters


	public Button getYesContinueButton() {
		return yesContinueButton;
	}

	// Screen Objects
	public ContinueProcessPage() {

		yesContinueButton = new Button(By.xpath("//button[@data-test-id='2014121801251706289770']"));

	}



	// Test Methods
	public void submitContinueProcess()  {

		BPATest = new BPATest();
		getBrowser().sleep(2000);
		BPATest.switchToActiveIFrame();
		yesContinueButton.click();



	}




	
}
                         