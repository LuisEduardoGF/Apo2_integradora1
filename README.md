<<<<<<< HEAD
# Apo2_integradora1
# Sistema de Gestión y Monitoreo de Movilidad y Seguridad (SGMMS)

Este proyecto es una solución orientada a objetos para gestionar rutas, conductores, incidentes, pasajeros y reportes dentro de un sistema urbano de movilidad.

---

## Descripción General

El sistema permite:

- Registrar y consultar rutas, conductores, pasajeros e incidentes  
- Buscar elementos por nombre o ID  
- Ordenar rutas e incidentes por distancia, tiempo o fecha  
- Generar reportes en consola  
- Persistencia mediante archivos JSON  
- Manejo de errores con excepciones personalizadas  
- Pruebas unitarias para cada funcionalidad  

---

## Estructura del Proyecto
src/
??? main/
?   ??? java/
?       ??? model/       ? Clases del modelo + Controller + JSON + excepciones
?       ??? ui/          ? Clase Main con menú de consola
??? test/
?   ??? java/
?       ??? model/       ? ControllerTest.java
lib/                    ? gson-2.10.1.jar
docs/                   ? Requerimientos, UML

---

## Tecnologías

- Java 17  
- Maven  
- JUnit 5  
- Gson 2.10.1  

---

## Funcionalidades (RF)

| Código | Descripción                              |
|--------|------------------------------------------|
| RF1    | Registrar rutas                          |
| RF2    | Registrar incidentes                     |
| RF3    | Registrar conductores                    |
| RF4    | Buscar conductores por nombre            |
| RF5    | Buscar incidentes por ID                 |
| RF6    | Ordenar rutas por distancia o tiempo     |
| RF7    | Ordenar incidentes por fecha/hora        |
| RF8    | Mostrar reportes simples en consola      |
| RF9    | Guardar y cargar archivos JSON           |
| RF10   | Manejar excepciones personalizadas       |

---

## Pruebas de Unidad

- Se realizaron mínimo 2 pruebas por funcionalidad
- Las pruebas se encuentran en `ControllerTest.java`
- Cobertura de:
  - Agregado de elementos  
  - Búsquedas  
  - Excepciones  
  - Ordenamientos  
  - Persistencia de datos  

---

## Indicadores de Calidad

| Iteración   | Commit SHA     | Densidad de errores | Confiabilidad | Completitud |
|-------------|----------------|---------------------|----------------|--------------|
| Iteración 1 | `<commit-sha>` | 0.2012              | 0.7988         | 2.32         |
| Iteración 2 | `<commit-sha>` | 0.4043              | 0.5957         | 3.01         |

**Fórmulas:**

- Densidad = total de fallos / total de pruebas  
- Confiabilidad = 1 - densidad  
- Completitud = casos de prueba / total funcionalidades  

---

## Diagrama UML

El diagrama de clases UML se encuentra en la carpeta `/docs` bajo el nombre `TI1APO2complemento.jpg`.

---

## Requerimientos

- Requerimientos funcionales y no funcionales documentados  
- Documento incluido en `/docs` y como entrega adicional en Word  

---

## Ejecución

Desde IntelliJ:

1. Abrir el proyecto como Maven Project  
2. Asegurarse de incluir la librería Gson (`lib/gson-2.10.1.jar`)  
3. Ejecutar `Main.java` desde `src/main/java/ui/`  

---
=======
# Apo2_integradora1
>>>>>>> 7370fd7b8c67e3eda3dfb6be4086ca369e5955fe
