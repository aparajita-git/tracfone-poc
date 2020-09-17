package com.tracfone.pages;

import com.incessant.bon34.controls.Button;
import com.incessant.bon34.controls.Control;
import com.incessant.bon34.controls.Dropdown;
import com.incessant.bon34.controls.TextField;
import com.tracfone.data.LineItemData;
import com.tracfone.reusablemethods.BPATest;
import com.tracfone.testdatamanager.BPATestData;
import org.openqa.selenium.By;

public class LineItemPage extends Control {

    //Object
    private LineItemData lineItemData;
    private BPATest BPATest;
    private BPATestData BPATestData;


    //Variable
    private Button addItem;
    private TextField descriptionTextfield;
    private TextField quantityTextfield;
    private TextField priceTextfield;
    private TextField partTextField;
    private Button continueButton;

    //Getters
    public Button getContinueButton(){return continueButton;}
    public Button getAddItem() {
        return addItem;
    }

    public TextField getDescriptionTextfield() {
        return descriptionTextfield;
    }

    public TextField getQuantityTextfield() {
        return quantityTextfield;
    }

    public TextField getPriceTextfield() {
        return priceTextfield;
    }

    public TextField getPartTextField() {
        return partTextField;
    }


    //ScreenObject
       public LineItemPage(){

        addItem = new Button(By.xpath("//a[@data-test-id=\"2015071603054009744126\"]"));
        descriptionTextfield = new TextField(By.xpath("//input[@data-test-id=\"2016072109335505834280\"]"));
        quantityTextfield = new TextField(By.xpath("//input[@data-test-id=\"201907131732430029148646\"]"));
        priceTextfield = new TextField(By.xpath("//input[@data-test-id=\"2019060713170104433826\"]"));
        partTextField = new TextField(By.xpath("//input[@data-test-id=\"201907111053320653121555\"\"]"));
        continueButton = new Button(By.xpath("//button[@data-test-id=\"20161017110917023176385\"]"));

      }

      public void submitLineItemPage(){

          BPATest = new BPATest();
          lineItemData = BPATestData.getLineItemDetails();
          getBrowser().sleep(1000);
          BPATest.switchToActiveIFrame();
          addItem.click();
          descriptionTextfield.enterText(lineItemData.getDescription());
          getBrowser().sleep(2000);
          quantityTextfield.enterText(lineItemData.getQuantity());
          priceTextfield.enterText(lineItemData.getPrice());
        //  partDropdown.e
          continueButton.click();

      }


   }