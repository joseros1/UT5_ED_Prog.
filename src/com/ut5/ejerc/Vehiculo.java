package com.ut5.ejerc;

import com.ut5.ejerc.utils.Valorable;
import java.time.LocalDate;
import java.time.Period;

public abstract class Vehiculo implements Valorable {
    private String matricula;
    private String marca;
    private String modelo;
    private int anioFabricacion;
    private int kilometros;
    private double precio;
    private Estado estado;
    private Persona propietario;

    public Vehiculo(String matricula, String marca, String modelo,
                    int anioFabricacion, int kilometros, double precio,
                    Estado estado, Persona propietario) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.kilometros = kilometros;
        this.precio = precio;
        this.estado = estado;
        this.propietario = propietario;
    }

    //Años desde fabricación hasta hoy.

    public int getAnios() {
        return Period.between(
                LocalDate.of(anioFabricacion,1,1),
                LocalDate.now()).getYears();
    }

    // Cada subclase define su cálculo de riesgo.

    public abstract double calcularRiesgo();

    @Override
    public double calcularDepreciacion() {
        // Ejemplo: 10% del precio por año
        return precio * 0.10 * getAnios();
    }

    // Getters y setters
    public String getMatricula() { return matricula; }
    public int getKilometros() { return kilometros; }
    public void setKilometros(int km) { this.kilometros = km; }
    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }
    public Persona getPropietario() { return propietario; }
    public void setPropietario(Persona propietario) { this.propietario = propietario; }
    public double getPrecio() { return precio; }

    @Override
    public String toString() {
        return String.format(
                "%s %s %s [%d] - %d km - %.2f€ - %s%s",
                matricula, marca, modelo, anioFabricacion,
                kilometros, precio,
                estado,
                (propietario != null ? " - " + propietario : "")
        );
    }
}
