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

    // Caso 5: Texto con solo espacios
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
}
