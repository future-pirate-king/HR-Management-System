package com.project.hrmanagement.testclasses;

import java.util.Random;

public class OtpGenerator {

	public static void main(String[] args) {
		int length = 4;
		OtpGenerator otp = new OtpGenerator();
		char[] a = otp.OTPgenerator(4);
		System.out.println(a);
	}
	// Java code to explain how to generate OTP

	// Here we are using random() method of util
	// class in Java

	
	public char[] OTPgenerator(int len) {
		System.out.print("You OTP is : ");
		String numbers = "0123456789";
		// Using random method
		Random rndm_method = new Random();
		char[] otp = new char[len];
		for (int i = 0; i < len; i++) {
			// Use of charAt() method : to get character value
			// Use of nextInt() as it is scanning the value as int
			otp[i] = numbers.charAt(rndm_method.nextInt(numbers.length()));
		}
		return otp;
	}

	
}
