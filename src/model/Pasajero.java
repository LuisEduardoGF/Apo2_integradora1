package model;

public class Pasajero {
    private String idPasajero;
    private String nombre;
    private String telefono;

    public Pasajero(String idPasajero, String nombre, String telefono) {
        if (idPasajero == null || idPasajero.isEmpty()) {
            throw new IllegalArgumentException("ID de pasajero es obligatorio");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Nombre del pasajero es obligatorio");
        }
        if (telefono == null || telefono.isEmpty()) {
            throw new IllegalArgumentException("Número de teléfono es obligatorio");
        }
        this.idPasajero = idPasajero;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getId() {
        return idPasajero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Nombre del pasajero es obligatorio");
        }
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.isEmpty()) {
            throw new IllegalArgumentException("Número de teléfono es obligatorio");
        }
        this.telefono = telefono;
    }
}