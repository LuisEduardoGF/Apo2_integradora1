package model;

public class Incidente {
    private String idIncidente;
    private String descripcion;
    private String severidad;

    public Incidente(String idIncidente, String descripcion, String severidad) {
        if (idIncidente == null || idIncidente.isEmpty()) {
            throw new IllegalArgumentException("ID de incidente es obligatorio");
        }
        if (descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("Descripción del incidente es obligatoria");
        }
        if (severidad == null || severidad.isEmpty()) {
            throw new IllegalArgumentException("La severidad es obligatoria");
        }
        this.idIncidente = idIncidente;
        this.descripcion = descripcion;
        this.severidad = severidad;
    }

    public String getId() {
        return idIncidente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getSeveridad() {
        return severidad;
    }

    public void setDescripcion(String descripcion) {
        if (descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("Descripción del incidente es obligatoria");
        }
        this.descripcion = descripcion;
    }

    public void setSeveridad(String severidad) {
        if (severidad == null || severidad.isEmpty()) {
            throw new IllegalArgumentException("La severidad es obligatoria");
        }
        this.severidad = severidad;
    }
}
