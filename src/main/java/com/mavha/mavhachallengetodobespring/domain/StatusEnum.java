package com.mavha.mavhachallengetodobespring.domain;

public enum StatusEnum {
	NEW("created"),
	IN_PROGRESS("in_progress"),
	DONE("done");
	
	private String name;
	
	private StatusEnum(String name) {
		this.name = name;
	}
}
