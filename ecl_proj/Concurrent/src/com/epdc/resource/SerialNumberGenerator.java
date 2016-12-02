package com.epdc.resource;

public class SerialNumberGenerator {

	static volatile int serialNumber = 0;
	public static int  nextSerialNumber() {
		return serialNumber++;
	}
	
}
