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

    @Override
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
        if (cantidad < 0) {
            this.cantidad = 0;
        } else {
            this.cantidad = cantidad;
        }
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

    public Scout copy() {
    Feromona nuevaF = this.feromonas;
    Scout copia = new Scout( this.cantidad, nuevaF, this.estado, this.energia, this.id, this.etapa_vida, this.hp, this.enfermo);
    copia.setTIPO(this.TIPO);
    copia.setAGRESIVIDAD(this.AGRESIVIDAD);
    copia.setCONSUMO(this.CONSUMO);
    copia.setREPRODUCCION(this.REPRODUCCION);

    return copia;
}

    
  
}