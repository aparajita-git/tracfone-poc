package com.tracfone.data;

import com.incessant.bon34.controls.TextField;

public class JustificationAndAttachmentData {

    //Variables
    private String addItem;
    private String description;

    private String whatSummaryofProductorService;
    private String whyDoesTFNeedThisProductOrServiceNow;
    private String whoDoesTFHaveMultipleVendorsThatOffer;
    private String ifFPurchasingWasNotInvolvedInTheNegotiations;
//    private Button attachFileButton;
//    private Button attachButton;

    //Getters

//    public Button getAttachButton() {
//        return attachButton;
//    }
//
//    public Button getAttachFileButton() {
//        return attachFileButton;
//    }

    public String getWhatSummaryofProductorService() {
        return whatSummaryofProductorService;
    }

    public String getWhyDoesTFNeedThisProductOrServiceNow() {
        return whyDoesTFNeedThisProductOrServiceNow;
    }

    public String getWhoDoesTFHaveMultipleVendorsThatOffer() {
        return whoDoesTFHaveMultipleVendorsThatOffer;
    }

    public String getIfFPurchasingWasNotInvolvedInTheNegotiations() {
        return ifFPurchasingWasNotInvolvedInTheNegotiations;
    }

    ;

    //Constructors

    public JustificationAndAttachmentData(String whatSummaryofProductorServiceTextfield,
                                          String whyDoesTFNeedThisProductOrServiceNowTextfield,
                                          String whoDoesTFHaveMultipleVendorsThatOfferTextfield,
                                          String ifFPurchasingWasNotInvolvedInTheNegotiationsTextfield) {

        this.whatSummaryofProductorService = whatSummaryofProductorServiceTextfield;
        this.whyDoesTFNeedThisProductOrServiceNow = whyDoesTFNeedThisProductOrServiceNowTextfield;
        this.whoDoesTFHaveMultipleVendorsThatOffer = whoDoesTFHaveMultipleVendorsThatOfferTextfield;
        this.ifFPurchasingWasNotInvolvedInTheNegotiations = ifFPurchasingWasNotInvolvedInTheNegotiationsTextfield;

    }


}
