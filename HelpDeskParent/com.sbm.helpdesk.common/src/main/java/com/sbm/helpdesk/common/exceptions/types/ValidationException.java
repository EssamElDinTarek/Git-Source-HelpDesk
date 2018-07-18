package com.sbm.helpdesk.common.exceptions.types;

import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;

public class ValidationException extends HelpdeskApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ValidationException() {
		super();
	}

	public ValidationException(ExceptionEnums exEnums) {
		super(exEnums);
	}

	public ValidationException(ExceptionEnums exEnums, Throwable e) {
		super(exEnums, e);
	}

}
