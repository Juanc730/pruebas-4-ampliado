
package com.example;

import java.util.regex.Pattern;

public class TextProcessor {

    public static String reverseAndCapitalize(String input) {
        if (input == null) {
            throw new IllegalArgumentException("El texto no puede ser nulo");
        }

        String trimmed = input.trim();
        if (trimmed.isEmpty()) {
            throw new IllegalArgumentException("El texto no puede estar vacío o solo contener espacios");
        }

        if (trimmed.length() > 1000) {
            throw new IllegalArgumentException("El texto excede el límite de 1000 caracteres");
        }

        // Invertir el texto
        String reversed = new StringBuilder(trimmed).reverse().toString();

        // Convertir a mayúsculas
        return reversed.toUpperCase();
    }
}
