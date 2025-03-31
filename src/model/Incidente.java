package model;

import java.util.Date;

public class Incidente {
    private String idIncidente;
    private String descripcion;
    private String severidad;

    private String tipo;
    private String ubicacion;
    private Date fechaHora;

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

        this.tipo = "Sin definir";
        this.ubicacion = "Desconocida";
        this.fechaHora = new Date(); 
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

    public String getIdIncidente() {
        return idIncidente;
    }

    public String getTipo() {
        return tipo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public Date getFechaHora() {
        return fechaHora;
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

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        return idIncidente + " - " + fechaHora + " - " + tipo + " - " + descripcion;
    }
}
