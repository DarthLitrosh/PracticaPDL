import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuarios")
public class UsuarioResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearUsuario(Usuario usuario) {
        // Implementar lógica para añadir usuario
        return Response.ok().entity("Usuario creado con éxito").build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerUsuario(@PathParam("id") String id) {
        // Implementar lógica para obtener usuario
        Usuario usuario = new Usuario(); // Supongamos que esto viene de tu base de datos
        return Response.ok().entity(usuario).build();
    }
}
