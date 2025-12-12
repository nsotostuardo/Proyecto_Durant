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

    @Override
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
        if (cantidad < 0) {
            this.cantidad = 0;
        } else {
            this.cantidad = cantidad;
        }
    }

    public void setEnergia(float energia) {
        if (energia <= 0) {
            this.energia = 0f;
        } else if (energia >= 100) {
            this.energia = 100f;
        } else {
            this.energia = energia;
        }
    }

    public void setEstado_fecundacion(boolean estado_fecundacion) {
        this.estado_fecundacion = estado_fecundacion;
    }    
    
    public String getTipo() {
        return "Reina";
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
    
    public Reina copy() {
    Reina r = new Reina();

    r.etapa_vida = this.etapa_vida;
    r.hp = this.hp;
    r.enfermo = this.enfermo;
    r.TIPO = this.TIPO;
    r.AGRESIVIDAD = this.AGRESIVIDAD;
    r.CONSUMO = this.CONSUMO;
    r.REPRODUCCION = this.REPRODUCCION;
    r.multiplicador_hijos = this.multiplicador_hijos;
    r.cantidad = this.cantidad;
    r.energia = this.energia;
    r.estado_fecundacion = this.estado_fecundacion;
    r.tipo = this.tipo;
    return r;
}
    
}
