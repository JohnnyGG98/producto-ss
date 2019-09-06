# Producto - SS

Parte administrativa de ecomerce ShopShop.

### Indicaciones generales
**Rutas**
- Todas las rutas deben ser especificadas en el archivo RUTAS.md
- Documentar claramente para que sirve esa  ruta, y especificar que tipo de metodo recibe (GET, POST, PUT, DELETE).
- Documentar los parametros que recibe la ruta, si es que los recibe.

**Controllers**
- Seria importante que en la carpeta de controllers se cree una carpeta interna con el numero de la version. Empezando siempre desde la 1.
- La carpeta version o la ruta version siempre empezara con una "v" seguida por el numero correspondiente.
- Todos los controladores deben especificar una ruta que comience con api/< version >/< clase >

**Documentacion**
- Toda los cambios deben ser documentados en el archivo DOCUMENTACION.md
- Cada que se realice un cambios o se corrija un error o bug debera ser indicado en ese archivo.
- Es importante que se indique la fecha, de moficacion.
- Si se agrega alguna libreria, se de indicar en este archivo, en la parte de dependencias.
- Importante indicar que tipo de cambio es:
  - Bug.
  - Mejora codigo.
  - Mejora de eficiencia.
  - Mas funcionalidad.

### Dependencias
Aqui se debe indicar todas las dependencias extras del proyecto, son las dependencias que agregamos al pom.xml.
```
# Nombre de la dependencia y comentar porque se agrego
```
