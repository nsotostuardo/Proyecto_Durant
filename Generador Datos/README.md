# 📝 Generador de datos 📝

Ejecutable del generador en ```>> ultimo_generador.exe```.

# 😸 Descripción: 😸
Desarrollado en Lenguaje C, se despliega un menú que permite: 

- (i) Elegir el tamaño de la grilla (N). 
- (ii) Visualizar los datos dentro de la grilla. 
- (iii) Generar un archivo ```datos.txt```.
- (iv) Salir.

La grilla creada es de NxN, definida por el usuario en (i). Entrega un output tipo .csv en formato .txt, sin los nombres de las columnas en el siguiete orden.

```pos_x, pos_y, tipo_terreno, altura, tipo, n_depredadores, n_reina, n_obreras, n_soldados, n_scouts, %_alimento"```

Los valores que componen cada fila son generados aleatoreamente siguiendo reglas. Unicamente, las posiciones son fijas.

# 🔍 Detalles variables: 🔍
Breve explicación de los valores obtenidos por el generador.

- pos_x: posición en X en la grilla.
- pos_y: posición en Y en la grilla.
- tipo_terreno: tipo del terreno de la casilla, i.e., rio, tiera, o roca.
- altura: altura relativa de la casilla.
- tipo: tipo de entidad que aloja en la casilla: 0 casilla vacia, 1 casilla con colonia de hormiga, 2 casilla con depredadores.
- n_depredadores: cantidad de depredadores.
- n_reina: cantidad de hormigas reinas.
- n_obreras: cantidad de hormigas obreras.
- n_soldados: cantidad de hormigas soldados.
- n_scouts: cantidad de hormigas scouts.
- %_alimento: porcentaje de alimento disponible en la casilla.

# ❌ Reglas de terrenos: ⭕

Cada terreno, es decir una sección de la grilla debe cumplir con las siguientes reglas.

- ```tipo_terreno``` debe ser: rio, roca o tierra, ningun otro. Ninguna casilla tiene más de un tipo.

- ```altura``` es aleatorio, pero esta restringido segun el tipo de terreno: rio -> [0,3], tierra -> [4,9] y roca -> [9,19].

- ```tipo```: solo puede tener un tipo de entidad (hormiga o depredador) la casilla o ninguna.

- ```n_reina```: cada colonia solo puede tener una reina al generarse la grilla.

