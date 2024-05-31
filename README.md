# Getting Started
El presente proyecto es parte de un grupo de 2 proyectos que juntos conforman un sistema CRUD que emplea el framework Spring, con Spring Boot, como backend, el framework Angular como frontend y una base de datos relacional en PostgreSQL.

El presente proyecto pone en evidencia los conocimientos adquiridos para la creación de este sistema CRUD.
La programación del mismo representó un reto interesante para mi debido a que he tenido que aprender los conceptos básicos y uso del Framework Spring con Spring Bootm.
En este proyecto se refleja mis conocimientos de principios SOLID 


## Prerrequisitos

### PostgreSQL 16

Se debe tener instalado PostgreSQL 16 y haber configurado el path para poder emplear los comandos psql en la terminal. En caso de solo tener instalado el PostgreSQL, se debe crear una base de datos en blanco llamada 'sindattechtest' y ejecutar el script sql adjunto en el correspondiente gestor de base de datos de PostgreSQL que uses.

 - Se adjunta un archivo sql-scripts.zip en donde se encuentra un cmd para automatizar la creación de la bbdd, y en caso que no se pueda. Ejecutar el contenido del archivo sql.
 - Debe haberse añadido PosgreSQL\bin a las variables de entorno para poder ejecutar el script en CMD generador de la base de datos.
 - Configurar el usuario y contraseña de PostgreSQL en el archivo CMD para generar la base de datos editando el mismo con bloc de notas.
 - Ejecutar el archivo CMD (se recomienda ejecutar con permisos de administrador).
 - Comprobar que se ha creado correctamente la base de datos 'sindattechtest' y sus tablas.

### Java jdk 17
Se debe tener instalado Java jdk en su versión 17.

### Postman
Se adiciona un enlace de postman para poder ejecutar las posibles consultas.
    
    https://www.postman.com/crimson-moon-223574/workspace/sintad-techtest-kevinpaima/

El uso del workspace en Postman requiere que se sigan los pasos que se describen al abrir el enlace.

### Pasos a seguir
Una vez clonado el repositorio se recomienda realizar la instalación de los paquetes.

Culminada la instalación de paquetes se debe proceder a correr el proyecto el cual inicia desde el archivo 'TechtestApplication.java' por defecto.

### Observación
No se pudo lograr las pruebas unitarias correspondientes a deleteById en los 3 servicios principales del CRUD.
