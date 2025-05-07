package com.ut5.ejerc;

public class Scooter extends Moto {
    private int espacioBajoAsiento;

    public Scooter(String matricula, String marca, String modelo,
                   int anioFabricacion, int kilometros, double precio,
                   Estado estado, Persona propietario,
                   int cilindrada, int peso, double alturaAsiento,
                   TipoTransmision transmision,
                   int espacioBajoAsiento) {
        super(matricula, marca, modelo, anioFabricacion, kilometros, precio,
                estado, propietario, cilindrada, peso, alturaAsiento, transmision);
        this.espacioBajoAsiento = espacioBajoAsiento;
    }
}
