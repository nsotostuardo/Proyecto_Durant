# 📝 Backend 📝

El código principal se encuentra en ```>> Hormigas/src/clases_hormiga/Main.java```.

# 😸 Descripción: 😸
Desarrollado en Lenguaje Java, permite instanciar todo la informacion del archivo ```datos.txt``` independientemente del tamaño de la grilla seleccionada.

# 😼 Notas: 😼
Ahora el Backend funciona utilizando sockets con un protocolo TCP. El Path ahora es entregado desde el frontend, pero manejado por el backend.

## 📂 Directorio 📂 
El directorio principal se encuentra en ```src/clase_hormiga```. Se pueden identificar tres secciones, el Main.java, y Datos.txt

- ```Grilla```: contiene todas las clases referente a las estructuras que conforman cada seccion de una grilla.

- ```Hormigas```: Contiene todas las clases referentes a las hormigas y los tipos de ellas, que heredan de la clase abstracta Hormiga.

- ```Miscelaneo```: Contiene el eje de los depredadores, alimentos y constantes globales.