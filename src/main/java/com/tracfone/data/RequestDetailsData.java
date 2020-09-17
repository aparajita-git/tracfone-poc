package com.tracfone.data;


public class RequestDetailsData {

	// Variables

	private String shortDescription;
	private String brand;
	private String requestType;
	private String priority;
	private String expectedReleaseDate;
	private String reasonForRequest;

	// Getters


	public String getShortDescription() {
		return shortDescription;
	}

	public String getBrand() {
		return brand;
	}

	public String getRequestType() {
		return requestType;
	}

	public String getPriority() {
		return priority;
	}

	public String getExpectedReleaseDate() {
		return expectedReleaseDate;
	}

	public String getReasonForRequest() {
		return reasonForRequest;
	}

	// Constructor
	public RequestDetailsData(String shortDescriptionTextField,
							  String brandAutoComplete,
							  String requestTypeDropdown,
							  String priorityDropdown,
							  String expectedReleaseDateTextField,
							  String reasonForRequestTextField) {


		this.shortDescription = shortDescriptionTextField;
		this.brand = brandAutoComplete;
		this.requestType = requestTypeDropdown;
		this.priority = priorityDropdown;
		this.expectedReleaseDate = expectedReleaseDateTextField;
		this.reasonForRequest = reasonForRequestTextField;

	}

}
