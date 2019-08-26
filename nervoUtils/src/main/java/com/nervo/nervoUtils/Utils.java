package com.nervo.nervoUtils;

public class Utils {
	public static double map(double val, double a, double b, double c, double d) {
		return c + (val-a)*(d-c)/(b-a);
	}
	
}
