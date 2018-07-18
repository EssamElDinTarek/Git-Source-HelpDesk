package com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums;

import com.sbm.helpdesk.common.utilities.MessagesUtil;

public enum ExceptionEnums {
	
	INVALID_REQUEST("helpdesk.controller.code.1000"),
	MISSING_PARAMS("helpdesk.controller.code.1001"),
	INVALID_HTTP_METHOD("helpdesk.controller.code.1002"),
	INVALID_OPERATION("helpdesk.controller.code.1003"),
	INTERNAL_SERVER_ERROR("helpdesk.controller.code.500"),
	
	BUSINESS_ERROR("helpdesk.business.code.3000"),
	
	REPOSITORY_ERROR("helpdesk.repository.code.4000");
	
	private String code;
	private String messageEn;
	private String messageAr;
	
	ExceptionEnums(String code){
		this.code = code;
		this.messageEn = MessagesUtil.getMessageEn(code);
		this.messageAr = MessagesUtil.getMessageAr(code);
	}

	public String getCode() {
		return code;
	}

	public String getMessageEn() {
		return messageEn;
	}

	public String getMessageAr() {
		return messageAr;
	}
}
