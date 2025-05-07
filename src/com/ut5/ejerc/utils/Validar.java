
package com.ut5.ejerc.utils;

import java.time.LocalDate;


public class Validar {
    public static boolean validarKilometros(int km) {
        return km > 0;
    }

    public static boolean validarFecha(LocalDate fecha) {
        return fecha.isBefore(LocalDate.now());
    }

    public static void validarDni(String dni) {
        String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
        if (dni == null || !dni.matches("\\d{8}[A-Z]")) {
            throw new IllegalArgumentException("Formato de DNI inválido");
        }
        int numero = Integer.parseInt(dni.substring(0, 8));
        char letraEsperada = letras.charAt(numero % 23);
        if (dni.charAt(8) != letraEsperada) {
            throw new IllegalArgumentException("Letra del DNI incorrecta");
        }
    }

    public static void validarMatricula(String mat) {
        if (mat == null || !mat.matches("\\d{4}[A-Z]{3}")) {
            throw new IllegalArgumentException("Matrícula debe tener formato 0000AAA");
        }
    }
}

