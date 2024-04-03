package Soso.src.main.java;
import java.util.List;

public class Vino {
    private int id;
    private String nombre;
    private String bodega;
    private int anio;
    private String origen;
    private String tipoVino;
    private List<String> tiposUva;
    private float puntuacion;

    // Constructor
    public Vino(int id, String nombre, String bodega, int anio, String origen, String tipoVino, List<String> tiposUva, float puntuacion) {
        this.id = id;
        this.nombre = nombre;
        this.bodega = bodega;
        this.anio = anio;
        this.origen = origen;
        this.tipoVino = tipoVino;
        this.tiposUva = tiposUva;
        this.puntuacion = puntuacion;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getBodega() {
        return bodega;
    }

    public int getAnio() {
        return anio;
    }

    public String getOrigen() {
        return origen;
    }

    public String getTipoVino() {
        return tipoVino;
    }

    public List<String> getTiposUva() {
        return tiposUva;
    }

    public float getPuntuacion() {
        return puntuacion;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public void setTipoVino(String tipoVino) {
        this.tipoVino = tipoVino;
    }

    public void setTiposUva(List<String> tiposUva) {
        this.tiposUva = tiposUva;
    }

    public void setPuntuacion(float puntuacion) {
        this.puntuacion = puntuacion;
    }
}
