package com.ut5.ejerc;

public class Deportivo extends Coche {
    private double aceleracion;
    private int potencia;
    private boolean modoPista;

    public Deportivo(String matricula, String marca, String modelo,
                     int anioFabricacion, int kilometros, double precio,
                     Estado estado, Persona propietario,
                     int puertas, TipoCombustible combustible,
                     int maletero, Traccion traccion,
                     double aceleracion, int potencia, boolean modoPista) {
        super(matricula, marca, modelo, anioFabricacion, kilometros, precio,
                estado, propietario, puertas, combustible, maletero, traccion);
        this.aceleracion = aceleracion;
        this.potencia = potencia;
        this.modoPista = modoPista;
    }
}

