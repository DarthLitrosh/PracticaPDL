@Path("/usuarios/{usuarioId}/seguidores")
public class SeguidoresResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response añadirSeguidor(@PathParam("usuarioId") String usuarioId, String seguidorId) {
        // Lógica para añadir un seguidor
        return Response.status(Response.Status.CREATED).build();
    }

    @DELETE
    @Path("/{seguidorId}")
    public Response eliminarSeguidor(@PathParam("usuarioId") String usuarioId, @PathParam("seguidorId") String seguidorId) {
        // Lógica para eliminar un seguidor
        return Response.ok().build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarSeguidores(@PathParam("usuarioId") String usuarioId) {
        // Lógica para listar seguidores
        List<String> seguidores = null; // Suponer la obtención de la lista
        return Response.ok(seguidores).build();
    }
}
