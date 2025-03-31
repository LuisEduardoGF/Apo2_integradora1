package model;

import java.util.LinkedList;

public class Controller {
    private LinkedList<Ruta> rutas;
    private LinkedList<Conductor> conductores;
    private LinkedList<Pasajero> pasajeros;
    private LinkedList<Incidente> incidentes;
    private LinkedList<Reporte> reportes;

    public Controller() {
        this.rutas = new LinkedList<>();
        this.conductores = new LinkedList<>();
        this.pasajeros = new LinkedList<>();
        this.incidentes = new LinkedList<>();
        this.reportes = new LinkedList<>();
    }

    // Métodos para agregar
    public void agregarRuta(Ruta ruta) {
        rutas.add(ruta);
    }

    public void agregarConductor(Conductor conductor) {
        conductores.add(conductor);
    }

    public void agregarPasajero(Pasajero pasajero) {
        pasajeros.add(pasajero);
    }

    public void agregarIncidente(Incidente incidente) {
        incidentes.add(incidente);
    }

    public void agregarReporte(Reporte reporte) {
        reportes.add(reporte);
    }

    // Métodos para buscar por ID sin Optional
    public Ruta buscarRuta(String id) {
        for (Ruta r : rutas) {
            if (r.getIdRuta().equals(id)) {
                return r;
            }
        }
        return null; // Retorna null si no se encuentra
    }

    public Conductor buscarConductor(String id) {
        for (Conductor c : conductores) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public Conductor buscarConductorPorNombre(String nombre) {
        for (Conductor c : conductores) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null; // Retorna null si no se encuentra
    }

    public Pasajero buscarPasajero(String id) {
        for (Pasajero p : pasajeros) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public Incidente buscarIncidente(String id) {
        for (Incidente i : incidentes) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null;
    }



    public Reporte buscarReporte(String id) {
        for (Reporte r : reportes) {
            if (r.getId().equals(id)) {
                return r;
            }
        }
        return null;
    }

    // Métodos para eliminar
    public boolean eliminarRuta(String id) {
        Ruta ruta = buscarRuta(id);
        return ruta != null && rutas.remove(ruta);
    }

    public boolean eliminarConductor(String id) {
        Conductor conductor = buscarConductor(id);
        return conductor != null && conductores.remove(conductor);
    }

    public boolean eliminarPasajero(String id) {
        Pasajero pasajero = buscarPasajero(id);
        return pasajero != null && pasajeros.remove(pasajero);
    }

    public boolean eliminarIncidente(String id) {
        Incidente incidente = buscarIncidente(id);
        return incidente != null && incidentes.remove(incidente);
    }

    public boolean eliminarReporte(String id) {
        Reporte reporte = buscarReporte(id);
        return reporte != null && reportes.remove(reporte);
    }

    // Métodos para obtener las listas
    public LinkedList<Ruta> getRutas() {
        return rutas;
    }

    public LinkedList<Conductor> getConductores() {
        return conductores;
    }

    public LinkedList<Pasajero> getPasajeros() {
        return pasajeros;
    }

    public LinkedList<Incidente> getIncidentes() {
        return incidentes;
    }

    public LinkedList<Reporte> getReportes() {
        return reportes;
    }
    public void guardarDatos() {
        ManejadorJSON.guardarDatos(this);
    }

    public void cargarDatos() {
        ManejadorJSON.cargarDatos(this);
    }

}


