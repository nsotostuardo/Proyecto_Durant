package clases_hormiga.Hormigas;

import clases_hormiga.Hormigas.Hormiga;

public class Scout extends Hormiga{
    
    private String tipo = "Scout";
    private int cantidad;
    private Feromona feromonas;
    private String estado;
    private float energia;
    private int id;

    public Scout() {
    }

    public Scout(int cantidad, Feromona feromonas, String estado, float energia, int id, String etapa_vida, float hp, boolean enfermo){
        super(etapa_vida, hp, enfermo);
        this.cantidad = cantidad;
        this.feromonas = feromonas;
        this.estado = estado;
        this.energia = energia;
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Feromona getFeromonas() {
        return feromonas;
    }

    public String getTipo() {
        return tipo;
    }
    
    public String getEstado() {
        return estado;
    }

    public float getEnergia() {
        return energia;
    }

    public int getId() {
        return id;
    }

    public void setFeromonas(Feromona feromonas) {
        this.feromonas = feromonas;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setEnergia(float energia) {
        this.energia = energia;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    
    
  
}