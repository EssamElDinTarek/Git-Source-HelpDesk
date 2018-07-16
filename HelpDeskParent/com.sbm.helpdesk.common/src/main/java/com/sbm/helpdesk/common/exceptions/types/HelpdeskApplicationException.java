package com.sbm.helpdesk.common.exceptions.types;

import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;

/**
 * 
 * @author Ahmed Magdy
 *
 */
public class HelpdeskApplicationException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorCode;
	private String messageEn;
	private String messageAr;
	
	public HelpdeskApplicationException() {
		super();
	}
	
	public HelpdeskApplicationException(ExceptionEnums exEnums) {
		super(exEnums.getMessageEn());
		this.errorCode = exEnums.getCode();
		this.messageEn = exEnums.getMessageEn();
		this.messageAr = exEnums.getMessageAr();
	}
	
	
	public HelpdeskApplicationException(ExceptionEnums exEnums, Throwable e) {
		super(exEnums.getMessageEn(), e);
		this.errorCode = exEnums.getCode();
		this.messageEn = exEnums.getMessageEn();
		this.messageAr = exEnums.getMessageAr();
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getMessageEn() {
		return messageEn;
	}

	public String getMessageAr() {
		return messageAr;
	}
}
