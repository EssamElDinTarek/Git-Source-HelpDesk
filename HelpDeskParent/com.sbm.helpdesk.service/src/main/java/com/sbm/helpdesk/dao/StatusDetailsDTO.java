package com.sbm.helpdesk.dao;


import java.io.Serializable;

/**
 * 
 * @author Ahmed Magdy
 *
 */
public class StatusDetailsDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String statusCode;
	private String statusMessage;

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessage() {
		return statusMessage;
	}

	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

	public StatusDetailsDTO(String statusCode, String statusMessage) {
		super();
		this.statusCode = statusCode;
		this.statusMessage = statusMessage;
	}

	@Override
	public String toString() {
		return "StatusDetailsDTO [statusCode=" + statusCode
				+ ", statusMessage=" + statusMessage + "]";
	}
	
}

