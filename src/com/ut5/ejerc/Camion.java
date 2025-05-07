package com.ut5.ejerc;

public class Camion extends Vehiculo {
    private double capacidadCarga;
    private int numEjes;
    private double longitudRemolque;
    private int potencia;

    public Camion(String matricula, String marca, String modelo,
                  int anioFabricacion, int kilometros, double precio,
                  Estado estado, Persona propietario,
                  double capacidadCarga, int numEjes,
                  double longitudRemolque, int potencia) {
        super(matricula, marca, modelo, anioFabricacion, kilometros, precio, estado, propietario);
        this.capacidadCarga = capacidadCarga;
        this.numEjes = numEjes;
        this.longitudRemolque = longitudRemolque;
        this.potencia = potencia;
    }

    @Override
    public double calcularRiesgo() {
        return capacidadCarga * numEjes / (getAnios() + 1);
    }
}

