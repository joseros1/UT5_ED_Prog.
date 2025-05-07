package com.ut5.ejerc;

import com.ut5.ejerc.utils.Validar;
import com.ut5.ejerc.utils.Valorable;

import java.time.LocalDate;
import java.util.*;

public class Principal {
    private static Scanner sc = new Scanner(System.in);
    private static List<Vehiculo> inventario = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = sc.nextInt(); sc.nextLine();
            switch (opcion) {
                case 1: registrarVehiculo(); break;
                case 2: listarVehiculos(); break;
                case 3: buscarVehiculo(); break;
                case 4: asignarVehiculo(); break;
                case 5: resumenRiesgo(); break;
                case 6: calcularDepreciacion(); break;
                case 7: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción no válida.");
            }
        } while (opcion != 7);
    }

    private static void mostrarMenu() {
        System.out.println("\n===== Concesionario APP =====");
        System.out.println("1. Registrar Vehículo");
        System.out.println("2. Listar Vehículos");
        System.out.println("3. Buscar Vehículo");
        System.out.println("4. Asignar Vehículo");
        System.out.println("5. Resumen Riesgo");
        System.out.println("6. Calcular Depreciación");
        System.out.println("7. Salir");
        System.out.print("Selecciona una opción: ");
    }

    private static void registrarVehiculo() {
        System.out.println("\n-- Registrar Vehículo --");
        System.out.println("Tipos: 1=Coche, 2=Moto, 3=Camión");
        int tipo = sc.nextInt(); sc.nextLine();
        try {
            Vehiculo v;
            switch (tipo) {
                case 1: v = crearCoche(); break;
                case 2: v = crearMoto(); break;
                case 3: v = crearCamion(); break;
                default:
                    System.out.println("Tipo no válido."); return;
            }
            inventario.add(v);
            System.out.println("Vehículo registrado correctamente.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static Coche crearCoche() {
        System.out.print("Matrícula: ");
        String matricula;
        do {
            matricula = sc.nextLine();
            try {
                Validar.validarMatricula(matricula);
                break;
            } catch (Exception e) {
                System.out.print("Matrícula inválida, reintente: ");
            }
        } while (true);

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Año de Fabricación: ");
        int ano = sc.nextInt(); sc.nextLine();

        System.out.print("Kilometraje: ");
        int km = sc.nextInt(); sc.nextLine();

        System.out.print("Precio: ");
        double precio = sc.nextDouble(); sc.nextLine();

        System.out.println("Estado (1=DISPONIBLE,2=VENDIDO): ");
        Estado est = sc.nextInt() == 2 ? Estado.VENDIDO : Estado.DISPONIBLE;
        sc.nextLine();

        System.out.print("Num Puertas (3 o 5): ");
        int puertas = sc.nextInt(); sc.nextLine();

        System.out.println("Tipo Combustible (GASOLINA,DIESEL,HIBRIDO,ELECTRICO): ");
        TipoCombustible comb = TipoCombustible.valueOf(sc.nextLine().toUpperCase());

        System.out.print("Capacidad Maletero (L): ");
        int maletero = sc.nextInt(); sc.nextLine();

        System.out.println("Tracción (DELANTERA,TRASERA,X4): ");
        Traccion trac = Traccion.valueOf(sc.nextLine().toUpperCase());

        System.out.println("Subtipo: 1=Sedan,2=SUV,3=Deportivo");
        int sub = sc.nextInt(); sc.nextLine();

        switch (sub) {
            case 1:
                System.out.print("Espacio Interior (m3): ");
                double espacio = sc.nextDouble(); sc.nextLine();
                NivelConfort nf = NivelConfort.valueOf(pedirEnum("Nivel Confort (BASICO,MEDIO,PREMIUM): "));
                return new Sedan(matricula, marca, modelo, ano, km, precio, est, null,
                        puertas, comb, maletero, trac, espacio, nf);
            case 2:
                System.out.print("Cap Offroad (true/false): ");
                boolean off = sc.nextBoolean(); sc.nextLine();
                System.out.print("Altura Libre Suelo (cm): ");
                double altura = sc.nextDouble(); sc.nextLine();
                return new SUV(matricula, marca, modelo, ano, km, precio, est, null,
                        puertas, comb, maletero, trac, off, altura);
            case 3:
                System.out.print("0-100 km/h (s): ");
                double acel = sc.nextDouble(); sc.nextLine();
                System.out.print("Potencia CV: ");
                int cv = sc.nextInt(); sc.nextLine();
                System.out.print("Modo Pista (true/false): ");
                boolean pista = sc.nextBoolean(); sc.nextLine();
                return new Deportivo(matricula, marca, modelo, ano, km, precio, est, null,
                        puertas, comb, maletero, trac, acel, cv, pista);
            default:
                throw new IllegalArgumentException("Subtipo coche inválido");
        }
    }

    private static Moto crearMoto() {
        System.out.print("Matrícula: ");
        String matricula;
        do {
            matricula = sc.nextLine();
            try {
                Validar.validarMatricula(matricula);
                break;
            } catch (Exception e) {
                System.out.print("Matrícula inválida, reintente: ");
            }
        } while (true);

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Año de Fabricación: ");
        int ano = sc.nextInt(); sc.nextLine();

        System.out.print("Kilometraje: ");
        int km = sc.nextInt(); sc.nextLine();

        System.out.print("Precio: ");
        double precio = sc.nextDouble(); sc.nextLine();

        System.out.println("Estado (1=DISPONIBLE,2=VENDIDO): ");
        Estado est = sc.nextInt() == 2 ? Estado.VENDIDO : Estado.DISPONIBLE;
        sc.nextLine();

        System.out.print("Cilindrada (cc): ");
        int cil = sc.nextInt(); sc.nextLine();

        System.out.print("Peso (kg): ");
        int peso = sc.nextInt(); sc.nextLine();

        System.out.print("Altura Asiento (cm): ");
        double altura = sc.nextDouble(); sc.nextLine();

        TipoTransmision tt = TipoTransmision.valueOf(pedirEnum("Transmision (MANUAL,AUTOMATICA): "));

        System.out.println("Subtipo: 1=Scooter,2=Deportiva");
        int sub = sc.nextInt(); sc.nextLine();

        switch (sub) {
            case 1:
                System.out.print("Espacio Bajo Asiento (L): ");
                int esp = sc.nextInt(); sc.nextLine();
                return new Scooter(matricula, marca, modelo, ano, km, precio, est, null,
                        cil, peso, altura, tt, esp);
            case 2:
                System.out.print("Velocidad Max (km/h): ");
                double vm = sc.nextDouble(); sc.nextLine();
                System.out.print("QuickShifter (true/false): ");
                boolean qs = sc.nextBoolean(); sc.nextLine();
                return new DeportivaMoto(matricula, marca, modelo, ano, km, precio, est, null,
                        cil, peso, altura, tt, vm, qs);
            default:
                throw new IllegalArgumentException("Subtipo moto inválido");
        }
    }

    private static Camion crearCamion() {
        System.out.print("Matrícula: ");
        String matricula;
        do {
            matricula = sc.nextLine();
            try {
                Validar.validarMatricula(matricula);
                break;
            } catch (Exception e) {
                System.out.print("Matrícula inválida, reintente: ");
            }
        } while (true);

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Año de Fabricación: ");
        int ano = sc.nextInt(); sc.nextLine();

        System.out.print("Kilometraje: ");
        int km = sc.nextInt(); sc.nextLine();

        System.out.print("Precio: ");
        double precio = sc.nextDouble(); sc.nextLine();

        System.out.println("Estado (1=DISPONIBLE,2=VENDIDO): ");
        Estado est = sc.nextInt() == 2 ? Estado.VENDIDO : Estado.DISPONIBLE;
        sc.nextLine();

        System.out.print("Capacidad Carga (t): ");
        double carga = sc.nextDouble(); sc.nextLine();

        System.out.print("Num Ejes (>=2): ");
        int ejes = sc.nextInt(); sc.nextLine();

        System.out.print("Longitud Remolque (m): ");
        double lon = sc.nextDouble(); sc.nextLine();

        System.out.print("Potencia Motor (CV): ");
        int cv = sc.nextInt(); sc.nextLine();

        return new Camion(matricula, marca, modelo, ano, km, precio, est, null,
                carga, ejes, lon, cv);
    }

    private static String pedirEnum(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine().trim().toUpperCase().replace("Ñ", "N");
    }

    private static void listarVehiculos() {
        System.out.println("\n-- Inventario de Vehículos --");
        if (inventario.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
        } else {
            inventario.forEach(v -> System.out.println(v));
        }
    }

    private static Vehiculo buscarPorMatricula(String mat) {
        return inventario.stream()
                .filter(v -> v.getMatricula().equalsIgnoreCase(mat))
                .findFirst().orElse(null);
    }

    private static void buscarVehiculo() {
        System.out.print("Matrícula a buscar: ");
        Vehiculo v = buscarPorMatricula(sc.nextLine());
        System.out.println(v != null ? v : "Vehículo no encontrado.");
    }

    private static void asignarVehiculo() {
        System.out.print("Matrícula a asignar: ");
        Vehiculo v = buscarPorMatricula(sc.nextLine());
        if (v == null || v.getPropietario() != null) {
            System.out.println("No disponible para asignar.");
            return;
        }
        Persona p = crearPersona();
        v.setPropietario(p);
        v.setEstado(Estado.VENDIDO);
        System.out.println("Asignado a " + p.getNombreCompleto());
    }

    private static Persona crearPersona() {
        System.out.print("Nombre y Apellidos: ");
        String nombre = sc.nextLine();
        System.out.print("DNI: ");
        String dni;
        do {
            dni = sc.nextLine().toUpperCase();
            try {
                Validar.validarDni(dni);
                break;
            } catch (Exception e) {
                System.out.print("Inválido, reintente: ");
            }
        } while (true);
        System.out.print("Año obtención carnet: ");
        int anioCarnet = sc.nextInt(); sc.nextLine();
        System.out.print("Año nacimiento: ");
        int anioNac = sc.nextInt(); sc.nextLine();
        return new Persona(nombre, dni, anioCarnet, anioNac);
    }

    private static void resumenRiesgo() {
        System.out.println("\n-- Resumen de Riesgo --");
        inventario.stream()
                .filter(v -> v.getPropietario() != null)
                .forEach(v ->
                        System.out.printf("%s -> Riesgo: %.2f%n",
                                v.getMatricula(), v.calcularRiesgo())
                );
    }

    private static void calcularDepreciacion() {
        System.out.println("\n-- Cálculo de Depreciación --");
        for (Vehiculo v : inventario) {
            double dep = ((Valorable)v).calcularDepreciacion();
            System.out.printf("%s -> Depreciación: %.2f€%n",
                    v.getMatricula(), dep);
        }
    }
}

