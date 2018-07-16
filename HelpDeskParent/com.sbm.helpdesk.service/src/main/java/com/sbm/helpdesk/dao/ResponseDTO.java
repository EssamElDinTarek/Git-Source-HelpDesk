package com.sbm.helpdesk.dao;

import java.io.Serializable;

/**
 * 
 * @author Ahmed Magdy
 *
 * This class for the generic response; @param status contains success code, error code,
 * messages, and error details if exist, also @param data contains the actual result for 
 * the service if success. 
 */
public class ResponseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private StatusDTO status;
	private Object data;

	public StatusDTO getStatus() {
		return status;
	}

	public void setStatus(StatusDTO status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public ResponseDTO(){}

	/**
	 * Constructor for the successful scenarios 
	 * @param statusCode
	 * @param statusMessageEN
	 * @param statusMessageAR
	 * @param data
	 */
	public ResponseDTO(String statusCode,String statusMessageEN,String statusMessageAR, Object data) {
		super();
		this.status = new StatusDTO(statusCode,statusMessageEN,statusMessageAR,null);
		this.data = data;
	}
	
	/**
	 * Constructor for the successful scenarios 
	 * @param statusCode
	 * @param statusMessageEN
	 * @param statusMessageAR
	 * @param data
	 */
	public ResponseDTO(StatusDTO status, Object data) {
		super();
		this.status = status;
		this.data = data;
	}
	/**
	 * Constructor for the failed scenarios 
	 * @param statusCode
	 * @param statusMessageEN
	 * @param statusMessageAR
	 * @param innerExceptionCode
	 * @param innerExceptionMessage
	 */
	public ResponseDTO(String statusCode,String statusMessageEN,String statusMessageAR, String innerExceptionCode,String innerExceptionMessage) {
		super();
		this.status = new StatusDTO(statusCode, statusMessageEN, statusMessageAR, new StatusDetailsDTO(innerExceptionCode, innerExceptionMessage));
	}

	@Override
	public String toString() {
		return "ResponseDTO [status=" + status + ", data=" + data + "]";
	}
	
}

