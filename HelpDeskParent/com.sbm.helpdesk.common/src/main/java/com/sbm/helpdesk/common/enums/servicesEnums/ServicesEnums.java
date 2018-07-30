package com.sbm.helpdesk.common.enums.servicesEnums;

public enum ServicesEnums {
	TICKET_STATUS_CREATED("1"),
	TICKET_STATUS_INPROGRESS("2"),
	TICKET_STATUS_COMPLETED("3");
	
	private String definition;

	private ServicesEnums(String definition) {
		this.definition = definition;
	}

	public String getStringValue() {
		return this.definition;
	}
}


