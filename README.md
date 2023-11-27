# TaskManager

Spring Boot App to manage tasks

## Features

| Feature                           | Status |
|-----------------------------------|--------|
| **Spring Boot Development**       |   ✅    |
| **Uses Amazon RDS**               |    ✅    |
| **Uses Hibernate to map objects** |    ✅    |
| **Task & User CRUD Controller**   |    ✅    |
| **Uses Spring Security**          |   ✅    |
| **Uses Maven**                    |    ✅    |
| **Simple Unit test implemented**  |    ✅    |

## Usage

1. Clone the project
2. Upload it in your preferred text editor or IDE (I used IntelliJ IDEA)
3. Request the cloud database password to my email (axelrvv@gmail.com)
4. Run the project
5. Make request either using PostMan, SoapUI or your local browser

## Essential Functions

| Url                                                | Functionality           | Method |
|----------------------------------------------------|-------------------------|--------|
| http://localhost:8080/task-manager/                | Home Controller         | GET    |
| http://localhost:8080/task-manager/tasks/          | Gets all existing tasks | GET    |
| http://localhost:8080/task-manager/users/          | Gets all existing users | GET    |
| http://localhost:8080/task-manager/tasks/          | Creates a new task      | POST   |
| http://localhost:8080/task-manager/users/          | Creates a new user      | POST   |
| http://localhost:8080/task-manager/tasks/{task_id} | Updates a task          | PUT    |
| http://localhost:8080/task-manager/users/{user_id} | Updates a user          | PUT    |
| http://localhost:8080/task-manager/tasks/{task_id} | Deletes a task          | DELETE |
| http://localhost:8080/task-manager/users/{user_id} | Deletes a user          | DELETE |

## Preguntas adicionales

**¿Cómo manejarías la paginación y la ordenación de las tareas?**

*En este proyecto los repositorios utilizan JpaRepository para paginación y ordenación en la consultas amplias de la base de datos de getAllTasks y getAllUsers, esa es una muy buena practica.* 

**¿Qué medidas tomarías para garantizar la seguridad de la aplicación?**

*Es bueno utilizar Spring Security para la autenticación este seria el 1er paso, tal como se implementa en este proyecto. Pero en adición, el manejo de usuarios de autenticación lo implementaría a nivel de base de datos con las contraseñas encriptadas. Y por ultimo, utilizaría comunicación HTTPS entre cliente-servidor para proteger la transferencia de datos.*

**¿Cómo escalarías esta aplicación si el número de usuarios y tareas aumentara
significativamente?**

*En un aplicativo hay muchas formas de enfrentarse a estas escalaciones, lo primero es evaluar que la capacidad del servidor donde se encuentra alocado tenga la capacidad de manejar las proyecciones de incremento que se van viendo, si este no es el caso pues se procede a aumentar las capacidades del servidor.*

*Lo 2do es tomar en consideración la posibilidad de dividir el API en servicios más pequeños (microservicios).*

*Otra opción validar las consultas de la base de datos (oportunidades de mejora), hacerle tuning a varios scripts de base de datos de ser necesario.*

*Pero en general, muchas de estas cosas se procuran en el diseño y desarrollo del servicio, si todo está estable a nivel de código el GO TO deberia ser aumentar las capacidades del servidor*

**¿Cómo gestionarías las actualizaciones de la base de datos sin tiempo de inactividad?**

*Esto tambien tiene muchas opciones es el día a día de un desarrollador, una opción puede ser tener una copia de la base de datos y esta sea utilizada para reportes y la segunda para las actualizaciones, y cada cierto tiempo definido se actualiza la copia de reportes.*