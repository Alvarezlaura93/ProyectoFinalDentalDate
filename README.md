# ProyectoFinalDentalDate

PARA PODER CORRER EL PROYECTO NECESITAMOS. 

JAVA 8
Springboot 
Spring Security 

---DOCUMENTACION---
20/4/22 - Realizamos los diseños - Figma y Canva |
21/4/22 - Index - Entidades|
25/4/22 - Estructura de seguridad con Spring Security|
26/4/22 - class Repositorio y class Servicio |
2/5/22 - 4 escenarios web listos para usar |
3/5/22 - class controladores listas| 
4/5/22 - class controladores error y security| 
5/5/22 - error en class controladores y servicios| 
9/5/22 - error en controladores, login, index,security,herencia| 
10/5/22 - modificaciones y arreglos en entidades (Salvados por Adri Bestilleiro)| 
11/5/22 - agregado de css, formulario turno en funcionamiento| 
12/5/22 - (ayuda de juanma con algunos errores)| 
13/5/22 - vista de en funcionamiento   de vista de turnos para el admin| 
13/5/22 - Testing Funcional de web Dental Date| 
27/4/22 - Santy nos sugiere usar Herencia. (Usted se tiene que arrepentir de lo que dijo)| 
14/5/22 - Arreglo del bug del navbar en el front| 
21/4/22 - Investigacion de sitios web similares|


Preguntas principales

¿como guarda un turno ? - primero el usuario accede al formTurno.html (controller "/formTurno") , automaticamente al estar logueado muestra sus datos y selecciona el dia . Al guardar llama al controller /guardarTurno/ .

¿como se registra el usuario ?- ingresa al formulario.html ( Controller "/mostrarFormulario/") y guarda sus datos  (th:text y "post")

¿como se registra el admin ? - desde la pagina del admin puede llenar el fomulario /formOdo y guardarse como admin
¿como muestra los turnos al admin ? - Desde el controlador /turnoAdmin/  con el metodo mostrarTurnos() 
llamamos a las List- Turnos y Pacientes. Luego en adminturno.html con thymelaf en  la etiqueta < tbody> th:ecth= "{paciente} "
nos trae un solo array List paciente. Y traemos List Turnos en la etiqueta <p th:etch= ${turnos] >

  
