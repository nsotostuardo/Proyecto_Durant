package clases_hormiga.Hormigas;

import clases_hormiga.Hormigas.Especie;

public abstract class Hormiga implements Especie{
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
   
    
    public static void listarInfomacionEspecie(){
        System.out.println("Especie="+ TIPO+", agresividad="+ AGRESIVIDAD+", consumo="+ CONSUMO + " taza reproduccion="+REPRODUCCION);
    }
    
}
