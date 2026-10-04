# Reproductor de música con estructuras de datos

Simulación de un reproductor tipo Spotify en Java, desarrollada para la asignatura de Estructuras de Datos (UNED, curso 2023-2024). Gestiona una colección de canciones, listas de reproducción, una cola de reproducción y el historial de canciones recientes.

## Estructuras de datos utilizadas

| Clase | Qué gestiona | Estructura |
| --- | --- | --- |
| `PlayBackQueue` | Cola de reproducción | `Queue` (y `List`) |
| `RecentlyPlayed` | Canciones reproducidas recientemente | `Stack` (y `List`) |
| `PlayList` | Lista de reproducción | `List` |
| `TuneCollection` | Colección de canciones | `List` |
| `PlayListManager` | Gestión de las listas de reproducción | `List` |
| `Player` | Reproductor | `List` |

## Diseño
- Cada clase implementa una interfaz (`PlayListIF`, `TuneCollectionIF`, `PlayerIF`...) que define su contrato, separando la especificación de la implementación.
- Los recorridos se hacen con iteradores (`IteratorIF`).

## Nota sobre las dependencias
Las estructuras `List`, `Queue` y `Stack` pertenecen a la librería de la asignatura (`es.uned.lsi.eped.DataStructures`), que no se incluye en este repositorio por ser material docente. Para compilar el proyecto hay que añadirla al classpath.

## Tecnologías
Java · TADs (listas, colas y pilas) · interfaces · iteradores
