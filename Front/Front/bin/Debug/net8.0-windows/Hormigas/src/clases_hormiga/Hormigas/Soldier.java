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

    @Override
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

    public void setTIPO(String TIPO) {
        this.TIPO = TIPO;
    }

    public void setAGRESIVIDAD(float AGRESIVIDAD) {
        this.AGRESIVIDAD = AGRESIVIDAD;
    }

    public void setCONSUMO(float CONSUMO) {
        this.CONSUMO = CONSUMO;
    }

    public void setREPRODUCCION(float REPRODUCCION) {
        this.REPRODUCCION = REPRODUCCION;
    }
 
    public void setVariablesEspecie(String tipo, float agresividad, float consumo, float reproduccion){
        setTIPO(tipo);
        setAGRESIVIDAD(agresividad);
        setCONSUMO(consumo);
        setREPRODUCCION(reproduccion);
    }
    
    public Soldier copy() {
        Soldier copia = new Soldier(this.estado_alerta, this.cantidad, this.energia, this.posicion, this.etapa_vida, this.hp, this.enfermo);
        copia.setTIPO(this.TIPO);
        copia.setAGRESIVIDAD(this.AGRESIVIDAD);
        copia.setCONSUMO(this.CONSUMO);
        copia.setREPRODUCCION(this.REPRODUCCION);
        return copia;
    }

}
