package ui;

import model.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();

        while (true) {
            System.out.println("\n--- Sistema de Gestión y Monitoreo de Movilidad y Seguridad ---");
            System.out.println("1. Agregar Ruta");
            System.out.println("2. Agregar Conductor");
            System.out.println("3. Agregar Pasajero");
            System.out.println("4. Agregar Incidente");
            System.out.println("5. Agregar Reporte");
            System.out.println("6. Mostrar Rutas");
            System.out.println("7. Buscar Conductor por Nombre");
            System.out.println("8. Buscar Incidente por ID");
            System.out.println("9. Cargar Datos");
            System.out.println("10. guardarDatos");
            System.out.println("11. Mostrar Rutas Ordenadas por Distancia");
            System.out.println("12. Mostrar Incidentes Ordenados por Fecha");
            System.out.println("13. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ID de la Ruta: ");
                    String idRuta = scanner.nextLine();
                    System.out.print("Ingrese Distancia: ");
                    double distancia = scanner.nextDouble();
                    System.out.print("Ingrese Tiempo Estimado: ");
                    double tiempo = scanner.nextDouble();
                    scanner.nextLine();
                    controller.agregarRuta(new Ruta(idRuta, distancia, tiempo));
                    System.out.println("Ruta agregada exitosamente.");
                    break;
                case 2:
                    System.out.print("Ingrese ID del Conductor: ");
                    String idConductor = scanner.nextLine();
                    System.out.print("Ingrese Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese Número de Licencia: ");
                    String licencia = scanner.nextLine();
                    controller.agregarConductor(new Conductor(idConductor, nombre, licencia));
                    System.out.println("Conductor agregado exitosamente.");
                    break;
                case 3:
                    System.out.print("Ingrese ID del Pasajero: ");
                    String idPasajero = scanner.nextLine();
                    System.out.print("Ingrese Nombre: ");
                    String nombrePasajero = scanner.nextLine();
                    System.out.print("Ingrese Teléfono: ");
                    String telefono = scanner.nextLine();
                    controller.agregarPasajero(new Pasajero(idPasajero, nombrePasajero, telefono));
                    System.out.println("Pasajero agregado exitosamente.");
                    break;
                case 4:
                    System.out.print("Ingrese ID del Incidente: ");
                    String idIncidente = scanner.nextLine();
                    System.out.print("Ingrese Descripción: ");
                    String descripcionIncidente = scanner.nextLine();
                    System.out.print("Ingrese Severidad: ");
                    String severidad = scanner.nextLine();
                    controller.agregarIncidente(new Incidente(idIncidente, descripcionIncidente, severidad));
                    System.out.println("Incidente agregado exitosamente.");
                    break;
                case 5:
                    System.out.print("Ingrese ID del Reporte: ");
                    String idReporte = scanner.nextLine();
                    System.out.print("Ingrese Descripción: ");
                    String descripcionReporte = scanner.nextLine();
                    System.out.print("Ingrese Fecha: ");
                    String fecha = scanner.nextLine();
                    controller.agregarReporte(new Reporte(idReporte, descripcionReporte, fecha));
                    System.out.println("Reporte agregado exitosamente.");
                    break;
                case 6:
                    System.out.println("Lista de Rutas:");
                    for (Ruta ruta : controller.getRutas()) {
                        System.out.println("ID: " + ruta.getIdRuta() + ", Distancia: " + ruta.getDistancia() + ", Tiempo: " + ruta.getTiempoEstimado());
                    }
                    break;
                case 7:
                    System.out.print("Ingrese el nombre del conductor a buscar: ");
                    String nombreBusqueda = scanner.nextLine();
                    Conductor conductor = controller.buscarConductorPorNombre(nombreBusqueda);
                    if (conductor != null) {
                        System.out.println("Conductor encontrado: " + conductor.getNombre() + " - Licencia: " + conductor.getLicencia());
                    } else {
                        System.out.println("Conductor no encontrado.");
                    }
                    break;
                case 8:
                    System.out.print("Ingrese el ID del incidente a buscar: ");
                    String idBusqueda = scanner.nextLine();
                    Incidente incidente = controller.buscarIncidente(idBusqueda);
                    if (incidente != null) {
                        System.out.println("Incidente encontrado: " + incidente.getDescripcion() + " - Severidad: " + incidente.getSeveridad());
                    } else {
                        System.out.println("Incidente no encontrado.");
                    }
                    break;
                case 9:
                    controller.cargarDatos();
                                    
                    return;
                case 10:
                    controller.guardarDatos(); 
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                case 11:
                    controller.ordenarRutasPorDistancia();
                    System.out.println("Rutas ordenadas por distancia:");
                    for (Ruta r : controller.getRutas()) {
                        System.out.println(r.getIdRuta() + " - " + r.getDistancia() + " km");
                    }
                    break;
                case 12:
                    controller.ordenarIncidentesPorFecha();
                    System.out.println("Incidentes ordenados por fecha (más recientes primero):");
                    for (Incidente i : controller.getIncidentes()) {
                        System.out.println(i.getIdIncidente() + " - " + i.getFecha() + " - " + i.getTipo());
                    }
                    break;
                case 13:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}
