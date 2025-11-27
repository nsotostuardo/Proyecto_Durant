package clases_hormiga.Grilla;

public class Ambiente {
    private float temperatura;
    private String clima;
    private float humedad;
    private float uv;

    public Ambiente() { 
    }

    public Ambiente(float temperatura, String clima, float humedad, float uv) {
        this.temperatura = temperatura;
        this.clima = clima; 
        this.humedad = humedad;
        this.uv = uv;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public String getClima() {
        return clima;
    }

    public float getHumedad() {
        return humedad;
    }

    public float getUv() {
        return uv;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public void setHumedad(float humedad) {
        this.humedad = humedad;
    }

    public void setUv(float uv) {
        this.uv = uv;
    }

    @Override
    public String toString() {
        return "Ambiente en la grilla: " + "clima=" + clima + ", T=" + temperatura + ", humedad=" + humedad + ", uv=" + uv ;
    }
    
   
    
    
}   
