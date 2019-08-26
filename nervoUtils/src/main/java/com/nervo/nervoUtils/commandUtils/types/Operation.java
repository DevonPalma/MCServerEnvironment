package com.nervo.nervoUtils.commandUtils.types;

import lombok.Getter;

public enum Operation {
	add(0),
	additive(1),
	multiplicative(2);
	
	@Getter private int id;
	
	private Operation(int id) {
		this.id = id;
	}
	
	public static Operation byId(int id) {
		for (Operation o : Operation.values())
			if (o.getId() == id)
				return o;
		return null;
	}
}
