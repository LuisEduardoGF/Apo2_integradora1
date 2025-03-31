package model;

public class Conductor {
    private String idConductor;
    private String nombre;
    private String licencia;

    public Conductor(String idConductor, String nombre, String licencia) {
        if (idConductor == null || idConductor.isEmpty()) {
            throw new IllegalArgumentException("ID de conductor es obligatorio");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Nombre del conductor es obligatorio");
        }
        if (licencia == null || licencia.isEmpty()) {
            throw new IllegalArgumentException("Número de licencia es obligatorio");
        }
        this.idConductor = idConductor;
        this.nombre = nombre;
        this.licencia = licencia;
    }

    public String getId() {
        return idConductor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Nombre del conductor es obligatorio");
        }
        this.nombre = nombre;
    }

    public void setLicencia(String licencia) {
        if (licencia == null || licencia.isEmpty()) {
            throw new IllegalArgumentException("Número de licencia es obligatorio");
        }
        this.licencia = licencia;
    }
}
