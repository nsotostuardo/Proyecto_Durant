package clases_hormiga.Miscelaneo;

public class Depredadores {
    private String Especie;
    private float Velocidad;
    private int cantidad;
    private int Consumo;
    private int reproduccion; //que es reproducción?
    
    public Depredadores(String Especie, float Velocidad, int Consumo, int reproduccion, int cantidad){
        this.Especie = Especie;
        this.Velocidad = Velocidad;
        this.Consumo = Consumo;
        this.reproduccion = reproduccion;
        this.cantidad = cantidad;
    }
    public Depredadores(){
    }

    public int getCantidad() {
        return cantidad;
    }
    
    public String getEspecie(){
        return this.Especie;
    }
    public float getVelocidad(){
        return this.Velocidad;
    }

    public int getConsumo() {
        return Consumo;
    }

    public int getReproduccion() {
        return reproduccion;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    public void setEspecie(String especie){
        this.Especie = especie;
    }

    public void setVelocidad(float Velocidad) {
        this.Velocidad = Velocidad;
    }

    public void setConsumo(int Consumo) {
        this.Consumo = Consumo;
    }

    public void setReproduccion(int reproduccion) {
        this.reproduccion = reproduccion;
    }

    @Override
    public String toString() {
        return "        Depredadores{" + "Especie=" + Especie + ", cantidad=" + cantidad + ", Velocidad=" + Velocidad +  ", Consumo=" + Consumo + ", reproduccion=" + reproduccion + '}';
    } 
    
    
    
    
}
