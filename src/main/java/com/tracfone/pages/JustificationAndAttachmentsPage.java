package com.tracfone.pages;

import com.incessant.bon34.controls.Button;
import com.tracfone.data.JustificationAndAttachmentData;
import com.incessant.bon34.controls.Control;
import com.incessant.bon34.controls.*;
import com.tracfone.reusablemethods.BPATest;
import com.tracfone.testdatamanager.BPATestData;
import org.openqa.selenium.By;
import com.incessant.bon34.controls.TextField;



public class JustificationAndAttachmentsPage extends Control {


    //Object
    private JustificationAndAttachmentsPage justificationAndAttachmentsPage;
    private JustificationAndAttachmentData justificationAndAttachmentsData;
    private BPATest BPATest;
    private BPATestData BPATestData;


    //Variables


    private TextField whatSummaryofProductorServiceTextfield;
    private TextField whyDoesTFNeedThisProductOrServiceNowTextField;
    private TextField whoDoesTFHaveMultipleVendorsThatOfferTextField;
    private TextField ifFPurchasingWasNotInvolvedInTheNegotiationsTextField;
    private Button attachFileButton;
    private Button attachButton;
    private Button continueButton;

    //Getter

    private Button getContinueButton(){return continueButton;}

    public Button getAttachFileButton(){return attachFileButton;}

    public Button getAttachButton(){return attachButton;}

    public TextField getWhatSummaryofProductorServiceTextfield() {
        return whatSummaryofProductorServiceTextfield;
    }

    public TextField getWhyDoesTFNeedThisProductOrServiceNowTextField() {
        return whyDoesTFNeedThisProductOrServiceNowTextField;
    }

    public TextField getWhoDoesTFHaveMultipleVendorsThatOfferTextField() {
        return whoDoesTFHaveMultipleVendorsThatOfferTextField;
    }

    public TextField getIfPurchasingWasNotInvolvedInTheNegotiationsTextField() {
        return ifFPurchasingWasNotInvolvedInTheNegotiationsTextField;
    }


    //Constructor

    //Screen Object
    public JustificationAndAttachmentsPage() {
        whatSummaryofProductorServiceTextfield = new TextField(By.xpath("//textarea[@data-test-id=\"20190718122211018760460\"]"));
        whyDoesTFNeedThisProductOrServiceNowTextField = new TextField(By.xpath("//textarea[@data-test-id=\"20190531001110000610894\"]"));
        whoDoesTFHaveMultipleVendorsThatOfferTextField = new TextField(By.xpath("//textarea[@data-test-id=\"20190531001110000711764\"]"));
        ifFPurchasingWasNotInvolvedInTheNegotiationsTextField = new TextField(By.xpath("//textarea[@data-test-id=\"20190531001110000712499\"]"));
        attachFileButton = new Button(By.xpath("//button[@name='EnterJustification_pyWorkPage_51']"));
        attachButton = new Button(By.xpath("//button[@id=\"ModalButtonSubmit\"]"));
        getBrowser().sleep(1000);
        continueButton = new Button(By.xpath("//button[@data-test-id=\"20161017110917023176385\"]"));
    }


    public void submitJustificationAndAttachmentsPage() {
        BPATest = new BPATest();
        justificationAndAttachmentsData = BPATestData.getjustificationAndAttachmentsDataDetails();
        whatSummaryofProductorServiceTextfield.enterText(justificationAndAttachmentsData.getWhatSummaryofProductorService());
        whyDoesTFNeedThisProductOrServiceNowTextField.enterText(justificationAndAttachmentsData.getWhyDoesTFNeedThisProductOrServiceNow());
        whoDoesTFHaveMultipleVendorsThatOfferTextField.enterText(justificationAndAttachmentsData.getWhoDoesTFHaveMultipleVendorsThatOffer());
        ifFPurchasingWasNotInvolvedInTheNegotiationsTextField.enterText(justificationAndAttachmentsData.getIfFPurchasingWasNotInvolvedInTheNegotiations());
        attachFileButton.click();
        getBrowser().sleep(2000);
        getDriver().findElement(By.xpath("//input[@id= '$PpyAttachmentPage$ppxAttachName']")).sendKeys((System.getProperty("user.dir")+"\\Documents\\SupportingDocument.txt" ));
        getBrowser().sleep(5000);
        attachButton.click();
        getBrowser().sleep(5000);
        continueButton.click();

    }

}
















