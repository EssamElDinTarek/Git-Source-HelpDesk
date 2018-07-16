package com.sbm.helpdesk.common.exceptions.types;

import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;

public class ControllerException extends HelpdeskApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ControllerException() {
		super();
	}

	public ControllerException(ExceptionEnums exEnums) {
		super(exEnums);
	}

	public ControllerException(ExceptionEnums exEnums, Throwable e) {
		super(exEnums, e);
	}

}
