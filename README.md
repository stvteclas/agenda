
Agenda Virtual Besysoft

Resumen
Este proyecto se genera a raíz de la necesidad de originar una idea para un nuevo proyecto
título, que por supuesto surgió de una necesidad real de resolver un problema, el cual es una
agenda web personal flexible. Una agenda es un Libro o cuaderno en que se apunta, para no
olvidarlo aquello que se ha de hacer (Diccionario de la Real Academia de la Lengua
Española), y uno de los usos más importante es la ayuda en gestionar algo tan valioso como
el tiempo.
Ya con la elección de este nuevo desafío, se comienza estudiando y analizando lo que es una
agenda, para qué sirve y qué contiene. Luego de resolver esta duda y entender la importancia
de este cuaderno, el cual organiza nuestro valioso tiempo, sabemos los reales beneficios de
crear una agenda, la que se adapte a nuestros tiempos y necesidades.
Este proyecto, concretamente, tiene como propósito la creación de una agenda web personal
flexible, que satisfaga las necesidades del propietario mucho más allá que una agenda
tradicional. Esta agenda tendrá la facultad de ingresar Empresas y Contactos, que tienen una
serie de atributos los cuales ayudarán a tener una mayor gestión de esta, y además, se tendrá
la opción de generar distintos reportes, los cuales serán gestionados según las necesidades
del propietario.
Para llevar a cabo este proyecto, se seleccionó una metodología de desarrollo llamado
“Cascada”, la cual contiene distintas etapas, donde el inicio de cada una de ellas depende de la
fase anterior.
El objetivo final al cual debemos llegar, es cumplir todos los requerimientos del propietario, y
que este aprenda a utilizar esta agenda web de forma fácil y sencilla, con acceso rápido y en
cualquier lugar. Que gestione sus datos de forma simple, sin la más mínima dificultad


Deberá implementarse la funcionalidad básica de una agenda:

- Se podrán almacenar datos sobre personas como también datos sobre empresas y los contactos de esta.

- Al agregar un contacto a la empresa, este debe haber sido anteriormente agregado a la agenda. 

- Una empresa podría tener varios contactos.

- Debe implementarse distintos tipos de buscadores de personas, por ejemplo buscar por nombre, o por ciudad.

- Agregar un buscador que permita encontrar personas en varias ciudades, por ejemplo todos los 'Juan Pérez' de 'Buenos Aires' y 'Córdoba'.

- La agenda tendrá que implementar el manejo de excepciones correctamente.

- Deberá diseñarse un Diagrama de Entidad Relación para la solución.

- Deberá ejecutarse por consola y se almacenarán los datos en memoria.





Paradigma de Programación:


El paradigma de programación a utilizar en este proyecto es "La Programación Orientada a
Objetos", este brinda un alcance favorable en diseño, desarrollo y mantención del software,
ofreciendo soluciones de forma rápida a los problemas y preocupaciones que han existido
desde el comienzo en el desarrollo de software: tales como la falta de portabilidad del código
y reusabilidad, código que es difícil de modificar, ciclos de desarrollo largos y técnicas de
codificación no intuitivas.
Su visión, es que los problemas a solucionar pueden ser representados con objetos, los cuales
poseen un significado y comportamiento como los elementos del mundo real. Las
características que tiene este paradigma es:
 Herencia: Donde una clase nueva se crea a partir de una clase existente, permite
obtener características y comportamientos comunes desde un objeto con una
morfología generalizada a partir de un conjunto de objetos similares.Universidad del Bío-Bío. Red de Bibliotecas - Chile
15
 Encapsulamiento: Evita el acceso a datos por cualquier otro medio distinto a los
especificados. Por lo tanto, la encapsulación garantiza la integridad de los datos que
contiene un objeto.
 Modularidad: Permite modificar las características de las clases que definen a un
objeto, de forma independiente a las demás clases dentro de la aplicación.
 Abstracción: Expresa las características esenciales de un objeto, las cuales
distinguen al objeto de los demás.
 Polimorfismo: Capacidad que tienen los objetos de una clase de responder al mismo
mensaje o evento en función de los parámetros utilizados durante su invocación. Un
objeto polimórfico es una entidad que puede contener valores de diferentes tipos
durante la ejecución del programa.
3.2.3 Arquitectura
La arquitectura o patrón a utilizar es MVC (Modelo Vista Controlador), la cual su
arquitectura está dividida en tres capas, los datos de la aplicación, interfaz de usuario y la
lógica de control.
 Modelo: Contiene todo el contenido específico de la aplicación y la lógica de
procesamiento, e incluye todos los objetos de contenido, el acceso a fuentes de
datos externas y toda la funcionalidad de procesamiento que son específicos de la
aplicación.
 Vista: Contiene todas las funciones específicas de la interfaz y habilita la
presentación del contenido y la lógica de procesamiento, e incluye a todos los
objetos de contenido, acceso a fuentes de datos externas y a toda la funcionalidad
de procesamiento requerida por el usuario final.
 Controlador: Este responde a eventos, usualmente acciones del usuario, e invoca
peticiones al modelo y, probablemente, a la vista.Universidad del Bío-Bío. Red de Bibliotecas - Chile
16
Algunas ventajas de este patrón:
 El diseño modular permite trabajar a diferentes desarrolladores en paralelo.
 Sus vistas muestran información actualizada siempre. El programador no debe
preocuparse de solicitar que las vistas se actualicen, ya que este proceso es
realizado automáticamente por el modelo de la aplicación.
 Podrás dividir la lógica de negocio del diseño, haciendo tu proyecto más escalable.
 Estabilidad en la aplicación debido al mejor control que tenemos sobre ella.
 Las modificaciones a las vistas no afectan al modelo de dominio, simplemente se
modifica la representación de la información, no su tratamiento


