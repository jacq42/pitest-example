package de.jkrech.tutorial;

class IsbnValidator {
	
	/**
	 * Validate as ISBN-10
	 * 
	 * @param isbnValue as formatted string
	 * @return {@code true} if value is a valid isbn, otherwise {@code false}
	 * 
	 * @see <a href="https://isbn-information.com/the-10-digit-isbn.html">ISBN Information</a>
	 */
	public static boolean validateIsbn10(String isbnValue) {
		String plainNumber = isbnValue.replace("-", "");
		if(plainNumber.length() != 10) {
			return false;
		}
		var checksum = 0;
		for(var i = 0; i < 10; i++) {
			var charAt = plainNumber.charAt(i);
			var intValue = Integer.parseInt(String.valueOf(charAt));
			checksum += intValue * (10 - i);
		}
		
		return (checksum % 11) == 0;
	}
	
}
