<<<<<<< HEAD
# Apo2_integradora1
# Sistema de Gesti�n y Monitoreo de Movilidad y Seguridad (SGMMS)

Este proyecto es una soluci�n orientada a objetos para gestionar rutas, conductores, incidentes, pasajeros y reportes dentro de un sistema urbano de movilidad.

---

## Descripci�n General

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
?       ??? ui/          ? Clase Main con men� de consola
??? test/
?   ??? java/
?       ??? model/       ? ControllerTest.java
lib/                    ? gson-2.10.1.jar
docs/                   ? Requerimientos, UML

---

## Tecnolog�as

- Java 17  
- Maven  
- JUnit 5  
- Gson 2.10.1  

---

## Funcionalidades (RF)

| C�digo | Descripci�n                              |
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

- Se realizaron m�nimo 2 pruebas por funcionalidad
- Las pruebas se encuentran en `ControllerTest.java`
- Cobertura de:
  - Agregado de elementos  
  - B�squedas  
  - Excepciones  
  - Ordenamientos  
  - Persistencia de datos  

---

## Indicadores de Calidad

| Iteraci�n   | Commit SHA     | Densidad de errores | Confiabilidad | Completitud |
|-------------|----------------|---------------------|----------------|--------------|
| Iteraci�n 1 | `<commit-sha>` | 0.2012              | 0.7988         | 2.32         |
| Iteraci�n 2 | `<commit-sha>` | 0.4043              | 0.5957         | 3.01         |

**F�rmulas:**

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

## Ejecuci�n

Desde IntelliJ:

1. Abrir el proyecto como Maven Project  
2. Asegurarse de incluir la librer�a Gson (`lib/gson-2.10.1.jar`)  
3. Ejecutar `Main.java` desde `src/main/java/ui/`  

---
=======
# Apo2_integradora1
>>>>>>> 7370fd7b8c67e3eda3dfb6be4086ca369e5955fe
