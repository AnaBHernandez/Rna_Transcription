# RNA Transcription

## Descripción

Este proyecto implementa una transcripción de ADN a ARN utilizando Java. La transcripción convierte cada nucleótido de ADN en su nucleótido complementario de ARN, siguiendo las reglas de transcripción.

## Reglas de Complementación

- **G** (Guanina) -> **C** (Citosina)
- **C** (Citosina) -> **G** (Guanina)
- **T** (Timina) -> **A** (Adenina)
- **A** (Adenina) -> **U** (Uracilo)

## Funcionalidad

El proyecto incluye:
- Un método llamado `transcribeDnaToRna` que toma una secuencia de ADN como entrada y devuelve su secuencia complementaria de ARN.
- Soporte para transcripción de nucleótidos individuales y secuencias completas.

### Ejemplo de Uso

```java
String result = RnaTranscription.transcribeDnaToRna("GCTA");
```

## Tests

El proyecto sigue la metodología TDD (Test-Driven Development). Los tests aseguran que la lógica de transcripción funciona correctamente en diferentes casos.

Casos probados:
- Transcripción de Guanina a Citosina.
- Transcripción de Citosina a Guanina.
- Transcripción de Timina a Adenina.
- Transcripción de Adenina a Uracilo.
- Transcripción de secuencias completas como GCTA -> CGAU.

Ejecución de Tests:
Utiliza JUnit para ejecutar las pruebas unitarias incluidas en la clase RnaTranscriptionTest.

## Requisitos
- Java 11 o superior
- JUnit 5 para pruebas unitarias

## Instalación
```bash
git clone https://github.com/AnaBHernandez/Rna_Transcription.git
cd Rna_Transcription
```

Importa el proyecto en tu IDE favorito (Eclipse, IntelliJ, VS Code) o compílalo desde la línea de comandos.

## Cómo contribuir
Realiza un fork del repositorio.
```bash
git checkout -b feature/nueva-funcionalidad
```

Realiza tus cambios y súbelos:
```bash
git add .
git commit -m "Añadida nueva funcionalidad X"
git push origin feature/nueva-funcionalidad
```

Crea un pull request.

## Autor
Este proyecto fue desarrollado por Ana BHernandez