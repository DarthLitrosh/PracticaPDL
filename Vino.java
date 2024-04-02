import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Vino {
    private String id;
    private String nombre;
    private String bodega;
    private int año;
    private String tipo;
    private String[] uvas;
    private double puntuacion;

    // Constructor por defecto necesario para la deserialización JSON/XML
    public Vino() {
    }

    // Constructor con parámetros para inicialización fácil de objetos
    public Vino(String id, String nombre, String bodega, int año, String tipo, String[] uvas, double puntuacion) {
        this.id = id;
        this.nombre = nombre;
        this.bodega = bodega;
        this.año = año;
        this.tipo = tipo;
        this.uvas = uvas;
        this.puntuacion = puntuacion;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getBodega() {
        return bodega;
    }

    public int getAño() {
        return año;
    }

    public String getTipo() {
        return tipo;
    }

    public String[] getUvas() {
        return uvas;
    }

    public double getPuntuacion() {
        return puntuacion;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setUvas(String[] uvas) {
        this.uvas = uvas;
    }

    public void setPuntuacion(double puntuacion) {
        this.puntuacion = puntuacion;
    }
}
