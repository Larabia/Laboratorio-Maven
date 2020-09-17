# Laboratorio-Maven
Sistema ABM integrado con Spring Core y base de datyos SQL.

Permite subir, modificar, dar de baja y listar el contenido de una base de datos SQL.
En este proyecto se suma la creación de BEANS al sistemaABM sobre el que venía trabajando. Si bien el manejo de Beans en Spring Core es un poco más analógico que en Spring Boot, este proyecto es muy útil para ver el funcionamiento de los beans en acción. Se introduce también la tabla ventas para hacer interactuar dos tablas.

## Diseño de la base 📦
Tabla: PERSONA Columnas: ID, NOMBRE, EDAD, FECHA_NACIMIENTO
Podes cargar el archivo Script.sql para crear la tabla!

## Construído con 🛠️

* [Maven](https://maven.apache.org/) - dependencies manager
* [Hibernate](https://hibernate.org/) - framework 
* [Spring Core](https://spring.io/) - framework 
* [Junit](https://junit.org/junit4/) - unitary testing 
* [mysql](https://www.mysql.com/products/workbench/) - Database service
* [Eclipse](https://www.eclipse.org/downloads/) - IDE

### Menú de opciones del programa 📋
Menu opciones: 1- Alta |2- Modificacion |3- Baja |4- Listado Personas|5- Buscar por nombre |6- Cargar venta |7- Listado Ventas |0- Salir

#### Listado de Métodos ⌨️

- mostrarMenu() Método de utilización interna que muestra por pantalla el menu, solicita al usuario que ingrese una opcion, la guarda en una variable y la devuelve.

- alta() Método de tipo POST que permite ingresar el nombre y la fecha de nacimiento de una persona, calcula la edad llamando a calcularEdad() y persiste los tres datos en la base generando un id.

- modificacion() Método de tipo PUT que toma como parametro un id, busca a la persona en la base, muestra los datos de la persona, pide que el usuario seleccione el dato que desea modificar, solicita el nuevo dato y luego lo persiste en la base.

- baja() Método de tipo DELETE que toma como parametro un id, busca a la persona en la base, muestra los datos de la persona, pide confirmación del usuario y luego borra los datos de la base.

- listado() Método de tipo GET que muestra un listado de todos los datos presentes en la tabla Persona.

- buscarXnombre() Método de tipo GET que le solicita al usuario que ingrese un nombre o las primeras letras del mismo y trae un listado de todas las personas de la base con las que encuentra correspondencia.

- mostrarPorID() Método de tipo GET que recibe como parámetro un id, realiza la consulta a la base y devuelve los datos de la persona correspondiente.

- cargarVenta() Toma un id de persona, verifica que exista y, de ser asi, lo asocia con la venta, solicita al usuario el monto de la venta, toma la fecha actual y persiste los tres datos en la base.

- mostrarListadoVentas() Método de tipo GET que muestra un listado de todos los datos presentes en la tabla Venta.

- mostrarPersona(PersonaEntity per) Metodo interno que toma un objeto persona y lo formatea para imprimirlo en pantalla. 

- mostrarVenta(PersonaEntity per) Metodo interno que toma un objeto venta y lo formatea para imprimirlo en pantalla. 

Capa Service ---------------------

- formatSdf() formatea un objeto date.

- formatParse() toma un String fecha y lo transforma en un objeto Date.

- currentDate() decuelve un objeto Date con la fecha actual.

- calcularEdad() Método de utilización interna que toma como parámetro una fechadenacimiento y utiliza la fecha actual para realizar el cálculo y devolver la edad de la persona.

