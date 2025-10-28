/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases_hormiga;

import clases_hormiga.Miscelaneo.*;
import clases_hormiga.Grilla.*;
import clases_hormiga.Hormigas.*;

import java.io.File;                  
import java.io.FileNotFoundException; 
import java.util.Scanner;             
import java.util.ArrayList;           
import java.util.Random;              

public class Main implements Constantes{
    public static void main(String[] args) {
        
        // Main preMain

        File myObj = new File(PATH_TXT); 
        ListaTerrenos terrenos = new ListaTerrenos(); 
        Ambiente ambiente = new Ambiente(TEMPERATURA, CLIMA, HUMEDAD, UV);
        Random random = new Random();
        
        
        Comida c1 = new Comida("Plantas",100, 1, 1, 12);
        Comida c2 = new Comida("Agua",    50, 2, 1,  1);
        Comida c3 = new Comida("Insecto",  2, 3, 2,  3);
        Comida c4 = new Comida("Cubito Azucar",  10, 100, 1,  0);
        Comida c5 = new Comida("Manzana",  10, 100, 1,  500);
        
        ListaComidas lc = new ListaComidas(); 
        lc.agregarComida(c1);
        lc.agregarComida(c2);
        lc.agregarComida(c3);
        lc.agregarComida(c4);
        lc.agregarComida(c5);
        
        int[] lista_ids = {0,1,3,12, 500}; 
        int largo_ids = lista_ids.length;
        int random_idx;
        Comida cr;
        
        
        try (Scanner myReader = new Scanner(myObj)) { 
          while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            ArrayList<String> valores = new ArrayList<>(); 

            for(String s: data.split(", ")){valores.add(s);} 
            
            int pos_x = Integer.parseInt(valores.get(0));
            int pos_y = Integer.parseInt(valores.get(1));
            String tipo = valores.get(2); 
            int altura  =Integer.parseInt(valores.get(3));
    
            
            int tipo_entidad = Integer.parseInt(valores.get(4));
            int n_depredadores = Integer.parseInt(valores.get(5));
            int n_reinas = Integer.parseInt(valores.get(6));
            int n_obreros = Integer.parseInt(valores.get(7));
            int n_soldados = Integer.parseInt(valores.get(8));
            int n_scouts = Integer.parseInt(valores.get(9));
            
            
            float p_comida = Float.parseFloat(valores.get(10));
            
            Colonia colonia; 
            Depredadores depredadores; 
            ListaHormigas listahormigas; 
            Reina reina;
            Operator obrera;
            Scout scout;
            Soldier soldado;
            Feromona feromona;
            
            switch(tipo_entidad){ 
                case 1: 
                    int suma = n_reinas +n_obreros +n_soldados +n_scouts;
                    listahormigas = new ListaHormigas();
                    feromona = new Feromona("Origen", Feromona.INTENCIDAD, Feromona.DURACION, "Colonia");
                    reina = new Reina(Reina.MULTIPLICADOR_HIJOS, n_reinas, 100, false, "viva", 100f, false);
                    obrera = new Operator(feromona, n_obreros, 100, 1, "Madera", "viva", 100f, false);
                    scout = new Scout(n_scouts, feromona, "Reposo", 100, 1, "viva", 100f, false);
                    soldado = new Soldier(false, n_soldados, 100f, "Defensa", "viva", 100f, false);
       
                    colonia = new Colonia(suma, 100, listahormigas, false);
                    depredadores = new Depredadores();
                    
                    colonia.getAlmacen_hormiga().agregarHormiga(reina);
                    colonia.getAlmacen_hormiga().agregarHormiga(obrera);
                    colonia.getAlmacen_hormiga().agregarHormiga(scout);
                    colonia.getAlmacen_hormiga().agregarHormiga(soldado);
                    
                    random_idx = random.nextInt(largo_ids);
                    cr = lc.buscarComida( lista_ids[random_idx] );
                    colonia.getAlmacen_comida().agregarComida(cr);
                    
                    break;
                case 2: 
                    colonia = new Colonia();
                    depredadores = new Depredadores(NOMBRE_DEPREDADOR, VELOCIDAD, CONSUMO, REPRODUCCION, n_depredadores);
                    break;
                default:
                    colonia = new Colonia();
                    depredadores = new Depredadores();
                    break;
            }      
            
            Terreno t = new Terreno(tipo, pos_x, pos_y, altura, p_comida, colonia, ambiente );
            if (depredadores.getEspecie() != null){t.setDepredador(depredadores);} 
            terrenos.agregarTerreno(t);
            
          }
          
        } catch (FileNotFoundException e) {System.out.println("Error en el PATH de archivo!");} 
        
             
       
        System.out.println("-------------------------- Informacion Global --------------------------");
        Hormiga.listarInfomacionEspecie();
        System.out.println("Depredador: "+NOMBRE_DEPREDADOR);
        System.out.println(ambiente.toString());
        lc.listarComida();
        
        terrenos.buscarTerreno(2, 0).getColonia().getAlmacen_comida().agregarComida(c4);
        
        System.out.println("-------------------------- Informacion Grilla --------------------------");
        terrenos.listarTerrenos();
        System.out.println("-------------------------- FIN --------------------------");
        
        
        
        
        
        
    }
}
