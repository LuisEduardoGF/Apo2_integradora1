package model;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {

    // ---------- RF1: Registrar rutas ----------

    @Test
    public void agregarRuta_valida() {
        Ruta r = new Ruta("R1", 5.0, 10.0);
        assertEquals("R1", r.getIdRuta());
    }

    @Test
    public void agregarRuta_invalida() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Ruta("R2", -3.0, 15.0);
        });
    }

    // ---------- RF2: Registrar incidentes ----------

    @Test
    public void agregarIncidente_valido() {
        Incidente i = new Incidente("I1", "Robo", "Calle 5", "2024-03-29", "Ladron armado", Estado.PENDIENTE);
        assertEquals("I1", i.getIdIncidente());
    }

    @Test
    public void agregarIncidente_conDescripcionVacia() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Incidente("I2", "Accidente", "Carrera 10", "2024-03-30", "", Estado.PENDIENTE);
        });
    }

    // ---------- RF3: Registrar conductores ----------

    @Test
    public void agregarConductor_valido() {
        Conductor c = new Conductor("C1", "Laura", "ZXC123");
        assertEquals("Laura", c.getNombre());
    }

    @Test
    public void agregarConductor_conNombreVacio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Conductor("C2", "", "ABC987");
        });
    }

    // ---------- RF4: Buscar conductores por nombre ----------

    @Test
    public void buscarConductor_existe() throws ConductorNoEncontradoException {
        Controller controller = new Controller();
        controller.agregarConductor(new Conductor("1", "Pedro", "LIC123"));
        Conductor c = controller.buscarConductorPorNombre("Pedro");
        assertEquals("Pedro", c.getNombre());
    }

    @Test
    public void buscarConductor_noExiste() {
        Controller controller = new Controller();
        assertThrows(ConductorNoEncontradoException.class, () -> {
            controller.buscarConductorPorNombre("Juan");
        });
    }

// ---------- RF5: Buscar incidente por ID ----------

    @Test
    public void buscarIncidente_existe() throws IncidenteNoEncontradoException {
        Controller controller = new Controller();
        controller.agregarIncidente(new Incidente("I1", "Robo", "Centro", "2024-03-30", "Robo en local", Estado.EN_PROCESO));
        Incidente i = controller.buscarIncidentePorId("I1");
        assertEquals("I1", i.getIdIncidente());
    }

    @Test
    public void buscarIncidente_noExiste() {
        Controller controller = new Controller();
        assertThrows(IncidenteNoEncontradoException.class, () -> {
            controller.buscarIncidentePorId("XXX");
        });
    }

// ---------- RF6: Ordenar rutas por distancia ----------

    @Test
    public void ordenarRutasPorDistancia() {
        Controller controller = new Controller();
        controller.agregarRuta(new Ruta("R2", 15, 30));
        controller.agregarRuta(new Ruta("R1", 5, 10));
        controller.ordenarRutasPorDistancia();

        assertEquals("R1", controller.getRutas().get(0).getIdRuta());
    }

    @Test
    public void ordenarRutasPorTiempo() {
        Controller controller = new Controller();
        controller.agregarRuta(new Ruta("R3", 20, 50));
        controller.agregarRuta(new Ruta("R4", 10, 25));
        controller.ordenarRutasPorTiempo();

        assertEquals("R4", controller.getRutas().get(0).getIdRuta());
    }

// ---------- RF7: Ordenar incidentes por fecha/hora ----------

    @Test
    public void ordenarIncidentesPorFecha() {
        Controller controller = new Controller();
        controller.agregarIncidente(new Incidente("I1", "Robo", "Zona A", "2024-03-29", "Desc", Estado.RESUELTO));
        controller.agregarIncidente(new Incidente("I2", "Robo", "Zona B", "2024-03-30", "Desc", Estado.RESUELTO));
        controller.ordenarIncidentesPorFecha();

        assertEquals("I2", controller.getIncidentes().get(0).getIdIncidente());
    }

    @Test
    public void ordenarIncidentesPorFecha_reversa() {
        Controller controller = new Controller();
        controller.agregarIncidente(new Incidente("I3", "Accidente", "Zona C", "2024-03-01", "Desc", Estado.PENDIENTE));
        controller.agregarIncidente(new Incidente("I4", "Accidente", "Zona D", "2024-03-31", "Desc", Estado.PENDIENTE));
        controller.ordenarIncidentesPorFecha();

        assertEquals("I4", controller.getIncidentes().get(0).getIdIncidente());
    }

// ---------- RF9: Guardar y cargar JSON ----------

    @Test
    public void guardarYCargarDatos() {
        Controller controller = new Controller();
        controller.agregarConductor(new Conductor("10", "María", "XFD001"));
        controller.guardarDatos();

        Controller nuevo = new Controller();
        nuevo.cargarDatos();

        assertFalse(nuevo.getConductores().isEmpty());
        assertEquals("María", nuevo.getConductores().get(0).getNombre());
    }

    @Test
    public void guardarSinErrores() {
        Controller controller = new Controller();
        controller.agregarRuta(new Ruta("R10", 12, 30));
        assertDoesNotThrow(controller::guardarDatos);
    }
    @Test
    public void buscarIncidente_existe() throws IncidenteNoEncontradoException {
        Controller controller = new Controller();
        controller.agregarIncidente(new Incidente("I1", "Choque", "Calle 9", "2024-03-30", "Auto detenido", Estado.PENDIENTE));

        Incidente i = controller.buscarIncidentePorId("I1");

        assertEquals("Choque", i.getTipo());
    }

    @Test
    public void buscarIncidente_noExiste() {
        Controller controller = new Controller();
        assertThrows(IncidenteNoEncontradoException.class, () -> {
            controller.buscarIncidentePorId("ZZZ");
        });
    }

    @Test
    public void ordenarRutasPorDistancia_primeroMenor() {
        Controller controller = new Controller();
        controller.agregarRuta(new Ruta("R1", 30, 40));
        controller.agregarRuta(new Ruta("R2", 10, 20));

        controller.ordenarRutasPorDistancia();

        assertEquals("R2", controller.getRutas().get(0).getIdRuta());
    }

    @Test
    public void ordenarIncidentesPorFecha_masRecientePrimero() {
        Controller controller = new Controller();
        controller.agregarIncidente(new Incidente("I1", "Accidente", "Centro", "2024-03-28", "Detalles", Estado.RESUELTO));
        controller.agregarIncidente(new Incidente("I2", "Incendio", "Norte", "2024-03-30", "Detalles", Estado.EN_PROCESO));

        controller.ordenarIncidentesPorFecha();

        assertEquals("I2", controller.getIncidentes().get(0).getIdIncidente());
    }

}
