
package com.ut5.ejerc;

//Representa una persona propietaria de vehículo.

public class Persona {
    private String nombreCompleto;
    private String dni;
    private int anioCarnet;
    private int anioNacimiento;

    public Persona(String nombreCompleto, String dni, int anioCarnet, int anioNacimiento) {
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.anioCarnet = anioCarnet;
        this.anioNacimiento = anioNacimiento;
    }

    public String getNombreCompleto() { return nombreCompleto; }
    public String getDni() { return dni; }

    @Override
    public String toString() {
        return nombreCompleto + " (" + dni + ")";
    }
}

