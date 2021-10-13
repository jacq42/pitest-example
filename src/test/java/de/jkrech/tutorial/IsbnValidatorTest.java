package de.jkrech.tutorial;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class IsbnValidatorTest {

	@ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"invalid", "3-598-21508-9", "3-680-08783-0"})
    void shouldThrowExceptionWhenIsbnIsInvalid(String invalidValue) {
        assertThrows(IllegalArgumentException.class, () -> Isbn.of(invalidValue));
    }
    
    @ParameterizedTest
    @ValueSource(strings = {"3-598-21508-8", "3-680-08783-7"})
    void shouldReturnIsbn(String validIsbn) {
        assertEquals(validIsbn, Isbn.of(validIsbn).value());
    }
}
