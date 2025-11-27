
package clases_hormiga;

import clases_hormiga.Miscelaneo.*;
import clases_hormiga.Grilla.*;
import clases_hormiga.Hormigas.*;

import java.io.File;                  
import java.io.FileNotFoundException; 
import java.io.*;
import java.net.*;
import java.util.Scanner;             
import java.util.ArrayList;           
import java.util.Random;   
import java.util.Arrays;
import java.util.List;

public class Main implements Constantes{
    private static int maximo = 0;
    private static int depre_muertos, horm_muertas = 0;
    private static ListaTerrenos terrenos = new ListaTerrenos();
    
    public static void main(String[] args){
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
        System.out.println("Servidor Java escuchando en puerto " + port);

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Cliente conectado");

            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String mensaje;

            while ((mensaje = in.readLine()) != null) {
                System.out.println("Recibido: " + mensaje);

                String resultado = procesar(mensaje);
                System.out.println("Enviando: " + resultado);
                out.println(resultado);
            }

            System.out.println("Cliente desconectado");
            clientSocket.close();
            }
        } catch (IOException e) {
            System.out.println("Error en servidor");
            }   
    }
   
   
    private static String procesar(String msg){
        // Protocolo es "COMANDO;arg1;arg2;...;argN"
        String[] partes = msg.split(";");
        String comando = partes[0];
        String[] args = Arrays.copyOfRange(partes, 1, partes.length);
        
        switch(comando){
            case "CONFIG":// tipo de hormiga,  tipo de depre, tipo de clima
                ListaHormigas lista_hormigas_base = CrearListaHormigasBase(args[0]);
                Depredadores depredador_base = CrearDepredador(args[1]);
                Ambiente ambiente_base = CrearAmbiente(args[2]);
                CrearGrilla(lista_hormigas_base, depredador_base, ambiente_base);
                return "OK";
                
            case "TAMANO":
                return maximo+"";
                
            case "TERRENO": //terrenos.buscarTerreno(2, 0)
                return terrenos.buscarTerreno( Integer.parseInt(args[0]),Integer.parseInt(args[1]) ).getTipo() ;
                                
            case "NHORMIDEPREDA":
                String  nHD ="";
                Depredadores depredador = terrenos.buscarTerreno( Integer.parseInt(args[0]),Integer.parseInt(args[1]) ).getDepredador();
                if(depredador == null){
                    nHD = nHD+"0";
                    }else{
                    nHD = nHD+ depredador.getCantidad();
                }
                nHD = nHD+";";
                
                Colonia colonia = terrenos.buscarTerreno(
                        Integer.parseInt(args[0]),
                        Integer.parseInt(args[1])
                        ).getColonia();
               
                if (colonia == null) {
                    return nHD+"0";  
                }

                ArrayList<Hormiga> lista = colonia.getAlmacen_hormiga().getListaHormigas();

                int totalHormigas = 0;

                for (Hormiga h : lista) {
                    totalHormigas += h.getCantidad();
                }
                return nHD + totalHormigas;
                
            case "INFO":
                String respuesta = "";
                int[] valores = calculoStatats();
                respuesta = respuesta + valores[0] +";"+ valores[1] +";" + valores[2]+";";
                respuesta = respuesta + horm_muertas +";"+ valores[3]+"/"+maximo*maximo+";";
                respuesta = respuesta + depre_muertos + ";";
                var puntaje  = valores[0]*( valores[1]* valores[2]/ 2000) * valores[3]/(maximo*maximo)  -200*horm_muertas + 250*depre_muertos;
                int numero = puntaje;
                respuesta = respuesta + numero;
                return respuesta;
                
            case "NUEVODIA":
                Random rnd = new Random();
                for (int col = 0; col < maximo; col++) {
                    for (int row = 0; row < maximo; row++) {
                        colonia = terrenos.buscarTerreno(col, row).getColonia();
                        if (colonia == null) continue;

                        lista = colonia.getAlmacen_hormiga().getListaHormigas();
                        Reina reina = (Reina) lista.get(0);
                        Operator obrero = (Operator) lista.get(1);
                        Scout scout = (Scout) lista.get(2);
                        Soldier soldado = (Soldier) lista.get(3);

                    
                        if (reina.getEnergia() == 100){
                            ActualizarHijos(lista);
                        }
                        // falta el else de comer
                       

                        float prob_moverse = rnd.nextFloat();

                        if (prob_moverse >= 0.85) {
                            int cantidadScouts = scout.getCantidad();
                            if (cantidadScouts == 0) continue; 
                            int[][] esquinas = { {col - 1, row - 1},{col + 1, row - 1},{col - 1, row + 1},{col + 1, row + 1}};

                            for (int[] esquina : esquinas) {
                                int x = esquina[0];
                                int y = esquina[1];

                                if (x < 0 || x >= maximo || y < 0 || y >= maximo)
                                    continue;

                                Colonia colEsquina = terrenos.buscarTerreno(x, y).getColonia();

                                if (colEsquina == null) {
                                    Colonia nueva = new Colonia();

                                    Scout s = (Scout) nueva.getAlmacen_hormiga()
                                            .getListaHormigas().get(2);

                                    s.setCantidad(cantidadScouts);

                                    terrenos.buscarTerreno(x, y).setColonia(nueva);
                                } else {
                                    ArrayList<Hormiga> listaEsquina = colEsquina.getAlmacen_hormiga().getListaHormigas();
                                    Scout scoutEsquina = (Scout) listaEsquina.get(2);
                                    scoutEsquina.setCantidad(scoutEsquina.getCantidad() + cantidadScouts);
                            }
                        }
                        scout.setCantidad(0);
                    }
                }
            }

            return "Nuevo Dia";
            
            default:
                return "El resultado de procesar '" + msg + "' es " + msg.length();
        }
        
    }    
    public static int[] calculoStatats() {
        int territorio = 0;
        int n_reina = 0;
        int n_obrera = 0;
        int n_scout = 0;
        int n_sold = 0;

        int[] arreglo = new int[4];

        for (int col = 0; col < maximo; col++) {
            for (int row = 0; row < maximo; row++) {

                Colonia colonia = terrenos.buscarTerreno(col, row).getColonia();
                if (colonia == null) continue;

                ArrayList<Hormiga> lista = colonia.getAlmacen_hormiga().getListaHormigas();

                if (lista.size() > 1) {
                    n_reina  += lista.get(0).getCantidad();
                    if (lista.get(0).getCantidad()==1) territorio++;
                }
                if (lista.size() > 1) n_obrera += lista.get(1).getCantidad();
                if (lista.size() > 1) n_scout  += lista.get(2).getCantidad();
                if (lista.size() > 1) n_sold   += lista.get(3).getCantidad();
            }
        }

        arreglo[0] = n_reina + n_obrera + n_scout + n_sold; // total
        arreglo[1] = n_reina;
        arreglo[2] = n_obrera;
        arreglo[3] = territorio;

        return arreglo;
    }
                      
    public static Ambiente CrearAmbiente(String tipo){
            Ambiente ambiente_global;
            switch(tipo){
                case "Soleado":
                    ambiente_global = new Ambiente(30.0f,"Soleado", 0.5f,5f);
                    break;
                case "Lluvia":
                    ambiente_global = new Ambiente(15.0f,"Lluvia", 1f,3f);
                    break;
                default: //Helada
                    ambiente_global = new Ambiente(-10.0f,"Helada", 1f, 1f);
                    break;
        }
        return ambiente_global;
    }
    
    public static Depredadores CrearDepredador(String tipo){
            Depredadores depredador;// String Especie, float Velocidad, int Consumo, int reproduccion, int cantidad
            switch(tipo){
                case "Pangolino":
                    depredador = new Depredadores("Pangolino",3.0f, 5, 2,0);
                    break;
                case "Armadillos":
                    depredador = new Depredadores("Armadillos",5.0f, 5, 2,0);
                    break;
                default: //Oso hormigero
                    depredador = new Depredadores("Oso hormigero",3.0f, 10, 2,0);
                    break;
        }
        return depredador;
    }   
    
    public static ListaHormigas CrearListaHormigasBase(String tipo){
        ListaHormigas listahormigas = new ListaHormigas();
        Feromona feromona;
        Reina reina;
        Operator obrera;
        Scout scout;
        Soldier soldado;
        switch(tipo){
            case "Camponotus":
                feromona = new Feromona("Origen", 0.90f, 10f, "Colonia");
                
                reina = new Reina(4, 1, 100, false, "viva", 100f, false);
                reina.setVariablesEspecie(tipo, 0.95f, 0.8f, 0.4f); //String tipo, float agresividad, float consumo, float reproduccion
                
                obrera = new Operator(feromona, 0, 100, 1, "Madera", "viva", 100f, false);
                obrera.setVariablesEspecie(tipo, 0.95f, 0.8f, 0.4f);
                
                scout = new Scout(0, feromona, "Reposo", 100, 1, "viva", 100f, false);
                scout.setVariablesEspecie(tipo, 0.95f, 0.8f, 0.4f);
                
                soldado = new Soldier(false, 0, 100f, "Defensa", "viva", 100f, false);
                soldado.setVariablesEspecie(tipo, 0.95f, 0.8f, 0.4f);
                break;
            case "Hormiga Bala":
                feromona = new Feromona("Origen", 0.90f, 10f, "Colonia");
                
                reina = new Reina(4, 1, 100, false, "viva", 100f, false);
                reina.setVariablesEspecie(tipo, 0.8f, 0.5f, 0.6f); //String tipo, float agresividad, float consumo, float reproduccion
                
                obrera = new Operator(feromona, 0, 100, 1, "Madera", "viva", 100f, false);
                obrera.setVariablesEspecie(tipo, 0.8f, 0.5f, 0.6f);
                
                scout = new Scout(0, feromona, "Reposo", 100, 1, "viva", 100f, false);
                scout.setVariablesEspecie(tipo, 0.8f, 0.5f, 0.6f);
                
                soldado = new Soldier(false, 0, 100f, "Defensa", "viva", 100f, false);
                soldado.setVariablesEspecie(tipo, 0.8f, 0.5f, 0.6f);
                break;
            default: // Hormida de la hoja
                feromona = new Feromona("Origen", 0.80f, 5f, "Colonia");
                
                reina = new Reina(2, 1, 100, false, "viva", 100f, false);
                reina.setVariablesEspecie(tipo, 0.4f, 0.3f, 0.2f);
                
                obrera = new Operator(feromona, 0, 100, 1, "Madera", "viva", 100f, false);
                obrera.setVariablesEspecie(tipo, 0.4f, 0.3f, 0.2f);
                
                scout = new Scout(0, feromona, "Reposo", 100, 1, "viva", 100f, false);
                scout.setVariablesEspecie(tipo, 0.4f, 0.3f, 0.2f);
                
                soldado = new Soldier(false, 0, 100f, "Defensa", "viva", 100f, false);
                soldado.setVariablesEspecie(tipo, 0.4f, 0.3f, 0.2f);
                break;
        }
        
        listahormigas.agregarHormiga(reina);
        listahormigas.agregarHormiga(obrera);
        listahormigas.agregarHormiga(scout);
        listahormigas.agregarHormiga(soldado);
        return listahormigas;
    }
    
    public static void CrearGrilla(ListaHormigas hormigasBase, Depredadores depredador_base, Ambiente ambiente_base){
        File myObj = new File(PATH_TXT); 
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
            
            switch(tipo_entidad){ 
                case 1: 
                    int suma = n_reinas +n_obreros +n_soldados +n_scouts;
                    listahormigas = new ListaHormigas();
                    
                    reina = ((Reina) hormigasBase.getListaHormigas().get(0)).copy();
                    reina.setCantidad(1);
                    
                    obrera = ((Operator) hormigasBase.getListaHormigas().get(1)).copy();
                    obrera.setCantidad(n_obreros);
                    
                    scout = ((Scout) hormigasBase.getListaHormigas().get(2)).copy();
                    scout.setCantidad(n_scouts);
                    
                    soldado = ((Soldier) hormigasBase.getListaHormigas().get(3)).copy();
                    soldado.setCantidad(n_soldados);
       
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
                    depredadores = new Depredadores(depredador_base, n_depredadores);
                    break;
                default:
                    colonia = new Colonia();
                    depredadores = new Depredadores();
                    break;
            }      
            
            Terreno t = new Terreno(tipo, pos_x, pos_y, altura, p_comida, colonia, ambiente_base );
            if (depredadores.getEspecie() != null){t.setDepredador(depredadores);} 
            terrenos.agregarTerreno(t);
            maximo = Math.max(maximo, pos_y);
            
          }
          
        } catch (FileNotFoundException e) {System.out.println("Error en el PATH de archivo!");}
        
        System.out.println("-------------------------- Informacion Global --------------------------");
        Reina h = (Reina) hormigasBase.getListaHormigas().get(0);
        h.listarInfomacionEspecie();
        System.out.println("Depredador: "+depredador_base.getEspecie());
        System.out.println(ambiente_base.toString());
        lc.listarComida();
        
        System.out.println("-------------------------- Informacion Grilla --------------------------");
        terrenos.listarTerrenos();
        System.out.println("-------------------------- FIN --------------------------");
        maximo = maximo +1;
        
     }
     
    public static void ActualizarHijos(ArrayList<Hormiga> lista){
        Reina reina = (Reina) lista.get(0);
        Operator obrero = (Operator) lista.get(1);
        Scout scout = (Scout) lista.get(2);
        Soldier soldado = (Soldier) lista.get(3);

        if (reina.getEnergia() == 100){
            Random random = new Random();
            int multi = (int) reina.getMultiplicador_hijos();

            // Obreras: entre 1 y 8
            int hijos = random.nextInt(8) + 1;
            obrero.setCantidad(obrero.getCantidad() + multi * hijos);

            // Scouts: entre 1 y 6
            hijos = random.nextInt(6) + 1;
            scout.setCantidad(scout.getCantidad() + multi * hijos);

            // Soldados: entre 1 y 4
            hijos = random.nextInt(4) + 1;
            soldado.setCantidad(soldado.getCantidad() + multi * hijos);
        }
    }



}
