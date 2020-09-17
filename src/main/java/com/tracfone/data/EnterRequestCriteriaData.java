package com.tracfone.data;

public class EnterRequestCriteriaData {

    //Variables

    private String shortDescription;
    private String requestType;
    private String department;
    private String shipToLocation;
    private String costCenter;
    private String vendor;
    private String vendorName;
    private String vendorEmailAddress;
    private String vendorPhone;


    //Getters

    public String getShortDescription() {
        return shortDescription;
    }

    public String getRequestType() {
        return requestType;
    }

    public String getDepartment(){
        return department;
    }

    public String getShipToLocation(){
        return shipToLocation;
    }

    public String getCostCenter(){
        return costCenter;
    }

    public String getVendor(){
        return vendor;
    }

    public String getVendorName(){
        return vendorName;
    }

    public String getVendorEmailAddress(){
        return vendorEmailAddress;
    }

    public String getVendorPhone() {
        return vendorPhone;
    }
        //Constructors

    public EnterRequestCriteriaData( String shortDescriptionTextField,
                                     String requestTypeDropdown,
                                     String departmentDropdown,
                                     String shipToLocationDropdown,
                                     String costCenterDropdown,
                                     String vendorAutoComplete,
                                     String vendorEmailAddressTextField,
                                     String vendorNameTextField,
                                     String vendorPhoneTextField){
      this.shortDescription = shortDescriptionTextField;
      this.requestType = requestTypeDropdown;
      this.department = departmentDropdown;
      this.shipToLocation = shipToLocationDropdown;
      this.costCenter = costCenterDropdown;
      this.vendor =vendorAutoComplete;
      this.vendorEmailAddress = vendorEmailAddressTextField;
      this.vendorName = vendorNameTextField;
      this.vendorPhone = vendorPhoneTextField;
    }

}