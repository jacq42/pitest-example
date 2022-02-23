package de.jkrech.tutorial;

import java.util.Objects;

@ValueObject
class Isbn {

	private String value;
	
	public static Isbn of(String value) {
		if(Objects.isNull(value) || value.length() == 0) {
			throw new IllegalArgumentException("Empty value is not allowed");
		}
		if(IsbnValidator.validateIsbn10(value)) {
			return new Isbn(value);
		}
		throw new IllegalArgumentException("Invalid isbn");
	}
	
	private Isbn(String value) {
		this.value = value;
	}
	
	public String value() {
		return value;
	}
}
