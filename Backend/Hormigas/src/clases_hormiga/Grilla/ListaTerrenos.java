/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases_hormiga.Grilla;
import java.util.ArrayList;

public class ListaTerrenos {
    private ArrayList<Terreno> listaTerrenos;

    public ListaTerrenos() {
        this.listaTerrenos = new ArrayList<Terreno>();
    }

    public ListaTerrenos(ArrayList<Terreno> listaTerrenos) {
        this.listaTerrenos = listaTerrenos;
    }

    public ArrayList<Terreno> getListaTerrenos() {
        return listaTerrenos;
    }

    public void setListaTerrenos(ArrayList<Terreno> listaTerrenos) {
        this.listaTerrenos = listaTerrenos;
    }
    
    public void agregarTerreno(Terreno t){
        this.listaTerrenos.add(t);
    }
    
    public Terreno buscarTerreno(int pos_x, int pos_y){
        for(Terreno t: listaTerrenos){
            if(t.getPosicionX() == pos_x && t.getPosicionY() == pos_y){
            return t;
        }
        }
        return new Terreno();
    }
    
    
    public void listarTerrenos(){
        for(Terreno t: listaTerrenos){
            System.out.println(t.toString());
            System.out.println(t.getColonia().toString());
            t.getColonia().getAlmacen_comida().listarComida();
            t.getColonia().getAlmacen_hormiga().listarHormigas();
        }
    }
    
   
    
    
    
    
}
