package com.sbm.helpdesk.common.enums.servicesEnums;

public enum ServicesEnums {
	TICKET_STATUS_CREATED("1"),
	TICKET_STATUS_INPROGRESS("2"),
	TICKET_STATUS_COMPLETED("3"),
	BEHAVIOR_NAME_COMMENT("Comment"),
	BEHAVIOR_NAME_ATTACHMENT("Attachment"),
	BEHAVIOR_NAME_ACTION("Action"),
	BEHAVIOR_VALUE_ADD("Add"),
	BEHAVIOR_VALUE_DELETE("Delete"),
	BEHAVIOR_VALUE_FORWARD("Forward"),
	BEHAVIOR_VALUE_BACKWARD("Backward");
	
	private String definition;

	private ServicesEnums(String definition) {
		this.definition = definition;
	}

	public String getStringValue() {
		return this.definition;
	}
}


