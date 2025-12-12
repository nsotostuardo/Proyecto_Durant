package clases_hormiga.Miscelaneo;
import clases_hormiga.Miscelaneo.Comida;
import java.util.ArrayList;


public class ListaComidas {
    private ArrayList<Comida> listaComida;
    
    
    public ListaComidas(){
        this.listaComida = new ArrayList<Comida>();
    }

    public ArrayList<Comida> getListaComida() {
        return listaComida;
    }

    public void setListaComida(ArrayList<Comida> listaComida) {
        this.listaComida = listaComida;
    }
   
    public void agregarComida(Comida c){
        listaComida.add(c);
    }
    
    public Comida buscarComida(int id){
        for(Comida c: listaComida){
            if(c.getId() == id){
                return c;
            }
        }
        return new Comida();}
    
    public void eliminarComida(int id){
        Comida c = buscarComida(id);
        if(c.getId() == id){
            listaComida.remove(c);
        }
    }
    
    public Comida getPrimeraComida() {
        if (listaComida.isEmpty())
            return null;  
        return listaComida.get(0);
    }
    
    public void listarComida(){
        System.out.print("        Comidas: [");
        String texto = "";
        for(Comida c: listaComida){
            texto = texto + c.getNombre() +", ";
        }
        if (texto.isEmpty()){
            System.out.print("]\n");
        }else{
            texto = texto.substring(0, texto.length() - 2);
            System.out.print(texto+"]\n");
        }
    }
    //System.out.print( c.getNombre() +", ");
    
}
