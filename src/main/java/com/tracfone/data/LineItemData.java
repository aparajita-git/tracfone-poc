package com.tracfone.data;

public class LineItemData {

    //Variables
    private String addItem;
    private String description;
    private String quantity;
    private String price;
    private String part;
    private String generalLedger;


    //Getters
    public String getDescription(){
        return description;
    }

    public String getQuantity(){
        return quantity;
    }

    public String getPrice(){
        return price;
    }

    public String part(){
        return part;
    }

    public String getGeneralLedger(){
        return generalLedger;
    }

    //Constructors

    public LineItemData(String descriptionTextfield,
                        String quantityTextfield,
                        String priceTextfield,
                        String partTextField,
                        String generalLedgerDropdown){
        this.description = descriptionTextfield;
        this.quantity = quantityTextfield;
        this.price = priceTextfield;
        this.part = partTextField;
        this.generalLedger = generalLedgerDropdown;
    }




    }
