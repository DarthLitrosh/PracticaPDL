import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
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


    

@Path("/usuarios")
public class UsuarioResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarUsuarios(@QueryParam("nombre") String nombre,
                                   @DefaultValue("0") @QueryParam("offset") int offset,
                                   @DefaultValue("10") @QueryParam("limit") int limit) {
        // Implementar lógica para filtrar usuarios por nombre y paginar resultados
        List<Usuario> usuariosFiltrados = new ArrayList<>();
        // Aquí se debería agregar la lógica para filtrar y paginar los usuarios desde tu base de datos
        
        // Devuelve la lista de usuarios filtrados y paginados
        return Response.ok(usuariosFiltrados).build();
    }

    // Otros métodos para manejar usuarios (añadir, obtener por ID, actualizar, eliminar, etc.)
}


    
} //de la clase
      
