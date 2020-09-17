package com.tracfone.data;


public enum UserData {


	BPACaseWorker {
		public BPAUser getBPAUser() {

			return new BPAUser("apattanaik@tracfone.com", "N9vOmsgNdp5nM3wV1NmZWA==");
		}

	},

	BPACaseManager {
		public BPAUser getBPAUser() {

			return new BPAUser("TDTestManager", "DI0JfGKF4itcRuoEMF+YtQ==");
		}

	};

	public BPAUser getBPAUser() {
		return null;
	}

}
