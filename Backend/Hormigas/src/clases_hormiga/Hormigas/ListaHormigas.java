/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases_hormiga.Hormigas;

import clases_hormiga.Hormigas.Hormiga;
import java.util.ArrayList;

public class ListaHormigas {
    
    private ArrayList<Hormiga> listaHormigas;

    public ListaHormigas() {
        listaHormigas = new ArrayList<Hormiga>();
    }

    public ArrayList<Hormiga> getListaHormigas() {
        return listaHormigas;
    }

    public void setListaHormigas(ArrayList<Hormiga> listaHormigas) {
        this.listaHormigas = listaHormigas;
    }
    
    public void agregarHormiga(Hormiga h){
        this.listaHormigas.add(h);
    }
    
    public void buscarHormiga(String tipo){
        for(Hormiga h: listaHormigas){
            return;
        }
    }

    public void listarHormigas(){
        String texto = "        Hormigas: ";
        if(listaHormigas == null){System.out.println(texto+"[]");}
        else{
            texto = texto + "[";
            for (Hormiga h: listaHormigas){
                texto = texto + h.getTipo() +":"+ h.getCantidad()+ ", ";
            }
            if (texto.isEmpty()){texto= texto+"";}
            else{
                texto = texto.substring(0, texto.length() - 2);
            }  
                
            
            
            
            System.out.println(texto + "]");
        }
    }

 
}
