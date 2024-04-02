import java.time.LocalDate;
import java.time.Period;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/usuarios")
public class UsuarioResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crearUsuario(Usuario usuario) {
        LocalDate fechaNacimiento = LocalDate.parse(usuario.getFechaNacimiento());
        LocalDate ahora = LocalDate.now();
        if (Period.between(fechaNacimiento, ahora).getYears() < 18) {
            return Response.status(Response.Status.BAD_REQUEST)
                           .entity("{\"error\":\"El usuario debe ser mayor de 18 años.\"}")
                           .build();
        }


        return Response.ok().entity("Usuario creado con éxito").build();  
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerUsuario(@PathParam("id") String id) {
        //lógica para obtener usuario
        Usuario usuario = new Usuario(); // Supongamos que esto viene de la base de datos
        return Response.ok().entity(usuario).build(); // Devolvemos el usuario creado
    }

}
      
