package clases_hormiga.Miscelaneo;

public class Comida {
    private int cantidad;
    private float calidad;
    private int estado;
    private int id;
    private String nombre;

    public Comida() {
    }

    public Comida(String nombre, int cantidad, float calidad, int estado, int id) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.calidad = calidad;
        this.estado = estado;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public float getCalidad() {
        return calidad;
    }

    public int getEstado() {
        return estado;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setCalidad(float calidad) {
        this.calidad = calidad;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Comida{" + "cantidad=" + cantidad + ", calidad=" + calidad + ", estado=" + estado + ", id=" + id + ", nombre=" + nombre + '}';
    }

    
    
}
