package clases_hormiga.Hormigas;

import clases_hormiga.Hormigas.Hormiga;


public class Reina extends Hormiga{
    private float multiplicador_hijos; 
    private int cantidad;
    private float energia;
    private boolean estado_fecundacion;
    private String tipo = "Reina";

    public Reina() { 
    }

    public Reina(float multiplicador_hijos, int cantidad, float energia, boolean estado_fecundacion, String etapa_vida, float hp, boolean enfermo){
        super(etapa_vida, hp, enfermo); 
        this.multiplicador_hijos = multiplicador_hijos;
        this.cantidad = cantidad;
        this.energia = energia;
        this.estado_fecundacion = estado_fecundacion;
    }

    public float getMultiplicador_hijos() {
        return multiplicador_hijos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getEnergia() {
        return energia;
    }

    public boolean isEstado_fecundacion() {
        return estado_fecundacion;
    }

 
    public void setMultiplicador_hijos(float multiplicador_hijos) {
        this.multiplicador_hijos = multiplicador_hijos;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setEnergia(float energia) {
        this.energia = energia;
    }

    public void setEstado_fecundacion(boolean estado_fecundacion) {
        this.estado_fecundacion = estado_fecundacion;
    }    
    
    public String getTipo() {
        return "Reina";
    } 
    
}
