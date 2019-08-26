package com.nervo.nervoUtils.stringUtils;

import java.util.List;

import lombok.Getter;

public class ClosestMatchError extends IllegalArgumentException {
	@Getter private String objectName;
	@Getter private List<String> availableOptions;
	@Getter private List<String> validOptions;
	
	@Override
	public String getMessage() {
		String message = "Error finding closest match to '" + objectName + "'";
		if (validOptions.size() > 0) {
			message += "\nValid options: " + validOptions;
		}
		message += "\nAvailable Options: " + availableOptions;
		return message;
	}


	public ClosestMatchError(String objectName, List<String> availableOptions, List<String> validOptions) {
		super();
		this.objectName = objectName;
		this.availableOptions = availableOptions;
		this.validOptions = validOptions;
	}
}
