# 📝 Backend 📝

El código principal se encuentra en ```>> Hormigas/src/clases_hormiga/Main.java```.

# 😸 Descripción: 😸
Desarrollado en Lenguaje Java, permite instanciar todo la informacion del archivo ```datos.txt``` independientemente del tamaño de la grilla seleccionada.

# 😿 Precaución 😿
Unicamente se debe cambiar en `\Miscelaneo\Constantes.java` la constante de la Interface ```PATH_TXT```, que hace referenia a donde se encuentra el archivo output del generador de datos, a leer por nuestro backend.

## 📂 Directorio 📂 
El directorio principal se encuentra en ```src/clase_hormiga```. Se pueden identificar tres secciones, el Main.java, y Datos.txt

- ```Grilla```: contiene todas las clases referente a las estructuras que conforman cada seccion de una grilla.

- ```Hormigas```: Contiene todas las clases referentes a las hormigas y los tipos de ellas, que heredan de la clase abstracta Hormiga.

- ```Miscelaneo```: Contiene el eje de los depredadores, alimentos y constantes globales.