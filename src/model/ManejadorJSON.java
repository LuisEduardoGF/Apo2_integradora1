package model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.LinkedList;

public class ManejadorJSON {
    private static final String CARPETA_BASE = "base_datos";

    public static void guardarDatos(Controller controller) {
        Gson gson = new Gson();
        crearCarpetaSiNoExiste();

        try {
            guardarLista("conductores.json", controller.getConductores(), gson);
            guardarLista("pasajeros.json", controller.getPasajeros(), gson);
            guardarLista("rutas.json", controller.getRutas(), gson);
            guardarLista("incidentes.json", controller.getIncidentes(), gson);
            guardarLista("reportes.json", controller.getReportes(), gson);
            System.out.println("✅ Datos guardados correctamente.");
        } catch (IOException e) {
            System.out.println("❌ Error al guardar datos: " + e.getMessage());
        }
    }

    public static void cargarDatos(Controller controller) {
        Gson gson = new Gson();

        try {
            controller.getConductores().addAll(cargarLista("conductores.json", new TypeToken<LinkedList<Conductor>>() {}.getType(), gson));
            controller.getPasajeros().addAll(cargarLista("pasajeros.json", new TypeToken<LinkedList<Pasajero>>() {}.getType(), gson));
            controller.getRutas().addAll(cargarLista("rutas.json", new TypeToken<LinkedList<Ruta>>() {}.getType(), gson));
            controller.getIncidentes().addAll(cargarLista("incidentes.json", new TypeToken<LinkedList<Incidente>>() {}.getType(), gson));
            controller.getReportes().addAll(cargarLista("reportes.json", new TypeToken<LinkedList<Reporte>>() {}.getType(), gson));
            System.out.println("✅ Datos cargados correctamente.");
        } catch (IOException e) {
            System.out.println("❌ Error al cargar datos: " + e.getMessage());
        }
    }

    private static <T> void guardarLista(String nombreArchivo, LinkedList<T> lista, Gson gson) throws IOException {
        FileWriter writer = new FileWriter(CARPETA_BASE + "/" + nombreArchivo);
        gson.toJson(lista, writer);
        writer.close();
    }

    private static <T> LinkedList<T> cargarLista(String nombreArchivo, Type tipoLista, Gson gson) throws IOException {
        File archivo = new File(CARPETA_BASE + "/" + nombreArchivo);
        if (!archivo.exists()) {
            return new LinkedList<>();
        }
        FileReader reader = new FileReader(archivo);
        LinkedList<T> lista = gson.fromJson(reader, tipoLista);
        reader.close();
        return lista != null ? lista : new LinkedList<>();
    }

    private static void crearCarpetaSiNoExiste() {
        File carpeta = new File(CARPETA_BASE);
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }
    }
}
