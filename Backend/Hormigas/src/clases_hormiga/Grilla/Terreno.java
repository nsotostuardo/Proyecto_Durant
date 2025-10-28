package clases_hormiga.Grilla;

import clases_hormiga.Miscelaneo.Depredadores;
import clases_hormiga.Grilla.Colonia;
import clases_hormiga.Grilla.Ambiente;

public class Terreno {
    private String tipo;
    private int[] posicion = new int[2];
    private int altura;
    private float porcentaje_alimento;
    private Colonia colonia;
    private Ambiente ambiente;
    private Depredadores depredador = null;

    public Terreno() {
    }

    public Terreno(String tipo, int posicion_x, int posicion_y, int altura, float porcentaje_alimento, Colonia colonia, Ambiente ambiente) {
        this.tipo = tipo;
        this.posicion[0] = posicion_x;
        this.posicion[1] = posicion_y;
        this.altura = altura;
        this.porcentaje_alimento = porcentaje_alimento;
        this.colonia = colonia;
        this.ambiente = ambiente;
    }

    public Depredadores getDepredador() {
        return depredador;
    }

    
    public String getTipo() {
        return tipo;
    }

    public int getPosicionX() {
        return posicion[0];
    }
    
    public int getPosicionY() {
        return posicion[1];
    }

    public int getAltura() {
        return altura;
    }

    public float getPorcentaje_alimento() {
        return porcentaje_alimento;
    }

    public Colonia getColonia() {
        return colonia;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPosicion(int posicion_x, int posicion_y) {
        this.posicion[0] = posicion_x;
        this.posicion[1] = posicion_y;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void setPorcentaje_alimento(float porcentaje_alimento) {
        this.porcentaje_alimento = porcentaje_alimento;
    }

    public void setColonia(Colonia colonia) {
        this.colonia = colonia;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public void setDepredador(Depredadores depredador) {
        this.depredador = depredador;
    }

    
    
    @Override
    public String toString() {
        
        if(this.depredador == null){
            return "Terreno{" + "tipo=" + tipo + ", posicion=(" + posicion[0] + ","+posicion[1]+"), altura=" + altura + ", porcentaje_alimento=" + porcentaje_alimento +  '}';}
        else{
            String texto = "Terreno{" + "tipo=" + tipo + ", posicion=(" + posicion[0] + ","+posicion[1]+"), altura=" + altura + ", porcentaje_alimento=" + porcentaje_alimento +  '}';
            return texto + "\n" + this.depredador.toString();
        }
    }
    
    
    
    
    
    
    
    
    
    
    
}
