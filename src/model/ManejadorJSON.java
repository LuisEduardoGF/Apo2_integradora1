package model;

import com.google.gson.Gson;

import java.io.*;
import java.util.LinkedList;

public class ManejadorJSON {

    private static final String CARPETA_BASE = "base_datos";

    public static void guardarDatos(Controller controller) {
        Gson gson = new Gson();
        crearCarpetaSiNoExiste();

        try {
            guardarConductores(controller.getConductores(), gson);
            guardarPasajeros(controller.getPasajeros(), gson);
            guardarRutas(controller.getRutas(), gson);
            guardarIncidentes(controller.getIncidentes(), gson);
            guardarReportes(controller.getReportes(), gson);
            System.out.println("Datos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }

    public static void cargarDatos(Controller controller) {
        Gson gson = new Gson();

        try {
            controller.getConductores().addAll(cargarConductores(gson));
            controller.getPasajeros().addAll(cargarPasajeros(gson));
            controller.getRutas().addAll(cargarRutas(gson));
            controller.getIncidentes().addAll(cargarIncidentes(gson));
            controller.getReportes().addAll(cargarReportes(gson));
            System.out.println("Datos cargados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al cargar datos: " + e.getMessage());
        }
    }

    private static void guardarConductores(LinkedList<Conductor> lista, Gson gson) throws IOException {
        FileWriter writer = new FileWriter(CARPETA_BASE + "/conductores.json");
        gson.toJson(lista, writer);
        writer.close();
    }

    private static LinkedList<Conductor> cargarConductores(Gson gson) throws IOException {
        File archivo = new File(CARPETA_BASE + "/conductores.json");
        if (!archivo.exists()) return new LinkedList<>();
        FileReader reader = new FileReader(archivo);
        Conductor[] arreglo = gson.fromJson(reader, Conductor[].class);
        reader.close();
        LinkedList<Conductor> lista = new LinkedList<>();
        if (arreglo != null) {
            for (Conductor c : arreglo) {
                lista.add(c);
            }
        }
        return lista;
    }

    private static void guardarPasajeros(LinkedList<Pasajero> lista, Gson gson) throws IOException {
        FileWriter writer = new FileWriter(CARPETA_BASE + "/pasajeros.json");
        gson.toJson(lista, writer);
        writer.close();
    }

    private static LinkedList<Pasajero> cargarPasajeros(Gson gson) throws IOException {
        File archivo = new File(CARPETA_BASE + "/pasajeros.json");
        if (!archivo.exists()) return new LinkedList<>();
        FileReader reader = new FileReader(archivo);
        Pasajero[] arreglo = gson.fromJson(reader, Pasajero[].class);
        reader.close();
        LinkedList<Pasajero> lista = new LinkedList<>();
        if (arreglo != null) {
            for (Pasajero p : arreglo) {
                lista.add(p);
            }
        }
        return lista;
    }

    private static void guardarRutas(LinkedList<Ruta> lista, Gson gson) throws IOException {
        FileWriter writer = new FileWriter(CARPETA_BASE + "/rutas.json");
        gson.toJson(lista, writer);
        writer.close();
    }

    private static LinkedList<Ruta> cargarRutas(Gson gson) throws IOException {
        File archivo = new File(CARPETA_BASE + "/rutas.json");
        if (!archivo.exists()) return new LinkedList<>();
        FileReader reader = new FileReader(archivo);
        Ruta[] arreglo = gson.fromJson(reader, Ruta[].class);
        reader.close();
        LinkedList<Ruta> lista = new LinkedList<>();
        if (arreglo != null) {
            for (Ruta r : arreglo) {
                lista.add(r);
            }
        }
        return lista;
    }

    private static void guardarIncidentes(LinkedList<Incidente> lista, Gson gson) throws IOException {
        FileWriter writer = new FileWriter(CARPETA_BASE + "/incidentes.json");
        gson.toJson(lista, writer);
        writer.close();
    }

    private static LinkedList<Incidente> cargarIncidentes(Gson gson) throws IOException {
        File archivo = new File(CARPETA_BASE + "/incidentes.json");
        if (!archivo.exists()) return new LinkedList<>();
        FileReader reader = new FileReader(archivo);
        Incidente[] arreglo = gson.fromJson(reader, Incidente[].class);
        reader.close();
        LinkedList<Incidente> lista = new LinkedList<>();
        if (arreglo != null) {
            for (Incidente i : arreglo) {
                lista.add(i);
            }
        }
        return lista;
    }

    private static void guardarReportes(LinkedList<Reporte> lista, Gson gson) throws IOException {
        FileWriter writer = new FileWriter(CARPETA_BASE + "/reportes.json");
        gson.toJson(lista, writer);
        writer.close();
    }

    private static LinkedList<Reporte> cargarReportes(Gson gson) throws IOException {
        File archivo = new File(CARPETA_BASE + "/reportes.json");
        if (!archivo.exists()) return new LinkedList<>();
        FileReader reader = new FileReader(archivo);
        Reporte[] arreglo = gson.fromJson(reader, Reporte[].class);
        reader.close();
        LinkedList<Reporte> lista = new LinkedList<>();
        if (arreglo != null) {
            for (Reporte r : arreglo) {
                lista.add(r);
            }
        }
        return lista;
    }

    private static void crearCarpetaSiNoExiste() {
        File carpeta = new File(CARPETA_BASE);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
    }
}
