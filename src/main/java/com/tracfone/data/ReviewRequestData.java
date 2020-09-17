package com.tracfone.data;

public class ReviewRequestData {

	// Variables

	private String deliveryDate;
	private String assignee;



	// Getters


	public String getDeliveryDate() {
		return deliveryDate;
	}

	public String getAssignee() {
		return assignee;
	}

	// Constructor
	public ReviewRequestData(String deliveryDateTextField,
                             String assigneeDropdown) {

		this.deliveryDate = deliveryDateTextField;
		this.assignee = assigneeDropdown;

	}

}
