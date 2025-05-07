
package com.ut5.ejerc;

import com.ut5.ejerc.utils.Valorable;

public abstract class Coche extends Vehiculo {
    private int puertas;
    private TipoCombustible combustible;
    private int maletero;
    private Traccion traccion;

    public Coche(String matricula, String marca, String modelo,
                 int anioFabricacion, int kilometros, double precio,
                 Estado estado, Persona propietario,
                 int puertas, TipoCombustible combustible,
                 int maletero, Traccion traccion) {
        super(matricula, marca, modelo, anioFabricacion, kilometros, precio, estado, propietario);
        this.puertas = puertas;
        this.combustible = combustible;
        this.maletero = maletero;
        this.traccion = traccion;
    }

    @Override
    public double calcularRiesgo() {
        return getKilometros() / (double)(getAnios() + 1);
    }
}

