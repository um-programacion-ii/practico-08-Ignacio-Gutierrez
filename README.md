# prog2.2024.practico08


# Libros y Autores  
Crear una aplicación básica de gestión de bibliotecas. La aplicación debe manejar dos entidades principales: Libro y Autor, y demostrar el uso de JPA/ORM/Hibernate, la creación de repositorios, controladores, servicios y consultas avanzadas.

### . Descripción de entidad y repository
**Tarea**:
- Definir la entidad `Libro` con los atributos `id`, `titulo`, `isbn` y una relación con la entidad `Autor`.
- Definir la entidad `Autor` con los atributos `id`, `nombre`, `nacionalidad` y una relación con la entidad `Libro`.
- Crear interfaces de repositorio para `Libro` y `Autor` que extiendan `JpaRepository`.

### . Definir consultas con `derivedQuery` y JPQL
**Tarea**:
- Crear un método en el repositorio de `Libro` que busque libros por título usando derived queries.
- Crear una consulta JPQL personalizada en el repositorio de `Libro` para buscar libros por título.

### . CRUD con controlador y servicio
**Tarea**:
- Crear servicios para `Libro` y `Autor` que proporcionen métodos para crear, leer, actualizar y eliminar registros.
- Crear controladores REST para `Libro` y `Autor` que expongan endpoints CRUD.

### . Consultas con Criteria y Specification
**Tarea**:
- Crear una clase Specification para `Libro` que permita filtrar libros por título.
- Modificar el servicio de `Libro` para incluir un método que use Specification para realizar consultas dinámicas.

### . Relaciones entre tablas `@OneToOne` y `@OneToMany`
**Tarea**:
- Definir una relación `@OneToMany` entre `Autor` y `Libro`.
- Definir una relación `@ManyToOne` entre `Libro` y `Autor`.
- Asegurarse de que las entidades y las relaciones estén correctamente mapeadas en la base de datos.
- Construir un endpoint que me permita consultar un `Autor` y la respuesta incluya todos los `Libro` del mismo autor.
- La respuesta de la consulta de un `Libro` debe incluir el `Autor` relacionado

### . Inicialización
**Tarea**:
- Generar datos mínimos suficientes para demostrar la funcionalidad solicitada.

### . Ampliar README.md
**Tarea**:
- Extender el archivo README con la especificación de cada endpoint y un `curl` que demuestre el uso y un ejemplo del resultado obtenido




# Biblioteca API

## Endpoints

### Libro

- **Crear Libro**
  - `POST /libros`
  - Request Body:
    ```json
    {
      "titulo": "Frankenstein",
      "isbn": "9780520201798"
    }
    ```
  - Response:
    ```json
    {
      "id": 10,
      "titulo": "Frankenstein",
      "isbn": "9780520201798"
    }
    ```

- **Obtener Libro por ID**
  - `GET /libros/{id}`
  - Response:
    ```json
    {
      "id": 1,
      "titulo": "El amor en los tiempos del cólera",
      "isbn": "9788439735427"
    }
    ```

- **Obtener todos los Libros**
  - `GET /libros`
  - Response:
    ```json
    [
      {
        "id": 1,
        "titulo": "El amor en los tiempos del cólera",
        "isbn": "9788439735427"
      },
      {
        "id": 2,
        "titulo": "Cien años de soledad",
        "isbn": "9780060114183"
      },
      {
        "id": 3,
        "titulo": "Harry Potter and the Chamber of Secrets",
        "isbn": "9788869185182"
      },
    ]
    ```

- **Editar Libro**
  - `PUT /libros/{id}`
  - Request Body:
    ```json
    {
      "titulo": "Frankenstein",
      "isbn": "9780520201798"
    }
    ```
  - Response:
    ```json
    {
      "id": 1,
      "titulo": "Frankenstein",
      "isbn": "9780520201798"
    }
    ```

- **Borrar Libro por ID**
  - `DELETE /libros/{id}`
  - Response:
    ```json

    ```

### Autor

- **Crear Autor**
  - `POST /autores`
  - Request Body:
    ```json
    {
      "nombre": "Mary Shelley",
      "nacionalidad": "Británico"
    }
    ```
  - Response:
    ```json
    {
      "id": 6,
      "nombre": "Mary Shelley",
      "nacionalidad": "Británico",
      "libros": []
    }
    ```

- **Obtener Autor por ID**
  - `GET /autores/{id}`
  - Response:
    ```json
    {
      "id": 1,
      "nombre": "Gabriel García Márquez",
      "nacionalidad": "Colombiano",
      "libros": [
        {
          "id": 2,
          "titulo": "Cien años de soledad",
          "isbn": "9780060114183"
        },
        {
          "id": 1,
          "titulo": "El amor en los tiempos del cólera",
          "isbn": "9788439735427"
        }
      ]
    }
    ```

- **Obtener todos los Autores**
  - `GET /autores`
  - Response:
    ```json
    [
      {
        "id": 1,
        "nombre": "Gabriel García Márquez",
        "nacionalidad": "Colombiano",
        "libros": [
          {
            "id": 2,
            "titulo": "Cien años de soledad",
            "isbn": "9780060114183"
          },
          {
            "id": 1,
            "titulo": "El amor en los tiempos del cólera",
            "isbn": "9788439735427"
          }
        ]
      },
    ]
    ```

- **Editar Autor**
  - `PUT /autores/{id}`
  - Request Body:
    ```json
    {
      "nombre": "Mary Shelley",
      "nacionalidad": "Británico",
      "libros": [
        {
          "id": 10,
          "titulo": "Frankenstein",
          "isbn": "9780520201798"
        }
      ]
    }
    ```
  - Response:
    ```json
    {
      "nombre": "Mary Shelley",
      "nacionalidad": "Británico",
      "libros": [
        {
          "id": 10,
          "titulo": "Frankenstein",
          "isbn": "9780520201798"
        }
      ]
    }
    ```

- **Borrar Autor por ID**
  - `DELETE /autores/{id}`
  - Response:
    ```json
    
    ```


## Ejemplos de uso con `curl`

- Crear un autor:
  curl -X POST http://localhost:8080/libros -H "Content-Type: application/json" -d '{"titulo": "Frankenstein","isbn": "9780520201798"}'