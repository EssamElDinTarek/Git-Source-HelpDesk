package com.sbm.helpdesk.common.exceptions.types;

import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;

public class RespositoryException extends HelpdeskApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public RespositoryException() {
		super();
	}

	public RespositoryException(ExceptionEnums exEnums) {
		super(exEnums);
	}

	public RespositoryException(ExceptionEnums exEnums, Throwable e) {
		super(exEnums, e);
	}
}
