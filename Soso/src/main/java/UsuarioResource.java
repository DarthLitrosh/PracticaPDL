package Soso.src.main.java;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuarios")
public class UsuarioResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response crearUsuario(Usuario usuario) {
        // Aquí iría la lógica para añadir el usuario a la base de datos
        return Response.ok(usuario).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerUsuario(@PathParam("id") int id) {
        // Aquí iría la lógica para obtener el usuario de la base de datos
        Usuario usuario = new Usuario(id, "Nombre Ejemplo", "1980-01-01", "email@example.com");
        return Response.ok(usuario).build();
    }

}
