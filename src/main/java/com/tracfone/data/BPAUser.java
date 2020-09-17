package com.tracfone.data;

import com.easepro.PasswordEncryption;

public class BPAUser {

	// Variables
	private String userID;
	private String password;

	// Getters
	public String getKey() {
		return "EasePro";
	}

	public String getUserID() {
		return this.userID;
	}

	public String getPassword() {
		return PasswordEncryption.decrypt(this.password, this.getKey());
	}

	// Constructor
	public BPAUser(String userID, String password) {
		super();
		this.userID = userID;
		this.password = password;
	}

}
