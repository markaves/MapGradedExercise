package com.orangeandbronze.map;

import java.util.*;

public class PhonebookExercise {
	
	/** Map of name to phone number. */
	static Map<String, String> phonebook = new HashMap<>();
	
	static boolean isNullOrEmpty(String name) {
		return name == null || name.trim().isEmpty();
	}
	
	static int getSize() {
		return phonebook.size();
	}
	
	/**
	 * If name is null or empty, method will do nothing. 
	 */
	static void remove(String name) {
		if (!isNullOrEmpty(name)) {
			phonebook.remove(name.trim().toLowerCase());	
		}
	}
	
	/** 
	 * Adds a name and phoneNumer to the phonebook.
	 * Stores name as all lowercase, even if the orginal name parameter has uppercase letters.
	 * If there is any whitespace at the beginning or end of either parameter, it will be trimmed before storing.
	 * If name already exists, then entry gets updated.
	 * If name is null or empty, will do nothing. 
	 * If phoneNumber is not an 11-digit string, method will do nothing (will not store value in the map).
	 */
	static void addOrUpdate(String name, String phoneNumber) {
		if (isNullOrEmpty(name)) {
			return;
		}
		if (phoneNumber == null) {
			return;
		}
		
		String trimmedPhoneNumber = phoneNumber.trim();
		if (!trimmedPhoneNumber.matches("\\d{11}")) {
			return;
		}
		phonebook.put(name.toLowerCase(), trimmedPhoneNumber);
	}

	/** 
	 * Will look for matching name, ignoring case.
	 * Returns corresponding phone number if name is present.
	 * Returns empty string - "" - if none found or empty parameter.
	 * */
	static String getNumber(String name) {
		return phonebook.getOrDefault(name.trim().toLowerCase(), "");
	}
	
	public static void main(String[] args) {
		addOrUpdate("Elmo", "09181234767");
		addOrUpdate("bErT", "09399876543");
		addOrUpdate("ernIE", "90171212121");
		
		System.out.println(phonebook);
		System.out.println(getSize()); // 3
		System.out.println(getNumber("eLMO")); // 09181234767
		System.out.println(getNumber("BERT")); // 09399876543
		System.out.println(getNumber("ernie")); // 90171212121
		
		addOrUpdate("abby", "123");
		System.out.println(getNumber("abby")); // (empty string)
		
		System.out.println(phonebook);
		
		addOrUpdate("ErNiE", "09228887777");
		System.out.println(getNumber("ERNIE")); // 09228887777
		
		remove("ELMO");
		System.out.println(getNumber("elmo")); // (empty string)
		
		System.out.println(phonebook);

	}

}
