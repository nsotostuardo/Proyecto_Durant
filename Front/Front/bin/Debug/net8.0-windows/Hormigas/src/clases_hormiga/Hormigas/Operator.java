/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clases_hormiga.Hormigas;

import clases_hormiga.Hormigas.Hormiga;

public class Operator extends Hormiga{
    
    private Feromona feromonas;
    private int cantidad;
    private float energia;
    private int id;
    private String material;
    private String tipo = "Obrera";

    public Operator(Feromona feromonas, int cantidad, float energia, int id, String material, String etapa_vida, float hp, boolean enfermo){
        super(etapa_vida, hp, enfermo);
        this.feromonas = feromonas;
        this.cantidad = cantidad;
        this.energia = energia;
        this.id = id;
        this.material = material;
    }

    public Operator() {
    }
    
    
    public Feromona getFeromonas() {
        return feromonas;
    }

    public void setFeromonas(Feromona feromonas) {
        this.feromonas = feromonas;
    }

    @Override
    public int getCantidad(){
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getEnergia() {
        return energia;
    }

    public void setEnergia(float energia) {
        this.energia = energia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    
    public String getTipo() {
        return "Obrera";
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
    public Operator copy() {
    Feromona nuevaF = this.feromonas;

    Operator copia = new Operator(nuevaF, this.cantidad, this.energia, this.id, this.material, this.etapa_vida, this.hp, this.enfermo);

    copia.setTIPO(this.TIPO);
    copia.setAGRESIVIDAD(this.AGRESIVIDAD);
    copia.setCONSUMO(this.CONSUMO);
    copia.setREPRODUCCION(this.REPRODUCCION);

    return copia;
}
}

