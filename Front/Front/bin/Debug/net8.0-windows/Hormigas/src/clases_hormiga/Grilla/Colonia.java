package clases_hormiga.Grilla;

import clases_hormiga.Hormigas.ListaHormigas;
import clases_hormiga.Hormigas.ListaHormigas;
import clases_hormiga.Miscelaneo.ListaComidas;
import clases_hormiga.Miscelaneo.ListaComidas;

public class Colonia {
    private float tamano;
    private float durabilidad;
    private ListaHormigas almacen_hormiga;
    private ListaComidas almacen_comida;
    private boolean oculto;

    public Colonia(float tamano, float durabilidad, ListaHormigas almacen_hormiga, boolean oculto) {
        this.tamano = tamano; 
        this.durabilidad = durabilidad;
        this.almacen_hormiga = new ListaHormigas();
        this.almacen_comida = new ListaComidas();
        this.oculto = oculto;
    }

    public Colonia() { 
        this.almacen_comida = new ListaComidas();
        this.almacen_hormiga = new ListaHormigas();
        this.almacen_hormiga.inicializarHormigasBase();
    }

    public float getTamano() {
        return tamano; 
    }

    public float getDurabilidad() {
        return durabilidad;
    }

    public ListaHormigas getAlmacen_hormiga() {
        return almacen_hormiga;
    }

    public ListaComidas getAlmacen_comida() {
        return almacen_comida;
    }

    public boolean isOculto() {
        return oculto;
    }

    public void setTamano(float tamano) { 
        this.tamano = tamano;
    }

    public void setDurabilidad(float durabilidad) {
        this.durabilidad = durabilidad;
    }

    public void setAlmacen_hormiga(ListaHormigas almacen_hormiga) {
        this.almacen_hormiga = almacen_hormiga;
    }

    public void setAlmacen_comida(ListaComidas almacen_comida) {
        this.almacen_comida = almacen_comida;
    }

    public void setOculto(boolean oculto) {
        this.oculto = oculto;
    }

    @Override
    public String toString() {
        return "        Colonia{" + "tamano=" + tamano + ", durabilidad=" + durabilidad + ", oculto=" + oculto + '}';
    } 
    
    
  
  
  
}
