package com.sbm.helpdesk.dto;

import java.math.BigDecimal;

public class PermissionDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5890191532300522155L;
	
	private BigDecimal code;
	private String nameAr;
	private String nameEn;
	
	public BigDecimal getCode() {
		return code;
	}
	public void setCode(BigDecimal code) {
		this.code = code;
	}
	public String getNameAr() {
		return nameAr;
	}
	public void setNameAr(String nameAr) {
		this.nameAr = nameAr;
	}
	public String getNameEn() {
		return nameEn;
	}
	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
	}
}
