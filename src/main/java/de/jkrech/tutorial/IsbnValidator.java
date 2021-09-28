package de.jkrech.tutorial;

public class IsbnValidator {
	
	public static boolean validateIsbn10(String isbnValue) {
		String plainNumber = isbnValue.replace("-", "");
		if(plainNumber.length() != 10) {
			return false;
		}
		var checksum = 0;
		for(int i = 0; i < 10; i++) {
			var charAt = plainNumber.charAt(i);
			var intValue = Integer.parseInt(String.valueOf(charAt));
			checksum += intValue * (10 - i);
		}
		return (checksum % 11) == 0;
	}
}
