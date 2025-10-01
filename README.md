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
- **API REST** para transcripción de ADN a ARN con endpoints HTTP
- Un método llamado `transcribeDnaToRna` que toma una secuencia de ADN como entrada y devuelve su secuencia complementaria de ARN
- Soporte para transcripción de nucleótidos individuales y secuencias completas
- Validación de entrada y manejo de errores
- Documentación de API con Swagger (próximamente)

### Endpoints de la API

#### 1. POST `/api/transcription/transcribe`
Transcribe una secuencia de ADN usando JSON.

**Request:**
```json
{
  "dnaSequence": "GCTA"
}
```

**Response:**
```json
{
  "dnaSequence": "GCTA",
  "rnaSequence": "CGAU",
  "message": "Transcripción completada exitosamente"
}
```

#### 2. GET `/api/transcription/transcribe/{dnaSequence}`
Transcribe una secuencia de ADN usando parámetro de URL.

**Ejemplo:** `GET /api/transcription/transcribe/GCTA`

**Response:**
```json
{
  "dnaSequence": "GCTA",
  "rnaSequence": "CGAU",
  "message": "Transcripción completada exitosamente"
}
```

#### 3. GET `/api/transcription/health`
Verifica el estado de la API.

**Response:** `"RNA Transcription API is running"`

### Ejemplo de Uso Programático

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

### Prerrequisitos
- Java 21 o superior
- Maven 3.6 o superior

### Pasos de Instalación
```bash
git clone https://github.com/AnaBHernandez/Rna_Transcription.git
cd Rna_Transcription
mvn clean install
mvn spring-boot:run
```

La aplicación estará disponible en `http://localhost:8082`

### Ejemplos de Uso con cURL

#### Transcripción con POST
```bash
curl -X POST http://localhost:8082/api/transcription/transcribe \
  -H "Content-Type: application/json" \
  -d '{"dnaSequence": "GCTA"}'
```

#### Transcripción con GET
```bash
curl http://localhost:8082/api/transcription/transcribe/GCTA
```

#### Verificar estado de la API
```bash
curl http://localhost:8082/api/transcription/health
```

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