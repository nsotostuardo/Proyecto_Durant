package clases_hormiga.Hormigas;

import clases_hormiga.Hormigas.Hormiga;

public class Soldier extends Hormiga{
    private boolean estado_alerta;
    private int cantidad;
    private float energia;
    private String posicion;
    private String tipo = "Soldado";

    public Soldier() {
    }

    public Soldier(boolean estado_alerta, int cantidad, float energia, String posicion, String etapa_vida, float hp, boolean enfermo){
        super(etapa_vida, hp, enfermo);this.estado_alerta = estado_alerta;
        this.cantidad = cantidad;
        this.energia = energia;
        this.posicion = posicion;
    }

    public boolean isEstado_alerta() {
        return estado_alerta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getEnergia() {
        return energia;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setEstado_alerta(boolean estado_alerta) {
        this.estado_alerta = estado_alerta;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setEnergia(float energia) {
        this.energia = energia;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    
    public String getTipo() {
        return "Soldado";
    }
    
    
    
}
