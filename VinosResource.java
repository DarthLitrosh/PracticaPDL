import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/usuarios/{usuarioId}/vinos")
public class VinosResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response añadirVino(@PathParam("usuarioId") String usuarioId, Vino vino) {
        // Lógica para añadir el vino al usuario especificado
        return Response.status(Response.Status.CREATED).entity(vino).build();
    }

    @DELETE
    @Path("/{vinoId}")
    public Response eliminarVino(@PathParam("usuarioId") String usuarioId, @PathParam("vinoId") String vinoId) {
        // Lógica para eliminar el vino del usuario
        return Response.ok().build();
    }

    @PUT
    @Path("/{vinoId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modificarVino(@PathParam("usuarioId") String usuarioId, @PathParam("vinoId") String vinoId, Vino vino) {
        // Lógica para actualizar la información del vino
        return Response.ok(vino).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarVinos(@PathParam("usuarioId") String usuarioId,
                                @QueryParam("filtro") String filtro) {
        // Lógica para obtener y filtrar la lista de vinos del usuario
        List<Vino> vinos = null; // Suponer la obtención de la lista
        return Response.ok(vinos).build();
    }
}
