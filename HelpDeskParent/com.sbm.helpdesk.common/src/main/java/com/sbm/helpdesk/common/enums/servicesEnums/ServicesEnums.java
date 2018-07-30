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
	BEHAVIOR_VALUE_BACKWARD("Backward"),
	INFORMATIONAL_COLNAME_TITLE("TITLE"),
	INFORMATIONAL_COLNAME_DESCRIPTION("DESCRIPTION"),
	INFORMATIONAL_COLNAME_SEVERIRTY("SEVERIRTY"),
	INFORMATIONAL_COLNAME_PRIORITY("PRIORITY"),
	INFORMATIONAL_COLNAME_STATUS("STATUS");
	
	private String definition;

	private ServicesEnums(String definition) {
		this.definition = definition;
	}

	public String getStringValue() {
		return this.definition;
	}
}


