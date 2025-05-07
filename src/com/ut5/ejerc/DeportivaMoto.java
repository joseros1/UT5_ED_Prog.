package com.ut5.ejerc;

public class DeportivaMoto extends Moto {
    private double velMax;
    private boolean quickShifter;

    public DeportivaMoto(String matricula, String marca, String modelo,
                         int anioFabricacion, int kilometros, double precio,
                         Estado estado, Persona propietario,
                         int cilindrada, int peso, double alturaAsiento,
                         TipoTransmision transmision,
                         double velMax, boolean quickShifter) {
        super(matricula, marca, modelo, anioFabricacion, kilometros, precio,
                estado, propietario, cilindrada, peso, alturaAsiento, transmision);
        this.velMax = velMax;
        this.quickShifter = quickShifter;
    }
}
