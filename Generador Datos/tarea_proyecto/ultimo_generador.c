#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h> //libreria de bools
int obtener_registros(){ //funcion obtener largo mapa NxN
    int a;
    printf("  Ingresando la cantidad de secciones: ");
    scanf("%d", &a);
    if(a<1){
        printf("  La cantidad debe ser >=1, guardando valor 1.\n");
        return (1);
    }else{
        return (a);
    }
}

int obtener_datos(){ //funcion para obtener los N datos.
    int b;
    printf("  Ingrese la cantidad de datos en el registros: ");
    scanf("%d", &b);
    if(b != 4){
        printf("  La cantidad debe ser =4, guardando valor 4. (Por ahora)\n");
        return (4);
    }else{
        return (b);
    }
}

int random_hight_terrein(char* terreno){
    // Generar alturas randoms para cada tipo de terreno
    if (strcmp(terreno, "rio") == 0){
        return rand() % 4;          // 0–3
    } else if (strcmp(terreno, "tierra") == 0){
        return rand() % 6 + 4;      // 4–9
    } else {
        return rand() % 11 + 9;     // 9–19
    }
}

int random_number_entities() { 
    // Genera numero entero [0, 200]
    return rand() % 201;
}

int random_type() { //Genera un random para saber si es Depredador, Nada o Hormiga
    // 0: nada, 1: hormiga , 2: depredador
    return rand() % 3;
}

float random_food_percentaje() { // Genera % float aleatorio
    float a = rand()/ (float)RAND_MAX; //RAND_MAX constante
    return a * 100.0;
}

char* random_type_terrain(){ //seleccionamos terreno random
    int i = rand() % 3;
    if (i == 0){
        return "rio";
    }else{
        if (i == 1){
            return "tierra";
            }else{
                return "roca";
        }
    }
}

int main() {
    int opcion; 
    int n_registros = 3;
    int n_datos = 6;
    int pos_x = 0;
    int pos_y = 0;
    int tipo_h = 0;
    int n_dep = 0;
    int altura = 0;
    int n_reinas, n_obreras, n_soldados, n_scouts = 0;
    char* tipo_terreno;
    FILE *fptr;

    do {
        printf("\n-------------  Menu   -------------  ");
        printf("\nSeleccione una opcion: ");
        printf("\n1) Cantidad de registros a generar (NxN).");
        printf("\n2) Mostrar datos.");
        printf("\n3) Generar archivo.");
        printf("\n4) Salir.\nOpcion: ");
        scanf("%d", &opcion);
        switch (opcion){
            case 1: // largo del tablero
                n_registros = obtener_registros();
                break; 
            case 2: // N datos
                printf("\n  %d numero de registros\n",n_registros);
                printf("pos_x, pos_y, tipo_terreno, altura, tipo, n_depredadores, n_reina, n_obreras, n_soldados, n_scouts, %%_alimento\n");

                for(pos_y = 0; pos_y < n_registros; pos_y++){
                    for(pos_x = 0; pos_x < n_registros; pos_x++){
                        tipo_terreno =  random_type_terrain();
                        printf("%d, %d, %s, %d, ", pos_y, pos_x, tipo_terreno, random_hight_terrein(tipo_terreno));
                        tipo_h = random_type();
                        printf("%d, ", tipo_h);
                        switch (tipo_h)
                        {
                        case 1: //hormigas
                            n_dep = 0;
                            n_reinas = 1;
                            n_obreras = random_number_entities();
                            n_soldados = random_number_entities(); 
                            n_scouts = random_number_entities();
                            break; 
                        case 2: //depredador
                            n_dep = random_number_entities();
                            n_reinas =0; 
                            n_obreras =0;
                            n_soldados =0;
                            n_scouts = 0;
                            break;

                        default: //nada1
                            n_dep = 0;
                            n_reinas =0; 
                            n_obreras =0;
                            n_soldados =0;
                            n_scouts = 0;
                            break;
                        }
                        
                        printf("%d, %d, %d, %d, %d, ", n_dep, n_reinas, n_obreras, n_soldados, n_scouts);
                        printf("%.2f\n", random_food_percentaje());
                    }
                }
                break;    
            case 3: // Generar
                printf("\n Escribiendo registro en datos.txt \n");
                fptr = fopen("datos.txt", "w");
                fclose(fptr);
                fptr = fopen("datos.txt", "a");
                for(pos_y = 0; pos_y < n_registros; pos_y++){
                    for(pos_x = 0; pos_x < n_registros; pos_x++){
                        tipo_terreno =  random_type_terrain();
                        fprintf(fptr,"%d, %d, %s, %d, ", pos_y, pos_x, tipo_terreno, random_hight_terrein(tipo_terreno));
                        tipo_h = random_type();
                        fprintf(fptr,"%d, ", tipo_h);
                        switch (tipo_h)
                        {
                        case 1: //hormigas
                            n_dep = 0;
                            n_reinas = 1;
                            n_obreras = random_number_entities();
                            n_soldados = random_number_entities(); 
                            n_scouts = random_number_entities();
                            break; 
                        case 2: //depredador
                            n_dep = random_number_entities();
                            n_reinas =0; 
                            n_obreras =0;
                            n_soldados =0;
                            n_scouts = 0;
                            break;

                        default: //nada1
                            n_dep = 0;
                            n_reinas =0; 
                            n_obreras =0;
                            n_soldados =0;
                            n_scouts = 0;
                            break;
                        }
                        
                        fprintf(fptr,"%d, %d, %d, %d, %d, ", n_dep, n_reinas, n_obreras, n_soldados, n_scouts);
                        fprintf(fptr,"%.2f\n", random_food_percentaje());
                        //fprintf(fptr, "%d, %d, ", pos_y, pos_x);
                        //tipo_h = random_type();
                        //fprintf(fptr, "%d, ", tipo_h);
                        //if (tipo_h == 0){n_dep = 0;}
                        //else{n_dep = random_number_entities();}
                        //fprintf(fptr, "%d, ", n_dep);
                        //fprintf(fptr, "%.2f, ", random_food_percentaje());
                        //fprintf(fptr, "%s \n", random_type_terrain()); 
                    }
                }
                fclose(fptr); // Close the file
                break; 
            case 4:
                printf("..... Saliendo .....\n");
                break;
            default:
                printf("ERROR! Opcion invalida.\n");
        }
    }while(opcion !=4);
    
}