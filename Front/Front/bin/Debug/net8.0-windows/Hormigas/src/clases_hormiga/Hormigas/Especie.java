/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package clases_hormiga.Hormigas;

public interface Especie {
   
    //REINA
    int MULTIPLICADOR_HIJOS = 12;
    
    //FEROMONAS
    float INTENCIDAD = 0.80f; 
    float DURACION = 5f; 
    
    public String getTipo();
    public int getCantidad();
}
