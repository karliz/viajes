README Reto ViajesTransparentes
============

##Dependencias
Es necesario contar con la máquina virtual de java, la versión 7 así como la versión 2.11 de Scala.
La aplicación se conecta a una base de datos mysql, se puede configurar la conexión, en el archivo DataBase.scala

- [JVM 1.7](http://www.oracle.com/technetwork/java/javase/downloads/java-se-jre-7-download-432155.html)
- [scala](http://www.scala-lang.org/download/)

##Instalación / Configuración
El proyecto está construido con el framework [Lift](http://liftweb.net/), [MySql](http://www.mysql.com/) y [D3](http://d3js.org/)
Para la base de datos será necesario realizar lo siguiente:

- ejecutar los comandos en init.sql, para crear tablas y añadir los datos del dataset
- modificar el archivo [DataBase.scala](https://github.com/netoho/viajes/blob/master/src/main/scala/code/model/DataBase.scala)

Una vez que este lista la base de datos, tengan la JVM y Scala, deberán ir al directorio raíz del proyecto y ejecutar

- ./sbt
- ~; container:start; container:reload /

Eso debería ser suficiente, ahora tendrán corriendo el puerto 8080 de la máquina el servidor

##Demo
Puede verse un demo en la siguiente liga:
 - [Demo AWS](http://voluntarios.elasticbeanstalk.com)

Se puede acceder como administrador (revisar archivo DataBase)

##Equipo
Indique los miembros del equipo principal que son responsables del desarrollo y mantenimiento de este proyecto. Añadir una referencia a sus perfiles de GitHub/Twitter/LinkedIn. Ejemplo:

- [Ernesto Huerta](https://github.com/netoho)
- [Arturo Cadena](https://github.com/arturocadena)

##Cartas de Protesta
Ambas cartas de protesta se encuentran dentro del directorio docs

- [Ernesto Huerta](https://github.com/netoho/viajes/blob/master/docs/ErnestoHuertaCarta.pdf)
- [Arturo Cadena](https://github.com/netoho/viajes/blob/master/docs/ArturoCadenaCarta.pdf)


##Licencia
Este proyecto está protegido bajo la licencia MIT.