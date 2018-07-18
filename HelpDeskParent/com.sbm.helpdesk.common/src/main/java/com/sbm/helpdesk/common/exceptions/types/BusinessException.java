package com.sbm.helpdesk.common.exceptions.types;

import com.sbm.helpdesk.common.exceptions.enums.ExceptionEnums.ExceptionEnums;

/**
 * 
 * @author Ahmed Magdy
 *
 */
public class BusinessException extends HelpdeskApplicationException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessException() {
		super();
	}

	public BusinessException(ExceptionEnums exEnums) {
		super(exEnums);
	}

	public BusinessException(ExceptionEnums exEnums, Throwable e) {
		super(exEnums, e);
	}
}