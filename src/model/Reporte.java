package model;

public class Reporte {
    private String idReporte;
    private String descripcion;
    private String fecha;

    public Reporte(String idReporte, String descripcion, String fecha) {
        if (idReporte == null || idReporte.isEmpty()) {
            throw new IllegalArgumentException("ID de reporte es obligatorio");
        }
        if (descripcion == null || descripcion.isEmpty()) {
            throw new IllegalArgumentException("Descripción del reporte es obligatoria");
        }
        if (fecha == null || fecha.isEmpty()) {
            throw new IllegalArgumentException("La fecha es obligatoria");
        }
        this.idReporte = idReporte;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public String getId() {
        return idReporte;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }
}
