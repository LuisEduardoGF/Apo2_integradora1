package model;

public class Ruta {
    private String idRuta;
    private double distancia;
    private double tiempoEstimado;

    public Ruta(String idRuta, double distancia, double tiempoEstimado) {
        if (idRuta == null || idRuta.isEmpty()) {
            throw new IllegalArgumentException("ID de ruta es obligatorio");
        }
        if (distancia <= 0 || tiempoEstimado <= 0) {
            throw new IllegalArgumentException("Distancia y tiempo deben ser mayores a 0");
        }
        this.idRuta = idRuta;
        this.distancia = distancia;
        this.tiempoEstimado = tiempoEstimado;
    }

    public String getIdRuta() {
        return idRuta;
    }

    public double getDistancia() {
        return distancia;
    }

    public double getTiempoEstimado() {
        return tiempoEstimado;
    }

    public void setDistancia(double distancia) {
        if (distancia <= 0) {
            throw new IllegalArgumentException("La distancia debe ser mayor a 0");
        }
        this.distancia = distancia;
    }

    public void setTiempoEstimado(double tiempoEstimado) {
        if (tiempoEstimado <= 0) {
            throw new IllegalArgumentException("El tiempo estimado debe ser mayor a 0");
        }
        this.tiempoEstimado = tiempoEstimado;
    }
}
