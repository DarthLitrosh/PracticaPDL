import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseConnector {

    private static final String URL = "jdbc:mysql://localhost:3306/nombreDeTuBaseDeDatos";
    private static final String USER = "tuUsuario";
    private static final String PASSWORD = "tuContraseña";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void agregarUsuario(String nombreUsuario, String fechaNacimiento, String correoElectronico) {
        String sql = "INSERT INTO Usuarios (nombre_usuario, fecha_nacimiento, correo_electronico) VALUES (?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombreUsuario);
            pstmt.setDate(2, java.sql.Date.valueOf(fechaNacimiento));
            pstmt.setString(3, correoElectronico);
            pstmt.executeUpdate();
            System.out.println("Usuario agregado correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void consultarUsuarios() {
        String sql = "SELECT * FROM Usuarios";
        try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("usuario_id") + ", Nombre: " + rs.getString("nombre_usuario") + ", Correo: " + rs.getString("correo_electronico"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DatabaseConnector connector = new DatabaseConnector();
        connector.agregarUsuario("Juan Perez", "1990-01-01", "juan.perez@example.com");
        connector.consultarUsuarios();
    }
}
