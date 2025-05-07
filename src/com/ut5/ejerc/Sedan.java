package com.ut5.ejerc;

public class Sedan extends Coche {
    private double espacioInterior;
    private NivelConfort confort;

    public Sedan(String matricula, String marca, String modelo,
                 int anioFabricacion, int kilometros, double precio,
                 Estado estado, Persona propietario,
                 int puertas, TipoCombustible combustible,
                 int maletero, Traccion traccion,
                 double espacioInterior, NivelConfort confort) {
        super(matricula, marca, modelo, anioFabricacion, kilometros, precio,
                estado, propietario, puertas, combustible, maletero, traccion);
        this.espacioInterior = espacioInterior;
        this.confort = confort;
    }
}

