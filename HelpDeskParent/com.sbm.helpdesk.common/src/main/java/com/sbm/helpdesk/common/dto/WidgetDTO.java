package com.sbm.helpdesk.common.dto;

import java.util.Date;

public class WidgetDTO extends BaseDTO {

	private static final long serialVersionUID = 6104011990509049339L;

	private long value;
	private String name;
	private Date date;
	public long getValue() {
		return value;
	}
	public void setValue(long value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
