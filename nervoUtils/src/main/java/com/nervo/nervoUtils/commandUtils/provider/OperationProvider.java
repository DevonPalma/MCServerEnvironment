package com.nervo.nervoUtils.commandUtils.provider;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.List;

import com.nervo.nervoUtils.commandUtils.types.Operation;

public class OperationProvider extends CustomAbstactProvider<Operation> {

	public OperationProvider() {
		super(Operation.class);
	}

	@Override
	public String asString(Operation object, List<? extends Annotation> mods) {
		return object.name();
	}

	@Override
	public List<Operation> getSource(List<? extends Annotation> mods) {
		return Arrays.asList(Operation.values());
	}
	
}
