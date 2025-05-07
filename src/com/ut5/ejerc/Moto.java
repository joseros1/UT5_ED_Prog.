package com.ut5.ejerc;

public abstract class Moto extends Vehiculo {
    private int cilindrada;
    private int peso;
    private double alturaAsiento;
    private TipoTransmision transmision;

    public Moto(String matricula, String marca, String modelo,
                int anioFabricacion, int kilometros, double precio,
                Estado estado, Persona propietario,
                int cilindrada, int peso, double alturaAsiento,
                TipoTransmision transmision) {
        super(matricula, marca, modelo, anioFabricacion, kilometros, precio, estado, propietario);
        this.cilindrada = cilindrada;
        this.peso = peso;
        this.alturaAsiento = alturaAsiento;
        this.transmision = transmision;
    }

    @Override
    public double calcularRiesgo() {
        return cilindrada / (double)(getAnios() + 1);
    }
}

