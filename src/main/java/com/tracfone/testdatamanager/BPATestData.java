package com.tracfone.testdatamanager;


import com.tracfone.data.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static org.testng.internal.Utils.log;

public class BPATestData {
	
	
	public static String randomNumber(int length) {
		StringBuffer buffer = new StringBuffer();
		String characters = "1234567890";

		int charactersLength = characters.length();
		for (int i = 0; i < length; i++) {
			double index = Math.random() * charactersLength;
			buffer.append(characters.charAt((int) index));
		}
		return buffer.toString();
	}
	
	public static String generateRandomString(int length) {
		StringBuffer buffer = new StringBuffer();
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		int charactersLength = characters.length();
		for (int i = 0; i < length; i++) {
			double index = Math.random() * charactersLength;
			buffer.append(characters.charAt((int) index));
		}
		return buffer.toString();
	}

	public static String enterDate(int days, int months, int years){
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, days);
		calendar.add(Calendar.MONTH, months);
		calendar.add(Calendar.YEAR, years);
		String finalDate = sdf.format(calendar.getTime());
		return finalDate;

	}

	/**
	 * Method to return test data for Training Request Details
	 * @return Request Details
	 */
	public static RequestDetailsData getTrainingRequestDetails() {
		return new RequestDetailsData("Tracfone "+generateRandomString(4), "GoSmart","Training Manuals","Low",enterDate(5,0,0), "Want to understand the basics of PEGA and start learning the advanced concepts");
	}

//	public static AmendOrPORPageDetailsData getAmendOrPORPageDetails(){
//		return new AmendOrPORPageDetailsData("")
    public static EnterRequestCriteriaData getRequestCriteriaDetails(){
		return new EnterRequestCriteriaData("Tracfone "+generateRandomString(4), "Hardware/Software Purchase","ACCT","TF_HQ","ACCOUNTING - 210","1010DATA SERVICES LLC","das@in","WENDY WALWYN","8886588892");
	}

	public static LineItemData getLineItemDetails() {
		return new LineItemData("Tracfone", "2", "200", "02230JBF", "01.000.1101.000.000");

	}

	public static JustificationAndAttachmentData getjustificationAndAttachmentsDataDetails(){
		return new JustificationAndAttachmentData("aaaa","bbbb","cccc","dddd");

	}
		/**
		 * Method to return test data for Review Request Details
		 * @return Review Request Details
		 */
		public static ReviewRequestData getReviewRequestDetails () {
			return new ReviewRequestData(enterDate(9, 0, 0), "TDTestManager");
		}

		/**
		 * Method to return test data for Withdraw case Details
		 * @return Withdraw case Details
		 */
		public static WithdrawCaseData getWithdrawReason () {
			return new WithdrawCaseData("No longer a valid training request...");
		}
	}

