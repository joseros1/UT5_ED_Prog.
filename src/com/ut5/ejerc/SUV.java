package com.ut5.ejerc;

public class SUV extends Coche {
    private boolean offRoad;
    private double alturaLibre;

    public SUV(String matricula, String marca, String modelo,
               int anioFabricacion, int kilometros, double precio,
               Estado estado, Persona propietario,
               int puertas, TipoCombustible combustible,
               int maletero, Traccion traccion,
               boolean offRoad, double alturaLibre) {
        super(matricula, marca, modelo, anioFabricacion, kilometros, precio,
                estado, propietario, puertas, combustible, maletero, traccion);
        this.offRoad = offRoad;
        this.alturaLibre = alturaLibre;
    }
}

