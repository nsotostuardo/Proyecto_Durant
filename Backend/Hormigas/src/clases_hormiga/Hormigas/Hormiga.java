package clases_hormiga.Hormigas;

import clases_hormiga.Hormigas.Especie;

public abstract class Hormiga extends ConstantesRaza implements Especie{
    protected String etapa_vida;
    protected float hp;
    protected boolean enfermo;

    public Hormiga() {
    }

    public Hormiga(String etapa_vida, float hp, boolean enfermo) {
        this.etapa_vida = etapa_vida;
        this.hp = hp;
        this.enfermo = enfermo;
    }

    public String getEtapa_vida() {
        return etapa_vida;
    }

    public float getHp() {
        return hp;
    }

    public boolean isEnfermo() {
        return enfermo;
    }

    public void setEtapa_vida(String etapa_vida) {
        this.etapa_vida = etapa_vida;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public void setEnfermo(boolean enfermo) {
        this.enfermo = enfermo;
    }

    public String getTIPO() {
        return TIPO;
    }

    public float getAGRESIVIDAD() {
        return AGRESIVIDAD;
    }

    public float getCONSUMO() {
        return CONSUMO;
    }

    public float getREPRODUCCION() {
        return REPRODUCCION;
    }
   
    
    public void listarInfomacionEspecie(){
        System.out.println("Especie="+ getTIPO()+", agresividad="+ getAGRESIVIDAD()+", consumo="+ getCONSUMO() + " taza reproduccion="+getREPRODUCCION());
    }
    
}
