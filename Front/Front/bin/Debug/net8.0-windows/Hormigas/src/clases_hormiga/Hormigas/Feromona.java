package clases_hormiga.Hormigas;

import clases_hormiga.Hormigas.Especie;

public class Feromona implements Especie{
    private String camino;
    private float intencidad;
    private float tiempo_desgaste;
    private String origen;

    public Feromona() {
    }

    public Feromona(String camino, float intencidad, float tiempo_desgaste, String origen) {
        this.camino = camino;
        this.intencidad = intencidad;
        this.tiempo_desgaste = tiempo_desgaste;
        this.origen = origen;
    }

    public String getCamino() {
        return camino;
    }

    public float getIntencidad() {
        return intencidad;
    }

    public float getTiempo_desgaste() {
        return tiempo_desgaste;
    }

    public String getOrigen() {
        return origen;
    }

    public void setCamino(String camino) {
        this.camino = camino;
    }

    public void setIntencidad(float intencidad) {
        this.intencidad = intencidad;
    }


    public void setTiempo_desgaste(float tiempo_desgaste) {
        this.tiempo_desgaste = tiempo_desgaste;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    
    public String getTipo() {
        return null;
    }

    
    public int getCantidad() {
        return 0;
    }
    
    
    
    
}
