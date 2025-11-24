import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.example.TextProcessor;

class TextProcessorTest {
    
    // Caso 1: Texto válido estándar
    @Test
    void testValidTextReturnsReversedAndCapitalized() {
        assertEquals("ALOH", TextProcessor.reverseAndCapitalize("hola"));
    }

    // Caso 2: Texto con espacios al inicio y final
    @Test
    void testTextWithSpacesTrimmedAndProcessed() {
        assertEquals("ALOH", TextProcessor.reverseAndCapitalize(" hola "));
    }

    // Caso 3: Texto nulo
    @Test
    void testNullTextThrowsException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TextProcessor.reverseAndCapitalize(null)
        );
        assertEquals("El texto no puede ser nulo", exception.getMessage());
    }

    // Caso 4: Texto vacío
    @Test
    void testEmptyTextThrowsException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TextProcessor.reverseAndCapitalize("")
        );
        assertEquals("El texto no puede estar vacío o solo contener espacios", exception.getMessage());
    }

    // Caso 5: Texto solo espacios
    @Test
    void testTextWithOnlySpacesThrowsException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TextProcessor.reverseAndCapitalize("   ")
        );
        assertEquals("El texto no puede estar vacío o solo contener espacios", exception.getMessage());
    }

    // Caso 6: Texto con longitud máxima excedida
    @Test
    void testTextExceedsMaxLengthThrowsException() {
        String longText = "a".repeat(1001);
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> TextProcessor.reverseAndCapitalize(longText)
        );
        assertEquals("El texto excede el límite de 1000 caracteres", exception.getMessage());
    }

    // Caso 7: Texto exactamente en el límite
    @Test
    void testTextAtMaxLengthValid() {
        String text = "a".repeat(1000);
        String result = TextProcessor.reverseAndCapitalize(text);
        assertEquals("A".repeat(1000), result);
    }

    // Caso 8: Texto con caracteres especiales
    @Test
    void testTextWithSpecialCharacters() {
        assertEquals("!ALOH¡", TextProcessor.reverseAndCapitalize("¡Hola!"));
    }

    // Caso 9: Texto con números
    @Test
    void testTextWithNumbers() {
        assertEquals("321CBA", TextProcessor.reverseAndCapitalize("abc123"));
    }

    // Caso 10: Texto mixto con mayúsculas y minúsculas
    @Test
    void testTextWithMixedCase() {
        assertEquals("ALOH", TextProcessor.reverseAndCapitalize("HoLa"));
    }

    // Caso 11: Texto palíndromo
    @Test
    void testPalindromeText() {
        assertEquals("ANA", TextProcessor.reverseAndCapitalize("ana"));
    }

    // Caso 12: Validación agrupada con assertAll
    @Test
    void testMultipleValidTexts() {
        assertAll(
            () -> assertEquals("ALOH", TextProcessor.reverseAndCapitalize("hola")),
            () -> assertEquals("321CBA", TextProcessor.reverseAndCapitalize("abc123")),
            () -> assertEquals("ANA", TextProcessor.reverseAndCapitalize("ana"))
        );
    }
}
