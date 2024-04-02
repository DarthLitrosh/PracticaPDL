import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Usuario {
    private String id;
    private String nombreUsuario;
    private String fechaNacimiento;
    private String email;

    // Constructor por defecto necesario para la deserialización JSON/XML
    public Usuario() {
    }

    // Constructor con parámetros
    public Usuario(String id, String nombreUsuario, String fechaNacimiento, String email) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

