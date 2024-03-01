import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/usuarios")
public class UsuarioResource {
    @POST
    public Response crearUsuario(Usuario usuario) {
        // Aquí va la lógica para crear un usuario
    }

    @GET
    @Path("/{usuarioId}")
    public Usuario leerUsuario(@PathParam("usuarioId") int usuarioId) {
        // Aquí va la lógica para obtener los datos de un usuario
    }

    @PUT
    @Path("/{usuarioId}")
    public Response actualizarUsuario(@PathParam("usuarioId") int usuarioId, Usuario usuario) {
        // Aquí va la lógica para actualizar los datos de un usuario
    }
    @DELETE
    @Path("/{usuarioId}")
    public Response borrarUsuario(@PathParam("usuarioId") int usuarioId) {
        // Aquí va la lógica para borrar un usuario
    }

    @GET
    public List<Usuario> listarUsuarios(@QueryParam("nombre") String nombre) {
        // Aquí va la lógica para listar todos los usuarios
    }

    @POST
    @Path("/{usuarioId}/vinos")
    public Response agregarVino(@PathParam("usuarioId") int usuarioId, Vino vino) {
        // Aquí va la lógica para agregar un vino a la lista de un usuario
    }
    @DELETE
    @Path("/{usuarioId}/vinos/{vinoId}")
    public Response eliminarVino(@PathParam("usuarioId") int usuarioId, @PathParam("vinoId") int vinoId) {
        // Aquí va la lógica para eliminar un vino de la lista de un usuario
    }

    @PUT
    @Path("/{usuarioId}/vinos/{vinoId}")
    public Response modificarPuntuacionVino(@PathParam("usuarioId") int usuarioId, @PathParam("vinoId") int vinoId, @QueryParam("puntuacion") int puntuacion) {
        // Aquí va la lógica para modificar la puntuación de un vino
    }

    @GET
    @Path("/{usuarioId}/vinos")
    public List<Vino> listarVinosUsuario(@PathParam("usuarioId") int usuarioId) {
        // Aquí va la lógica para listar todos los vinos de un usuario
    }
    @POST
    @Path("/{usuarioId}/seguidores")
    public Response agregarSeguidor(@PathParam("usuarioId") int usuarioId, @QueryParam("seguidorId") int seguidorId) {
        // Aquí va la lógica para agregar un seguidor a un usuario
    }

    @DELETE
    @Path("/{usuarioId}/seguidores/{seguidorId}")
    public Response eliminarSeguidor(@PathParam("usuarioId") int usuarioId, @PathParam("seguidorId") int seguidorId) {
        // Aquí va la lógica para eliminar un seguidor de un usuario
    }

    @GET
    @Path("/{usuarioId}/seguidores")
    public List<Usuario> listarSeguidores(@PathParam("usuarioId") int usuarioId) {
        // Aquí va la lógica para listar todos los seguidores de un usuario
    }
}

