package com.nervo.nervoUtils.stringUtils;

import java.util.ArrayList;
import java.util.List;

public class ListMatcher {
	public static <E> E getClosestNameMatch(E object, List<E> options, ObjToString<E> stringConverter) {
		String stringedObject = stringConverter.toString(object);
		
		List<E> validOptions = new ArrayList<E>();
		List<String> validStringedOptions = new ArrayList<String>();
		
		List<String> stringedOptions = new ArrayList<String>();
		
		for (E option : options) {
			String stringedOption = stringConverter.toString(option);
			stringedOptions.add(stringedOption);
			
			if (stringedObject.equals(stringedOption))
				return option;
			else if (stringedObject.startsWith(stringedOption)) {
				validOptions.add(option);
				validStringedOptions.add(stringedOption);
			}
		}
		
		
		if (validOptions.size() != 1) 
			throw new ClosestMatchError(stringedObject, stringedOptions, validStringedOptions);
		return validOptions.get(0);
	}
}
