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

    // Constructor, getters y setters
}
