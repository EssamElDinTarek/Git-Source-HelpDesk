package com.sbm.helpdesk.dao;

import java.io.Serializable;

/**
 * 
 * @author Ahmed Magdy
 *
 */
public class StatusDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String statusCode;
	private String statusMessageEN;
	private String statusMessageAR;
	private StatusDetailsDTO statusDetails;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessageEN() {
		return statusMessageEN;
	}

	public void setStatusMessageEN(String statusMessageEN) {
		this.statusMessageEN = statusMessageEN;
	}

	public String getStatusMessageAR() {
		return statusMessageAR;
	}

	public void setStatusMessageAR(String statusMessageAR) {
		this.statusMessageAR = statusMessageAR;
	}

	public StatusDetailsDTO getStatusDetails() {
		return statusDetails;
	}

	public void setStatusDetails(StatusDetailsDTO statusDetails) {
		this.statusDetails = statusDetails;
	}

	public StatusDTO(String statusCode, String statusMessageEN,
			String statusMessageAR, StatusDetailsDTO statusDetails) {
		super();
		this.statusCode = statusCode;
		this.statusMessageEN = statusMessageEN;
		this.statusMessageAR = statusMessageAR;
		this.statusDetails = statusDetails;
	}

	@Override
	public String toString() {
		return "StatusDTO [statusCode=" + statusCode + ", statusMessageEN="
				+ statusMessageEN + ", statusMessageAR=" + statusMessageAR
				+ ", statusDetails=" + statusDetails + "]";
	}
	
}

